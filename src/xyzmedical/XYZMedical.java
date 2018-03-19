/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xyzmedical;

import xyzmedical.view.LoginView;

import xyzmedical.model.*;
import java.sql.Timestamp;
import java.sql.Date;
import xyzmedical.db.Database;
import xyzmedical.model.Patient;
/**
 *
 * @author cjwn
 */
public class XYZMedical {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ClassNotFoundException {
            Patient patient = new Patient(12, "Mike", "Kubik", "mkubik", "password", 1, 0, "mkubik@oakland.edu", "7849578484", "UNITED", new Date(1996, 2, 14));
            System.out.println(Database.allPatients().size());
            //Database.insertPatient(patient);
            // This is the entry point for the application.
            //LoginView view = new LoginView();
            //view.setVisible(true);
    }
}
