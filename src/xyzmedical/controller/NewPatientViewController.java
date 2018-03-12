/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xyzmedical.controller;

import java.util.logging.Level;
import java.util.logging.Logger;
import static xyzmedical.utilities.HttpConnection.HttpConnection;

/**
 *
 * @author cjwn
 */
public class NewPatientViewController {
    
    public static void insertNewPatient(String fName, String lName, String dob, String email, String phone, String insurance, int U_ID) {
        String insertQuery = String.format("INSERT INTO PATIENT (P_ID,PLNAME,PFNAME,DOB,EMAIL,PHONE,INSURANCE,BALANCE,U_ID)VALUES (NULL,'%s','%s','%s',"
                + "'%s','%s','%s','%d','%d');", lName,fName,dob,email,phone,insurance,0,U_ID);
        
        try {
            String resultString = HttpConnection(insertQuery);
            System.out.println(insertQuery);
        } catch (Exception ex) {
            Logger.getLogger(NewPatientViewController.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        
    }
}
