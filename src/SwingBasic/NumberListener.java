package SwingBasic;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NumberListener implements ActionListener {
    private String mNumber;
    private JTextField mTextFiled;

    public NumberListener(String mNumber, JTextField mTextFiled) {
        this.mNumber = mNumber;
        this.mTextFiled = mTextFiled;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String value = mTextFiled.getText();
        value += mNumber;
        mTextFiled.setText(value);
    }
}
