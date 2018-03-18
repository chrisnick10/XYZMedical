/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xyzmedical.controller;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONArray;
import xyzmedical.model.Patient;
import static xyzmedical.util.HttpConnection.HttpConnection;

import xyzmedical.db.Database;

/**
 *
 * @author cjwn
 */
public class PatientViewController {
    
    public static boolean isNewPatient(int U_ID) {
        ArrayList<Patient> patients = Database.searchPatients("P_ID", U_ID);
        if (patients.size() == 0) {
            return true;
        }
        return false;
    }
    
    public static Patient getPatientInformation(int U_ID) {
        Patient p = null;
        ArrayList<Patient> patients = Database.searchPatients("P_ID", U_ID);
        if (patients.size() > 0) {
            p = patients.get(0);
        }
        return p;
    }
    
    public static void payBalance(int U_ID) {
        
    }
}
