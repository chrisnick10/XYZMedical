/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xyzmedical.model;

/**
 *
 * @author Will
 */
public class Frequency {
    protected int count;
    protected String timeUnit;
    
    public Frequency(int count, String timeUnit) {
        this.count = count;
        this.timeUnit = timeUnit;
    }
    
    public int getCount() {
        return this.count;
    }
    
    public String getTimeUnit() {
        return this.timeUnit;
    }
    
    @Override
    public String toString() {
        return String.valueOf(count) + "/" + timeUnit;
    }
}
