import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PlotTestStudent {

    private Plot basePlot;
    private Plot innerPlot;
    private Plot overlappingPlot;
    private Plot nonOverlappingPlot;
    private Plot edgeTouchingPlot;
    private Plot exactMatchPlot;
    private Plot negativeCoordPlot;
    private Plot zeroSizePlot;

    @BeforeEach
    public void setUp() {
        basePlot = new Plot(0, 0, 10, 10);
        innerPlot = new Plot(2, 2, 3, 3);
        overlappingPlot = new Plot(4, 4, 7, 7);
        nonOverlappingPlot = new Plot(11, 11, 2, 2);
        edgeTouchingPlot = new Plot(10, 0, 2, 2);
        exactMatchPlot = new Plot(0, 0, 10, 10);
        negativeCoordPlot = new Plot(-1, -1, 5, 5);
        zeroSizePlot = new Plot(0, 0, 0, 0);
    }

    @Test
    public void testEncompassesTrue() {
        assertTrue(basePlot.encompasses(innerPlot));
    }

    @Test
    public void testEncompassesFalse() {
        assertFalse(innerPlot.encompasses(basePlot));
    }

    @Test
    public void testEncompassesExactMatch() {
        assertTrue(basePlot.encompasses(exactMatchPlot));
    }

    @Test
    public void testOverlapsTrue() {
        assertTrue(basePlot.overlaps(overlappingPlot));
    }

    @Test
    public void testOverlapsFalse() {
        assertFalse(basePlot.overlaps(nonOverlappingPlot));
    }

    @Test
    public void testOverlapsEdgeTouching() {
        assertFalse(basePlot.overlaps(edgeTouchingPlot));
    }

    @Test
    public void testNegativeCoordinates() {
        assertTrue(basePlot.overlaps(negativeCoordPlot));
    }

    @Test
    public void testZeroSizePlot() {
        assertFalse(basePlot.overlaps(zeroSizePlot));
        assertFalse(zeroSizePlot.overlaps(basePlot));
    }

    @Test
    public void testToString() {
        assertEquals("0,0,10,10", basePlot.toString());
    }

    @Test
    public void testCopyConstructor() {
        Plot copy = new Plot(innerPlot);
        assertNotSame(copy, innerPlot);
        assertEquals(innerPlot.toString(), copy.toString());
    }
}
