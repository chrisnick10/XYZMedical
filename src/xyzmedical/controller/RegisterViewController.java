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
import static xyzmedical.utilities.HttpConnection.HttpConnection;

/**
 *
 * @author christian
 */
public class RegisterViewController {
    
    public static boolean register(String userName, String userPassword, char userType) {
        
        String usernameQuery = "SELECT userName FROM USER;";
        String insertQuery = "INSERT INTO 'USER' ('userName', 'userPassword', 'userType') VALUES ('" +
                userName+"','"+userPassword+"','"+userType+"');";
        
        String resultString;
        try {
            resultString = HttpConnection(usernameQuery);
            //System.out.println(resultString);
            
            
            JSONArray jsonArr = new JSONArray(resultString);
            List<String> userList = new ArrayList<String>();
            for (int i = 0; i < jsonArr.length(); i++) {
                userList.add(jsonArr.getJSONObject(i).getString("userName"));
            }
            
            for (String s: userList) {
                if (!s.equals(userName)) {
                    System.out.println(insertQuery);
                    String insertString = HttpConnection(insertQuery);
                    System.out.println(insertString);
                    return true;
                }
            }
            
            return false;
            
        } catch (Exception ex) {
            Logger.getLogger(RegisterViewController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }
}
