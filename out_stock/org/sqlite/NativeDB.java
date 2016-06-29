/*
 * Copyright (c) 2007 David Crawshaw <david@zentus.com>
 * 
 * Permission to use, copy, modify, and/or distribute this software for any
 * purpose with or without fee is hereby granted, provided that the above
 * copyright notice and this permission notice appear in all copies.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS" AND THE AUTHOR DISCLAIMS ALL WARRANTIES
 * WITH REGARD TO THIS SOFTWARE INCLUDING ALL IMPLIED WARRANTIES OF
 * MERCHANTABILITY AND FITNESS. IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR
 * ANY SPECIAL, DIRECT, INDIRECT, OR CONSEQUENTIAL DAMAGES OR ANY DAMAGES
 * WHATSOEVER RESULTING FROM LOSS OF USE, DATA OR PROFITS, WHETHER IN AN
 * ACTION OF CONTRACT, NEGLIGENCE OR OTHER TORTIOUS ACTION, ARISING OUT OF
 * OR IN CONNECTION WITH THE USE OR PERFORMANCE OF THIS SOFTWARE.
 */

package org.sqlite;

import java.sql.SQLException;

/** This class provides a thin JNI layer over the SQLite3 C API. */
final class NativeDB extends DB
{
    /** SQLite connection handle. */
    long                   pointer       = 0;

    private static boolean isLoaded      = false;
    private static boolean loadSucceeded = false;

    static boolean load() {
        if (isLoaded)
            return loadSucceeded == true;

        loadSucceeded = SQLiteJDBCLoader.initialize();
        isLoaded = true;
        return loadSucceeded;
    }

    /** linked list of all instanced UDFDatas */
    private final long udfdatalist = 0;

    // WRAPPER FUNCTIONS ////////////////////////////////////////////

    @Override
    protected native synchronized void _open(String file, int openFlags) throws SQLException;

    @Override
    protected native synchronized void _close() throws SQLException;

    @Override
    protected native synchronized int _exec(String sql) throws SQLException;

    @Override
    native synchronized int shared_cache(boolean enable);

    @Override
    native synchronized int enable_load_extension(boolean enable);

    @Override
    native synchronized void interrupt();

    @Override
    native synchronized void busy_timeout(int ms);

    //native synchronized void exec(String sql) throws SQLException;
    @Override
    protected native synchronized long prepare(String sql) throws SQLException;

    @Override
    native synchronized String errmsg();

    @Override
    native synchronized String libversion();

    @Override
    native synchronized int changes();

    @Override
    protected native synchronized int finalize(long stmt);

    @Override
    protected native synchronized int step(long stmt);

    @Override
    protected native synchronized int reset(long stmt);

    @Override
    native synchronized int clear_bindings(long stmt);

    @Override
    native synchronized int bind_parameter_count(long stmt);

    @Override
    native synchronized int column_count(long stmt);

    @Override
    native synchronized int column_type(long stmt, int col);

    @Override
    native synchronized String column_decltype(long stmt, int col);

    @Override
    native synchronized String column_table_name(long stmt, int col);

    @Override
    native synchronized String column_name(long stmt, int col);

    @Override
    native synchronized String column_text(long stmt, int col);

    @Override
    native synchronized byte[] column_blob(long stmt, int col);

    @Override
    native synchronized double column_double(long stmt, int col);

    @Override
    native synchronized long column_long(long stmt, int col);

    @Override
    native synchronized int column_int(long stmt, int col);

    @Override
    native synchronized int bind_null(long stmt, int pos);

    @Override
    native synchronized int bind_int(long stmt, int pos, int v);

    @Override
    native synchronized int bind_long(long stmt, int pos, long v);

    @Override
    native synchronized int bind_double(long stmt, int pos, double v);

    @Override
    native synchronized int bind_text(long stmt, int pos, String v);

    @Override
    native synchronized int bind_blob(long stmt, int pos, byte[] v);

    @Override
    native synchronized void result_null(long context);

    @Override
    native synchronized void result_text(long context, String val);

    @Override
    native synchronized void result_blob(long context, byte[] val);

    @Override
    native synchronized void result_double(long context, double val);

    @Override
    native synchronized void result_long(long context, long val);

    @Override
    native synchronized void result_int(long context, int val);

    @Override
    native synchronized void result_error(long context, String err);

    @Override
    native synchronized int value_bytes(Function f, int arg);

    @Override
    native synchronized String value_text(Function f, int arg);

    @Override
    native synchronized byte[] value_blob(Function f, int arg);

    @Override
    native synchronized double value_double(Function f, int arg);

    @Override
    native synchronized long value_long(Function f, int arg);

    @Override
    native synchronized int value_int(Function f, int arg);

    @Override
    native synchronized int value_type(Function f, int arg);

    @Override
    native synchronized int create_function(String name, Function func);

    @Override
    native synchronized int destroy_function(String name);

    @Override
    native synchronized void free_functions();

    @Override
    native synchronized int backup(String dbName, String destFileName, ProgressObserver observer) throws SQLException;

    @Override
    native synchronized int restore(String dbName, String sourceFileName, ProgressObserver observer)
            throws SQLException;

    // COMPOUND FUNCTIONS (for optimisation) /////////////////////////

    /**
     * Provides metadata for the columns of a statement. Returns: res[col][0] =
     * true if column constrained NOT NULL res[col][1] = true if column is part
     * of the primary key res[col][2] = true if column is auto-increment
     */
    @Override
    native synchronized boolean[][] column_metadata(long stmt);

    static void throwex(String msg) throws SQLException {
        throw new SQLException(msg);
    }
}
