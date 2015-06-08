package joly.tpi.jdessinario;

import java.util.ArrayList;

/**
 * Created by jolyma on 03.06.2015.
 */
public class GameControl {
    ArrayList<Team> guessTeamColor;
    Team redTeam = new Team();
    Team blueTeam = new Team();
    public int nbTurn;
    public String mode;

    public int getNbTurn() {
        return nbTurn;
    }

    public void setNbTurn(int nbTurn) {
        this.nbTurn = nbTurn;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public void initializeGame(String mode){
        Game game = new Game();
        ArrayList<String> drawers = new ArrayList<>();

        redTeam.setColor("red");
        blueTeam.setColor("blue");

        switch (mode){
            case "classic":
                this.guessTeamColor.add(redTeam);
                //The drawer is choose random in the list of enemy team
                for( String player : blueTeam.getPlayers()){
                    drawers.add(player);
                }
                break;
            case "challenge":
                this.guessTeamColor.add(redTeam);
                this.guessTeamColor.add(blueTeam);

                for( String player : redTeam.getPlayers()){
                    drawers.add(player);
                }

                for( String player : blueTeam.getPlayers()){
                    drawers.add(player);
                }
                break;

            default:
                this.guessTeamColor.add(redTeam);
                break;
        }

        this.nbTurn--;

        if( drawers != null){
            game.setDrawer(Drawer.whoDraw(drawers));
        }

    }

    public void startNewRound(Game game){
        if (game != null){
            game.startARound("");
        }
    }
}
