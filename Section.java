/**
 * A titled section that contains any number of paragraphs
 *
 * @author Eric Boris
 * @version 10/26/18
 */
public class Section {
    /** name            the name of the section */
    private String name;
    /** paragraphs      the collection of paragraphs in the section */
    private LinkedList<Paragraph> paragraphs;

    /** DEFAULT_NAME    the default name of the section */
    public static final String DEFAULT_NAME = "";

    /**
     * a section with default settings
     */
    public Section() {
        this(DEFAULT_NAME);
    }

    /**
     * a section with a given name and default settings
     * 
     * @param   name        the name of the section
     */
    public Section(String name) {
        this(name, new LinkedList<Paragraph>());
    }

    /**
     * a section with a given name and paragaphs provided
     * 
     * @param   name        the name of the section
     * @param   paragraphs  the paragraphs in this section
     */
    public Section(String name, LinkedList<Paragraph> paragraphs) {
        setName(name);
        this.paragraphs = paragraphs;
    }
    
    /**
     * set the name of the section
     * 
     * @param   name        the name of the section
     */
    public void setName(String name) {
        if (name == null) {
            throw new IllegalArgumentException("name must not be null");
        }
        this.name = name;
    }

    /**
     * return the name of the section
     * 
     * @return              the name of the section
     */
    public String getName() {
        return name;
    }

    /**
     * add a paragraph at the front of the section
     * 
     * @param   paragraph   the paragraph to add
     */
    public void addParagraph(Paragraph paragraph) {
        addParagraph(0, paragraph);
    }

    /**
     * add a paragraph at given index of the section
     * 
     * @param   index       the location to insert the paragraph
     * @param   paragraph   the paragraph to add
     */
    public void addParagraph(int index, Paragraph paragraph) {
        if (index < 0 || index > paragraphs.size()) {
            throw new IndexOutOfBoundsException("index: " + index);
        }
        if (paragraph == null) {
            throw new IllegalArgumentException("paragraph must not be null");
        }
        paragraphs.add(index, paragraph);
    }

    /**
     * return a paragraph at given index of the section
     * 
     * @param   index       the location of the paragraph to return
     * @return              the paragraph to return
     */
    public Paragraph getParagraph(int index) {
        if (index < 0 || index > paragraphs.size()) {
            throw new IndexOutOfBoundsException("index: " + index);
        }
        return paragraphs.get(index);
    }
    
    /**
     * return the paragraphs in the section
     * 
     * @return              the paragraphs in the section
     */
    public LinkedList<Paragraph> getParagraphs() {
        return paragraphs;
    }
    
    /**
     * remove a paragraph at the given index of the section
     * 
     * @param   index       the location of the paragraph to remove
     */
    public void remParagraph(int index) {
        if (index < 0 || index > paragraphs.size()) {
            throw new IndexOutOfBoundsException("index: " + index);
        }
        paragraphs.remove(index);
    }
    
    /**
     * clear the section of all paragraphs
     */
    public void clear() {
        paragraphs = new LinkedList<Paragraph>();
    }
    
    /**
     * return the count of the paragraphs in the section
     */
    public int getCount() {
        return paragraphs.size();
    }
    
    /**
     * return a string form of the section
     * 
     * @return              the string form of the section
     */
    public String toString() {
        return "name :\n\t" + name + "\nparagraphs :\n\t" + getCount();
    }
}
