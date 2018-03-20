package xyzmedical.controller;

import java.util.ArrayList;

import xyzmedical.model.Staff;
import xyzmedical.model.Patient;
import xyzmedical.db.Database;
/**
 *
 * @author christian
 */
public class LoginViewController {
    public static int login(String userName, String userPassword) {
        ArrayList<Staff> staffList = Database.searchStaff("USERNAME", userName);
        ArrayList<Patient> patientList = Database.searchPatients("USERNAME", userName);

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
        ArrayList<Staff> staffList = Database.searchStaff("USERNAME", uname);
        for (Staff staffMember : staffList) {
            if (staffMember.getUsername().equals(uname)) {
                return staffMember.getID();
            }
        }
        
        ArrayList<Patient> patientList = Database.searchPatients("USERNAME", uname);
        for (Patient patient : patientList) {
            if (patient.getUsername().equals(uname)) {
                return patient.getID();
            }
        }
        return -1;
    }
}
