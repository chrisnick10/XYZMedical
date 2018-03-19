/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xyzmedical.db;

import java.util.ArrayList;

/**
 *
 * @author Will
 */
class InsertStmtBuilder extends StmtBuilder {

    public InsertStmtBuilder(String table) {
        super(table);
    }

    @Override
    public String generateStmt() {
        String stmt = "INSERT INTO `CSI-3370`." + table + " (";
        for (int i = 0; i < fields.size(); ++i) {
            stmt += fields.get(i);
            if (i < fields.size() - 1) {
                stmt += ", ";
            }
        }
        stmt += ") VALUES (";
        for (int i = 0; i < values.size(); ++i) {
            stmt += values.get(i);
            if (i < values.size() - 1) {
                stmt += ", ";
            }
        }
        stmt += ");";
        return stmt;
    }
}
