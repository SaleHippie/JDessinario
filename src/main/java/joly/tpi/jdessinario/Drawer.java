package joly.tpi.jdessinario;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by jolyma on 29.05.2015.
 */
public class Drawer {
    public String drawer;

    public String getDrawer() {
        return drawer;
    }

    public void setDrawer(String drawer) {
        this.drawer = drawer;
    }

    public String whoDraw(ArrayList<String> drawers){
        Random rand = new Random();

        int index = rand.nextInt(drawers.size());
        this.drawer = drawers.get(index);

        //TODO return the new player list
        return this.drawer;
    }
}
