package joly.tpi.jdessinario.test;

import joly.tpi.jdessinario.GameControl;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * ETML
 * Author : Matthieu Joly
 * Date : 06.06.2015.
 * Summary :  test class.
 */
public class TestGameControl {
    @Test
    public void testGameControl(){
        GameControl testGameControl = new GameControl();

        testGameControl.setNbTurn(8);

        assertEquals("May return 8", 8, testGameControl.getNbTurn());
    }
}
