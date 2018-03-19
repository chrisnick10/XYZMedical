package xyzmedical.model;

import java.sql.Date;

/**
 *
 * @author Will
 */
public class Prescription {
    private int apptID;
    private int medID;
    private int staffID;
    private int patientID;
    private int doses;
    private int refills;
    private Dosage dosage;
    private Frequency freq;
    private Date date;
    
    public Prescription(int apptID, int medID, int staffID, int patientID, int doses, 
                int refills, Dosage dosage, Frequency freq, Date date) {
        this.apptID = apptID;
        this.medID = medID;
        this.staffID = staffID;
        this.patientID = patientID;
        this.doses = doses;
        this.refills = refills;
        this.dosage = dosage;
        this.freq = freq;
        this.date = date;
    }
    
    public int getAppointmentID() {
        return this.apptID;
    }
    
    public int getMedID() {
        return this.medID;
    }
    
    public int getStaffID() {
        return this.staffID;
    }
    
    public int getPatientID() {
        return this.patientID;
    }
    
    public int getDoses() {
        return this.doses;
    }
    
    public int getRefills() {
        return this.refills;
    }
    
    public Dosage getDosage() {
        return this.dosage;
    }
    
    public Frequency getFreq() {
        return this.freq;
    }
    
    public Date getDate() {
        return this.date;
    }
    
    @Override
    public String toString() {
        return String.valueOf(medID) + " " + this.dosage.toString() + " " + this.freq.toString();
    }
}
