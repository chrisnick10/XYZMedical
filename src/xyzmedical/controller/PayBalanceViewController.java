/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xyzmedical.controller;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONArray;
import xyzmedical.model.Patient;
import static xyzmedical.utilities.HttpConnection.HttpConnection;

/**
 *
 * @author nickolaou
 */
public class PayBalanceViewController {
    public static Patient getPatientInformation(int U_ID) {
        Patient p = null;
        
        String selectQuery = "Select * FROM PATIENT WHERE U_ID="+U_ID+";";
        try {
            String resultString = HttpConnection(selectQuery);
            JSONArray jsonArr = new JSONArray(resultString);
            p = new Patient(jsonArr.getJSONObject(0));
        } catch (Exception ex) {
            Logger.getLogger(PayBalanceViewController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return p;
    }
    
    public static void payBalance(int u_id, double amount) {
        
        Double oldBalance = Double.parseDouble(getPatientInformation(u_id).getP_balance());
        Double newBalance = oldBalance - amount;
        
        System.out.println("Old Balance: "+oldBalance);
        System.out.println("New Balance: "+newBalance);
        String updateQuery = "UPDATE PATIENT SET BALANCE="+newBalance+" WHERE U_ID="+u_id+";";
        try {
            String resultString = HttpConnection(updateQuery);
        } catch (Exception ex) {
            Logger.getLogger(PayBalanceViewController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
