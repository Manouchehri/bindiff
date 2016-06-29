/*
 * Decompiled with CFR 0_115.
 */
package org.sqlite;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Struct;
import java.util.ArrayList;
import java.util.Iterator;
import org.sqlite.Conn;

class MetaData
implements DatabaseMetaData {
    private Conn conn;
    private PreparedStatement getTables = null;
    private PreparedStatement getTableTypes = null;
    private PreparedStatement getTypeInfo = null;
    private PreparedStatement getCatalogs = null;
    private PreparedStatement getSchemas = null;
    private PreparedStatement getUDTs = null;
    private PreparedStatement getColumnsTblName = null;
    private PreparedStatement getSuperTypes = null;
    private PreparedStatement getSuperTables = null;
    private PreparedStatement getTablePrivileges = null;
    private PreparedStatement getIndexInfo = null;
    private PreparedStatement getProcedures = null;
    private PreparedStatement getProcedureColumns = null;
    private PreparedStatement getAttributes = null;
    private PreparedStatement getBestRowIdentifier = null;
    private PreparedStatement getVersionColumns = null;
    private PreparedStatement getColumnPrivileges = null;
    private PreparedStatement getGeneratedKeys = null;

    MetaData(Conn conn) {
        this.conn = conn;
    }

    void checkOpen() {
        if (this.conn != null) return;
        throw new SQLException("connection closed");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    synchronized void close() {
        if (this.conn == null) {
            return;
        }
        try {
            if (this.getTables != null) {
                this.getTables.close();
            }
            if (this.getTableTypes != null) {
                this.getTableTypes.close();
            }
            if (this.getTypeInfo != null) {
                this.getTypeInfo.close();
            }
            if (this.getCatalogs != null) {
                this.getCatalogs.close();
            }
            if (this.getSchemas != null) {
                this.getSchemas.close();
            }
            if (this.getUDTs != null) {
                this.getUDTs.close();
            }
            if (this.getColumnsTblName != null) {
                this.getColumnsTblName.close();
            }
            if (this.getSuperTypes != null) {
                this.getSuperTypes.close();
            }
            if (this.getSuperTables != null) {
                this.getSuperTables.close();
            }
            if (this.getTablePrivileges != null) {
                this.getTablePrivileges.close();
            }
            if (this.getIndexInfo != null) {
                this.getIndexInfo.close();
            }
            if (this.getProcedures != null) {
                this.getProcedures.close();
            }
            if (this.getProcedureColumns != null) {
                this.getProcedureColumns.close();
            }
            if (this.getAttributes != null) {
                this.getAttributes.close();
            }
            if (this.getBestRowIdentifier != null) {
                this.getBestRowIdentifier.close();
            }
            if (this.getVersionColumns != null) {
                this.getVersionColumns.close();
            }
            if (this.getColumnPrivileges != null) {
                this.getColumnPrivileges.close();
            }
            if (this.getGeneratedKeys != null) {
                this.getGeneratedKeys.close();
            }
            this.getTables = null;
            this.getTableTypes = null;
            this.getTypeInfo = null;
            this.getCatalogs = null;
            this.getSchemas = null;
            this.getUDTs = null;
            this.getColumnsTblName = null;
            this.getSuperTypes = null;
            this.getSuperTables = null;
            this.getTablePrivileges = null;
            this.getIndexInfo = null;
            this.getProcedures = null;
            this.getProcedureColumns = null;
            this.getAttributes = null;
            this.getBestRowIdentifier = null;
            this.getVersionColumns = null;
            this.getColumnPrivileges = null;
            this.getGeneratedKeys = null;
            return;
        }
        finally {
            this.conn = null;
        }
    }

    @Override
    public Connection getConnection() {
        return this.conn;
    }

    @Override
    public int getDatabaseMajorVersion() {
        return 3;
    }

    @Override
    public int getDatabaseMinorVersion() {
        return 0;
    }

    @Override
    public int getDriverMajorVersion() {
        return 1;
    }

    @Override
    public int getDriverMinorVersion() {
        return 1;
    }

    @Override
    public int getJDBCMajorVersion() {
        return 2;
    }

    @Override
    public int getJDBCMinorVersion() {
        return 1;
    }

    @Override
    public int getDefaultTransactionIsolation() {
        return 8;
    }

    @Override
    public int getMaxBinaryLiteralLength() {
        return 0;
    }

    @Override
    public int getMaxCatalogNameLength() {
        return 0;
    }

    @Override
    public int getMaxCharLiteralLength() {
        return 0;
    }

    @Override
    public int getMaxColumnNameLength() {
        return 0;
    }

    @Override
    public int getMaxColumnsInGroupBy() {
        return 0;
    }

    @Override
    public int getMaxColumnsInIndex() {
        return 0;
    }

    @Override
    public int getMaxColumnsInOrderBy() {
        return 0;
    }

    @Override
    public int getMaxColumnsInSelect() {
        return 0;
    }

    @Override
    public int getMaxColumnsInTable() {
        return 0;
    }

    @Override
    public int getMaxConnections() {
        return 0;
    }

    @Override
    public int getMaxCursorNameLength() {
        return 0;
    }

    @Override
    public int getMaxIndexLength() {
        return 0;
    }

    @Override
    public int getMaxProcedureNameLength() {
        return 0;
    }

    @Override
    public int getMaxRowSize() {
        return 0;
    }

    @Override
    public int getMaxSchemaNameLength() {
        return 0;
    }

    @Override
    public int getMaxStatementLength() {
        return 0;
    }

    @Override
    public int getMaxStatements() {
        return 0;
    }

    @Override
    public int getMaxTableNameLength() {
        return 0;
    }

    @Override
    public int getMaxTablesInSelect() {
        return 0;
    }

    @Override
    public int getMaxUserNameLength() {
        return 0;
    }

    @Override
    public int getResultSetHoldability() {
        return 2;
    }

    @Override
    public int getSQLStateType() {
        return 2;
    }

    @Override
    public String getDatabaseProductName() {
        return "SQLite";
    }

    @Override
    public String getDatabaseProductVersion() {
        return this.conn.libversion();
    }

    @Override
    public String getDriverName() {
        return "SQLiteJDBC";
    }

    @Override
    public String getDriverVersion() {
        return this.conn.getDriverVersion();
    }

    @Override
    public String getExtraNameCharacters() {
        return "";
    }

    @Override
    public String getCatalogSeparator() {
        return ".";
    }

    @Override
    public String getCatalogTerm() {
        return "catalog";
    }

    @Override
    public String getSchemaTerm() {
        return "schema";
    }

    @Override
    public String getProcedureTerm() {
        return "not_implemented";
    }

    @Override
    public String getSearchStringEscape() {
        return null;
    }

    @Override
    public String getIdentifierQuoteString() {
        return " ";
    }

    @Override
    public String getSQLKeywords() {
        return "";
    }

    @Override
    public String getNumericFunctions() {
        return "";
    }

    @Override
    public String getStringFunctions() {
        return "";
    }

    @Override
    public String getSystemFunctions() {
        return "";
    }

    @Override
    public String getTimeDateFunctions() {
        return "";
    }

    @Override
    public String getURL() {
        return this.conn.url();
    }

    @Override
    public String getUserName() {
        return null;
    }

    @Override
    public boolean allProceduresAreCallable() {
        return false;
    }

    @Override
    public boolean allTablesAreSelectable() {
        return true;
    }

    @Override
    public boolean dataDefinitionCausesTransactionCommit() {
        return false;
    }

    @Override
    public boolean dataDefinitionIgnoredInTransactions() {
        return false;
    }

    @Override
    public boolean doesMaxRowSizeIncludeBlobs() {
        return false;
    }

    @Override
    public boolean deletesAreDetected(int n2) {
        return false;
    }

    @Override
    public boolean insertsAreDetected(int n2) {
        return false;
    }

    @Override
    public boolean isCatalogAtStart() {
        return true;
    }

    @Override
    public boolean locatorsUpdateCopy() {
        return false;
    }

    @Override
    public boolean nullPlusNonNullIsNull() {
        return true;
    }

    @Override
    public boolean nullsAreSortedAtEnd() {
        if (this.nullsAreSortedAtStart()) return false;
        return true;
    }

    @Override
    public boolean nullsAreSortedAtStart() {
        return true;
    }

    @Override
    public boolean nullsAreSortedHigh() {
        return true;
    }

    @Override
    public boolean nullsAreSortedLow() {
        if (this.nullsAreSortedHigh()) return false;
        return true;
    }

    @Override
    public boolean othersDeletesAreVisible(int n2) {
        return false;
    }

    @Override
    public boolean othersInsertsAreVisible(int n2) {
        return false;
    }

    @Override
    public boolean othersUpdatesAreVisible(int n2) {
        return false;
    }

    @Override
    public boolean ownDeletesAreVisible(int n2) {
        return false;
    }

    @Override
    public boolean ownInsertsAreVisible(int n2) {
        return false;
    }

    @Override
    public boolean ownUpdatesAreVisible(int n2) {
        return false;
    }

    @Override
    public boolean storesLowerCaseIdentifiers() {
        return false;
    }

    @Override
    public boolean storesLowerCaseQuotedIdentifiers() {
        return false;
    }

    @Override
    public boolean storesMixedCaseIdentifiers() {
        return true;
    }

    @Override
    public boolean storesMixedCaseQuotedIdentifiers() {
        return false;
    }

    @Override
    public boolean storesUpperCaseIdentifiers() {
        return false;
    }

    @Override
    public boolean storesUpperCaseQuotedIdentifiers() {
        return false;
    }

    @Override
    public boolean supportsAlterTableWithAddColumn() {
        return false;
    }

    @Override
    public boolean supportsAlterTableWithDropColumn() {
        return false;
    }

    @Override
    public boolean supportsANSI92EntryLevelSQL() {
        return false;
    }

    @Override
    public boolean supportsANSI92FullSQL() {
        return false;
    }

    @Override
    public boolean supportsANSI92IntermediateSQL() {
        return false;
    }

    @Override
    public boolean supportsBatchUpdates() {
        return true;
    }

    @Override
    public boolean supportsCatalogsInDataManipulation() {
        return false;
    }

    @Override
    public boolean supportsCatalogsInIndexDefinitions() {
        return false;
    }

    @Override
    public boolean supportsCatalogsInPrivilegeDefinitions() {
        return false;
    }

    @Override
    public boolean supportsCatalogsInProcedureCalls() {
        return false;
    }

    @Override
    public boolean supportsCatalogsInTableDefinitions() {
        return false;
    }

    @Override
    public boolean supportsColumnAliasing() {
        return true;
    }

    @Override
    public boolean supportsConvert() {
        return false;
    }

    @Override
    public boolean supportsConvert(int n2, int n3) {
        return false;
    }

    @Override
    public boolean supportsCorrelatedSubqueries() {
        return false;
    }

    @Override
    public boolean supportsDataDefinitionAndDataManipulationTransactions() {
        return true;
    }

    @Override
    public boolean supportsDataManipulationTransactionsOnly() {
        return false;
    }

    @Override
    public boolean supportsDifferentTableCorrelationNames() {
        return false;
    }

    @Override
    public boolean supportsExpressionsInOrderBy() {
        return true;
    }

    @Override
    public boolean supportsMinimumSQLGrammar() {
        return true;
    }

    @Override
    public boolean supportsCoreSQLGrammar() {
        return true;
    }

    @Override
    public boolean supportsExtendedSQLGrammar() {
        return false;
    }

    @Override
    public boolean supportsLimitedOuterJoins() {
        return true;
    }

    @Override
    public boolean supportsFullOuterJoins() {
        return false;
    }

    @Override
    public boolean supportsGetGeneratedKeys() {
        return false;
    }

    @Override
    public boolean supportsGroupBy() {
        return true;
    }

    @Override
    public boolean supportsGroupByBeyondSelect() {
        return false;
    }

    @Override
    public boolean supportsGroupByUnrelated() {
        return false;
    }

    @Override
    public boolean supportsIntegrityEnhancementFacility() {
        return false;
    }

    @Override
    public boolean supportsLikeEscapeClause() {
        return false;
    }

    @Override
    public boolean supportsMixedCaseIdentifiers() {
        return true;
    }

    @Override
    public boolean supportsMixedCaseQuotedIdentifiers() {
        return false;
    }

    @Override
    public boolean supportsMultipleOpenResults() {
        return false;
    }

    @Override
    public boolean supportsMultipleResultSets() {
        return false;
    }

    @Override
    public boolean supportsMultipleTransactions() {
        return true;
    }

    @Override
    public boolean supportsNamedParameters() {
        return true;
    }

    @Override
    public boolean supportsNonNullableColumns() {
        return true;
    }

    @Override
    public boolean supportsOpenCursorsAcrossCommit() {
        return false;
    }

    @Override
    public boolean supportsOpenCursorsAcrossRollback() {
        return false;
    }

    @Override
    public boolean supportsOpenStatementsAcrossCommit() {
        return false;
    }

    @Override
    public boolean supportsOpenStatementsAcrossRollback() {
        return false;
    }

    @Override
    public boolean supportsOrderByUnrelated() {
        return false;
    }

    @Override
    public boolean supportsOuterJoins() {
        return true;
    }

    @Override
    public boolean supportsPositionedDelete() {
        return false;
    }

    @Override
    public boolean supportsPositionedUpdate() {
        return false;
    }

    @Override
    public boolean supportsResultSetConcurrency(int n2, int n3) {
        if (n2 != 1003) return false;
        if (n3 != 1007) return false;
        return true;
    }

    @Override
    public boolean supportsResultSetHoldability(int n2) {
        if (n2 != 2) return false;
        return true;
    }

    @Override
    public boolean supportsResultSetType(int n2) {
        if (n2 != 1003) return false;
        return true;
    }

    @Override
    public boolean supportsSavepoints() {
        return false;
    }

    @Override
    public boolean supportsSchemasInDataManipulation() {
        return false;
    }

    @Override
    public boolean supportsSchemasInIndexDefinitions() {
        return false;
    }

    @Override
    public boolean supportsSchemasInPrivilegeDefinitions() {
        return false;
    }

    @Override
    public boolean supportsSchemasInProcedureCalls() {
        return false;
    }

    @Override
    public boolean supportsSchemasInTableDefinitions() {
        return false;
    }

    @Override
    public boolean supportsSelectForUpdate() {
        return false;
    }

    @Override
    public boolean supportsStatementPooling() {
        return false;
    }

    @Override
    public boolean supportsStoredProcedures() {
        return false;
    }

    @Override
    public boolean supportsSubqueriesInComparisons() {
        return false;
    }

    @Override
    public boolean supportsSubqueriesInExists() {
        return true;
    }

    @Override
    public boolean supportsSubqueriesInIns() {
        return true;
    }

    @Override
    public boolean supportsSubqueriesInQuantifieds() {
        return false;
    }

    @Override
    public boolean supportsTableCorrelationNames() {
        return false;
    }

    @Override
    public boolean supportsTransactionIsolationLevel(int n2) {
        if (n2 != 8) return false;
        return true;
    }

    @Override
    public boolean supportsTransactions() {
        return true;
    }

    @Override
    public boolean supportsUnion() {
        return true;
    }

    @Override
    public boolean supportsUnionAll() {
        return true;
    }

    @Override
    public boolean updatesAreDetected(int n2) {
        return false;
    }

    @Override
    public boolean usesLocalFilePerTable() {
        return false;
    }

    @Override
    public boolean usesLocalFiles() {
        return true;
    }

    @Override
    public boolean isReadOnly() {
        return this.conn.isReadOnly();
    }

    @Override
    public ResultSet getAttributes(String string, String string2, String string3, String string4) {
        if (this.getAttributes != null) return this.getAttributes.executeQuery();
        this.getAttributes = this.conn.prepareStatement("select null as TYPE_CAT, null as TYPE_SCHEM, null as TYPE_NAME, null as ATTR_NAME, null as DATA_TYPE, null as ATTR_TYPE_NAME, null as ATTR_SIZE, null as DECIMAL_DIGITS, null as NUM_PREC_RADIX, null as NULLABLE, null as REMARKS, null as ATTR_DEF, null as SQL_DATA_TYPE, null as SQL_DATETIME_SUB, null as CHAR_OCTET_LENGTH, null as ORDINAL_POSITION, null as IS_NULLABLE, null as SCOPE_CATALOG, null as SCOPE_SCHEMA, null as SCOPE_TABLE, null as SOURCE_DATA_TYPE limit 0;");
        return this.getAttributes.executeQuery();
    }

    @Override
    public ResultSet getBestRowIdentifier(String string, String string2, String string3, int n2, boolean bl2) {
        if (this.getBestRowIdentifier != null) return this.getBestRowIdentifier.executeQuery();
        this.getBestRowIdentifier = this.conn.prepareStatement("select null as SCOPE, null as COLUMN_NAME, null as DATA_TYPE, null as TYPE_NAME, null as COLUMN_SIZE, null as BUFFER_LENGTH, null as DECIMAL_DIGITS, null as PSEUDO_COLUMN limit 0;");
        return this.getBestRowIdentifier.executeQuery();
    }

    @Override
    public ResultSet getColumnPrivileges(String string, String string2, String string3, String string4) {
        if (this.getColumnPrivileges != null) return this.getColumnPrivileges.executeQuery();
        this.getColumnPrivileges = this.conn.prepareStatement("select null as TABLE_CAT, null as TABLE_SCHEM, null as TABLE_NAME, null as COLUMN_NAME, null as GRANTOR, null as GRANTEE, null as PRIVILEGE, null as IS_GRANTABLE limit 0;");
        return this.getColumnPrivileges.executeQuery();
    }

    @Override
    public ResultSet getColumns(String string, String string2, String string3, String string4) {
        Statement statement = this.conn.createStatement();
        this.checkOpen();
        if (this.getColumnsTblName == null) {
            this.getColumnsTblName = this.conn.prepareStatement("select tbl_name from sqlite_master where tbl_name like ?;");
        }
        this.getColumnsTblName.setString(1, string3);
        ResultSet resultSet = this.getColumnsTblName.executeQuery();
        if (!resultSet.next()) {
            return resultSet;
        }
        string3 = resultSet.getString(1);
        resultSet.close();
        String string5 = "select null as TABLE_CAT, null as TABLE_SCHEM, '" + this.escape(string3) + "' as TABLE_NAME, " + "cn as COLUMN_NAME, " + "ct as DATA_TYPE, " + "tn as TYPE_NAME, " + "2000000000 as COLUMN_SIZE, " + "2000000000 as BUFFER_LENGTH, " + "10   as DECIMAL_DIGITS, " + "10   as NUM_PREC_RADIX, " + "colnullable as NULLABLE, " + "null as REMARKS, " + "null as COLUMN_DEF, " + "0    as SQL_DATA_TYPE, " + "0    as SQL_DATETIME_SUB, " + "2000000000 as CHAR_OCTET_LENGTH, " + "ordpos as ORDINAL_POSITION, " + "(case colnullable when 0 then 'N' when 1 then 'Y' else '' end)" + "    as IS_NULLABLE, " + "null as SCOPE_CATLOG, " + "null as SCOPE_SCHEMA, " + "null as SCOPE_TABLE, " + "null as SOURCE_DATA_TYPE from (";
        resultSet = statement.executeQuery("pragma table_info ('" + this.escape(string3) + "');");
        boolean bl2 = false;
        int n2 = 0;
        while (resultSet.next()) {
            String string6 = resultSet.getString(2);
            String string7 = resultSet.getString(3);
            String string8 = resultSet.getString(4);
            int n3 = 2;
            if (string8 != null) {
                int n4 = n3 = string8.equals("0") ? 1 : 0;
            }
            if (bl2) {
                string5 = string5 + " union all ";
            }
            bl2 = true;
            string7 = string7 == null ? "TEXT" : string7.toUpperCase();
            int n5 = -1;
            n5 = string7.equals("INT") || string7.equals("INTEGER") ? 4 : (string7.equals("TEXT") ? 12 : (string7.equals("FLOAT") ? 6 : 12));
            string5 = string5 + "select " + n2 + " as ordpos, " + n3 + " as colnullable, '" + n5 + "' as ct, '" + this.escape(string6) + "' as cn, '" + this.escape(string7) + "' as tn";
            if (string4 != null) {
                string5 = string5 + " where upper(cn) like upper('" + this.escape(string4) + "')";
            }
            ++n2;
        }
        string5 = string5 + (bl2 ? ");" : "select null as ordpos, null as colnullable, null as cn, null as tn) limit 0;");
        resultSet.close();
        return statement.executeQuery(string5);
    }

    @Override
    public ResultSet getCrossReference(String string, String string2, String string3, String string4, String string5, String string6) {
        if (string3 == null) {
            return this.getExportedKeys(string4, string5, string6);
        }
        if (string6 == null) {
            return this.getImportedKeys(string, string2, string3);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format("select %s as PKTABLE_CAT, %s as PKTABLE_SCHEM, %s as PKTABLE_NAME, ", MetaData.quote(string), MetaData.quote(string2), MetaData.quote(string3)) + "'' as PKCOLUMN_NAME, " + String.format("%s as FKTABLE_CAT, %s as FKTABLE_SCHEM,  %s as FKTABLE_NAME, ", MetaData.quote(string4), MetaData.quote(string5), MetaData.quote(string6)) + "'' as FKCOLUMN_NAME, -1 as KEY_SEQ, 3 as UPDATE_RULE, " + "3 as DELETE_RULE, '' as FK_NAME, '' as PK_NAME, " + Integer.toString(5) + " as DEFERRABILITY limit 0;");
        return this.conn.createStatement().executeQuery(stringBuilder.toString());
    }

    @Override
    public ResultSet getSchemas() {
        if (this.getSchemas == null) {
            this.getSchemas = this.conn.prepareStatement("select null as TABLE_SCHEM, null as TABLE_CATALOG limit 0;");
        }
        this.getSchemas.clearParameters();
        return this.getSchemas.executeQuery();
    }

    @Override
    public ResultSet getCatalogs() {
        if (this.getCatalogs == null) {
            this.getCatalogs = this.conn.prepareStatement("select null as TABLE_CAT limit 0;");
        }
        this.getCatalogs.clearParameters();
        return this.getCatalogs.executeQuery();
    }

    @Override
    public ResultSet getPrimaryKeys(String string, String string2, String string3) {
        Statement statement = this.conn.createStatement();
        ResultSet resultSet = statement.executeQuery("pragma table_info('" + this.escape(string3) + "');");
        String string4 = "select null as TABLE_CAT, null as TABLE_SCHEM, '" + this.escape(string3) + "' as TABLE_NAME, " + "cn as COLUMN_NAME, " + "0 as KEY_SEQ, " + "null as PK_NAME from (";
        int n2 = 0;
        while (resultSet.next()) {
            String string5 = resultSet.getString(2);
            if (!resultSet.getBoolean(6)) {
                --n2;
            } else {
                if (n2 > 0) {
                    string4 = string4 + " union all ";
                }
                string4 = string4 + "select '" + this.escape(string5) + "' as cn";
            }
            ++n2;
        }
        string4 = string4 + (n2 == 0 ? "select null as cn) limit 0;" : ");");
        resultSet.close();
        return statement.executeQuery(string4);
    }

    private static String quote(String string) {
        if (string != null) return String.format("'%s'", string);
        return "null";
    }

    @Override
    public ResultSet getExportedKeys(String string, String string2, String string3) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format("select %s as PKTABLE_CAT, %s as PKTABLE_SCHEM, %s as PKTABLE_NAME, ", MetaData.quote(string), MetaData.quote(string2), MetaData.quote(string3)) + String.format("pcn as PKCOLUMN_NAME, %s as FKTABLE_CAT, %s as FKTABLE_SCHEM, ", MetaData.quote(string), MetaData.quote(string2)) + "fkn as FKTABLE_NAME, fcn as FKCOLUMN_NAME, " + "ks as KEY_SEQ, " + "ur as UPDATE_RULE, " + "dr as DELETE_RULE, " + "'' as FK_NAME, " + "'' as PK_NAME, " + Integer.toString(5) + " as DEFERRABILITY from (");
        String string4 = String.format("select name from sqlite_master where type = 'table'", new Object[0]);
        Statement statement = this.conn.createStatement();
        ResultSet resultSet = statement.executeQuery(string4);
        ArrayList<String> arrayList = new ArrayList<String>();
        while (resultSet.next()) {
            arrayList.add(resultSet.getString(1));
        }
        resultSet.close();
        int n2 = 0;
        for (String string5 : arrayList) {
            String string6 = String.format("pragma foreign_key_list('%s');", this.escape(string5));
            try {
                ResultSet resultSet2 = statement.executeQuery(string6);
                while (resultSet2.next()) {
                    int n3 = resultSet2.getInt(2) + 1;
                    String string7 = resultSet2.getString(3);
                    String string8 = resultSet2.getString(4);
                    String string9 = resultSet2.getString(5);
                    String string10 = resultSet2.getString(6);
                    String string11 = resultSet2.getString(7);
                    if (string7 == null || !string7.equals(string3)) continue;
                    if (n2 > 0) {
                        stringBuilder.append(" union all ");
                    }
                    stringBuilder.append("select " + Integer.toString(n3) + " as ks," + "'" + this.escape(string5) + "' as fkn," + "'" + this.escape(string8) + "' as fcn," + "'" + this.escape(string9) + "' as pcn," + String.format("case '%s' ", this.escape(string10)) + String.format("when 'NO ACTION' then %d ", 3) + String.format("when 'CASCADE' then %d ", 0) + String.format("when 'RESTRICT' then %d  ", 1) + String.format("when 'SET NULL' then %d  ", 2) + String.format("when 'SET DEFAULT' then %d  ", 4) + "end as ur," + String.format("case '%s' ", this.escape(string11)) + String.format("when 'NO ACTION' then %d ", 3) + String.format("when 'CASCADE' then %d ", 0) + String.format("when 'RESTRICT' then %d  ", 1) + String.format("when 'SET NULL' then %d  ", 2) + String.format("when 'SET DEFAULT' then %d  ", 4) + "end as dr");
                    ++n2;
                }
                stringBuilder.append(");");
                resultSet2.close();
            }
            catch (SQLException var13_14) {}
        }
        String string12 = n2 > 0 ? stringBuilder.toString() : String.format("select %s as PKTABLE_CAT, %s as PKTABLE_SCHEM, %s as PKTABLE_NAME, ", MetaData.quote(string), MetaData.quote(string2), MetaData.quote(string3)) + "'' as PKCOLUMN_NAME, " + String.format("%s as FKTABLE_CAT, %s as FKTABLE_SCHEM, ", MetaData.quote(string), MetaData.quote(string2)) + "'' as FKTABLE_NAME, " + "'' as FKCOLUMN_NAME, " + "-1 as KEY_SEQ, " + "3 as UPDATE_RULE, " + "3 as DELETE_RULE, " + "'' as FK_NAME, " + "'' as PK_NAME, " + "5 as DEFERRABILITY limit 0;";
        return statement.executeQuery(string12);
    }

    @Override
    public ResultSet getImportedKeys(String string, String string2, String string3) {
        ResultSet resultSet = null;
        Statement statement = this.conn.createStatement();
        String string4 = String.format("select %s as PKTABLE_CAT, %s as PKTABLE_SCHEM, ", MetaData.quote(string), MetaData.quote(string2)) + String.format("ptn as PKTABLE_NAME, pcn as PKCOLUMN_NAME, %s as FKTABLE_CAT, %s as FKTABLE_SCHEM, %s as FKTABLE_NAME, ", MetaData.quote(string), MetaData.quote(string2), MetaData.quote(string3)) + "fcn as FKCOLUMN_NAME, " + "ks as KEY_SEQ, " + "ur as UPDATE_RULE, " + "dr as DELETE_RULE, " + "'' as FK_NAME, " + "'' as PK_NAME, " + Integer.toString(5) + " as DEFERRABILITY from (";
        try {
            resultSet = statement.executeQuery("pragma foreign_key_list('" + this.escape(string3) + "');");
            int n2 = 0;
            do {
                if (!resultSet.next()) {
                    string4 = string4 + ");";
                    resultSet.close();
                    return statement.executeQuery(string4);
                }
                int n3 = resultSet.getInt(2) + 1;
                String string5 = resultSet.getString(3);
                String string6 = resultSet.getString(4);
                String string7 = resultSet.getString(5);
                String string8 = resultSet.getString(6);
                String string9 = resultSet.getString(7);
                if (n2 > 0) {
                    string4 = string4 + " union all ";
                }
                string4 = string4 + String.format("select %d as ks,", n3) + String.format("'%s' as ptn, '%s' as fcn, '%s' as pcn,", this.escape(string5), this.escape(string6), this.escape(string7)) + String.format("case '%s' ", this.escape(string8)) + String.format("when 'NO ACTION' then %d ", 3) + String.format("when 'CASCADE' then %d ", 0) + String.format("when 'RESTRICT' then %d  ", 1) + String.format("when 'SET NULL' then %d  ", 2) + String.format("when 'SET DEFAULT' then %d  ", 4) + "end as ur," + String.format("case '%s' ", this.escape(string9)) + String.format("when 'NO ACTION' then %d ", 3) + String.format("when 'CASCADE' then %d ", 0) + String.format("when 'RESTRICT' then %d  ", 1) + String.format("when 'SET NULL' then %d  ", 2) + String.format("when 'SET DEFAULT' then %d  ", 4) + "end as dr";
                ++n2;
            } while (true);
        }
        catch (SQLException var7_8) {
            string4 = string4 + "select -1 as ks, '' as ptn, '' as fcn, '' as pcn, 3 as ur, 3 as dr) limit 0;";
        }
        return statement.executeQuery(string4);
    }

    @Override
    public ResultSet getIndexInfo(String string, String string2, String string3, boolean bl2, boolean bl3) {
        ResultSet resultSet = null;
        Statement statement = this.conn.createStatement();
        String string4 = "select null as TABLE_CAT, null as TABLE_SCHEM, '" + this.escape(string3) + "' as TABLE_NAME, " + "un as NON_UNIQUE, " + "null as INDEX_QUALIFIER, " + "n as INDEX_NAME, " + Integer.toString(3) + " as TYPE, " + "op as ORDINAL_POSITION, " + "cn as COLUMN_NAME, " + "null as ASC_OR_DESC, " + "0 as CARDINALITY, " + "0 as PAGES, " + "null as FILTER_CONDITION from (";
        try {
            ArrayList arrayList = new ArrayList();
            resultSet = statement.executeQuery("pragma index_list('" + this.escape(string3) + "');");
            while (resultSet.next()) {
                arrayList.add(new ArrayList());
                ((ArrayList)arrayList.get(arrayList.size() - 1)).add(resultSet.getString(2));
                ((ArrayList)arrayList.get(arrayList.size() - 1)).add(resultSet.getInt(3));
            }
            resultSet.close();
            int n2 = 0;
            Iterator iterator = arrayList.iterator();
            do {
                if (!iterator.hasNext()) {
                    string4 = string4 + ");";
                    return statement.executeQuery(string4);
                }
                ArrayList arrayList2 = (ArrayList)iterator.next();
                String string5 = arrayList2.get(0).toString();
                int n3 = (Integer)arrayList2.get(1);
                resultSet = statement.executeQuery("pragma index_info('" + this.escape(string5) + "');");
                while (resultSet.next()) {
                    int n4 = resultSet.getInt(1) + 1;
                    String string6 = resultSet.getString(3);
                    if (n2 > 0) {
                        string4 = string4 + " union all ";
                    }
                    string4 = string4 + "select " + Integer.toString(1 - n3) + " as un," + "'" + this.escape(string5) + "' as n," + Integer.toString(n4) + " as op," + "'" + this.escape(string6) + "' as cn";
                    ++n2;
                    ++n2;
                }
                resultSet.close();
            } while (true);
        }
        catch (SQLException var9_10) {
            string4 = string4 + "select null as un, null as n, null as op, null as cn) limit 0;";
        }
        return statement.executeQuery(string4);
    }

    @Override
    public ResultSet getProcedureColumns(String string, String string2, String string3, String string4) {
        if (this.getProcedures != null) return this.getProcedureColumns.executeQuery();
        this.getProcedureColumns = this.conn.prepareStatement("select null as PROCEDURE_CAT, null as PROCEDURE_SCHEM, null as PROCEDURE_NAME, null as COLUMN_NAME, null as COLUMN_TYPE, null as DATA_TYPE, null as TYPE_NAME, null as PRECISION, null as LENGTH, null as SCALE, null as RADIX, null as NULLABLE, null as REMARKS limit 0;");
        return this.getProcedureColumns.executeQuery();
    }

    @Override
    public ResultSet getProcedures(String string, String string2, String string3) {
        if (this.getProcedures != null) return this.getProcedures.executeQuery();
        this.getProcedures = this.conn.prepareStatement("select null as PROCEDURE_CAT, null as PROCEDURE_SCHEM, null as PROCEDURE_NAME, null as UNDEF1, null as UNDEF2, null as UNDEF3, null as REMARKS, null as PROCEDURE_TYPE limit 0;");
        return this.getProcedures.executeQuery();
    }

    @Override
    public ResultSet getSuperTables(String string, String string2, String string3) {
        if (this.getSuperTables != null) return this.getSuperTables.executeQuery();
        this.getSuperTables = this.conn.prepareStatement("select null as TABLE_CAT, null as TABLE_SCHEM, null as TABLE_NAME, null as SUPERTABLE_NAME limit 0;");
        return this.getSuperTables.executeQuery();
    }

    @Override
    public ResultSet getSuperTypes(String string, String string2, String string3) {
        if (this.getSuperTypes != null) return this.getSuperTypes.executeQuery();
        this.getSuperTypes = this.conn.prepareStatement("select null as TYPE_CAT, null as TYPE_SCHEM, null as TYPE_NAME, null as SUPERTYPE_CAT, null as SUPERTYPE_SCHEM, null as SUPERTYPE_NAME limit 0;");
        return this.getSuperTypes.executeQuery();
    }

    @Override
    public ResultSet getTablePrivileges(String string, String string2, String string3) {
        if (this.getTablePrivileges != null) return this.getTablePrivileges.executeQuery();
        this.getTablePrivileges = this.conn.prepareStatement("select null as TABLE_CAT, null as TABLE_SCHEM, null as TABLE_NAME, null as GRANTOR, null as GRANTEE, null as PRIVILEGE, null as IS_GRANTABLE limit 0;");
        return this.getTablePrivileges.executeQuery();
    }

    @Override
    public synchronized ResultSet getTables(String string, String string2, String string3, String[] arrstring) {
        this.checkOpen();
        string3 = string3 == null || "".equals(string3) ? "%" : string3.toUpperCase();
        String string4 = "select null as TABLE_CAT, null as TABLE_SCHEM, name as TABLE_NAME, upper(type) as TABLE_TYPE, null as REMARKS, null as TYPE_CAT, null as TYPE_SCHEM, null as TYPE_NAME, null as SELF_REFERENCING_COL_NAME, null as REF_GENERATION from (select name, type from sqlite_master union all       select name, type from sqlite_temp_master) where TABLE_NAME like '" + this.escape(string3) + "'";
        if (arrstring != null) {
            string4 = string4 + " and TABLE_TYPE in (";
            for (int i2 = 0; i2 < arrstring.length; ++i2) {
                if (i2 > 0) {
                    string4 = string4 + ", ";
                }
                string4 = string4 + "'" + arrstring[i2].toUpperCase() + "'";
            }
            string4 = string4 + ")";
        }
        string4 = string4 + ";";
        return this.conn.createStatement().executeQuery(string4);
    }

    @Override
    public ResultSet getTableTypes() {
        this.checkOpen();
        if (this.getTableTypes == null) {
            this.getTableTypes = this.conn.prepareStatement("select 'TABLE' as TABLE_TYPE union select 'VIEW' as TABLE_TYPE;");
        }
        this.getTableTypes.clearParameters();
        return this.getTableTypes.executeQuery();
    }

    @Override
    public ResultSet getTypeInfo() {
        if (this.getTypeInfo == null) {
            this.getTypeInfo = this.conn.prepareStatement("select tn as TYPE_NAME, dt as DATA_TYPE, 0 as PRECISION, null as LITERAL_PREFIX, null as LITERAL_SUFFIX, null as CREATE_PARAMS, 1 as NULLABLE, 1 as CASE_SENSITIVE, 3 as SEARCHABLE, 0 as UNSIGNED_ATTRIBUTE, 0 as FIXED_PREC_SCALE, 0 as AUTO_INCREMENT, null as LOCAL_TYPE_NAME, 0 as MINIMUM_SCALE, 0 as MAXIMUM_SCALE, 0 as SQL_DATA_TYPE, 0 as SQL_DATETIME_SUB, 10 as NUM_PREC_RADIX from (    select 'BLOB' as tn, 2004 as dt union    select 'NULL' as tn, 0 as dt union    select 'REAL' as tn, 7 as dt union    select 'TEXT' as tn, 12 as dt union    select 'INTEGER' as tn, 4 as dt) order by TYPE_NAME;");
        }
        this.getTypeInfo.clearParameters();
        return this.getTypeInfo.executeQuery();
    }

    @Override
    public ResultSet getUDTs(String string, String string2, String string3, int[] arrn) {
        if (this.getUDTs == null) {
            this.getUDTs = this.conn.prepareStatement("select null as TYPE_CAT, null as TYPE_SCHEM, null as TYPE_NAME, null as CLASS_NAME, null as DATA_TYPE, null as REMARKS, null as BASE_TYPE limit 0;");
        }
        this.getUDTs.clearParameters();
        return this.getUDTs.executeQuery();
    }

    @Override
    public ResultSet getVersionColumns(String string, String string2, String string3) {
        if (this.getVersionColumns != null) return this.getVersionColumns.executeQuery();
        this.getVersionColumns = this.conn.prepareStatement("select null as SCOPE, null as COLUMN_NAME, null as DATA_TYPE, null as TYPE_NAME, null as COLUMN_SIZE, null as BUFFER_LENGTH, null as DECIMAL_DIGITS, null as PSEUDO_COLUMN limit 0;");
        return this.getVersionColumns.executeQuery();
    }

    ResultSet getGeneratedKeys() {
        if (this.getGeneratedKeys != null) return this.getGeneratedKeys.executeQuery();
        this.getGeneratedKeys = this.conn.prepareStatement("select last_insert_rowid();");
        return this.getGeneratedKeys.executeQuery();
    }

    private String escape(String string) {
        int n2 = string.length();
        StringBuffer stringBuffer = new StringBuffer(n2);
        int n3 = 0;
        while (n3 < n2) {
            if (string.charAt(n3) == '\'') {
                stringBuffer.append('\'');
            }
            stringBuffer.append(string.charAt(n3));
            ++n3;
        }
        return stringBuffer.toString();
    }

    public Struct createStruct(String string, Object[] arrobject) {
        throw new SQLException("Not yet implemented by SQLite JDBC driver");
    }

    @Override
    public ResultSet getFunctionColumns(String string, String string2, String string3, String string4) {
        throw new SQLException("Not yet implemented by SQLite JDBC driver");
    }
}

