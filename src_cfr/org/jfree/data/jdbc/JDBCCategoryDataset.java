/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.data.jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import org.jfree.data.category.DefaultCategoryDataset;

public class JDBCCategoryDataset
extends DefaultCategoryDataset {
    private transient Connection connection;
    private boolean transpose = true;

    public JDBCCategoryDataset(String string, String string2, String string3, String string4) {
        Class.forName(string2);
        this.connection = DriverManager.getConnection(string, string3, string4);
    }

    public JDBCCategoryDataset(Connection connection) {
        if (connection == null) {
            throw new NullPointerException("A connection must be supplied.");
        }
        this.connection = connection;
    }

    public JDBCCategoryDataset(Connection connection, String string) {
        this(connection);
        this.executeQuery(string);
    }

    public boolean getTranspose() {
        return this.transpose;
    }

    public void setTranspose(boolean bl2) {
        this.transpose = bl2;
    }

    public void executeQuery(String string) {
        this.executeQuery(this.connection, string);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     * Unable to fully structure code
     * Enabled unnecessary exception pruning
     */
    public void executeQuery(Connection var1_1, String var2_2) {
        var3_3 = null;
        var4_4 = null;
        var3_3 = var1_1.createStatement();
        var4_4 = var3_3.executeQuery(var2_2);
        var5_5 = var4_4.getMetaData();
        var6_8 = var5_5.getColumnCount();
        if (var6_8 < 2) {
            throw new SQLException("JDBCCategoryDataset.executeQuery() : insufficient columns returned from the database.");
        }
        var7_9 = this.getRowCount();
        while (--var7_9 >= 0) {
            this.removeRow(var7_9);
        }
lbl14: // 2 sources:
        if (var4_4.next()) ** GOTO lbl32
        ** GOTO lbl30
        finally {
            if (var4_4 != null) {
                try {
                    var4_4.close();
                }
                catch (Exception var5_6) {}
            }
            if (var3_3 != null) {
                try {
                    var3_3.close();
                }
                catch (Exception var5_7) {}
            }
        }
lbl30: // 1 sources:
        this.fireDatasetChanged();
        return;
lbl32: // 1 sources:
        var8_10 = var4_4.getString(1);
        var9_11 = 2;
        do {
            if (var9_11 > var6_8) ** GOTO lbl14
            var10_12 = var5_5.getColumnName(var9_11);
            var11_13 = var5_5.getColumnType(var9_11);
            switch (var11_13) {
                case -6: 
                case -5: 
                case 2: 
                case 3: 
                case 4: 
                case 5: 
                case 6: 
                case 7: 
                case 8: {
                    var12_14 = (Number)var4_4.getObject(var9_11);
                    if (this.transpose) {
                        this.setValue((Number)var12_14, (Comparable)var10_12, (Comparable)var8_10);
                        break;
                    }
                    this.setValue((Number)var12_14, (Comparable)var8_10, (Comparable)var10_12);
                    break;
                }
                case 91: 
                case 92: 
                case 93: {
                    var12_14 = (Date)var4_4.getObject(var9_11);
                    var13_16 = new Long(var12_14.getTime());
                    if (this.transpose) {
                        this.setValue(var13_16, (Comparable)var10_12, (Comparable)var8_10);
                        break;
                    }
                    this.setValue(var13_16, (Comparable)var8_10, (Comparable)var10_12);
                    break;
                }
                case -1: 
                case 1: 
                case 12: {
                    var12_14 = (String)var4_4.getObject(var9_11);
                    try {
                        var13_17 = Double.valueOf((String)var12_14);
                        if (this.transpose) {
                            this.setValue(var13_17, (Comparable)var10_12, (Comparable)var8_10);
                            break;
                        }
                        this.setValue(var13_17, (Comparable)var8_10, (Comparable)var10_12);
                        break;
                    }
                    catch (NumberFormatException var13_18) {
                        break;
                    }
                }
            }
            ++var9_11;
        } while (true);
    }
}

