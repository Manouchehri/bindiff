package com.google.security.zynamics.bindiff.exceptions;

public class DifferException extends Exception {
   public DifferException(Exception var1, String var2) {
      super(var2, var1);
   }

   public DifferException(String var1) {
      super(var1);
   }
}
