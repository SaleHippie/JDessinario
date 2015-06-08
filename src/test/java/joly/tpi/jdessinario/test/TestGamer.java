package joly.tpi.jdessinario.test;

import joly.tpi.jdessinario.Gamer;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * ETML
 * Author : Matthieu Joly
 * Date : 06.06.2015.
 * Summary :  test class.
 */

public class TestGamer {

    @Test
    public void testGamer(){
        Gamer testGamer = new Gamer();

        testGamer.setModeDraw(true);
        testGamer.setNickname("Jean");

        assertEquals("May return true", true, testGamer.isModeDraw());
        assertEquals("May return jean", "jean", testGamer.getNickname().toLowerCase());
    }
}
