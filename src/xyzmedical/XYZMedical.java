/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xyzmedical;

import xyzmedical.view.LoginView;

import java.util.Date;
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
            Date dob = new Date(1988, 8, 11);
            Patient p = new Patient(456, "William", "Williamson", 0.0, "wwilliamson@gmail.com", "810", "6547891", "BCBS", "wwilliamson", "wwilliamsonpassword", dob);
            
            System.out.println(Database.insertPatient(p));
            int n = 3;
            if (n == 3) {
                return;
            }
            // This is the entry point for the application.
            LoginView view = new LoginView();
            view.setVisible(true);
    }
}
