package joly.tpi.jdessinario;

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
        //TODO pop-up at the openning
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
     * Name :       sendMessage()
     * Param :      msg : String contain the message to sendMessage
     * Return :     -
     **************************************/
    public static void sendMessage(String msg){

        Package chat = new Package();

        chat.setText("[" + nickname + "] " + msg);
        chat.setCategories(CategoriesPackage.CHAT);

        client.channel.writeAndFlush(chat);
    }

    public static void sendAnswer(String msg){
        Package answer = new Package();

        answer.setCategories(CategoriesPackage.ANSWER);
        answer.setText(msg);

        client.channel.writeAndFlush(answer);
    }

    public static void sendDraw(float x, float y, String mode){
        Package draw = new Package();

        draw.setCategories(CategoriesPackage.DRAW);
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
