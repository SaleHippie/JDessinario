package joly.tpi.jdessinario;

import java.util.ArrayList;

/**
 * ETML
 * Author : Matthieu Joly
 * Date : 28.05.2015.
 * Summary :  Contain game parameters
 */
public class Game {

    public boolean  modeClassic;
    public int      nbTurn;
    public String   Drawer;
    public String   GuessTeamColor;

    public boolean isModeClassic() {
        return modeClassic;
    }

    public void setModeClassic(boolean modeClassic) {
        this.modeClassic = modeClassic;
    }

    public int getNbTurn() {
        return nbTurn;
    }

    public void setNbTurn(int nbTurn) {
        this.nbTurn = nbTurn;
    }

    public String getDrawer() {
        return Drawer;
    }

    public void setDrawer(String drawer) {
        Drawer = drawer;
    }

    public String getGuessTeamColor() {
        return GuessTeamColor;
    }

    public void setGuessTeamColor(String guessTeamColor) {
        GuessTeamColor = guessTeamColor;
    }

    /************************************
     * Summary :    start a game
     * Name :       start()
     * Param :      -
     * Return :     -
     **************************************/
    public void start(Drawer drawer, ArrayList<String> players){
        this.nbTurn --;
        //TODO assign the drawer
        drawer.whoDraw(players);

        //TODO get the word
        //TODO
    }
}
