/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xyzmedical.record;

/**
 *
 * @author Will
 */
public abstract class Person {
    protected int ID;
    protected String firstName;
    protected String lastName;
    
    public Person(int ID, String firstName, String lastName) {
        this.ID = ID;
        this.firstName = firstName;
        this.lastName = lastName;
    }
    
    public int getID() {
        return ID;
    }
    
    public String getFirstName() {
        return firstName;
    }
    
    public String getLastName() {
        return lastName;
    }
}
