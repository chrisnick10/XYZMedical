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
 * @author Will
 */
public class Appointment {

    private int v_id, s_id, p_id;
    private String reason, date, summary;

    public Appointment(JSONObject json) throws JSONException {
        this.v_id       =       json.getInt("V_ID");
        this.s_id       =       json.getInt("S_ID");
        this.p_id       =       json.getInt("P_ID");
        this.reason     =       json.getString("REASON");
        this.date       =       json.getString("DATE");
        this.summary    =       json.getString("SUMMARY");
    }

    public int getV_id() {
        return v_id;
    }

    public void setV_id(int v_id) {
        this.v_id = v_id;
    }

    public int getS_id() {
        return s_id;
    }

    public void setS_id(int s_id) {
        this.s_id = s_id;
    }

    public int getP_id() {
        return p_id;
    }

    public void setP_id(int p_id) {
        this.p_id = p_id;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

}
