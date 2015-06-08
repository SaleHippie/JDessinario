package joly.tpi.jdessinario;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InitializeGameForm extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    public JComboBox modeList;
    public JSpinner nbTurn;

    public InitializeGameForm() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });
    }

    private void onOK() {
// add your code here
        dispose();
    }
}
