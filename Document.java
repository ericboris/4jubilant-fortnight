import java.io.IOException;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;

/**
 * a titled document that contains any number of sectionss
 *
 * @author Eric Boris
 * @version 10/26/18
 */
public class Document {
    /** instance        the single document instance */
    private static Document instance;
    /** name            the name of the document */
    private String name;
    /** sections        the sections of the document */
    private LinkedList<Section> sections;
    /** DEFAULT_NAME    the default name of the document */
    public static final String DEFAULT_NAME = "";

    /**
     * create a new document instance
     * 
     * @param   name        the name of the document
     * @param   sections    the sections of the document
     */
    private Document(String name, LinkedList<Section> sections) {
        setName(name);
        this.sections = sections;
    }

    /**
     * return an instance of the document
     * 
     * @param   name        the name of the document
     * @param   sections    the sections of the document
     * @return              the document
     */
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
     * open a new document
     * 
     * @param   name        the name of the document
     * @return              the document
     */
    public static Document newDoc(String name) {
        if (instance == null) {
            instance = new Document(name, new LinkedList<Section>()); 
        }
        return instance;
    }
    
    /**
     * open an existing document
     * 
     * @param   name        the name of the document to open
     * @return              the document
     */
    public static Document openDoc(String name) {
        if (name == null) {
            throw new IllegalArgumentException("name must not be null");
        }
        try {

            FileInputStream fis = new FileInputStream("docs/" + name);
            ObjectInputStream ois = new ObjectInputStream(fis);
            instance = new Document(name, (LinkedList<Section>) ois.readObject());
            ois.close();
            fis.close();
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
        return instance;
    }

    /**
     * save the current document instance
     */
    public void saveDoc() {
        Path path = Paths.get(System.getProperty("user.dir") + "/docs");
        try {
            Files.createDirectories(path);
            FileOutputStream docFile = new FileOutputStream("docs/" + name + ".wpd");
            ObjectOutputStream out = new ObjectOutputStream(docFile);
            out.writeObject(sections);
            out.close();
            docFile.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
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
