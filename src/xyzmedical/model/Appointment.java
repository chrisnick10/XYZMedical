package xyzmedical.model;

import java.util.Date;

/**
 *
 * @author Will
 */
public class Appointment {
    protected int ID;
    protected int staffID;
    protected int patientID;
    protected String reason;
    protected String summary;
    protected Date apptTime;
    
    public Appointment(int ID, int staffID, int patientID, String reason, String summary, Date apptTime) {
        this.ID = ID;
        this.staffID = staffID;
        this.patientID = patientID;
        this.reason = reason;
        this.summary = summary;
        this.apptTime = apptTime;
    }
    
    @Override
    public String toString() {
        String idStr = "[" + String.valueOf(this.ID) + "]";
        String staffIdStr = "Staff:[" + String.valueOf(this.staffID) + "]";
        String patientIdStr = "Patient:[" + String.valueOf(this.patientID) + "]";
        return idStr + " " + staffIdStr + " " + patientIdStr;
    }
    
    public int getID() {
        return ID;
    }
    
    public int getStaffID() {
        return staffID;
    }
    
    public int getPatientID() {
        return patientID;
    }
    
    public String getReason() {
        return reason;
    }
    
    public String getSummary() {
        return summary;
    }
    
    public Date getTime() {
        return apptTime;
    }
    
    public boolean setReason(String reason) {
        if (reason != null) {
            this.reason = reason;
            return true;
        }
        return false;
    }
    
    public boolean setSummary(String summary) {
        if (summary != null) {
            this.summary = summary;
            return true;
        }
        return false;
    }
    
    public boolean setTime(Date apptTime) {
        if (apptTime != null) {
            this.apptTime = apptTime;
            return true;
        }
        return false;
    }
}
