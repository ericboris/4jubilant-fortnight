import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class LinkedListTest.
 *
 * @author  Eric Boris
 * @version 10/29/18
 */
public class LinkedListTest {
    LinkedList<Paragraph> testPs;
    
    /**
     * Default constructor for test class LinkedListTest
     */
    public LinkedListTest() {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp() {
        testPs = new LinkedList<Paragraph>();        
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown() {
    }
    
    @Test
    public void testMove() {
        testPs.add(new Paragraph("a"));
        testPs.add(new Paragraph("b"));
        testPs.add(new Paragraph("c"));
        
        testPs.move(0, 0);
        assertEquals("a", testPs.get(0).getText()); // abc
        testPs.move(0, 1);
        assertEquals("a", testPs.get(1).getText()); // bac
        testPs.move(0, 2);
        assertEquals("b", testPs.get(2).getText()); // acb
        testPs.move(1, -1);
        assertEquals("c", testPs.get(0).getText()); // cab
        testPs.move(1, 1);
        assertEquals("a", testPs.get(2).getText()); // cba
        testPs.move(2, -2);
        assertEquals("a", testPs.get(0).getText()); // acb
        testPs.move(2, -1);
        assertEquals("b", testPs.get(1).getText()); // abc
    }
    
    @Test (expected = IndexOutOfBoundsException.class)
    public void testIndexLessThanZeroMove() {
        testPs.move(-1, 0);
    }
    
    @Test (expected = IndexOutOfBoundsException.class)
    public void testIndexGreaterThanSizeMove() {
        testPs.move(1, 0);
    }
    
    @Test (expected = IndexOutOfBoundsException.class)
    public void testPsirectionLessThanZeroMove() {
        testPs.move(0, -1);
    }
    
    @Test (expected = IndexOutOfBoundsException.class)
    public void testPsirectionGreaterThanSizeMove() {
        testPs.move(0, 1);
    }
}
