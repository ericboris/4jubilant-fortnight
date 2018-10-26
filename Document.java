/**
 * a titled document that contains any number of sectionss
 *
 * @author Eric Boris
 * @version 10/26/18
 */
public class Document {
    private static Document instance;
    
    private String name;
    private LinkedList<Section> sections;
    
    public static final String DEFAULT_NAME = "";
        
    private Document(String name, LinkedList<Section> sections) {
        setName(name);
        this.sections = sections;
    }
    
    public static Document getInstance(String name, LinkedList<Section> sections) {
        if (instance == null) {
            instance = new Document(name, sections);
        }
        return instance;
    }
    
    /**
     * set the name of the document
     * 
     * @param   name        the name of the document
     */
    public void setName(String name) {
        if (name == null) {
            throw new IllegalArgumentException("name must not be null");
        }
        this.name = name;
    }

    /**
     * return the name of the document
     * 
     * @return              the name of the document
     */
    public String getName() {
        return name;
    }

    /**
     * add a section at the front of the document
     * 
     * @param   section   the section to add
     */
    public void addSection(Section section) {
        addSection(0, section);
    }

    /**
     * add a section at given index of the document
     * 
     * @param   index       the location to insert the section
     * @param   section     the section to add
     */
    public void addSection(int index, Section section) {
        if (index < 0 || index > sections.size()) {
            throw new IndexOutOfBoundsException("index: " + index);
        }
        if (section == null) {
            throw new IllegalArgumentException("section must not be null");
        }
        sections.add(index, section);
    }

    /**
     * return a section at given index of the document
     * 
     * @param   index       the location of the section to return
     * @return              the section to return
     */
    public Section getSection(int index) {
        if (index < 0 || index > sections.size()) {
            throw new IndexOutOfBoundsException("index: " + index);
        }
        return sections.get(index);
    }
    
    /**
     * return the sections in the document
     * 
     * @return              the sections in the document
     */
    public LinkedList<Section> getSections() {
        return sections;
    }
    
    /**
     * remove a section at the given index of the document
     * 
     * @param   index       the location of the section to remove
     */
    public void remSection(int index) {
        if (index < 0 || index > sections.size()) {
            throw new IndexOutOfBoundsException("index: " + index);
        }
        sections.remove(index);
    }
    
    /**
     * clear the document of all sections
     */
    public void clear() {
        sections = new LinkedList<Section>();
    }
    
    /**
     * return the count of the sections in the document
     */
    public int getCount() {
        return sections.size();
    }
    
    /**
     * return a string form of the document
     * 
     * @return              the string form of the document
     */
    public String toString() {
        return "name :\n\t" + name + "\nsections :\n\t" + getCount();
    }
}
