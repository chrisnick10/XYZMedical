package xyzmedical.controller;

import java.util.ArrayList;

import xyzmedical.model.Staff;
import xyzmedical.model.Person;
import xyzmedical.db.Database;
/**
 *
 * @author christian
 */
public class LoginViewController {
    private static Person userPerson;
    
    public LoginViewController() {
        userPerson = null;
    }
    
    public static boolean login(String userName, String userPassword) {
        userPerson = Database.login(userName, userPassword);
        return userPerson != null;
    }
    
    public static boolean isUserStaff() {
        return Database.staffExists(userPerson.getID());
    }
    
    public static boolean isUserPatient() {
        return Database.patientExists(userPerson.getID());
    }
    
    public static int userID() {
        return userPerson.getID();
    }
}
