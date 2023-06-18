package com.sg.tools.emi.ui;

import com.sg.tools.emi.svc.EmiComputation;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.text.DecimalFormat;
import java.util.logging.Level;
import javax.swing.UIManager;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.WindowConstants;
import javax.swing.border.TitledBorder;

/**
 *
 * @author suraj
 */
public class EmiCalculator extends JFrame {
    private JButton jButtonSubmit;
    private JComboBox<String> jComboBoxTerm;
    private JLabel jLabelEMI;
    private JLabel jLabelEMIResult;
    private JLabel jLabelErrorMsg;
    private JLabel jLabelHeader;
    private JLabel jLabelInterest;
    private JLabel jLabelPrincipal;
    private JLabel jLabelTerm;
    private JLabel jLabelTotalAmout;
    private JLabel jLabelTotalAmoutResult;
    private JLabel jLabelTotalInterest;
    private JLabel jLabelTotalInterestResult;
    private JPanel jPanelInput;
    private JPanel jPanelOutPut;
    private JTextField jTextFielPrincipal;
    private JTextField jTextFieldInterest;
    private JTextField jTextFieldTerm;
	
    /**
     * Creates new form EmiCalculator
     */
    public EmiCalculator() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
        jPanelInput = new JPanel();
        jLabelPrincipal = new JLabel();
        jTextFielPrincipal = new JTextField();
        jLabelInterest = new JLabel();
        jTextFieldInterest = new JTextField();
        jLabelTerm = new JLabel();
        jTextFieldTerm = new JTextField();
        jComboBoxTerm = new JComboBox<>();
        jButtonSubmit = new JButton();
        jLabelErrorMsg = new JLabel();
        jLabelHeader = new JLabel();
        jPanelOutPut = new JPanel();
        jLabelEMI = new JLabel();
        jLabelEMIResult = new JLabel();
        jLabelTotalInterest = new JLabel();
        jLabelTotalInterestResult = new JLabel();
        jLabelTotalAmout = new JLabel();
        jLabelTotalAmoutResult = new JLabel();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Loan EMI Calculator");
        setIconImage(getIconImage());
        setResizable(false);

        jPanelInput.setBorder(BorderFactory.createTitledBorder(null, "Principal-Interest-Term", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font("Tahoma", 1, 13))); 

        jLabelPrincipal.setText("Principal Amount");

        jLabelInterest.setText("Rate of interest (%)");

        jLabelTerm.setText("Loan Term");

        jComboBoxTerm.setModel(new DefaultComboBoxModel<>(new String[] { "Years", "Months" }));

        jButtonSubmit.setFont(new Font("Tahoma", 1, 13)); 
        jButtonSubmit.setText("Calculate EMI");
        jButtonSubmit.addActionListener((ActionEvent evt) -> {
            jButtonSubmitActionPerformed();
        });

        jLabelErrorMsg.setFont(new Font("Tahoma", 2, 13)); 
        jLabelErrorMsg.setForeground(new Color(255, 51, 51));
        jLabelErrorMsg.setText("Please enter valid inputs");
        jLabelErrorMsg.setVisible(false);

        GroupLayout jPanelInputLayout = new GroupLayout(jPanelInput);
        jPanelInput.setLayout(jPanelInputLayout);
        jPanelInputLayout.setHorizontalGroup(
            jPanelInputLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanelInputLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelInputLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanelInputLayout.createSequentialGroup()
                        .addGroup(jPanelInputLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelPrincipal)
                            .addComponent(jLabelTerm))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanelInputLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFielPrincipal, GroupLayout.PREFERRED_SIZE, 157, GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldTerm, GroupLayout.PREFERRED_SIZE, 157, GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29)
                        .addGroup(jPanelInputLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelInterest)
                            .addComponent(jComboBoxTerm, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanelInputLayout.createSequentialGroup()
                        .addComponent(jLabelErrorMsg, GroupLayout.PREFERRED_SIZE, 167, GroupLayout.PREFERRED_SIZE)
                        .addGap(46, 46, 46)))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelInputLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonSubmit)
                    .addComponent(jTextFieldInterest, GroupLayout.PREFERRED_SIZE, 157, GroupLayout.PREFERRED_SIZE))
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelInputLayout.setVerticalGroup(
            jPanelInputLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanelInputLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelInputLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelPrincipal)
                    .addComponent(jTextFielPrincipal, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelInterest)
                    .addComponent(jTextFieldInterest, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelInputLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelTerm)
                    .addComponent(jTextFieldTerm, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxTerm, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonSubmit))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelErrorMsg)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabelHeader.setFont(new Font("Tahoma", 1, 14)); 
        jLabelHeader.setText("EMI Calculator for Home/Car/Personal Loans");

        jPanelOutPut.setBorder(BorderFactory.createTitledBorder(null, "EMI", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new Font("Tahoma", 1, 13))); 

        jLabelEMI.setText("Monthly EMI: ");

        jLabelEMIResult.setFont(new Font("Tahoma", 1, 13)); 
        jLabelEMIResult.setText("<Result>");

        jLabelTotalInterest.setText("Total Interest Payable:");

        jLabelTotalInterestResult.setFont(new Font("Tahoma", 1, 13)); 
        jLabelTotalInterestResult.setText("<Result>");

        jLabelTotalAmout.setText("Total Payment (Principal + Interest): ");

        jLabelTotalAmoutResult.setFont(new Font("Tahoma", 1, 13)); 
        jLabelTotalAmoutResult.setText("<Result>");

        GroupLayout jPanelOutPutLayout = new GroupLayout(jPanelOutPut);
        jPanelOutPut.setLayout(jPanelOutPutLayout);
        jPanelOutPutLayout.setHorizontalGroup(
            jPanelOutPutLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanelOutPutLayout.createSequentialGroup()
                .addGap(78, 78, 78)
                .addGroup(jPanelOutPutLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelTotalInterest)
                    .addComponent(jLabelEMI)
                    .addComponent(jLabelTotalAmout))
                .addGap(18, 18, 18)
                .addGroup(jPanelOutPutLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelTotalInterestResult)
                    .addComponent(jLabelTotalAmoutResult)
                    .addComponent(jLabelEMIResult))
                .addContainerGap(67, Short.MAX_VALUE))
        );
        jPanelOutPutLayout.setVerticalGroup(
            jPanelOutPutLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanelOutPutLayout.createSequentialGroup()
                .addGroup(jPanelOutPutLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelEMI)
                    .addComponent(jLabelEMIResult, GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE))
                .addGap(10, 10, 10)
                .addGroup(jPanelOutPutLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelTotalInterest)
                    .addComponent(jLabelTotalInterestResult))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelOutPutLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelTotalAmout)
                    .addComponent(jLabelTotalAmoutResult))
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanelInput, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(153, 153, 153)
                        .addComponent(jLabelHeader)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanelOutPut, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(87, 87, 87))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelHeader)
                .addGap(18, 18, 18)
                .addComponent(jPanelInput, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelOutPut, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        pack();
    }

    private void jButtonSubmitActionPerformed() {
        boolean isValid = true;

        if (!this.jTextFielPrincipal.getText().isEmpty()) {
            if (!Pattern.matches("\\d*.\\d*", this.jTextFielPrincipal.getText())) {
                this.jLabelErrorMsg.setVisible(true);
                isValid = false;
            }
        } else {
            this.jLabelErrorMsg.setVisible(true);
            isValid = false;
        }

        if (!this.jTextFieldInterest.getText().isEmpty()) {
            if (!Pattern.matches("\\d*.\\d*", this.jTextFieldInterest.getText())) {
                this.jLabelErrorMsg.setVisible(true);
                isValid = false;
            }
        } else {
            this.jLabelErrorMsg.setVisible(true);
            isValid = false;
        }

        if (!this.jTextFieldTerm.getText().isEmpty()) {
            if (!Pattern.matches("\\d*", this.jTextFieldTerm.getText())) {
                this.jLabelErrorMsg.setVisible(true);
                isValid = false;
            }
        } else {
            this.jLabelErrorMsg.setVisible(true);
            isValid = false;
        }

        if (isValid) {
            boolean isTimeInYears = false;

            if (this.jComboBoxTerm.getSelectedItem().toString().equals("Years")) {
                isTimeInYears = true;
            }

            final long emi = EmiComputation.monthlyEmi(Double.parseDouble(this.jTextFielPrincipal.getText()), Double.valueOf(this.jTextFieldInterest.getText()), Long.parseLong(this.jTextFieldTerm.getText()), isTimeInYears);

            this.jLabelEMIResult.setText(new DecimalFormat("##,##,##,###").format(emi));

            final long totalInterestPayable = EmiComputation.totalInterestPayable(Double.parseDouble(this.jTextFielPrincipal.getText()), emi, Long.parseLong(this.jTextFieldTerm.getText()), isTimeInYears);

            this.jLabelTotalInterestResult.setText(new DecimalFormat("##,##,##,###").format(totalInterestPayable));

            final long totalPayment = EmiComputation.totalPayment(emi, Long.parseLong(this.jTextFieldTerm.getText()), isTimeInYears);

            this.jLabelTotalAmoutResult.setText(new DecimalFormat("########").format(totalPayment));
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                /**
                 * if ("Nimbus".equals(info.getName())) {
                 * UIManager.setLookAndFeel(info.getClassName());
                 * break; }
                 */

                if ("Windows".contains(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            Logger.getLogger(EmiCalculator.class.getName()).log(Level.ALL.SEVERE, null, ex);
        }
        
        /* Create and display the form */
        EventQueue.invokeLater(() -> {
            new EmiCalculator().setVisible(true);
        });
    }
}
