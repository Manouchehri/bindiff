package org.jfree.data.jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import org.jfree.data.category.DefaultCategoryDataset;

public class JDBCCategoryDataset extends DefaultCategoryDataset {
   private transient Connection connection;
   private boolean transpose;

   public JDBCCategoryDataset(String var1, String var2, String var3, String var4) {
      this.transpose = true;
      Class.forName(var2);
      this.connection = DriverManager.getConnection(var1, var3, var4);
   }

   public JDBCCategoryDataset(Connection var1) {
      this.transpose = true;
      if(var1 == null) {
         throw new NullPointerException("A connection must be supplied.");
      } else {
         this.connection = var1;
      }
   }

   public JDBCCategoryDataset(Connection var1, String var2) {
      this(var1);
      this.executeQuery(var2);
   }

   public boolean getTranspose() {
      return this.transpose;
   }

   public void setTranspose(boolean var1) {
      this.transpose = var1;
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
         if(var6 < 2) {
            throw new SQLException("JDBCCategoryDataset.executeQuery() : insufficient columns returned from the database.");
         } else {
            int var7 = this.getRowCount();

            while(true) {
               --var7;
               if(var7 < 0) {
                  label160:
                  while(true) {
                     if(var4.next()) {
                        String var8 = var4.getString(1);
                        int var9 = 2;

                        while(true) {
                           if(var9 > var6) {
                              continue label160;
                           }

                           String var10 = var5.getColumnName(var9);
                           int var11 = var5.getColumnType(var9);
                           switch(var11) {
                           case -6:
                           case -5:
                           case 2:
                           case 3:
                           case 4:
                           case 5:
                           case 6:
                           case 7:
                           case 8:
                              Number var27 = (Number)var4.getObject(var9);
                              if(this.transpose) {
                                 this.setValue(var27, var10, var8);
                              } else {
                                 this.setValue(var27, var8, var10);
                              }
                              break;
                           case -1:
                           case 1:
                           case 12:
                              String var26 = (String)var4.getObject(var9);

                              try {
                                 Double var28 = Double.valueOf(var26);
                                 if(this.transpose) {
                                    this.setValue(var28, var10, var8);
                                 } else {
                                    this.setValue(var28, var8, var10);
                                 }
                              } catch (NumberFormatException var24) {
                                 ;
                              }
                              break;
                           case 91:
                           case 92:
                           case 93:
                              Date var12 = (Date)var4.getObject(var9);
                              Long var13 = new Long(var12.getTime());
                              if(this.transpose) {
                                 this.setValue(var13, var10, var8);
                              } else {
                                 this.setValue(var13, var8, var10);
                              }
                           }

                           ++var9;
                        }
                     }

                     this.fireDatasetChanged();
                     return;
                  }
               }

               this.removeRow(var7);
            }
         }
      } finally {
         if(var4 != null) {
            try {
               var4.close();
            } catch (Exception var23) {
               ;
            }
         }

         if(var3 != null) {
            try {
               var3.close();
            } catch (Exception var22) {
               ;
            }
         }

      }
   }
}
