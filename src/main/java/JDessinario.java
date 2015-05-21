import java.io.IOException;

/**
 * ETML
 * Author : Matthieu Joly
 * Date : 08.05.2015.
 * Summary :  main class for all run.
 */


public class JDessinario {
    private static ClientForm window;
    private static Client client = new Client("localhost",8000);
    private static String nickname;

    public static void main(String[] args) throws IOException, InterruptedException {
        window = new ClientForm();
        window.setVisible(true);
        client.run();
    }

    public void showMessageReceived(String msg) {
        window.writeChat(msg);
    }

    public static void send(String msg){

        client.channel.writeAndFlush("[" + nickname + "] " + msg + "\r\n");
    }
}
