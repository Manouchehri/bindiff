package org.jfree.data.jdbc;

import org.jfree.data.general.*;
import java.sql.*;

public class JDBCPieDataset extends DefaultPieDataset
{
    private transient Connection connection;
    
    public JDBCPieDataset(final String s, final String s2, final String s3, final String s4) {
        Class.forName(s2);
        this.connection = DriverManager.getConnection(s, s3, s4);
    }
    
    public JDBCPieDataset(final Connection connection) {
        if (connection == null) {
            throw new NullPointerException("A connection must be supplied.");
        }
        this.connection = connection;
    }
    
    public JDBCPieDataset(final Connection connection, final String s) {
        this(connection);
        this.executeQuery(s);
    }
    
    public void executeQuery(final String s) {
        this.executeQuery(this.connection, s);
    }
    
    public void executeQuery(final Connection connection, final String s) {
        Statement statement = null;
        ResultSet executeQuery = null;
        try {
            statement = connection.createStatement();
            executeQuery = statement.executeQuery(s);
            final ResultSetMetaData metaData = executeQuery.getMetaData();
            if (metaData.getColumnCount() != 2) {
                throw new SQLException("Invalid sql generated.  PieDataSet requires 2 columns only");
            }
            final int columnType = metaData.getColumnType(2);
            while (executeQuery.next()) {
                final String string = executeQuery.getString(1);
                switch (columnType) {
                    case -5:
                    case 2:
                    case 3:
                    case 4:
                    case 6:
                    case 7:
                    case 8: {
                        this.setValue(string, executeQuery.getDouble(2));
                        continue;
                    }
                    case 91:
                    case 92:
                    case 93: {
                        this.setValue(string, executeQuery.getTimestamp(2).getTime());
                        continue;
                    }
                    default: {
                        System.err.println("JDBCPieDataset - unknown data type");
                        continue;
                    }
                }
            }
            this.fireDatasetChanged();
        }
        finally {
            if (executeQuery != null) {
                try {
                    executeQuery.close();
                }
                catch (Exception ex) {
                    System.err.println("JDBCPieDataset: swallowing exception.");
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                }
                catch (Exception ex2) {
                    System.err.println("JDBCPieDataset: swallowing exception.");
                }
            }
        }
    }
    
    public void close() {
        try {
            this.connection.close();
        }
        catch (Exception ex) {
            System.err.println("JdbcXYDataset: swallowing exception.");
        }
    }
}
