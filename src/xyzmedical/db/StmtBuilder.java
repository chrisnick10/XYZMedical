/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xyzmedical.db;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;

import xyzmedical.model.*;

/**
 *
 * @author Will
 */
abstract class StmtBuilder {
    protected String table;
    protected ArrayList<String> fields;
    protected ArrayList<String> values;
    
    public StmtBuilder(String table) {
        this.table = Util.sqlTableAttrib(table);
        this.fields = new ArrayList<>();
        this.values = new ArrayList<>();
    }
    
    public void add(String field, Date value) {
        fields.add(Util.sqlTableAttrib(field));
        values.add(Util.sqlValue(value));
    }
    
    public void add(String field, Timestamp value) {
        fields.add(Util.sqlTableAttrib(field));
        values.add(Util.sqlValue(value));
    }
    
    public void add(String field, String value) {
        fields.add(Util.sqlTableAttrib(field));
        values.add(Util.sqlValue(value));
    }
    
    public void add(String field, int value) {
        fields.add(Util.sqlTableAttrib(field));
        values.add(Util.sqlValue(value));
    }
    
    public void add(String field, double value) {
        fields.add(Util.sqlTableAttrib(field));
        values.add(Util.sqlValue(value));
    }
    
    public boolean add(Appointment appt) {
        if (appt.getID() >= 0) {
            this.add("ID", appt.getID());
        }
        this.add("STAFF_ID", appt.getStaffID());
        this.add("PATIENT_ID", appt.getPatientID());
        this.add("REASON", appt.getReason());
        this.add("SUMMARY", appt.getSummary());
        this.add("TIME", appt.getTime());
        return true;
    }
    
    public boolean add(MedInfo medInfo) {
        if (medInfo.getID() >= 0) {
            this.add("ID", medInfo.getID());
        }
        this.add("ID", medInfo.getID());
        this.add("NAME", medInfo.getName());
        this.add("USAGE", medInfo.getUsage());
        this.add("DESCRIPTION", medInfo.getDescription());
        this.add("SIDE_EFFECTS", medInfo.getSideEffects());
        return true;
    }
    
    public boolean add(Patient patient) {
        if (patient.getID() >= 0) {
            this.add("ID", patient.getID());
        }
        if (patient.getPrimaryCareProvider() >= 0) {
            this.add("PCP", patient.getPrimaryCareProvider());
        } else {
            this.add("PCP", "");
        }
        this.add("USERNAME", patient.getUsername());
        this.add("PASSWORD", patient.getPassword());
        this.add("FIRSTNAME", patient.getUsername());
        this.add("LASTNAME", patient.getLastName());
        this.add("EMAIL", patient.getEmail());
        this.add("MAINPHONE", patient.getPhoneNum());
        this.add("INSURANCE", patient.getInsurance());
        this.add("BALANCE", patient.getBalance());
        this.add("BIRTH_DATE", patient.getBirthDate());
        return true;
    }
    
    public boolean add(Prescription p) {
        this.add("APPT_ID", p.getAppointmentID());
        this.add("MED_ID", p.getMedID());
        this.add("STAFF_ID", p.getStaffID());
        this.add("PATIENT_ID", p.getPatientID());
        this.add("DOSES", p.getDoses());
        this.add("DOSE_AMNT", p.getDosage().getAmount());
        this.add("DOSE_UNIT", p.getDosage().getUnit());
        this.add("FREQ_AMNT", p.getFreq().getCount());
        this.add("FREQ_UNIT", p.getFreq().getTimeUnit());
        this.add("REFILLS", p.getRefills());
        this.add("DATE", p.getDate());
        return true;
    }
    
    public boolean add(Staff staff) {
        if (staff.getID() >= 0) {
            this.add("ID", staff.getID());
        }
        this.add("ACCESSLVL", staff.getAccessLevel());
        this.add("USERNAME", staff.getUsername());
        this.add("PASSWORD", staff.getPassword());
        this.add("FIRSTNAME", staff.getFirstName());
        this.add("LASTNAME", staff.getLastName());
        this.add("BIRTH_DATE", staff.getBirthDate());
        this.add("HIRE_DATE", staff.getHireDate());
        return true;
    }
    
    public abstract String generateStmt();
}
