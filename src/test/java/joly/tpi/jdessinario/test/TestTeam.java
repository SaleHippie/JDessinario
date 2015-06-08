package joly.tpi.jdessinario.test;

import joly.tpi.jdessinario.Team;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

/**
 * ETML
 * Author : Matthieu Joly
 * Date : 06.06.2015.
 * Summary :  test class.
 */
public class TestTeam {
    @Test
    public void testTeam(){
        Team testTeam = new Team();
        ArrayList<String> players = new ArrayList<String>();

        players.add("Jean");
        players.add("Robert");
        players.add("Paul");

        testTeam.setColor("red");
        testTeam.setPlayers(players);
        testTeam.setScore(8);

        assertEquals("May return red", "red", testTeam.getColor());
        assertEquals("May return true", true, testTeam.getPlayers().contains("Jean"));
        assertEquals("May return false", false, testTeam.getPlayers().contains("Toto"));
        assertEquals("May return 8", 8, testTeam.getScore());
    }
}
