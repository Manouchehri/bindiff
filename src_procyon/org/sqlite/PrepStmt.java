package org.sqlite;

import java.io.*;
import java.util.*;
import java.sql.*;

final class PrepStmt extends Stmt implements ParameterMetaData, PreparedStatement, Codes
{
    private int columnCount;
    private int paramCount;
    
    PrepStmt(final Conn conn, final String sql) {
        super(conn);
        this.sql = sql;
        this.db.prepare(this);
        this.rs.colsMeta = this.db.column_names(this.pointer);
        this.columnCount = this.db.column_count(this.pointer);
        this.paramCount = this.db.bind_parameter_count(this.pointer);
        this.batch = new Object[this.paramCount];
        this.batchPos = 0;
    }
    
    public void clearParameters() {
        this.checkOpen();
        this.db.reset(this.pointer);
        this.clearBatch();
    }
    
    protected void finalize() {
        this.close();
    }
    
    public boolean execute() {
        this.checkOpen();
        this.rs.close();
        this.db.reset(this.pointer);
        this.resultsWaiting = this.db.execute(this, this.batch);
        return this.columnCount != 0;
    }
    
    public ResultSet executeQuery() {
        this.checkOpen();
        if (this.columnCount == 0) {
            throw new SQLException("query does not return results");
        }
        this.rs.close();
        this.db.reset(this.pointer);
        this.resultsWaiting = this.db.execute(this, this.batch);
        return this.getResultSet();
    }
    
    public int executeUpdate() {
        this.checkOpen();
        if (this.columnCount != 0) {
            throw new SQLException("query returns results");
        }
        this.rs.close();
        this.db.reset(this.pointer);
        return this.db.executeUpdate(this, this.batch);
    }
    
    public int[] executeBatch() {
        if (this.batchPos == 0) {
            return new int[0];
        }
        try {
            return this.db.executeBatch(this.pointer, this.batchPos / this.paramCount, this.batch);
        }
        finally {
            this.clearBatch();
        }
    }
    
    public int getUpdateCount() {
        this.checkOpen();
        if (this.pointer == 0L || this.resultsWaiting) {
            return -1;
        }
        return this.db.changes();
    }
    
    public void addBatch() {
        this.checkOpen();
        this.batchPos += this.paramCount;
        if (this.batchPos + this.paramCount > this.batch.length) {
            final Object[] batch = new Object[this.batch.length * 2];
            System.arraycopy(this.batch, 0, batch, 0, this.batch.length);
            this.batch = batch;
        }
        System.arraycopy(this.batch, this.batchPos - this.paramCount, this.batch, this.batchPos, this.paramCount);
    }
    
    public ParameterMetaData getParameterMetaData() {
        return this;
    }
    
    public int getParameterCount() {
        this.checkOpen();
        return this.paramCount;
    }
    
    public String getParameterClassName(final int n) {
        this.checkOpen();
        return "java.lang.String";
    }
    
    public String getParameterTypeName(final int n) {
        return "VARCHAR";
    }
    
    public int getParameterType(final int n) {
        return 12;
    }
    
    public int getParameterMode(final int n) {
        return 1;
    }
    
    public int getPrecision(final int n) {
        return 0;
    }
    
    public int getScale(final int n) {
        return 0;
    }
    
    public int isNullable(final int n) {
        return 1;
    }
    
    public boolean isSigned(final int n) {
        return true;
    }
    
    public Statement getStatement() {
        return this;
    }
    
    private void batch(final int n, final Object o) {
        this.checkOpen();
        if (this.batch == null) {
            this.batch = new Object[this.paramCount];
        }
        this.batch[this.batchPos + n - 1] = o;
    }
    
    public void setBoolean(final int n, final boolean b) {
        this.setInt(n, b ? 1 : 0);
    }
    
    public void setByte(final int n, final byte b) {
        this.setInt(n, b);
    }
    
    public void setBytes(final int n, final byte[] array) {
        this.batch(n, array);
    }
    
    public void setDouble(final int n, final double n2) {
        this.batch(n, new Double(n2));
    }
    
    public void setFloat(final int n, final float n2) {
        this.batch(n, new Float(n2));
    }
    
    public void setInt(final int n, final int n2) {
        this.batch(n, new Integer(n2));
    }
    
    public void setLong(final int n, final long n2) {
        this.batch(n, new Long(n2));
    }
    
    public void setNull(final int n, final int n2) {
        this.setNull(n, n2, null);
    }
    
    public void setNull(final int n, final int n2, final String s) {
        this.batch(n, null);
    }
    
    public void setObject(final int n, final Object o) {
        if (o == null) {
            this.batch(n, null);
        }
        else if (o instanceof Date) {
            this.batch(n, new Long(((Date)o).getTime()));
        }
        else if (o instanceof java.sql.Date) {
            this.batch(n, new Long(((java.sql.Date)o).getTime()));
        }
        else if (o instanceof Time) {
            this.batch(n, new Long(((Time)o).getTime()));
        }
        else if (o instanceof Timestamp) {
            this.batch(n, new Long(((Timestamp)o).getTime()));
        }
        else if (o instanceof Long) {
            this.batch(n, o);
        }
        else if (o instanceof Integer) {
            this.batch(n, o);
        }
        else if (o instanceof Short) {
            this.batch(n, new Integer((int)o));
        }
        else if (o instanceof Float) {
            this.batch(n, o);
        }
        else if (o instanceof Double) {
            this.batch(n, o);
        }
        else if (o instanceof Boolean) {
            this.setBoolean(n, (boolean)o);
        }
        else if (o instanceof byte[]) {
            this.batch(n, o);
        }
        else {
            this.batch(n, o.toString());
        }
    }
    
    public void setObject(final int n, final Object o, final int n2) {
        this.setObject(n, o);
    }
    
    public void setObject(final int n, final Object o, final int n2, final int n3) {
        this.setObject(n, o);
    }
    
    public void setShort(final int n, final short n2) {
        this.setInt(n, n2);
    }
    
    public void setString(final int n, final String s) {
        this.batch(n, s);
    }
    
    public void setCharacterStream(final int n, final Reader reader, final int n2) {
        try {
            final StringBuffer sb = new StringBuffer();
            final char[] array = new char[8192];
            int read;
            while ((read = reader.read(array)) > 0) {
                sb.append(array, 0, read);
            }
            this.setString(n, sb.toString());
        }
        catch (IOException ex) {
            throw new SQLException("Cannot read from character stream, exception message: " + ex.getMessage());
        }
    }
    
    public void setDate(final int n, final java.sql.Date date) {
        this.setObject(n, date);
    }
    
    public void setDate(final int n, final java.sql.Date date, final Calendar calendar) {
        this.setObject(n, date);
    }
    
    public void setTime(final int n, final Time time) {
        this.setObject(n, time);
    }
    
    public void setTime(final int n, final Time time, final Calendar calendar) {
        this.setObject(n, time);
    }
    
    public void setTimestamp(final int n, final Timestamp timestamp) {
        this.setObject(n, timestamp);
    }
    
    public void setTimestamp(final int n, final Timestamp timestamp, final Calendar calendar) {
        this.setObject(n, timestamp);
    }
    
    public ResultSetMetaData getMetaData() {
        this.checkOpen();
        return this.rs;
    }
    
    public boolean execute(final String s) {
        throw this.unused();
    }
    
    public int executeUpdate(final String s) {
        throw this.unused();
    }
    
    public ResultSet executeQuery(final String s) {
        throw this.unused();
    }
    
    public void addBatch(final String s) {
        throw this.unused();
    }
    
    private SQLException unused() {
        return new SQLException("not supported by PreparedStatment");
    }
}
