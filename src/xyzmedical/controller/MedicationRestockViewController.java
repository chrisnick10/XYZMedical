/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xyzmedical.controller;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import org.json.JSONObject;
import xyzmedical.utilities.HttpConnection;
import xyzmedical.view.MedicationRestockView;

/**
 *
 * @author samar
 */
public class MedicationRestockViewController {
 
    public static String getMedicationInfo() {
        
        try {
            
            return HttpConnection.HttpConnection("SELECT * FROM `MEDICATION2`");
            
        } catch(Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    
    public static void restockMeds(JSONObject jsonO, JFrame frame, int u_id) throws Exception {
        
        try {
            
            String s = (String) JOptionPane.showInputDialog(
                        null,
                        jsonO.getString("NAME"),
                        "Quantity",
                        JOptionPane.PLAIN_MESSAGE,
                        null,
                        null,
                        "");

            //UPDATE `CSI-3370`.`MEDICATION2` SET `QUANTITY` = '80' WHERE `MEDICATION2`.`M_ID` = 2;

            int currentQ = jsonO.getInt("QUANTITY");
            int totalQ = currentQ + Integer.valueOf(s);

            HttpConnection.HttpConnection("UPDATE `MEDICATION2` SET `QUANTITY` = '" + totalQ + "'"
                    + " WHERE `M_ID` = " + jsonO.getString("M_ID"));

            frame.dispose();
            MedicationRestockView mRestock = new MedicationRestockView(u_id);
            mRestock.setVisible(true);
        
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
