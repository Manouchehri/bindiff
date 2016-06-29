/*
 * Decompiled with CFR 0_115.
 */
package org.sqlite;

import java.io.InputStream;
import java.io.Reader;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.Array;
import java.sql.Blob;
import java.sql.Clob;
import java.sql.Date;
import java.sql.Ref;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Map;

abstract class Unused {
    Unused() {
    }

    private SQLException unused() {
        return new SQLException("not implemented by SQLite JDBC driver");
    }

    public void setEscapeProcessing(boolean bl2) {
        throw this.unused();
    }

    public boolean execute(String string, int[] arrn) {
        throw this.unused();
    }

    public boolean execute(String string, String[] arrstring) {
        throw this.unused();
    }

    public int executeUpdate(String string, int n2) {
        throw this.unused();
    }

    public int executeUpdate(String string, int[] arrn) {
        throw this.unused();
    }

    public int executeUpdate(String string, String[] arrstring) {
        throw this.unused();
    }

    public boolean execute(String string, int n2) {
        throw this.unused();
    }

    public void setArray(int n2, Array array) {
        throw this.unused();
    }

    public void setAsciiStream(int n2, InputStream inputStream, int n3) {
        throw this.unused();
    }

    public void setBigDecimal(int n2, BigDecimal bigDecimal) {
        throw this.unused();
    }

    public void setBinaryStream(int n2, InputStream inputStream, int n3) {
        throw this.unused();
    }

    public void setBlob(int n2, Blob blob) {
        throw this.unused();
    }

    public void setClob(int n2, Clob clob) {
        throw this.unused();
    }

    public void setRef(int n2, Ref ref) {
        throw this.unused();
    }

    public void setUnicodeStream(int n2, InputStream inputStream, int n3) {
        throw this.unused();
    }

    public void setURL(int n2, URL uRL) {
        throw this.unused();
    }

    public Array getArray(int n2) {
        throw this.unused();
    }

    public Array getArray(String string) {
        throw this.unused();
    }

    public InputStream getAsciiStream(int n2) {
        throw this.unused();
    }

    public InputStream getAsciiStream(String string) {
        throw this.unused();
    }

    public BigDecimal getBigDecimal(int n2) {
        throw this.unused();
    }

    public BigDecimal getBigDecimal(int n2, int n3) {
        throw this.unused();
    }

    public BigDecimal getBigDecimal(String string) {
        throw this.unused();
    }

    public BigDecimal getBigDecimal(String string, int n2) {
        throw this.unused();
    }

    public InputStream getBinaryStream(int n2) {
        throw this.unused();
    }

    public InputStream getBinaryStream(String string) {
        throw this.unused();
    }

    public Blob getBlob(int n2) {
        throw this.unused();
    }

    public Blob getBlob(String string) {
        throw this.unused();
    }

    public Clob getClob(int n2) {
        throw this.unused();
    }

    public Clob getClob(String string) {
        throw this.unused();
    }

    public Object getObject(int n2, Map map) {
        throw this.unused();
    }

    public Object getObject(String string, Map map) {
        throw this.unused();
    }

    public Ref getRef(int n2) {
        throw this.unused();
    }

    public Ref getRef(String string) {
        throw this.unused();
    }

    public InputStream getUnicodeStream(int n2) {
        throw this.unused();
    }

    public InputStream getUnicodeStream(String string) {
        throw this.unused();
    }

    public URL getURL(int n2) {
        throw this.unused();
    }

    public URL getURL(String string) {
        throw this.unused();
    }

    public void insertRow() {
        throw new SQLException("ResultSet is TYPE_FORWARD_ONLY");
    }

    public void moveToCurrentRow() {
        throw new SQLException("ResultSet is TYPE_FORWARD_ONLY");
    }

    public void moveToInsertRow() {
        throw new SQLException("ResultSet is TYPE_FORWARD_ONLY");
    }

    public boolean last() {
        throw new SQLException("ResultSet is TYPE_FORWARD_ONLY");
    }

    public boolean previous() {
        throw new SQLException("ResultSet is TYPE_FORWARD_ONLY");
    }

    public boolean relative(int n2) {
        throw new SQLException("ResultSet is TYPE_FORWARD_ONLY");
    }

    public boolean absolute(int n2) {
        throw new SQLException("ResultSet is TYPE_FORWARD_ONLY");
    }

    public void afterLast() {
        throw new SQLException("ResultSet is TYPE_FORWARD_ONLY");
    }

    public void beforeFirst() {
        throw new SQLException("ResultSet is TYPE_FORWARD_ONLY");
    }

    public boolean first() {
        throw new SQLException("ResultSet is TYPE_FORWARD_ONLY");
    }

    public void cancelRowUpdates() {
        throw this.unused();
    }

    public void deleteRow() {
        throw this.unused();
    }

    public void updateArray(int n2, Array array) {
        throw this.unused();
    }

    public void updateArray(String string, Array array) {
        throw this.unused();
    }

    public void updateAsciiStream(int n2, InputStream inputStream, int n3) {
        throw this.unused();
    }

    public void updateAsciiStream(String string, InputStream inputStream, int n2) {
        throw this.unused();
    }

    public void updateBigDecimal(int n2, BigDecimal bigDecimal) {
        throw this.unused();
    }

    public void updateBigDecimal(String string, BigDecimal bigDecimal) {
        throw this.unused();
    }

    public void updateBinaryStream(int n2, InputStream inputStream, int n3) {
        throw this.unused();
    }

    public void updateBinaryStream(String string, InputStream inputStream, int n2) {
        throw this.unused();
    }

    public void updateBlob(int n2, Blob blob) {
        throw this.unused();
    }

    public void updateBlob(String string, Blob blob) {
        throw this.unused();
    }

    public void updateBoolean(int n2, boolean bl2) {
        throw this.unused();
    }

    public void updateBoolean(String string, boolean bl2) {
        throw this.unused();
    }

    public void updateByte(int n2, byte by2) {
        throw this.unused();
    }

    public void updateByte(String string, byte by2) {
        throw this.unused();
    }

    public void updateBytes(int n2, byte[] arrby) {
        throw this.unused();
    }

    public void updateBytes(String string, byte[] arrby) {
        throw this.unused();
    }

    public void updateCharacterStream(int n2, Reader reader, int n3) {
        throw this.unused();
    }

    public void updateCharacterStream(String string, Reader reader, int n2) {
        throw this.unused();
    }

    public void updateClob(int n2, Clob clob) {
        throw this.unused();
    }

    public void updateClob(String string, Clob clob) {
        throw this.unused();
    }

    public void updateDate(int n2, Date date) {
        throw this.unused();
    }

    public void updateDate(String string, Date date) {
        throw this.unused();
    }

    public void updateDouble(int n2, double d2) {
        throw this.unused();
    }

    public void updateDouble(String string, double d2) {
        throw this.unused();
    }

    public void updateFloat(int n2, float f2) {
        throw this.unused();
    }

    public void updateFloat(String string, float f2) {
        throw this.unused();
    }

    public void updateInt(int n2, int n3) {
        throw this.unused();
    }

    public void updateInt(String string, int n2) {
        throw this.unused();
    }

    public void updateLong(int n2, long l2) {
        throw this.unused();
    }

    public void updateLong(String string, long l2) {
        throw this.unused();
    }

    public void updateNull(int n2) {
        throw this.unused();
    }

    public void updateNull(String string) {
        throw this.unused();
    }

    public void updateObject(int n2, Object object) {
        throw this.unused();
    }

    public void updateObject(int n2, Object object, int n3) {
        throw this.unused();
    }

    public void updateObject(String string, Object object) {
        throw this.unused();
    }

    public void updateObject(String string, Object object, int n2) {
        throw this.unused();
    }

    public void updateRef(int n2, Ref ref) {
        throw this.unused();
    }

    public void updateRef(String string, Ref ref) {
        throw this.unused();
    }

    public void updateRow() {
        throw this.unused();
    }

    public void updateShort(int n2, short s2) {
        throw this.unused();
    }

    public void updateShort(String string, short s2) {
        throw this.unused();
    }

    public void updateString(int n2, String string) {
        throw this.unused();
    }

    public void updateString(String string, String string2) {
        throw this.unused();
    }

    public void updateTime(int n2, Time time) {
        throw this.unused();
    }

    public void updateTime(String string, Time time) {
        throw this.unused();
    }

    public void updateTimestamp(int n2, Timestamp timestamp) {
        throw this.unused();
    }

    public void updateTimestamp(String string, Timestamp timestamp) {
        throw this.unused();
    }

    public void refreshRow() {
        throw this.unused();
    }
}

