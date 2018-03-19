/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xyzmedical.db;

/**
 *
 * @author Will
 */
public class DeleteStmtBuilder extends StmtBuilder {

    public DeleteStmtBuilder(String table) {
        super(table);
    }

    @Override
    public String generateStmt() {
        String stmt = "DELETE * FROM " + table;

        if (fields.size() > 0) {
            stmt += " WHERE";
            int lastIdx = fields.size() - 1;
            for (int i = 0; i < fields.size(); ++i) {
                stmt += " " + fields.get(i) + " = " + values.get(i);
                if (i < lastIdx) { 
                    stmt += " AND";
                }
            }
        }
        return stmt;
    }
}
