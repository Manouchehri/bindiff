package org.sqlite;

import java.io.*;
import java.util.*;
import java.sql.*;

final class RS extends Unused implements ResultSet, ResultSetMetaData, Codes
{
    private final Stmt stmt;
    private final DB db;
    boolean open;
    int maxRows;
    String[] cols;
    String[] colsMeta;
    boolean[][] meta;
    private int limitRows;
    private int row;
    private int lastCol;
    
    RS(final Stmt stmt) {
        this.open = false;
        this.cols = null;
        this.colsMeta = null;
        this.meta = null;
        this.row = 0;
        this.stmt = stmt;
        this.db = stmt.db;
    }
    
    boolean isOpen() {
        return this.open;
    }
    
    void checkOpen() {
        if (!this.open) {
            throw new SQLException("ResultSet closed");
        }
    }
    
    private int checkCol(int n) {
        if (this.colsMeta == null) {
            throw new IllegalStateException("SQLite JDBC: inconsistent internal state");
        }
        if (n < 1 || n > this.colsMeta.length) {
            throw new SQLException("column " + n + " out of bounds [1," + this.colsMeta.length + "]");
        }
        return --n;
    }
    
    private int markCol(int lastCol) {
        this.checkOpen();
        this.checkCol(lastCol);
        this.lastCol = lastCol;
        return --lastCol;
    }
    
    private void checkMeta() {
        this.checkCol(1);
        if (this.meta == null) {
            this.meta = this.db.column_metadata(this.stmt.pointer);
        }
    }
    
    public void close() {
        this.cols = null;
        this.colsMeta = null;
        this.meta = null;
        this.open = false;
        this.limitRows = 0;
        this.row = 0;
        this.lastCol = -1;
        if (this.stmt == null) {
            return;
        }
        if (this.stmt != null && this.stmt.pointer != 0L) {
            this.db.reset(this.stmt.pointer);
        }
    }
    
    public int findColumn(final String s) {
        this.checkOpen();
        int n = -1;
        for (int i = 0; i < this.cols.length; ++i) {
            if (s.equalsIgnoreCase(this.cols[i]) || (this.cols[i].toUpperCase().endsWith(s.toUpperCase()) && this.cols[i].charAt(this.cols[i].length() - s.length()) == '.')) {
                if (n != -1) {
                    throw new SQLException("ambiguous column: '" + s + "'");
                }
                n = i;
            }
        }
        if (n == -1) {
            throw new SQLException("no such column: '" + s + "'");
        }
        return n + 1;
    }
    
    public boolean next() {
        if (!this.open) {
            return false;
        }
        this.lastCol = -1;
        if (this.row == 0) {
            ++this.row;
            return true;
        }
        if (this.maxRows != 0 && this.row > this.maxRows) {
            return false;
        }
        final int step = this.db.step(this.stmt.pointer);
        switch (step) {
            case 101: {
                this.close();
                return false;
            }
            case 100: {
                ++this.row;
                return true;
            }
            default: {
                this.db.throwex(step);
                return false;
            }
        }
    }
    
    public int getType() {
        return 1003;
    }
    
    public int getFetchSize() {
        return this.limitRows;
    }
    
    public void setFetchSize(final int limitRows) {
        if (0 > limitRows || (this.maxRows != 0 && limitRows > this.maxRows)) {
            throw new SQLException("fetch size " + limitRows + " out of bounds " + this.maxRows);
        }
        this.limitRows = limitRows;
    }
    
    public int getFetchDirection() {
        this.checkOpen();
        return 1000;
    }
    
    public void setFetchDirection(final int n) {
        this.checkOpen();
        if (n != 1000) {
            throw new SQLException("only FETCH_FORWARD direction supported");
        }
    }
    
    public boolean isAfterLast() {
        return !this.open;
    }
    
    public boolean isBeforeFirst() {
        return this.open && this.row == 0;
    }
    
    public boolean isFirst() {
        return this.row == 1;
    }
    
    public boolean isLast() {
        throw new SQLException("function not yet implemented for SQLite");
    }
    
    protected void finalize() {
        this.close();
    }
    
    public int getRow() {
        return this.row;
    }
    
    public boolean wasNull() {
        return this.db.column_type(this.stmt.pointer, this.markCol(this.lastCol)) == 5;
    }
    
    public boolean getBoolean(final int n) {
        return this.getInt(n) != 0;
    }
    
    public boolean getBoolean(final String s) {
        return this.getBoolean(this.findColumn(s));
    }
    
    public byte getByte(final int n) {
        return (byte)this.getInt(n);
    }
    
    public byte getByte(final String s) {
        return this.getByte(this.findColumn(s));
    }
    
    public byte[] getBytes(final int n) {
        return this.db.column_blob(this.stmt.pointer, this.markCol(n));
    }
    
    public byte[] getBytes(final String s) {
        return this.getBytes(this.findColumn(s));
    }
    
    public Reader getCharacterStream(final int n) {
        return new StringReader(this.getString(n));
    }
    
    public Reader getCharacterStream(final String s) {
        return this.getCharacterStream(this.findColumn(s));
    }
    
    public Date getDate(final int n) {
        if (this.db.column_type(this.stmt.pointer, this.markCol(n)) == 5) {
            return null;
        }
        return new Date(this.db.column_long(this.stmt.pointer, this.markCol(n)));
    }
    
    public Date getDate(final int n, final Calendar calendar) {
        if (this.db.column_type(this.stmt.pointer, this.markCol(n)) == 5) {
            return null;
        }
        if (calendar == null) {
            return this.getDate(n);
        }
        calendar.setTimeInMillis(this.db.column_long(this.stmt.pointer, this.markCol(n)));
        return new Date(calendar.getTime().getTime());
    }
    
    public Date getDate(final String s) {
        return this.getDate(this.findColumn(s), Calendar.getInstance());
    }
    
    public Date getDate(final String s, final Calendar calendar) {
        return this.getDate(this.findColumn(s), calendar);
    }
    
    public double getDouble(final int n) {
        if (this.db.column_type(this.stmt.pointer, this.markCol(n)) == 5) {
            return 0.0;
        }
        return this.db.column_double(this.stmt.pointer, this.markCol(n));
    }
    
    public double getDouble(final String s) {
        return this.getDouble(this.findColumn(s));
    }
    
    public float getFloat(final int n) {
        if (this.db.column_type(this.stmt.pointer, this.markCol(n)) == 5) {
            return 0.0f;
        }
        return (float)this.db.column_double(this.stmt.pointer, this.markCol(n));
    }
    
    public float getFloat(final String s) {
        return this.getFloat(this.findColumn(s));
    }
    
    public int getInt(final int n) {
        return this.db.column_int(this.stmt.pointer, this.markCol(n));
    }
    
    public int getInt(final String s) {
        return this.getInt(this.findColumn(s));
    }
    
    public long getLong(final int n) {
        return this.db.column_long(this.stmt.pointer, this.markCol(n));
    }
    
    public long getLong(final String s) {
        return this.getLong(this.findColumn(s));
    }
    
    public short getShort(final int n) {
        return (short)this.getInt(n);
    }
    
    public short getShort(final String s) {
        return this.getShort(this.findColumn(s));
    }
    
    public String getString(final int n) {
        return this.db.column_text(this.stmt.pointer, this.markCol(n));
    }
    
    public String getString(final String s) {
        return this.getString(this.findColumn(s));
    }
    
    public Time getTime(final int n) {
        if (this.db.column_type(this.stmt.pointer, this.markCol(n)) == 5) {
            return null;
        }
        return new Time(this.db.column_long(this.stmt.pointer, this.markCol(n)));
    }
    
    public Time getTime(final int n, final Calendar calendar) {
        if (calendar == null) {
            return this.getTime(n);
        }
        if (this.db.column_type(this.stmt.pointer, this.markCol(n)) == 5) {
            return null;
        }
        calendar.setTimeInMillis(this.db.column_long(this.stmt.pointer, this.markCol(n)));
        return new Time(calendar.getTime().getTime());
    }
    
    public Time getTime(final String s) {
        return this.getTime(this.findColumn(s));
    }
    
    public Time getTime(final String s, final Calendar calendar) {
        return this.getTime(this.findColumn(s), calendar);
    }
    
    public Timestamp getTimestamp(final int n) {
        if (this.db.column_type(this.stmt.pointer, this.markCol(n)) == 5) {
            return null;
        }
        return new Timestamp(this.db.column_long(this.stmt.pointer, this.markCol(n)));
    }
    
    public Timestamp getTimestamp(final int n, final Calendar calendar) {
        if (calendar == null) {
            return this.getTimestamp(n);
        }
        if (this.db.column_type(this.stmt.pointer, this.markCol(n)) == 5) {
            return null;
        }
        calendar.setTimeInMillis(this.db.column_long(this.stmt.pointer, this.markCol(n)));
        return new Timestamp(calendar.getTime().getTime());
    }
    
    public Timestamp getTimestamp(final String s) {
        return this.getTimestamp(this.findColumn(s));
    }
    
    public Timestamp getTimestamp(final String s, final Calendar calendar) {
        return this.getTimestamp(this.findColumn(s), calendar);
    }
    
    public Object getObject(final int n) {
        switch (this.db.column_type(this.stmt.pointer, this.checkCol(n))) {
            case 1: {
                final long long1 = this.getLong(n);
                if (long1 > 2147483647L || long1 < -2147483648L) {
                    return new Long(long1);
                }
                return new Integer((int)long1);
            }
            case 2: {
                return new Double(this.getDouble(n));
            }
            case 4: {
                return this.getBytes(n);
            }
            case 5: {
                return null;
            }
            default: {
                return this.getString(n);
            }
        }
    }
    
    public Object getObject(final String s) {
        return this.getObject(this.findColumn(s));
    }
    
    public Statement getStatement() {
        return this.stmt;
    }
    
    public String getCursorName() {
        return null;
    }
    
    public SQLWarning getWarnings() {
        return null;
    }
    
    public void clearWarnings() {
    }
    
    public ResultSetMetaData getMetaData() {
        return this;
    }
    
    public String getCatalogName(final int n) {
        return this.db.column_table_name(this.stmt.pointer, this.checkCol(n));
    }
    
    public String getColumnClassName(final int n) {
        this.checkCol(n);
        return "java.lang.Object";
    }
    
    public int getColumnCount() {
        this.checkCol(1);
        return this.colsMeta.length;
    }
    
    public int getColumnDisplaySize(final int n) {
        return Integer.MAX_VALUE;
    }
    
    public String getColumnLabel(final int n) {
        return this.getColumnName(n);
    }
    
    public String getColumnName(final int n) {
        return this.db.column_name(this.stmt.pointer, this.checkCol(n));
    }
    
    public int getColumnType(final int n) {
        switch (this.db.column_type(this.stmt.pointer, this.checkCol(n))) {
            case 1: {
                return 4;
            }
            case 2: {
                return 6;
            }
            case 4: {
                return 2004;
            }
            case 5: {
                return 0;
            }
            default: {
                return 12;
            }
        }
    }
    
    public String getColumnTypeName(final int n) {
        switch (this.db.column_type(this.stmt.pointer, this.checkCol(n))) {
            case 1: {
                return "integer";
            }
            case 2: {
                return "float";
            }
            case 4: {
                return "blob";
            }
            case 5: {
                return "null";
            }
            default: {
                return "text";
            }
        }
    }
    
    public int getPrecision(final int n) {
        return 0;
    }
    
    public int getScale(final int n) {
        return 0;
    }
    
    public String getSchemaName(final int n) {
        return "";
    }
    
    public String getTableName(final int n) {
        return this.db.column_table_name(this.stmt.pointer, this.checkCol(n));
    }
    
    public int isNullable(final int n) {
        this.checkMeta();
        return this.meta[this.checkCol(n)][1] ? 0 : 1;
    }
    
    public boolean isAutoIncrement(final int n) {
        this.checkMeta();
        return this.meta[this.checkCol(n)][2];
    }
    
    public boolean isCaseSensitive(final int n) {
        return true;
    }
    
    public boolean isCurrency(final int n) {
        return false;
    }
    
    public boolean isDefinitelyWritable(final int n) {
        return true;
    }
    
    public boolean isReadOnly(final int n) {
        return false;
    }
    
    public boolean isSearchable(final int n) {
        return true;
    }
    
    public boolean isSigned(final int n) {
        return false;
    }
    
    public boolean isWritable(final int n) {
        return true;
    }
    
    public int getConcurrency() {
        return 1007;
    }
    
    public boolean rowDeleted() {
        return false;
    }
    
    public boolean rowInserted() {
        return false;
    }
    
    public boolean rowUpdated() {
        return false;
    }
}
