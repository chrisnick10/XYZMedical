/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xyzmedical.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONArray;
import static xyzmedical.util.HttpConnection.HttpConnection;

/**
 *
 * @author christian
 */
public class RegisterViewController {
    
    public static boolean register(String userName, String userPassword, char userType) {
        
        String usernameQuery = "SELECT userName FROM USER;";
        String resultString;
        
        try {
            // get json result string
            resultString = HttpConnection(usernameQuery);
            
            // convert json string to json array and create list array
            JSONArray jsonArr = new JSONArray(resultString);
            List<String> userList = new ArrayList<String>();
            for (int i = 0; i < jsonArr.length(); i++) {
                userList.add(jsonArr.getJSONObject(i).getString("userName"));
            }
            
            // check list array for matching username and return false if found
            for (String s: userList) {
                if (s.equals(userName)) {
                    System.out.println("username matches");
                    return false;
                } else {
                }
            }
            
            // if not found, then insert new data into database and return true
            String insertQuery = "INSERT INTO USER (userID,userName,userPassword,userType) VALUES (NULL,'"+
                userName+"','"+userPassword+"','"+userType+"');";
            
            resultString = HttpConnection(insertQuery);
            return true;
        } catch (Exception ex) {
            Logger.getLogger(RegisterViewController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }
}
