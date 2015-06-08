package joly.tpi.jdessinario;

import java.io.IOException;

/**
 * Created by Sale Hippie on 07.06.2015.
 */
public class ClientThread extends Thread{

    public void run(Client client) throws IOException, InterruptedException {
        client.run();
    }
}
