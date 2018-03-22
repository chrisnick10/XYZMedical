package xyzmedical.db;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import org.json.*;

import xyzmedical.model.*;

/**
 *
 * @author Will
 */
public class Database {
    public static final String APPT_TABLE_NAME = "APPT";
    public static final String PATIENT_TABLE_NAME = "PATIENT_TABLE";
    public static final String MEDINFO_TABLE_NAME = "MED_INFO";
    public static final String RX_TABLE_NAME = "PRESCRIPT";
    public static final String STAFF_TABLE_NAME = "STAFF_TABLE";
    
    
    
    // APPOINTMENT TABLE INTERFACE
    public static ArrayList<Appointment> searchAppts(String key, int value) {
        SelectStmtBuilder stmtBuilder = new SelectStmtBuilder(APPT_TABLE_NAME);
        stmtBuilder.add(key, value);
        return QueryRunner.apptQuery(stmtBuilder.generateStmt());
    }
    
    public static ArrayList<Appointment> searchAppts(String key, String value) {
        SelectStmtBuilder stmtBuilder = new SelectStmtBuilder(APPT_TABLE_NAME);
        stmtBuilder.add(key, value);
        return QueryRunner.apptQuery(stmtBuilder.generateStmt());
    }
    
    public static boolean apptExists(int apptID) {
        return searchAppts("ID", apptID).size() > 0;
    }
    
    public static boolean deleteAppt(int apptID) {
        if (!apptExists(apptID)) {
            return false;
        }
        DeleteStmtBuilder stmtBuilder = new DeleteStmtBuilder(APPT_TABLE_NAME);
        stmtBuilder.add("ID", apptID);
        QueryRunner.execQuery(stmtBuilder.generateStmt());
        return true;
    }
    
    public static boolean insertAppt(Appointment appt) {
        if (apptExists(appt.getID())) {
            return false;
        }
        InsertStmtBuilder stmtBuilder = new InsertStmtBuilder(APPT_TABLE_NAME);
        if (appt.getID() >= 0) {
            stmtBuilder.add("ID", appt.getID());
        }
        stmtBuilder.add("STAFF_ID", appt.getStaffID());
        stmtBuilder.add("PATIENT_ID", appt.getPatientID());
        stmtBuilder.add("REASON", appt.getReason());
        stmtBuilder.add("SUMMARY", appt.getSummary());
        stmtBuilder.add("TIME", appt.getTime());
        QueryRunner.execQuery(stmtBuilder.generateStmt());
        return true;
    }
    
    
    
    // PATIENT TABLE INTERFACE
    public static ArrayList<Patient> searchPatients(String key, int value) {
        SelectStmtBuilder stmtBuilder = new SelectStmtBuilder(PATIENT_TABLE_NAME);
        stmtBuilder.add(key, value);
        return QueryRunner.patientQuery(stmtBuilder.generateStmt());
    }
    
    public static ArrayList<Patient> searchPatients(String key, String value) {
        SelectStmtBuilder stmtBuilder = new SelectStmtBuilder(PATIENT_TABLE_NAME);
        stmtBuilder.add(key, value);
        return QueryRunner.patientQuery(stmtBuilder.generateStmt());
    }
    
    public static boolean patientExists(int patientID) {
        return searchPatients("ID", patientID).size() > 0;
    }
    
    public static boolean deletePatient(int patientID) {
        if (!patientExists(patientID)) {
            return false;
        }
        DeleteStmtBuilder stmtBuilder = new DeleteStmtBuilder(PATIENT_TABLE_NAME);
        stmtBuilder.add("ID", patientID);
        QueryRunner.execQuery(stmtBuilder.generateStmt());
        return true;
    }
        
    public static boolean insertPatient(Patient patient) {
        if (patientExists(patient.getID())) {
            return false;
        }
        InsertStmtBuilder stmtBuilder = new InsertStmtBuilder(PATIENT_TABLE_NAME);
        if (patient.getID() >= 0) {
            stmtBuilder.add("ID", patient.getID());
        }
        if (patient.getPrimaryCareProvider() >= 0) {
            stmtBuilder.add("PCP", patient.getPrimaryCareProvider());
        } else {
            stmtBuilder.add("PCP", "");
        }
        stmtBuilder.add("USERNAME", patient.getUsername());
        stmtBuilder.add("PASSWORD", patient.getPassword());
        stmtBuilder.add("FIRSTNAME", patient.getUsername());
        stmtBuilder.add("LASTNAME", patient.getLastName());
        stmtBuilder.add("EMAIL", patient.getEmail());
        stmtBuilder.add("MAINPHONE", patient.getPhoneNum());
        stmtBuilder.add("INSURANCE", patient.getInsurance());
        stmtBuilder.add("BALANCE", patient.getBalance());
        stmtBuilder.add("BIRTH_DATE", patient.getBirthDate());
        QueryRunner.execQuery(stmtBuilder.generateStmt());
        return true;
    }
    
    
    
    // MEDINFO TABLE INTERFACE
    public static ArrayList<MedInfo> searchMedInfo(String key, int value) {
        SelectStmtBuilder stmtBuilder = new SelectStmtBuilder(MEDINFO_TABLE_NAME);
        stmtBuilder.add(key, value);
        return QueryRunner.medinfoQuery(stmtBuilder.generateStmt());
    }
    
    public static ArrayList<MedInfo> searchMedInfo(String key, String value) {
        SelectStmtBuilder stmtBuilder = new SelectStmtBuilder(MEDINFO_TABLE_NAME);
        stmtBuilder.add(key, value);
        return QueryRunner.medinfoQuery(stmtBuilder.generateStmt());
    }
    
    public static boolean medInfoExists(int medID) {
        return searchMedInfo("ID", medID).size() > 0;
    }
    
    public static boolean deleteMedInfo(int medID) {
        if (!medInfoExists(medID)) {
            return false;
        }
        DeleteStmtBuilder stmtBuilder = new DeleteStmtBuilder(MEDINFO_TABLE_NAME);
        stmtBuilder.add("ID", medID);
        QueryRunner.execQuery(stmtBuilder.generateStmt());
        return true;
    }
    
    public static boolean insertMedInfo(MedInfo medInfo) {
        if (medInfoExists(medInfo.getID())) {
            return false;
        }
        InsertStmtBuilder stmtBuilder = new InsertStmtBuilder(MEDINFO_TABLE_NAME);
        if (medInfo.getID() >= 0) {
            stmtBuilder.add("ID", medInfo.getID());
        }
        stmtBuilder.add("ID", medInfo.getID());
        stmtBuilder.add("NAME", medInfo.getName());
        stmtBuilder.add("USAGE", medInfo.getUsage());
        stmtBuilder.add("DESCRIPTION", medInfo.getDescription());
        stmtBuilder.add("SIDE_EFFECTS", medInfo.getSideEffects());
        QueryRunner.execQuery(stmtBuilder.generateStmt());
        return true;
    }
    
    
    
    // PRESCRIPTION TABLE INTERFACE
    public static ArrayList<Prescription> allPrescriptions() {
        SelectStmtBuilder stmtBuilder = new SelectStmtBuilder(RX_TABLE_NAME);
        return QueryRunner.prescriptionQuery(stmtBuilder.generateStmt());
    }
    
    public static ArrayList<Prescription> searchPrescriptions(String key, int value) {
        SelectStmtBuilder stmtBuilder = new SelectStmtBuilder(RX_TABLE_NAME);
        stmtBuilder.add(key, value);
        return QueryRunner.prescriptionQuery(stmtBuilder.generateStmt());
    }
    
    public static ArrayList<Prescription> searchPrescriptions(String key, String value) {
        SelectStmtBuilder stmtBuilder = new SelectStmtBuilder(RX_TABLE_NAME);
        stmtBuilder.add(key, value);
        return QueryRunner.prescriptionQuery(stmtBuilder.generateStmt());
    }
    
    public static boolean prescriptionExists(int apptID, int patientID) {
        SelectStmtBuilder stmtBuilder = new SelectStmtBuilder(RX_TABLE_NAME);
        stmtBuilder.add("APPT_ID", apptID);
        stmtBuilder.add("PATIENT_ID", patientID);
        return QueryRunner.prescriptionQuery(stmtBuilder.generateStmt()).size() > 0;
    }
    
    public static boolean insertPrescription(Prescription p) {
        if (prescriptionExists(p.getAppointmentID(), p.getPatientID())) {
            return false;
        }
        InsertStmtBuilder stmtBuilder = new InsertStmtBuilder(RX_TABLE_NAME);
        stmtBuilder.add("APPT_ID", p.getAppointmentID());
        stmtBuilder.add("MED_ID", p.getMedID());
        stmtBuilder.add("STAFF_ID", p.getStaffID());
        stmtBuilder.add("PATIENT_ID", p.getPatientID());
        stmtBuilder.add("DOSES", p.getDoses());
        stmtBuilder.add("DOSE_AMNT", p.getDosage().getAmount());
        stmtBuilder.add("DOSE_UNIT", p.getDosage().getUnit());
        stmtBuilder.add("FREQ_AMNT", p.getFreq().getCount());
        stmtBuilder.add("FREQ_UNIT", p.getFreq().getTimeUnit());
        stmtBuilder.add("REFILLS", p.getRefills());
        stmtBuilder.add("DATE", p.getDate());
        QueryRunner.execQuery(stmtBuilder.generateStmt());
        return true;
    }
    
    
    // STAFF TABLE INTERFACE
    public static ArrayList<Staff> allStaff() {
        SelectStmtBuilder stmtBuilder = new SelectStmtBuilder(STAFF_TABLE_NAME);
        return QueryRunner.staffQuery(stmtBuilder.generateStmt());
    }
    
    public static ArrayList<Staff> searchStaff(String key, int value) {
        SelectStmtBuilder stmtBuilder = new SelectStmtBuilder(STAFF_TABLE_NAME);
        stmtBuilder.add(key, value);
        return QueryRunner.staffQuery(stmtBuilder.generateStmt());
    }
    
    public static ArrayList<Staff> searchStaff(String key, String value) {
        SelectStmtBuilder stmtBuilder = new SelectStmtBuilder(STAFF_TABLE_NAME);
        stmtBuilder.add(key, value);
        return QueryRunner.staffQuery(stmtBuilder.generateStmt());
    }

    public static boolean staffExists(int staffID) {
        return searchStaff("ID", staffID).size() > 0;
    }
    
    public static boolean insertStaff(Staff staff) {
        if (staffExists(staff.getID())) {
            return false;
        }
        InsertStmtBuilder stmtBuilder = new InsertStmtBuilder(STAFF_TABLE_NAME);
        if (staff.getID() >= 0) {
            stmtBuilder.add("ID", staff.getID());
        }
        stmtBuilder.add("ACCESSLVL", staff.getAccessLevel());
        stmtBuilder.add("USERNAME", staff.getUsername());
        stmtBuilder.add("PASSWORD", staff.getPassword());
        stmtBuilder.add("FIRSTNAME", staff.getFirstName());
        stmtBuilder.add("LASTNAME", staff.getLastName());
        stmtBuilder.add("BIRTH_DATE", staff.getBirthDate());
        stmtBuilder.add("HIRE_DATE", staff.getHireDate());
        QueryRunner.execQuery(stmtBuilder.generateStmt());
        return true;
    }

    
    public static  boolean deleteMedInfo(MedInfo medInfo) {
        return deleteMedInfo(medInfo.getID());
    }
    
    public static boolean deletePrescription(int apptID, int patientID) {
        if (!prescriptionExists(apptID, patientID)) {
            return false;
        }
        DeleteStmtBuilder stmtBuilder = new DeleteStmtBuilder(RX_TABLE_NAME);
        stmtBuilder.add("APPT_ID", apptID);
        stmtBuilder.add("PATIENT_ID", patientID);
        QueryRunner.execQuery(stmtBuilder.generateStmt());
        return true;
    }
    
    public static boolean deletePrescription(Prescription p) {
        return deletePrescription(p.getAppointmentID(), p.getPatientID());
    }
    
    public static void deleteStaff(String key, String value) {
        DeleteStmtBuilder stmtBuilder = new DeleteStmtBuilder(STAFF_TABLE_NAME);
        stmtBuilder.add(key, value);
        QueryRunner.execQuery(stmtBuilder.generateStmt());
    }
    
    public static void deleteStaff(String key, int value) {
        DeleteStmtBuilder stmtBuilder = new DeleteStmtBuilder(STAFF_TABLE_NAME);
        stmtBuilder.add(key, value);
        QueryRunner.execQuery(stmtBuilder.generateStmt());
    }
    
    public static boolean deleteStaff(int staffID) {
        if (!staffExists(staffID)) {
            return false;
        }
        deleteStaff("ID", staffID);
        return true;
    }

    public static boolean deleteStaff(Staff staff) {
        return deleteStaff(staff.getID());
    }
    
    // TODO throwaway when more generic methods realized
    public static float setBalance(int patientID, float newBalance) {
        String updateQuery = "UPDATE `" + PATIENT_TABLE_NAME + "` SET `BALANCE` = ";
        updateQuery += String.valueOf(newBalance);
        updateQuery += " WHERE `ID` = " + String.valueOf(patientID);
        QueryRunner.execQuery(updateQuery);
        if (patientExists(patientID)) {
            return searchPatients("ID", patientID).get(0).getBalance();
        }
        return -1;
    }
}
