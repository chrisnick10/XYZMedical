/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xyzmedical.controller;

import java.sql.Timestamp;
import xyzmedical.db.Database;
import xyzmedical.model.Appointment;

/**
 *
 * @author nhine
 */
public class AppointmentViewController {
    public static boolean schedule(int ID, int staffID, int patientID, 
                String reason, String summary, Timestamp time) {
        Appointment appt = new Appointment(ID, staffID, patientID, reason, 
            summary, time);
        return Database.insertAppt(appt);
    }
}
