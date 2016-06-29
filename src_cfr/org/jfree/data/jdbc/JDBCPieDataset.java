/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.data.jdbc;

import java.io.PrintStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import org.jfree.data.general.DefaultPieDataset;

public class JDBCPieDataset
extends DefaultPieDataset {
    private transient Connection connection;

    public JDBCPieDataset(String string, String string2, String string3, String string4) {
        Class.forName(string2);
        this.connection = DriverManager.getConnection(string, string3, string4);
    }

    public JDBCPieDataset(Connection connection) {
        if (connection == null) {
            throw new NullPointerException("A connection must be supplied.");
        }
        this.connection = connection;
    }

    public JDBCPieDataset(Connection connection, String string) {
        this(connection);
        this.executeQuery(string);
    }

    public void executeQuery(String string) {
        this.executeQuery(this.connection, string);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void executeQuery(Connection connection, String string) {
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(string);
            ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
            int n2 = resultSetMetaData.getColumnCount();
            if (n2 != 2) {
                throw new SQLException("Invalid sql generated.  PieDataSet requires 2 columns only");
            }
            int n3 = resultSetMetaData.getColumnType(2);
            double d2 = Double.NaN;
            block15 : while (resultSet.next()) {
                String string2 = resultSet.getString(1);
                switch (n3) {
                    case -5: 
                    case 2: 
                    case 3: 
                    case 4: 
                    case 6: 
                    case 7: 
                    case 8: {
                        d2 = resultSet.getDouble(2);
                        this.setValue((Comparable)((Object)string2), d2);
                        continue block15;
                    }
                    case 91: 
                    case 92: 
                    case 93: {
                        Timestamp timestamp = resultSet.getTimestamp(2);
                        d2 = timestamp.getTime();
                        this.setValue((Comparable)((Object)string2), d2);
                        continue block15;
                    }
                }
                System.err.println("JDBCPieDataset - unknown data type");
            }
            this.fireDatasetChanged();
            return;
        }
        finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                }
                catch (Exception var5_6) {
                    System.err.println("JDBCPieDataset: swallowing exception.");
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                }
                catch (Exception var5_7) {
                    System.err.println("JDBCPieDataset: swallowing exception.");
                }
            }
        }
    }

    public void close() {
        try {
            this.connection.close();
            return;
        }
        catch (Exception var1_1) {
            System.err.println("JdbcXYDataset: swallowing exception.");
        }
    }
}

