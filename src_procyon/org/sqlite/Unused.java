package org.sqlite;

import java.math.*;
import java.net.*;
import java.util.*;
import java.io.*;
import java.sql.*;

abstract class Unused
{
    private SQLException unused() {
        return new SQLException("not implemented by SQLite JDBC driver");
    }
    
    public void setEscapeProcessing(final boolean b) {
        throw this.unused();
    }
    
    public boolean execute(final String s, final int[] array) {
        throw this.unused();
    }
    
    public boolean execute(final String s, final String[] array) {
        throw this.unused();
    }
    
    public int executeUpdate(final String s, final int n) {
        throw this.unused();
    }
    
    public int executeUpdate(final String s, final int[] array) {
        throw this.unused();
    }
    
    public int executeUpdate(final String s, final String[] array) {
        throw this.unused();
    }
    
    public boolean execute(final String s, final int n) {
        throw this.unused();
    }
    
    public void setArray(final int n, final Array array) {
        throw this.unused();
    }
    
    public void setAsciiStream(final int n, final InputStream inputStream, final int n2) {
        throw this.unused();
    }
    
    public void setBigDecimal(final int n, final BigDecimal bigDecimal) {
        throw this.unused();
    }
    
    public void setBinaryStream(final int n, final InputStream inputStream, final int n2) {
        throw this.unused();
    }
    
    public void setBlob(final int n, final Blob blob) {
        throw this.unused();
    }
    
    public void setClob(final int n, final Clob clob) {
        throw this.unused();
    }
    
    public void setRef(final int n, final Ref ref) {
        throw this.unused();
    }
    
    public void setUnicodeStream(final int n, final InputStream inputStream, final int n2) {
        throw this.unused();
    }
    
    public void setURL(final int n, final URL url) {
        throw this.unused();
    }
    
    public Array getArray(final int n) {
        throw this.unused();
    }
    
    public Array getArray(final String s) {
        throw this.unused();
    }
    
    public InputStream getAsciiStream(final int n) {
        throw this.unused();
    }
    
    public InputStream getAsciiStream(final String s) {
        throw this.unused();
    }
    
    public BigDecimal getBigDecimal(final int n) {
        throw this.unused();
    }
    
    public BigDecimal getBigDecimal(final int n, final int n2) {
        throw this.unused();
    }
    
    public BigDecimal getBigDecimal(final String s) {
        throw this.unused();
    }
    
    public BigDecimal getBigDecimal(final String s, final int n) {
        throw this.unused();
    }
    
    public InputStream getBinaryStream(final int n) {
        throw this.unused();
    }
    
    public InputStream getBinaryStream(final String s) {
        throw this.unused();
    }
    
    public Blob getBlob(final int n) {
        throw this.unused();
    }
    
    public Blob getBlob(final String s) {
        throw this.unused();
    }
    
    public Clob getClob(final int n) {
        throw this.unused();
    }
    
    public Clob getClob(final String s) {
        throw this.unused();
    }
    
    public Object getObject(final int n, final Map map) {
        throw this.unused();
    }
    
    public Object getObject(final String s, final Map map) {
        throw this.unused();
    }
    
    public Ref getRef(final int n) {
        throw this.unused();
    }
    
    public Ref getRef(final String s) {
        throw this.unused();
    }
    
    public InputStream getUnicodeStream(final int n) {
        throw this.unused();
    }
    
    public InputStream getUnicodeStream(final String s) {
        throw this.unused();
    }
    
    public URL getURL(final int n) {
        throw this.unused();
    }
    
    public URL getURL(final String s) {
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
    
    public boolean relative(final int n) {
        throw new SQLException("ResultSet is TYPE_FORWARD_ONLY");
    }
    
    public boolean absolute(final int n) {
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
    
    public void updateArray(final int n, final Array array) {
        throw this.unused();
    }
    
    public void updateArray(final String s, final Array array) {
        throw this.unused();
    }
    
    public void updateAsciiStream(final int n, final InputStream inputStream, final int n2) {
        throw this.unused();
    }
    
    public void updateAsciiStream(final String s, final InputStream inputStream, final int n) {
        throw this.unused();
    }
    
    public void updateBigDecimal(final int n, final BigDecimal bigDecimal) {
        throw this.unused();
    }
    
    public void updateBigDecimal(final String s, final BigDecimal bigDecimal) {
        throw this.unused();
    }
    
    public void updateBinaryStream(final int n, final InputStream inputStream, final int n2) {
        throw this.unused();
    }
    
    public void updateBinaryStream(final String s, final InputStream inputStream, final int n) {
        throw this.unused();
    }
    
    public void updateBlob(final int n, final Blob blob) {
        throw this.unused();
    }
    
    public void updateBlob(final String s, final Blob blob) {
        throw this.unused();
    }
    
    public void updateBoolean(final int n, final boolean b) {
        throw this.unused();
    }
    
    public void updateBoolean(final String s, final boolean b) {
        throw this.unused();
    }
    
    public void updateByte(final int n, final byte b) {
        throw this.unused();
    }
    
    public void updateByte(final String s, final byte b) {
        throw this.unused();
    }
    
    public void updateBytes(final int n, final byte[] array) {
        throw this.unused();
    }
    
    public void updateBytes(final String s, final byte[] array) {
        throw this.unused();
    }
    
    public void updateCharacterStream(final int n, final Reader reader, final int n2) {
        throw this.unused();
    }
    
    public void updateCharacterStream(final String s, final Reader reader, final int n) {
        throw this.unused();
    }
    
    public void updateClob(final int n, final Clob clob) {
        throw this.unused();
    }
    
    public void updateClob(final String s, final Clob clob) {
        throw this.unused();
    }
    
    public void updateDate(final int n, final Date date) {
        throw this.unused();
    }
    
    public void updateDate(final String s, final Date date) {
        throw this.unused();
    }
    
    public void updateDouble(final int n, final double n2) {
        throw this.unused();
    }
    
    public void updateDouble(final String s, final double n) {
        throw this.unused();
    }
    
    public void updateFloat(final int n, final float n2) {
        throw this.unused();
    }
    
    public void updateFloat(final String s, final float n) {
        throw this.unused();
    }
    
    public void updateInt(final int n, final int n2) {
        throw this.unused();
    }
    
    public void updateInt(final String s, final int n) {
        throw this.unused();
    }
    
    public void updateLong(final int n, final long n2) {
        throw this.unused();
    }
    
    public void updateLong(final String s, final long n) {
        throw this.unused();
    }
    
    public void updateNull(final int n) {
        throw this.unused();
    }
    
    public void updateNull(final String s) {
        throw this.unused();
    }
    
    public void updateObject(final int n, final Object o) {
        throw this.unused();
    }
    
    public void updateObject(final int n, final Object o, final int n2) {
        throw this.unused();
    }
    
    public void updateObject(final String s, final Object o) {
        throw this.unused();
    }
    
    public void updateObject(final String s, final Object o, final int n) {
        throw this.unused();
    }
    
    public void updateRef(final int n, final Ref ref) {
        throw this.unused();
    }
    
    public void updateRef(final String s, final Ref ref) {
        throw this.unused();
    }
    
    public void updateRow() {
        throw this.unused();
    }
    
    public void updateShort(final int n, final short n2) {
        throw this.unused();
    }
    
    public void updateShort(final String s, final short n) {
        throw this.unused();
    }
    
    public void updateString(final int n, final String s) {
        throw this.unused();
    }
    
    public void updateString(final String s, final String s2) {
        throw this.unused();
    }
    
    public void updateTime(final int n, final Time time) {
        throw this.unused();
    }
    
    public void updateTime(final String s, final Time time) {
        throw this.unused();
    }
    
    public void updateTimestamp(final int n, final Timestamp timestamp) {
        throw this.unused();
    }
    
    public void updateTimestamp(final String s, final Timestamp timestamp) {
        throw this.unused();
    }
    
    public void refreshRow() {
        throw this.unused();
    }
}
