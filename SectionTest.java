import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class SectionTest.
 *
 * @author  Eric Boris
 * @version 10/26/18
 */
public class SectionTest {
    /**
     * Default constructor for test class SectionTest
     */
    public SectionTest() {
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
        Section testS = new Section();
        assertEquals(Section.DEFAULT_NAME, testS.getName());
    }

    @Test
    public void testSingleConstructor() {
        Section testS = new Section("name");
        assertEquals("name", testS.getName());;
    }

    @Test
    public void testFullConstructor() {
        Section testS = new Section("name", new LinkedList<Paragraph>());
        assertEquals("name", testS.getName());
    }

    @Test
    public void testSetNameAndAddParagraph() {
        Section testS = new Section();
        testS.setName("new name");
        testS.addParagraph(new Paragraph());
        assertEquals("new name", testS.getName());
        assertTrue(testS.getParagraph(0) instanceof Paragraph);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testNullName() {
        Section testS = new Section();
        testS.setName(null);
    }
    
    @Test
    public void testAddGetRemoveParagraphs() {
        // create a new section and check that there are no paragraphs
        Section testS = new Section();
        assertEquals(0, testS.getCount());
        
        // add three paragraphs and check the new size
        testS.addParagraph(new Paragraph("text 1", Style.LEFT));
        testS.addParagraph(new Paragraph("text 2", Style.CENTER));
        testS.addParagraph(new Paragraph("text 3", Style.RIGHT));
        assertEquals(3, testS.getCount());
        
        // check each element and remove it after checkingk
        assertEquals("text 1", testS.getParagraph(0).getText());
        assertEquals(Style.LEFT, testS.getParagraph(0).getStyle());
        testS.remParagraph(0);
        assertEquals(2, testS.getCount());
        assertEquals("text 2", testS.getParagraph(0).getText());
        assertEquals(Style.CENTER, testS.getParagraph(0).getStyle());
        testS.remParagraph(0);
        assertEquals("text 3", testS.getParagraph(0).getText());
        assertEquals(Style.RIGHT, testS.getParagraph(0).getStyle());
    }
    
    @Test
    public void testAddParagraphAtIndex() {
        Section testS = new Section();
        testS.addParagraph(0, new Paragraph("text 1"));
        testS.addParagraph(1, new Paragraph("text 2"));
        testS.addParagraph(2, new Paragraph("text 3"));
        
        assertEquals("text 2", testS.getParagraph(1).getText());
        testS.addParagraph(1, new Paragraph("text 4"));
        assertEquals("text 1", testS.getParagraph(0).getText());
        assertEquals("text 4", testS.getParagraph(1).getText());
        assertEquals("text 2", testS.getParagraph(2).getText());
    }
    
    @Test (expected = IndexOutOfBoundsException.class)
    public void testAddParagraphNegativeIndex() {
        Section testS = new Section();
        testS.addParagraph(-1, new Paragraph());
    }
    
    @Test (expected = IndexOutOfBoundsException.class)
    public void testAddParagraphOutOfBoundsIndex() {
        Section testS = new Section();
        testS.addParagraph(1, new Paragraph());
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testAddNullParagraph() {
        Section testS = new Section();
        testS.addParagraph(null);
    }
    
    @Test (expected = IndexOutOfBoundsException.class)
    public void testGetParagraphNegativeIndex() {
        Section testS = new Section();
        testS.getParagraph(-1);
    }
    
    @Test (expected = IndexOutOfBoundsException.class)
    public void testGetParagraphOutOfBoundsIndex() {
        Section testS = new Section();
        testS.addParagraph(new Paragraph());
        testS.getParagraph(1);
    }
    
    @Test (expected = IndexOutOfBoundsException.class)
    public void testRemParagraphNegativeIndex() {
        Section testS = new Section();
        testS.remParagraph(-1);
    }
    
    @Test (expected = IndexOutOfBoundsException.class)
    public void testRemParagraphOutOfBoundsIndex() {
        Section testS = new Section();
        testS.addParagraph(new Paragraph());
        testS.remParagraph(1);
    }
    
    @Test
    public void testGetCountAndClear() {
        Section testS = new Section();
        assertEquals(0, testS.getCount());
        testS.addParagraph(new Paragraph());
        assertEquals(1, testS.getCount());
        testS.addParagraph(new Paragraph());
        assertEquals(2, testS.getCount());
        testS.clear();
        assertEquals(0, testS.getCount());
    }
}
