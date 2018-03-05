/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xyzmedical.record;

import java.sql.Date;

/**
 *
 * @author Will
 */
public class Staff extends Person {
    protected int access;
    protected Date hireDate;
    
    public Staff(int ID, String firstName, String lastName, Date hireDate) {
        super(ID, firstName, lastName);
        this.access = 0;
        this.hireDate = hireDate;
    }
    
    public int getAccessLevel() {
        return access;
    }
    
    public Date getHireDate() {
        return hireDate;
    }
}
