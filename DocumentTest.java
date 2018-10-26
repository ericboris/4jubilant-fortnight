import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class DocumentTest.
 *
 * @author  Eric Boris
 * @version 10/26/18
 */
public class DocumentTest {
    /**
     * Default constructor for test class DocumentTest
     */
    public DocumentTest() {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp() {
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
    public void testDefaultInstance() {
        Document testD = Document.getInstance();
        assertEquals(Document.DEFAULT_NAME, testD.getName());
        assertTrue(testD.getSections() instanceof LinkedList);
    }
    
    @Test
    public void testSingleInstance() {
        Document testD = Document.getInstance("name 1");
        testD.setName("name 1");
        assertEquals("name 1", testD.getName());
        
        //assertTrue(testD.getSections() instanceof LinkedList);
    }
    
    // @Test
    // public void testFullInstance() {
        // Document testD = Document.getInstance("name 1", new LinkedList<Section>());
        // assertEquals("name 1", testD.getName());
        // assertTrue(testD.getSections() instanceof LinkedList);
    // }
}
