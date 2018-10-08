import java.awt.*;
import java.awt.event.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import javax.swing.*;

public class DCF extends JFrame {

    private JTextField GrowthRateTf;
    private JTextField DiscountRateTF;
    private JTextField TerminalGrowthRateTF;
    private JTextField EPSTF;
    private JTextField GrowthYearsTF;
    private JTextField TerminalGrowthYearsTF;
    private JButton computeValueJB;
    private JLabel outputLabel;
    private JPanel outputPanel;

    public DCF() {
        setTitle("DCF Calculator");
        setSize(1000, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel mainPanel = new JPanel();

        GrowthRateTf = new JTextField(6);
        DiscountRateTF = new JTextField(6);
        TerminalGrowthRateTF = new JTextField(6);
        EPSTF = new JTextField(6);
        GrowthYearsTF = new JTextField(6);
        TerminalGrowthYearsTF = new JTextField(6);

        ImageIcon icon = new ImageIcon("Val.png");
        JLabel iconLabel = new JLabel("DCF Calculator", icon, SwingConstants.CENTER);
        iconLabel.setFont(new Font("SansSerif", Font.BOLD, 36));
        mainPanel.add(iconLabel);

        mainPanel.add(new JLabel("Expected Growth Rate:"));
        mainPanel.add(GrowthRateTf);
        mainPanel.add(new JLabel("WACC:"));
        mainPanel.add(DiscountRateTF);
        mainPanel.add(new JLabel("Terminal Growth Rate:"));
        mainPanel.add(TerminalGrowthRateTF);
        mainPanel.add(new JLabel("Earnings Per Share:"));
        mainPanel.add(EPSTF);
        mainPanel.add(new JLabel("Years of Growth under Growth Rate:"));
        mainPanel.add(GrowthYearsTF);
        mainPanel.add(new JLabel("Years in terminal growth:"));
        mainPanel.add(TerminalGrowthYearsTF);

        computeValueJB = new JButton("Compute Value");

        computeValueJB.addActionListener(new ValuationButtonListener());

        mainPanel.add(computeValueJB);

        outputPanel = new JPanel();
        outputLabel = new JLabel("Enter values above, and click a button");
        outputPanel.add(outputLabel);
        outputPanel.setBackground(Color.yellow);

        add(mainPanel, BorderLayout.CENTER);
        add(outputPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

    private class ValuationButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            double growthRate = Double.parseDouble(GrowthRateTf.getText());
            double discountRate = Double.parseDouble(DiscountRateTF.getText());
            double terminalGrowthRate = Double.parseDouble(TerminalGrowthRateTF.getText());
            int growthOverYears = Integer.parseInt(GrowthYearsTF.getText());
            int terminalGrowthOverYears = Integer.parseInt(TerminalGrowthYearsTF.getText());

            float EPS = Float.parseFloat(EPSTF.getText());

            double Val = computeValue(EPS, growthRate, discountRate, terminalGrowthRate, growthOverYears, terminalGrowthOverYears);


            String output = String.format("Total interest paid: $1.2d", Val);
            outputLabel.setText(output);

        }

        public double computeValue(float EPShare, double growth, double discount, double terminal, int year, int tyear) {
            // TODO Auto-generated method stub
            double A = (1 + growth) / (1 + discount);
            double B = (1 + terminal) / (1 + discount);
            int expA = (int) Math.pow(A, year);
            int expB = (int) Math.pow(B, tyear);

            double growthValue = EPShare * A * (1 - expA) / (1 - A);
            double terminalValue = EPShare * expA * B * (1 - expB) / (1 - B);
            double answer = growthValue + terminalValue;
            return answer;
        }


    }
}
 