package xyzmedical.model;

import java.sql.Date;
import xyzmedical.db.Util;

/**
 *
 * @author Will
 */
public class Patient extends Person {
    private int primaryCareProvider;
    private float balance;
    private String email;
    private String phoneNum;
    private String insurance;
    private Date birthDate;
    
    public Patient(int ID, String firstName, String lastName, String username,
                String password, int primaryCareProvider, float balance, 
                String email, String phoneNum, String insurance,
                Date birthDate) {
        super(ID, firstName, lastName, username, password);
        this.primaryCareProvider = primaryCareProvider;
        this.balance = balance;
        setInsurance(insurance);
        setEmail(email);
        setPhoneNum(phoneNum);
        this.birthDate = birthDate;
    }
    
    public int getPrimaryCareProvider() {
        return this.primaryCareProvider;
    }
    
    public String getEmail() {
        return this.email;
    }
    
    public String getPhoneNum() {
        return this.phoneNum;
    }
    
    public String getInsurance() {
        return this.insurance;
    }
    
    public float getBalance() {
        return this.balance;
    }
    
    public Date getBirthDate() {
        return this.birthDate;
    }
    
    public boolean setBalance(float balance) {
        this.balance = balance;
        return true;
    }
    
    public boolean setPrimaryCareProvider(int pcp) {
        this.primaryCareProvider = pcp;
        return (pcp >= 0);
    }
    
    public boolean setEmail(String email) {
        if (email == null) {
            this.email = "";
        } else {
            this.email = email;
            return true;
        }
        return false;
    }
    
    public boolean setPhoneNum(String phoneNum) {
        if (phoneNum == null) {
            this.phoneNum = "";
        } else {
            this.phoneNum = phoneNum;
            return true;
        }
        return false;
    }
    
    public boolean setInsurance(String insurance) {
        if (insurance == null) {
            this.insurance = "";
        } else {
            this.insurance = insurance;
            return true;
        }
        return false;
    }
    
    public boolean setBirthDate(Date dob) {
        this.birthDate = dob;
        return true;
    }
}
