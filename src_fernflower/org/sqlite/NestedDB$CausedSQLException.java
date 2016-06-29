package org.sqlite;

import java.io.PrintWriter;
import java.sql.SQLException;

final class NestedDB$CausedSQLException extends SQLException {
   private final Exception cause;

   NestedDB$CausedSQLException(Exception var1) {
      if(var1 == null) {
         throw new RuntimeException("null exception cause");
      } else {
         this.cause = var1;
      }
   }

   public Throwable getCause() {
      return this.cause;
   }

   public void printStackTrace() {
      this.cause.printStackTrace();
   }

   public void printStackTrace(PrintWriter var1) {
      this.cause.printStackTrace(var1);
   }

   public Throwable fillInStackTrace() {
      return this.cause.fillInStackTrace();
   }

   public StackTraceElement[] getStackTrace() {
      return this.cause.getStackTrace();
   }

   public String getMessage() {
      return this.cause.getMessage();
   }
}
