import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class ParagraphTest.
 *
 * @author  Eric Boris
 * @version 10/24/18
 */
public class ParagraphTest {
    /**
     * Default constructor for test class ParagraphTest
     */
    public ParagraphTest() {
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
    public void testDefaultConstructor() {
        Paragraph testP = new Paragraph();
        assertEquals(Paragraph.DEFAULT_TEXT, testP.getText());
        assertEquals(Paragraph.DEFAULT_STYLE, testP.getStyle());
    }
    
    @Test
    public void testSingleConstructor() {
        Paragraph testP = new Paragraph("text");
        assertEquals("text", testP.getText());
        assertEquals(Paragraph.DEFAULT_STYLE, testP.getStyle());
    }
    
    @Test
    public void testFullConstructor() {
        Paragraph testP = new Paragraph("", Style.LEFT);
        assertEquals(Paragraph.DEFAULT_TEXT, testP.getText());
        assertEquals(Paragraph.DEFAULT_STYLE, testP.getStyle());
    }
    @Test
    public void testSetters() {
        Paragraph testP = new Paragraph();
        testP.setText("Lorem ipsum");
        testP.setStyle(Style.RIGHT);
        assertEquals("Lorem ipsum", testP.getText());
        assertEquals(Style.RIGHT, testP.getStyle());
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testSetNullText() {
        Paragraph testP = new Paragraph();
        testP.setText(null);
    }
}
