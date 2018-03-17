/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xyzmedical.controller;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONArray;
import xyzmedical.model.Staff;
import static xyzmedical.utilities.HttpConnection.HttpConnection;

/**
 *
 * @author cjwn
 */
public class StaffViewController {
    
    
    public static boolean isNewStaff(int U_ID) {
        
        String uidQuery = "SELECT * FROM STAFF WHERE U_ID = "+U_ID+";";
        try {
            String resultJSON = HttpConnection(uidQuery);
            JSONArray jsonArr = new JSONArray(resultJSON);
            
            if (jsonArr.length() > 0) {
                System.out.println("not new Staff");
                return false;
            } else {
                System.out.println("new staff. need info.");
                return true;
            }
            
        } catch (Exception ex) {
            Logger.getLogger(PatientViewController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public static Staff getStaffInformation(int U_ID) {
        Staff s = null;
        
        String selectQuery = "Select * FROM STAFF WHERE U_ID="+U_ID+";";
        try {
            String resultString = HttpConnection(selectQuery);
            JSONArray jsonArr = new JSONArray(resultString);
            s = new Staff(jsonArr.getJSONObject(0));
        } catch (Exception ex) {
            Logger.getLogger(PatientViewController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return s;
    }
}
