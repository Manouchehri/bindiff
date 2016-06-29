package org.sqlite;

import java.sql.*;

class Stmt extends Unused implements Statement, Codes
{
    final Conn conn;
    final DB db;
    final RS rs;
    long pointer;
    String sql;
    int batchPos;
    Object[] batch;
    boolean resultsWaiting;
    
    Stmt(final Conn conn) {
        this.sql = null;
        this.batch = null;
        this.resultsWaiting = false;
        this.conn = conn;
        this.db = this.conn.db();
        this.rs = new RS(this);
    }
    
    protected final void checkOpen() {
        if (this.pointer == 0L) {
            throw new SQLException("statement is not executing");
        }
    }
    
    boolean isOpen() {
        return this.pointer != 0L;
    }
    
    protected boolean exec() {
        if (this.sql == null) {
            throw new SQLException("SQLiteJDBC internal error: sql==null");
        }
        if (this.rs.isOpen()) {
            throw new SQLException("SQLite JDBC internal error: rs.isOpen() on exec.");
        }
        boolean execute = false;
        try {
            execute = this.db.execute(this, null);
        }
        finally {
            this.resultsWaiting = execute;
        }
        return this.db.column_count(this.pointer) != 0;
    }
    
    protected boolean exec(final String s) {
        if (s == null) {
            throw new SQLException("SQLiteJDBC internal error: sql==null");
        }
        if (this.rs.isOpen()) {
            throw new SQLException("SQLite JDBC internal error: rs.isOpen() on exec.");
        }
        boolean execute = false;
        try {
            execute = this.db.execute(s);
        }
        finally {
            this.resultsWaiting = execute;
        }
        return this.db.column_count(this.pointer) != 0;
    }
    
    public void close() {
        if (this.pointer == 0L) {
            return;
        }
        this.rs.close();
        this.batch = null;
        this.batchPos = 0;
        final int finalize = this.db.finalize(this);
        if (finalize != 0 && finalize != 21) {
            this.db.throwex();
        }
    }
    
    protected void finalize() {
        this.close();
    }
    
    public boolean execute(final String sql) {
        this.close();
        this.sql = sql;
        this.db.prepare(this);
        return this.exec();
    }
    
    public ResultSet executeQuery(final String sql) {
        this.close();
        this.sql = sql;
        this.db.prepare(this);
        if (!this.exec()) {
            this.close();
            throw new SQLException("query does not return ResultSet");
        }
        return this.getResultSet();
    }
    
    public int executeUpdate(final String sql) {
        this.close();
        this.sql = sql;
        int changes = 0;
        final ExtendedCommand$SQLExtension parse = ExtendedCommand.parse(sql);
        if (parse != null) {
            parse.execute(this.db);
        }
        else {
            try {
                final int exec = this.db._exec(sql);
                if (exec != 0) {
                    throw DB.newSQLException(exec, "");
                }
                changes = this.db.changes();
            }
            finally {
                this.close();
            }
        }
        return changes;
    }
    
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
    
    public int getUpdateCount() {
        if (this.pointer != 0L && !this.rs.isOpen() && !this.resultsWaiting && this.db.column_count(this.pointer) == 0) {
            return this.db.changes();
        }
        return -1;
    }
    
    public void addBatch(final String s) {
        this.close();
        if (this.batch == null || this.batchPos + 1 >= this.batch.length) {
            final Object[] batch = new Object[Math.max(10, this.batchPos * 2)];
            if (this.batch != null) {
                System.arraycopy(this.batch, 0, batch, 0, this.batch.length);
            }
            this.batch = batch;
        }
        this.batch[this.batchPos++] = s;
    }
    
    public void clearBatch() {
        this.batchPos = 0;
        if (this.batch != null) {
            for (int i = 0; i < this.batch.length; ++i) {
                this.batch[i] = null;
            }
        }
    }
    
    public int[] executeBatch() {
        this.close();
        if (this.batch == null || this.batchPos == 0) {
            return new int[0];
        }
        final int[] array = new int[this.batchPos];
        synchronized (this.db) {
            try {
                for (int i = 0; i < array.length; ++i) {
                    try {
                        this.sql = (String)this.batch[i];
                        this.db.prepare(this);
                        array[i] = this.db.executeUpdate(this, null);
                    }
                    catch (SQLException ex) {
                        throw new BatchUpdateException("batch entry " + i + ": " + ex.getMessage(), array);
                    }
                    finally {
                        this.db.finalize(this);
                    }
                }
            }
            finally {
                this.clearBatch();
            }
        }
        return array;
    }
    
    public void setCursorName(final String s) {
    }
    
    public SQLWarning getWarnings() {
        return null;
    }
    
    public void clearWarnings() {
    }
    
    public Connection getConnection() {
        return this.conn;
    }
    
    public void cancel() {
        this.rs.checkOpen();
        this.db.interrupt();
    }
    
    public int getQueryTimeout() {
        return this.conn.getTimeout();
    }
    
    public void setQueryTimeout(final int n) {
        if (n < 0) {
            throw new SQLException("query timeout must be >= 0");
        }
        this.conn.setTimeout(1000 * n);
    }
    
    public int getMaxRows() {
        return this.rs.maxRows;
    }
    
    public void setMaxRows(final int maxRows) {
        if (maxRows < 0) {
            throw new SQLException("max row count must be >= 0");
        }
        this.rs.maxRows = maxRows;
    }
    
    public int getMaxFieldSize() {
        return 0;
    }
    
    public void setMaxFieldSize(final int n) {
        if (n < 0) {
            throw new SQLException("max field size " + n + " cannot be negative");
        }
    }
    
    public int getFetchSize() {
        return this.rs.getFetchSize();
    }
    
    public void setFetchSize(final int fetchSize) {
        this.rs.setFetchSize(fetchSize);
    }
    
    public int getFetchDirection() {
        return this.rs.getFetchDirection();
    }
    
    public void setFetchDirection(final int fetchDirection) {
        this.rs.setFetchDirection(fetchDirection);
    }
    
    public ResultSet getGeneratedKeys() {
        return ((MetaData)this.conn.getMetaData()).getGeneratedKeys();
    }
    
    public boolean getMoreResults() {
        return this.getMoreResults(0);
    }
    
    public boolean getMoreResults(final int n) {
        this.checkOpen();
        this.close();
        return false;
    }
    
    public int getResultSetConcurrency() {
        return 1007;
    }
    
    public int getResultSetHoldability() {
        return 2;
    }
    
    public int getResultSetType() {
        return 1003;
    }
}
