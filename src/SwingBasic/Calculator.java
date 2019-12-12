package SwingBasic;

import javax.swing.*;

public class Calculator {
    private JPanel rootPanel;
    private JTextField textField1;
    private JButton btn9;
    private JButton btn8;
    private JButton btn0;
    private JButton btnDot;
    private JButton btnDel;
    private JButton btn4;
    private JButton btn5;
    private JButton btn6;
    private JButton btn1;
    private JButton btn2;
    private JButton btn3;
    private JButton btn7;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;

    public Calculator()
    {
        btn0.addActionListener(new NumberListener("0",textField1));
        btn1.addActionListener(new NumberListener("1",textField1));
        btn2.addActionListener(new NumberListener("2",textField1));
        btn3.addActionListener(new NumberListener("3",textField1));
        btn4.addActionListener(new NumberListener("4",textField1));
        btn5.addActionListener(new NumberListener("5",textField1));
        btn6.addActionListener(new NumberListener("6",textField1));
        btn7.addActionListener(new NumberListener("7",textField1));
        btn8.addActionListener(new NumberListener("8",textField1));
        btn9.addActionListener(new NumberListener("9",textField1));
    }

    public JPanel getRootPanel()
    {
        return rootPanel;
    }


}
