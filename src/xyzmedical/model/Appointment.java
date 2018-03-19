package xyzmedical.model;

import java.sql.Timestamp;

/**
 *
 * @author Will
 */
public class Appointment {
    private int ID;
    private int staffID;
    private int patientID;
    private String reason;
    private String summary;
    private Timestamp apptTime;
    
    public Appointment(int ID, int staffID, int patientID, String reason, String summary, Timestamp apptTime) {
        this.ID = ID;
        this.staffID = staffID;
        this.patientID = patientID;
        this.apptTime = apptTime;
        this.setReason(reason);
        this.setSummary(summary);
    }
    
    public int getID() {
        return this.ID;
    }
    
    public int getStaffID() {
        return this.staffID;
    }
    
    public int getPatientID() {
        return this.patientID;
    }
    
    public String getReason() {
        return this.reason;
    }
    
    public String getSummary() {
        return this.summary;
    }
    
    public Timestamp getTime() {
        return this.apptTime;
    }
    
    public boolean setReason(String reason) {
        if (reason != null) {
            this.reason = reason;
            return true;
        } else {
            this.reason = "";
        }
        return false;
    }
    
    public boolean setSummary(String summary) {
        if (summary != null) {
            this.summary = summary;
            return true;
        } else {
            this.summary = "";
        }
        return false;
    }
    
    public boolean setTime(Timestamp apptTime) {
        if (apptTime != null) {
            this.apptTime = apptTime;
            return true;
        }
        return false;
    }
    
    @Override
    public String toString() {
        String idStr = "[" + String.valueOf(this.ID) + "]";
        String staffIdStr = "Staff:[" + String.valueOf(this.staffID) + "]";
        String patientIdStr = "Patient:[" + String.valueOf(this.patientID) + "]";
        return idStr + " " + staffIdStr + " " + patientIdStr;
    }
}
