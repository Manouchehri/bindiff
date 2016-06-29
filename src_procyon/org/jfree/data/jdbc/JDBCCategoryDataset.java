package org.jfree.data.jdbc;

import org.jfree.data.category.*;
import java.sql.*;

public class JDBCCategoryDataset extends DefaultCategoryDataset
{
    private transient Connection connection;
    private boolean transpose;
    
    public JDBCCategoryDataset(final String s, final String s2, final String s3, final String s4) {
        this.transpose = true;
        Class.forName(s2);
        this.connection = DriverManager.getConnection(s, s3, s4);
    }
    
    public JDBCCategoryDataset(final Connection connection) {
        this.transpose = true;
        if (connection == null) {
            throw new NullPointerException("A connection must be supplied.");
        }
        this.connection = connection;
    }
    
    public JDBCCategoryDataset(final Connection connection, final String s) {
        this(connection);
        this.executeQuery(s);
    }
    
    public boolean getTranspose() {
        return this.transpose;
    }
    
    public void setTranspose(final boolean transpose) {
        this.transpose = transpose;
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
            final int columnCount = metaData.getColumnCount();
            if (columnCount < 2) {
                throw new SQLException("JDBCCategoryDataset.executeQuery() : insufficient columns returned from the database.");
            }
            int rowCount = this.getRowCount();
            while (--rowCount >= 0) {
                this.removeRow(rowCount);
            }
            while (executeQuery.next()) {
                final String string = executeQuery.getString(1);
                for (int i = 2; i <= columnCount; ++i) {
                    final String columnName = metaData.getColumnName(i);
                    switch (metaData.getColumnType(i)) {
                        case -6:
                        case -5:
                        case 2:
                        case 3:
                        case 4:
                        case 5:
                        case 6:
                        case 7:
                        case 8: {
                            final Number n = (Number)executeQuery.getObject(i);
                            if (this.transpose) {
                                this.setValue(n, columnName, string);
                                break;
                            }
                            this.setValue(n, string, columnName);
                            break;
                        }
                        case 91:
                        case 92:
                        case 93: {
                            final Long n2 = new Long(((Date)executeQuery.getObject(i)).getTime());
                            if (this.transpose) {
                                this.setValue(n2, columnName, string);
                                break;
                            }
                            this.setValue(n2, string, columnName);
                            break;
                        }
                        case -1:
                        case 1:
                        case 12: {
                            final String s2 = (String)executeQuery.getObject(i);
                            try {
                                final Double value = Double.valueOf(s2);
                                if (this.transpose) {
                                    this.setValue(value, columnName, string);
                                }
                                else {
                                    this.setValue(value, string, columnName);
                                }
                            }
                            catch (NumberFormatException ex) {}
                            break;
                        }
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
                catch (Exception ex2) {}
            }
            if (statement != null) {
                try {
                    statement.close();
                }
                catch (Exception ex3) {}
            }
        }
    }
}
