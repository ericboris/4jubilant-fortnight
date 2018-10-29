import java.io.IOException;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.FileWriter;
import java.io.BufferedWriter;
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
    private static String name;
    /** sections        the sections of the document */
    private static LinkedList<Section> sections;
    /** isOpen          is the file open or closed */
    private static boolean isOpen;
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
    private static Document getInstance(String name, LinkedList<Section> sections) {
        if (name == null || sections == null) {
            throw new IllegalArgumentException("parameter must not be null");
        }
        if (instance == null) {
            instance = new Document(name, sections);
        }
        isOpen = true;
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
     * add a section at the end of the document
     * 
     * @param   section   the section to add
     */
    public void addSection(Section section) {
        if (section == null) {
            throw new IllegalArgumentException("section must not be null");
        }
        addSection(sections.size(), section);
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
        sections.clear();
    }

    /**
     * return the count of the sections in the document
     */
    public int getCount() {
        return sections.size();
    }
    
    /**
     * move the section located at index the number of times in direction
     * 
     * @param   index       the section index to move
     * @param   direction   the number of times and direction (+, -) to move
     */
    public void move(int index, int direction) {
        if (index < 0 || index > sections.size() ||
            index + direction < 0 || index + direction > sections.size()) {
            throw new IndexOutOfBoundsException("index: " + index);
        }
        sections.move(index, direction);
    }
    
    /**
     * open a new document
     * 
     * @param   name        the name of the document
     * @return              the document
     */
    public static Document newDoc(String name) {
        if (isOpen) {
            throw new IllegalArgumentException("document is already open");
        }
        if (name == null) {
            throw new IllegalArgumentException("name must not be null");
        }
        return getInstance(name, new LinkedList<Section>());
    }

    /**
     * open an existing document
     * 
     * @param   name        the name of the document to open
     * @return              the document
     */
    public static Document openDoc(String name) {
        if (isOpen) {
            throw new IllegalArgumentException("document is already open");
        }
        if (name == null) {
            throw new IllegalArgumentException("name must not be null");
        }
        try {
            FileInputStream fis = new FileInputStream("docs/" + name + ".wpd");
            ObjectInputStream ois = new ObjectInputStream(fis);
            instance = getInstance(name, (LinkedList<Section>) ois.readObject());
            ois.close();
            fis.close();
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
        return instance;
    }

    /**
     * save the current document instance to a file of the same name
     */
    public void saveDoc() {
        Path path = Paths.get(System.getProperty("user.dir") + "/docs");
        try {
            File file = new File("docs/" + name + ".wpd");
            if (file.exists()) {
                file.delete();
            }
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
     * save the open document to an html file of the same name
     */
    public void saveHtml() {
        StringBuilder sb = new StringBuilder();
        sb.append("<!DOCTYPE html>\n<html>");
        sb.append("\n<head>\n\t<title>" + name + "</title>\n</head>");
        sb.append("\n<body>");
        for (int s = 0; s < getCount(); s++) {
            Section sect = getSection(s);
            for (int p = 0; p < getSection(s).getCount(); p++) {
                Paragraph para = sect.getParagraph(p);
                switch (para.getStyle()) {
                    case HEAD1: sb.append("\n\t\t<h1>" + para.getText() + "</h1>");
                    break;
                    case HEAD2: sb.append("\n\t\t<h2>" + para.getText() + "</h2>");
                    break;
                    case HEAD3: sb.append("\n\t\t<h3>" + para.getText() + "</h3>");
                    break; 
                    case HEAD4: sb.append("\n\t\t<h4>" + para.getText() + "</h4>");
                    break;
                    case LEFT: sb.append("\n\t\t<p align=\"left\">" + para.getText() + "</p>");
                    break;
                    case RIGHT: sb.append("\n\t\t<p align=\"right\">" + para.getText() + "</p>");
                    break;   
                    case CENTER: sb.append("\n\t\t<p align=\"center\">" + para.getText() + "</p>");
                    break;
                    case BULLET: 
                        sb.append("\n\t\t<ul>"); 
                        String[] ulSplit = para.getText().split("\n");
                        for (String li : ulSplit) {
                            sb.append("\n\t\t\t<li>" + li + "</li>");
                        }
                        sb.append("</ul>");
                        break;
                    case NUMBERED:
                        sb.append("\n\t\t<ol>"); 
                        String[] olSplit = para.getText().split("\n");
                        for (String li : olSplit) {
                            sb.append("\n\t\t\t<li>" + li + "</li>");
                        }
                        sb.append("</ol>");
                        break;
                }
            }
            sb.append("\n\t\t</section>");
        }
        sb.append("\n</body>");
        sb.append("\n</html>");

        String htmlText = sb.toString();

        Path path = Paths.get(System.getProperty("user.dir") + "/docs");
        try {      
            File file = new File("docs/" + name + ".html");
            if (file.exists()) {
                file.delete();
            }
            Files.createDirectories(path);
            FileWriter fw = new FileWriter("docs/" + name +  ".html", true);
            BufferedWriter bw  = new BufferedWriter(fw);
            bw.append(htmlText);
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * close the open document
     */
    public static void closeDoc() {
        name = null;
        sections.clear();
        instance = null;
        isOpen = false;
    }   
    
    /**
     * return a string form of the document
     * 
     * @return              the string form of the document
     */
    public String toString() {
        String sects = "";
        for (int s = 0; s < getCount(); s++) {
            sects += getSection(s).toString() + "\t";
        }
        return "name :\n\t" + name + 
               "\ncount :\n\t" + getCount() +
               "\nsections : \n\t" + sects;
               
    }
}
