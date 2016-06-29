package com.google.security.zynamics.bindiff.exceptions;

public class BinExportException extends Exception {
   public BinExportException(Exception var1) {
      super(var1);
   }

   public BinExportException(Exception var1, String var2) {
      super(var2, var1);
   }

   public BinExportException(String var1) {
      super(var1);
   }
}
