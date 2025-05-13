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

public class CustomerStudentTest {

    private Customer original;
    private Customer copy;

    @BeforeEach
    public void setUp() {
        original = new Customer("Chris", 21);
        copy = new Customer(original);
    }

    @Test
    public void testConstructorAndGetters() {
        assertEquals("Chris", original.getName());
        assertEquals(21, original.getAge());
    }

    @Test
    public void testSetters() {
        original.setName("Alex");
        original.setAge(30);

        assertEquals("Alex", original.getName());
        assertEquals(30, original.getAge());
    }

    @Test
    public void testCopyConstructorCreatesSeparateObject() {
        assertEquals(original.getName(), copy.getName());
        assertEquals(original.getAge(), copy.getAge());

        original.setName("Different");
        original.setAge(99);

        assertNotEquals(original.getName(), copy.getName());
        assertNotEquals(original.getAge(), copy.getAge());
    }
}

