import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by jolyma on 08.05.2015.
 */
public class Client extends JFrame{
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

    public Client() {
        super();

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
                //TODO implements it on network
                answerLabel.setText(answerLabel.getText() + " " + txtAnswer.getText());

                // Clear the answer text
                txtAnswer.setText(null);
            }
        });

        /***********************************************
         * ActionListener btnSend
         * Send the message to other clients and write it in chatMessagePane
         ***********************************************/
        btnSend.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
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
        });

        //TODO shrink left part of JSplitPane when it can
    }
}
