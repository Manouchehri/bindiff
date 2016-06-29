package org.sqlite;

import java.sql.*;
import org.ibex.nestedvm.*;

final class NestedDB extends DB implements Runtime$CallJavaCB
{
    int handle;
    private Runtime rt;
    private Function[] functions;
    private String[] funcNames;
    private final int[] p0;
    private final int[] p1;
    private final int[] p2;
    private final int[] p3;
    private final int[] p4;
    private final int[] p5;
    
    NestedDB() {
        this.handle = 0;
        this.rt = null;
        this.functions = null;
        this.funcNames = null;
        this.p0 = new int[0];
        this.p1 = new int[] { 0 };
        this.p2 = new int[] { 0, 0 };
        this.p3 = new int[] { 0, 0, 0 };
        this.p4 = new int[] { 0, 0, 0, 0 };
        this.p5 = new int[] { 0, 0, 0, 0, 0 };
    }
    
    protected synchronized void _open(String s, final int n) {
        if (this.handle != 0) {
            throw new SQLException("DB already open");
        }
        if (s.length() > 2) {
            final char lowerCase = Character.toLowerCase(s.charAt(0));
            if (s.charAt(1) == ':' && lowerCase >= 'a' && lowerCase <= 'z') {
                s = s.substring(2);
                s = s.replace('\\', '/');
                s = "/" + lowerCase + ":" + s;
            }
        }
        try {
            (this.rt = (Runtime)Class.forName("org.sqlite.SQLite").newInstance()).start();
        }
        catch (Exception ex) {
            throw new NestedDB$CausedSQLException(ex);
        }
        this.rt.setCallJavaCB(this);
        final int xmalloc = this.rt.xmalloc(4);
        final int strdup = this.rt.strdup(s);
        if (this.call("sqlite3_open_v2", strdup, xmalloc, n, 0) != 0) {
            this.throwex();
        }
        this.handle = this.deref(xmalloc);
        this.rt.free(strdup);
        this.rt.free(xmalloc);
    }
    
    public int call(final int n, final int n2, final int n3, final int n4) {
        this.xUDF(n, n2, n3, n4);
        return 0;
    }
    
    protected synchronized void _close() {
        if (this.handle == 0) {
            return;
        }
        try {
            if (this.call("sqlite3_close", this.handle) != 0) {
                this.throwex();
            }
        }
        finally {
            this.handle = 0;
            this.rt.stop();
            this.rt = null;
        }
    }
    
    int shared_cache(final boolean b) {
        return -1;
    }
    
    int enable_load_extension(final boolean b) {
        return 1;
    }
    
    synchronized void interrupt() {
        this.call("sqlite3_interrupt", this.handle);
    }
    
    synchronized void busy_timeout(final int n) {
        this.call("sqlite3_busy_timeout", this.handle, n);
    }
    
    protected synchronized long prepare(final String s) {
        final int xmalloc = this.rt.xmalloc(4);
        final int strdup = this.rt.strdup(s);
        final int call = this.call("sqlite3_prepare_v2", this.handle, strdup, -1, xmalloc, 0);
        this.rt.free(strdup);
        if (call != 0) {
            this.rt.free(xmalloc);
            this.throwex(call);
        }
        final int deref = this.deref(xmalloc);
        this.rt.free(xmalloc);
        return deref;
    }
    
    synchronized String errmsg() {
        return this.cstring(this.call("sqlite3_errmsg", this.handle));
    }
    
    synchronized String libversion() {
        return this.cstring(this.call("sqlite3_libversion", this.handle));
    }
    
    synchronized int changes() {
        return this.call("sqlite3_changes", this.handle);
    }
    
    protected synchronized int _exec(final String s) {
        if (this.rt == null) {
            throw DB.newSQLException(SQLiteErrorCode.SQLITE_MISUSE.code, "attempt to use the closed conection");
        }
        final int xmalloc = this.rt.xmalloc(4);
        final int call = this.call("sqlite3_exec", this.handle, this.rt.strdup(s), 0, 0, xmalloc);
        if (call != 0) {
            final String cstring = this.cstring(xmalloc);
            this.call("sqlite3_free", this.deref(xmalloc));
            this.rt.free(xmalloc);
            this.throwex(call, cstring);
        }
        this.rt.free(xmalloc);
        return call;
    }
    
    protected synchronized int finalize(final long n) {
        return this.call("sqlite3_finalize", (int)n);
    }
    
    protected synchronized int step(final long n) {
        return this.call("sqlite3_step", (int)n);
    }
    
    protected synchronized int reset(final long n) {
        return this.call("sqlite3_reset", (int)n);
    }
    
    synchronized int clear_bindings(final long n) {
        return this.call("sqlite3_clear_bindings", (int)n);
    }
    
    synchronized int bind_parameter_count(final long n) {
        return this.call("sqlite3_bind_parameter_count", (int)n);
    }
    
    synchronized int column_count(final long n) {
        return this.call("sqlite3_column_count", (int)n);
    }
    
    synchronized int column_type(final long n, final int n2) {
        return this.call("sqlite3_column_type", (int)n, n2);
    }
    
    synchronized String column_name(final long n, final int n2) {
        return this.utfstring(this.call("sqlite3_column_name", (int)n, n2));
    }
    
    synchronized String column_text(final long n, final int n2) {
        return this.utfstring(this.call("sqlite3_column_text", (int)n, n2));
    }
    
    synchronized byte[] column_blob(final long n, final int n2) {
        final int call = this.call("sqlite3_column_blob", (int)n, n2);
        if (call == 0) {
            return null;
        }
        final byte[] array = new byte[this.call("sqlite3_column_bytes", (int)n, n2)];
        this.copyin(call, array, array.length);
        return array;
    }
    
    synchronized double column_double(final long n, final int n2) {
        try {
            return Double.parseDouble(this.column_text(n, n2));
        }
        catch (NumberFormatException ex) {
            return Double.NaN;
        }
    }
    
    synchronized long column_long(final long n, final int n2) {
        try {
            return Long.parseLong(this.column_text(n, n2));
        }
        catch (NumberFormatException ex) {
            return 0L;
        }
    }
    
    synchronized int column_int(final long n, final int n2) {
        return this.call("sqlite3_column_int", (int)n, n2);
    }
    
    synchronized String column_decltype(final long n, final int n2) {
        return this.utfstring(this.call("sqlite3_column_decltype", (int)n, n2));
    }
    
    synchronized String column_table_name(final long n, final int n2) {
        return this.utfstring(this.call("sqlite3_column_table_name", (int)n, n2));
    }
    
    synchronized int bind_null(final long n, final int n2) {
        return this.call("sqlite3_bind_null", (int)n, n2);
    }
    
    synchronized int bind_int(final long n, final int n2, final int n3) {
        return this.call("sqlite3_bind_int", (int)n, n2, n3);
    }
    
    synchronized int bind_long(final long n, final int n2, final long n3) {
        return this.bind_text(n, n2, Long.toString(n3));
    }
    
    synchronized int bind_double(final long n, final int n2, final double n3) {
        return this.bind_text(n, n2, Double.toString(n3));
    }
    
    synchronized int bind_text(final long n, final int n2, final String s) {
        if (s == null) {
            return this.bind_null(n, n2);
        }
        return this.call("sqlite3_bind_text", (int)n, n2, this.rt.strdup(s), -1, this.rt.lookupSymbol("free"));
    }
    
    synchronized int bind_blob(final long n, final int n2, final byte[] array) {
        if (array == null || array.length < 1) {
            return this.bind_null(n, n2);
        }
        final int length = array.length;
        final int xmalloc = this.rt.xmalloc(length);
        this.copyout(array, xmalloc, length);
        return this.call("sqlite3_bind_blob", (int)n, n2, xmalloc, length, this.rt.lookupSymbol("free"));
    }
    
    synchronized void result_null(final long n) {
        this.call("sqlite3_result_null", (int)n);
    }
    
    synchronized void result_text(final long n, final String s) {
        this.call("sqlite3_result_text", (int)n, this.rt.strdup(s), -1, this.rt.lookupSymbol("free"));
    }
    
    synchronized void result_blob(final long n, final byte[] array) {
        if (array == null || array.length == 0) {
            this.result_null(n);
            return;
        }
        final int xmalloc = this.rt.xmalloc(array.length);
        this.copyout(array, xmalloc, array.length);
        this.call("sqlite3_result_blob", (int)n, xmalloc, array.length, this.rt.lookupSymbol("free"));
    }
    
    synchronized void result_double(final long n, final double n2) {
        this.result_text(n, Double.toString(n2));
    }
    
    synchronized void result_long(final long n, final long n2) {
        this.result_text(n, Long.toString(n2));
    }
    
    synchronized void result_int(final long n, final int n2) {
        this.call("sqlite3_result_int", (int)n, n2);
    }
    
    synchronized void result_error(final long n, final String s) {
        final int strdup = this.rt.strdup(s);
        this.call("sqlite3_result_error", (int)n, strdup, -1);
        this.rt.free(strdup);
    }
    
    synchronized int value_bytes(final Function function, final int n) {
        return this.call("sqlite3_value_bytes", this.value(function, n));
    }
    
    synchronized String value_text(final Function function, final int n) {
        return this.utfstring(this.call("sqlite3_value_text", this.value(function, n)));
    }
    
    synchronized byte[] value_blob(final Function function, final int n) {
        final int call = this.call("sqlite3_value_blob", this.value(function, n));
        if (call == 0) {
            return null;
        }
        final byte[] array = new byte[this.value_bytes(function, n)];
        this.copyin(call, array, array.length);
        return array;
    }
    
    synchronized double value_double(final Function function, final int n) {
        return Double.parseDouble(this.value_text(function, n));
    }
    
    synchronized long value_long(final Function function, final int n) {
        return Long.parseLong(this.value_text(function, n));
    }
    
    synchronized int value_int(final Function function, final int n) {
        return this.call("sqlite3_value_int", this.value(function, n));
    }
    
    synchronized int value_type(final Function function, final int n) {
        return this.call("sqlite3_value_type", this.value(function, n));
    }
    
    private int value(final Function function, final int n) {
        return this.deref((int)function.value + n * 4);
    }
    
    synchronized int create_function(final String s, final Function function) {
        if (this.functions == null) {
            this.functions = new Function[10];
            this.funcNames = new String[10];
        }
        int n;
        for (n = 0; n < this.functions.length && this.functions[n] != null; ++n) {}
        if (n == this.functions.length) {
            final Function[] functions = new Function[this.functions.length * 2];
            final String[] funcNames = new String[this.funcNames.length * 2];
            System.arraycopy(this.functions, 0, functions, 0, this.functions.length);
            System.arraycopy(this.funcNames, 0, funcNames, 0, this.funcNames.length);
            this.functions = functions;
            this.funcNames = funcNames;
        }
        this.functions[n] = function;
        this.funcNames[n] = s;
        final int strdup = this.rt.strdup(s);
        final int call = this.call("create_function_helper", this.handle, strdup, n, (function instanceof Function$Aggregate) ? 1 : 0);
        this.rt.free(strdup);
        return call;
    }
    
    synchronized int destroy_function(final String s) {
        if (s == null) {
            return 0;
        }
        int n;
        for (n = 0; n < this.funcNames.length && !s.equals(this.funcNames[n]); ++n) {}
        if (n == this.funcNames.length) {
            return 0;
        }
        this.functions[n] = null;
        this.funcNames[n] = null;
        final int strdup = this.rt.strdup(s);
        final int call = this.call("create_function_helper", this.handle, strdup, -1, 0);
        this.rt.free(strdup);
        return call;
    }
    
    synchronized void free_functions() {
    }
    
    synchronized void xUDF(final int n, final int n2, final int args, final int n3) {
        Function function = null;
        try {
            function = this.functions[this.call("sqlite3_user_data", n2)];
            if (function == null) {
                throw new SQLException("function state inconsistent");
            }
            function.context = n2;
            function.value = n3;
            function.args = args;
            switch (n) {
                case 1: {
                    function.xFunc();
                    break;
                }
                case 2: {
                    ((Function$Aggregate)function).xStep();
                    break;
                }
                case 3: {
                    ((Function$Aggregate)function).xFinal();
                    break;
                }
            }
        }
        catch (SQLException ex) {
            try {
                String string = ex.toString();
                if (string == null) {
                    string = "unknown error";
                }
                final int strdup = this.rt.strdup(string);
                this.call("sqlite3_result_error", n2, strdup, -1);
                this.rt.free(strdup);
            }
            catch (SQLException ex2) {
                ex2.printStackTrace();
            }
        }
        finally {
            if (function != null) {
                function.context = 0L;
                function.value = 0L;
                function.args = 0;
            }
        }
    }
    
    synchronized boolean[][] column_metadata(final long n) {
        final int call = this.call("sqlite3_column_count", (int)n);
        final boolean[][] array = new boolean[call][3];
        final int xmalloc = this.rt.xmalloc(12);
        for (int i = 0; i < call; ++i) {
            this.call("column_metadata_helper", this.handle, (int)n, i, xmalloc);
            array[i][0] = (this.deref(xmalloc) == 1);
            array[i][1] = (this.deref(xmalloc + 4) == 1);
            array[i][2] = (this.deref(xmalloc + 8) == 1);
        }
        this.rt.free(xmalloc);
        return array;
    }
    
    int backup(final String s, final String s2, final DB$ProgressObserver db$ProgressObserver) {
        throw new SQLException("backup command is not supported in pure-java mode");
    }
    
    int restore(final String s, final String s2, final DB$ProgressObserver db$ProgressObserver) {
        throw new SQLException("restore command is not supported in pure-java mode");
    }
    
    private int call(final String s, final int n) {
        this.p1[0] = n;
        return this.call(s, this.p1);
    }
    
    private int call(final String s, final int n, final int n2) {
        this.p2[0] = n;
        this.p2[1] = n2;
        return this.call(s, this.p2);
    }
    
    private int call(final String s, final int n, final int n2, final int n3) {
        this.p3[0] = n;
        this.p3[1] = n2;
        this.p3[2] = n3;
        return this.call(s, this.p3);
    }
    
    private int call(final String s, final int n, final int n2, final int n3, final int n4) {
        this.p4[0] = n;
        this.p4[1] = n2;
        this.p4[2] = n3;
        this.p4[3] = n4;
        return this.call(s, this.p4);
    }
    
    private int call(final String s, final int n, final int n2, final int n3, final int n4, final int n5) {
        this.p5[0] = n;
        this.p5[1] = n2;
        this.p5[2] = n3;
        this.p5[3] = n4;
        this.p5[4] = n5;
        return this.call(s, this.p5);
    }
    
    private int call(final String s, final int[] array) {
        try {
            return this.rt.call(s, array);
        }
        catch (Runtime$CallException ex) {
            throw new NestedDB$CausedSQLException(ex);
        }
    }
    
    private int deref(final int n) {
        try {
            return this.rt.memRead(n);
        }
        catch (Runtime$ReadFaultException ex) {
            throw new NestedDB$CausedSQLException(ex);
        }
    }
    
    private String utfstring(final int n) {
        try {
            return this.rt.utfstring(n);
        }
        catch (Runtime$ReadFaultException ex) {
            throw new NestedDB$CausedSQLException(ex);
        }
    }
    
    private String cstring(final int n) {
        try {
            return this.rt.cstring(n);
        }
        catch (Runtime$ReadFaultException ex) {
            throw new NestedDB$CausedSQLException(ex);
        }
    }
    
    private void copyin(final int n, final byte[] array, final int n2) {
        try {
            this.rt.copyin(n, array, n2);
        }
        catch (Runtime$ReadFaultException ex) {
            throw new NestedDB$CausedSQLException(ex);
        }
    }
    
    private void copyout(final byte[] array, final int n, final int n2) {
        try {
            this.rt.copyout(array, n, n2);
        }
        catch (Runtime$FaultException ex) {
            throw new NestedDB$CausedSQLException(ex);
        }
    }
}
