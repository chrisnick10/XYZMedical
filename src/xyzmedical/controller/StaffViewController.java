/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xyzmedical.controller;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONArray;
import xyzmedical.db.Database;
import xyzmedical.model.Staff;
import static xyzmedical.util.HttpConnection.HttpConnection;

import xyzmedical.db.Database;
/**
 *
 * @author cjwn
 */
public class StaffViewController {
    
    
    public static boolean isNewStaff(int U_ID) {
        ArrayList<Staff> staffList = Database.searchStaff("S_ID", U_ID);
        if (staffList.size() == 0) {
            return true;
        }
        return false;
    }
    
    public static Staff getStaffInformation(int U_ID) {
        Staff staffMember = null;
        ArrayList<Staff> staffList = Database.searchStaff("S_ID", U_ID);
        if (staffList.size() > 0) {
            staffMember = staffList.get(0);
        }
        return staffMember;
    }
}
