/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xyzmedical.view;

import java.text.DecimalFormat;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import xyzmedical.controller.PatientViewController;
import xyzmedical.model.Patient;

/**
 *
 * @author nickolaou
 */
public class PatientView extends javax.swing.JFrame {
    
    private static int U_ID;
    /**
     * Creates new form PatientView
     */
    public PatientView(int uid) {
        U_ID = uid;
        initComponents();
        this.setLocationRelativeTo(null);
        enterPatientInfoButton.setVisible(false);
        if(PatientViewController.isNewPatient(U_ID)) {
            enterPatientInfoButton.setVisible(true);
        } else {
            //load patient data into view
            Patient p = PatientViewController.getPatientInformation(U_ID);
            
            patientNameLabel.setText("Name: "+p.getP_fname()+" "+p.getP_lname());
            patientDOBLabel.setText("D.O.B.: "+p.getP_dob());
            patientEmailLabel.setText("Email: "+p.getP_email());
            patientPhoneLabel.setText("Phone: "+p.getP_phone());
            patientInsuranceLabel.setText("Insurance: "+p.getP_insurace());
            
            DecimalFormat numberFormat = new DecimalFormat("#.00");
            
            patientBalanceLabel.setText("Account Balance: $"+numberFormat.format(Double.parseDouble(p.getP_balance())));
            
            
        }
        testresult_button.setVisible(PatientViewController.hasTests(U_ID));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        enterPatientInfoButton = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        patientNameLabel = new javax.swing.JLabel();
        patientDOBLabel = new javax.swing.JLabel();
        patientEmailLabel = new javax.swing.JLabel();
        patientPhoneLabel = new javax.swing.JLabel();
        patientInsuranceLabel = new javax.swing.JLabel();
        patientBalanceLabel = new javax.swing.JLabel();
        payBalanceButton = new javax.swing.JButton();
        testresult_button = new javax.swing.JButton();
        logoutButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 0, 51));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Patient");

        enterPatientInfoButton.setText("Enter Patient Information");
        enterPatientInfoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enterPatientInfoButtonActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Patient Information"));

        patientNameLabel.setText("Name:");

        patientDOBLabel.setText("D.O.B.:");

        patientEmailLabel.setText("Email");

        patientPhoneLabel.setText("Phone:");

        patientInsuranceLabel.setText("Insurance:");

        patientBalanceLabel.setText("Account Balance:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(patientNameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(patientDOBLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(patientEmailLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(patientPhoneLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(patientInsuranceLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(patientBalanceLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(patientNameLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(patientDOBLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(patientEmailLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(patientPhoneLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(patientInsuranceLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(patientBalanceLabel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        payBalanceButton.setText("Pay Balance");
        payBalanceButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                payBalanceButtonActionPerformed(evt);
            }
        });

        testresult_button.setText("Test Results");
        testresult_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                testresult_buttonActionPerformed(evt);
            }
        });

        logoutButton.setText("Logout");
        logoutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(enterPatientInfoButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(testresult_button)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(payBalanceButton))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(logoutButton)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(enterPatientInfoButton)
                    .addComponent(payBalanceButton)
                    .addComponent(testresult_button))
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(logoutButton)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void enterPatientInfoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enterPatientInfoButtonActionPerformed
        // TODO add your handling code here:
        this.dispose();
        NewPatientView newPView = new NewPatientView(U_ID);
        newPView.setVisible(true);
    }//GEN-LAST:event_enterPatientInfoButtonActionPerformed

    private void payBalanceButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_payBalanceButtonActionPerformed
        // TODO add your handling code here:
        this.dispose();
        PayBalanceView payBalView = new PayBalanceView(U_ID);
        payBalView.setVisible(true);
    }//GEN-LAST:event_payBalanceButtonActionPerformed

    private void testresult_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_testresult_buttonActionPerformed
        // TODO add your handling code here:
        TestResultsView tResultView = new TestResultsView(U_ID);
        tResultView.setVisible(true);
        
        this.dispose();
    }//GEN-LAST:event_testresult_buttonActionPerformed

    private void logoutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutButtonActionPerformed
        // TODO add your handling code here:
        
        this.dispose();
        LoginView lView = new LoginView();
        lView.setVisible(true);
    }//GEN-LAST:event_logoutButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PatientView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PatientView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PatientView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PatientView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PatientView(U_ID).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton enterPatientInfoButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton logoutButton;
    private javax.swing.JLabel patientBalanceLabel;
    private javax.swing.JLabel patientDOBLabel;
    private javax.swing.JLabel patientEmailLabel;
    private javax.swing.JLabel patientInsuranceLabel;
    private javax.swing.JLabel patientNameLabel;
    private javax.swing.JLabel patientPhoneLabel;
    private javax.swing.JButton payBalanceButton;
    private javax.swing.JButton testresult_button;
    // End of variables declaration//GEN-END:variables
}
