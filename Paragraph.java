/**
 * Store and handle the text of a paragraph
 *
 * @author Eric Boris
 * @version 10/24/18
 */
public class Paragraph {
    /** text        the text of the paragraph */
    private String text;
    /** style       the style of the paragraph */
    private Style style;
    
    /** DEFAULT_TEXT        the default text of a paragraph */
    public static final String DEFAULT_TEXT = "";
    /** DEFAULT_STYLE       the default style of a paragraph */
    public static final Style DEFAULT_STYLE = Style.LEFT;
   
    /**
     * a paragraph with class defaults
     */
    public Paragraph() {
        this(DEFAULT_TEXT, DEFAULT_STYLE);
    }
    
    /**
     * a paragraph with text and class default style
     * 
     * @param   text        the text of the paragraph
     */
    public Paragraph(String text) {
        this(text, DEFAULT_STYLE);
    }
    
    /**
     * a paragraph with text and a style
     * 
     * @param   text        the text of the paragraph
     * @param   style       the style of the paragraph
     */  
    public Paragraph(String text, Style style) {
        setText(text);
        setStyle(style);
    }
    
    /**
     * set the text of the paragraph
     * 
     * @param   text        the text to set
     */
    public void setText(String text) {
        if (text == null) {
            throw new IllegalArgumentException("parameter must not be null");
        }
        this.text = text;
    }
    
    /**
     * get the text of the paragraph
     * 
     * @return          the text of the paragraph
     */
    public String getText() {
        return text;
    }
    
    /**
     * set the style of the paragraph
     * 
     * @param   style       the style to set
     */
    public void setStyle(Style style) {
        this.style = style;
    }
    
    /**
     * get the style of the paragraph
     * 
     * @return          the style of the paragraph
     */
    public Style getStyle() {
        return style;
    }
    
    /**
     * return a string of the object
     */
    public String toString() {
        return "text :\n\t" + text + "\nstyle : \n\t" + style;
    }
}
