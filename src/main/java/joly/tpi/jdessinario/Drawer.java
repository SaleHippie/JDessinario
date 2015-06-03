package joly.tpi.jdessinario;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by jolyma on 29.05.2015.
 */
public class Drawer {
    public static String drawer;

    public String getDrawer() {
        return drawer;
    }

    public void setDrawer(String drawer) {
        this.drawer = drawer;
    }

    public static String whoDraw(ArrayList<String> drawers){
        Random rand = new Random();

        int index = rand.nextInt(drawers.size());
        drawer = drawers.get(index);

        //TODO return the player who need to draw
        return drawer;
    }
}
