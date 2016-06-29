/*
 * Decompiled with CFR 0_115.
 */
package org.sqlite;

import java.io.Reader;
import java.io.StringReader;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.Statement;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import org.sqlite.Codes;
import org.sqlite.DB;
import org.sqlite.Stmt;
import org.sqlite.Unused;

final class RS
extends Unused
implements ResultSet,
ResultSetMetaData,
Codes {
    private final Stmt stmt;
    private final DB db;
    boolean open = false;
    int maxRows;
    String[] cols = null;
    String[] colsMeta = null;
    boolean[][] meta = null;
    private int limitRows;
    private int row = 0;
    private int lastCol;

    RS(Stmt stmt) {
        this.stmt = stmt;
        this.db = stmt.db;
    }

    boolean isOpen() {
        return this.open;
    }

    void checkOpen() {
        if (this.open) return;
        throw new SQLException("ResultSet closed");
    }

    private int checkCol(int n2) {
        if (this.colsMeta == null) {
            throw new IllegalStateException("SQLite JDBC: inconsistent internal state");
        }
        if (n2 < 1) throw new SQLException("column " + n2 + " out of bounds [1," + this.colsMeta.length + "]");
        if (n2 <= this.colsMeta.length) return --n2;
        throw new SQLException("column " + n2 + " out of bounds [1," + this.colsMeta.length + "]");
    }

    private int markCol(int n2) {
        this.checkOpen();
        this.checkCol(n2);
        this.lastCol = n2--;
        return n2;
    }

    private void checkMeta() {
        this.checkCol(1);
        if (this.meta != null) return;
        this.meta = this.db.column_metadata(this.stmt.pointer);
    }

    @Override
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
        if (this.stmt == null) return;
        if (this.stmt.pointer == 0) return;
        this.db.reset(this.stmt.pointer);
    }

    @Override
    public int findColumn(String string) {
        this.checkOpen();
        int n2 = -1;
        int n3 = 0;
        do {
            if (n3 >= this.cols.length) {
                if (n2 != -1) return n2 + 1;
                throw new SQLException("no such column: '" + string + "'");
            }
            if (string.equalsIgnoreCase(this.cols[n3]) || this.cols[n3].toUpperCase().endsWith(string.toUpperCase()) && this.cols[n3].charAt(this.cols[n3].length() - string.length()) == '.') {
                if (n2 != -1) throw new SQLException("ambiguous column: '" + string + "'");
                n2 = n3;
            }
            ++n3;
        } while (true);
    }

    @Override
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
        int n2 = this.db.step(this.stmt.pointer);
        switch (n2) {
            case 101: {
                this.close();
                return false;
            }
            case 100: {
                ++this.row;
                return true;
            }
        }
        this.db.throwex(n2);
        return false;
    }

    @Override
    public int getType() {
        return 1003;
    }

    @Override
    public int getFetchSize() {
        return this.limitRows;
    }

    @Override
    public void setFetchSize(int n2) {
        if (0 > n2) throw new SQLException("fetch size " + n2 + " out of bounds " + this.maxRows);
        if (this.maxRows != 0 && n2 > this.maxRows) {
            throw new SQLException("fetch size " + n2 + " out of bounds " + this.maxRows);
        }
        this.limitRows = n2;
    }

    @Override
    public int getFetchDirection() {
        this.checkOpen();
        return 1000;
    }

    @Override
    public void setFetchDirection(int n2) {
        this.checkOpen();
        if (n2 == 1000) return;
        throw new SQLException("only FETCH_FORWARD direction supported");
    }

    @Override
    public boolean isAfterLast() {
        if (this.open) return false;
        return true;
    }

    @Override
    public boolean isBeforeFirst() {
        if (!this.open) return false;
        if (this.row != 0) return false;
        return true;
    }

    @Override
    public boolean isFirst() {
        if (this.row != 1) return false;
        return true;
    }

    @Override
    public boolean isLast() {
        throw new SQLException("function not yet implemented for SQLite");
    }

    protected void finalize() {
        this.close();
    }

    @Override
    public int getRow() {
        return this.row;
    }

    @Override
    public boolean wasNull() {
        if (this.db.column_type(this.stmt.pointer, this.markCol(this.lastCol)) != 5) return false;
        return true;
    }

    @Override
    public boolean getBoolean(int n2) {
        if (this.getInt(n2) != 0) return true;
        return false;
    }

    @Override
    public boolean getBoolean(String string) {
        return this.getBoolean(this.findColumn(string));
    }

    @Override
    public byte getByte(int n2) {
        return (byte)this.getInt(n2);
    }

    @Override
    public byte getByte(String string) {
        return this.getByte(this.findColumn(string));
    }

    @Override
    public byte[] getBytes(int n2) {
        return this.db.column_blob(this.stmt.pointer, this.markCol(n2));
    }

    @Override
    public byte[] getBytes(String string) {
        return this.getBytes(this.findColumn(string));
    }

    @Override
    public Reader getCharacterStream(int n2) {
        return new StringReader(this.getString(n2));
    }

    @Override
    public Reader getCharacterStream(String string) {
        return this.getCharacterStream(this.findColumn(string));
    }

    @Override
    public java.sql.Date getDate(int n2) {
        if (this.db.column_type(this.stmt.pointer, this.markCol(n2)) != 5) return new java.sql.Date(this.db.column_long(this.stmt.pointer, this.markCol(n2)));
        return null;
    }

    @Override
    public java.sql.Date getDate(int n2, Calendar calendar) {
        if (this.db.column_type(this.stmt.pointer, this.markCol(n2)) == 5) {
            return null;
        }
        if (calendar == null) {
            return this.getDate(n2);
        }
        calendar.setTimeInMillis(this.db.column_long(this.stmt.pointer, this.markCol(n2)));
        return new java.sql.Date(calendar.getTime().getTime());
    }

    @Override
    public java.sql.Date getDate(String string) {
        return this.getDate(this.findColumn(string), Calendar.getInstance());
    }

    @Override
    public java.sql.Date getDate(String string, Calendar calendar) {
        return this.getDate(this.findColumn(string), calendar);
    }

    @Override
    public double getDouble(int n2) {
        if (this.db.column_type(this.stmt.pointer, this.markCol(n2)) != 5) return this.db.column_double(this.stmt.pointer, this.markCol(n2));
        return 0.0;
    }

    @Override
    public double getDouble(String string) {
        return this.getDouble(this.findColumn(string));
    }

    @Override
    public float getFloat(int n2) {
        if (this.db.column_type(this.stmt.pointer, this.markCol(n2)) != 5) return (float)this.db.column_double(this.stmt.pointer, this.markCol(n2));
        return 0.0f;
    }

    @Override
    public float getFloat(String string) {
        return this.getFloat(this.findColumn(string));
    }

    @Override
    public int getInt(int n2) {
        return this.db.column_int(this.stmt.pointer, this.markCol(n2));
    }

    @Override
    public int getInt(String string) {
        return this.getInt(this.findColumn(string));
    }

    @Override
    public long getLong(int n2) {
        return this.db.column_long(this.stmt.pointer, this.markCol(n2));
    }

    @Override
    public long getLong(String string) {
        return this.getLong(this.findColumn(string));
    }

    @Override
    public short getShort(int n2) {
        return (short)this.getInt(n2);
    }

    @Override
    public short getShort(String string) {
        return this.getShort(this.findColumn(string));
    }

    @Override
    public String getString(int n2) {
        return this.db.column_text(this.stmt.pointer, this.markCol(n2));
    }

    @Override
    public String getString(String string) {
        return this.getString(this.findColumn(string));
    }

    @Override
    public Time getTime(int n2) {
        if (this.db.column_type(this.stmt.pointer, this.markCol(n2)) != 5) return new Time(this.db.column_long(this.stmt.pointer, this.markCol(n2)));
        return null;
    }

    @Override
    public Time getTime(int n2, Calendar calendar) {
        if (calendar == null) {
            return this.getTime(n2);
        }
        if (this.db.column_type(this.stmt.pointer, this.markCol(n2)) == 5) {
            return null;
        }
        calendar.setTimeInMillis(this.db.column_long(this.stmt.pointer, this.markCol(n2)));
        return new Time(calendar.getTime().getTime());
    }

    @Override
    public Time getTime(String string) {
        return this.getTime(this.findColumn(string));
    }

    @Override
    public Time getTime(String string, Calendar calendar) {
        return this.getTime(this.findColumn(string), calendar);
    }

    @Override
    public Timestamp getTimestamp(int n2) {
        if (this.db.column_type(this.stmt.pointer, this.markCol(n2)) != 5) return new Timestamp(this.db.column_long(this.stmt.pointer, this.markCol(n2)));
        return null;
    }

    @Override
    public Timestamp getTimestamp(int n2, Calendar calendar) {
        if (calendar == null) {
            return this.getTimestamp(n2);
        }
        if (this.db.column_type(this.stmt.pointer, this.markCol(n2)) == 5) {
            return null;
        }
        calendar.setTimeInMillis(this.db.column_long(this.stmt.pointer, this.markCol(n2)));
        return new Timestamp(calendar.getTime().getTime());
    }

    @Override
    public Timestamp getTimestamp(String string) {
        return this.getTimestamp(this.findColumn(string));
    }

    @Override
    public Timestamp getTimestamp(String string, Calendar calendar) {
        return this.getTimestamp(this.findColumn(string), calendar);
    }

    @Override
    public Object getObject(int n2) {
        switch (this.db.column_type(this.stmt.pointer, this.checkCol(n2))) {
            case 1: {
                long l2 = this.getLong(n2);
                if (l2 > Integer.MAX_VALUE) return new Long(l2);
                if (l2 >= Integer.MIN_VALUE) return new Integer((int)l2);
                return new Long(l2);
            }
            case 2: {
                return new Double(this.getDouble(n2));
            }
            case 4: {
                return this.getBytes(n2);
            }
            case 5: {
                return null;
            }
        }
        return this.getString(n2);
    }

    @Override
    public Object getObject(String string) {
        return this.getObject(this.findColumn(string));
    }

    @Override
    public Statement getStatement() {
        return this.stmt;
    }

    @Override
    public String getCursorName() {
        return null;
    }

    @Override
    public SQLWarning getWarnings() {
        return null;
    }

    @Override
    public void clearWarnings() {
    }

    @Override
    public ResultSetMetaData getMetaData() {
        return this;
    }

    @Override
    public String getCatalogName(int n2) {
        return this.db.column_table_name(this.stmt.pointer, this.checkCol(n2));
    }

    @Override
    public String getColumnClassName(int n2) {
        this.checkCol(n2);
        return "java.lang.Object";
    }

    @Override
    public int getColumnCount() {
        this.checkCol(1);
        return this.colsMeta.length;
    }

    @Override
    public int getColumnDisplaySize(int n2) {
        return Integer.MAX_VALUE;
    }

    @Override
    public String getColumnLabel(int n2) {
        return this.getColumnName(n2);
    }

    @Override
    public String getColumnName(int n2) {
        return this.db.column_name(this.stmt.pointer, this.checkCol(n2));
    }

    @Override
    public int getColumnType(int n2) {
        switch (this.db.column_type(this.stmt.pointer, this.checkCol(n2))) {
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
        }
        return 12;
    }

    @Override
    public String getColumnTypeName(int n2) {
        switch (this.db.column_type(this.stmt.pointer, this.checkCol(n2))) {
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
        }
        return "text";
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
    public String getSchemaName(int n2) {
        return "";
    }

    @Override
    public String getTableName(int n2) {
        return this.db.column_table_name(this.stmt.pointer, this.checkCol(n2));
    }

    @Override
    public int isNullable(int n2) {
        this.checkMeta();
        if (!this.meta[this.checkCol(n2)][1]) return 1;
        return 0;
    }

    @Override
    public boolean isAutoIncrement(int n2) {
        this.checkMeta();
        return this.meta[this.checkCol(n2)][2];
    }

    @Override
    public boolean isCaseSensitive(int n2) {
        return true;
    }

    @Override
    public boolean isCurrency(int n2) {
        return false;
    }

    @Override
    public boolean isDefinitelyWritable(int n2) {
        return true;
    }

    @Override
    public boolean isReadOnly(int n2) {
        return false;
    }

    @Override
    public boolean isSearchable(int n2) {
        return true;
    }

    @Override
    public boolean isSigned(int n2) {
        return false;
    }

    @Override
    public boolean isWritable(int n2) {
        return true;
    }

    @Override
    public int getConcurrency() {
        return 1007;
    }

    @Override
    public boolean rowDeleted() {
        return false;
    }

    @Override
    public boolean rowInserted() {
        return false;
    }

    @Override
    public boolean rowUpdated() {
        return false;
    }
}

