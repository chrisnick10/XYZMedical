/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xyzmedical.view;

import xyzmedical.controller.PatientViewController;
import xyzmedical.controller.StaffViewController;

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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        staffLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        staffLabel.setText("Staff Portal");

        scheduleButton.setText("Schedule Appointment");
        scheduleButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                scheduleButtonActionPerformed(evt);
            }
        });

        cancelButton.setText("Cancel Appointment");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        restockMed.setText("Restock Medication");
        restockMed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                restockMedActionPerformed(evt);
            }
        });

        enterStaffInfoButton.setText("Enter Staff Information");
        enterStaffInfoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enterStaffInfoButtonActionPerformed(evt);
            }
        });

        chargePatientButton.setText("Charge Patient Account");
        chargePatientButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chargePatientButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(restockMed, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(staffLabel, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(scheduleButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cancelButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(enterStaffInfoButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(chargePatientButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(245, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(staffLabel)
                .addGap(18, 18, 18)
                .addComponent(scheduleButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cancelButton)
                .addGap(43, 43, 43)
                .addComponent(restockMed)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(enterStaffInfoButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(chargePatientButton)
                .addContainerGap(50, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void scheduleButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_scheduleButtonActionPerformed
        // TODO add your handling code here:
        this.dispose();
        AppointmentView av = new AppointmentView();
        av.setVisible(true);
    }//GEN-LAST:event_scheduleButtonActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        // TODO add your handling code here:
        this.dispose();
        CancelView cv = new CancelView();
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
    private javax.swing.JButton restockMed;
    private javax.swing.JButton scheduleButton;
    private javax.swing.JLabel staffLabel;
    // End of variables declaration//GEN-END:variables
}
