package com.google.security.zynamics.bindiff.database;

import com.google.security.zynamics.bindiff.database.SqliteDatabase;
import com.google.security.zynamics.bindiff.log.Logger;
import com.google.security.zynamics.bindiff.project.Workspace;
import java.io.File;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class WorkspaceDatabase extends SqliteDatabase {
   private static final String STATEMENT_CREATE_METADATA_TABLE = "CREATE TABLE IF NOT EXISTS metadata (version INT NOT NULL)";
   private static final String STATEMENT_CREATE_DIFFS_TABLE = "CREATE TABLE IF NOT EXISTS diffs (matchesDbPath VARCHAR NOT NULL, isfunctiondiff NUMERIC NOT NULL DEFAULT 0)";

   public WorkspaceDatabase(File var1) {
      super(var1);
      this.createTables();
   }

   private void setFormatVersionNumber() {
      PreparedStatement var1 = this.connection.prepareStatement("INSERT INTO metadata (version) VALUES (?)");
      Throwable var2 = null;

      try {
         var1.setInt(1, 1);
         var1.executeUpdate();
      } catch (Throwable var11) {
         var2 = var11;
         throw var11;
      } finally {
         if(var1 != null) {
            if(var2 != null) {
               try {
                  var1.close();
               } catch (Throwable var10) {
                  var2.addSuppressed(var10);
               }
            } else {
               var1.close();
            }
         }

      }

   }

   private void createTables() {
      Statement var1 = this.connection.createStatement();
      Throwable var2 = null;

      try {
         var1.executeUpdate("CREATE TABLE IF NOT EXISTS metadata (version INT NOT NULL)");
         this.setFormatVersionNumber();
      } catch (Throwable var26) {
         var2 = var26;
         throw var26;
      } finally {
         if(var1 != null) {
            if(var2 != null) {
               try {
                  var1.close();
               } catch (Throwable var23) {
                  var2.addSuppressed(var23);
               }
            } else {
               var1.close();
            }
         }

      }

      var1 = this.connection.createStatement();
      var2 = null;

      try {
         var1.executeUpdate("CREATE TABLE IF NOT EXISTS diffs (matchesDbPath VARCHAR NOT NULL, isfunctiondiff NUMERIC NOT NULL DEFAULT 0)");
      } catch (Throwable var25) {
         var2 = var25;
         throw var25;
      } finally {
         if(var1 != null) {
            if(var2 != null) {
               try {
                  var1.close();
               } catch (Throwable var24) {
                  var2.addSuppressed(var24);
               }
            } else {
               var1.close();
            }
         }

      }

   }

   public List loadDiffPaths(boolean var1) {
      ArrayList var2 = new ArrayList();

      try {
         PreparedStatement var3 = this.connection.prepareStatement("SELECT matchesDbPath FROM diffs WHERE isfunctiondiff = ?");
         Throwable var4 = null;

         try {
            var3.setBoolean(1, var1);
            ResultSet var5 = var3.executeQuery();

            while(var5.next()) {
               var2.add(var5.getString("matchesDbPath"));
            }
         } catch (Throwable var14) {
            var4 = var14;
            throw var14;
         } finally {
            if(var3 != null) {
               if(var4 != null) {
                  try {
                     var3.close();
                  } catch (Throwable var13) {
                     var4.addSuppressed(var13);
                  }
               } else {
                  var3.close();
               }
            }

         }

         return var2;
      } catch (SQLException var16) {
         Logger.logException(var16, var16.getMessage());
         if(var1) {
            throw new SQLException("Failed to load workspace: Couldn\'t load function diff paths.", var16);
         } else {
            throw new SQLException("Failed to load workspace: Couldn\'t load diff paths.", var16);
         }
      }
   }

   public void saveWorkspace(Workspace var1) {
      // $FF: Couldn't be decompiled
   }
}
