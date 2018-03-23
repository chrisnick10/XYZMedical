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
        stmtBuilder.add(appt);
        QueryRunner.execQuery(stmtBuilder.generateStmt());
        return true;
    }
    
    public static boolean updateAppt(Appointment appt) {
        if (!apptExists(appt.getID())) {
            return false;
        }
        UpdateStmtBuilder stmtBuilder = new UpdateStmtBuilder(APPT_TABLE_NAME);
        stmtBuilder.add(appt);
        stmtBuilder.addCondition("ID", appt.getID());
        QueryRunner.execQuery(stmtBuilder.generateStmt());
        return true;
    }
    
    public static void save(Appointment appt) {
        if (!insertAppt(appt)) {
            updateAppt(appt);
        }
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
    
    public static Patient getPatient(int patientID) {
        ArrayList<Patient> patients = searchPatients("ID", patientID);
        if (patients.size() == 1) {
            return patients.get(0);
        }
        return null;
    }
    
    public static boolean patientExists(int patientID) {
        return getPatient(patientID) != null;
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
        stmtBuilder.add(patient);
        QueryRunner.execQuery(stmtBuilder.generateStmt());
        return true;
    }
    
    public static boolean updatePatient(Patient patient) {
        if (!patientExists(patient.getID())) {
            return false;
        }
        UpdateStmtBuilder stmtBuilder = new UpdateStmtBuilder(PATIENT_TABLE_NAME);
        stmtBuilder.add(patient);
        stmtBuilder.addCondition("ID", patient.getID());
        QueryRunner.execQuery(stmtBuilder.generateStmt());
        return true;
    }
    
    public static void save(Patient patient) {
        if (!insertPatient(patient)) {
            updatePatient(patient);
        }
    }
    
    public static boolean chargePatient(int patientID, float chargeAmnt) {
        Patient p = getPatient(patientID);
        if (p == null) {
            return false;
        }
        p.setBalance(p.getBalance() + chargeAmnt);
        save(p);
        return true;
    }
    
    public static boolean payBalance(int patientID, float paymentAmnt) {
        Patient p = getPatient(patientID);
        if (p == null) {
            return false;
        }
        p.setBalance(p.getBalance() - paymentAmnt);
        save(p);
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
    
    public static MedInfo getMedInfo(int medID) {
        ArrayList<MedInfo> medInfo = searchMedInfo("ID", medID);
        if (medInfo.size() == 1) {
            return medInfo.get(0);
        }
        return null;
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
        stmtBuilder.add(medInfo);
        QueryRunner.execQuery(stmtBuilder.generateStmt());
        return true;
    }
    
    public static boolean updateMedInfo(MedInfo medInfo) {
        if (!medInfoExists(medInfo.getID())) {
            return false;
        }
        UpdateStmtBuilder stmtBuilder = new UpdateStmtBuilder(MEDINFO_TABLE_NAME);
        stmtBuilder.add(medInfo);
        stmtBuilder.addCondition("ID", medInfo.getID());
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
    
    public static ArrayList<Prescription> getApptPrescription(int apptID, int patientID) {
        SelectStmtBuilder stmtBuilder = new SelectStmtBuilder(RX_TABLE_NAME);
        stmtBuilder.add("APPT_ID", apptID);
        stmtBuilder.add("PATIENT_ID", patientID);
        return QueryRunner.prescriptionQuery(stmtBuilder.generateStmt());
    }
    
    public static boolean prescriptionExists(int apptID, int patientID) {
        SelectStmtBuilder stmtBuilder = new SelectStmtBuilder(RX_TABLE_NAME);
        stmtBuilder.add("APPT_ID", apptID);
        stmtBuilder.add("PATIENT_ID", patientID);
        return QueryRunner.prescriptionQuery(stmtBuilder.generateStmt()).size() > 0;
    }
    
    public static boolean deletePrescription(int apptID, int patientID) {
        if (!prescriptionExists(apptID, patientID)) {
            return false;
        }
        DeleteStmtBuilder stmtBuilder = new DeleteStmtBuilder(STAFF_TABLE_NAME);
        stmtBuilder.add("APPT_ID", apptID);
        stmtBuilder.add("PATIENT_ID", patientID);
        QueryRunner.execQuery(stmtBuilder.generateStmt());
        return true;
    }
    
    public static boolean insertPrescription(Prescription p) {
        if (prescriptionExists(p.getAppointmentID(), p.getPatientID())) {
            return false;
        }
        InsertStmtBuilder stmtBuilder = new InsertStmtBuilder(RX_TABLE_NAME);
        stmtBuilder.add(p);
        QueryRunner.execQuery(stmtBuilder.generateStmt());
        return true;
    }
    
    public static boolean updatePrescription(Prescription p) {
        if (!prescriptionExists(p.getAppointmentID(), p.getPatientID())) {
            return false;
        }
        UpdateStmtBuilder stmtBuilder = new UpdateStmtBuilder(RX_TABLE_NAME);
        stmtBuilder.add(p);
        stmtBuilder.addCondition("APPT_ID", p.getAppointmentID());
        stmtBuilder.addCondition("PATIENT_ID", p.getPatientID());
        QueryRunner.execQuery(stmtBuilder.generateStmt());
        return true;
    }
    
    public static void save(Prescription p) {
        if (!insertPrescription(p)) {
            updatePrescription(p);
        }
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

    public static Staff getStaff(int staffID) {
        ArrayList<Staff> staff = searchStaff("ID", staffID);
        if (staff.size() == 1) {
            return staff.get(0);
        }
        return null;
    }
    
    public static boolean staffExists(int staffID) {
        return searchStaff("ID", staffID).size() > 0;
    }

    public static boolean deleteStaff(int staffID) {
        if (!staffExists(staffID)) {
            return false;
        }
        DeleteStmtBuilder stmtBuilder = new DeleteStmtBuilder(STAFF_TABLE_NAME);
        stmtBuilder.add("ID", staffID);
        QueryRunner.execQuery(stmtBuilder.generateStmt());
        return true;
    }
    
    public static boolean insertStaff(Staff staff) {
        if (staffExists(staff.getID())) {
            return false;
        }
        InsertStmtBuilder stmtBuilder = new InsertStmtBuilder(STAFF_TABLE_NAME);
        stmtBuilder.add(staff);
        QueryRunner.execQuery(stmtBuilder.generateStmt());
        return true;
    }

    public static boolean updateStaff(Staff staff) {
        if (!staffExists(staff.getID())) {
            return false;
        }
        UpdateStmtBuilder stmtBuilder = new UpdateStmtBuilder(STAFF_TABLE_NAME);
        stmtBuilder.add(staff);
        stmtBuilder.addCondition("ID", staff.getID());
        QueryRunner.execQuery(stmtBuilder.generateStmt());
        return true;
    }
    
    public static void save(Staff staff) {
        if (!insertStaff(staff)) {
            updateStaff(staff);
        }
    }
    
    public static ArrayList<Staff> getDoctors() {
        return searchStaff("ACCESSLVL", 1);
    }
    
    public static Person login(String username, String password) {
        SelectStmtBuilder staffStmtBuilder = new SelectStmtBuilder(STAFF_TABLE_NAME);
        staffStmtBuilder.add("USERNAME", username);
        staffStmtBuilder.add("PASSWORD", password);
        ArrayList<Staff> staff = QueryRunner.staffQuery(staffStmtBuilder.generateStmt());
        if (staff.size() == 1) {
            return staff.get(0);
        }
        
        SelectStmtBuilder patientStmtBuilder = new SelectStmtBuilder(PATIENT_TABLE_NAME);
        patientStmtBuilder.add("USERNAME", username);
        patientStmtBuilder.add("PASSWORD", password);
        ArrayList<Patient> patients = QueryRunner.patientQuery(patientStmtBuilder.generateStmt());
        if (patients.size() == 1) {
            return patients.get(0);
        }
        return null;
    }
}
