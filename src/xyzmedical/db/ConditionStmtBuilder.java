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
abstract class ConditionStmtBuilder extends StmtBuilder {
    protected ArrayList<String> condFields;
    protected ArrayList<String> condValues;
    
    public ConditionStmtBuilder(String table) {
        super(table);
        condFields = new ArrayList<>();
        condValues = new ArrayList<>();
    }
    
    public void addCondition(String field, Date value) {
        condFields.add(Util.sqlTableAttrib(field));
        condValues.add(Util.sqlValue(value));
    }
    
    public void addCondition(String field, Timestamp value) {
        condFields.add(Util.sqlTableAttrib(field));
        condValues.add(Util.sqlValue(value));
    }
    
    public void addCondition(String field, String value) {
        condFields.add(Util.sqlTableAttrib(field));
        condValues.add(Util.sqlValue(value));
    }
    
    public void addCondition(String field, int value) {
        condFields.add(Util.sqlTableAttrib(field));
        condValues.add(Util.sqlValue(value));
    }
    
    public void addCondition(String field, double value) {
        condFields.add(Util.sqlTableAttrib(field));
        condValues.add(Util.sqlValue(value));
    }

    @Override
    public abstract String generateStmt();
}
