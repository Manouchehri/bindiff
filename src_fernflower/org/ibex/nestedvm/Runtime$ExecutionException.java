package org.ibex.nestedvm;

public class Runtime$ExecutionException extends Exception {
   private String message = "(null)";
   private String location = "(unknown)";

   public Runtime$ExecutionException() {
   }

   public Runtime$ExecutionException(String var1) {
      if(var1 != null) {
         this.message = var1;
      }

   }

   void setLocation(String var1) {
      this.location = var1 == null?"(unknown)":var1;
   }

   public final String getMessage() {
      return this.message + " at " + this.location;
   }
}
