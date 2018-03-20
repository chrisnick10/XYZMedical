package xyzmedical.controller;

import xyzmedical.model.Patient;
import xyzmedical.model.Staff;
import xyzmedical.db.Database;

/**
 *
 * @author christian
 */
public class RegisterViewController {
    public static boolean registerStaff(Staff staff) {
        return Database.insertStaff(staff);
    }
    
    public static boolean registerPatient(Patient p) {
        return Database.insertPatient(p);
    }
}
