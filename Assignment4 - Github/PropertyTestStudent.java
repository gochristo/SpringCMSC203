import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PropertyTestStudent{

    private Property defaultProperty;
    private Property basicProperty;
    private Property customPlotProperty;
    private Property copiedProperty;

    @BeforeEach
    public void setUp() {
        defaultProperty = new Property();
        basicProperty = new Property("House", "New York", 3000.0, "Christopher");
        customPlotProperty = new Property("Store", "Silver Spring", 4500.0, "Bob", 1, 1, 4, 4);
        copiedProperty = new Property(customPlotProperty);
    }

    @Test
    public void testConstructor() {
        assertEquals("House", basicProperty.getPropertyName());
        assertEquals("New York", basicProperty.getCity());
        assertEquals(3000.0, basicProperty.getRentAmount());
        assertEquals("Christopher", basicProperty.getOwner());
        assertNotNull(basicProperty.getPlot());
    }

    @Test
    public void testPlotConstructor() {
        Plot plot = customPlotProperty.getPlot();
        assertEquals(1, plot.getX());
        assertEquals(1, plot.getY());
        assertEquals(4, plot.getWidth());
        assertEquals(4, plot.getDepth());
    }

    @Test
    public void testCopyConstructor() {
        assertEquals(customPlotProperty.getPropertyName(), copiedProperty.getPropertyName());
        assertEquals(customPlotProperty.getCity(), copiedProperty.getCity());
        assertEquals(customPlotProperty.getOwner(), copiedProperty.getOwner());
        assertEquals(customPlotProperty.getRentAmount(), copiedProperty.getRentAmount());
        assertNotSame(customPlotProperty.getPlot(), copiedProperty.getPlot()); // deep copy check
        assertEquals(customPlotProperty.getPlot().toString(), copiedProperty.getPlot().toString());
    }

    @Test
    public void testToString() {
        assertEquals("House,New York,Christopher,3000.0", basicProperty.toString());
    }
} 