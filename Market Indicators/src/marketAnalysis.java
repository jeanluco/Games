import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class marketAnalysis {

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
        {
            // TODO Auto-generated method stub
            //jfilechooser
            String x;
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            JFrame window = new JFrame("Equity Analysis");
            JPanel topPanel = new JPanel();
            final JButton openFileChooser = new JButton("Choose .csv File");
            window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            final JFileChooser fc = new JFileChooser();
            openFileChooser.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {

                    fc.setCurrentDirectory(new java.io.File("user.home"));
                    fc.setDialogTitle("This is a JFileChooser");
                    fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
                    if (fc.showOpenDialog(openFileChooser) == JFileChooser.APPROVE_OPTION) {
                        JOptionPane.showMessageDialog(null, fc.getSelectedFile().getAbsolutePath());
                        x = fc.getSelectedFile().getAbsolutePath();
                    }
                }
            });
            window.add(BorderLayout.NORTH, topPanel);
            topPanel.add(openFileChooser);
            window.setSize(500, 500);
            window.setVisible(true);
            window.setLocationRelativeTo(null);

            FileReader r = new FileReader();
            r.getFile(x);
            r.convertToArray();
            Formulas f = new Formulas();
            f.createDataArray(r.getArray());
            f.printArray();
            f.SMA();
            f.arroonUp();
            f.arroonDown();
            f.rateOfChange();
            f.RSI();
            create array for all above numbers
            print array as strings with name of indicator before each Int

                outputPanel = new JPanel();
            outputLabel = new JLabel("Enter values above, and click a button");
            outputPanel.add(outputLabel);
            outputPanel.setBackground(Color.yellow);
            add(outputPanel, BorderLayout.SOUTH);

            setVisible(true);

        }

    }
