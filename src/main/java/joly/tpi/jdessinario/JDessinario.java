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
    public static boolean firstClientServer = true;
    public static ServerThread thread;

    private static Team redTeam = new Team();
    private Team blueTeam = new Team();

    public static void main(String[] args) throws IOException, InterruptedException {

        //set the user's nickname
        Login login = new Login();
        login.setVisible(true);
        nickname = login.nickname.getText();

        //if it's the first client Set it and initialize the gam
        if( isFirst()){
            int i = 0;
            InitializeGameForm newGame = null;

            while(newGame == null || (i<=0 || i % 2 != 0 )){
                newGame = new InitializeGameForm();
                openInitializeGameForm(newGame);

                i= (int) newGame.nbTurn.getValue();
                int x = i%2;
            }

            GameControl gameControl = new GameControl();

          //  gameControl.setNbTurn((int) newGame.nbTurn.getValue());
        }

        //Open the window
        window = new ClientForm();
        window.setVisible(true);

        //Run the netty's thread
        client.run();

    }

    private static void openInitializeGameForm(InitializeGameForm gameForm) {
        gameForm.pack();
        gameForm.setVisible(true);
    }

    private static boolean isFirst() {
            //TODO check if there already are a server. if not launch the server and return true
         thread = new ServerThread();
        // Server server = new Server(8000);
        //TODO run it in new thread

        thread.start();
        synchronized (thread) {
            try {
                thread.wait(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        //  server.run();

        System.out.println(firstClientServer);
        return firstClientServer;
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

    /************************************
     * Summary :    relay the answers to the view(window)
     * Name :       showAnswerReceived()
     * Param :      msg : String contain the answers
     * Return :     -
     **************************************/
    public void showAnswerReceived(String msg) {
        window.writeAnswer(msg);
    }

    /************************************
     * Summary :    Send the string to the server
     * Name :       sendMessage()
     * Param :      msg : String contain the message to send
     * Return :     -
     **************************************/
    public static void sendMessage(String msg){
        Package chat = new Package();

        chat.setText("[" + nickname + "] " + msg);
        chat.setCategories(CategoriesPackage.
                CHAT);

        client.channel.writeAndFlush(chat);
    }

    /************************************
     * Summary :    Send the string to the server
     * Name :       sendAnswer()
     * Param :      msg : String contain the message to send
     * Return :     -
     **************************************/
    public static void sendAnswer(String msg){
        Package answer = new Package();

        answer.setCategories(CategoriesPackage.ANSWER);
        answer.setText(msg);

        client.channel.writeAndFlush(answer);
    }

    /************************************
     * Summary :    Send the string to the server
     * Name :       sendDraw()
     * Param :      x : Float contain the coordinated to send
     *              y : Float contain the coordinated to send
     *              mode : String the drawing mode to new trace or not
     * Return :     -
     **************************************/
    public static void sendDraw(float x, float y, String mode){
        Package draw = new Package();

        draw.setCategories(CategoriesPackage.DRAW);
        draw.setX(x);
        draw.setY(y);
        draw.setMode(mode);

        client.channel.writeAndFlush(draw);
    }

    public static void sendGame(Game game){
        Package pck = new Package();

        pck.setCategories(CategoriesPackage.DRAW);
        pck.setGame(game);

        client.channel.writeAndFlush(pck);
    }

    public static void showReceivedGame(Game game){
        //TODO start a new round with the game
    }

    /************************************
     * Summary :    Exit the application
     * Name :       exit()
     * Param :      -
     * Return :     -
     **************************************/
    public static void exit(){
        client.exitChannel = true;
    }

    /************************************
     * @Summary :    relay the draw to the view(window)
     * @Name :       showDrawReceived()
     * @Param :      x : Float contain the coordinated to send
     *               y : Float contain the coordinated to send
     *               mode : String the drawing mode to new trace or not
     * @Return :     -
     **************************************/
    public void showDrawReceived(float x, float y, String mode) {
        window.drawReceived(x,y,mode);
    }

    public static void showResult() {

    }

    private void initializeTeam(){

    }

    public static void showWordToDraw(String word){
        window.showTheWordToDraw(word);
    }
}
