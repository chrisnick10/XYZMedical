package xyzmedical.model;

import java.sql.Date;

/**
 *
 * @author Will
 */
public class Staff extends Person {
    private int access;
    private Date birthDate;
    private Date hireDate;
    
    public Staff(int ID, int accessLevel, String firstName, String lastName, 
                String username, String password, Date birthDate, 
                Date hireDate) {
        super(ID, firstName, lastName, username, password);
        this.access = accessLevel;
        this.birthDate = birthDate;
        this.hireDate = hireDate;
    }
    
    public int getAccessLevel() {
        return this.access;
    }
    
    public Date getBirthDate() {
        return this.birthDate;
    }
    
    public Date getHireDate() {
        return this.hireDate;
    }
}
