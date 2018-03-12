/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xyzmedical.controller;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONArray;
import static xyzmedical.utilities.HttpConnection.HttpConnection;

/**
 *
 * @author cjwn
 */
public class PatientViewController {
    
    public static boolean isNewPatient(int U_ID) {
        
        String uidQuery = "SELECT * FROM PATIENT WHERE U_ID = "+U_ID+";";
        try {
            String resultJSON = HttpConnection(uidQuery);
            JSONArray jsonArr = new JSONArray(resultJSON);
            
            if (jsonArr.length() > 0) {
                System.out.println("not new patient");
                return false;
            } else {
                System.out.println("new patient. need info.");
                return true;
            }
            
        } catch (Exception ex) {
            Logger.getLogger(PatientViewController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}
