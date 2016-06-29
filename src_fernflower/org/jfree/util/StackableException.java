package org.jfree.util;

import java.io.PrintStream;
import java.io.PrintWriter;

public abstract class StackableException extends Exception {
   private Exception parent;

   public StackableException() {
   }

   public StackableException(String var1, Exception var2) {
      super(var1);
      this.parent = var2;
   }

   public StackableException(String var1) {
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

   public void printStackTrace() {
      PrintStream var1 = System.err;
      synchronized(System.err) {
         this.printStackTrace(System.err);
      }
   }
}
