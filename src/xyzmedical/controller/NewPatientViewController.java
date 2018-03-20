package xyzmedical.controller;

import java.sql.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import xyzmedical.model.Patient;
import static xyzmedical.util.HttpConnection.HttpConnection;

/**
 *
 * @author cjwn
 */
public class NewPatientViewController {
    
    public static void insertNewPatient(int ID, String firstName, 
            String lastName, String username, String password, 
            int primaryCareProvider, float balance, String email, 
            String phoneNum, String insurance, Date birthDate) {
        
        Patient p = new Patient(ID, firstName, lastName, username, password, 
                primaryCareProvider, balance, email, phoneNum, insurance, 
                birthDate);
    }
}
