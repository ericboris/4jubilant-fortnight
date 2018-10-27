
/**
 * Demonstrate the functionality of Document
 *
 * @author Eric Boris
 * @version 10/26/18
 */
public class Main {
    public static void main(String[] args) {
        Document doc = Document.newDoc("Hippos");
        
        Section firstSect = new Section();
        
        firstSect.addParagraph(new Paragraph("Pygmy Hippos of Africa", Style.HEAD1));
        firstSect.addParagraph(new Paragraph("While the hippopotamus exists in various places in Africa..."));
        firstSect.addParagraph(new Paragraph("Hippo facts:"));
        
        String bulletedText = "";
        bulletedText += "The name Hippopotamus comes from the Ancient Greek 'river horse'. \n"; 
        bulletedText += "Hippos secrete an oily red substance; they do not sweat blood. \n"; 
        bulletedText += "An adult Hippo resurfaces every 3 to 5 minutes to breathe.\n"; 
        bulletedText += "They are only territorial while in the water."; 
        
        firstSect.addParagraph(new Paragraph(bulletedText, Style.BULLET)); 
        firstSect.addParagraph(new Paragraph("I hope you have enjoyed our foray into the world of the pygmy hippo..."));
        
        doc.addSection(firstSect);
        doc.saveDoc();
        doc.saveToHtml();
    }
}
