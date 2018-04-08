/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xyzmedical.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.lang.Integer;
import org.json.JSONArray;
import static xyzmedical.utilities.HttpConnection.HttpConnection;
/**
 *
 * @author nhine
 */
public class PrescriptionViewController {
    
    public static JSONArray getMedicationList(){
        try {
            String apptListQuery = "SELECT * FROM MEDICATION2";
            
            JSONArray jsonArr = new JSONArray(HttpConnection(apptListQuery));
            
            return jsonArr;
        } catch (Exception ex) {
            Logger.getLogger(AppointmentViewController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    
    public static JSONArray getPatientList(){
        try {
            String apptListQuery = "SELECT * FROM PATIENT";
            
            JSONArray jsonArr = new JSONArray(HttpConnection(apptListQuery));
            System.out.println(jsonArr.toString());
            return jsonArr;
        } catch (Exception ex) {
            Logger.getLogger(AppointmentViewController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }


        public static void enterPrescriptionInfo(int s_id, int p_id, int m_id, int dosage) {
        
        try {
         
            String insertQ = String.format("INSERT INTO PRESCRIPTIONS(`Rx_ID`, `S_ID`, `P_ID`, `M_ID`, `DOSAGE`) VALUES (NULL, '%d', '%d', '%d', '%d');",
                    s_id, p_id, m_id, dosage);
            System.out.println(insertQ);
            System.out.println(HttpConnection(insertQ));
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
