/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xyzmedical.controller;

import xyzmedical.utilities.HttpConnection;

/**
 *
 * @author samar
 */
public class TestResultsController {

    
        public static String getUsersTestResults(int U_ID) {
        
        try {
            
            return HttpConnection.HttpConnection("SELECT * FROM LABRESULTS WHERE U_ID = " + U_ID);
            
        } catch(Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}