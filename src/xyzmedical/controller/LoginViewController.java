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
import org.json.JSONArray;
import static xyzmedical.util.HttpConnection.HttpConnection;

import xyzmedical.model.Staff;
import xyzmedical.model.Patient;
import xyzmedical.util.Util;
import xyzmedical.db.Database;
/**
 *
 * @author christian
 */
public class LoginViewController {
    public static int login(String userName, String userPassword) {
        ArrayList<Staff> staffList = Database.searchStaff("USERNAME", Util.sqlStringValue(userName));
        ArrayList<Patient> patientList = Database.searchPatients("USERNAME", Util.sqlStringValue(userName));

        if (staffList.size() == 0 && patientList.size() == 0) {
            return -1;
        }
        
        for (Staff staffMember : staffList) {
            if (staffMember.passwordMatches(userPassword)) {
                return staffMember.getAccessLevel();
            }
        }
        
        for (Patient patient : patientList) {
            if (patient.passwordMatches(userPassword)) {
                return 0;
            }
        }
        return 88;
    }
    
    public static int getUID(String uname) {
        ArrayList<Staff> staffList = Database.searchStaff("USERNAME", Util.sqlStringValue(uname));
        for (Staff staffMember : staffList) {
            if (staffMember.getUsername().equals(uname)) {
                return staffMember.getID();
            }
        }
        
        ArrayList<Patient> patientList = Database.searchPatients("USERNAME", Util.sqlStringValue(uname));
        for (Patient patient : patientList) {
            if (patient.getUsername().equals(uname)) {
                return patient.getID();
            }
        }
        return -1;
    }
}
