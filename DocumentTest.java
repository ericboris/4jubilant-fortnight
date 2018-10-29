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
    Document testD;

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
        testD = Document.newDoc("testD");
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown() {
        testD.closeDoc();
    }

    @Test
    public void testNewDocument() {
        assertTrue(testD instanceof Document);        
    }

    @Test
    public void testSetAndGetName() {
        testD.setName("document1");
        assertEquals("document1", testD.getName());
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testNullName() {
        testD.setName(null);
    }

    @Test
    public void testAddAndGetSection() {
        testD.addSection(new Section("section1"));
        assertEquals("section1", testD.getSection(0).getName());
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testNullAddSection() {
        testD.addSection(null);
    }

    @Test (expected = IndexOutOfBoundsException.class)
    public void testIndexLessThanZeroAddSection() {
        testD.addSection(-1, new Section("section1"));
    }
    
    @Test (expected = IndexOutOfBoundsException.class)
    public void testIndexGreaterThanSizeAddSection() {
        testD.addSection(1, new Section("section1"));
    }
    
    @Test
    public void testGetSections() {
        testD.addSection(new Section("section1"));
        testD.addSection(0, new Section("section2"));
        assertEquals(2, testD.getSections().size());
    }
    
    @Test (expected = IndexOutOfBoundsException.class)
    public void testIndexLessThanZeroGetSection() {
        testD.getSection(-1);
    }
    
    @Test (expected = IndexOutOfBoundsException.class)
    public void testIndexGreaterThanSizeGetSection() {
        testD.getSection(0);
    }
    
    @Test
    public void testRemoveSection() {
        testD.addSection(new Section("section1"));
        testD.addSection(new Section("section2"));
        assertEquals(2, testD.getSections().size());
        testD.remSection(0);
        assertEquals(1, testD.getSections().size());
        assertEquals("section2", testD.getSection(0).getName());
    }

    @Test (expected = IndexOutOfBoundsException.class)
    public void testIndexLessThanZeroRemSection() {
        testD.remSection(-1);
    }
    
    @Test (expected = IndexOutOfBoundsException.class)
    public void testIndexGreaterThanSizeRemSection() {
        testD.remSection(0);
    }
    
    @Test
    public void testClear() {
        testD.addSection(new Section("section1"));
        testD.addSection(new Section("section2"));
        assertEquals(2, testD.getSections().size());
        testD.clear();
        assertEquals(0, testD.getSections().size());
    }

    @Test
    public void testGetCount() {
        testD.addSection(new Section("section1"));
        testD.addSection(new Section("section2"));
        assertEquals(2, testD.getCount());
    }

    @Test
    public void testMove() {
        testD.addSection(new Section("section1"));
        testD.addSection(new Section("section2"));
        assertEquals("section1", testD.getSection(0).getName());
        testD.move(0, 1);
        assertEquals("section2", testD.getSection(0).getName());
    }

    @Test (expected = IndexOutOfBoundsException.class)
    public void testIndexLessThanZeroMove() {
        testD.move(-1, 0);
    }
    
    @Test (expected = IndexOutOfBoundsException.class)
    public void testIndexGreaterThanSizeMove() {
        testD.move(1, 0);
    }
    
    @Test (expected = IndexOutOfBoundsException.class)
    public void testDirectionLessThanZeroMove() {
        testD.move(0, -1);
    }
    
    @Test (expected = IndexOutOfBoundsException.class)
    public void testDirectionGreaterThanSizeMove() {
        testD.move(0, 1);
    }
    
    @Test
    public void testSaveAndOpenDoc() {
        testD.addSection(new Section("section1"));
        testD.saveDoc();
        testD.closeDoc();
        Document testD2 = Document.openDoc("testD");
        assertEquals("section1", testD2.getSection(0).getName());
    }
    
    @Test
    public void testSaveHtml() {
        testD.saveHtml();
    }
    
    @Test
    public void testCloseDoc() {
        testD.addSection(new Section("section1"));
        assertEquals("section1", testD.getSection(0).getName());
        testD.closeDoc();
        assertEquals(null, testD.getName());
        assertEquals(null, testD.getSections());
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testDocAlreadyOpenNewDoc() {
        testD.newDoc("testD");
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testNullNameNewDoc() {
        testD.closeDoc();
        testD.newDoc(null);
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testDocAlreadyOpenOpenDoc() {
        testD.openDoc("testD");
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testNullNameOpenDoc() {
        testD.closeDoc();
        testD.openDoc(null);
    }
}
