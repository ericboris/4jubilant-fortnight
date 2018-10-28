
/**
 * Demonstrate the functionality of Document
 *
 * @author Eric Boris
 * @version 10/26/18
 */
public class Main {
    public static void main(String[] args) {
        Document doc = Document.newDoc("Hippos");
        
        Section firstSect = new Section("section1");
        Section secndSect = new Section("section2");
        Section thirdSect = new Section("section3");
        Section forthSect = new Section("section4");
        
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
        
        secndSect.addParagraph(new Paragraph("Now, how about cat facts?"));
        
        doc.addSection(firstSect);
        doc.addSection(secndSect);
        doc.addSection(thirdSect);
        doc.addSection(forthSect);
        
        doc.move(0, 0);
        System.out.println("0,0" + doc.toString());
        doc.move(0, 1);
        System.out.println("0,1" + doc.toString());
        doc.move(0, 2);
        System.out.println("0,2" + doc.toString());
        doc.move(0, 3);
        System.out.println("0,3" + doc.toString());
        doc.move(1, -1);
        System.out.println("1,-1" + doc.toString());
        doc.move(1, 1);
        System.out.println("1,1" + doc.toString());
        doc.move(1, 2);
        System.out.println("1,2" + doc.toString());
        doc.move(2, -2);
        System.out.println("2,-2" + doc.toString());
        doc.move(2, -1);
        System.out.println("2,1" + doc.toString());
        doc.move(2, 1);        
        
        doc.saveDoc();
        doc.saveToHtml();
    }
}
