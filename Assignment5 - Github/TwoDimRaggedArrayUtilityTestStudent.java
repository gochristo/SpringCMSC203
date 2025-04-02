/*
 * Class: CMSC203
 * Instructor: Prof. Monshi
 * Description: Test for TwoDimRaggedArrayUtility class
 * Due: 04/02/2025
 * Platform/compiler: IntelliJ
 * I pledge that I have completed the programming assignment independently.
 *  I have not copied the code from a student or any source.
 *  I have not given my code to any student.
 *  Print your Name here: Christopher Andrews
 */
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.IOException;

public class TwoDimRaggedArrayUtilityTestStudent {
    private double[][] sampleData;
    private File testFile;

    @Before
    public void setUp() throws IOException {
        sampleData = new double[][] {
                {1.5, 2.5, 3.5},
                {4.5, 5.5},
                {6.5, 7.5, 8.5, 9.5}
        };

        testFile = new File("testData.txt");
        PrintWriter writer = new PrintWriter(testFile);
        for (int i = 0 ; i < sampleData.length; i ++) {
            double[] sample = sampleData[i];
            for (int j = 0; j < sample.length; j++) {
                double num = sample[j];
                writer.print(num + " ");
            }
            writer.println();
        }
        writer.close();
    }

    @Test
    public void testReadFile() throws FileNotFoundException {
        double[][] result = TwoDimRaggedArrayUtility.readFile(testFile);
        assertArrayEquals(sampleData, result);
    }

    @Test
    public void testWriteToFile() throws IOException {
        File outputFile = new File("outputTest.txt");
        TwoDimRaggedArrayUtility.writeToFile(sampleData, outputFile);
        double[][] result = TwoDimRaggedArrayUtility.readFile(outputFile);
        assertArrayEquals(sampleData, result);
    }

    @Test
    public void testGetTotal() {
        assertEquals(49.5, TwoDimRaggedArrayUtility.getTotal(sampleData), 0.001);
    }

    @Test
    public void testGetAverage() {
        assertEquals(5.5, TwoDimRaggedArrayUtility.getAverage(sampleData), 0.001);
    }

    @Test
    public void testGetRowTotal() {
        assertEquals(7.5, TwoDimRaggedArrayUtility.getRowTotal(sampleData, 0), 0.001);
    }

    @Test
    public void testGetColumnTotal() {
        assertEquals(12.5, TwoDimRaggedArrayUtility.getColumnTotal(sampleData, 0), 0.001);
    }

    @Test
    public void testGetLowestInRow() {
        assertEquals(4.5, TwoDimRaggedArrayUtility.getLowestInRow(sampleData, 1), 0.001);
    }

    @Test
    public void testGetLowestInRowIndex() {
        assertEquals(0, TwoDimRaggedArrayUtility.getLowestInRowIndex(sampleData, 1));
    }

    @Test
    public void testGetHighestInRow() {
        assertEquals(3.5, TwoDimRaggedArrayUtility.getHighestInRow(sampleData, 0), 0.001);
    }

    @Test
    public void testGetHighestInRowIndex() {
        assertEquals(2, TwoDimRaggedArrayUtility.getHighestInRowIndex(sampleData, 0));
    }

    @Test
    public void testGetLowestInColumn() {
        assertEquals(1.5, TwoDimRaggedArrayUtility.getLowestInColumn(sampleData, 0), 0.001);
    }

    @Test
    public void testGetLowestInColumnIndex() {
        assertEquals(0, TwoDimRaggedArrayUtility.getLowestInColumnIndex(sampleData, 0));
    }

    @Test
    public void testGetHighestInColumn() {
        assertEquals(6.5, TwoDimRaggedArrayUtility.getHighestInColumn(sampleData, 0), 0.001);
    }

    @Test
    public void testGetHighestInColumnIndex() {
        assertEquals(2, TwoDimRaggedArrayUtility.getHighestInColumnIndex(sampleData, 0));
    }

    @Test
    public void testGetLowestInArray() {
        assertEquals(1.5, TwoDimRaggedArrayUtility.getLowestInArray(sampleData), 0.001);
    }

    @Test
    public void testGetHighestInArray() {
        assertEquals(9.5, TwoDimRaggedArrayUtility.getHighestInArray(sampleData), 0.001);
    }
}

