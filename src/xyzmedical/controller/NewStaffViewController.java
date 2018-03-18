/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xyzmedical.controller;

import java.util.logging.Level;
import java.util.logging.Logger;
import static xyzmedical.util.HttpConnection.HttpConnection;

/**
 *
 * @author samar
 */
public class NewStaffViewController {
    
    public static void insertNewPatient(String fName, String lName, String doh, int sType,int U_ID) {
        String insertQuery = String.format("INSERT INTO STAFF (S_ID,SLName,SFName,AccessLevel,DOH,U_ID)VALUES (NULL,'%s','%s','%d',"
                + "'%s','%d');", lName,fName,sType,doh,U_ID);
        
        try {
            String resultString = HttpConnection(insertQuery);
            System.out.println(insertQuery);
        } catch (Exception ex) {
            Logger.getLogger(NewPatientViewController.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        
    }
}
