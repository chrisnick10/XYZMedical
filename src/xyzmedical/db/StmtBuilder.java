/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xyzmedical.db;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;

/**
 *
 * @author Will
 */
abstract class StmtBuilder {
    protected String table;
    protected ArrayList<String> fields;
    protected ArrayList<String> values;
    
    public StmtBuilder(String table) {
        this.table = Util.sqlTableAttrib(table);
        this.fields = new ArrayList<>();
        this.values = new ArrayList<>();
    }
    
    public void add(String field, Date value) {
        fields.add(Util.sqlTableAttrib(field));
        values.add(Util.sqlValue(value));
    }
    
    public void add(String field, Timestamp value) {
        fields.add(Util.sqlTableAttrib(field));
        values.add(Util.sqlValue(value));
    }
    
    public void add(String field, String value) {
        fields.add(Util.sqlTableAttrib(field));
        values.add(Util.sqlValue(value));
    }
    
    public void add(String field, int value) {
        fields.add(Util.sqlTableAttrib(field));
        values.add(Util.sqlValue(value));
    }
    
    public void add(String field, double value) {
        fields.add(Util.sqlTableAttrib(field));
        values.add(Util.sqlValue(value));
    }
    
    public abstract String generateStmt();
}
