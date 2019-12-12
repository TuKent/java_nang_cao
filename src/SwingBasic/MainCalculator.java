package SwingBasic;

import javax.swing.*;
import java.awt.*;

public class MainCalculator {
    public static void main (String[] args)
    {
        //Tạo 1 OOP cửa sổ
        JFrame frame = new JFrame();

        frame.setContentPane(new Calculator().getRootPanel());
        //Đặt tiêu đề cho cửa sổ
        frame.setTitle("Frame Demo");

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        //Kích thước của sổ
        frame.setPreferredSize(new Dimension(300,200));

        //Đưa ra giữa màn hình
        frame.setLocationRelativeTo(null);

        //Điều chỉnh lại kích thước
        frame.pack();

        //Hiển thị cửa sổ
        frame.setVisible(true);

    }
}
