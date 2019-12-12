package DigialClock;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.io.File;
import java.io.IOException;
import java.util.Calendar;

import static java.lang.Thread.sleep;

public class DigitalClock implements Runnable{
    private JPanel rootPanel;
    private JLabel lblTime;
    private JButton btnStopWatch;
    private JTabbedPane tabbedPane1;
    private JPanel FiledClock;
    private JPanel PanelSW;
    private JButton btnStartSW;
    private JButton btnStopSW;
    private JPanel PanelSWMain;
    private JPanel PanelSWTop;
    private JPanel PanelSWCenter;
    public JLabel lblHoursSW;
    public JLabel lblMinutesSW;
    public JLabel lblSecondsSW;
    public JLabel lblMillisecondsSF;
    private JButton btnReset;

    int hours=0;
    int minutes=0;
    int seconds=0;

    public int millisecondsSW = 0;
    public int secondsSW = 0;
    public int minutesSW = 0;
    public int hoursSW = 0;

    static boolean state = true;





    public DigitalClock() throws IOException, FontFormatException {
        String filename = "E:\\java_nang_cao\\resources\\font\\DIGITALDREAM.ttf";

        Font fontST = Font.createFont(Font.TRUETYPE_FONT, new File(filename));

        Font HoursSW = Font.createFont(Font.TRUETYPE_FONT, new File(filename));
        Font MinutesSW = Font.createFont(Font.TRUETYPE_FONT, new File(filename));
        Font SecondsSW = Font.createFont(Font.TRUETYPE_FONT, new File(filename));
        Font MillisecondsSW = Font.createFont(Font.TRUETYPE_FONT, new File(filename));


        fontST = fontST.deriveFont(Font.BOLD, 36);

        HoursSW = HoursSW.deriveFont(Font.BOLD,36);
        MinutesSW = MinutesSW.deriveFont(Font.BOLD,36);
        SecondsSW = SecondsSW.deriveFont(Font.BOLD,36);
        MillisecondsSW = MillisecondsSW.deriveFont(Font.BOLD,26);


        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        //DIGITAL CLOCK
        ge.registerFont(fontST);
        //STOP WATCH
        ge.registerFont(HoursSW);
        ge.registerFont(MinutesSW);
        ge.registerFont(SecondsSW);
        ge.registerFont(MillisecondsSW);



        lblTime.setFont(fontST);

        lblHoursSW.setFont(HoursSW);
        lblMinutesSW.setFont(MinutesSW);
        lblSecondsSW.setFont(SecondsSW);
        lblMillisecondsSF.setFont(MillisecondsSW);

        Thread t = new Thread(this);
        t.start();

        lblMillisecondsSF.setText(" : "+millisecondsSW);
        lblSecondsSW.setText(" : "+secondsSW);
        lblMinutesSW.setText(": "+minutesSW);
        lblHoursSW.setText(""+hoursSW);



        FiledClock.setBackground(Color.BLACK);
        lblTime.setForeground(Color.CYAN);

        tabbedPane1.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                super.componentResized(e);
                PanelSWTop.setBackground(Color.yellow);
                PanelSWCenter.setBackground(Color.BLACK);
                lblMillisecondsSF.setForeground(Color.CYAN);
                lblSecondsSW.setForeground(Color.CYAN);
                lblMinutesSW.setForeground(Color.CYAN);
                lblHoursSW.setForeground(Color.CYAN);
            }
        });



        btnStartSW.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                state = true;
                Thread thread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        while (true)
                        {
                            if (state == true)
                            {
                                try
                                {
                                    sleep(1);
                                    if (millisecondsSW > 1000)
                                    {
                                        millisecondsSW  = 0;
                                        secondsSW ++;
                                    }
                                    if (secondsSW > 60)
                                    {
                                        millisecondsSW = 0;
                                        secondsSW = 0;
                                        minutesSW ++;
                                    }
                                    if (minutesSW > 60)
                                    {
                                        millisecondsSW = 0;
                                        secondsSW = 0;
                                        minutesSW = 0;
                                        hoursSW ++;
                                    }
                                    lblMillisecondsSF.setText(" : "+millisecondsSW);
                                    millisecondsSW++;
                                    lblSecondsSW.setText(" : "+secondsSW);
                                    lblMinutesSW.setText(": "+minutesSW);
                                    lblHoursSW.setText(""+hoursSW);

                                }catch (Exception e)
                                {

                                }
                            }
                            else
                            {
                                break;
                            }
                        }
                    }
                });
                thread.start();
            }
        });
        btnStopSW.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                state = false;

            }
        });
        btnReset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                state = false;
                millisecondsSW = 0;
                secondsSW = 0;
                minutesSW = 0;
                hoursSW = 0;

                lblMillisecondsSF.setText(" : "+millisecondsSW);
                lblSecondsSW.setText(" : "+secondsSW);
                lblMinutesSW.setText(": "+minutesSW);
                lblHoursSW.setText(""+hoursSW);


            }
        });

    }

    public JPanel getRootPanel() {
        return rootPanel;
    }


    @Override
    public void run() {
        try
        {
            while (true)
            {
                Calendar cal = Calendar.getInstance();
                hours = cal.get(Calendar.HOUR_OF_DAY);
                minutes = cal.get(Calendar.MINUTE);
                seconds = cal.get(Calendar.SECOND);

                lblTime.setText("" + hours + ":" + minutes +":"+seconds);
            }
        }
        catch (Exception e)
        {}
    }
}

