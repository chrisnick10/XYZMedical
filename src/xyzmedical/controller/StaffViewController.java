package xyzmedical.controller;

import java.util.ArrayList;
import xyzmedical.model.Staff;

import xyzmedical.db.Database;
/**
 *
 * @author cjwn
 */
public class StaffViewController {
    public static boolean isNewStaff(int U_ID) {
        return Database.staffExists(U_ID);
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
