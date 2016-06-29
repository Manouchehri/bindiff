/*
 * Decompiled with CFR 0_115.
 */
package org.sqlite;

import java.io.IOException;
import java.io.Reader;
import java.sql.Date;
import java.sql.ParameterMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Calendar;
import org.sqlite.Codes;
import org.sqlite.Conn;
import org.sqlite.DB;
import org.sqlite.RS;
import org.sqlite.Stmt;

final class PrepStmt
extends Stmt
implements ParameterMetaData,
PreparedStatement,
Codes {
    private int columnCount;
    private int paramCount;

    PrepStmt(Conn conn, String string) {
        super(conn);
        this.sql = string;
        this.db.prepare(this);
        this.rs.colsMeta = this.db.column_names(this.pointer);
        this.columnCount = this.db.column_count(this.pointer);
        this.paramCount = this.db.bind_parameter_count(this.pointer);
        this.batch = new Object[this.paramCount];
        this.batchPos = 0;
    }

    @Override
    public void clearParameters() {
        this.checkOpen();
        this.db.reset(this.pointer);
        this.clearBatch();
    }

    @Override
    protected void finalize() {
        this.close();
    }

    @Override
    public boolean execute() {
        this.checkOpen();
        this.rs.close();
        this.db.reset(this.pointer);
        this.resultsWaiting = this.db.execute(this, this.batch);
        if (this.columnCount == 0) return false;
        return true;
    }

    @Override
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

    @Override
    public int executeUpdate() {
        this.checkOpen();
        if (this.columnCount != 0) {
            throw new SQLException("query returns results");
        }
        this.rs.close();
        this.db.reset(this.pointer);
        return this.db.executeUpdate(this, this.batch);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public int[] executeBatch() {
        if (this.batchPos == 0) {
            return new int[0];
        }
        try {
            int[] arrn = this.db.executeBatch(this.pointer, this.batchPos / this.paramCount, this.batch);
            return arrn;
        }
        finally {
            this.clearBatch();
        }
    }

    @Override
    public int getUpdateCount() {
        this.checkOpen();
        if (this.pointer == 0) return -1;
        if (!this.resultsWaiting) return this.db.changes();
        return -1;
    }

    @Override
    public void addBatch() {
        this.checkOpen();
        this.batchPos += this.paramCount;
        if (this.batchPos + this.paramCount > this.batch.length) {
            Object[] arrobject = new Object[this.batch.length * 2];
            System.arraycopy(this.batch, 0, arrobject, 0, this.batch.length);
            this.batch = arrobject;
        }
        System.arraycopy(this.batch, this.batchPos - this.paramCount, this.batch, this.batchPos, this.paramCount);
    }

    @Override
    public ParameterMetaData getParameterMetaData() {
        return this;
    }

    @Override
    public int getParameterCount() {
        this.checkOpen();
        return this.paramCount;
    }

    @Override
    public String getParameterClassName(int n2) {
        this.checkOpen();
        return "java.lang.String";
    }

    @Override
    public String getParameterTypeName(int n2) {
        return "VARCHAR";
    }

    @Override
    public int getParameterType(int n2) {
        return 12;
    }

    @Override
    public int getParameterMode(int n2) {
        return 1;
    }

    @Override
    public int getPrecision(int n2) {
        return 0;
    }

    @Override
    public int getScale(int n2) {
        return 0;
    }

    @Override
    public int isNullable(int n2) {
        return 1;
    }

    @Override
    public boolean isSigned(int n2) {
        return true;
    }

    public Statement getStatement() {
        return this;
    }

    private void batch(int n2, Object object) {
        this.checkOpen();
        if (this.batch == null) {
            this.batch = new Object[this.paramCount];
        }
        this.batch[this.batchPos + n2 - 1] = object;
    }

    @Override
    public void setBoolean(int n2, boolean bl2) {
        this.setInt(n2, bl2 ? 1 : 0);
    }

    @Override
    public void setByte(int n2, byte by2) {
        this.setInt(n2, by2);
    }

    @Override
    public void setBytes(int n2, byte[] arrby) {
        this.batch(n2, arrby);
    }

    @Override
    public void setDouble(int n2, double d2) {
        this.batch(n2, new Double(d2));
    }

    @Override
    public void setFloat(int n2, float f2) {
        this.batch(n2, new Float(f2));
    }

    @Override
    public void setInt(int n2, int n3) {
        this.batch(n2, new Integer(n3));
    }

    @Override
    public void setLong(int n2, long l2) {
        this.batch(n2, new Long(l2));
    }

    @Override
    public void setNull(int n2, int n3) {
        this.setNull(n2, n3, null);
    }

    @Override
    public void setNull(int n2, int n3, String string) {
        this.batch(n2, null);
    }

    @Override
    public void setObject(int n2, Object object) {
        if (object == null) {
            this.batch(n2, null);
            return;
        }
        if (object instanceof java.util.Date) {
            this.batch(n2, new Long(((java.util.Date)object).getTime()));
            return;
        }
        if (object instanceof Date) {
            this.batch(n2, new Long(((Date)object).getTime()));
            return;
        }
        if (object instanceof Time) {
            this.batch(n2, new Long(((Time)object).getTime()));
            return;
        }
        if (object instanceof Timestamp) {
            this.batch(n2, new Long(((Timestamp)object).getTime()));
            return;
        }
        if (object instanceof Long) {
            this.batch(n2, object);
            return;
        }
        if (object instanceof Integer) {
            this.batch(n2, object);
            return;
        }
        if (object instanceof Short) {
            this.batch(n2, new Integer(((Short)object).intValue()));
            return;
        }
        if (object instanceof Float) {
            this.batch(n2, object);
            return;
        }
        if (object instanceof Double) {
            this.batch(n2, object);
            return;
        }
        if (object instanceof Boolean) {
            this.setBoolean(n2, (Boolean)object);
            return;
        }
        if (object instanceof byte[]) {
            this.batch(n2, object);
            return;
        }
        this.batch(n2, object.toString());
    }

    @Override
    public void setObject(int n2, Object object, int n3) {
        this.setObject(n2, object);
    }

    @Override
    public void setObject(int n2, Object object, int n3, int n4) {
        this.setObject(n2, object);
    }

    @Override
    public void setShort(int n2, short s2) {
        this.setInt(n2, s2);
    }

    @Override
    public void setString(int n2, String string) {
        this.batch(n2, string);
    }

    @Override
    public void setCharacterStream(int n2, Reader reader, int n3) {
        try {
            StringBuffer stringBuffer = new StringBuffer();
            char[] arrc = new char[8192];
            do {
                int n4;
                if ((n4 = reader.read(arrc)) <= 0) {
                    this.setString(n2, stringBuffer.toString());
                    return;
                }
                stringBuffer.append(arrc, 0, n4);
            } while (true);
        }
        catch (IOException var4_5) {
            throw new SQLException("Cannot read from character stream, exception message: " + var4_5.getMessage());
        }
    }

    @Override
    public void setDate(int n2, Date date) {
        this.setObject(n2, date);
    }

    @Override
    public void setDate(int n2, Date date, Calendar calendar) {
        this.setObject(n2, date);
    }

    @Override
    public void setTime(int n2, Time time) {
        this.setObject(n2, time);
    }

    @Override
    public void setTime(int n2, Time time, Calendar calendar) {
        this.setObject(n2, time);
    }

    @Override
    public void setTimestamp(int n2, Timestamp timestamp) {
        this.setObject(n2, timestamp);
    }

    @Override
    public void setTimestamp(int n2, Timestamp timestamp, Calendar calendar) {
        this.setObject(n2, timestamp);
    }

    @Override
    public ResultSetMetaData getMetaData() {
        this.checkOpen();
        return this.rs;
    }

    @Override
    public boolean execute(String string) {
        throw this.unused();
    }

    @Override
    public int executeUpdate(String string) {
        throw this.unused();
    }

    @Override
    public ResultSet executeQuery(String string) {
        throw this.unused();
    }

    @Override
    public void addBatch(String string) {
        throw this.unused();
    }

    private SQLException unused() {
        return new SQLException("not supported by PreparedStatment");
    }
}

