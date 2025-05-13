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

public class BevShopStudentTest {

    private BevShop shop;

    @BeforeEach
    public void setUp() {
        shop = new BevShop();
    }

    @Test
    public void testIsValidTime() {
        assertTrue(shop.isValidTime(10));
        assertFalse(shop.isValidTime(7));
        assertFalse(shop.isValidTime(23));
        assertFalse(shop.isValidTime(8));
    }

    @Test
    public void testAgeRestrictions() {
        assertTrue(shop.isValidAge(21));
        assertFalse(shop.isValidAge(20));
        assertEquals(21, shop.getMinAgeForAlcohol());
    }

    @Test
    public void testMaxFruit() {
        assertFalse(shop.isMaxFruit(3));
        assertTrue(shop.isMaxFruit(5));
        assertTrue(shop.isMaxFruit(6));
        assertEquals(5, shop.getMaxNumOfFruits());
    }

    @Test
    public void testAlcoholLimitTracking() {
        shop.startNewOrder(10, Day.MONDAY, "Alex", 25);
        assertEquals(0, shop.getNumOfAlcoholDrink());
        assertFalse(shop.isEligibleForMore());

        shop.processAlcoholOrder("Wine", Size.SMALL);
        shop.processAlcoholOrder("Beer", Size.SMALL);
        shop.processAlcoholOrder("Whiskey", Size.SMALL);

        assertEquals(3, shop.getNumOfAlcoholDrink());
        assertTrue(shop.isEligibleForMore());
        assertEquals(3, shop.getMaxOrderForAlcohol());
    }

    @Test
    public void testStartAndProcessOrders() {
        shop.startNewOrder(10, Day.TUESDAY, "Chris", 22);
        assertEquals(1, shop.totalNumOfMonthlyOrders());
        assertEquals("Chris", shop.getCurrentOrder().getCustomer().getName());

        shop.processCoffeeOrder("Latte", Size.SMALL, false, false);
        shop.processSmoothieOrder("Berry", Size.LARGE, 2, true);
        assertEquals(2, shop.getCurrentOrder().getTotalItems());

        double expectedTotal = new Coffee("Latte", Size.SMALL, false, false).calcPrice()
                + new Smoothie("Berry", Size.LARGE, 2, true).calcPrice();

        assertEquals(expectedTotal, shop.getCurrentOrder().calcOrderTotal(), 0.001);
    }

    @Test
    public void testTotalOrderPriceAndFindOrder() {
        shop.startNewOrder(10, Day.FRIDAY, "Jordan", 23);
        shop.processAlcoholOrder("Rum", Size.MEDIUM);
        int orderNo = shop.getCurrentOrder().getOrderNo();

        int index = shop.findOrder(orderNo);
        assertNotEquals(-1, index);

        assertEquals(2.5, shop.totalOrderPrice(orderNo), 0.001);
    }
}
