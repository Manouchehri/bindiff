/*
 * Copyright (c) 2007 David Crawshaw <david@zentus.com>
 *
 * Permission to use, copy, modify, and/or distribute this software for any
 * purpose with or without fee is hereby granted, provided that the above
 * copyright notice and this permission notice appear in all copies.
 *
 * THE SOFTWARE IS PROVIDED "AS IS" AND THE AUTHOR DISCLAIMS ALL WARRANTIES
 * WITH REGARD TO THIS SOFTWARE INCLUDING ALL IMPLIED WARRANTIES OF
 * MERCHANTABILITY AND FITNESS. IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR
 * ANY SPECIAL, DIRECT, INDIRECT, OR CONSEQUENTIAL DAMAGES OR ANY DAMAGES
 * WHATSOEVER RESULTING FROM LOSS OF USE, DATA OR PROFITS, WHETHER IN AN
 * ACTION OF CONTRACT, NEGLIGENCE OR OTHER TORTIOUS ACTION, ARISING OUT OF
 * OR IN CONNECTION WITH THE USE OR PERFORMANCE OF THIS SOFTWARE.
 */

package org.sqlite;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Struct;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Iterator;

class MetaData implements DatabaseMetaData
{
    private Conn              conn;
    private PreparedStatement getTables        = null, getTableTypes = null, getTypeInfo = null, getCatalogs = null,
            getSchemas = null, getUDTs = null, getColumnsTblName = null, getSuperTypes = null, getSuperTables = null,
            getTablePrivileges = null, getIndexInfo = null, getProcedures = null, getProcedureColumns = null,
            getAttributes = null, getBestRowIdentifier = null, getVersionColumns = null, getColumnPrivileges = null;

    /** Used by PrepStmt to save generating a new statement every call. */
    private PreparedStatement getGeneratedKeys = null;

    MetaData(Conn conn) {
        this.conn = conn;
    }

    void checkOpen() throws SQLException {
        if (conn == null)
            throw new SQLException("connection closed");
    }

    synchronized void close() throws SQLException {
        if (conn == null)
            return;

        try {
            if (getTables != null)
                getTables.close();
            if (getTableTypes != null)
                getTableTypes.close();
            if (getTypeInfo != null)
                getTypeInfo.close();
            if (getCatalogs != null)
                getCatalogs.close();
            if (getSchemas != null)
                getSchemas.close();
            if (getUDTs != null)
                getUDTs.close();
            if (getColumnsTblName != null)
                getColumnsTblName.close();
            if (getSuperTypes != null)
                getSuperTypes.close();
            if (getSuperTables != null)
                getSuperTables.close();
            if (getTablePrivileges != null)
                getTablePrivileges.close();
            if (getIndexInfo != null)
                getIndexInfo.close();
            if (getProcedures != null)
                getProcedures.close();
            if (getProcedureColumns != null)
                getProcedureColumns.close();
            if (getAttributes != null)
                getAttributes.close();
            if (getBestRowIdentifier != null)
                getBestRowIdentifier.close();
            if (getVersionColumns != null)
                getVersionColumns.close();
            if (getColumnPrivileges != null)
                getColumnPrivileges.close();
            if (getGeneratedKeys != null)
                getGeneratedKeys.close();

            getTables = null;
            getTableTypes = null;
            getTypeInfo = null;
            getCatalogs = null;
            getSchemas = null;
            getUDTs = null;
            getColumnsTblName = null;
            getSuperTypes = null;
            getSuperTables = null;
            getTablePrivileges = null;
            getIndexInfo = null;
            getProcedures = null;
            getProcedureColumns = null;
            getAttributes = null;
            getBestRowIdentifier = null;
            getVersionColumns = null;
            getColumnPrivileges = null;
            getGeneratedKeys = null;
        }
        finally {
            conn = null;
        }
    }

    public Connection getConnection() {
        return conn;
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
        return Connection.TRANSACTION_SERIALIZABLE;
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
        return ResultSet.CLOSE_CURSORS_AT_COMMIT;
    }

    public int getSQLStateType() {
        return sqlStateSQL99;
    }

    public String getDatabaseProductName() {
        return "SQLite";
    }

    public String getDatabaseProductVersion() throws SQLException {
        return conn.libversion();
    }

    public String getDriverName() {
        return "SQLiteJDBC";
    }

    public String getDriverVersion() {
        return conn.getDriverVersion();
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
        return conn.url();
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

    public boolean deletesAreDetected(int type) {
        return false;
    }

    public boolean insertsAreDetected(int type) {
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
        return !nullsAreSortedAtStart();
    }

    public boolean nullsAreSortedAtStart() {
        return true;
    }

    public boolean nullsAreSortedHigh() {
        return true;
    }

    public boolean nullsAreSortedLow() {
        return !nullsAreSortedHigh();
    }

    public boolean othersDeletesAreVisible(int type) {
        return false;
    }

    public boolean othersInsertsAreVisible(int type) {
        return false;
    }

    public boolean othersUpdatesAreVisible(int type) {
        return false;
    }

    public boolean ownDeletesAreVisible(int type) {
        return false;
    }

    public boolean ownInsertsAreVisible(int type) {
        return false;
    }

    public boolean ownUpdatesAreVisible(int type) {
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

    public boolean supportsConvert(int fromType, int toType) {
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

    public boolean supportsResultSetConcurrency(int t, int c) {
        return t == ResultSet.TYPE_FORWARD_ONLY && c == ResultSet.CONCUR_READ_ONLY;
    }

    public boolean supportsResultSetHoldability(int h) {
        return h == ResultSet.CLOSE_CURSORS_AT_COMMIT;
    }

    public boolean supportsResultSetType(int t) {
        return t == ResultSet.TYPE_FORWARD_ONLY;
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
    } // TODO: check

    public boolean supportsSubqueriesInIns() {
        return true;
    } // TODO: check

    public boolean supportsSubqueriesInQuantifieds() {
        return false;
    }

    public boolean supportsTableCorrelationNames() {
        return false;
    }

    public boolean supportsTransactionIsolationLevel(int level) {
        return level == Connection.TRANSACTION_SERIALIZABLE;
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

    public boolean updatesAreDetected(int type) {
        return false;
    }

    public boolean usesLocalFilePerTable() {
        return false;
    }

    public boolean usesLocalFiles() {
        return true;
    }

    public boolean isReadOnly() throws SQLException {
        return conn.isReadOnly();
    }

    public ResultSet getAttributes(String c, String s, String t, String a) throws SQLException {
        if (getAttributes == null)
            getAttributes = conn.prepareStatement("select " + "null as TYPE_CAT, " + "null as TYPE_SCHEM, "
                    + "null as TYPE_NAME, " + "null as ATTR_NAME, " + "null as DATA_TYPE, "
                    + "null as ATTR_TYPE_NAME, " + "null as ATTR_SIZE, " + "null as DECIMAL_DIGITS, "
                    + "null as NUM_PREC_RADIX, " + "null as NULLABLE, " + "null as REMARKS, " + "null as ATTR_DEF, "
                    + "null as SQL_DATA_TYPE, " + "null as SQL_DATETIME_SUB, " + "null as CHAR_OCTET_LENGTH, "
                    + "null as ORDINAL_POSITION, " + "null as IS_NULLABLE, " + "null as SCOPE_CATALOG, "
                    + "null as SCOPE_SCHEMA, " + "null as SCOPE_TABLE, " + "null as SOURCE_DATA_TYPE limit 0;");
        return getAttributes.executeQuery();
    }

    public ResultSet getBestRowIdentifier(String c, String s, String t, int scope, boolean n) throws SQLException {
        if (getBestRowIdentifier == null)
            getBestRowIdentifier = conn.prepareStatement("select " + "null as SCOPE, " + "null as COLUMN_NAME, "
                    + "null as DATA_TYPE, " + "null as TYPE_NAME, " + "null as COLUMN_SIZE, "
                    + "null as BUFFER_LENGTH, " + "null as DECIMAL_DIGITS, " + "null as PSEUDO_COLUMN limit 0;");
        return getBestRowIdentifier.executeQuery();
    }

    public ResultSet getColumnPrivileges(String c, String s, String t, String colPat) throws SQLException {
        if (getColumnPrivileges == null)
            getColumnPrivileges = conn.prepareStatement("select " + "null as TABLE_CAT, " + "null as TABLE_SCHEM, "
                    + "null as TABLE_NAME, " + "null as COLUMN_NAME, " + "null as GRANTOR, " + "null as GRANTEE, "
                    + "null as PRIVILEGE, " + "null as IS_GRANTABLE limit 0;");
        return getColumnPrivileges.executeQuery();
    }

    public ResultSet getColumns(String c, String s, String tbl, String colPat) throws SQLException {
        Statement stat = conn.createStatement();
        ResultSet rs;
        String sql;

        checkOpen();

        if (getColumnsTblName == null)
            getColumnsTblName = conn.prepareStatement("select tbl_name from sqlite_master where tbl_name like ?;");

        // determine exact table name
        getColumnsTblName.setString(1, tbl);
        rs = getColumnsTblName.executeQuery();
        if (!rs.next())
            return rs;
        tbl = rs.getString(1);
        rs.close();

        sql = "select " + "null as TABLE_CAT, " + "null as TABLE_SCHEM, " + "'" + escape(tbl) + "' as TABLE_NAME, "
                + "cn as COLUMN_NAME, " + "ct as DATA_TYPE, " + "tn as TYPE_NAME, " + "2000000000 as COLUMN_SIZE, "
                + "2000000000 as BUFFER_LENGTH, " + "10   as DECIMAL_DIGITS, " + "10   as NUM_PREC_RADIX, "
                + "colnullable as NULLABLE, " + "null as REMARKS, " + "null as COLUMN_DEF, "
                + "0    as SQL_DATA_TYPE, " + "0    as SQL_DATETIME_SUB, " + "2000000000 as CHAR_OCTET_LENGTH, "
                + "ordpos as ORDINAL_POSITION, " + "(case colnullable when 0 then 'N' when 1 then 'Y' else '' end)"
                + "    as IS_NULLABLE, " + "null as SCOPE_CATLOG, " + "null as SCOPE_SCHEMA, "
                + "null as SCOPE_TABLE, " + "null as SOURCE_DATA_TYPE from (";

        // the command "pragma table_info('tablename')" does not embed
        // like a normal select statement so we must extract the information
        // and then build a resultset from unioned select statements
        rs = stat.executeQuery("pragma table_info ('" + escape(tbl) + "');");

        boolean colFound = false;
        for (int i = 0; rs.next(); i++) {
            String colName = rs.getString(2);
            String colType = rs.getString(3);
            String colNotNull = rs.getString(4);

            int colNullable = 2;
            if (colNotNull != null)
                colNullable = colNotNull.equals("0") ? 1 : 0;
            if (colFound)
                sql += " union all ";
            colFound = true;

            colType = colType == null ? "TEXT" : colType.toUpperCase();
            int colJavaType = -1;
            if (colType.equals("INT") || colType.equals("INTEGER"))
                colJavaType = Types.INTEGER;
            else if (colType.equals("TEXT"))
                colJavaType = Types.VARCHAR;
            else if (colType.equals("FLOAT"))
                colJavaType = Types.FLOAT;
            else
                colJavaType = Types.VARCHAR;

            sql += "select " + i + " as ordpos, " + colNullable + " as colnullable, '" + colJavaType + "' as ct, '"
                    + escape(colName) + "' as cn, '" + escape(colType) + "' as tn";

            if (colPat != null)
                sql += " where upper(cn) like upper('" + escape(colPat) + "')";
        }
        sql += colFound ? ");" : "select null as ordpos, null as colnullable, " + "null as cn, null as tn) limit 0;";
        rs.close();

        return stat.executeQuery(sql);
    }

    public ResultSet getCrossReference(String pc, String ps, String pt, String fc, String fs, String ft)
            throws SQLException {

        if (pt == null)
            return getExportedKeys(fc, fs, ft);
        if (ft == null)
            return getImportedKeys(pc, ps, pt);

        StringBuilder query = new StringBuilder();
        query.append(String.format("select %s as PKTABLE_CAT, %s as PKTABLE_SCHEM, %s as PKTABLE_NAME, ", quote(pc),
                quote(ps), quote(pt))
                + "'' as PKCOLUMN_NAME, "
                + String.format("%s as FKTABLE_CAT, %s as FKTABLE_SCHEM,  %s as FKTABLE_NAME, ", quote(fc), quote(fs),
                        quote(ft))
                + "'' as FKCOLUMN_NAME, -1 as KEY_SEQ, 3 as UPDATE_RULE, "
                + "3 as DELETE_RULE, '' as FK_NAME, '' as PK_NAME, "
                + Integer.toString(importedKeyInitiallyDeferred)
                + " as DEFERRABILITY limit 0;");
        return conn.createStatement().executeQuery(query.toString());
    }

    public ResultSet getSchemas() throws SQLException {
        if (getSchemas == null)
            getSchemas = conn.prepareStatement("select " + "null as TABLE_SCHEM, " + "null as TABLE_CATALOG "
                    + "limit 0;");
        getSchemas.clearParameters();
        return getSchemas.executeQuery();
    }

    public ResultSet getCatalogs() throws SQLException {
        if (getCatalogs == null)
            getCatalogs = conn.prepareStatement("select null as TABLE_CAT limit 0;");
        getCatalogs.clearParameters();
        return getCatalogs.executeQuery();
    }

    public ResultSet getPrimaryKeys(String c, String s, String table) throws SQLException {
        String sql;
        ResultSet rs;
        Statement stat = conn.createStatement();

        rs = stat.executeQuery("pragma table_info('" + escape(table) + "');");

        sql = "select " + "null as TABLE_CAT, " + "null as TABLE_SCHEM, " + "'" + escape(table) + "' as TABLE_NAME, "
                + "cn as COLUMN_NAME, " + "0 as KEY_SEQ, " + "null as PK_NAME from (";

        int i;
        for (i = 0; rs.next(); i++) {
            String colName = rs.getString(2);

            if (!rs.getBoolean(6)) {
                i--;
                continue;
            }
            if (i > 0)
                sql += " union all ";

            sql += "select '" + escape(colName) + "' as cn";
        }
        sql += i == 0 ? "select null as cn) limit 0;" : ");";
        rs.close();

        return stat.executeQuery(sql);
    }

    private static String quote(String tableName) {
        if (tableName == null)
            return "null";
        else
            return String.format("'%s'", tableName);
    }

    public ResultSet getExportedKeys(String catalog, String schema, String table) throws SQLException {

        StringBuilder exportedKeysQuery = new StringBuilder();
        exportedKeysQuery.append(String.format("select %s as PKTABLE_CAT, %s as PKTABLE_SCHEM, %s as PKTABLE_NAME, ",
                quote(catalog), quote(schema), quote(table))
                + String.format("pcn as PKCOLUMN_NAME, %s as FKTABLE_CAT, %s as FKTABLE_SCHEM, ", quote(catalog),
                        quote(schema))
                + "fkn as FKTABLE_NAME, fcn as FKCOLUMN_NAME, "
                + "ks as KEY_SEQ, "
                + "ur as UPDATE_RULE, "
                + "dr as DELETE_RULE, "
                + "'' as FK_NAME, "
                + "'' as PK_NAME, "
                + Integer.toString(importedKeyInitiallyDeferred) + " as DEFERRABILITY from (");

        // retrieve table list
        String tableListQuery = String.format("select name from sqlite_master where type = 'table'");
        Statement stat = conn.createStatement();
        ResultSet rs = stat.executeQuery(tableListQuery);
        ArrayList<String> tableList = new ArrayList<String>();
        while (rs.next())
            tableList.add(rs.getString(1));
        rs.close();

        // find imported keys for each table
        int count = 0;
        for (String targetTable : tableList) {
            String foreignKeyQuery = String.format("pragma foreign_key_list('%s');", escape(targetTable));

            try {
                ResultSet fk = stat.executeQuery(foreignKeyQuery);
                for (; fk.next();) {
                    int keySeq = fk.getInt(2) + 1;
                    String PKTabName = fk.getString(3);
                    String FKColName = fk.getString(4);
                    String PKColName = fk.getString(5);
                    String updateRule = fk.getString(6);
                    String deleteRule = fk.getString(7);

                    if (PKTabName == null || !PKTabName.equals(table))
                        continue;

                    if (count > 0)
                        exportedKeysQuery.append(" union all ");

                    exportedKeysQuery.append("select " + Integer.toString(keySeq) + " as ks," + "'"
                            + escape(targetTable) + "' as fkn," + "'" + escape(FKColName) + "' as fcn," + "'"
                            + escape(PKColName) + "' as pcn," + String.format("case '%s' ", escape(updateRule))
                            + String.format("when 'NO ACTION' then %d ", importedKeyNoAction)
                            + String.format("when 'CASCADE' then %d ", importedKeyCascade)
                            + String.format("when 'RESTRICT' then %d  ", importedKeyRestrict)
                            + String.format("when 'SET NULL' then %d  ", importedKeySetNull)
                            + String.format("when 'SET DEFAULT' then %d  ", importedKeySetDefault) + "end as ur,"
                            + String.format("case '%s' ", escape(deleteRule))
                            + String.format("when 'NO ACTION' then %d ", importedKeyNoAction)
                            + String.format("when 'CASCADE' then %d ", importedKeyCascade)
                            + String.format("when 'RESTRICT' then %d  ", importedKeyRestrict)
                            + String.format("when 'SET NULL' then %d  ", importedKeySetNull)
                            + String.format("when 'SET DEFAULT' then %d  ", importedKeySetDefault) + "end as dr");

                    count++;
                }

                exportedKeysQuery.append(");");
                fk.close();
            }
            catch (SQLException e) {
                // continue
            }
        }

        String sql = (count > 0) ? exportedKeysQuery.toString() : (String.format(
                "select %s as PKTABLE_CAT, %s as PKTABLE_SCHEM, %s as PKTABLE_NAME, ", quote(catalog), quote(schema),
                quote(table))
                + "'' as PKCOLUMN_NAME, "
                + String.format("%s as FKTABLE_CAT, %s as FKTABLE_SCHEM, ", quote(catalog), quote(schema))
                + "'' as FKTABLE_NAME, "
                + "'' as FKCOLUMN_NAME, "
                + "-1 as KEY_SEQ, "
                + "3 as UPDATE_RULE, "
                + "3 as DELETE_RULE, " + "'' as FK_NAME, " + "'' as PK_NAME, " + "5 as DEFERRABILITY limit 0;");
        return stat.executeQuery(sql);
    }

    public ResultSet getImportedKeys(String catalog, String schema, String table) throws SQLException {
        String sql;
        ResultSet rs = null;
        Statement stat = conn.createStatement();

        sql = String.format("select %s as PKTABLE_CAT, %s as PKTABLE_SCHEM, ", quote(catalog), quote(schema))
                + String
                        .format(
                                "ptn as PKTABLE_NAME, pcn as PKCOLUMN_NAME, %s as FKTABLE_CAT, %s as FKTABLE_SCHEM, %s as FKTABLE_NAME, ",
                                quote(catalog), quote(schema), quote(table)) + "fcn as FKCOLUMN_NAME, "
                + "ks as KEY_SEQ, " + "ur as UPDATE_RULE, " + "dr as DELETE_RULE, " + "'' as FK_NAME, "
                + "'' as PK_NAME, " + Integer.toString(importedKeyInitiallyDeferred) + " as DEFERRABILITY from (";

        // Use a try catch block to avoid "query does not return ResultSet" error
        try {
            rs = stat.executeQuery("pragma foreign_key_list('" + escape(table) + "');");
            int i;
            for (i = 0; rs.next(); i++) {
                int keySeq = rs.getInt(2) + 1;
                String PKTabName = rs.getString(3);
                String FKColName = rs.getString(4);
                String PKColName = rs.getString(5);
                String updateRule = rs.getString(6);
                String deleteRule = rs.getString(7);

                if (i > 0)
                    sql += " union all ";

                sql += String.format("select %d as ks,", keySeq)
                        + String.format("'%s' as ptn, '%s' as fcn, '%s' as pcn,", escape(PKTabName), escape(FKColName),
                                escape(PKColName)) + String.format("case '%s' ", escape(updateRule))
                        + String.format("when 'NO ACTION' then %d ", importedKeyNoAction)
                        + String.format("when 'CASCADE' then %d ", importedKeyCascade)
                        + String.format("when 'RESTRICT' then %d  ", importedKeyRestrict)
                        + String.format("when 'SET NULL' then %d  ", importedKeySetNull)
                        + String.format("when 'SET DEFAULT' then %d  ", importedKeySetDefault) + "end as ur,"
                        + String.format("case '%s' ", escape(deleteRule))
                        + String.format("when 'NO ACTION' then %d ", importedKeyNoAction)
                        + String.format("when 'CASCADE' then %d ", importedKeyCascade)
                        + String.format("when 'RESTRICT' then %d  ", importedKeyRestrict)
                        + String.format("when 'SET NULL' then %d  ", importedKeySetNull)
                        + String.format("when 'SET DEFAULT' then %d  ", importedKeySetDefault) + "end as dr";
            }
            sql += ");";
            rs.close();
        }
        catch (SQLException e) {
            sql += "select -1 as ks, '' as ptn, '' as fcn, '' as pcn, " + importedKeyNoAction + " as ur, "
                    + importedKeyNoAction + " as dr) limit 0;";
        }

        return stat.executeQuery(sql);
    }

    public ResultSet getIndexInfo(String c, String s, String t, boolean u, boolean approximate) throws SQLException {
        String sql;
        ResultSet rs = null;
        Statement stat = conn.createStatement();

        sql = "select " + "null as TABLE_CAT, " + "null as TABLE_SCHEM, " + "'" + escape(t) + "' as TABLE_NAME, "
                + "un as NON_UNIQUE, " + "null as INDEX_QUALIFIER, " + "n as INDEX_NAME, "
                + Integer.toString(tableIndexOther) + " as TYPE, " + "op as ORDINAL_POSITION, " + "cn as COLUMN_NAME, "
                + "null as ASC_OR_DESC, " + "0 as CARDINALITY, " + "0 as PAGES, " + "null as FILTER_CONDITION from (";

        // Use a try catch block to avoid "query does not return ResultSet" error
        try {
            ArrayList<ArrayList> indexList = new ArrayList<ArrayList>();

            rs = stat.executeQuery("pragma index_list('" + escape(t) + "');");
            while (rs.next()) {
                indexList.add(new ArrayList());
                indexList.get(indexList.size() - 1).add(rs.getString(2));
                indexList.get(indexList.size() - 1).add(rs.getInt(3));
            }
            rs.close();

            int i = 0;
            Iterator indexIterator = indexList.iterator();
            ArrayList currentIndex;
            while (indexIterator.hasNext()) {
                currentIndex = (ArrayList) indexIterator.next();
                String indexName = currentIndex.get(0).toString();
                int unique = (Integer) currentIndex.get(1);

                rs = stat.executeQuery("pragma index_info('" + escape(indexName) + "');");
                for (; rs.next(); i++) {

                    int ordinalPosition = rs.getInt(1) + 1;
                    String colName = rs.getString(3);

                    if (i > 0)
                        sql += " union all ";

                    sql += "select " + Integer.toString(1 - unique) + " as un," + "'" + escape(indexName) + "' as n,"
                            + Integer.toString(ordinalPosition) + " as op," + "'" + escape(colName) + "' as cn";
                    i++;
                }
                rs.close();
            }
            sql += ");";
        }
        catch (SQLException e) {
            sql += "select null as un, null as n, null as op, null as cn) limit 0;";
        }

        return stat.executeQuery(sql);
    }

    public ResultSet getProcedureColumns(String c, String s, String p, String colPat) throws SQLException {
        if (getProcedures == null)
            getProcedureColumns = conn.prepareStatement("select " + "null as PROCEDURE_CAT, "
                    + "null as PROCEDURE_SCHEM, " + "null as PROCEDURE_NAME, " + "null as COLUMN_NAME, "
                    + "null as COLUMN_TYPE, " + "null as DATA_TYPE, " + "null as TYPE_NAME, " + "null as PRECISION, "
                    + "null as LENGTH, " + "null as SCALE, " + "null as RADIX, " + "null as NULLABLE, "
                    + "null as REMARKS limit 0;");
        return getProcedureColumns.executeQuery();

    }

    public ResultSet getProcedures(String c, String s, String p) throws SQLException {
        if (getProcedures == null)
            getProcedures = conn.prepareStatement("select " + "null as PROCEDURE_CAT, " + "null as PROCEDURE_SCHEM, "
                    + "null as PROCEDURE_NAME, " + "null as UNDEF1, " + "null as UNDEF2, " + "null as UNDEF3, "
                    + "null as REMARKS, " + "null as PROCEDURE_TYPE limit 0;");
        return getProcedures.executeQuery();
    }

    public ResultSet getSuperTables(String c, String s, String t) throws SQLException {
        if (getSuperTables == null)
            getSuperTables = conn.prepareStatement("select " + "null as TABLE_CAT, " + "null as TABLE_SCHEM, "
                    + "null as TABLE_NAME, " + "null as SUPERTABLE_NAME limit 0;");
        return getSuperTables.executeQuery();
    }

    public ResultSet getSuperTypes(String c, String s, String t) throws SQLException {
        if (getSuperTypes == null)
            getSuperTypes = conn.prepareStatement("select " + "null as TYPE_CAT, " + "null as TYPE_SCHEM, "
                    + "null as TYPE_NAME, " + "null as SUPERTYPE_CAT, " + "null as SUPERTYPE_SCHEM, "
                    + "null as SUPERTYPE_NAME limit 0;");
        return getSuperTypes.executeQuery();
    }

    public ResultSet getTablePrivileges(String c, String s, String t) throws SQLException {
        if (getTablePrivileges == null)
            getTablePrivileges = conn.prepareStatement("select " + "null as TABLE_CAT, " + "null as TABLE_SCHEM, "
                    + "null as TABLE_NAME, " + "null as GRANTOR, " + "null as GRANTEE, " + "null as PRIVILEGE, "
                    + "null as IS_GRANTABLE limit 0;");
        return getTablePrivileges.executeQuery();
    }

    public synchronized ResultSet getTables(String c, String s, String t, String[] types) throws SQLException {
        checkOpen();

        t = (t == null || "".equals(t)) ? "%" : t.toUpperCase();

        String sql = "select" + " null as TABLE_CAT," + " null as TABLE_SCHEM," + " name as TABLE_NAME,"
                + " upper(type) as TABLE_TYPE," + " null as REMARKS," + " null as TYPE_CAT," + " null as TYPE_SCHEM,"
                + " null as TYPE_NAME," + " null as SELF_REFERENCING_COL_NAME," + " null as REF_GENERATION"
                + " from (select name, type from sqlite_master union all"
                + "       select name, type from sqlite_temp_master)" + " where TABLE_NAME like '" + escape(t) + "'";

        if (types != null) {
            sql += " and TABLE_TYPE in (";
            for (int i = 0; i < types.length; i++) {
                if (i > 0)
                    sql += ", ";
                sql += "'" + types[i].toUpperCase() + "'";
            }
            sql += ")";
        }

        sql += ";";

        return conn.createStatement().executeQuery(sql);
    }

    public ResultSet getTableTypes() throws SQLException {
        checkOpen();
        if (getTableTypes == null)
            getTableTypes = conn.prepareStatement("select 'TABLE' as TABLE_TYPE"
                    + " union select 'VIEW' as TABLE_TYPE;");
        getTableTypes.clearParameters();
        return getTableTypes.executeQuery();
    }

    public ResultSet getTypeInfo() throws SQLException {
        if (getTypeInfo == null) {
            getTypeInfo = conn.prepareStatement("select " + "tn as TYPE_NAME, " + "dt as DATA_TYPE, "
                    + "0 as PRECISION, " + "null as LITERAL_PREFIX, " + "null as LITERAL_SUFFIX, "
                    + "null as CREATE_PARAMS, "
                    + typeNullable
                    + " as NULLABLE, "
                    + "1 as CASE_SENSITIVE, "
                    + typeSearchable
                    + " as SEARCHABLE, "
                    + "0 as UNSIGNED_ATTRIBUTE, "
                    + "0 as FIXED_PREC_SCALE, "
                    + "0 as AUTO_INCREMENT, "
                    + "null as LOCAL_TYPE_NAME, "
                    + "0 as MINIMUM_SCALE, "
                    + "0 as MAXIMUM_SCALE, "
                    + "0 as SQL_DATA_TYPE, "
                    + "0 as SQL_DATETIME_SUB, "
                    + "10 as NUM_PREC_RADIX from ("
                    + "    select 'BLOB' as tn, "
                    + Types.BLOB
                    + " as dt union"
                    + "    select 'NULL' as tn, "
                    + Types.NULL
                    + " as dt union"
                    + "    select 'REAL' as tn, "
                    + Types.REAL
                    + " as dt union"
                    + "    select 'TEXT' as tn, "
                    + Types.VARCHAR
                    + " as dt union"
                    + "    select 'INTEGER' as tn, "
                    + Types.INTEGER + " as dt" + ") order by TYPE_NAME;");
        }

        getTypeInfo.clearParameters();
        return getTypeInfo.executeQuery();
    }

    public ResultSet getUDTs(String c, String s, String t, int[] types) throws SQLException {
        if (getUDTs == null)
            getUDTs = conn.prepareStatement("select " + "null as TYPE_CAT, " + "null as TYPE_SCHEM, "
                    + "null as TYPE_NAME, " + "null as CLASS_NAME, " + "null as DATA_TYPE, " + "null as REMARKS, "
                    + "null as BASE_TYPE " + "limit 0;");

        getUDTs.clearParameters();
        return getUDTs.executeQuery();
    }

    public ResultSet getVersionColumns(String c, String s, String t) throws SQLException {
        if (getVersionColumns == null)
            getVersionColumns = conn.prepareStatement("select " + "null as SCOPE, " + "null as COLUMN_NAME, "
                    + "null as DATA_TYPE, " + "null as TYPE_NAME, " + "null as COLUMN_SIZE, "
                    + "null as BUFFER_LENGTH, " + "null as DECIMAL_DIGITS, " + "null as PSEUDO_COLUMN limit 0;");
        return getVersionColumns.executeQuery();
    }

    ResultSet getGeneratedKeys() throws SQLException {
        if (getGeneratedKeys == null)
            getGeneratedKeys = conn.prepareStatement("select last_insert_rowid();");
        return getGeneratedKeys.executeQuery();
    }

    /** Replace all instances of ' with '' */
    private String escape(final String val) {
        // TODO: this function is ugly, pass this work off to SQLite, then we
        //       don't have to worry about Unicode 4, other characters needing
        //       escaping, etc.
        int len = val.length();
        StringBuffer buf = new StringBuffer(len);
        for (int i = 0; i < len; i++) {
            if (val.charAt(i) == '\'')
                buf.append('\'');
            buf.append(val.charAt(i));
        }
        return buf.toString();
    }

    public Struct createStruct(String t, Object[] attr) throws SQLException {
        throw new SQLException("Not yet implemented by SQLite JDBC driver");
    }

    public ResultSet getFunctionColumns(String a, String b, String c, String d) throws SQLException {
        throw new SQLException("Not yet implemented by SQLite JDBC driver");
    }
}
