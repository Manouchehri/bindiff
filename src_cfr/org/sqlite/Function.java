/*
 * Decompiled with CFR 0_115.
 */
package org.sqlite;

import java.sql.Connection;
import java.sql.SQLException;
import org.sqlite.Conn;
import org.sqlite.DB;

public abstract class Function {
    private Conn conn;
    private DB db;
    long context = 0;
    long value = 0;
    int args = 0;

    public static final void create(Connection connection, String string, Function function) {
        if (connection == null) throw new SQLException("connection must be to an SQLite db");
        if (!(connection instanceof Conn)) {
            throw new SQLException("connection must be to an SQLite db");
        }
        if (connection.isClosed()) {
            throw new SQLException("connection closed");
        }
        function.conn = (Conn)connection;
        function.db = function.conn.db();
        if (string == null) throw new SQLException("invalid function name: '" + string + "'");
        if (string.length() > 255) {
            throw new SQLException("invalid function name: '" + string + "'");
        }
        if (function.db.create_function(string, function) == 0) return;
        throw new SQLException("error creating function");
    }

    public static final void destroy(Connection connection, String string) {
        if (connection == null) throw new SQLException("connection must be to an SQLite db");
        if (!(connection instanceof Conn)) {
            throw new SQLException("connection must be to an SQLite db");
        }
        ((Conn)connection).db().destroy_function(string);
    }

    protected abstract void xFunc();

    protected final synchronized int args() {
        this.checkContext();
        return this.args;
    }

    protected final synchronized void result(byte[] arrby) {
        this.checkContext();
        this.db.result_blob(this.context, arrby);
    }

    protected final synchronized void result(double d2) {
        this.checkContext();
        this.db.result_double(this.context, d2);
    }

    protected final synchronized void result(int n2) {
        this.checkContext();
        this.db.result_int(this.context, n2);
    }

    protected final synchronized void result(long l2) {
        this.checkContext();
        this.db.result_long(this.context, l2);
    }

    protected final synchronized void result() {
        this.checkContext();
        this.db.result_null(this.context);
    }

    protected final synchronized void result(String string) {
        this.checkContext();
        this.db.result_text(this.context, string);
    }

    protected final synchronized void error(String string) {
        this.checkContext();
        this.db.result_error(this.context, string);
    }

    protected final synchronized int value_bytes(int n2) {
        this.checkValue(n2);
        return this.db.value_bytes(this, n2);
    }

    protected final synchronized String value_text(int n2) {
        this.checkValue(n2);
        return this.db.value_text(this, n2);
    }

    protected final synchronized byte[] value_blob(int n2) {
        this.checkValue(n2);
        return this.db.value_blob(this, n2);
    }

    protected final synchronized double value_double(int n2) {
        this.checkValue(n2);
        return this.db.value_double(this, n2);
    }

    protected final synchronized int value_int(int n2) {
        this.checkValue(n2);
        return this.db.value_int(this, n2);
    }

    protected final synchronized long value_long(int n2) {
        this.checkValue(n2);
        return this.db.value_long(this, n2);
    }

    protected final synchronized int value_type(int n2) {
        this.checkValue(n2);
        return this.db.value_type(this, n2);
    }

    private void checkContext() {
        if (this.conn == null) throw new SQLException("no context, not allowed to read value");
        if (this.conn.db() == null) throw new SQLException("no context, not allowed to read value");
        if (this.context != 0) return;
        throw new SQLException("no context, not allowed to read value");
    }

    private void checkValue(int n2) {
        if (this.conn == null) throw new SQLException("not in value access state");
        if (this.conn.db() == null) throw new SQLException("not in value access state");
        if (this.value == 0) {
            throw new SQLException("not in value access state");
        }
        if (n2 < this.args) return;
        throw new SQLException("arg " + n2 + " out bounds [0," + this.args + ")");
    }
}

