/*
 * Decompiled with CFR 0_115.
 */
package org.sqlite;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.DriverPropertyInfo;
import java.sql.SQLException;
import java.util.Properties;
import org.sqlite.Conn;
import org.sqlite.SQLiteConfig;
import org.sqlite.SQLiteJDBCLoader;

public class JDBC
implements Driver {
    public static final String PREFIX = "jdbc:sqlite:";

    @Override
    public int getMajorVersion() {
        return SQLiteJDBCLoader.getMajorVersion();
    }

    @Override
    public int getMinorVersion() {
        return SQLiteJDBCLoader.getMinorVersion();
    }

    @Override
    public boolean jdbcCompliant() {
        return false;
    }

    @Override
    public boolean acceptsURL(String string) {
        return JDBC.isValidURL(string);
    }

    public static boolean isValidURL(String string) {
        if (string == null) return false;
        if (!string.toLowerCase().startsWith("jdbc:sqlite:")) return false;
        return true;
    }

    @Override
    public DriverPropertyInfo[] getPropertyInfo(String string, Properties properties) {
        return SQLiteConfig.getDriverPropertyInfo();
    }

    @Override
    public Connection connect(String string, Properties properties) {
        return JDBC.createConnection(string, properties);
    }

    static String extractAddress(String string) {
        if ("jdbc:sqlite:".equalsIgnoreCase(string)) {
            return ":memory:";
        }
        String string2 = string.substring("jdbc:sqlite:".length());
        return string2;
    }

    public static Connection createConnection(String string, Properties properties) {
        if (!JDBC.isValidURL(string)) {
            throw new SQLException("invalid database address: " + string);
        }
        string = string.trim();
        return new Conn(string, JDBC.extractAddress(string), properties);
    }

    static {
        try {
            DriverManager.registerDriver(new JDBC());
            return;
        }
        catch (SQLException var0) {
            var0.printStackTrace();
        }
    }
}

