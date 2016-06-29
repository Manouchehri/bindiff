package com.google.security.zynamics.zylib.gui.zygraph.layouters;

public enum CircularStyle {
   COMPACT,
   ISOLATED,
   SINGLE_CIRCLE;

   public static CircularStyle parseInt(int var0) {
      if(var0 == COMPACT.ordinal()) {
         return COMPACT;
      } else if(var0 == ISOLATED.ordinal()) {
         return ISOLATED;
      } else if(var0 == SINGLE_CIRCLE.ordinal()) {
         return SINGLE_CIRCLE;
      } else {
         throw new IllegalStateException("Error: Invalid style");
      }
   }
}
