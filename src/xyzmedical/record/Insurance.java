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
public class Insurance {
    protected int ID;
    protected int group;
    protected String provider;
    protected String plan;
    
    public Insurance(int ID, int group, String provider, String plan) {
        this.ID = ID;
        this.group = group;
        this.provider = provider;
        this.plan = plan;
    }
    
    public int getID() {
        return this.ID;
    }
    
    public int getGroup() {
        return this.group;
    }
    
    public String getProvider() {
        return this.provider;
    }
    
    public String getPlan() {
        return this.plan;
    }
}
