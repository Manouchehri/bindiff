package org.jfree.data.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import org.jfree.data.general.DefaultPieDataset;

public class JDBCPieDataset extends DefaultPieDataset {
   private transient Connection connection;

   public JDBCPieDataset(String var1, String var2, String var3, String var4) {
      Class.forName(var2);
      this.connection = DriverManager.getConnection(var1, var3, var4);
   }

   public JDBCPieDataset(Connection var1) {
      if(var1 == null) {
         throw new NullPointerException("A connection must be supplied.");
      } else {
         this.connection = var1;
      }
   }

   public JDBCPieDataset(Connection var1, String var2) {
      this(var1);
      this.executeQuery(var2);
   }

   public void executeQuery(String var1) {
      this.executeQuery(this.connection, var1);
   }

   public void executeQuery(Connection var1, String var2) {
      Statement var3 = null;
      ResultSet var4 = null;

      try {
         var3 = var1.createStatement();
         var4 = var3.executeQuery(var2);
         ResultSetMetaData var5 = var4.getMetaData();
         int var6 = var5.getColumnCount();
         if(var6 != 2) {
            throw new SQLException("Invalid sql generated.  PieDataSet requires 2 columns only");
         }

         int var7 = var5.getColumnType(2);
         double var8 = Double.NaN;

         while(var4.next()) {
            String var10 = var4.getString(1);
            switch(var7) {
            case -5:
            case 2:
            case 3:
            case 4:
            case 6:
            case 7:
            case 8:
               var8 = var4.getDouble(2);
               this.setValue(var10, var8);
               break;
            case 91:
            case 92:
            case 93:
               Timestamp var11 = var4.getTimestamp(2);
               var8 = (double)var11.getTime();
               this.setValue(var10, var8);
               break;
            default:
               System.err.println("JDBCPieDataset - unknown data type");
            }
         }

         this.fireDatasetChanged();
      } finally {
         if(var4 != null) {
            try {
               var4.close();
            } catch (Exception var20) {
               System.err.println("JDBCPieDataset: swallowing exception.");
            }
         }

         if(var3 != null) {
            try {
               var3.close();
            } catch (Exception var19) {
               System.err.println("JDBCPieDataset: swallowing exception.");
            }
         }

      }

   }

   public void close() {
      try {
         this.connection.close();
      } catch (Exception var2) {
         System.err.println("JdbcXYDataset: swallowing exception.");
      }

   }
}
