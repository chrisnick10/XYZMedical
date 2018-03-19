package xyzmedical.model;

/**
 *
 * @author Will
 */
public class Dosage {
    protected int amount;
    protected String unit;
    
    public Dosage(int amount, String unit) {
        this.amount = amount;
        this.unit = unit;
    }
    
    public int getAmount() {
        return this.amount;
    }
    
    public String getUnit() {
        return this.unit;
    }
    
    @Override
    public String toString() {
        return String.valueOf(amount) + unit;
    }
}
