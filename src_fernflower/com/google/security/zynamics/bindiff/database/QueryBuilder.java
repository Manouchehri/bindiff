package com.google.security.zynamics.bindiff.database;

import com.google.common.base.Preconditions;
import java.sql.Connection;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class QueryBuilder {
   protected static final int SQLITE_MAX_QUERY_SIZE = 1000000;
   private final List queries = new ArrayList();
   private final String baseQuery;
   private StringBuffer currentBuffer;

   public QueryBuilder(String var1) {
      // $FF: Couldn't be decompiled
   }

   private void addCurrentQuery() {
      if(this.currentBuffer.charAt(this.currentBuffer.length() - 1) != 41) {
         this.currentBuffer.append(")");
      }

      this.currentBuffer.append(";");
      this.queries.add(this.currentBuffer);
      this.currentBuffer = new StringBuffer();
   }

   public void appendInSet(String var1) {
      Preconditions.checkArgument(var1 != null && !var1.isEmpty(), "Row insert string cannot be null or empty");
      Preconditions.checkArgument(!var1.startsWith("(") && !var1.endsWith(")"), "In set values can not start with a \"(\" and end with a \")\")");
      if(this.currentBuffer.length() + var1.length() >= 999997) {
         this.currentBuffer.append(")");
         this.addCurrentQuery();
      }

      if(this.currentBuffer.length() == 0) {
         this.currentBuffer.append(this.baseQuery);
         this.currentBuffer.append("(");
      } else {
         this.currentBuffer.append(",");
      }

      this.currentBuffer.append(var1);
   }

   public void execute(Connection var1) {
      Preconditions.checkNotNull(var1);
      if(this.currentBuffer.length() != 0) {
         this.addCurrentQuery();
      }

      Iterator var2 = this.queries.iterator();

      while(var2.hasNext()) {
         StringBuffer var3 = (StringBuffer)var2.next();
         Statement var4 = var1.createStatement();
         Throwable var5 = null;

         try {
            var4.executeUpdate(var3.toString());
         } catch (Throwable var14) {
            var5 = var14;
            throw var14;
         } finally {
            if(var4 != null) {
               if(var5 != null) {
                  try {
                     var4.close();
                  } catch (Throwable var13) {
                     var5.addSuppressed(var13);
                  }
               } else {
                  var4.close();
               }
            }

         }
      }

   }
}
