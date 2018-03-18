package xyzmedical.model;

import java.util.Date;

/**
 *
 * @author Will
 */
public class Patient extends Person {
    protected double balance;
    protected String email;
    protected String areaCode;
    protected String phoneNum;
    protected String insurance;
    protected Date birthDate;
    
    public Patient(int ID, String fName, String lName, double balance, String email, String area, String phoneNum, String insurance, String username, String password, Date dob) {
        super(ID, fName, lName, username, password);
        this.balance = balance;
        this.email = email;
        this.areaCode = area;
        this.phoneNum = phoneNum;
        this.insurance = insurance;
        this.birthDate = dob;
    }
    
    public double getBalance() {
        return balance;
    }
    
    public String getEmail() {
        return email;
    }
    
    public String getPhoneNum() {
        return areaCode + phoneNum;
    }
    
    public String getInsurance() {
        return insurance;
    }
    
    public Date getBirthDate() {
        return birthDate;
    }
    
    public boolean setBalance(double balance) {
        this.balance = balance;
        return true;
    }
    
    public boolean setEmail(String email) {
        if (email != null) {
            this.email = email;
            return true;
        }
        return false;
    }
    
    public boolean setPhoneNum(String areaCode, String phoneNum) {
        if (areaCode != null && phoneNum != null) {
            this.areaCode = areaCode;
            this.phoneNum = phoneNum;
            return true;
        }
        return false;
    }
    
    public boolean setInsurance(String insurance) {
        if (insurance != null) {
            this.insurance = insurance;
            return true;
        }
        return false;
    }
}
