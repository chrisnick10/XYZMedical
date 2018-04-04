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
    public static List<String> getPatientList(){
        
        try {
            String patientListQuery = "SELECT PFNAME, PLNAME FROM PATIENT";
            String patientList = HttpConnection(patientListQuery);
            JSONArray jsonArr = new JSONArray(patientList);
            List<String> pList = new ArrayList<String>();
            
            for (int i = 0; i < jsonArr.length(); i++) {
                String name = jsonArr.getJSONObject(i).getString("PFNAME") + " " + jsonArr.getJSONObject(i).getString("PLNAME");
                pList.add(name);
            }
            
            return pList;
        } catch (Exception ex) {
            Logger.getLogger(AppointmentViewController.class.getName()).log(Level.SEVERE, null, ex);
            List<String> pList = new ArrayList<String>();
            return pList;
        }
    }
    
    public static int getPatientId(String patientName){
        
        try {
            String fName = patientName.substring(0, patientName.indexOf(" "));
            
            String patientIdQuery = "SELECT P_ID FROM PATIENT WHERE PFNAME = '" + fName + "'";
            String patientList = HttpConnection(patientIdQuery);
            JSONArray jsonArr = new JSONArray(patientList); 
            
            return Integer.parseInt(jsonArr.getJSONObject(0).getString("P_ID"));
        } catch (Exception ex) {
            return 0;
        }
    }
    
    public static List<String> getMedicationList(){
        try {
            String apptListQuery = "SELECT MedicationName FROM MEDICATION";
            String apptList = HttpConnection(apptListQuery);
            JSONArray jsonArr = new JSONArray(apptList);
            List<String> aList = new ArrayList<String>();
            
            for (int i = 0; i < jsonArr.length(); i++) {
                String name = jsonArr.getJSONObject(i).getString("MedicationName");
                aList.add(name);
            }
            
            return aList;
        } catch (Exception ex) {
            Logger.getLogger(AppointmentViewController.class.getName()).log(Level.SEVERE, null, ex);
            List<String> pList = new ArrayList<String>();
            return pList;
        }
    }    
}
