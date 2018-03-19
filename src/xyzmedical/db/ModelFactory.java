package xyzmedical.db;

import java.sql.Date;
import java.sql.Timestamp;
import org.json.*;

import xyzmedical.model.*;
/**
 *
 * @author Will
 */
class ModelFactory {
    private static boolean isNull(JSONObject obj, String key) {
        if (obj == null || key == null || !obj.has(key)) {
            return true;
        }
        String valStr = obj.get(key).toString();
        if (valStr.equals("null")) {
            return true;
        }
        return false;
    }

    public static Appointment createAppointment(JSONObject obj) {
        if (obj == null) {
            return null;
        }
        Timestamp apptTime = Util.jTimestamp(obj.getString("TIME"));
        if (apptTime != null) {
            Appointment appt = new Appointment(obj.getInt("ID"),
                    obj.getInt("STAFF_ID"),
                    obj.getInt("PATIENT_ID"),
                    obj.getString("REASON"),
                    obj.getString("SUMMARY"),
                    apptTime);
            return appt;
        }
        return null;
    }
    
    public static MedInfo createMedInfo(JSONObject obj) {
        if (obj == null) {
            return null;
        }
        
        String description = "";
        if (!isNull(obj, "DESCRIPTION")) {
            description = obj.getString("DESCRIPTION");
        }
        
        String sideEffects = "";
        if (!isNull(obj, "SIDE_EFFECTS")) {
            sideEffects = obj.getString("SIDE_EFFECTS");
        }

        MedInfo info = new MedInfo(obj.getInt("ID"),
                obj.getString("NAME"),
                obj.getString("USAGE"),
                description,
                sideEffects);
        return info;
    }
    
    public static Patient createPatient(JSONObject obj) {
        if (obj == null) {
            return null;
        }
        
        int pcp = -1;
        if (!isNull(obj, "PCP")) {
            pcp = obj.getInt("PCP");
        }
         
        String email = "";
        if (!isNull(obj, "EMAIL")) {
            email = obj.getString("EMAIL");
        }
        
        String phone = "";
        if (!isNull(obj, "MAINPHONE")) {
            phone = obj.getString("MAINPHONE");
        }
        
        String insurance = "";
        if (!isNull(obj, "INSURANCE")) {
            insurance = obj.getString("INSURANCE");
        }
        
        Date dob = Util.jDate(obj.getString("BIRTH_DATE"));
        
        Patient p = null;
        if (dob != null) {
            p = new Patient(obj.getInt("ID"),
                    obj.getString("FIRSTNAME"),
                    obj.getString("LASTNAME"),
                    obj.getString("USERNAME"),
                    obj.getString("PASSWORD"),
                    pcp,
                    obj.getFloat("BALANCE"),
                    email,
                    phone,
                    insurance,
                    dob);
        }
        return p;
    }
    
    public static Prescription createPrescription(JSONObject obj) {
        if (obj == null) {
            return null;
        }
        
        int apptId = -1;
        if (!isNull(obj, "APPT_ID")) {
            apptId = obj.getInt("APPT_ID");
        }

        Dosage dosage = new Dosage(obj.getInt("DOSE_AMNT"), 
                obj.getString("DOSE_UNIT"));
        Frequency freq = new Frequency(obj.getInt("FREQ_AMNT"), 
                obj.getString("FREQ_UNIT"));
        Date date = Util.jDate(obj.getString("DATE"));

        Prescription med = new Prescription(apptId, obj.getInt("MED_ID"),
                obj.getInt("STAFF_ID"),
                obj.getInt("PATIENT_ID"),
                obj.getInt("DOSES"),
                obj.getInt("REFILLS"),
                dosage,
                freq,
                date);
        return med;
    }
    
    public static Staff createStaff(JSONObject obj) {
        if (obj == null) {
            return null;
        }
        
        Date birthDate = null;
        if (!isNull(obj, "BIRTH_DATE")) {
            birthDate = Util.jDate(obj.getString("BIRTH_DATE"));
        }
        
        Date hireDate = null;
        if (!isNull(obj, "HIRE_DATE")) {
            hireDate = Util.jDate(obj.getString("HIRE_DATE"));
        }
        
        Staff staff = new Staff(obj.getInt("ID"), 
                obj.getInt("ACCESSLVL"),
                obj.getString("FIRSTNAME"),
                obj.getString("LASTNAME"),
                obj.getString("USERNAME"),
                obj.getString("LASTNAME"),
                birthDate,
                hireDate);
        return staff;
    }
}
