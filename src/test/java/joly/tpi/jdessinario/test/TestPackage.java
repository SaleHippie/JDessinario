package joly.tpi.jdessinario.test;

import joly.tpi.jdessinario.*;
import joly.tpi.jdessinario.Package;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * ETML
 * Author : Matthieu Joly
 * Date : 06.06.2015.
 * Summary :  test class.
 */
public class TestPackage {

    @Test
    public void testPackage(){
        Package testPackage = new Package();

        Game game = new Game();
        testPackage.setCategories(CategoriesPackage.ANSWER);
        testPackage.setGame(game);
        testPackage.setMode("Classic");
        testPackage.setText("Hello World !\n");
        testPackage.setX(4);
        testPackage.setY(2);

        assertEquals("May return ANSWER", CategoriesPackage.ANSWER, testPackage.getCategories());
        assertEquals("May return classic", "classic", testPackage.getMode().toLowerCase());
        assertEquals("May return Hello World !", "Hello World !\n", testPackage.getText());
        assertEquals("May return 4", (float) 4.0, testPackage.getX(), 0.1);
        assertEquals("May return 2", (float) 2.0, testPackage.getY(), 0.1);
        assertEquals("May return the object Game", game, testPackage.getGame());
    }
}
