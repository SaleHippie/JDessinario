package joly.tpi.jdessinario;

import java.io.Serializable;
import java.text.Normalizer;

/**
 * ETML
 * Author : Matthieu Joly
 * Date : 28.05.2015.
 * Summary :  Contain game parameters
 */
public class Game implements Serializable{

    public boolean  modeClassic;
    public String   drawer;
    public String   GuessTeamColor;
    public String   wordToDraw;

    public boolean isModeClassic() {
        return modeClassic;
    }

    public void setModeClassic(boolean modeClassic) {
        this.modeClassic = modeClassic;
    }

    public String getDrawer() {
        return drawer;
    }

    public void setDrawer(String drawer) {
        this.drawer = drawer;
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
    public void startARound(String nickname){

        //assign role of players
        if(this.drawer == nickname){
            //TODO change the answer panel to write the  word
        }
        else{
            //TODO block the drawing pane and notify client
        }

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
        //TODO call the end controller of first client
        /*if( nbTurn > 0){
            // start a round
            //startARound();
        }
        else {
            JDessinario.showResult();
        }*/
    }
}
