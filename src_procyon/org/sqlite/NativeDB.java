package org.sqlite;

import java.sql.*;

final class NativeDB extends DB
{
    long pointer;
    private static boolean isLoaded;
    private static boolean loadSucceeded;
    private final long udfdatalist = 0L;
    
    NativeDB() {
        this.pointer = 0L;
    }
    
    static boolean load() {
        if (NativeDB.isLoaded) {
            return NativeDB.loadSucceeded;
        }
        NativeDB.loadSucceeded = SQLiteJDBCLoader.initialize();
        NativeDB.isLoaded = true;
        return NativeDB.loadSucceeded;
    }
    
    protected synchronized native void _open(final String p0, final int p1);
    
    protected synchronized native void _close();
    
    protected synchronized native int _exec(final String p0);
    
    synchronized native int shared_cache(final boolean p0);
    
    synchronized native int enable_load_extension(final boolean p0);
    
    synchronized native void interrupt();
    
    synchronized native void busy_timeout(final int p0);
    
    protected synchronized native long prepare(final String p0);
    
    synchronized native String errmsg();
    
    synchronized native String libversion();
    
    synchronized native int changes();
    
    protected synchronized native int finalize(final long p0);
    
    protected synchronized native int step(final long p0);
    
    protected synchronized native int reset(final long p0);
    
    synchronized native int clear_bindings(final long p0);
    
    synchronized native int bind_parameter_count(final long p0);
    
    synchronized native int column_count(final long p0);
    
    synchronized native int column_type(final long p0, final int p1);
    
    synchronized native String column_decltype(final long p0, final int p1);
    
    synchronized native String column_table_name(final long p0, final int p1);
    
    synchronized native String column_name(final long p0, final int p1);
    
    synchronized native String column_text(final long p0, final int p1);
    
    synchronized native byte[] column_blob(final long p0, final int p1);
    
    synchronized native double column_double(final long p0, final int p1);
    
    synchronized native long column_long(final long p0, final int p1);
    
    synchronized native int column_int(final long p0, final int p1);
    
    synchronized native int bind_null(final long p0, final int p1);
    
    synchronized native int bind_int(final long p0, final int p1, final int p2);
    
    synchronized native int bind_long(final long p0, final int p1, final long p2);
    
    synchronized native int bind_double(final long p0, final int p1, final double p2);
    
    synchronized native int bind_text(final long p0, final int p1, final String p2);
    
    synchronized native int bind_blob(final long p0, final int p1, final byte[] p2);
    
    synchronized native void result_null(final long p0);
    
    synchronized native void result_text(final long p0, final String p1);
    
    synchronized native void result_blob(final long p0, final byte[] p1);
    
    synchronized native void result_double(final long p0, final double p1);
    
    synchronized native void result_long(final long p0, final long p1);
    
    synchronized native void result_int(final long p0, final int p1);
    
    synchronized native void result_error(final long p0, final String p1);
    
    synchronized native int value_bytes(final Function p0, final int p1);
    
    synchronized native String value_text(final Function p0, final int p1);
    
    synchronized native byte[] value_blob(final Function p0, final int p1);
    
    synchronized native double value_double(final Function p0, final int p1);
    
    synchronized native long value_long(final Function p0, final int p1);
    
    synchronized native int value_int(final Function p0, final int p1);
    
    synchronized native int value_type(final Function p0, final int p1);
    
    synchronized native int create_function(final String p0, final Function p1);
    
    synchronized native int destroy_function(final String p0);
    
    synchronized native void free_functions();
    
    synchronized native int backup(final String p0, final String p1, final DB$ProgressObserver p2);
    
    synchronized native int restore(final String p0, final String p1, final DB$ProgressObserver p2);
    
    synchronized native boolean[][] column_metadata(final long p0);
    
    static void throwex(final String s) {
        throw new SQLException(s);
    }
    
    static {
        NativeDB.isLoaded = false;
        NativeDB.loadSucceeded = false;
    }
}
