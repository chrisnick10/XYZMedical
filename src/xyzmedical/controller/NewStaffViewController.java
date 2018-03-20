/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xyzmedical.controller;

import java.sql.Date;
import xyzmedical.db.Database;
import xyzmedical.model.Staff;

/**
 *
 * @author samar
 */
public class NewStaffViewController {
    public static void insertNewPatient(int ID, int accessLevel, 
            String firstName, String lastName, String username, String password,
            Date birthDate, Date hireDate) {
        Staff staff = new Staff(ID, accessLevel, firstName, lastName, 
                username, password, birthDate, hireDate);
        Database.insertStaff(staff);
    }
}
