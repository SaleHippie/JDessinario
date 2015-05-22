import java.io.Serializable;

/**
 * ETML
 * Author : Matthieu Joly
 * Date : 21.05.2015.
 * Summary :  Client main class to run it
 */
public class Categories implements Serializable{

    public String text;
    public String Type;


    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        this.Type = type;
    }
}