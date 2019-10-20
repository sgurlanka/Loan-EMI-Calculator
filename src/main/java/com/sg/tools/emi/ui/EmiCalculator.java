package com.sg.tools.emi.ui;

import com.sg.tools.emi.svc.EmiComputation;
import java.text.DecimalFormat;
import javax.swing.UIManager;
import java.util.logging.Logger;
import java.util.regex.Pattern;

/**
 *
 * @author suraj
 */
public class EmiCalculator extends javax.swing.JFrame {
    private javax.swing.JButton jButtonSubmit;
    private javax.swing.JComboBox<String> jComboBoxTerm;
    private javax.swing.JLabel jLabelEMI;
    private javax.swing.JLabel jLabelEMIResult;
    private javax.swing.JLabel jLabelErrorMsg;
    private javax.swing.JLabel jLabelHeader;
    private javax.swing.JLabel jLabelInterest;
    private javax.swing.JLabel jLabelPrincipal;
    private javax.swing.JLabel jLabelTerm;
    private javax.swing.JLabel jLabelTotalAmout;
    private javax.swing.JLabel jLabelTotalAmoutResult;
    private javax.swing.JLabel jLabelTotalInterest;
    private javax.swing.JLabel jLabelTotalInterestResult;
    private javax.swing.JPanel jPanelInput;
    private javax.swing.JPanel jPanelOutPut;
    private javax.swing.JTextField jTextFielPrincipal;
    private javax.swing.JTextField jTextFieldInterest;
    private javax.swing.JTextField jTextFieldTerm;
	
    /**
     * Creates new form EmiCalculator
     */
    public EmiCalculator() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
        jPanelInput = new javax.swing.JPanel();
        jLabelPrincipal = new javax.swing.JLabel();
        jTextFielPrincipal = new javax.swing.JTextField();
        jLabelInterest = new javax.swing.JLabel();
        jTextFieldInterest = new javax.swing.JTextField();
        jLabelTerm = new javax.swing.JLabel();
        jTextFieldTerm = new javax.swing.JTextField();
        jComboBoxTerm = new javax.swing.JComboBox<>();
        jButtonSubmit = new javax.swing.JButton();
        jLabelErrorMsg = new javax.swing.JLabel();
        jLabelHeader = new javax.swing.JLabel();
        jPanelOutPut = new javax.swing.JPanel();
        jLabelEMI = new javax.swing.JLabel();
        jLabelEMIResult = new javax.swing.JLabel();
        jLabelTotalInterest = new javax.swing.JLabel();
        jLabelTotalInterestResult = new javax.swing.JLabel();
        jLabelTotalAmout = new javax.swing.JLabel();
        jLabelTotalAmoutResult = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Loan EMI Calculator");
        setIconImage(getIconImage());
        setResizable(false);

        jPanelInput.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Principal-Interest-Term", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 13))); 

        jLabelPrincipal.setText("Principal Amount");

        jLabelInterest.setText("Rate of interest (%)");

        jLabelTerm.setText("Loan Term");

        jComboBoxTerm.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Years", "Months" }));

        jButtonSubmit.setFont(new java.awt.Font("Tahoma", 1, 13)); 
        jButtonSubmit.setText("Calculate EMI");
        jButtonSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSubmitActionPerformed(evt);
            }
        });

        jLabelErrorMsg.setFont(new java.awt.Font("Tahoma", 2, 13)); 
        jLabelErrorMsg.setForeground(new java.awt.Color(255, 51, 51));
        jLabelErrorMsg.setText("Please enter valid inputs");
        jLabelErrorMsg.setVisible(false);

        javax.swing.GroupLayout jPanelInputLayout = new javax.swing.GroupLayout(jPanelInput);
        jPanelInput.setLayout(jPanelInputLayout);
        jPanelInputLayout.setHorizontalGroup(
            jPanelInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelInputLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanelInputLayout.createSequentialGroup()
                        .addGroup(jPanelInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelPrincipal)
                            .addComponent(jLabelTerm))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanelInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFielPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldTerm, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29)
                        .addGroup(jPanelInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelInterest)
                            .addComponent(jComboBoxTerm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanelInputLayout.createSequentialGroup()
                        .addComponent(jLabelErrorMsg, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(46, 46, 46)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonSubmit)
                    .addComponent(jTextFieldInterest, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelInputLayout.setVerticalGroup(
            jPanelInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelInputLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelPrincipal)
                    .addComponent(jTextFielPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelInterest)
                    .addComponent(jTextFieldInterest, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelTerm)
                    .addComponent(jTextFieldTerm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxTerm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonSubmit))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelErrorMsg)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabelHeader.setFont(new java.awt.Font("Tahoma", 1, 14)); 
        jLabelHeader.setText("EMI Calculator for Home/Car/Personal Loans");

        jPanelOutPut.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "EMI", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 13))); 

        jLabelEMI.setText("Monthly EMI: ");

        jLabelEMIResult.setFont(new java.awt.Font("Tahoma", 1, 13)); 
        jLabelEMIResult.setText("<Result>");

        jLabelTotalInterest.setText("Total Interest Payable:");

        jLabelTotalInterestResult.setFont(new java.awt.Font("Tahoma", 1, 13)); 
        jLabelTotalInterestResult.setText("<Result>");

        jLabelTotalAmout.setText("Total Payment (Principal + Interest): ");

        jLabelTotalAmoutResult.setFont(new java.awt.Font("Tahoma", 1, 13)); 
        jLabelTotalAmoutResult.setText("<Result>");

        javax.swing.GroupLayout jPanelOutPutLayout = new javax.swing.GroupLayout(jPanelOutPut);
        jPanelOutPut.setLayout(jPanelOutPutLayout);
        jPanelOutPutLayout.setHorizontalGroup(
            jPanelOutPutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelOutPutLayout.createSequentialGroup()
                .addGap(78, 78, 78)
                .addGroup(jPanelOutPutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelTotalInterest)
                    .addComponent(jLabelEMI)
                    .addComponent(jLabelTotalAmout))
                .addGap(18, 18, 18)
                .addGroup(jPanelOutPutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelTotalInterestResult)
                    .addComponent(jLabelTotalAmoutResult)
                    .addComponent(jLabelEMIResult))
                .addContainerGap(67, Short.MAX_VALUE))
        );
        jPanelOutPutLayout.setVerticalGroup(
            jPanelOutPutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelOutPutLayout.createSequentialGroup()
                .addGroup(jPanelOutPutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelEMI)
                    .addComponent(jLabelEMIResult, javax.swing.GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE))
                .addGap(10, 10, 10)
                .addGroup(jPanelOutPutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelTotalInterest)
                    .addComponent(jLabelTotalInterestResult))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelOutPutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelTotalAmout)
                    .addComponent(jLabelTotalAmoutResult))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanelInput, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(153, 153, 153)
                        .addComponent(jLabelHeader)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanelOutPut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(87, 87, 87))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelHeader)
                .addGap(18, 18, 18)
                .addComponent(jPanelInput, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelOutPut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        pack();
    }

    private void jButtonSubmitActionPerformed(java.awt.event.ActionEvent evt) {
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

            final long emi = EmiComputation.monthlyEmi(Double.valueOf(this.jTextFielPrincipal.getText()), Double.valueOf(this.jTextFieldInterest.getText()), Long.valueOf(this.jTextFieldTerm.getText()), isTimeInYears);

            this.jLabelEMIResult.setText(new DecimalFormat("##,##,##,###").format(emi));

            final long totalInterestPayable = EmiComputation.totalInterestPayable(Double.valueOf(this.jTextFielPrincipal.getText()), emi, Long.valueOf(this.jTextFieldTerm.getText()), isTimeInYears);

            this.jLabelTotalInterestResult.setText(new DecimalFormat("##,##,##,###").format(totalInterestPayable));

            final long totalPayment = EmiComputation.totalPayment(emi, Long.valueOf(this.jTextFieldTerm.getText()), isTimeInYears);

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
                 * javax.swing.UIManager.setLookAndFeel(info.getClassName());
                 * break; }
                 */

                if ("Windows".contains(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(EmiCalculator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(EmiCalculator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(EmiCalculator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            Logger.getLogger(EmiCalculator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EmiCalculator().setVisible(true);
            }
        });
    }
}
