/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.database;

import com.google.common.base.Preconditions;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class SqliteDatabase
implements AutoCloseable {
    protected final Connection connection;

    public SqliteDatabase(File file) {
        Preconditions.checkNotNull(file);
        try {
            Class.forName("org.sqlite.JDBC");
        }
        catch (ClassNotFoundException var2_2) {
            throw new SQLException("JDBC driver for SQLite not found", var2_2);
        }
        String string = String.valueOf(file.getPath());
        this.connection = DriverManager.getConnection(string.length() != 0 ? "jdbc:sqlite:".concat(string) : new String("jdbc:sqlite:"));
    }

    @Override
    public void close() {
        this.connection.close();
    }
}

