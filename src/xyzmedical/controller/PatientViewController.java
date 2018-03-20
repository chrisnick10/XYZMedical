package xyzmedical.controller;

import java.util.ArrayList;
import xyzmedical.model.Patient;

import xyzmedical.db.Database;

/**
 *
 * @author cjwn
 */
public class PatientViewController {
    
    public static boolean isNewPatient(int U_ID) {
        return Database.patientExists(U_ID);
    }
    
    public static Patient getPatientInformation(int U_ID) {
        ArrayList<Patient> patients = Database.searchPatients("ID", U_ID);
        if (patients.size() == 1) {
            return patients.get(0);
        }
        return null;
    }

    public static boolean payBalance(int U_ID) {
        return true;
    }
}
