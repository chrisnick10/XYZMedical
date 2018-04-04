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
    
    public static List<String> getDoctorList(){
        
        try {
            String doctorListQuery = "SELECT SLName, SFName FROM STAFF WHERE AccessLevel = 1";
            String doctorList = HttpConnection(doctorListQuery);
            JSONArray jsonArr = new JSONArray(doctorList);
            List<String> docList = new ArrayList<String>();
            
            for (int i = 0; i < jsonArr.length(); i++) {
                docList.add(jsonArr.getJSONObject(i).getString("SFName") + jsonArr.getJSONObject(i).getString("SLName"));
            }
            
            return docList;
        } catch (Exception ex) {
            Logger.getLogger(AppointmentViewController.class.getName()).log(Level.SEVERE, null, ex);
            List<String> docList = new ArrayList<String>();
            return docList;
        }
    }
    
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
    
    public static List<String> getAppointmentList(){
        try {
            String apptListQuery = "SELECT TOP 5 DATE FROM APPOINTMENTS";
            String apptList = HttpConnection(apptListQuery);
            JSONArray jsonArr = new JSONArray(apptList);
            List<String> aList = new ArrayList<String>();
            
            for (int i = 0; i < jsonArr.length(); i++) {
                String name = jsonArr.getJSONObject(i).getString("DATE");
                aList.add(name);
            }
            
            return aList;
        } catch (Exception ex) {
            Logger.getLogger(AppointmentViewController.class.getName()).log(Level.SEVERE, null, ex);
            List<String> pList = new ArrayList<String>();
            return pList;
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
