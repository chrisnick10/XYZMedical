/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xyzmedical.controller;

/**
 *
 * @author christian
 */
public class RegisterViewController {
    
    public static boolean register(String userName, String userPassword, char userType) {
        
        String usernameQuery = "SELECT userName FROM USER;";
        
        System.out.println(userName+" "+userPassword+" "+userType);
        
        return true;
    }
}
