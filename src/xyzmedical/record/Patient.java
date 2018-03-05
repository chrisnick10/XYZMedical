/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xyzmedical.record;

import java.sql.Date;
import java.util.regex.*;

/**
 *
 * @author Will
 */
public class Patient extends Person {
    protected Date dateOfBirth;
    protected String email;
    protected String mainPhoneNum;
    protected Insurance insurance;
    
    // Regex patterns to validate input
    protected static Pattern emailPattern;
    protected static Pattern phoneNumPattern;
    
    static {
        emailPattern = Pattern.compile("^\\w+@[a-zA-Z_]+?\\.[a-zA-Z]{2,3}$");
        phoneNumPattern = Pattern.compile("^[2-9]\\d{2}-\\d{3}-\\d{4}$");
    }
    
    public Patient(int ID, String firstName, String lastName, Date dob) {
        super(ID, firstName, lastName);
        this.dateOfBirth = dob;
        this.email = "";
        this.mainPhoneNum = "";
        this.insurance = null;
    }
    
    public Date getDob() {
        return this.dateOfBirth;
    }
    
    public String getEmail() {
        return this.email;
    }
    
    public String getMainPhoneNum() {
        return this.mainPhoneNum;
    }
    
    public Insurance getInsurance() {
        return this.insurance;
    }
    
    public void setEmail(String email) throws StrFormatException {
        Matcher m = emailPattern.matcher((CharSequence) email);
        if (m.matches()) {
            this.email = email;
        }
        throw new StrFormatException("Bad email string format");
    }
    
    public void setMainPhoneNum(String phoneNum) throws StrFormatException {
        Matcher m = phoneNumPattern.matcher((CharSequence) phoneNum);
        if (m.matches()) {
            this.mainPhoneNum = phoneNum;
        }
        throw new StrFormatException("Bad phone number string format");
    }
}
