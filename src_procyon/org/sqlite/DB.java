package org.sqlite;

import java.util.*;
import java.sql.*;

abstract class DB implements Codes
{
    Conn conn;
    long begin;
    long commit;
    private final Map stmts;
    
    DB() {
        this.conn = null;
        this.begin = 0L;
        this.commit = 0L;
        this.stmts = new HashMap();
    }
    
    abstract void interrupt();
    
    abstract void busy_timeout(final int p0);
    
    abstract String errmsg();
    
    abstract String libversion();
    
    abstract int changes();
    
    abstract int shared_cache(final boolean p0);
    
    abstract int enable_load_extension(final boolean p0);
    
    final synchronized void exec(final String s) {
        long prepare = 0L;
        try {
            prepare = this.prepare(s);
            switch (this.step(prepare)) {
                case 101: {
                    this.ensureAutoCommit();
                }
                case 100: {}
                default: {
                    this.throwex();
                    break;
                }
            }
        }
        finally {
            this.finalize(prepare);
        }
    }
    
    final synchronized void open(final Conn conn, final String s, final int n) {
        this.conn = conn;
        this._open(s, n);
    }
    
    final synchronized void close() {
        synchronized (this.stmts) {
            final Iterator<Map.Entry<K, Stmt>> iterator = this.stmts.entrySet().iterator();
            while (iterator.hasNext()) {
                final Map.Entry<K, Stmt> entry = iterator.next();
                final Stmt stmt = entry.getValue();
                this.finalize((long)entry.getKey());
                if (stmt != null) {
                    stmt.pointer = 0L;
                }
                iterator.remove();
            }
        }
        this.free_functions();
        if (this.begin != 0L) {
            this.finalize(this.begin);
            this.begin = 0L;
        }
        if (this.commit != 0L) {
            this.finalize(this.commit);
            this.commit = 0L;
        }
        this._close();
    }
    
    final synchronized void prepare(final Stmt stmt) {
        if (stmt.pointer != 0L) {
            this.finalize(stmt);
        }
        stmt.pointer = this.prepare(stmt.sql);
        this.stmts.put(new Long(stmt.pointer), stmt);
    }
    
    final synchronized int finalize(final Stmt stmt) {
        if (stmt.pointer == 0L) {
            return 0;
        }
        int finalize = 1;
        try {
            finalize = this.finalize(stmt.pointer);
        }
        finally {
            this.stmts.remove(new Long(stmt.pointer));
            stmt.pointer = 0L;
        }
        return finalize;
    }
    
    protected abstract void _open(final String p0, final int p1);
    
    protected abstract void _close();
    
    protected abstract int _exec(final String p0);
    
    protected abstract long prepare(final String p0);
    
    protected abstract int finalize(final long p0);
    
    protected abstract int step(final long p0);
    
    protected abstract int reset(final long p0);
    
    abstract int clear_bindings(final long p0);
    
    abstract int bind_parameter_count(final long p0);
    
    abstract int column_count(final long p0);
    
    abstract int column_type(final long p0, final int p1);
    
    abstract String column_decltype(final long p0, final int p1);
    
    abstract String column_table_name(final long p0, final int p1);
    
    abstract String column_name(final long p0, final int p1);
    
    abstract String column_text(final long p0, final int p1);
    
    abstract byte[] column_blob(final long p0, final int p1);
    
    abstract double column_double(final long p0, final int p1);
    
    abstract long column_long(final long p0, final int p1);
    
    abstract int column_int(final long p0, final int p1);
    
    abstract int bind_null(final long p0, final int p1);
    
    abstract int bind_int(final long p0, final int p1, final int p2);
    
    abstract int bind_long(final long p0, final int p1, final long p2);
    
    abstract int bind_double(final long p0, final int p1, final double p2);
    
    abstract int bind_text(final long p0, final int p1, final String p2);
    
    abstract int bind_blob(final long p0, final int p1, final byte[] p2);
    
    abstract void result_null(final long p0);
    
    abstract void result_text(final long p0, final String p1);
    
    abstract void result_blob(final long p0, final byte[] p1);
    
    abstract void result_double(final long p0, final double p1);
    
    abstract void result_long(final long p0, final long p1);
    
    abstract void result_int(final long p0, final int p1);
    
    abstract void result_error(final long p0, final String p1);
    
    abstract int value_bytes(final Function p0, final int p1);
    
    abstract String value_text(final Function p0, final int p1);
    
    abstract byte[] value_blob(final Function p0, final int p1);
    
    abstract double value_double(final Function p0, final int p1);
    
    abstract long value_long(final Function p0, final int p1);
    
    abstract int value_int(final Function p0, final int p1);
    
    abstract int value_type(final Function p0, final int p1);
    
    abstract int create_function(final String p0, final Function p1);
    
    abstract int destroy_function(final String p0);
    
    abstract void free_functions();
    
    abstract int backup(final String p0, final String p1, final DB$ProgressObserver p2);
    
    abstract int restore(final String p0, final String p1, final DB$ProgressObserver p2);
    
    abstract boolean[][] column_metadata(final long p0);
    
    final synchronized String[] column_names(final long n) {
        final String[] array = new String[this.column_count(n)];
        for (int i = 0; i < array.length; ++i) {
            array[i] = this.column_name(n, i);
        }
        return array;
    }
    
    final synchronized int sqlbind(final long n, int n2, final Object o) {
        ++n2;
        if (o == null) {
            return this.bind_null(n, n2);
        }
        if (o instanceof Integer) {
            return this.bind_int(n, n2, (int)o);
        }
        if (o instanceof Short) {
            return this.bind_int(n, n2, (int)o);
        }
        if (o instanceof Long) {
            return this.bind_long(n, n2, (long)o);
        }
        if (o instanceof Float) {
            return this.bind_double(n, n2, (double)o);
        }
        if (o instanceof Double) {
            return this.bind_double(n, n2, (double)o);
        }
        if (o instanceof String) {
            return this.bind_text(n, n2, (String)o);
        }
        if (o instanceof byte[]) {
            return this.bind_blob(n, n2, (byte[])o);
        }
        throw new SQLException("unexpected param type: " + o.getClass());
    }
    
    final synchronized int[] executeBatch(final long n, final int n2, final Object[] array) {
        if (n2 < 1) {
            throw new SQLException("count (" + n2 + ") < 1");
        }
        final int bind_parameter_count = this.bind_parameter_count(n);
        final int[] array2 = new int[n2];
        try {
            for (int i = 0; i < n2; ++i) {
                this.reset(n);
                for (int j = 0; j < bind_parameter_count; ++j) {
                    if (this.sqlbind(n, j, array[i * bind_parameter_count + j]) != 0) {
                        this.throwex();
                    }
                }
                final int step = this.step(n);
                if (step != 101) {
                    this.reset(n);
                    if (step == 100) {
                        throw new BatchUpdateException("batch entry " + i + ": query returns results", array2);
                    }
                    this.throwex();
                }
                array2[i] = this.changes();
            }
        }
        finally {
            this.ensureAutoCommit();
        }
        this.reset(n);
        return array2;
    }
    
    final synchronized boolean execute(final Stmt stmt, final Object[] array) {
        if (array != null) {
            final int bind_parameter_count = this.bind_parameter_count(stmt.pointer);
            if (bind_parameter_count != array.length) {
                throw new SQLException("assertion failure: param count (" + bind_parameter_count + ") != value count (" + array.length + ")");
            }
            for (int i = 0; i < bind_parameter_count; ++i) {
                if (this.sqlbind(stmt.pointer, i, array[i]) != 0) {
                    this.throwex();
                }
            }
        }
        final int step = this.step(stmt.pointer);
        switch (step) {
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
                throw this.newSQLException(step);
            }
            default: {
                this.finalize(stmt);
                throw this.newSQLException(step);
            }
        }
    }
    
    final synchronized boolean execute(final String s) {
        final int exec = this._exec(s);
        switch (exec) {
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
            default: {
                throw this.newSQLException(exec);
            }
        }
    }
    
    final synchronized int executeUpdate(final Stmt stmt, final Object[] array) {
        if (this.execute(stmt, array)) {
            throw new SQLException("query returns results");
        }
        this.reset(stmt.pointer);
        return this.changes();
    }
    
    final void throwex() {
        throw new SQLException(this.errmsg());
    }
    
    final void throwex(final int n) {
        throw this.newSQLException(n);
    }
    
    final void throwex(final int n, final String s) {
        throw newSQLException(n, s);
    }
    
    static SQLException newSQLException(final int n, final String s) {
        return new SQLException(String.format("%s (%s)", SQLiteErrorCode.getErrorCode(n), s));
    }
    
    private SQLException newSQLException(final int n) {
        return newSQLException(n, this.errmsg());
    }
    
    final void ensureAutoCommit() {
        if (!this.conn.getAutoCommit()) {
            return;
        }
        if (this.begin == 0L) {
            this.begin = this.prepare("begin;");
        }
        if (this.commit == 0L) {
            this.commit = this.prepare("commit;");
        }
        try {
            if (this.step(this.begin) != 101) {
                return;
            }
            if (this.step(this.commit) != 101) {
                this.reset(this.commit);
                this.throwex();
            }
        }
        finally {
            this.reset(this.begin);
            this.reset(this.commit);
        }
    }
}
