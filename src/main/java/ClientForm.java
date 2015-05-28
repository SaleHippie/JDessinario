import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * ETML
 * Author : Matthieu Joly
 * Date : 08.05.2015.
 * Summary :  main class for all run.
 */
public class ClientForm extends JFrame{
    private JPanel panelContainer;

    // Left part (game)
    private JEditorPane drawPane;
    private JTextField txtAnswer;
    private JButton btnAnswer;
    private JPanel panelAnswer;
    private JPanel panelDraw;
    private JLabel answerLabel;

    //Right part (chat)
    private JTextPane chatMessagePane;
    private JTextArea messageText;
    private JButton btnSend;

    private JPanel panelChat;
    private JPanel panelMessage;

    private boolean shiftPressed;
    private ScribbleDragAndDrop drawable = new ScribbleDragAndDrop();
    public ClientForm() {
        super();

        panelDraw.add(drawable);

        setContentPane(panelContainer);
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

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
     * Summary :    send the messages in chat
     * Name :       sendChat()
     * Param :      -
     * Return :     -
     **************************************/
    private void sendChat(){

        //Write th message in this client
        writeChat(messageText.getText());
        //Send the message to the other clients
        JDessinario.send(messageText.getText());

        // Clear the message text
        messageText.setText(null);
    }

    /************************************
     * Summary :    send the answer and try to win
     * Name :       sendAnswer()
     * Param :      -
     * Return :     -
     **************************************/
    private void sendAnswer(){
        //Write the answer in this client
        writeAnswer(txtAnswer.getText());
        //Send the answer to the other clients
        JDessinario.sendAnswer(txtAnswer.getText());

        // Clear the answer text
        txtAnswer.setText(null);
    }

    /************************************
     * Summary :    write the answer in the Label
     * Name :       writeAnswer()
     * Param :      -
     * Return :     -
     **************************************/
    public void writeAnswer(String answer){
        answerLabel.setText(answerLabel.getText() + " " + answer);
    }

    /************************************
     * Summary :    write the messages in chat
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

    public void drawReceived(float x, float y,String mode){
        switch (mode){
            case "new":
                drawable.drawReceived(x,y);
                break;
            case "follow":
                drawable.followDraw(x,y);
                break;

            default:
                break;
        }


    }
}
