package xyzmedical.model;

import org.json.JSONObject;

public class Prescriptions {

    private int rx_id, v_id;
    private String dosage, dosageUnit;

    public Prescriptions(JSONObject jsonObject) {

        rx_id       =       jsonObject.getInt("RxID");
        v_id        =       jsonObject.getInt("V_ID");
        dosage      =       jsonObject.getString("Dosage");
        dosageUnit  =       jsonObject.getString("DosageUnit");

    }

    public int getRx_id() {
        return rx_id;
    }

    public void setRx_id(int rx_id) {
        this.rx_id = rx_id;
    }

    public int getV_id() {
        return v_id;
    }

    public void setV_id(int v_id) {
        this.v_id = v_id;
    }

    public String getDosage() {
        return dosage;
    }

    public void setDosage(String dosage) {
        this.dosage = dosage;
    }

    public String getDosageUnit() {
        return dosageUnit;
    }

    public void setDosageUnit(String dosageUnit) {
        this.dosageUnit = dosageUnit;
    }
}
