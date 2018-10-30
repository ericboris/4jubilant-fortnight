
/**
 * Demonstrate the functionality of Document
 *
 * @author Eric Boris
 * @version 10/26/18
 */
public class Main {
    /**
     *  run the program
     *  
     *  @param  args        the optional commandline arguments
     */
    public static void main(String[] args) {
        //Document doc = Document.newDoc("Animals");
        Document doc = Document.getInstance();        
        
        Section firstSect = new Section("Hippos");
        
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
        
        Section secondSect = new Section("Cats");

        secondSect.addParagraph(new Paragraph("Domestic cats", Style.HEAD1));
        secondSect.addParagraph(new Paragraph("The cat is a furry, carnivorous mammal..."));
        secondSect.addParagraph(new Paragraph("Cat facts:"));
        
        String numberedText = "";
        numberedText += "Cats have been domesticated for around 4,000 years. \n";
        numberedText += "While not well known, the collective nouns used for cats and kittens are a clowder of cats and a kindle of kittens. \n";
        numberedText += "More cats are left-pawed than right. \n";
        numberedText += "The largest breed of cat in Australia is the Maine Coon. Males can regularly weigh up to 12kgs! \n";
        
        secondSect.addParagraph(new Paragraph(numberedText, Style.NUMBERED));
        secondSect.addParagraph(new Paragraph("That's all for cats..."));
        
        doc.addSection(firstSect);
        doc.addSection(secondSect);
        
        doc.move(0, 1);
        
        doc.saveDoc();
        doc.saveHtml();
    }
}
