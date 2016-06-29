package org.sqlite;

import java.util.*;
import java.sql.*;

public class JDBC implements Driver
{
    public static final String PREFIX = "jdbc:sqlite:";
    
    public int getMajorVersion() {
        return SQLiteJDBCLoader.getMajorVersion();
    }
    
    public int getMinorVersion() {
        return SQLiteJDBCLoader.getMinorVersion();
    }
    
    public boolean jdbcCompliant() {
        return false;
    }
    
    public boolean acceptsURL(final String s) {
        return isValidURL(s);
    }
    
    public static boolean isValidURL(final String s) {
        return s != null && s.toLowerCase().startsWith("jdbc:sqlite:");
    }
    
    public DriverPropertyInfo[] getPropertyInfo(final String s, final Properties properties) {
        return SQLiteConfig.getDriverPropertyInfo();
    }
    
    public Connection connect(final String s, final Properties properties) {
        return createConnection(s, properties);
    }
    
    static String extractAddress(final String s) {
        return "jdbc:sqlite:".equalsIgnoreCase(s) ? ":memory:" : s.substring("jdbc:sqlite:".length());
    }
    
    public static Connection createConnection(String trim, final Properties properties) {
        if (!isValidURL(trim)) {
            throw new SQLException("invalid database address: " + trim);
        }
        trim = trim.trim();
        return new Conn(trim, extractAddress(trim), properties);
    }
    
    static {
        try {
            DriverManager.registerDriver(new JDBC());
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
