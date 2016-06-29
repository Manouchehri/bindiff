/*
 * Decompiled with CFR 0_115.
 */
package org.sqlite;

import java.sql.SQLException;
import org.ibex.nestedvm.Runtime;
import org.ibex.nestedvm.Runtime$CallException;
import org.ibex.nestedvm.Runtime$CallJavaCB;
import org.ibex.nestedvm.Runtime$FaultException;
import org.ibex.nestedvm.Runtime$ReadFaultException;
import org.sqlite.DB;
import org.sqlite.DB$ProgressObserver;
import org.sqlite.Function;
import org.sqlite.Function$Aggregate;
import org.sqlite.NestedDB$CausedSQLException;
import org.sqlite.SQLiteErrorCode;

final class NestedDB
extends DB
implements Runtime$CallJavaCB {
    int handle = 0;
    private Runtime rt = null;
    private Function[] functions = null;
    private String[] funcNames = null;
    private final int[] p0 = new int[0];
    private final int[] p1 = new int[]{0};
    private final int[] p2 = new int[]{0, 0};
    private final int[] p3 = new int[]{0, 0, 0};
    private final int[] p4 = new int[]{0, 0, 0, 0};
    private final int[] p5 = new int[]{0, 0, 0, 0, 0};

    NestedDB() {
    }

    @Override
    protected synchronized void _open(String string, int n2) {
        char c2;
        if (this.handle != 0) {
            throw new SQLException("DB already open");
        }
        if (string.length() > 2) {
            c2 = Character.toLowerCase(string.charAt(0));
            if (string.charAt(1) == ':' && c2 >= 'a' && c2 <= 'z') {
                string = string.substring(2);
                string = string.replace('\\', '/');
                string = "/" + c2 + ":" + string;
            }
        }
        try {
            this.rt = (Runtime)Class.forName("org.sqlite.SQLite").newInstance();
            this.rt.start();
        }
        catch (Exception var3_4) {
            throw new NestedDB$CausedSQLException(var3_4);
        }
        this.rt.setCallJavaCB(this);
        c2 = this.rt.xmalloc(4);
        int n3 = this.rt.strdup(string);
        if (this.call("sqlite3_open_v2", n3, c2, n2, 0) != 0) {
            this.throwex();
        }
        this.handle = this.deref(c2);
        this.rt.free(n3);
        this.rt.free(c2);
    }

    @Override
    public int call(int n2, int n3, int n4, int n5) {
        this.xUDF(n2, n3, n4, n5);
        return 0;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    protected synchronized void _close() {
        if (this.handle == 0) {
            return;
        }
        try {
            if (this.call("sqlite3_close", this.handle) == 0) return;
            this.throwex();
            return;
        }
        finally {
            this.handle = 0;
            this.rt.stop();
            this.rt = null;
        }
    }

    @Override
    int shared_cache(boolean bl2) {
        return -1;
    }

    @Override
    int enable_load_extension(boolean bl2) {
        return 1;
    }

    @Override
    synchronized void interrupt() {
        this.call("sqlite3_interrupt", this.handle);
    }

    @Override
    synchronized void busy_timeout(int n2) {
        this.call("sqlite3_busy_timeout", this.handle, n2);
    }

    @Override
    protected synchronized long prepare(String string) {
        int n2 = this.rt.xmalloc(4);
        int n3 = this.rt.strdup(string);
        int n4 = this.call("sqlite3_prepare_v2", this.handle, n3, -1, n2, 0);
        this.rt.free(n3);
        if (n4 != 0) {
            this.rt.free(n2);
            this.throwex(n4);
        }
        int n5 = this.deref(n2);
        this.rt.free(n2);
        return n5;
    }

    @Override
    synchronized String errmsg() {
        return this.cstring(this.call("sqlite3_errmsg", this.handle));
    }

    @Override
    synchronized String libversion() {
        return this.cstring(this.call("sqlite3_libversion", this.handle));
    }

    @Override
    synchronized int changes() {
        return this.call("sqlite3_changes", this.handle);
    }

    @Override
    protected synchronized int _exec(String string) {
        if (this.rt == null) {
            throw DB.newSQLException(SQLiteErrorCode.SQLITE_MISUSE.code, "attempt to use the closed conection");
        }
        int n2 = this.rt.xmalloc(4);
        int n3 = this.rt.strdup(string);
        int n4 = this.call("sqlite3_exec", this.handle, n3, 0, 0, n2);
        if (n4 != 0) {
            String string2 = this.cstring(n2);
            this.call("sqlite3_free", this.deref(n2));
            this.rt.free(n2);
            this.throwex(n4, string2);
        }
        this.rt.free(n2);
        return n4;
    }

    @Override
    protected synchronized int finalize(long l2) {
        return this.call("sqlite3_finalize", (int)l2);
    }

    @Override
    protected synchronized int step(long l2) {
        return this.call("sqlite3_step", (int)l2);
    }

    @Override
    protected synchronized int reset(long l2) {
        return this.call("sqlite3_reset", (int)l2);
    }

    @Override
    synchronized int clear_bindings(long l2) {
        return this.call("sqlite3_clear_bindings", (int)l2);
    }

    @Override
    synchronized int bind_parameter_count(long l2) {
        return this.call("sqlite3_bind_parameter_count", (int)l2);
    }

    @Override
    synchronized int column_count(long l2) {
        return this.call("sqlite3_column_count", (int)l2);
    }

    @Override
    synchronized int column_type(long l2, int n2) {
        return this.call("sqlite3_column_type", (int)l2, n2);
    }

    @Override
    synchronized String column_name(long l2, int n2) {
        return this.utfstring(this.call("sqlite3_column_name", (int)l2, n2));
    }

    @Override
    synchronized String column_text(long l2, int n2) {
        return this.utfstring(this.call("sqlite3_column_text", (int)l2, n2));
    }

    @Override
    synchronized byte[] column_blob(long l2, int n2) {
        int n3 = this.call("sqlite3_column_blob", (int)l2, n2);
        if (n3 == 0) {
            return null;
        }
        byte[] arrby = new byte[this.call("sqlite3_column_bytes", (int)l2, n2)];
        this.copyin(n3, arrby, arrby.length);
        return arrby;
    }

    @Override
    synchronized double column_double(long l2, int n2) {
        try {
            return Double.parseDouble(this.column_text(l2, n2));
        }
        catch (NumberFormatException var4_3) {
            return Double.NaN;
        }
    }

    @Override
    synchronized long column_long(long l2, int n2) {
        try {
            return Long.parseLong(this.column_text(l2, n2));
        }
        catch (NumberFormatException var4_3) {
            return 0;
        }
    }

    @Override
    synchronized int column_int(long l2, int n2) {
        return this.call("sqlite3_column_int", (int)l2, n2);
    }

    @Override
    synchronized String column_decltype(long l2, int n2) {
        return this.utfstring(this.call("sqlite3_column_decltype", (int)l2, n2));
    }

    @Override
    synchronized String column_table_name(long l2, int n2) {
        return this.utfstring(this.call("sqlite3_column_table_name", (int)l2, n2));
    }

    @Override
    synchronized int bind_null(long l2, int n2) {
        return this.call("sqlite3_bind_null", (int)l2, n2);
    }

    @Override
    synchronized int bind_int(long l2, int n2, int n3) {
        return this.call("sqlite3_bind_int", (int)l2, n2, n3);
    }

    @Override
    synchronized int bind_long(long l2, int n2, long l3) {
        return this.bind_text(l2, n2, Long.toString(l3));
    }

    @Override
    synchronized int bind_double(long l2, int n2, double d2) {
        return this.bind_text(l2, n2, Double.toString(d2));
    }

    @Override
    synchronized int bind_text(long l2, int n2, String string) {
        if (string != null) return this.call("sqlite3_bind_text", (int)l2, n2, this.rt.strdup(string), -1, this.rt.lookupSymbol("free"));
        return this.bind_null(l2, n2);
    }

    @Override
    synchronized int bind_blob(long l2, int n2, byte[] arrby) {
        if (arrby == null) return this.bind_null(l2, n2);
        if (arrby.length < 1) {
            return this.bind_null(l2, n2);
        }
        int n3 = arrby.length;
        int n4 = this.rt.xmalloc(n3);
        this.copyout(arrby, n4, n3);
        return this.call("sqlite3_bind_blob", (int)l2, n2, n4, n3, this.rt.lookupSymbol("free"));
    }

    @Override
    synchronized void result_null(long l2) {
        this.call("sqlite3_result_null", (int)l2);
    }

    @Override
    synchronized void result_text(long l2, String string) {
        this.call("sqlite3_result_text", (int)l2, this.rt.strdup(string), -1, this.rt.lookupSymbol("free"));
    }

    @Override
    synchronized void result_blob(long l2, byte[] arrby) {
        if (arrby != null && arrby.length != 0) {
            int n2 = this.rt.xmalloc(arrby.length);
            this.copyout(arrby, n2, arrby.length);
            this.call("sqlite3_result_blob", (int)l2, n2, arrby.length, this.rt.lookupSymbol("free"));
            return;
        }
        this.result_null(l2);
    }

    @Override
    synchronized void result_double(long l2, double d2) {
        this.result_text(l2, Double.toString(d2));
    }

    @Override
    synchronized void result_long(long l2, long l3) {
        this.result_text(l2, Long.toString(l3));
    }

    @Override
    synchronized void result_int(long l2, int n2) {
        this.call("sqlite3_result_int", (int)l2, n2);
    }

    @Override
    synchronized void result_error(long l2, String string) {
        int n2 = this.rt.strdup(string);
        this.call("sqlite3_result_error", (int)l2, n2, -1);
        this.rt.free(n2);
    }

    @Override
    synchronized int value_bytes(Function function, int n2) {
        return this.call("sqlite3_value_bytes", this.value(function, n2));
    }

    @Override
    synchronized String value_text(Function function, int n2) {
        return this.utfstring(this.call("sqlite3_value_text", this.value(function, n2)));
    }

    @Override
    synchronized byte[] value_blob(Function function, int n2) {
        int n3 = this.call("sqlite3_value_blob", this.value(function, n2));
        if (n3 == 0) {
            return null;
        }
        byte[] arrby = new byte[this.value_bytes(function, n2)];
        this.copyin(n3, arrby, arrby.length);
        return arrby;
    }

    @Override
    synchronized double value_double(Function function, int n2) {
        return Double.parseDouble(this.value_text(function, n2));
    }

    @Override
    synchronized long value_long(Function function, int n2) {
        return Long.parseLong(this.value_text(function, n2));
    }

    @Override
    synchronized int value_int(Function function, int n2) {
        return this.call("sqlite3_value_int", this.value(function, n2));
    }

    @Override
    synchronized int value_type(Function function, int n2) {
        return this.call("sqlite3_value_type", this.value(function, n2));
    }

    private int value(Function function, int n2) {
        return this.deref((int)function.value + n2 * 4);
    }

    @Override
    synchronized int create_function(String string, Function function) {
        int n2;
        if (this.functions == null) {
            this.functions = new Function[10];
            this.funcNames = new String[10];
        }
        for (n2 = 0; n2 < this.functions.length && this.functions[n2] != null; ++n2) {
        }
        if (n2 == this.functions.length) {
            Function[] arrfunction = new Function[this.functions.length * 2];
            String[] arrstring = new String[this.funcNames.length * 2];
            System.arraycopy(this.functions, 0, arrfunction, 0, this.functions.length);
            System.arraycopy(this.funcNames, 0, arrstring, 0, this.funcNames.length);
            this.functions = arrfunction;
            this.funcNames = arrstring;
        }
        this.functions[n2] = function;
        this.funcNames[n2] = string;
        int n3 = this.rt.strdup(string);
        int n4 = this.call("create_function_helper", this.handle, n3, n2, function instanceof Function$Aggregate ? 1 : 0);
        this.rt.free(n3);
        return n4;
    }

    @Override
    synchronized int destroy_function(String string) {
        int n2;
        if (string == null) {
            return 0;
        }
        for (n2 = 0; n2 < this.funcNames.length && !string.equals(this.funcNames[n2]); ++n2) {
        }
        if (n2 == this.funcNames.length) {
            return 0;
        }
        this.functions[n2] = null;
        this.funcNames[n2] = null;
        int n3 = this.rt.strdup(string);
        int n4 = this.call("create_function_helper", this.handle, n3, -1, 0);
        this.rt.free(n3);
        return n4;
    }

    @Override
    synchronized void free_functions() {
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    synchronized void xUDF(int n2, int n3, int n4, int n5) {
        Function function = null;
        try {
            int n6 = this.call("sqlite3_user_data", n3);
            function = this.functions[n6];
            if (function == null) {
                throw new SQLException("function state inconsistent");
            }
            function.context = n3;
            function.value = n5;
            function.args = n4;
            switch (n2) {
                case 1: {
                    function.xFunc();
                    return;
                }
                case 2: {
                    ((Function$Aggregate)function).xStep();
                    return;
                }
                case 3: {
                    ((Function$Aggregate)function).xFinal();
                }
            }
            return;
        }
        catch (SQLException var6_7) {
            try {
                String string = var6_7.toString();
                if (string == null) {
                    string = "unknown error";
                }
                int n7 = this.rt.strdup(string);
                this.call("sqlite3_result_error", n3, n7, -1);
                this.rt.free(n7);
                return;
            }
            catch (SQLException var7_9) {
                var7_9.printStackTrace();
                return;
            }
        }
        finally {
            if (function != null) {
                function.context = 0;
                function.value = 0;
                function.args = 0;
            }
        }
    }

    @Override
    synchronized boolean[][] column_metadata(long l2) {
        int n2 = this.call("sqlite3_column_count", (int)l2);
        boolean[][] arrbl = new boolean[n2][3];
        int n3 = this.rt.xmalloc(12);
        int n4 = 0;
        do {
            if (n4 >= n2) {
                this.rt.free(n3);
                return arrbl;
            }
            this.call("column_metadata_helper", this.handle, (int)l2, n4, n3);
            arrbl[n4][0] = this.deref(n3) == 1;
            arrbl[n4][1] = this.deref(n3 + 4) == 1;
            arrbl[n4][2] = this.deref(n3 + 8) == 1;
            ++n4;
        } while (true);
    }

    @Override
    int backup(String string, String string2, DB$ProgressObserver dB$ProgressObserver) {
        throw new SQLException("backup command is not supported in pure-java mode");
    }

    @Override
    int restore(String string, String string2, DB$ProgressObserver dB$ProgressObserver) {
        throw new SQLException("restore command is not supported in pure-java mode");
    }

    private int call(String string, int n2) {
        this.p1[0] = n2;
        return this.call(string, this.p1);
    }

    private int call(String string, int n2, int n3) {
        this.p2[0] = n2;
        this.p2[1] = n3;
        return this.call(string, this.p2);
    }

    private int call(String string, int n2, int n3, int n4) {
        this.p3[0] = n2;
        this.p3[1] = n3;
        this.p3[2] = n4;
        return this.call(string, this.p3);
    }

    private int call(String string, int n2, int n3, int n4, int n5) {
        this.p4[0] = n2;
        this.p4[1] = n3;
        this.p4[2] = n4;
        this.p4[3] = n5;
        return this.call(string, this.p4);
    }

    private int call(String string, int n2, int n3, int n4, int n5, int n6) {
        this.p5[0] = n2;
        this.p5[1] = n3;
        this.p5[2] = n4;
        this.p5[3] = n5;
        this.p5[4] = n6;
        return this.call(string, this.p5);
    }

    private int call(String string, int[] arrn) {
        try {
            return this.rt.call(string, arrn);
        }
        catch (Runtime$CallException var3_3) {
            throw new NestedDB$CausedSQLException(var3_3);
        }
    }

    private int deref(int n2) {
        try {
            return this.rt.memRead(n2);
        }
        catch (Runtime$ReadFaultException var2_2) {
            throw new NestedDB$CausedSQLException(var2_2);
        }
    }

    private String utfstring(int n2) {
        try {
            return this.rt.utfstring(n2);
        }
        catch (Runtime$ReadFaultException var2_2) {
            throw new NestedDB$CausedSQLException(var2_2);
        }
    }

    private String cstring(int n2) {
        try {
            return this.rt.cstring(n2);
        }
        catch (Runtime$ReadFaultException var2_2) {
            throw new NestedDB$CausedSQLException(var2_2);
        }
    }

    private void copyin(int n2, byte[] arrby, int n3) {
        try {
            this.rt.copyin(n2, arrby, n3);
            return;
        }
        catch (Runtime$ReadFaultException var4_4) {
            throw new NestedDB$CausedSQLException(var4_4);
        }
    }

    private void copyout(byte[] arrby, int n2, int n3) {
        try {
            this.rt.copyout(arrby, n2, n3);
            return;
        }
        catch (Runtime$FaultException var4_4) {
            throw new NestedDB$CausedSQLException(var4_4);
        }
    }
}

