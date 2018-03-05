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
public class Medicine {
    protected int ID;
    protected int visitID;
    protected Dosage dosage;
    
    public Medicine(int ID, int visitID, Dosage dosage) {
        this.ID = ID;
        this.visitID = visitID;
        this.dosage = dosage;
    }
    
    public int getID() {
        return this.ID;
    }
    
    public int getVisitID() {
        return this.visitID;
    }
    
    public Dosage getDosage() {
        return this.dosage;
    }
}
