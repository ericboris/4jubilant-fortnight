
/**
 * Demonstrate the functionality of Document
 *
 * @author Eric Boris
 * @version 10/26/18
 */
public class Main {
    public static void main(String[] args) {
        Document doc = Document.newDoc("file1");
        Section sec1 = new Section("section1");
        Paragraph para1 = new Paragraph("paragraph1");
        Section sec2 = new Section("section2");
        Paragraph para2 = new Paragraph("paragraph2");
        
        sec1.addParagraph(para1);
        sec1.addParagraph(para2);
        sec2.addParagraph(para2);
        doc.addSection(sec1);
        doc.addSection(sec2);
        
        doc.saveDoc();
        
        Document doc2 = Document.openDoc("file1.wpd");
        System.out.println(doc2.getName());
        for (int i = 0; i < doc2.getCount(); i++) {
            System.out.println(doc2.getSection(i).toString());
        }
    }
}
