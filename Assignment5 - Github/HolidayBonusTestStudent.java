/*
 * Class: CMSC203
 * Instructor: Prof. Monshi
 * Description: Test for HolidayTest class
 * Due: 04/02/2025
 * Platform/compiler: IntelliJ
 * I pledge that I have completed the programming assignment independently.
 *  I have not copied the code from a student or any source.
 *  I have not given my code to any student.
 *  Print your Name here: Christopher Andrews
 */
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import java.io.IOException;


class HolidayBonusTestStudent {
    private double[][] salesData;

    @BeforeEach
    public void setUp() throws IOException {
        salesData = new double[][] {
                {5000, 2000, 3000},
                {7000, 1000, 2000},
                {1000, 4000, 2500}
        };
    }

    @AfterEach
    public void tearDown() {
        salesData = null;
    }

    @Test
    public void testCalculateHolidayBonus() {

        double[] expectedBonuses = {9000, 7000, 8000};

        double[] actualBonuses = HolidayBonus.calculateHolidayBonus(salesData);

        assertArrayEquals(expectedBonuses, actualBonuses, "Bonuses do not match expected values.");
    }

    @Test
    public void testCalculateTotalHolidayBonus() {

        double expectedTotalBonus = 9000 + 7000 + 8000;

        double actualTotalBonus = HolidayBonus.calculateTotalHolidayBonus(salesData);

        assertEquals(expectedTotalBonus, actualTotalBonus, "Total bonus calculation is incorrect.");
    }

    @Test
    public void testCalculateHolidayBonusWithNegativeSales() {

        double[][] salesDataNegative = new double[][] {
                {-100,3000,2004},
                {500,2400,-1000},
                {100}
        };

        double[] expectedBonuses = {10000, 6000, 2000};

        double[] actualBonuses = HolidayBonus.calculateHolidayBonus(salesDataNegative);

        assertArrayEquals(expectedBonuses, actualBonuses, "Bonuses with negative sales are incorrect.");
    }

    @Test
    public void testCalculateTotalHolidayBonusWithEmptyArray() {

        double[][] salesData = new double[0][0];

        double expectedTotalBonus = 0;

        double actualTotalBonus = HolidayBonus.calculateTotalHolidayBonus(salesData);

        assertEquals(expectedTotalBonus, actualTotalBonus, "Total bonus for empty array should be 0.");
    }
}
