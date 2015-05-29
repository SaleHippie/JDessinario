package joly.tpi.jdessinario;

/**
 * ETML
 * Author : Matthieu Joly
 * Date : 28.05.2015.
 * Summary :  Parameter of user
 */
public class Gamer {

    public String nickname;
    public boolean modeDraw;
    public Team team;

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public boolean isModeDraw() {
        return modeDraw;
    }

    public void setModeDraw(boolean modeDraw) {
        this.modeDraw = modeDraw;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }
}
