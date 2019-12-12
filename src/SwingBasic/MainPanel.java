package SwingBasic;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainPanel {
    private JPanel rootPanel;
    private JLabel txtContent;
    private JButton btnSave;
    private JTextField txtFileName;
    private JButton btnBrowse;

    public MainPanel() {
        btnSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        btnBrowse.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fc = new JFileChooser();
                int returnValue = fc.showOpenDialog(null);
                if ( returnValue == JFileChooser.APPROVE_OPTION)
                {
                    String path  = fc.getSelectedFile().getAbsolutePath();
                    txtFileName.setText(path);
                }
            }
        });
    }
    public static void saveFile(String filename, byte[] data) throws IOException {

        FileOutputStream fos = new FileOutputStream(filename);
        fos.write(data);
        fos.close();
    }
    public JPanel getRootPanel()
    {
        return rootPanel;
    }
}
