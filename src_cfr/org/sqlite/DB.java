/*
 * Decompiled with CFR 0_115.
 */
package org.sqlite;

import java.sql.BatchUpdateException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.sqlite.Codes;
import org.sqlite.Conn;
import org.sqlite.DB$ProgressObserver;
import org.sqlite.Function;
import org.sqlite.SQLiteErrorCode;
import org.sqlite.Stmt;

abstract class DB
implements Codes {
    Conn conn = null;
    long begin = 0;
    long commit = 0;
    private final Map stmts = new HashMap();

    DB() {
    }

    abstract void interrupt();

    abstract void busy_timeout(int var1);

    abstract String errmsg();

    abstract String libversion();

    abstract int changes();

    abstract int shared_cache(boolean var1);

    abstract int enable_load_extension(boolean var1);

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    final synchronized void exec(String string) {
        long l2 = 0;
        try {
            l2 = this.prepare(string);
            switch (this.step(l2)) {
                case 101: {
                    this.ensureAutoCommit();
                    return;
                }
                case 100: {
                    return;
                }
            }
            this.throwex();
            return;
        }
        finally {
            this.finalize(l2);
        }
    }

    final synchronized void open(Conn conn, String string, int n2) {
        this.conn = conn;
        this._open(string, n2);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    final synchronized void close() {
        Map map = this.stmts;
        synchronized (map) {
            Iterator<Map.Entry<K, V>> iterator = this.stmts.entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry<K, V> entry = iterator.next();
                Stmt stmt = (Stmt)entry.getValue();
                this.finalize((Long)entry.getKey());
                if (stmt != null) {
                    stmt.pointer = 0;
                }
                iterator.remove();
            }
        }
        this.free_functions();
        if (this.begin != 0) {
            this.finalize(this.begin);
            this.begin = 0;
        }
        if (this.commit != 0) {
            this.finalize(this.commit);
            this.commit = 0;
        }
        this._close();
    }

    final synchronized void prepare(Stmt stmt) {
        if (stmt.pointer != 0) {
            this.finalize(stmt);
        }
        stmt.pointer = this.prepare(stmt.sql);
        this.stmts.put(new Long(stmt.pointer), stmt);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    final synchronized int finalize(Stmt stmt) {
        if (stmt.pointer == 0) {
            return 0;
        }
        int n2 = 1;
        try {
            n2 = this.finalize(stmt.pointer);
            return n2;
        }
        finally {
            this.stmts.remove(new Long(stmt.pointer));
            stmt.pointer = 0;
        }
    }

    protected abstract void _open(String var1, int var2);

    protected abstract void _close();

    protected abstract int _exec(String var1);

    protected abstract long prepare(String var1);

    protected abstract int finalize(long var1);

    protected abstract int step(long var1);

    protected abstract int reset(long var1);

    abstract int clear_bindings(long var1);

    abstract int bind_parameter_count(long var1);

    abstract int column_count(long var1);

    abstract int column_type(long var1, int var3);

    abstract String column_decltype(long var1, int var3);

    abstract String column_table_name(long var1, int var3);

    abstract String column_name(long var1, int var3);

    abstract String column_text(long var1, int var3);

    abstract byte[] column_blob(long var1, int var3);

    abstract double column_double(long var1, int var3);

    abstract long column_long(long var1, int var3);

    abstract int column_int(long var1, int var3);

    abstract int bind_null(long var1, int var3);

    abstract int bind_int(long var1, int var3, int var4);

    abstract int bind_long(long var1, int var3, long var4);

    abstract int bind_double(long var1, int var3, double var4);

    abstract int bind_text(long var1, int var3, String var4);

    abstract int bind_blob(long var1, int var3, byte[] var4);

    abstract void result_null(long var1);

    abstract void result_text(long var1, String var3);

    abstract void result_blob(long var1, byte[] var3);

    abstract void result_double(long var1, double var3);

    abstract void result_long(long var1, long var3);

    abstract void result_int(long var1, int var3);

    abstract void result_error(long var1, String var3);

    abstract int value_bytes(Function var1, int var2);

    abstract String value_text(Function var1, int var2);

    abstract byte[] value_blob(Function var1, int var2);

    abstract double value_double(Function var1, int var2);

    abstract long value_long(Function var1, int var2);

    abstract int value_int(Function var1, int var2);

    abstract int value_type(Function var1, int var2);

    abstract int create_function(String var1, Function var2);

    abstract int destroy_function(String var1);

    abstract void free_functions();

    abstract int backup(String var1, String var2, DB$ProgressObserver var3);

    abstract int restore(String var1, String var2, DB$ProgressObserver var3);

    abstract boolean[][] column_metadata(long var1);

    final synchronized String[] column_names(long l2) {
        String[] arrstring = new String[this.column_count(l2)];
        int n2 = 0;
        while (n2 < arrstring.length) {
            arrstring[n2] = this.column_name(l2, n2);
            ++n2;
        }
        return arrstring;
    }

    final synchronized int sqlbind(long l2, int n2, Object object) {
        ++n2;
        if (object == null) {
            return this.bind_null(l2, n2);
        }
        if (object instanceof Integer) {
            return this.bind_int(l2, n2, (Integer)object);
        }
        if (object instanceof Short) {
            return this.bind_int(l2, n2, ((Short)object).intValue());
        }
        if (object instanceof Long) {
            return this.bind_long(l2, n2, (Long)object);
        }
        if (object instanceof Float) {
            return this.bind_double(l2, n2, ((Float)object).doubleValue());
        }
        if (object instanceof Double) {
            return this.bind_double(l2, n2, (Double)object);
        }
        if (object instanceof String) {
            return this.bind_text(l2, n2, (String)object);
        }
        if (!(object instanceof byte[])) throw new SQLException("unexpected param type: " + object.getClass());
        return this.bind_blob(l2, n2, (byte[])object);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    final synchronized int[] executeBatch(long l2, int n2, Object[] arrobject) {
        int[] arrn;
        if (n2 < 1) {
            throw new SQLException("count (" + n2 + ") < 1");
        }
        int n3 = this.bind_parameter_count(l2);
        arrn = new int[n2];
        try {
            for (int i2 = 0; i2 < n2; ++i2) {
                this.reset(l2);
                for (int i3 = 0; i3 < n3; ++i3) {
                    if (this.sqlbind(l2, i3, arrobject[i2 * n3 + i3]) == 0) continue;
                    this.throwex();
                }
                int n4 = this.step(l2);
                if (n4 != 101) {
                    this.reset(l2);
                    if (n4 == 100) {
                        throw new BatchUpdateException("batch entry " + i2 + ": query returns results", arrn);
                    }
                    this.throwex();
                }
                arrn[i2] = this.changes();
            }
        }
        finally {
            this.ensureAutoCommit();
        }
        this.reset(l2);
        return arrn;
    }

    final synchronized boolean execute(Stmt stmt, Object[] arrobject) {
        int n2;
        if (arrobject != null) {
            n2 = this.bind_parameter_count(stmt.pointer);
            if (n2 != arrobject.length) {
                throw new SQLException("assertion failure: param count (" + n2 + ") != value count (" + arrobject.length + ")");
            }
            for (int i2 = 0; i2 < n2; ++i2) {
                if (this.sqlbind(stmt.pointer, i2, arrobject[i2]) == 0) continue;
                this.throwex();
            }
        }
        n2 = this.step(stmt.pointer);
        switch (n2) {
            case 101: {
                this.reset(stmt.pointer);
                this.ensureAutoCommit();
                return false;
            }
            case 100: {
                return true;
            }
            case 5: 
            case 6: 
            case 21: {
                throw this.newSQLException(n2);
            }
        }
        this.finalize(stmt);
        throw this.newSQLException(n2);
    }

    final synchronized boolean execute(String string) {
        int n2 = this._exec(string);
        switch (n2) {
            case 0: {
                return false;
            }
            case 101: {
                this.ensureAutoCommit();
                return false;
            }
            case 100: {
                return true;
            }
        }
        throw this.newSQLException(n2);
    }

    final synchronized int executeUpdate(Stmt stmt, Object[] arrobject) {
        if (this.execute(stmt, arrobject)) {
            throw new SQLException("query returns results");
        }
        this.reset(stmt.pointer);
        return this.changes();
    }

    final void throwex() {
        throw new SQLException(this.errmsg());
    }

    final void throwex(int n2) {
        throw this.newSQLException(n2);
    }

    final void throwex(int n2, String string) {
        throw DB.newSQLException(n2, string);
    }

    static SQLException newSQLException(int n2, String string) {
        SQLiteErrorCode sQLiteErrorCode = SQLiteErrorCode.getErrorCode(n2);
        return new SQLException(String.format("%s (%s)", new Object[]{sQLiteErrorCode, string}));
    }

    private SQLException newSQLException(int n2) {
        return DB.newSQLException(n2, this.errmsg());
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    final void ensureAutoCommit() {
        if (!this.conn.getAutoCommit()) {
            return;
        }
        if (this.begin == 0) {
            this.begin = this.prepare("begin;");
        }
        if (this.commit == 0) {
            this.commit = this.prepare("commit;");
        }
        try {
            if (this.step(this.begin) != 101) {
                return;
            }
            if (this.step(this.commit) == 101) return;
            this.reset(this.commit);
            this.throwex();
            return;
        }
        finally {
            this.reset(this.begin);
            this.reset(this.commit);
        }
    }
}

