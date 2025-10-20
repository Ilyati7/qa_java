import com.example.Animal;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class AnimalTest {
    private Animal animal;


    @Before
    public void setUp() {
        animal = new Animal();
    }

    @Test
    public void shouldReturnCorrectFamilyList() {
        String expected = "Существует несколько семейств: заячьи, беличьи, мышиные, кошачьи, псовые, медвежьи, куньи";
        assertEquals("Семейства должны совпадать", expected, animal.getFamily());
    }
    }
