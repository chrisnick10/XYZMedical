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
import xyzmedical.utilities.HttpConnection;
import static xyzmedical.utilities.HttpConnection.HttpConnection;

/**
 *
 * @author nickolaou
 */
public class ChargePatientViewController {
    
    public static Patient getPatientInformationFromUsername(String userName) {
        Patient p = null;
        
        String selectQuery = "Select * FROM USER WHERE userName='"+userName+"';";
        try {
            String resultString = HttpConnection(selectQuery);
            JSONArray jsonArr = new JSONArray(resultString);
            
            int uid = Integer.parseInt(jsonArr.getJSONObject(0).getString("userID"));
            String patientQuery = "Select * FROM PATIENT WHERE U_ID="+uid+";";
            
            resultString = HttpConnection(patientQuery);
            jsonArr = new JSONArray(resultString);
            p = new Patient(jsonArr.getJSONObject(0));
            
        } catch (Exception ex) {
            Logger.getLogger(ChargePatientViewController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return p;
    }
    
    public static void chargePatient(Patient p, Double amount) {
        double newBalance = amount + Double.parseDouble(p.getP_balance());
        
        System.out.println("patient first name:"+p.getP_fname());
        System.out.println("Old balance:"+p.getP_balance());
        System.out.println("New balance:"+newBalance);
        
        String updateQuery = "UPDATE PATIENT SET BALANCE="+newBalance+" WHERE U_ID="+p.getP_uid()+";";
        try {
            String resultString = HttpConnection(updateQuery);
        } catch (Exception ex) {
            Logger.getLogger(ChargePatientViewController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
