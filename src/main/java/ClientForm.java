import javafx.embed.swing.JFXPanel;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * Created by jolyma on 08.05.2015.
 */
public class ClientForm extends JFrame{
    private JPanel panelContainer;
    private JEditorPane drawPane;
    private JTextField txtAnswer;
    private JButton btnAnswer;
    private JTextPane chatMessagePane;
    private JTextArea messageText;
    private JButton btnSend;
    private JPanel panelAnswer;
    private JPanel panelDraw;
    private JPanel panelChat;
    private JPanel panelMessage;
    private JLabel answerLabel;
    private JFXPanel drawing;

    public ClientForm() {
        super();

       /*drawing = new JFXPanel();
       panelDraw.add(drawing);*/

        panelDraw.add(new ScribbleDragAndDrop());

        setContentPane(panelContainer);
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        /*Platform.runLater(new Runnable() {
            @Override
            public void run() {
                initFX(drawing);
            }
        });*/

        /***********************************************
         * ActionListener btnAnswer
         * Send answer to other client and write it in answerLabel
         ***********************************************/
        btnAnswer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sendAnswer();
            }
        });

        /***********************************************
         * ActionListener btnSend
         * Send the message to other clients and write it in chatMessagePane
         ***********************************************/
        btnSend.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sendChat();
            }
        });

        //TODO shrink left part of JSplitPane when it can

        messageText.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);


                //Catch the enter to send message
                if( e.getKeyChar() == KeyEvent.VK_ENTER ){
                    //Consume the enter
                    messageText.setText(messageText.getText().substring(0,messageText.getText().length()-1));
                    sendChat();
                }
            }
        });
        txtAnswer.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);


                //Catch the enter to send answer
                if(e.getKeyChar() == KeyEvent.VK_ENTER ){
                    sendAnswer();
                }
            }
        });
    }

    private static void initFX(JFXPanel fxPanel){
        Scene scene = createScene();
        fxPanel.setScene(scene);
    }

    /*************************************
     *  Create a javaFx scene for draw
     *  @return : javafx.scene.Scene
     */
    private static Scene createScene() {
        Group root  =  new  Group();
        Scene  scene  =  new  Scene(root, Color.ALICEBLUE);
        Text text  =  new  Text();

        text.setX(40);
        text.setY(100);
        text.setFont(new Font(25));
        text.setText("Welcome JavaFX!");

        root.getChildren().add(text);

        return scene;
    }

    /************************************
     * Summury :    send the messages in chat
     * Name :       sendChat()
     * Param :      -
     * Return :     -
     **************************************/
    private void sendChat(){
        //TODO implements it on network

        // Get Document of the pane to write the message to the end of it
        // and add a return to separate message.
        Document doc = chatMessagePane.getDocument();
        String message = messageText.getText();
        try {
            doc.insertString(doc.getLength(), message + "\n", chatMessagePane.getStyle("default"));
        } catch (BadLocationException e1) {
            e1.printStackTrace();
        }

        // Clear the message text
        messageText.setText(null);
    }

    /************************************
     * Summury :    send the answer and try to win
     * Name :       sendAnswer()
     * Param :      -
     * Return :     -
     **************************************/
    private void sendAnswer(){
        //TODO implements it on network
        answerLabel.setText(answerLabel.getText() + " " + txtAnswer.getText());

        // Clear the answer text
        txtAnswer.setText(null);
    }
}
