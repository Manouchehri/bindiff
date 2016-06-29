package org.sqlite;

import java.sql.*;

public abstract class Function
{
    private Conn conn;
    private DB db;
    long context;
    long value;
    int args;
    
    public Function() {
        this.context = 0L;
        this.value = 0L;
        this.args = 0;
    }
    
    public static final void create(final Connection connection, final String s, final Function function) {
        if (connection == null || !(connection instanceof Conn)) {
            throw new SQLException("connection must be to an SQLite db");
        }
        if (connection.isClosed()) {
            throw new SQLException("connection closed");
        }
        function.conn = (Conn)connection;
        function.db = function.conn.db();
        if (s == null || s.length() > 255) {
            throw new SQLException("invalid function name: '" + s + "'");
        }
        if (function.db.create_function(s, function) != 0) {
            throw new SQLException("error creating function");
        }
    }
    
    public static final void destroy(final Connection connection, final String s) {
        if (connection == null || !(connection instanceof Conn)) {
            throw new SQLException("connection must be to an SQLite db");
        }
        ((Conn)connection).db().destroy_function(s);
    }
    
    protected abstract void xFunc();
    
    protected final synchronized int args() {
        this.checkContext();
        return this.args;
    }
    
    protected final synchronized void result(final byte[] array) {
        this.checkContext();
        this.db.result_blob(this.context, array);
    }
    
    protected final synchronized void result(final double n) {
        this.checkContext();
        this.db.result_double(this.context, n);
    }
    
    protected final synchronized void result(final int n) {
        this.checkContext();
        this.db.result_int(this.context, n);
    }
    
    protected final synchronized void result(final long n) {
        this.checkContext();
        this.db.result_long(this.context, n);
    }
    
    protected final synchronized void result() {
        this.checkContext();
        this.db.result_null(this.context);
    }
    
    protected final synchronized void result(final String s) {
        this.checkContext();
        this.db.result_text(this.context, s);
    }
    
    protected final synchronized void error(final String s) {
        this.checkContext();
        this.db.result_error(this.context, s);
    }
    
    protected final synchronized int value_bytes(final int n) {
        this.checkValue(n);
        return this.db.value_bytes(this, n);
    }
    
    protected final synchronized String value_text(final int n) {
        this.checkValue(n);
        return this.db.value_text(this, n);
    }
    
    protected final synchronized byte[] value_blob(final int n) {
        this.checkValue(n);
        return this.db.value_blob(this, n);
    }
    
    protected final synchronized double value_double(final int n) {
        this.checkValue(n);
        return this.db.value_double(this, n);
    }
    
    protected final synchronized int value_int(final int n) {
        this.checkValue(n);
        return this.db.value_int(this, n);
    }
    
    protected final synchronized long value_long(final int n) {
        this.checkValue(n);
        return this.db.value_long(this, n);
    }
    
    protected final synchronized int value_type(final int n) {
        this.checkValue(n);
        return this.db.value_type(this, n);
    }
    
    private void checkContext() {
        if (this.conn == null || this.conn.db() == null || this.context == 0L) {
            throw new SQLException("no context, not allowed to read value");
        }
    }
    
    private void checkValue(final int n) {
        if (this.conn == null || this.conn.db() == null || this.value == 0L) {
            throw new SQLException("not in value access state");
        }
        if (n >= this.args) {
            throw new SQLException("arg " + n + " out bounds [0," + this.args + ")");
        }
    }
}
