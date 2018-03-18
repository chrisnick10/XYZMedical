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
import static xyzmedical.util.HttpConnection.HttpConnection;

/**
 *
 * @author nhine
 */
public class AppointmentViewController {
    
    public static boolean schedule(String apptDate, String apptDoctor, String apptPatient, String apptReason) {
         
        String appointmentQuery = "SELECT DATE, S_ID FROM APPOINTMENTS;";
        String resultString;
        
        try {
            // get json result string
            resultString = HttpConnection(appointmentQuery);
            
            // convert json string to json array and create list array
            JSONArray jsonArr = new JSONArray(resultString);
            List<String> dateList = new ArrayList<String>();
            List<String> doctorList = new ArrayList<String>();
            
            String doctorIdQuery = "SELECT S_ID FROM STAFF WHERE SFName = '"+apptDoctor+"'";
            String patientIdQuery = "SELECT P_ID FROM PATIENT WHERE PFNAME = '"+apptPatient+"'";
            int docId = Integer.parseInt(HttpConnection(doctorIdQuery).substring(10,11));
            int patientId = Integer.parseInt(HttpConnection(patientIdQuery).substring(10,11));
            
            for (int i = 0; i < jsonArr.length(); i++) {
                dateList.add(jsonArr.getJSONObject(i).getString("DATE"));
                doctorList.add(jsonArr.getJSONObject(i).getString("S_ID"));
            }
            
            for (String d: dateList) {
                if (d.equals(apptDate)) {
                    for(String s: doctorList){
                        if(Integer.parseInt(s) == docId){
                            return false;
                        }
                    }
           } else {
                    String insertQuery = "INSERT INTO APPOINTMENTS(S_ID, P_ID, REASON, DATE, SUMMARY) VALUES("+docId+", "+patientId+", '"+apptReason+"', '"+apptDate+"', '')";
                    HttpConnection(insertQuery);
                    return true;
                }
           }
        }
        catch (Exception ex) {
            Logger.getLogger(RegisterViewController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }
    
    public static String[] getDoctorList(){
        
        try {
            String doctorListQuery = "SELECT SLName, SFName FROM STAFF WHERE AccessLevel = 1";
            String doctorList = HttpConnection(doctorListQuery);
            JSONArray jsonArr = new JSONArray(doctorList);
            System.out.println(doctorList);
            String[] retList = {};
            return retList;
        } catch (Exception ex) {
            Logger.getLogger(AppointmentViewController.class.getName()).log(Level.SEVERE, null, ex);
            String[] retList = {};
            return retList;
        }
    }
    
}
