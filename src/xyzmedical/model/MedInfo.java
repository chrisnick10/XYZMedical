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
public class MedInfo {
    private int ID;
    private String name;
    private String usage;
    private String description;
    private String sideEffects;
    
    public MedInfo(int ID, String name, String usage) {
        this.ID = ID;
        this.name = name;
        this.usage = usage;
        this.description = "";
        this.sideEffects = "";
    }
    
    public MedInfo(int ID, String name, String usage, String description, 
            String sideEffects) {
        this.ID = ID;
        this.name = name;
        this.usage = usage;
        this.description = description;
        this.sideEffects = sideEffects;
    }
    
    public int getID() {
        return this.ID;
    }
    
    public String getName() {
        return this.name;
    }
    
    public String getUsage() {
        return this.usage;
    }
    
    public String getDescription() {
        return this.description;
    }
    
    public String getSideEffects() {
        return this.sideEffects;
    }
    
    public boolean setName(String name) {
        if (name == null) {
            return false;
        } else {
            this.name = name;
        }
        return true;
    }
    
    public boolean setUsage(String usage) {
        if (usage == null) {
            return false;
        } else {
            this.usage = usage;
        }
        return true;
    }
    
    public boolean setDescription(String description) {
        if (description == null) {
            return false;
        } else {
            this.description = description;
        }
        return true;
    }
    
    public boolean setSideEffects(String sideEffects) {
        if (sideEffects == null) {
            return false;
        } else {
            this.sideEffects = sideEffects;
        }
        return true;
    }
    
    @Override
    public String toString() {
        return "[" + String.valueOf(ID) + "] " + this.name;
    }
}
