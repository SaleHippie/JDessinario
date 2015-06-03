package joly.tpi.jdessinario;

import java.util.ArrayList;

/**
 * Created by jolyma on 03.06.2015.
 */
public class GameControl {
    ArrayList<Team> guessTeamColor;
    Team redTeam = new Team();
    Team blueTeam = new Team();

    public void initializeGame(int nbTurn, String mode){
        Game game = new Game();
        ArrayList<String> drawers = null;

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

        game.setNbTurn(nbTurn);

        if( drawers != null){
            game.setDrawer(Drawer.whoDraw(drawers));
        }

    }
}
