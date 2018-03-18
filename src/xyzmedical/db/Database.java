package xyzmedical.db;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Date;
import org.json.*;

import xyzmedical.model.*;
import xyzmedical.util.Util;

/**
 *
 * @author Will
 */
public class Database {
    private final static String DB_PATH = "http://76.230.142.194/csi3370/sql_query1.php?query=";
    
    private static String doQuery(String query) {
        String result = "";
        String urlStr = DB_PATH + query;
        urlStr = urlStr.replaceAll(" ", "+");
        urlStr = urlStr.replaceAll("'", "%27");

        try {
            URL url = new URL(urlStr);
            URLConnection connection = url.openConnection();
            
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

    private static ArrayList<Appointment> apptQuery(String query) {
        ArrayList<Appointment> apptList = new ArrayList<>();
        try {
            JSONArray jsonArr = new JSONArray(doQuery(query));
            for (int i = 0; i < jsonArr.length(); ++i) {
                JSONObject obj = jsonArr.getJSONObject(i);
                Date apptTime = Util.jDate(obj.getString("DATE"));
                if (apptTime != null) {
                    Appointment appt = new Appointment(obj.getInt("V_ID"),
                            obj.getInt("S_ID"),
                            obj.getInt("P_ID"),
                            obj.getString("REASON"),
                            obj.getString("SUMMARY"),
                            apptTime);
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
            JSONArray jsonArr = new JSONArray(doQuery(query));
            for (int i = 0; i < jsonArr.length(); ++i) {
                JSONObject obj = jsonArr.getJSONObject(i);
                Date dob = Util.jDate(obj.getString("DOB"));
                if (dob != null) {
                    Patient patient = new Patient(obj.getInt("P_ID"),
                            obj.getString("PFNAME"),
                            obj.getString("PLNAME"),
                            obj.getDouble("BALANCE"),
                            obj.getString("EMAIL"),
                            obj.getString("AREA_CODE"),
                            obj.getString("PHONE"),
                            obj.getString("INSURANCE"),
                            obj.getString("USERNAME"),
                            obj.getString("PASSWORD"),
                            dob);
                    patientList.add(patient);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return patientList;
    }
    
    private static ArrayList<Medication> rxQuery(String query) {
        ArrayList<Medication> rxList = new ArrayList<>();
        try {
            JSONArray jsonArr = new JSONArray(doQuery(query));
            for (int i = 0; i < jsonArr.length(); ++i) {
                JSONObject obj = jsonArr.getJSONObject(i);
                Dosage dose = new Dosage(Integer.valueOf(obj.getString("Dosage")), obj.getString("DosageUnit"));
                if (dose != null) {
                    Medication med = new Medication(obj.getInt("RxID"),
                            obj.getInt("V_ID"),
                            dose);
                    rxList.add(med);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rxList;
    }
    
    private static ArrayList<Staff> staffQuery(String query) {
        ArrayList<Staff> staffList = new ArrayList<>();
        try {
            JSONArray jsonArr = new JSONArray(doQuery(query));
            for (int i = 0; i < jsonArr.length(); ++i) {
                JSONObject obj = jsonArr.getJSONObject(i);
                Date hireDate = Util.jDate(obj.getString("DOH"));
                if (hireDate != null) {
                    Staff staff = new Staff(obj.getInt("S_ID"),
                            obj.getString("SFName"),
                            obj.getString("SLName"),
                            obj.getString("USERNAME"),
                            obj.getString("PASSWORD"),
                            obj.getInt("AccessLevel"),
                            hireDate);
                    staffList.add(staff);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return staffList;
    }
    
    public static ArrayList<Appointment> allAppointments() {
        return apptQuery("SELECT * FROM APPOINTMENTS;");
    }
    
    public static ArrayList<Appointment> searchAppointments(String key, int value) {
        return apptQuery("SELECT * FROM PATIENT WHERE " + key + "=" + Util.sqlValue(value) + ";");
    }
    
    public static ArrayList<Appointment> searchAppointments(String key, String value) {
        return apptQuery("SELECT * FROM PATIENT WHERE " + key + "=" + Util.sqlValue(value) + ";");
    }
    
    public static ArrayList<Patient> allPatients() {
        return patientQuery("SELECT * FROM PATIENT;");
    }
    
    public static ArrayList<Patient> searchPatients(String key, int value) {
        return patientQuery("SELECT * FROM PATIENT WHERE " + key + "=" + Util.sqlValue(value) + ";");
    }
    
    public static ArrayList<Patient> searchPatients(String key, String value) {
        return patientQuery("SELECT * FROM PATIENT WHERE " + key + "=" + Util.sqlValue(value) + ";");
    }
    
    public static ArrayList<Medication> allPrescriptions() {
        return rxQuery("SELECT * FROM PRESCRIPTIONS;");
    }
    
    public static ArrayList<Medication> searchPrescriptions(String key, int value) {
        return rxQuery("SELECT * FROM PRESCRIPTIONS WHERE " + key + "=" + Util.sqlValue(value) + ";");
    }
    
    public static ArrayList<Medication> searchPrescriptions(String key, String value) {
        return rxQuery("SELECT * FROM PRESCRIPTIONS WHERE " + key + "=" + Util.sqlValue(value) + ";");
    }
    
    public static ArrayList<Staff> allStaff() {
        return staffQuery("SELECT * FROM STAFF;");
    }
    
    public static ArrayList<Staff> searchStaff(String key, int value) {
        return staffQuery("SELECT * FROM STAFF WHERE " + key + "=" + Util.sqlValue(value) + ";");
    }
    
    public static ArrayList<Staff> searchStaff(String key, String value) {
        return staffQuery("SELECT * FROM STAFF WHERE " + key + "=" + Util.sqlValue(value) + ";");
    }

    public static boolean patientExists(Patient patient) {
        String searchQuery = "SELECT * FROM `PATIENT` WHERE `P_ID` = ";
        searchQuery += Util.sqlValue(patient.getID()) + " ORDER BY `P_ID` ASC";
        String searchResult = doQuery(searchQuery);
        if (searchResult.equals("[]")) {
            return false;
        }
        return true;
    }
    
    public static boolean insertPatient(Patient patient) {
        if (patientExists(patient)) {
            return false;
        }
        String insertStmt = "INSERT INTO `PATIENT`";
        insertStmt += "(`P_ID`, `PLNAME`, `PFNAME`, `DOB`, `EMAIL`, `PHONE`, `INSURANCE`, `BALANCE`, `U_ID`, `USERNAME`, `PASSWORD`)";
        insertStmt += " VALUES (";
        insertStmt += Util.sqlValue(patient.getID()) + ", ";
        insertStmt += Util.sqlValue(patient.getLastName()) + ", ";
        insertStmt += Util.sqlValue(patient.getFirstName()) + ", ";
        insertStmt += Util.sqlValue(patient.getBirthDate()) + ", ";
        insertStmt += Util.sqlValue(patient.getEmail()) + ", ";
        insertStmt += Util.sqlValue(patient.getPhoneNum()) + ", ";
        insertStmt += Util.sqlValue(patient.getInsurance()) + ", ";
        insertStmt += Util.sqlValue(patient.getBalance()) + ", ";
        insertStmt += Util.sqlValue(17) + ", ";
        insertStmt += Util.sqlValue(patient.getUsername()) + ", ";
        insertStmt += Util.sqlValue(patient.getPassword()) + ");";
        doQuery(insertStmt);
        return true;
    }
}
