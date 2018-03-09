/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xyzmedical.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONArray;
import static xyzmedical.utilities.HttpConnection.HttpConnection;

/**
 *
 * @author christian
 */
public class LoginViewController {
    
    
    
    public static String login(String userName, String userPassword) {
        
        String userQuery = "SELECT userName FROM USER;";
        String jsonResult;
        
        try {
            jsonResult = HttpConnection(userQuery);
            JSONArray jsonArr = new JSONArray(jsonResult);
            List<String> userList = new ArrayList<String>();
            for (int i = 0; i < jsonArr.length(); i++) {
                userList.add(jsonArr.getJSONObject(i).getString("userName"));
            }
            
            boolean match = false;
            for (String user: userList) {
                if (user.equals(userName)) {
                    match = true;
                }
            }
            if (!match) {
                return "NU";
            }
            
            String passwordQuery = "SELECT userPassword, userType FROM USER WHERE userName = '" +userName+"';" ;
            jsonResult = HttpConnection(passwordQuery);
            jsonArr = new JSONArray(jsonResult);
            String upass = jsonArr.getJSONObject(0).getString("userPassword");
            System.out.println("DB user password: "+upass);
            System.out.println("entered user password: "+userPassword);
            if (!upass.equals(userPassword)) {
                System.out.println("password don't match");
                return "IP";
            }
            
            char userType = jsonArr.getJSONObject(0).getString("userType").charAt(0);
            if (userType == 'P') {
                return "P";
            } else if (userType == 'S') {
                return "S";
            }
            
            
        } catch (Exception ex) {
            Logger.getLogger(LoginViewController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
        return "";
    }
    
}
