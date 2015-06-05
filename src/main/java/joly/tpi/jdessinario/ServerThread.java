package joly.tpi.jdessinario;

import java.net.BindException;

/**
 * Created by jolyma on 05.06.2015.
 */
public class ServerThread extends Thread {

    public void run() {
        Server server = new Server(8000);

        try {
            server.run();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BindException e) {
            JDessinario.firstClientServer = false;
        }
        synchronized (this){
            notify();
        }


        //TODO process the error. Notify client and close it !

    }
}
