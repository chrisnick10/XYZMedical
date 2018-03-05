/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xyzmedical.record;

import java.sql.Date;
import java.sql.Time;

/**
 *
 * @author Will
 */
public class Visit {
    protected int ID;
    protected int doctor;
    protected int patient;
    protected String reason;
    protected Date date;
    protected Time time;
}
