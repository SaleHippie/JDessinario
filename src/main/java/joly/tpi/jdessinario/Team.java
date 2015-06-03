package joly.tpi.jdessinario;

import java.util.ArrayList;

/**
 * ETML
 * Author : Matthieu Joly
 * Date : 28.05.2015.
 * Summary :  manage the team.
 **/

public class Team {

    public String color;
    public int score;
    public ArrayList<String> Players;
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public ArrayList<String> getPlayers() {
        return Players;
    }

    public void setPlayers(ArrayList<String> players) {
        Players = players;
    }
}
