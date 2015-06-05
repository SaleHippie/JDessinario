package joly.tpi.jdessinario;

import java.io.Serializable;

/**
 * ETML
 * Author : Matthieu Joly
 * Date : 21.05.2015.
 * Summary :  Client main class to run it
 */
public class Package implements Serializable{

    public String text;
    public CategoriesPackage categories;
    public float x;
    public float y;
    public String mode;
    public Game game;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public CategoriesPackage getCategories() {
        return categories;
    }

    public void setCategories(CategoriesPackage categories) {
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

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }
}