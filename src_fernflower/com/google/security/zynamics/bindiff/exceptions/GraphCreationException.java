package com.google.security.zynamics.bindiff.exceptions;

public class GraphCreationException extends Exception {
   public GraphCreationException(Exception var1, String var2) {
      super(var2, var1);
   }

   public GraphCreationException(String var1) {
      super(var1);
   }
}
