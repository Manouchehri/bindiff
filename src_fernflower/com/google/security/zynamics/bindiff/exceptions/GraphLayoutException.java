package com.google.security.zynamics.bindiff.exceptions;

public class GraphLayoutException extends Exception {
   public GraphLayoutException(Exception var1, String var2) {
      super(var2, var1);
   }

   public GraphLayoutException(String var1) {
      super(var1);
   }
}
