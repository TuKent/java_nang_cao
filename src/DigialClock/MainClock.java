package DigialClock;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class MainClock {
    public static void main(String[] args) throws IOException, FontFormatException {
        //Create door OOP
        JFrame jFrame = new JFrame();

        jFrame.setContentPane(new DigitalClock().getRootPanel());

        jFrame.setTitle("Digital Clock ");

        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        //Kích thước của sổ
        jFrame.setPreferredSize(new Dimension(450, 150));

        //Đưa ra giữa màn hình
        jFrame.setLocationRelativeTo(null);

        //Điều chỉnh lại kích thước
        jFrame.pack();

        //Hiển thị cửa sổ
        jFrame.setVisible(true);
    }
}
