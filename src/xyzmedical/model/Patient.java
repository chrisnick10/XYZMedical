/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xyzmedical.model;

import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author Samartha Mudigere
 */
public class Patient {

    
    private int P_ID;
    private String p_lname, p_fname, p_dob, p_email, p_phone, p_insurace, p_balance, p_uid;
    
    public Patient(JSONObject json) throws JSONException {
        
        P_ID        =       json.getInt("P_ID");
        p_lname     =       json.getString("PLNAME");
        p_fname     =       json.getString("PFNAME");
        p_dob       =       json.getString("DOB");
        p_email     =       json.getString("EMAIL");
        p_phone     =       json.getString("PHONE");
        p_insurace  =       json.getString("INSURANCE");
        p_balance   =       json.getString("BALANCE");
        p_uid       =       json.getString("U_ID");
    }
    
    public int getP_ID() {
        return P_ID;
    }

    public void setP_ID(int P_ID) {
        this.P_ID = P_ID;
    }

    public String getP_lname() {
        return p_lname;
    }

    public void setP_lname(String p_lname) {
        this.p_lname = p_lname;
    }

    public String getP_fname() {
        return p_fname;
    }

    public void setP_fname(String p_fname) {
        this.p_fname = p_fname;
    }

    public String getP_dob() {
        return p_dob;
    }

    public void setP_dob(String p_dob) {
        this.p_dob = p_dob;
    }

    public String getP_email() {
        return p_email;
    }

    public void setP_email(String p_email) {
        this.p_email = p_email;
    }

    public String getP_phone() {
        return p_phone;
    }

    public void setP_phone(String p_phone) {
        this.p_phone = p_phone;
    }

    public String getP_insurace() {
        return p_insurace;
    }

    public void setP_insurace(String p_insurace) {
        this.p_insurace = p_insurace;
    }
    
    public String getP_balance() {
        return p_balance;
    }
    
    public void setP_balance(String p_balance) {
        this.p_balance = p_balance;
    }
    
    public String getP_uid() {
        return p_uid;
    }
    
    public void setP_uid(String p_uid) {
        this.p_uid = p_uid;
    }
}
