import javafx.embed.swing.JFXPanel;

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
    private boolean shiftPressed;

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

            // TODO imolements Shift enter for return
             /*   Don't work now

             if( e.getKeyCode() == KeyEvent.VK_SHIFT ) {
                    switch (e.getID()){
                        case KeyEvent.KEY_PRESSED:
                            System.out.println("true");
                            shiftPressed = true;
                            break;
                        default:
                            shiftPressed = false;
                            System.out.println("false");
                            break;
                    }
                    System.out.println("Shift");
                }*/
               //

                //Catch the enter to send message
                if( e.getKeyChar() == KeyEvent.VK_ENTER ) {
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

    /************************************
     * Summury :    send the messages in chat
     * Name :       sendChat()
     * Param :      -
     * Return :     -
     **************************************/
    private void sendChat(){
        //TODO implements it on network

        //Write th message in this client
        writeChat(messageText.getText());
        //Send the message to the other clint
        JDessinario.send(messageText.getText());

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
        //Write the answer in this client
        writeAnswer(txtAnswer.getText());
        //Send the answer to the other clients
        //JDessinario.send(txtAnswer.getText());

        // Clear the answer text
        txtAnswer.setText(null);
    }

    /************************************
     * Summury :    write the answer in the Label
     * Name :       writeAnswer()
     * Param :      -
     * Return :     -
     **************************************/
    private void writeAnswer(String answer){
        answerLabel.setText(answerLabel.getText() + " " + answer);
    }

    /************************************
     * Summury :    write the messages in chat
     * Name :       writeChat()
     * Param :      -
     * Return :     -
     **************************************/
    public void writeChat(String msg){

        // Get Document of the pane to write the message to the end of it
        // and add a return to separate message.
        Document doc = chatMessagePane.getDocument();

        try {
            doc.insertString(doc.getLength(), msg + "\n", chatMessagePane.getStyle("default"));
        } catch (BadLocationException e1) {
            e1.printStackTrace();
        }
    }
}
