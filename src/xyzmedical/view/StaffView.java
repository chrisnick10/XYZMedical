/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xyzmedical.view;

import xyzmedical.controller.PatientViewController;
import xyzmedical.controller.StaffViewController;
import xyzmedical.model.Staff;

/**
 *
 * @author nickolaou
 */
public class StaffView extends javax.swing.JFrame {

    private static int P_ID;
    /**
     * Creates new form StaffView
     */
    public StaffView(int p_id) {
        P_ID = p_id;
        initComponents();
        this.setLocationRelativeTo(null);
        enterStaffInfoButton.setVisible(
                StaffViewController.isNewStaff(P_ID)
        );
        enter_test_results.setVisible(
                StaffViewController.isLabTech(p_id)
        );
        
        if (!StaffViewController.isNewStaff(P_ID)) {
            Staff s = StaffViewController.getStaffInformation(P_ID);
            loginLabel.setText("Logggd in as: "+s.getLast_name()+", "+s.getFirst_name());
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        staffLabel = new javax.swing.JLabel();
        scheduleButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        restockMed = new javax.swing.JButton();
        enterStaffInfoButton = new javax.swing.JButton();
        chargePatientButton = new javax.swing.JButton();
        logoutButton = new javax.swing.JButton();
        enter_test_results = new javax.swing.JButton();
        prescribeButton = new javax.swing.JButton();
        loginLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        staffLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        staffLabel.setForeground(new java.awt.Color(204, 0, 51));
        staffLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        staffLabel.setText("Staff Portal");

        scheduleButton.setForeground(new java.awt.Color(204, 0, 51));
        scheduleButton.setText("Schedule Appointment");
        scheduleButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                scheduleButtonActionPerformed(evt);
            }
        });

        cancelButton.setForeground(new java.awt.Color(204, 0, 51));
        cancelButton.setText("Cancel Appointment");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        restockMed.setForeground(new java.awt.Color(204, 0, 51));
        restockMed.setText("Restock Medication");
        restockMed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                restockMedActionPerformed(evt);
            }
        });

        enterStaffInfoButton.setForeground(new java.awt.Color(204, 0, 51));
        enterStaffInfoButton.setText("Enter Staff Information");
        enterStaffInfoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enterStaffInfoButtonActionPerformed(evt);
            }
        });

        chargePatientButton.setForeground(new java.awt.Color(204, 0, 51));
        chargePatientButton.setText("Charge Patient Account");
        chargePatientButton.setPreferredSize(new java.awt.Dimension(185, 29));
        chargePatientButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chargePatientButtonActionPerformed(evt);
            }
        });

        logoutButton.setForeground(new java.awt.Color(204, 0, 51));
        logoutButton.setText("Logout");
        logoutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutButtonActionPerformed(evt);
            }
        });

        enter_test_results.setForeground(new java.awt.Color(204, 0, 51));
        enter_test_results.setText("Enter Test Results");
        enter_test_results.setMaximumSize(new java.awt.Dimension(185, 29));
        enter_test_results.setMinimumSize(new java.awt.Dimension(185, 29));
        enter_test_results.setPreferredSize(new java.awt.Dimension(185, 29));
        enter_test_results.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enter_test_resultsActionPerformed(evt);
            }
        });

        prescribeButton.setForeground(new java.awt.Color(204, 0, 51));
        prescribeButton.setText("Prescribe Medication");
        prescribeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prescribeButtonActionPerformed(evt);
            }
        });

        loginLabel.setText("Logged in as:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(staffLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(loginLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(logoutButton))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(scheduleButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cancelButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(prescribeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(chargePatientButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(enterStaffInfoButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(restockMed, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(enter_test_results, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(staffLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(loginLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(scheduleButton)
                    .addComponent(restockMed))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancelButton)
                    .addComponent(enterStaffInfoButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(prescribeButton)
                    .addComponent(chargePatientButton, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(enter_test_results, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addComponent(logoutButton))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void scheduleButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_scheduleButtonActionPerformed
        // TODO add your handling code here:
        this.dispose();
        AppointmentView av = new AppointmentView(P_ID);
        av.setVisible(true);
    }//GEN-LAST:event_scheduleButtonActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        // TODO add your handling code here:
        this.dispose();
        CancelView cv = new CancelView(P_ID);
        cv.setVisible(true);
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void restockMedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_restockMedActionPerformed
        // TODO add your handling code here:
        this.dispose();
        MedicationRestockView mRestock = new MedicationRestockView(P_ID);
        mRestock.setVisible(true);
    }//GEN-LAST:event_restockMedActionPerformed

    private void enterStaffInfoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enterStaffInfoButtonActionPerformed
        // TODO add your handling code here:
        this.dispose();
        NewStaffView newSView = new NewStaffView(P_ID);
        newSView.setVisible(true);
    }//GEN-LAST:event_enterStaffInfoButtonActionPerformed

    private void chargePatientButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chargePatientButtonActionPerformed
        // TODO add your handling code here:
        this.dispose();
        ChargePatientView view = new ChargePatientView(P_ID);
        view.setVisible(true);
    }//GEN-LAST:event_chargePatientButtonActionPerformed

    private void logoutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutButtonActionPerformed
        // TODO add your handling code here:
        this.dispose();
        LoginView lView = new LoginView();
        lView.setVisible(true);
    }//GEN-LAST:event_logoutButtonActionPerformed

    private void enter_test_resultsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enter_test_resultsActionPerformed
        // TODO add your handling code here:
        this.dispose();
        EnterTestResultsView view = new EnterTestResultsView(P_ID);
        view.setVisible(true);
    }//GEN-LAST:event_enter_test_resultsActionPerformed

    private void prescribeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prescribeButtonActionPerformed
        // TODO add your handling code here:
        this.dispose();
        PrescriptionView view = new PrescriptionView(P_ID);
        view.setVisible(true);
    }//GEN-LAST:event_prescribeButtonActionPerformed

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
            java.util.logging.Logger.getLogger(StaffView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StaffView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StaffView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StaffView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StaffView(P_ID).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelButton;
    private javax.swing.JButton chargePatientButton;
    private javax.swing.JButton enterStaffInfoButton;
    private javax.swing.JButton enter_test_results;
    private javax.swing.JLabel loginLabel;
    private javax.swing.JButton logoutButton;
    private javax.swing.JButton prescribeButton;
    private javax.swing.JButton restockMed;
    private javax.swing.JButton scheduleButton;
    private javax.swing.JLabel staffLabel;
    // End of variables declaration//GEN-END:variables
}
