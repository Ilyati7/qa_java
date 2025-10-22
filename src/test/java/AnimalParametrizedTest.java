import com.example.Animal;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class AnimalParametrizedTest {
    private Animal animal;

    // Правило для проверки исключений
    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    // Параметризация тестовых данных
    @Parameters(name = "Тестирование для: {0} (питание: {1})")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"Травоядное", List.of("Трава", "Различные растения"), null},
                {"Хищник", List.of("Животные", "Птицы", "Рыба"), null},
                {"Неизвестный тип", null, "Неизвестный вид животного, используйте значение Травоядное или Хищник"}
        });
    }

    private final String animalKind;
    private final List<String> expectedResult;
    private final String expectedErrorMessage;

    public AnimalParametrizedTest(String animalKind, List<String> expectedResult, String expectedErrorMessage) {
        this.animalKind = animalKind;
        this.expectedResult = expectedResult;
        this.expectedErrorMessage = expectedErrorMessage;
    }

    @Before
    public void setUp() {
        animal = new Animal();
    }

    @Test
    public void testGetFood() throws Exception {
        if (expectedResult != null) {
            // Проверяем корректные значения
            List<String> result = animal.getFood(animalKind);
            assertEquals("Списки должны совпадать", expectedResult, result);
        } else {
            // Проверяем исключение
            exceptionRule.expect(Exception.class);
            exceptionRule.expectMessage(expectedErrorMessage);
            animal.getFood(animalKind);
        }
    }
}
