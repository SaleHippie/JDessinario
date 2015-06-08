package joly.tpi.jdessinario.test;

import joly.tpi.jdessinario.Game;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * ETML
 * Author : Matthieu Joly
 * Date : 06.06.2015.
 * Summary :  test class.
 */
public class TestGame {
    @Test
    public void TestGame(){
        Game testGame = new Game();

        testGame.setDrawer("MArk");
        testGame.setGuessTeamColor("blue");
        testGame.setModeClassic(false);
        testGame.setWordToDraw("Bambi");

        assertEquals("May return mark", "mark", testGame.getDrawer().toLowerCase());
        assertEquals("May return blue", "blue", testGame.getGuessTeamColor().toLowerCase());
        assertEquals("May return false", false, testGame.isModeClassic());
        assertEquals("May return bambi", "bambi", testGame.getWordToDraw().toLowerCase());
    }
}
