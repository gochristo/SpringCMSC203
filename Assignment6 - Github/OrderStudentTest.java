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

public class OrderStudentTest {

    private Customer cust;
    private Order weekdayOrder;
    private Order weekendOrder;

    @BeforeEach
    public void setUp() {
        cust = new Customer("Chris", 21);
        weekdayOrder = new Order(14, Day.TUESDAY, cust);
        weekendOrder = new Order(18, Day.SATURDAY, cust);
    }

    @Test
    public void testConstructorAndGetters() {
        assertEquals(14, weekdayOrder.getOrderTime());
        assertEquals(Day.TUESDAY, weekdayOrder.getOrderDay());
        assertEquals("Chris", weekdayOrder.getCustomer().getName());
        assertNotEquals(cust, weekdayOrder.getCustomer());
    }

    @Test
    public void testIsWeekend() {
        assertTrue(weekendOrder.isWeekend());
        assertFalse(weekdayOrder.isWeekend());
    }

    @Test
    public void testAddNewBeverageCoffee() {
        weekdayOrder.addNewBeverage("Espresso", Size.MEDIUM, true, false);
        Beverage b = weekdayOrder.getBeverage(0);
        assertNotNull(b);
        assertEquals(Type.COFFEE, b.getType());
        assertEquals("Espresso", b.getBevName());
    }

    @Test
    public void testAddNewBeverageAlcohol() {
        weekendOrder.addNewBeverage("Wine", Size.SMALL);
        Beverage b = weekendOrder.getBeverage(0);
        assertNotNull(b);
        assertEquals(Type.ALCOHOL, b.getType());
        assertEquals("Wine", b.getBevName());
    }

    @Test
    public void testAddNewBeverageSmoothie() {
        weekdayOrder.addNewBeverage("Banana Blast", Size.LARGE, 2, true);
        Beverage b = weekdayOrder.getBeverage(0);
        assertNotNull(b);
        assertEquals(Type.SMOOTHIE, b.getType());
        assertEquals("Banana Blast", b.getBevName());
    }

    @Test
    public void testGetBeverageWithInvalidIndex() {
        assertNull(weekdayOrder.getBeverage(0));
        weekdayOrder.addNewBeverage("Latte", Size.SMALL, false, false);
        assertNull(weekdayOrder.getBeverage(5));
    }

    @Test
    public void testCalcOrderTotal() {
        weekdayOrder.addNewBeverage("Latte", Size.SMALL, false, false);
        weekdayOrder.addNewBeverage("Wine", Size.LARGE);
        weekdayOrder.addNewBeverage("Banana", Size.MEDIUM, 2, false);
        assertEquals(8.5, weekdayOrder.calcOrderTotal(), 0.001);
    }

    @Test
    public void testFindNumOfBeveType() {
        weekdayOrder.addNewBeverage("Latte", Size.SMALL, false, false);
        weekdayOrder.addNewBeverage("Wine", Size.LARGE);
        weekdayOrder.addNewBeverage("Banana", Size.MEDIUM, 2, false);
        weekdayOrder.addNewBeverage("Mocha", Size.MEDIUM, true, true);

        assertEquals(2, weekdayOrder.findNumOfBeveType(Type.COFFEE));
        assertEquals(1, weekdayOrder.findNumOfBeveType(Type.ALCOHOL));
        assertEquals(1, weekdayOrder.findNumOfBeveType(Type.SMOOTHIE));
    }

    @Test
    public void testCompareTo() {
        Order another = new Order(12, Day.MONDAY, cust);
        another.generateOrder();

        assertNotEquals(weekdayOrder.getOrderNo(), another.getOrderNo());

        int result = weekdayOrder.compareTo(another);
        if (weekdayOrder.getOrderNo() < another.getOrderNo()) {
            assertEquals(-1, result);
        } else if (weekdayOrder.getOrderNo() > another.getOrderNo()) {
            assertEquals(1, result);
        } else {
            assertEquals(0, result);
        }
    }
}

