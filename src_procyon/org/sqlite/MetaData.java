package org.sqlite;

import java.util.*;
import java.sql.*;

class MetaData implements DatabaseMetaData
{
    private Conn conn;
    private PreparedStatement getTables;
    private PreparedStatement getTableTypes;
    private PreparedStatement getTypeInfo;
    private PreparedStatement getCatalogs;
    private PreparedStatement getSchemas;
    private PreparedStatement getUDTs;
    private PreparedStatement getColumnsTblName;
    private PreparedStatement getSuperTypes;
    private PreparedStatement getSuperTables;
    private PreparedStatement getTablePrivileges;
    private PreparedStatement getIndexInfo;
    private PreparedStatement getProcedures;
    private PreparedStatement getProcedureColumns;
    private PreparedStatement getAttributes;
    private PreparedStatement getBestRowIdentifier;
    private PreparedStatement getVersionColumns;
    private PreparedStatement getColumnPrivileges;
    private PreparedStatement getGeneratedKeys;
    
    MetaData(final Conn conn) {
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
        this.conn = conn;
    }
    
    void checkOpen() {
        if (this.conn == null) {
            throw new SQLException("connection closed");
        }
    }
    
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
        }
        finally {
            this.conn = null;
        }
    }
    
    public Connection getConnection() {
        return this.conn;
    }
    
    public int getDatabaseMajorVersion() {
        return 3;
    }
    
    public int getDatabaseMinorVersion() {
        return 0;
    }
    
    public int getDriverMajorVersion() {
        return 1;
    }
    
    public int getDriverMinorVersion() {
        return 1;
    }
    
    public int getJDBCMajorVersion() {
        return 2;
    }
    
    public int getJDBCMinorVersion() {
        return 1;
    }
    
    public int getDefaultTransactionIsolation() {
        return 8;
    }
    
    public int getMaxBinaryLiteralLength() {
        return 0;
    }
    
    public int getMaxCatalogNameLength() {
        return 0;
    }
    
    public int getMaxCharLiteralLength() {
        return 0;
    }
    
    public int getMaxColumnNameLength() {
        return 0;
    }
    
    public int getMaxColumnsInGroupBy() {
        return 0;
    }
    
    public int getMaxColumnsInIndex() {
        return 0;
    }
    
    public int getMaxColumnsInOrderBy() {
        return 0;
    }
    
    public int getMaxColumnsInSelect() {
        return 0;
    }
    
    public int getMaxColumnsInTable() {
        return 0;
    }
    
    public int getMaxConnections() {
        return 0;
    }
    
    public int getMaxCursorNameLength() {
        return 0;
    }
    
    public int getMaxIndexLength() {
        return 0;
    }
    
    public int getMaxProcedureNameLength() {
        return 0;
    }
    
    public int getMaxRowSize() {
        return 0;
    }
    
    public int getMaxSchemaNameLength() {
        return 0;
    }
    
    public int getMaxStatementLength() {
        return 0;
    }
    
    public int getMaxStatements() {
        return 0;
    }
    
    public int getMaxTableNameLength() {
        return 0;
    }
    
    public int getMaxTablesInSelect() {
        return 0;
    }
    
    public int getMaxUserNameLength() {
        return 0;
    }
    
    public int getResultSetHoldability() {
        return 2;
    }
    
    public int getSQLStateType() {
        return 2;
    }
    
    public String getDatabaseProductName() {
        return "SQLite";
    }
    
    public String getDatabaseProductVersion() {
        return this.conn.libversion();
    }
    
    public String getDriverName() {
        return "SQLiteJDBC";
    }
    
    public String getDriverVersion() {
        return this.conn.getDriverVersion();
    }
    
    public String getExtraNameCharacters() {
        return "";
    }
    
    public String getCatalogSeparator() {
        return ".";
    }
    
    public String getCatalogTerm() {
        return "catalog";
    }
    
    public String getSchemaTerm() {
        return "schema";
    }
    
    public String getProcedureTerm() {
        return "not_implemented";
    }
    
    public String getSearchStringEscape() {
        return null;
    }
    
    public String getIdentifierQuoteString() {
        return " ";
    }
    
    public String getSQLKeywords() {
        return "";
    }
    
    public String getNumericFunctions() {
        return "";
    }
    
    public String getStringFunctions() {
        return "";
    }
    
    public String getSystemFunctions() {
        return "";
    }
    
    public String getTimeDateFunctions() {
        return "";
    }
    
    public String getURL() {
        return this.conn.url();
    }
    
    public String getUserName() {
        return null;
    }
    
    public boolean allProceduresAreCallable() {
        return false;
    }
    
    public boolean allTablesAreSelectable() {
        return true;
    }
    
    public boolean dataDefinitionCausesTransactionCommit() {
        return false;
    }
    
    public boolean dataDefinitionIgnoredInTransactions() {
        return false;
    }
    
    public boolean doesMaxRowSizeIncludeBlobs() {
        return false;
    }
    
    public boolean deletesAreDetected(final int n) {
        return false;
    }
    
    public boolean insertsAreDetected(final int n) {
        return false;
    }
    
    public boolean isCatalogAtStart() {
        return true;
    }
    
    public boolean locatorsUpdateCopy() {
        return false;
    }
    
    public boolean nullPlusNonNullIsNull() {
        return true;
    }
    
    public boolean nullsAreSortedAtEnd() {
        return !this.nullsAreSortedAtStart();
    }
    
    public boolean nullsAreSortedAtStart() {
        return true;
    }
    
    public boolean nullsAreSortedHigh() {
        return true;
    }
    
    public boolean nullsAreSortedLow() {
        return !this.nullsAreSortedHigh();
    }
    
    public boolean othersDeletesAreVisible(final int n) {
        return false;
    }
    
    public boolean othersInsertsAreVisible(final int n) {
        return false;
    }
    
    public boolean othersUpdatesAreVisible(final int n) {
        return false;
    }
    
    public boolean ownDeletesAreVisible(final int n) {
        return false;
    }
    
    public boolean ownInsertsAreVisible(final int n) {
        return false;
    }
    
    public boolean ownUpdatesAreVisible(final int n) {
        return false;
    }
    
    public boolean storesLowerCaseIdentifiers() {
        return false;
    }
    
    public boolean storesLowerCaseQuotedIdentifiers() {
        return false;
    }
    
    public boolean storesMixedCaseIdentifiers() {
        return true;
    }
    
    public boolean storesMixedCaseQuotedIdentifiers() {
        return false;
    }
    
    public boolean storesUpperCaseIdentifiers() {
        return false;
    }
    
    public boolean storesUpperCaseQuotedIdentifiers() {
        return false;
    }
    
    public boolean supportsAlterTableWithAddColumn() {
        return false;
    }
    
    public boolean supportsAlterTableWithDropColumn() {
        return false;
    }
    
    public boolean supportsANSI92EntryLevelSQL() {
        return false;
    }
    
    public boolean supportsANSI92FullSQL() {
        return false;
    }
    
    public boolean supportsANSI92IntermediateSQL() {
        return false;
    }
    
    public boolean supportsBatchUpdates() {
        return true;
    }
    
    public boolean supportsCatalogsInDataManipulation() {
        return false;
    }
    
    public boolean supportsCatalogsInIndexDefinitions() {
        return false;
    }
    
    public boolean supportsCatalogsInPrivilegeDefinitions() {
        return false;
    }
    
    public boolean supportsCatalogsInProcedureCalls() {
        return false;
    }
    
    public boolean supportsCatalogsInTableDefinitions() {
        return false;
    }
    
    public boolean supportsColumnAliasing() {
        return true;
    }
    
    public boolean supportsConvert() {
        return false;
    }
    
    public boolean supportsConvert(final int n, final int n2) {
        return false;
    }
    
    public boolean supportsCorrelatedSubqueries() {
        return false;
    }
    
    public boolean supportsDataDefinitionAndDataManipulationTransactions() {
        return true;
    }
    
    public boolean supportsDataManipulationTransactionsOnly() {
        return false;
    }
    
    public boolean supportsDifferentTableCorrelationNames() {
        return false;
    }
    
    public boolean supportsExpressionsInOrderBy() {
        return true;
    }
    
    public boolean supportsMinimumSQLGrammar() {
        return true;
    }
    
    public boolean supportsCoreSQLGrammar() {
        return true;
    }
    
    public boolean supportsExtendedSQLGrammar() {
        return false;
    }
    
    public boolean supportsLimitedOuterJoins() {
        return true;
    }
    
    public boolean supportsFullOuterJoins() {
        return false;
    }
    
    public boolean supportsGetGeneratedKeys() {
        return false;
    }
    
    public boolean supportsGroupBy() {
        return true;
    }
    
    public boolean supportsGroupByBeyondSelect() {
        return false;
    }
    
    public boolean supportsGroupByUnrelated() {
        return false;
    }
    
    public boolean supportsIntegrityEnhancementFacility() {
        return false;
    }
    
    public boolean supportsLikeEscapeClause() {
        return false;
    }
    
    public boolean supportsMixedCaseIdentifiers() {
        return true;
    }
    
    public boolean supportsMixedCaseQuotedIdentifiers() {
        return false;
    }
    
    public boolean supportsMultipleOpenResults() {
        return false;
    }
    
    public boolean supportsMultipleResultSets() {
        return false;
    }
    
    public boolean supportsMultipleTransactions() {
        return true;
    }
    
    public boolean supportsNamedParameters() {
        return true;
    }
    
    public boolean supportsNonNullableColumns() {
        return true;
    }
    
    public boolean supportsOpenCursorsAcrossCommit() {
        return false;
    }
    
    public boolean supportsOpenCursorsAcrossRollback() {
        return false;
    }
    
    public boolean supportsOpenStatementsAcrossCommit() {
        return false;
    }
    
    public boolean supportsOpenStatementsAcrossRollback() {
        return false;
    }
    
    public boolean supportsOrderByUnrelated() {
        return false;
    }
    
    public boolean supportsOuterJoins() {
        return true;
    }
    
    public boolean supportsPositionedDelete() {
        return false;
    }
    
    public boolean supportsPositionedUpdate() {
        return false;
    }
    
    public boolean supportsResultSetConcurrency(final int n, final int n2) {
        return n == 1003 && n2 == 1007;
    }
    
    public boolean supportsResultSetHoldability(final int n) {
        return n == 2;
    }
    
    public boolean supportsResultSetType(final int n) {
        return n == 1003;
    }
    
    public boolean supportsSavepoints() {
        return false;
    }
    
    public boolean supportsSchemasInDataManipulation() {
        return false;
    }
    
    public boolean supportsSchemasInIndexDefinitions() {
        return false;
    }
    
    public boolean supportsSchemasInPrivilegeDefinitions() {
        return false;
    }
    
    public boolean supportsSchemasInProcedureCalls() {
        return false;
    }
    
    public boolean supportsSchemasInTableDefinitions() {
        return false;
    }
    
    public boolean supportsSelectForUpdate() {
        return false;
    }
    
    public boolean supportsStatementPooling() {
        return false;
    }
    
    public boolean supportsStoredProcedures() {
        return false;
    }
    
    public boolean supportsSubqueriesInComparisons() {
        return false;
    }
    
    public boolean supportsSubqueriesInExists() {
        return true;
    }
    
    public boolean supportsSubqueriesInIns() {
        return true;
    }
    
    public boolean supportsSubqueriesInQuantifieds() {
        return false;
    }
    
    public boolean supportsTableCorrelationNames() {
        return false;
    }
    
    public boolean supportsTransactionIsolationLevel(final int n) {
        return n == 8;
    }
    
    public boolean supportsTransactions() {
        return true;
    }
    
    public boolean supportsUnion() {
        return true;
    }
    
    public boolean supportsUnionAll() {
        return true;
    }
    
    public boolean updatesAreDetected(final int n) {
        return false;
    }
    
    public boolean usesLocalFilePerTable() {
        return false;
    }
    
    public boolean usesLocalFiles() {
        return true;
    }
    
    public boolean isReadOnly() {
        return this.conn.isReadOnly();
    }
    
    public ResultSet getAttributes(final String s, final String s2, final String s3, final String s4) {
        if (this.getAttributes == null) {
            this.getAttributes = this.conn.prepareStatement("select null as TYPE_CAT, null as TYPE_SCHEM, null as TYPE_NAME, null as ATTR_NAME, null as DATA_TYPE, null as ATTR_TYPE_NAME, null as ATTR_SIZE, null as DECIMAL_DIGITS, null as NUM_PREC_RADIX, null as NULLABLE, null as REMARKS, null as ATTR_DEF, null as SQL_DATA_TYPE, null as SQL_DATETIME_SUB, null as CHAR_OCTET_LENGTH, null as ORDINAL_POSITION, null as IS_NULLABLE, null as SCOPE_CATALOG, null as SCOPE_SCHEMA, null as SCOPE_TABLE, null as SOURCE_DATA_TYPE limit 0;");
        }
        return this.getAttributes.executeQuery();
    }
    
    public ResultSet getBestRowIdentifier(final String s, final String s2, final String s3, final int n, final boolean b) {
        if (this.getBestRowIdentifier == null) {
            this.getBestRowIdentifier = this.conn.prepareStatement("select null as SCOPE, null as COLUMN_NAME, null as DATA_TYPE, null as TYPE_NAME, null as COLUMN_SIZE, null as BUFFER_LENGTH, null as DECIMAL_DIGITS, null as PSEUDO_COLUMN limit 0;");
        }
        return this.getBestRowIdentifier.executeQuery();
    }
    
    public ResultSet getColumnPrivileges(final String s, final String s2, final String s3, final String s4) {
        if (this.getColumnPrivileges == null) {
            this.getColumnPrivileges = this.conn.prepareStatement("select null as TABLE_CAT, null as TABLE_SCHEM, null as TABLE_NAME, null as COLUMN_NAME, null as GRANTOR, null as GRANTEE, null as PRIVILEGE, null as IS_GRANTABLE limit 0;");
        }
        return this.getColumnPrivileges.executeQuery();
    }
    
    public ResultSet getColumns(final String s, final String s2, String string, final String s3) {
        final Statement statement = this.conn.createStatement();
        this.checkOpen();
        if (this.getColumnsTblName == null) {
            this.getColumnsTblName = this.conn.prepareStatement("select tbl_name from sqlite_master where tbl_name like ?;");
        }
        this.getColumnsTblName.setString(1, string);
        final ResultSet executeQuery = this.getColumnsTblName.executeQuery();
        if (!executeQuery.next()) {
            return executeQuery;
        }
        string = executeQuery.getString(1);
        executeQuery.close();
        String s4 = "select null as TABLE_CAT, null as TABLE_SCHEM, '" + this.escape(string) + "' as TABLE_NAME, " + "cn as COLUMN_NAME, " + "ct as DATA_TYPE, " + "tn as TYPE_NAME, " + "2000000000 as COLUMN_SIZE, " + "2000000000 as BUFFER_LENGTH, " + "10   as DECIMAL_DIGITS, " + "10   as NUM_PREC_RADIX, " + "colnullable as NULLABLE, " + "null as REMARKS, " + "null as COLUMN_DEF, " + "0    as SQL_DATA_TYPE, " + "0    as SQL_DATETIME_SUB, " + "2000000000 as CHAR_OCTET_LENGTH, " + "ordpos as ORDINAL_POSITION, " + "(case colnullable when 0 then 'N' when 1 then 'Y' else '' end)" + "    as IS_NULLABLE, " + "null as SCOPE_CATLOG, " + "null as SCOPE_SCHEMA, " + "null as SCOPE_TABLE, " + "null as SOURCE_DATA_TYPE from (";
        final ResultSet executeQuery2 = statement.executeQuery("pragma table_info ('" + this.escape(string) + "');");
        int n = 0;
        int n2 = 0;
        while (executeQuery2.next()) {
            final String string2 = executeQuery2.getString(2);
            final String string3 = executeQuery2.getString(3);
            final String string4 = executeQuery2.getString(4);
            int equals = 2;
            if (string4 != null) {
                equals = (string4.equals("0") ? 1 : 0);
            }
            if (n != 0) {
                s4 += " union all ";
            }
            n = 1;
            final String s5 = (string3 == null) ? "TEXT" : string3.toUpperCase();
            int n3;
            if (s5.equals("INT") || s5.equals("INTEGER")) {
                n3 = 4;
            }
            else if (s5.equals("TEXT")) {
                n3 = 12;
            }
            else if (s5.equals("FLOAT")) {
                n3 = 6;
            }
            else {
                n3 = 12;
            }
            s4 = s4 + "select " + n2 + " as ordpos, " + equals + " as colnullable, '" + n3 + "' as ct, '" + this.escape(string2) + "' as cn, '" + this.escape(s5) + "' as tn";
            if (s3 != null) {
                s4 = s4 + " where upper(cn) like upper('" + this.escape(s3) + "')";
            }
            ++n2;
        }
        final String string5 = s4 + ((n != 0) ? ");" : "select null as ordpos, null as colnullable, null as cn, null as tn) limit 0;");
        executeQuery2.close();
        return statement.executeQuery(string5);
    }
    
    public ResultSet getCrossReference(final String s, final String s2, final String s3, final String s4, final String s5, final String s6) {
        if (s3 == null) {
            return this.getExportedKeys(s4, s5, s6);
        }
        if (s6 == null) {
            return this.getImportedKeys(s, s2, s3);
        }
        final StringBuilder sb = new StringBuilder();
        sb.append(String.format("select %s as PKTABLE_CAT, %s as PKTABLE_SCHEM, %s as PKTABLE_NAME, ", quote(s), quote(s2), quote(s3)) + "'' as PKCOLUMN_NAME, " + String.format("%s as FKTABLE_CAT, %s as FKTABLE_SCHEM,  %s as FKTABLE_NAME, ", quote(s4), quote(s5), quote(s6)) + "'' as FKCOLUMN_NAME, -1 as KEY_SEQ, 3 as UPDATE_RULE, " + "3 as DELETE_RULE, '' as FK_NAME, '' as PK_NAME, " + Integer.toString(5) + " as DEFERRABILITY limit 0;");
        return this.conn.createStatement().executeQuery(sb.toString());
    }
    
    public ResultSet getSchemas() {
        if (this.getSchemas == null) {
            this.getSchemas = this.conn.prepareStatement("select null as TABLE_SCHEM, null as TABLE_CATALOG limit 0;");
        }
        this.getSchemas.clearParameters();
        return this.getSchemas.executeQuery();
    }
    
    public ResultSet getCatalogs() {
        if (this.getCatalogs == null) {
            this.getCatalogs = this.conn.prepareStatement("select null as TABLE_CAT limit 0;");
        }
        this.getCatalogs.clearParameters();
        return this.getCatalogs.executeQuery();
    }
    
    public ResultSet getPrimaryKeys(final String s, final String s2, final String s3) {
        final Statement statement = this.conn.createStatement();
        final ResultSet executeQuery = statement.executeQuery("pragma table_info('" + this.escape(s3) + "');");
        String s4 = "select null as TABLE_CAT, null as TABLE_SCHEM, '" + this.escape(s3) + "' as TABLE_NAME, " + "cn as COLUMN_NAME, " + "0 as KEY_SEQ, " + "null as PK_NAME from (";
        int n = 0;
        while (executeQuery.next()) {
            final String string = executeQuery.getString(2);
            if (!executeQuery.getBoolean(6)) {
                --n;
            }
            else {
                if (n > 0) {
                    s4 += " union all ";
                }
                s4 = s4 + "select '" + this.escape(string) + "' as cn";
            }
            ++n;
        }
        final String string2 = s4 + ((n == 0) ? "select null as cn) limit 0;" : ");");
        executeQuery.close();
        return statement.executeQuery(string2);
    }
    
    private static String quote(final String s) {
        if (s == null) {
            return "null";
        }
        return String.format("'%s'", s);
    }
    
    public ResultSet getExportedKeys(final String s, final String s2, final String s3) {
        final StringBuilder sb = new StringBuilder();
        sb.append(String.format("select %s as PKTABLE_CAT, %s as PKTABLE_SCHEM, %s as PKTABLE_NAME, ", quote(s), quote(s2), quote(s3)) + String.format("pcn as PKCOLUMN_NAME, %s as FKTABLE_CAT, %s as FKTABLE_SCHEM, ", quote(s), quote(s2)) + "fkn as FKTABLE_NAME, fcn as FKCOLUMN_NAME, " + "ks as KEY_SEQ, " + "ur as UPDATE_RULE, " + "dr as DELETE_RULE, " + "'' as FK_NAME, " + "'' as PK_NAME, " + Integer.toString(5) + " as DEFERRABILITY from (");
        final String format = String.format("select name from sqlite_master where type = 'table'", new Object[0]);
        final Statement statement = this.conn.createStatement();
        final ResultSet executeQuery = statement.executeQuery(format);
        final ArrayList<String> list = new ArrayList<String>();
        while (executeQuery.next()) {
            list.add(executeQuery.getString(1));
        }
        executeQuery.close();
        int n = 0;
        for (final String s4 : list) {
            final String format2 = String.format("pragma foreign_key_list('%s');", this.escape(s4));
            try {
                final ResultSet executeQuery2 = statement.executeQuery(format2);
                while (executeQuery2.next()) {
                    final int n2 = executeQuery2.getInt(2) + 1;
                    final String string = executeQuery2.getString(3);
                    final String string2 = executeQuery2.getString(4);
                    final String string3 = executeQuery2.getString(5);
                    final String string4 = executeQuery2.getString(6);
                    final String string5 = executeQuery2.getString(7);
                    if (string != null) {
                        if (!string.equals(s3)) {
                            continue;
                        }
                        if (n > 0) {
                            sb.append(" union all ");
                        }
                        sb.append("select " + Integer.toString(n2) + " as ks," + "'" + this.escape(s4) + "' as fkn," + "'" + this.escape(string2) + "' as fcn," + "'" + this.escape(string3) + "' as pcn," + String.format("case '%s' ", this.escape(string4)) + String.format("when 'NO ACTION' then %d ", 3) + String.format("when 'CASCADE' then %d ", 0) + String.format("when 'RESTRICT' then %d  ", 1) + String.format("when 'SET NULL' then %d  ", 2) + String.format("when 'SET DEFAULT' then %d  ", 4) + "end as ur," + String.format("case '%s' ", this.escape(string5)) + String.format("when 'NO ACTION' then %d ", 3) + String.format("when 'CASCADE' then %d ", 0) + String.format("when 'RESTRICT' then %d  ", 1) + String.format("when 'SET NULL' then %d  ", 2) + String.format("when 'SET DEFAULT' then %d  ", 4) + "end as dr");
                        ++n;
                    }
                }
                sb.append(");");
                executeQuery2.close();
            }
            catch (SQLException ex) {}
        }
        return statement.executeQuery((n > 0) ? sb.toString() : (String.format("select %s as PKTABLE_CAT, %s as PKTABLE_SCHEM, %s as PKTABLE_NAME, ", quote(s), quote(s2), quote(s3)) + "'' as PKCOLUMN_NAME, " + String.format("%s as FKTABLE_CAT, %s as FKTABLE_SCHEM, ", quote(s), quote(s2)) + "'' as FKTABLE_NAME, " + "'' as FKCOLUMN_NAME, " + "-1 as KEY_SEQ, " + "3 as UPDATE_RULE, " + "3 as DELETE_RULE, " + "'' as FK_NAME, " + "'' as PK_NAME, " + "5 as DEFERRABILITY limit 0;"));
    }
    
    public ResultSet getImportedKeys(final String s, final String s2, final String s3) {
        final Statement statement = this.conn.createStatement();
        String s4 = String.format("select %s as PKTABLE_CAT, %s as PKTABLE_SCHEM, ", quote(s), quote(s2)) + String.format("ptn as PKTABLE_NAME, pcn as PKCOLUMN_NAME, %s as FKTABLE_CAT, %s as FKTABLE_SCHEM, %s as FKTABLE_NAME, ", quote(s), quote(s2), quote(s3)) + "fcn as FKCOLUMN_NAME, " + "ks as KEY_SEQ, " + "ur as UPDATE_RULE, " + "dr as DELETE_RULE, " + "'' as FK_NAME, " + "'' as PK_NAME, " + Integer.toString(5) + " as DEFERRABILITY from (";
        try {
            final ResultSet executeQuery = statement.executeQuery("pragma foreign_key_list('" + this.escape(s3) + "');");
            int n = 0;
            while (executeQuery.next()) {
                final int n2 = executeQuery.getInt(2) + 1;
                final String string = executeQuery.getString(3);
                final String string2 = executeQuery.getString(4);
                final String string3 = executeQuery.getString(5);
                final String string4 = executeQuery.getString(6);
                final String string5 = executeQuery.getString(7);
                if (n > 0) {
                    s4 += " union all ";
                }
                s4 = s4 + String.format("select %d as ks,", n2) + String.format("'%s' as ptn, '%s' as fcn, '%s' as pcn,", this.escape(string), this.escape(string2), this.escape(string3)) + String.format("case '%s' ", this.escape(string4)) + String.format("when 'NO ACTION' then %d ", 3) + String.format("when 'CASCADE' then %d ", 0) + String.format("when 'RESTRICT' then %d  ", 1) + String.format("when 'SET NULL' then %d  ", 2) + String.format("when 'SET DEFAULT' then %d  ", 4) + "end as ur," + String.format("case '%s' ", this.escape(string5)) + String.format("when 'NO ACTION' then %d ", 3) + String.format("when 'CASCADE' then %d ", 0) + String.format("when 'RESTRICT' then %d  ", 1) + String.format("when 'SET NULL' then %d  ", 2) + String.format("when 'SET DEFAULT' then %d  ", 4) + "end as dr";
                ++n;
            }
            s4 += ");";
            executeQuery.close();
        }
        catch (SQLException ex) {
            s4 += "select -1 as ks, '' as ptn, '' as fcn, '' as pcn, 3 as ur, 3 as dr) limit 0;";
        }
        return statement.executeQuery(s4);
    }
    
    public ResultSet getIndexInfo(final String s, final String s2, final String s3, final boolean b, final boolean b2) {
        final Statement statement = this.conn.createStatement();
        String s4 = "select null as TABLE_CAT, null as TABLE_SCHEM, '" + this.escape(s3) + "' as TABLE_NAME, " + "un as NON_UNIQUE, " + "null as INDEX_QUALIFIER, " + "n as INDEX_NAME, " + Integer.toString(3) + " as TYPE, " + "op as ORDINAL_POSITION, " + "cn as COLUMN_NAME, " + "null as ASC_OR_DESC, " + "0 as CARDINALITY, " + "0 as PAGES, " + "null as FILTER_CONDITION from (";
        try {
            final ArrayList<ArrayList<Object>> list = new ArrayList<ArrayList<Object>>();
            final ResultSet executeQuery = statement.executeQuery("pragma index_list('" + this.escape(s3) + "');");
            while (executeQuery.next()) {
                list.add(new ArrayList<Object>());
                list.get(list.size() - 1).add(executeQuery.getString(2));
                list.get(list.size() - 1).add(executeQuery.getInt(3));
            }
            executeQuery.close();
            int n = 0;
            for (final ArrayList<Object> list2 : list) {
                final String string = list2.get(0).toString();
                final int intValue = list2.get(1);
                final ResultSet executeQuery2 = statement.executeQuery("pragma index_info('" + this.escape(string) + "');");
                while (executeQuery2.next()) {
                    final int n2 = executeQuery2.getInt(1) + 1;
                    final String string2 = executeQuery2.getString(3);
                    if (n > 0) {
                        s4 += " union all ";
                    }
                    s4 = s4 + "select " + Integer.toString(1 - intValue) + " as un," + "'" + this.escape(string) + "' as n," + Integer.toString(n2) + " as op," + "'" + this.escape(string2) + "' as cn";
                    ++n;
                    ++n;
                }
                executeQuery2.close();
            }
            s4 += ");";
        }
        catch (SQLException ex) {
            s4 += "select null as un, null as n, null as op, null as cn) limit 0;";
        }
        return statement.executeQuery(s4);
    }
    
    public ResultSet getProcedureColumns(final String s, final String s2, final String s3, final String s4) {
        if (this.getProcedures == null) {
            this.getProcedureColumns = this.conn.prepareStatement("select null as PROCEDURE_CAT, null as PROCEDURE_SCHEM, null as PROCEDURE_NAME, null as COLUMN_NAME, null as COLUMN_TYPE, null as DATA_TYPE, null as TYPE_NAME, null as PRECISION, null as LENGTH, null as SCALE, null as RADIX, null as NULLABLE, null as REMARKS limit 0;");
        }
        return this.getProcedureColumns.executeQuery();
    }
    
    public ResultSet getProcedures(final String s, final String s2, final String s3) {
        if (this.getProcedures == null) {
            this.getProcedures = this.conn.prepareStatement("select null as PROCEDURE_CAT, null as PROCEDURE_SCHEM, null as PROCEDURE_NAME, null as UNDEF1, null as UNDEF2, null as UNDEF3, null as REMARKS, null as PROCEDURE_TYPE limit 0;");
        }
        return this.getProcedures.executeQuery();
    }
    
    public ResultSet getSuperTables(final String s, final String s2, final String s3) {
        if (this.getSuperTables == null) {
            this.getSuperTables = this.conn.prepareStatement("select null as TABLE_CAT, null as TABLE_SCHEM, null as TABLE_NAME, null as SUPERTABLE_NAME limit 0;");
        }
        return this.getSuperTables.executeQuery();
    }
    
    public ResultSet getSuperTypes(final String s, final String s2, final String s3) {
        if (this.getSuperTypes == null) {
            this.getSuperTypes = this.conn.prepareStatement("select null as TYPE_CAT, null as TYPE_SCHEM, null as TYPE_NAME, null as SUPERTYPE_CAT, null as SUPERTYPE_SCHEM, null as SUPERTYPE_NAME limit 0;");
        }
        return this.getSuperTypes.executeQuery();
    }
    
    public ResultSet getTablePrivileges(final String s, final String s2, final String s3) {
        if (this.getTablePrivileges == null) {
            this.getTablePrivileges = this.conn.prepareStatement("select null as TABLE_CAT, null as TABLE_SCHEM, null as TABLE_NAME, null as GRANTOR, null as GRANTEE, null as PRIVILEGE, null as IS_GRANTABLE limit 0;");
        }
        return this.getTablePrivileges.executeQuery();
    }
    
    public synchronized ResultSet getTables(final String s, final String s2, String s3, final String[] array) {
        this.checkOpen();
        s3 = ((s3 == null || "".equals(s3)) ? "%" : s3.toUpperCase());
        String s4 = "select null as TABLE_CAT, null as TABLE_SCHEM, name as TABLE_NAME, upper(type) as TABLE_TYPE, null as REMARKS, null as TYPE_CAT, null as TYPE_SCHEM, null as TYPE_NAME, null as SELF_REFERENCING_COL_NAME, null as REF_GENERATION from (select name, type from sqlite_master union all       select name, type from sqlite_temp_master) where TABLE_NAME like '" + this.escape(s3) + "'";
        if (array != null) {
            String s5 = s4 + " and TABLE_TYPE in (";
            for (int i = 0; i < array.length; ++i) {
                if (i > 0) {
                    s5 += ", ";
                }
                s5 = s5 + "'" + array[i].toUpperCase() + "'";
            }
            s4 = s5 + ")";
        }
        return this.conn.createStatement().executeQuery(s4 + ";");
    }
    
    public ResultSet getTableTypes() {
        this.checkOpen();
        if (this.getTableTypes == null) {
            this.getTableTypes = this.conn.prepareStatement("select 'TABLE' as TABLE_TYPE union select 'VIEW' as TABLE_TYPE;");
        }
        this.getTableTypes.clearParameters();
        return this.getTableTypes.executeQuery();
    }
    
    public ResultSet getTypeInfo() {
        if (this.getTypeInfo == null) {
            this.getTypeInfo = this.conn.prepareStatement("select tn as TYPE_NAME, dt as DATA_TYPE, 0 as PRECISION, null as LITERAL_PREFIX, null as LITERAL_SUFFIX, null as CREATE_PARAMS, 1 as NULLABLE, 1 as CASE_SENSITIVE, 3 as SEARCHABLE, 0 as UNSIGNED_ATTRIBUTE, 0 as FIXED_PREC_SCALE, 0 as AUTO_INCREMENT, null as LOCAL_TYPE_NAME, 0 as MINIMUM_SCALE, 0 as MAXIMUM_SCALE, 0 as SQL_DATA_TYPE, 0 as SQL_DATETIME_SUB, 10 as NUM_PREC_RADIX from (    select 'BLOB' as tn, 2004 as dt union    select 'NULL' as tn, 0 as dt union    select 'REAL' as tn, 7 as dt union    select 'TEXT' as tn, 12 as dt union    select 'INTEGER' as tn, 4 as dt) order by TYPE_NAME;");
        }
        this.getTypeInfo.clearParameters();
        return this.getTypeInfo.executeQuery();
    }
    
    public ResultSet getUDTs(final String s, final String s2, final String s3, final int[] array) {
        if (this.getUDTs == null) {
            this.getUDTs = this.conn.prepareStatement("select null as TYPE_CAT, null as TYPE_SCHEM, null as TYPE_NAME, null as CLASS_NAME, null as DATA_TYPE, null as REMARKS, null as BASE_TYPE limit 0;");
        }
        this.getUDTs.clearParameters();
        return this.getUDTs.executeQuery();
    }
    
    public ResultSet getVersionColumns(final String s, final String s2, final String s3) {
        if (this.getVersionColumns == null) {
            this.getVersionColumns = this.conn.prepareStatement("select null as SCOPE, null as COLUMN_NAME, null as DATA_TYPE, null as TYPE_NAME, null as COLUMN_SIZE, null as BUFFER_LENGTH, null as DECIMAL_DIGITS, null as PSEUDO_COLUMN limit 0;");
        }
        return this.getVersionColumns.executeQuery();
    }
    
    ResultSet getGeneratedKeys() {
        if (this.getGeneratedKeys == null) {
            this.getGeneratedKeys = this.conn.prepareStatement("select last_insert_rowid();");
        }
        return this.getGeneratedKeys.executeQuery();
    }
    
    private String escape(final String s) {
        final int length = s.length();
        final StringBuffer sb = new StringBuffer(length);
        for (int i = 0; i < length; ++i) {
            if (s.charAt(i) == '\'') {
                sb.append('\'');
            }
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }
    
    public Struct createStruct(final String s, final Object[] array) {
        throw new SQLException("Not yet implemented by SQLite JDBC driver");
    }
    
    public ResultSet getFunctionColumns(final String s, final String s2, final String s3, final String s4) {
        throw new SQLException("Not yet implemented by SQLite JDBC driver");
    }
}
