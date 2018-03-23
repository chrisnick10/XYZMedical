package xyzmedical.db;

/**
 *
 * @author Will
 */
class UpdateStmtBuilder extends ConditionStmtBuilder {
    public UpdateStmtBuilder(String table) {
        super(table);
    }

    @Override
    public String generateStmt() {
        if (condFields.size() < 1) {
            return "";
        }

        String stmt = "UPDATE " + table + " SET ";
        int lastIdx = fields.size() - 1;
        for (int i = 0; i < fields.size(); ++i) {
            stmt += fields.get(i) + "=" + values.get(i);
            if (i < lastIdx) {
                stmt += ", ";
            }
        }
        
        stmt += " WHERE ";
        lastIdx = condFields.size() - 1;
        for (int i = 0; i < condFields.size(); ++i) {
            stmt += condFields.get(i) + "=" + condValues.get(i);
            if (i < lastIdx) {
                stmt += ", ";
            }
        }
        return stmt;
    }
}
