package xyzmedical.model;

import java.util.Date;

/**
 *
 * @author Will
 */
public class Staff extends Person {
    protected int access;
    protected Date hireDate;
    
    public Staff(int ID, String fName, String lName, String username, String password, int accessLvl, Date hireDate) {
        super(ID, fName, lName, username, password);
        this.access = accessLvl;
        this.hireDate = hireDate;
    }
    
    public int getAccessLevel() {
        return access;
    }
    
    public Date getHireDate() {
        return hireDate;
    }
}
