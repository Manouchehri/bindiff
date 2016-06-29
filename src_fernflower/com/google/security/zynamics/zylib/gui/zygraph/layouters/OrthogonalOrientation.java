package com.google.security.zynamics.zylib.gui.zygraph.layouters;

public enum OrthogonalOrientation {
   VERTICAL,
   HORIZONTAL;

   public static OrthogonalOrientation parseInt(int var0) {
      if(var0 == VERTICAL.ordinal()) {
         return VERTICAL;
      } else if(var0 == HORIZONTAL.ordinal()) {
         return HORIZONTAL;
      } else {
         throw new IllegalStateException("Internal Error: Unknown orientation");
      }
   }
}
