package xyzmedical.model;

import org.json.JSONObject;

public class User {

    private int userID;
    private String userName;
    private char userType;

    public User(JSONObject jsonObject) throws Exception {

        userID      =       jsonObject.getInt("userID");
        userName    =       jsonObject.getString("userName");
        userType    = (char)jsonObject.get("userType");
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public char getUserType() {
        return userType;
    }

    public void setUserType(char userType) {
        this.userType = userType;
    }
}