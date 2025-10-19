import com.example.Feline;
import com.example.Lion;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.List;
import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {
    @Mock
    private Feline felineMock;


    private Lion lion;

    @Before
    public void setUp() throws Exception {

        lion = new Lion("Самец");
    }

    @Test
    public void testConstructorMale() throws Exception {
        Lion lion = new Lion("Самец");
        assertTrue(lion.doesHaveMane());
    }

    @Test
    public void testConstructorFemale() throws Exception {
        Lion lion = new Lion("Самка");
        assertFalse(lion.doesHaveMane());
    }

    @Test(expected = Exception.class)
    public void testConstructorInvalidSex() throws Exception {
        new Lion("Неизвестный пол");
    }

    @Test
    public void testGetKittens() {
        assertEquals(1, lion.getKittens());
    }

    @Test
    public void testGetFood() throws Exception {
        List<String> result = lion.getFood();
        assertEquals(List.of("Животные", "Птицы", "Рыба"), result);
    }
}
