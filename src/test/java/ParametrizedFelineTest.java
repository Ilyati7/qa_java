import com.example.Feline;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(Parameterized.class)
public class ParametrizedFelineTest {

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {1, 1},
                {2, 2},
                {3, 3},
                {0, 0}
        });
    }

    private final int input;
    private final int expected;

    @Mock
    private Feline felineMock;

    public ParametrizedFelineTest(int input, int expected) {
        this.input = input;
        this.expected = expected;
    }

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this); // Добавляем эту строку
    }

    @Test
    public void testGetKittens() {
        when(felineMock.getKittens(input)).thenReturn(expected); // Добавляем stub
        assertEquals(expected, felineMock.getKittens(input));
    }
}
