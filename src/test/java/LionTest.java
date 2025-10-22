

import com.example.Feline;
import com.example.Lion;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.List;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {
    @Mock
    private Feline feline;

    private Lion lion;

    @Before
    public void setUp() throws Exception {
        // Создаем экземпляр Lion с моком Feline
        lion = new Lion("Самец", feline);
    }

    // Изменим конструктор Lion для передачи Feline
    public LionTest() {
        // Конструктор без параметров для работы с Mockito
    }

    @Test
    public void testConstructorMale() throws Exception {
        Lion lion = new Lion("Самец", feline);
        assertTrue(lion.doesHaveMane());
    }

    @Test
    public void testConstructorFemale() throws Exception {
        Lion lion = new Lion("Самка", feline);
        assertFalse(lion.doesHaveMane());
    }

    @Test(expected = Exception.class)
    public void testConstructorInvalidSex() throws Exception {
        new Lion("Неизвестный пол", feline);
    }

    @Test
    public void testGetKittens() {
        // Настраиваем мок для метода getKittens
        when(feline.getKittens()).thenReturn(1);
        assertEquals(1, lion.getKittens());
    }

    @Test
    public void testGetFood() throws Exception {
        // Настраиваем мок для метода getFood
        when(feline.getFood("Хищник"))
                .thenReturn(List.of("Животные", "Птицы", "Рыба"));

        List<String> result = lion.getFood();
        assertEquals(List.of("Животные", "Птицы", "Рыба"), result);
    }
}
