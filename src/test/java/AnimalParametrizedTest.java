import com.example.Animal;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.rules.ExpectedException;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class AnimalParametrizedTest {
    private Animal animal;

    // Объявляем правило как @Rule
    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    @Parameterized.Parameters(name = "Тестирование для: {0} (питание: {1})")
    public static Object[][] data() {
        return new Object[][] {
                {"Травоядное", List.of("Трава", "Различные растения")},
                {"Хищник", List.of("Животные", "Птицы", "Рыба")}
        };
    }

    private final String animalKind;
    private final List<String> expectedResult;

    public AnimalParametrizedTest(String animalKind, List<String> expectedResult) {
        this.animalKind = animalKind;
        this.expectedResult = expectedResult;
    }

    @Before
    public void setUp() {
        animal = new Animal();
    }

    @Test
    public void shouldReturnCorrectFoodList() throws Exception {
        List<String> result = animal.getFood(animalKind);
        assertEquals("Списки должны совпадать", expectedResult, result);
    }
    @Test
    public void shouldThrowExceptionForInvalidType() throws Exception {
        exceptionRule.expect(Exception.class);
        exceptionRule.expectMessage("Неизвестный вид животного, используйте значение Травоядное или Хищник");

        animal.getFood("Неизвестный тип");
    }

}