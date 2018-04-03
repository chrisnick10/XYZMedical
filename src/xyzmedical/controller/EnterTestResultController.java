/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xyzmedical.controller;

import org.json.JSONArray;
import xyzmedical.utilities.HttpConnection;

/**
 *
 * @author samar
 */
public class EnterTestResultController {
    
    public static void enterTestResult(int p_id, String testName, String testResult) {
        try {
            
            String q = "SELECT U_ID FROM PATIENT WHERE P_ID = " + p_id + ";";
            
            JSONArray jsonA = new JSONArray(HttpConnection.HttpConnection(q));
            
            System.out.print(HttpConnection.HttpConnection(q));
            
            String insertQ = String.format( "INSERT INTO LABRESULTS (L_ID, U_ID, P_ID, TEST, RESULT) VALUES (NULL, '%s', '%d', '%s', '%s');",
                                                jsonA.getJSONObject(0).getString("U_ID"), p_id, testName, testResult);
            
            System.out.print(HttpConnection.HttpConnection(insertQ));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
