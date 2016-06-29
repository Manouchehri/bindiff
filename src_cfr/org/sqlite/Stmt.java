/*
 * Decompiled with CFR 0_115.
 */
package org.sqlite;

import java.sql.BatchUpdateException;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.Statement;
import org.sqlite.Codes;
import org.sqlite.Conn;
import org.sqlite.DB;
import org.sqlite.ExtendedCommand;
import org.sqlite.ExtendedCommand$SQLExtension;
import org.sqlite.MetaData;
import org.sqlite.RS;
import org.sqlite.Unused;

class Stmt
extends Unused
implements Statement,
Codes {
    final Conn conn;
    final DB db;
    final RS rs;
    long pointer;
    String sql = null;
    int batchPos;
    Object[] batch = null;
    boolean resultsWaiting = false;

    Stmt(Conn conn) {
        this.conn = conn;
        this.db = this.conn.db();
        this.rs = new RS(this);
    }

    protected final void checkOpen() {
        if (this.pointer != 0) return;
        throw new SQLException("statement is not executing");
    }

    boolean isOpen() {
        if (this.pointer == 0) return false;
        return true;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected boolean exec() {
        if (this.sql == null) {
            throw new SQLException("SQLiteJDBC internal error: sql==null");
        }
        if (this.rs.isOpen()) {
            throw new SQLException("SQLite JDBC internal error: rs.isOpen() on exec.");
        }
        boolean bl2 = false;
        try {
            bl2 = this.db.execute(this, null);
        }
        finally {
            this.resultsWaiting = bl2;
        }
        if (this.db.column_count(this.pointer) == 0) return false;
        return true;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected boolean exec(String string) {
        if (string == null) {
            throw new SQLException("SQLiteJDBC internal error: sql==null");
        }
        if (this.rs.isOpen()) {
            throw new SQLException("SQLite JDBC internal error: rs.isOpen() on exec.");
        }
        boolean bl2 = false;
        try {
            bl2 = this.db.execute(string);
        }
        finally {
            this.resultsWaiting = bl2;
        }
        if (this.db.column_count(this.pointer) == 0) return false;
        return true;
    }

    @Override
    public void close() {
        if (this.pointer == 0) {
            return;
        }
        this.rs.close();
        this.batch = null;
        this.batchPos = 0;
        int n2 = this.db.finalize(this);
        if (n2 == 0) return;
        if (n2 == 21) return;
        this.db.throwex();
    }

    protected void finalize() {
        this.close();
    }

    @Override
    public boolean execute(String string) {
        this.close();
        this.sql = string;
        this.db.prepare(this);
        return this.exec();
    }

    @Override
    public ResultSet executeQuery(String string) {
        this.close();
        this.sql = string;
        this.db.prepare(this);
        if (this.exec()) return this.getResultSet();
        this.close();
        throw new SQLException("query does not return ResultSet");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public int executeUpdate(String string) {
        this.close();
        this.sql = string;
        int n2 = 0;
        ExtendedCommand$SQLExtension extendedCommand$SQLExtension = ExtendedCommand.parse(string);
        if (extendedCommand$SQLExtension != null) {
            extendedCommand$SQLExtension.execute(this.db);
            return n2;
        }
        try {
            int n3 = this.db._exec(string);
            if (n3 != 0) {
                throw DB.newSQLException(n3, "");
            }
            n2 = this.db.changes();
            return n2;
        }
        finally {
            this.close();
        }
    }

    @Override
    public ResultSet getResultSet() {
        this.checkOpen();
        if (this.rs.isOpen()) {
            throw new SQLException("ResultSet already requested");
        }
        if (this.db.column_count(this.pointer) == 0) {
            throw new SQLException("no ResultSet available");
        }
        if (this.rs.colsMeta == null) {
            this.rs.colsMeta = this.db.column_names(this.pointer);
        }
        this.rs.cols = this.rs.colsMeta;
        this.rs.open = this.resultsWaiting;
        this.resultsWaiting = false;
        return this.rs;
    }

    @Override
    public int getUpdateCount() {
        if (this.pointer == 0) return -1;
        if (this.rs.isOpen()) return -1;
        if (this.resultsWaiting) return -1;
        if (this.db.column_count(this.pointer) != 0) return -1;
        return this.db.changes();
    }

    @Override
    public void addBatch(String string) {
        this.close();
        if (this.batch == null || this.batchPos + 1 >= this.batch.length) {
            Object[] arrobject = new Object[java.lang.Math.max(10, this.batchPos * 2)];
            if (this.batch != null) {
                System.arraycopy(this.batch, 0, arrobject, 0, this.batch.length);
            }
            this.batch = arrobject;
        }
        this.batch[this.batchPos++] = string;
    }

    @Override
    public void clearBatch() {
        this.batchPos = 0;
        if (this.batch == null) return;
        int n2 = 0;
        while (n2 < this.batch.length) {
            this.batch[n2] = null;
            ++n2;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public int[] executeBatch() {
        this.close();
        if (this.batch == null) return new int[0];
        if (this.batchPos == 0) {
            return new int[0];
        }
        int[] arrn = new int[this.batchPos];
        DB dB2 = this.db;
        synchronized (dB2) {
            try {
                int n2 = 0;
                while (n2 < arrn.length) {
                    try {
                        this.sql = (String)this.batch[n2];
                        this.db.prepare(this);
                        arrn[n2] = this.db.executeUpdate(this, null);
                    }
                    catch (SQLException var4_4) {
                        throw new BatchUpdateException("batch entry " + n2 + ": " + var4_4.getMessage(), arrn);
                    }
                    finally {
                        this.db.finalize(this);
                    }
                    ++n2;
                }
                return arrn;
            }
            finally {
                this.clearBatch();
            }
        }
    }

    @Override
    public void setCursorName(String string) {
    }

    @Override
    public SQLWarning getWarnings() {
        return null;
    }

    @Override
    public void clearWarnings() {
    }

    @Override
    public Connection getConnection() {
        return this.conn;
    }

    @Override
    public void cancel() {
        this.rs.checkOpen();
        this.db.interrupt();
    }

    @Override
    public int getQueryTimeout() {
        return this.conn.getTimeout();
    }

    @Override
    public void setQueryTimeout(int n2) {
        if (n2 < 0) {
            throw new SQLException("query timeout must be >= 0");
        }
        this.conn.setTimeout(1000 * n2);
    }

    @Override
    public int getMaxRows() {
        return this.rs.maxRows;
    }

    @Override
    public void setMaxRows(int n2) {
        if (n2 < 0) {
            throw new SQLException("max row count must be >= 0");
        }
        this.rs.maxRows = n2;
    }

    @Override
    public int getMaxFieldSize() {
        return 0;
    }

    @Override
    public void setMaxFieldSize(int n2) {
        if (n2 >= 0) return;
        throw new SQLException("max field size " + n2 + " cannot be negative");
    }

    @Override
    public int getFetchSize() {
        return this.rs.getFetchSize();
    }

    @Override
    public void setFetchSize(int n2) {
        this.rs.setFetchSize(n2);
    }

    @Override
    public int getFetchDirection() {
        return this.rs.getFetchDirection();
    }

    @Override
    public void setFetchDirection(int n2) {
        this.rs.setFetchDirection(n2);
    }

    @Override
    public ResultSet getGeneratedKeys() {
        return ((MetaData)this.conn.getMetaData()).getGeneratedKeys();
    }

    @Override
    public boolean getMoreResults() {
        return this.getMoreResults(0);
    }

    @Override
    public boolean getMoreResults(int n2) {
        this.checkOpen();
        this.close();
        return false;
    }

    @Override
    public int getResultSetConcurrency() {
        return 1007;
    }

    @Override
    public int getResultSetHoldability() {
        return 2;
    }

    @Override
    public int getResultSetType() {
        return 1003;
    }
}

