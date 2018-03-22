/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xyzmedical.db;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
import xyzmedical.model.Appointment;
import xyzmedical.model.MedInfo;
import xyzmedical.model.Patient;
import xyzmedical.model.Prescription;
import xyzmedical.model.Staff;

/**
 *
 * @author Will
 */
class QueryRunner {
    private final static String DB_PATH = "http://76.230.142.194/csi3370/sql_query1.php?query=";
    
    // Query execution method
    static String execQuery(String query) {
        System.out.println(query);
        String result = "";
        String urlStr = DB_PATH + query;
        urlStr = urlStr.replaceAll(" ", "+");
        urlStr = urlStr.replaceAll("'", "%27");

        try {
            URL url = new URL(urlStr);
            URLConnection connection = url.openConnection();
            
            connection.setDoInput(true);
            connection.setDoOutput(true);
            connection.setAllowUserInteraction(false);
            
            BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            
            String ln = null;
            while ((ln = br.readLine()) != null) {
                result += ln;
            }
            
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    
    
    // Methods for retrieving raw JSON info from db
    static ArrayList<Appointment> apptQuery(String query) {
        ArrayList<Appointment> apptList = new ArrayList<>();
        try {
            JSONArray jsonArr = new JSONArray(execQuery(query));
            for (int i = 0; i < jsonArr.length(); ++i) {
                JSONObject obj = jsonArr.getJSONObject(i);
                Appointment appt = ModelFactory.createAppointment(obj);
                if (appt != null) {
                    apptList.add(appt);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return apptList;
    }
    
    static ArrayList<Patient> patientQuery(String query) {
        ArrayList<Patient> patientList = new ArrayList<>();
        try {
            JSONArray jsonArr = new JSONArray(execQuery(query));
            for (int i = 0; i < jsonArr.length(); ++i) {
                JSONObject obj = jsonArr.getJSONObject(i);
                Patient patient = ModelFactory.createPatient(obj);
                if (patient != null) {
                    patientList.add(patient);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return patientList;
    }
    
    static ArrayList<MedInfo> medinfoQuery(String query) {
        ArrayList<MedInfo> medinfoList = new ArrayList<>();
        try {
            JSONArray jsonArr = new JSONArray(execQuery(query));
            for (int i = 0; i < jsonArr.length(); ++i) {
                JSONObject obj = jsonArr.getJSONObject(i);
                MedInfo medinfo = ModelFactory.createMedInfo(obj);
                if (medinfo != null) {
                    medinfoList.add(medinfo);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return medinfoList;
    }
    
    static ArrayList<Prescription> prescriptionQuery(String query) {
        ArrayList<Prescription> prescriptionList = new ArrayList<>();
        try {
            JSONArray jsonArr = new JSONArray(QueryRunner.execQuery(query));
            for (int i = 0; i < jsonArr.length(); ++i) {
                JSONObject obj = jsonArr.getJSONObject(i);
                Prescription med = ModelFactory.createPrescription(obj);
                if (med != null) {
                    prescriptionList.add(med);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return prescriptionList;
    }
    
    static ArrayList<Staff> staffQuery(String query) {
        ArrayList<Staff> staffList = new ArrayList<>();
        try {
            JSONArray jsonArr = new JSONArray(QueryRunner.execQuery(query));
            for (int i = 0; i < jsonArr.length(); ++i) {
                JSONObject obj = jsonArr.getJSONObject(i);
                Staff staff = ModelFactory.createStaff(obj);
                if (staff != null) {
                    staffList.add(staff);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return staffList;
    }
}
