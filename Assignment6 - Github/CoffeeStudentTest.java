import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
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
import static org.junit.jupiter.api.Assertions.*;

public class CoffeeStudentTest {

    private Coffee plainSmall;
    private Coffee fullOptionLarge;
    private Coffee sameAsFullOption;

    @BeforeEach
    public void setUp() {
        plainSmall = new Coffee("Latte", Size.SMALL, false, false);
        fullOptionLarge = new Coffee("Latte", Size.LARGE, true, true);
        sameAsFullOption = new Coffee("Latte", Size.LARGE, true, true);
    }

    @Test
    public void testConstructorAndGetters() {
        assertEquals("Latte", plainSmall.getBevName());
        assertEquals(Type.COFFEE, plainSmall.getType());
        assertEquals(Size.SMALL, plainSmall.getSize());
        assertFalse(plainSmall.getExtraShot());
        assertFalse(plainSmall.getExtraSyrup());

        assertTrue(fullOptionLarge.getExtraShot());
        assertTrue(fullOptionLarge.getExtraSyrup());
    }

    @Test
    public void testCalcPrice() {
        assertEquals(4.0, fullOptionLarge.calcPrice(), 0.001);

        assertEquals(2.0, plainSmall.calcPrice(), 0.001);
    }

    @Test
    public void testEqualsMethod() {
        assertEquals(fullOptionLarge, sameAsFullOption);

        assertNotEquals(plainSmall, fullOptionLarge);

        assertNotEquals(fullOptionLarge, null);
        assertNotEquals(fullOptionLarge, "Coffee");
    }
}

