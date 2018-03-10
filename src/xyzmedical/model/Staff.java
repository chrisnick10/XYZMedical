package xyzmedical.model;

import org.json.JSONObject;

public class Staff {

    private int s_id;
    private String last_name, first_name, accessLevel, date_hire;

    public Staff(JSONObject jsonObject) {
        s_id        =       jsonObject.getInt("S_ID");
        last_name   =       jsonObject.getString("SLName");
        first_name  =       jsonObject.getString("SFName");
        accessLevel =       jsonObject.getString("AccessLevel");
        date_hire   =       jsonObject.getString("DOH");
    }

    public int getS_id() {
        return s_id;
    }

    public void setS_id(int s_id) {
        this.s_id = s_id;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getAccessLevel() {
        return accessLevel;
    }

    public void setAccessLevel(String accessLevel) {
        this.accessLevel = accessLevel;
    }

    public String getDate_hire() {
        return date_hire;
    }

    public void setDate_hire(String date_hire) {
        this.date_hire = date_hire;
    }
}