    import static org.junit.Assert.*;
    import org.junit.After;
    import org.junit.Before;
    import org.junit.Test;
    
    /**
     * The test class StyleTest.
     *
     * @author  (your name)
     * @version (a version number or a date)
     */
    public class StyleTest {
        /**
         * Default constructor for test class StyleTest
         */
        public StyleTest() {
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
        public void testHEAD1() {
            Style testStyle = Style.HEAD1;
            assertEquals("h1", testStyle.toString());
        }
        
        @Test
        public void testHEAD2() {
            Style testStyle = Style.HEAD2;
            assertEquals("h2", testStyle.toString());
        }
        
        @Test
        public void testHEAD3() {
            Style testStyle = Style.HEAD3;
            assertEquals("h3", testStyle.toString());
        }
        
        @Test
        public void testHEAD4() {
            Style testStyle = Style.HEAD4;
            assertEquals("h4", testStyle.toString());
        }
        
        @Test
        public void testLEFT() {
            Style testStyle = Style.LEFT;
            assertEquals("LEFT", testStyle.toString());
        }
        
        @Test
        public void testRIGHT() {
            Style testStyle = Style.RIGHT;
            assertEquals("RIGHT", testStyle.toString());
        }
    
        @Test
        public void testCENTER() {
            Style testStyle = Style.CENTER;
            assertEquals("CENTER", testStyle.toString());
        }
        
        @Test
        public void testBULLET() {
            Style testStyle = Style.BULLET;
            assertEquals("ul", testStyle.toString());
        }
        
        @Test
        public void testNUMBERED() {
            Style testStyle = Style.NUMBERED;
            assertEquals("ol", testStyle.toString());
        }
}
