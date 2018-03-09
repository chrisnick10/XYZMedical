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
    
    
    
    public static String login(String userName, String passWord) {
        
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
            
        } catch (Exception ex) {
            Logger.getLogger(LoginViewController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
        return "";
    }
    
}
