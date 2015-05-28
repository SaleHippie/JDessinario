import java.io.Serializable;

/**
 * ETML
 * Author : Matthieu Joly
 * Date : 21.05.2015.
 * Summary :  Client main class to run it
 */
public class Categories implements Serializable{

    public String text;
    public String categories;
    public float x;
    public float y;
    public String mode;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getCategories() {
        return categories;
    }

    public void setCategories(String categories) {
        this.categories = categories;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }
}