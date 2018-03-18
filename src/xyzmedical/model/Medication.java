package xyzmedical.model;

/**
 *
 * @author Will
 */
public class Medication {
    protected int ID;
    protected int visitId;
    protected Dosage dosage;
    
    public Medication(int ID, int visitId, Dosage dosage) {
        this.ID = ID;
        this.visitId = visitId;
        this.dosage = dosage;
    }
    
    @Override
    public String toString() {
        String dosageStr = String.valueOf(this.dosage.getDosage()) + " " + this.dosage.getUnit();
        return "[" + this.ID + "] " + dosageStr;
    }
    
    public int getVisitID() {
        return visitId;
    }
    
    public Dosage getDosage() {
        return dosage;
    }
}
