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

public class AlcoholStudentTest {

    private Alcohol weekdaySmall;
    private Alcohol weekendLarge;
    private Alcohol anotherWeekendLarge;

    @BeforeEach
    public void setUp() {
        weekdaySmall = new Alcohol("Whiskey", Size.SMALL, false);
        weekendLarge = new Alcohol("Whiskey", Size.LARGE, true);
        anotherWeekendLarge = new Alcohol("Whiskey", Size.LARGE, true);
    }

    @Test
    public void testConstructorAndGetters() {
        assertEquals("Whiskey", weekdaySmall.getBevName());
        assertEquals(Size.SMALL, weekdaySmall.getSize());
        assertEquals(Type.ALCOHOL, weekdaySmall.getType());
        assertFalse(weekdaySmall.isWeekend());

        assertTrue(weekendLarge.isWeekend());
    }

    @Test
    public void testCalcPrice() {
        assertEquals(3.6, weekendLarge.calcPrice(), 0.001);
        assertEquals(2.0, weekdaySmall.calcPrice(), 0.001);
    }

    @Test
    public void testEqualsMethod() {
        assertEquals(weekendLarge, anotherWeekendLarge);

        assertNotEquals(weekendLarge, weekdaySmall);

        assertNotEquals(weekendLarge, null);
        assertNotEquals(weekendLarge, "Not an Alcohol");
    }
}

