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
public class Dosage {
    protected int dosage;
    protected String unit;
    
    public Dosage(int dosage, String unit) {
        this.dosage = dosage;
        this.unit = unit;
    }
    
    public int getDosage() {
        return this.dosage;
    }
    
    public String getUnit() {
        return this.unit;
    }
}
