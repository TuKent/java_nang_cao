package DigialClock;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import static java.lang.Thread.sleep;

public class DigitalClock implements Runnable {

    private JPanel rootPanel;
    private JLabel lblTime;
    private JButton btnStopWatch;
    private JTabbedPane tabbedPane1;
    private JPanel PanelST;
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
    private JPanel PanelAC;
    private JLabel lblST;
    private JPanel PanelContentST;

    int hours = 0;
    int minutes = 0;
    int seconds = 0;

    public int millisecondsSW = 0;
    public int secondsSW = 0;
    public int minutesSW = 0;
    public int hoursSW = 0;

    boolean state = false;

    public DigitalClock() throws IOException, FontFormatException {

        String filename = ".\\resources\\font\\DIGITALDREAM.ttf";
        //SHOW TIME
        Font fontDC = Font.createFont(Font.TRUETYPE_FONT, new File(filename));
        //STOP WATCH
        Font HoursSW = Font.createFont(Font.TRUETYPE_FONT, new File(filename));
        Font MinutesSW = Font.createFont(Font.TRUETYPE_FONT, new File(filename));
        Font SecondsSW = Font.createFont(Font.TRUETYPE_FONT, new File(filename));
        Font MillisecondsSW = Font.createFont(Font.TRUETYPE_FONT, new File(filename));
        //ALARMS
        Font fontAL = Font.createFont(Font.TRUETYPE_FONT,new File(filename));


        //SHOW TIME
        fontDC = fontDC.deriveFont(Font.BOLD, 36);
        //STOP WATCH
        HoursSW = HoursSW.deriveFont(Font.BOLD, 36);
        MinutesSW = MinutesSW.deriveFont(Font.BOLD, 36);
        SecondsSW = SecondsSW.deriveFont(Font.BOLD, 36);
        MillisecondsSW = MillisecondsSW.deriveFont(Font.BOLD, 26);
        //ALARMS
        fontAL = fontAL.deriveFont(Font.BOLD, 12);


        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        //SHOW TIME
        ge.registerFont(fontDC);
        //STOP WATCH
        ge.registerFont(HoursSW);
        ge.registerFont(MinutesSW);
        ge.registerFont(SecondsSW);
        ge.registerFont(MillisecondsSW);
        //ALARMS
        ge.registerFont(fontAL);

        //SHOW TIME
        lblTime.setFont(fontDC);
        //STOP WATCH
        lblHoursSW.setFont(HoursSW);
        lblMinutesSW.setFont(MinutesSW);
        lblSecondsSW.setFont(SecondsSW);
        lblMillisecondsSF.setFont(MillisecondsSW);
        //ALARMS
        lblST.setFont(fontAL);
        Thread t = new Thread(this);
        t.start();

        lblMillisecondsSF.setText(" : " + millisecondsSW);
        lblSecondsSW.setText(" : " + secondsSW);
        lblMinutesSW.setText(": " + minutesSW);
        lblHoursSW.setText("" + hoursSW);

        PanelST.setBackground(Color.BLACK);
        lblTime.setForeground(Color.CYAN);

        PanelSWTop.setBackground(Color.BLACK);
        PanelSWCenter.setBackground(Color.BLACK);
        lblMillisecondsSF.setForeground(Color.CYAN);
        lblSecondsSW.setForeground(Color.CYAN);
        lblMinutesSW.setForeground(Color.CYAN);
        lblHoursSW.setForeground(Color.CYAN);

        lblST.setForeground(Color.CYAN);

        btnStartSW.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (state)
                {
                    return;
                }
                state = true;
                Thread thread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        while (true) {
                            if (state) {
                                try {

                                    if (millisecondsSW >= 99) {
                                        millisecondsSW = 0;
                                        secondsSW++;
                                    }
                                    if (secondsSW > 60) {
                                        millisecondsSW = 0;
                                        secondsSW = 0;
                                        minutesSW++;
                                    }
                                    if (minutesSW > 60) {
                                        millisecondsSW = 0;
                                        secondsSW = 0;
                                        minutesSW = 0;
                                        hoursSW++;
                                    }
                                    lblMillisecondsSF.setText(" : " + millisecondsSW);
                                    millisecondsSW++;
                                    sleep(10);
                                    lblSecondsSW.setText(" : " + secondsSW);
                                    lblMinutesSW.setText(": " + minutesSW);
                                    lblHoursSW.setText("" + hoursSW);

                                } catch (Exception e) {

                                }
                            } else {
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

                lblMillisecondsSF.setText(" : " + millisecondsSW);
                lblSecondsSW.setText(" : " + secondsSW);
                lblMinutesSW.setText(": " + minutesSW);
                lblHoursSW.setText("" + hoursSW);
            }
        });
        PanelAC.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                super.componentResized(e);
                Date date = new Date();
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
                lblST.setText(simpleDateFormat.format(date));

            }
        });
        lblST.addComponentListener(new ComponentAdapter() {
        });
    }

    public JPanel getRootPanel() {
        return rootPanel;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Calendar cal = Calendar.getInstance();
                hours = cal.get(Calendar.HOUR_OF_DAY);
                minutes = cal.get(Calendar.MINUTE);
                seconds = cal.get(Calendar.SECOND);

                lblTime.setText("" + hours + ":" + minutes + ":" + seconds);
                sleep(50);
            }
        } catch (Exception e) {
        }
    }
}

