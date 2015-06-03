package joly.tpi.jdessinario;

import java.text.Normalizer;
import java.util.ArrayList;
import java.util.Random;

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
    public String   wordToDraw;

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

    public String getWordToDraw() {
        return wordToDraw;
    }

    public void setWordToDraw(String wordToDraw) {
        this.wordToDraw = wordToDraw;
    }

    /************************************
     * Summary :    startARound a game
     * Name :       startARound()
     * Param :      -
     * Return :     -
     **************************************/
    public void startARound(Drawer drawer, ArrayList<String> players, ArrayList<String> words){
        this.nbTurn --;
        drawer.whoDraw(players);

        //get the word to draw
        Random rand = new Random();

        int index = rand.nextInt(words.size());
        this.wordToDraw = words.get(index);
        //TODO assign role of players
    }

    public void checkAnswer(String answerToCheck){

        String word = this.wordToDraw.toLowerCase();
        answerToCheck = answerToCheck.toLowerCase();

        //Accent insensitive
        word =  Normalizer.normalize(word, Normalizer.Form.NFKD);
        word = word.replaceAll("[^\\p{ASCII}]", "");

        answerToCheck = Normalizer.normalize(answerToCheck, Normalizer.Form.NFKD);
        answerToCheck = answerToCheck.replaceAll("[^\\p{ASCII}]", "");

        if( answerToCheck == word ){

            end();
        }
    }

    private void end(){
        if( nbTurn > 0){
            // start a round
            //startARound();
        }
        else {
            JDessinario.showResult();
        }
    }
}
