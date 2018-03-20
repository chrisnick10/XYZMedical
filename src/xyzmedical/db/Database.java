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
    private final static String DB_PATH = "http://76.230.142.194/csi3370/sql_query1.php?query=";
    
    // Query execution method
    private static String execQuery(String query) {
        System.out.println(query);
        String result = "";
        String urlStr = DB_PATH + query;
        urlStr = urlStr.replaceAll(" ", "+");
        urlStr = urlStr.replaceAll("'", "%27");

        try {
            URL url = new URL(urlStr);
            URLConnection connection = url.openConnection();
            
            connection.setDoInput(true);
            connection.setDoOutput(true);
            connection.setAllowUserInteraction(false);
            
            BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            
            String ln = null;
            while ((ln = br.readLine()) != null) {
                result += ln;
            }
            
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    
    
    // Methods for retrieving raw JSON info from db
    private static ArrayList<Appointment> apptQuery(String query) {
        ArrayList<Appointment> apptList = new ArrayList<>();
        try {
            JSONArray jsonArr = new JSONArray(execQuery(query));
            for (int i = 0; i < jsonArr.length(); ++i) {
                JSONObject obj = jsonArr.getJSONObject(i);
                Appointment appt = ModelFactory.createAppointment(obj);
                if (appt != null) {
                    apptList.add(appt);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return apptList;
    }
    
    private static ArrayList<Patient> patientQuery(String query) {
        ArrayList<Patient> patientList = new ArrayList<>();
        try {
            JSONArray jsonArr = new JSONArray(execQuery(query));
            for (int i = 0; i < jsonArr.length(); ++i) {
                JSONObject obj = jsonArr.getJSONObject(i);
                Patient patient = ModelFactory.createPatient(obj);
                if (patient != null) {
                    patientList.add(patient);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return patientList;
    }
    
    private static ArrayList<MedInfo> medinfoQuery(String query) {
        ArrayList<MedInfo> medinfoList = new ArrayList<>();
        try {
            JSONArray jsonArr = new JSONArray(execQuery(query));
            for (int i = 0; i < jsonArr.length(); ++i) {
                JSONObject obj = jsonArr.getJSONObject(i);
                MedInfo medinfo = ModelFactory.createMedInfo(obj);
                if (medinfo != null) {
                    medinfoList.add(medinfo);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return medinfoList;
    }
    
    private static ArrayList<Prescription> prescriptionQuery(String query) {
        ArrayList<Prescription> prescriptionList = new ArrayList<>();
        try {
            JSONArray jsonArr = new JSONArray(execQuery(query));
            for (int i = 0; i < jsonArr.length(); ++i) {
                JSONObject obj = jsonArr.getJSONObject(i);
                Prescription med = ModelFactory.createPrescription(obj);
                if (med != null) {
                    prescriptionList.add(med);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return prescriptionList;
    }
    
    private static ArrayList<Staff> staffQuery(String query) {
        ArrayList<Staff> staffList = new ArrayList<>();
        try {
            JSONArray jsonArr = new JSONArray(execQuery(query));
            for (int i = 0; i < jsonArr.length(); ++i) {
                JSONObject obj = jsonArr.getJSONObject(i);
                Staff staff = ModelFactory.createStaff(obj);
                if (staff != null) {
                    staffList.add(staff);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return staffList;
    }
    
    
    
    // SEARCH METHODS FOR EQUALITY CONDITIONS
    public static ArrayList<Appointment> allAppts() {
        SelectStmtBuilder stmtBuilder = new SelectStmtBuilder("APPTS");
        return apptQuery(stmtBuilder.generateStmt());
    }
    
    public static ArrayList<Appointment> searchAppts(String key, int value) {
        SelectStmtBuilder stmtBuilder = new SelectStmtBuilder("APPTS");
        stmtBuilder.add(key, value);
        return apptQuery(stmtBuilder.generateStmt());
    }
    
    public static ArrayList<Appointment> searchAppts(String key, String value) {
        SelectStmtBuilder stmtBuilder = new SelectStmtBuilder("APPTS");
        stmtBuilder.add(key, value);
        return apptQuery(stmtBuilder.generateStmt());
    }
    
    public static ArrayList<Patient> allPatients() {
        SelectStmtBuilder stmtBuilder = new SelectStmtBuilder("PATIENT_TABLE");
        return patientQuery(stmtBuilder.generateStmt());
    }
    
    public static ArrayList<Patient> searchPatients(String key, int value) {
        SelectStmtBuilder stmtBuilder = new SelectStmtBuilder("PATIENT_TABLE");
        stmtBuilder.add(key, value);
        return patientQuery(stmtBuilder.generateStmt());
    }
    
    public static ArrayList<Patient> searchPatients(String key, String value) {
        SelectStmtBuilder stmtBuilder = new SelectStmtBuilder("PATIENT_TABLE");
        stmtBuilder.add(key, value);
        return patientQuery(stmtBuilder.generateStmt());
    }

    public static ArrayList<MedInfo> allMedInfo() {
        SelectStmtBuilder stmtBuilder = new SelectStmtBuilder("MED_INFO");
        return medinfoQuery(stmtBuilder.generateStmt());
    }
    
    public static ArrayList<MedInfo> searchMedInfo(String key, int value) {
        SelectStmtBuilder stmtBuilder = new SelectStmtBuilder("MED_INFO");
        stmtBuilder.add(key, value);
        return medinfoQuery(stmtBuilder.generateStmt());
    }
    
    public static ArrayList<MedInfo> searchMedInfo(String key, String value) {
        SelectStmtBuilder stmtBuilder = new SelectStmtBuilder("MED_INFO");
        stmtBuilder.add(key, value);
        return medinfoQuery(stmtBuilder.generateStmt());
    }
    
    public static ArrayList<Prescription> allPrescriptions() {
        SelectStmtBuilder stmtBuilder = new SelectStmtBuilder("PRESCRIPT");
        return prescriptionQuery(stmtBuilder.generateStmt());
    }
    
    public static ArrayList<Prescription> searchPrescriptions(String key, int value) {
        SelectStmtBuilder stmtBuilder = new SelectStmtBuilder("PRESCRIPT");
        stmtBuilder.add(key, value);
        return prescriptionQuery(stmtBuilder.generateStmt());
    }
    
    public static ArrayList<Prescription> searchPrescriptions(String key, String value) {
        SelectStmtBuilder stmtBuilder = new SelectStmtBuilder("PRESCRIPT");
        stmtBuilder.add(key, value);
        return prescriptionQuery(stmtBuilder.generateStmt());
    }
    
    public static ArrayList<Staff> allStaff() {
        SelectStmtBuilder stmtBuilder = new SelectStmtBuilder("STAFF_TABLE");
        return staffQuery(stmtBuilder.generateStmt());
    }
    
    public static ArrayList<Staff> searchStaff(String key, int value) {
        SelectStmtBuilder stmtBuilder = new SelectStmtBuilder("STAFF_TABLE");
        stmtBuilder.add(key, value);
        return staffQuery(stmtBuilder.generateStmt());
    }
    
    public static ArrayList<Staff> searchStaff(String key, String value) {
        SelectStmtBuilder stmtBuilder = new SelectStmtBuilder("STAFF_TABLE");
        stmtBuilder.add(key, value);
        return staffQuery(stmtBuilder.generateStmt());
    }

    
    
    // EXISTENCE METHODS
    public static boolean appointmentExists(int apptID) {
        SelectStmtBuilder stmtBuilder = new SelectStmtBuilder("APPT");
        stmtBuilder.add("ID", apptID);
        String searchResult = execQuery(stmtBuilder.generateStmt() + " ORDER BY 'ID' ASC");
        if (searchResult.equals("[]")) {
            return false;
        }
        return true;
    }
    
    public static boolean appointmentExists(Appointment appt) {
        return appointmentExists(appt.getID());
    }
    
    public static boolean patientExists(int patientID) {
        SelectStmtBuilder stmtBuilder = new SelectStmtBuilder("PATIENT_TABLE");
        stmtBuilder.add("ID", patientID);
        String searchResult = execQuery(stmtBuilder.generateStmt() + " ORDER BY 'ID' ASC");
        if (searchResult.equals("[]")) {
            return false;
        }
        return true;
    }
    
    public static boolean patientExists(Patient patient) {
        return patientExists(patient.getID());
    }
    
    public static boolean medInfoExists(int medID) {
        SelectStmtBuilder stmtBuilder = new SelectStmtBuilder("MED_INFO");
        stmtBuilder.add("ID", medID);
        String searchResult = execQuery(stmtBuilder.generateStmt() + " ORDER BY 'ID' ASC");
        if (searchResult.equals("[]")) {
            return false;
        }
        return true;
    }
    
    public static boolean medInfoExists(MedInfo medInfo) {
        return medInfoExists(medInfo.getID());
    }
    
    public static boolean prescriptionExists(int apptID, int patientID) {
        SelectStmtBuilder stmtBuilder = new SelectStmtBuilder("PRESCRIPT");
        stmtBuilder.add("APPT_ID", apptID);
        stmtBuilder.add("PATIENT_ID", patientID);
        String searchResult = execQuery(stmtBuilder.generateStmt() + " ORDER BY 'DATE' ASC");
        if (searchResult.equals("[]")) {
            return false;
        }
        return true;
    }
    
    public static boolean prescriptionExists(Prescription p) {
        return prescriptionExists(p.getAppointmentID(), p.getPatientID());
    }
    
    public static boolean staffExists(int staffID) {
        SelectStmtBuilder stmtBuilder = new SelectStmtBuilder("STAFF_TABLE");
        stmtBuilder.add("ID", staffID);
        String searchResult = execQuery(stmtBuilder.generateStmt() + " ORDER BY 'ID' ASC");
        if (searchResult.equals("[]")) {
            return false;
        }
        return true;
    }
    
    public static boolean staffExists(Staff staff) {
        return staffExists(staff.getID());
    }
    
    
    
    // INSERTION METHODS
    public static boolean insertAppt(Appointment appt) {
        if (appointmentExists(appt)) {
            return false;
        }
        InsertStmtBuilder stmtBuilder = new InsertStmtBuilder("APPT");
        if (appt.getID() >= 0) {
            stmtBuilder.add("ID", appt.getID());
        }
        stmtBuilder.add("STAFF_ID", appt.getStaffID());
        stmtBuilder.add("PATIENT_ID", appt.getPatientID());
        stmtBuilder.add("REASON", appt.getReason());
        stmtBuilder.add("SUMMARY", appt.getSummary());
        stmtBuilder.add("TIME", appt.getTime());
        execQuery(stmtBuilder.generateStmt());
        return true;
    }
    
    public static boolean insertPatient(Patient patient) {
        if (patientExists(patient)) {
            return false;
        }
        InsertStmtBuilder stmtBuilder = new InsertStmtBuilder("PATIENT_TABLE");
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
        execQuery(stmtBuilder.generateStmt());
        return true;
    }
    
    public static boolean insertMedInfo(MedInfo medInfo) {
        if (medInfoExists(medInfo)) {
            return false;
        }
        InsertStmtBuilder stmtBuilder = new InsertStmtBuilder("MED_INFO");
        if (medInfo.getID() >= 0) {
            stmtBuilder.add("ID", medInfo.getID());
        }
        stmtBuilder.add("ID", medInfo.getID());
        stmtBuilder.add("NAME", medInfo.getName());
        stmtBuilder.add("USAGE", medInfo.getUsage());
        stmtBuilder.add("DESCRIPTION", medInfo.getDescription());
        stmtBuilder.add("SIDE_EFFECTS", medInfo.getSideEffects());
        execQuery(stmtBuilder.generateStmt());
        return true;
    }
    
    public static boolean insertPrescription(Prescription p) {
        if (prescriptionExists(p)) {
            return false;
        }
        InsertStmtBuilder stmtBuilder = new InsertStmtBuilder("PRESCRIPT");
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
        execQuery(stmtBuilder.generateStmt());
        return true;
    }
    
    public static boolean insertStaff(Staff staff) {
        if (staffExists(staff)) {
            return false;
        }
        InsertStmtBuilder stmtBuilder = new InsertStmtBuilder("STAFF");
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
        execQuery(stmtBuilder.generateStmt());
        return true;
    }
    
    
    
    // DELETE METHODS
    public static void deleteAppt(String key, String value) {
        DeleteStmtBuilder stmtBuilder = new DeleteStmtBuilder("APPT");
        stmtBuilder.add(key, value);
        execQuery(stmtBuilder.generateStmt());
    }
    
    public static void deleteAppt(String key, int value) {
        DeleteStmtBuilder stmtBuilder = new DeleteStmtBuilder("APPT");
        stmtBuilder.add(key, value);
        execQuery(stmtBuilder.generateStmt());
    }
    
    public static boolean deleteAppt(int apptID) {
        if (!appointmentExists(apptID)) {
            return false;
        }
        deleteAppt("ID", apptID);
        return true;
    }
    
    public static boolean deleteAppt(Appointment appt) {
        return deleteAppt(appt.getID());
    }
    
    public static boolean deletePatient(int patientID) {
        if (!patientExists(patientID)) {
            return false;
        }
        return true;
    }
    
    public static void deleteMedInfo(String key, String value) {
        DeleteStmtBuilder stmtBuilder = new DeleteStmtBuilder("MED_INFO");
        stmtBuilder.add(key, value);
        execQuery(stmtBuilder.generateStmt());
    }
    
    public static void deleteMedInfo(String key, int value) {
        DeleteStmtBuilder stmtBuilder = new DeleteStmtBuilder("MED_INFO");
        stmtBuilder.add(key, value);
        execQuery(stmtBuilder.generateStmt());
    }
    
    public static boolean deleteMedInfo(int medID) {
        if (!medInfoExists(medID)) {
            return false;
        }
        deleteMedInfo("ID", medID);
        return true;
    }
    
    public static boolean deleteMedInfo(MedInfo medInfo) {
        return deleteMedInfo(medInfo.getID());
    }
    
    public static boolean deletePrescription(int apptID, int patientID) {
        if (!prescriptionExists(apptID, patientID)) {
            return false;
        }
        DeleteStmtBuilder stmtBuilder = new DeleteStmtBuilder("PRESCRIPT");
        stmtBuilder.add("APPT_ID", apptID);
        stmtBuilder.add("PATIENT_ID", patientID);
        execQuery(stmtBuilder.generateStmt());
        return true;
    }
    
    public static boolean deletePrescription(Prescription p) {
        return deletePrescription(p.getAppointmentID(), p.getPatientID());
    }
    
    public static void deleteStaff(String key, String value) {
        DeleteStmtBuilder stmtBuilder = new DeleteStmtBuilder("STAFF");
        stmtBuilder.add(key, value);
        execQuery(stmtBuilder.generateStmt());
    }
    
    public static void deleteStaff(String key, int value) {
        DeleteStmtBuilder stmtBuilder = new DeleteStmtBuilder("STAFF");
        stmtBuilder.add(key, value);
        execQuery(stmtBuilder.generateStmt());
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
}
