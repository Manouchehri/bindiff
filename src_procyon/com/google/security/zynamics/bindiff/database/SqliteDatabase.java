package com.google.security.zynamics.bindiff.database;

import java.io.*;
import com.google.common.base.*;
import java.sql.*;

public abstract class SqliteDatabase implements AutoCloseable
{
    protected final Connection connection;
    
    public SqliteDatabase(final File file) {
        Preconditions.checkNotNull(file);
        try {
            Class.forName("org.sqlite.JDBC");
        }
        catch (ClassNotFoundException ex) {
            throw new SQLException("JDBC driver for SQLite not found", ex);
        }
        final String s = "jdbc:sqlite:";
        final String value = String.valueOf(file.getPath());
        this.connection = DriverManager.getConnection((value.length() != 0) ? s.concat(value) : new String(s));
    }
    
    @Override
    public void close() {
        this.connection.close();
    }
}
