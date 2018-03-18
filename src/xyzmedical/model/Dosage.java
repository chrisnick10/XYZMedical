package xyzmedical.model;

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
