/*
 * Decompiled with CFR 0_115.
 */
package org.sqlite;

import java.sql.SQLException;
import org.sqlite.DB;
import org.sqlite.DB$ProgressObserver;
import org.sqlite.Function;
import org.sqlite.SQLiteJDBCLoader;

final class NativeDB
extends DB {
    long pointer = 0;
    private static boolean isLoaded = false;
    private static boolean loadSucceeded = false;
    private final long udfdatalist = 0;

    NativeDB() {
    }

    static boolean load() {
        if (!isLoaded) {
            loadSucceeded = SQLiteJDBCLoader.initialize();
            isLoaded = true;
            return loadSucceeded;
        }
        if (!loadSucceeded) return false;
        return true;
    }

    @Override
    protected synchronized native void _open(String var1, int var2);

    @Override
    protected synchronized native void _close();

    @Override
    protected synchronized native int _exec(String var1);

    @Override
    synchronized native int shared_cache(boolean var1);

    @Override
    synchronized native int enable_load_extension(boolean var1);

    @Override
    synchronized native void interrupt();

    @Override
    synchronized native void busy_timeout(int var1);

    @Override
    protected synchronized native long prepare(String var1);

    @Override
    synchronized native String errmsg();

    @Override
    synchronized native String libversion();

    @Override
    synchronized native int changes();

    @Override
    protected synchronized native int finalize(long var1);

    @Override
    protected synchronized native int step(long var1);

    @Override
    protected synchronized native int reset(long var1);

    @Override
    synchronized native int clear_bindings(long var1);

    @Override
    synchronized native int bind_parameter_count(long var1);

    @Override
    synchronized native int column_count(long var1);

    @Override
    synchronized native int column_type(long var1, int var3);

    @Override
    synchronized native String column_decltype(long var1, int var3);

    @Override
    synchronized native String column_table_name(long var1, int var3);

    @Override
    synchronized native String column_name(long var1, int var3);

    @Override
    synchronized native String column_text(long var1, int var3);

    @Override
    synchronized native byte[] column_blob(long var1, int var3);

    @Override
    synchronized native double column_double(long var1, int var3);

    @Override
    synchronized native long column_long(long var1, int var3);

    @Override
    synchronized native int column_int(long var1, int var3);

    @Override
    synchronized native int bind_null(long var1, int var3);

    @Override
    synchronized native int bind_int(long var1, int var3, int var4);

    @Override
    synchronized native int bind_long(long var1, int var3, long var4);

    @Override
    synchronized native int bind_double(long var1, int var3, double var4);

    @Override
    synchronized native int bind_text(long var1, int var3, String var4);

    @Override
    synchronized native int bind_blob(long var1, int var3, byte[] var4);

    @Override
    synchronized native void result_null(long var1);

    @Override
    synchronized native void result_text(long var1, String var3);

    @Override
    synchronized native void result_blob(long var1, byte[] var3);

    @Override
    synchronized native void result_double(long var1, double var3);

    @Override
    synchronized native void result_long(long var1, long var3);

    @Override
    synchronized native void result_int(long var1, int var3);

    @Override
    synchronized native void result_error(long var1, String var3);

    @Override
    synchronized native int value_bytes(Function var1, int var2);

    @Override
    synchronized native String value_text(Function var1, int var2);

    @Override
    synchronized native byte[] value_blob(Function var1, int var2);

    @Override
    synchronized native double value_double(Function var1, int var2);

    @Override
    synchronized native long value_long(Function var1, int var2);

    @Override
    synchronized native int value_int(Function var1, int var2);

    @Override
    synchronized native int value_type(Function var1, int var2);

    @Override
    synchronized native int create_function(String var1, Function var2);

    @Override
    synchronized native int destroy_function(String var1);

    @Override
    synchronized native void free_functions();

    @Override
    synchronized native int backup(String var1, String var2, DB$ProgressObserver var3);

    @Override
    synchronized native int restore(String var1, String var2, DB$ProgressObserver var3);

    @Override
    synchronized native boolean[][] column_metadata(long var1);

    static void throwex(String string) {
        throw new SQLException(string);
    }
}

