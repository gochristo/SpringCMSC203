/*
 * Class: CMSC203
 * Instructor: Prof.Monshi
 * Description: (Give a brief description for each Class)
 * Due: 05/12/2025
 * Platform/compiler: ItelliJ
 * I pledge that I have completed the programming
 * assignment independently. I have not copied the code
 * from a student or any source. I have not given my code
 * to any student.
   Print your Name here: Christopher Andrews
*/
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SmoothieStudentTest {

    private Smoothie basicSmoothie;
    private Smoothie fruityProteinLarge;
    private Smoothie sameAsFruityProtein;

    @BeforeEach
    public void setUp() {
        basicSmoothie = new Smoothie("Berry Blast", Size.SMALL, 0, false);
        fruityProteinLarge = new Smoothie("Berry Blast", Size.LARGE, 3, true);
        sameAsFruityProtein = new Smoothie("Berry Blast", Size.LARGE, 3, true);
    }

    @Test
    public void testConstructorAndGetters() {
        assertEquals("Berry Blast", basicSmoothie.getBevName());
        assertEquals(Type.SMOOTHIE, basicSmoothie.getType());
        assertEquals(Size.SMALL, basicSmoothie.getSize());
        assertEquals(0, basicSmoothie.getNumFruits());
        assertFalse(basicSmoothie.getAddProtein());

        assertEquals(3, fruityProteinLarge.getNumFruits());
        assertTrue(fruityProteinLarge.getAddProtein());
    }

    @Test
    public void testCalcPrice() {
        assertEquals(6.0, fruityProteinLarge.calcPrice(), 0.001);

        assertEquals(2.0, basicSmoothie.calcPrice(), 0.001);
    }

    @Test
    public void testEqualsMethod() {
        assertEquals(fruityProteinLarge, sameAsFruityProtein);
        assertNotEquals(basicSmoothie, fruityProteinLarge);
        assertNotEquals(fruityProteinLarge, null);
        assertNotEquals(fruityProteinLarge, "Smoothie");
    }
}

