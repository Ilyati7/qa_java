import com.example.Feline;
import org.junit.Before;
import org.junit.Test;
import java.util.List;
import static org.junit.Assert.*;


public class FelineTest {
    private Feline feline;

    @Before
    public void setUp() {
        feline = new Feline();
    }

    @Test
    public void testEatMeatAnimals() throws Exception {
        List<String> result = feline.eatMeat();
        assertTrue(result.contains("Животные"));
    }

    @Test
    public void testEatMeatBirds() throws Exception {
        List<String> result = feline.eatMeat();
        assertTrue(result.contains("Птицы"));
    }

    @Test
    public void testEatMeatFish() throws Exception {
        List<String> result = feline.eatMeat();
        assertTrue(result.contains("Рыба"));
    }

    @Test
    public void testGetFamily() {
        assertEquals("Кошачьи", feline.getFamily());
    }

    @Test
    public void testGetKittens() {
        assertEquals(3, feline.getKittens(3));
    }
}
