package org.jfree.util;

import java.io.PrintStream;
import java.io.PrintWriter;

public class StackableRuntimeException extends RuntimeException {
   private Exception parent;

   public StackableRuntimeException() {
   }

   public StackableRuntimeException(String var1, Exception var2) {
      super(var1);
      this.parent = var2;
   }

   public StackableRuntimeException(String var1) {
      super(var1);
   }

   public Exception getParent() {
      return this.parent;
   }

   public void printStackTrace(PrintStream var1) {
      super.printStackTrace(var1);
      if(this.getParent() != null) {
         var1.println("ParentException: ");
         this.getParent().printStackTrace(var1);
      }

   }

   public void printStackTrace(PrintWriter var1) {
      super.printStackTrace(var1);
      if(this.getParent() != null) {
         var1.println("ParentException: ");
         this.getParent().printStackTrace(var1);
      }

   }
}
