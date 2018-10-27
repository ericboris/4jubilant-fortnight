//import java.io.Serializable;

/**
 * Store the possible choices of paragraph style
 *
 * @author Eric Boris
 * @version 10/24/18
 */
public enum Style{
    /** HEAD1       a first class header */
    HEAD1("h1"), 
    /** HEAD2       a second class header */
    HEAD2("h2"), 
    /** HEAD3       a third class header */
    HEAD3("h3"), 
    /** HEAD4       a fourth class header */
    HEAD4("h4"), 
    /** LEFT        left aligned text */
    LEFT("LEFT"), 
    /** CENTER      center aligned text */
    CENTER("CENTER"), 
    /** RIGHT       right aligned text */
    RIGHT("RIGHT"), 
    /** BULLET      a bulleted list */
    BULLET("ul"), 
    /** NUMBERED    a numbered list */
    NUMBERED("ol");
    
    /** type        the type of style */
    private String type;
    
    /**
     * set the type of style
     * 
     * @param   type        the type of style to set
     */
    private Style(String type) {
        this.type = type;
    }

    /**
     * return a string of the object
     * 
     * @return              a string of the object  
     */
    @Override
    public String toString() {
        return type;
    }
}


