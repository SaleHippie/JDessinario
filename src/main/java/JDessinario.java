import java.io.IOException;

/**
 * ETML
 * Author : Matthieu Joly
 * Date : 08.05.2015.
 * Summary :  main class for all run.
 */


public class JDessinario {

    private static Client client = new Client("localhost",8000);
    private static ClientForm window;
    private static String nickname;

    public static void main(String[] args) throws IOException, InterruptedException {

        //set the user's nickname
        nickname = "";

        //Open the window
        window = new ClientForm();
        window.setVisible(true);

        //Run the netty's thread
        client.run();
    }


    /************************************
     * Summary :    relay the message to the view(window)
     * Name :       showMessageReceived()
     * Param :      msg : String contain the messages
     * Return :     -
     **************************************/
    public void showMessageReceived(String msg) {
        window.writeChat(msg);
    }

    public void showAnswerReceived(String msg) {
        window.writeAnswer(msg);
    }

    /************************************
     * Summary :    Send the string to the server
     * Name :       send()
     * Param :      msg : String contain the message to send
     * Return :     -
     **************************************/
    public static void send(String msg){

        Categories chat = new Categories();

        chat.setText("[" + nickname + "] " + msg);
        chat.setCategories("chat");

        client.channel.writeAndFlush(chat);
    }

    public static void sendAnswer(String msg){
        Categories answer = new Categories();

        answer.setCategories("answer");
        answer.setText(msg);

        client.channel.writeAndFlush(answer);
    }

    public static void sendDraw(float x, float y, String mode){
        Categories draw = new Categories();

        draw.setCategories("draw");
        draw.setX(x);
        draw.setY(y);
        draw.setMode(mode);

        client.channel.writeAndFlush(draw);
    }

    public static void exit(){
        client.exitChannel = true;
    }

    public void showDrawReceived(float x, float y, String mode) {
        window.drawReceived(x,y,mode);
    }
}
