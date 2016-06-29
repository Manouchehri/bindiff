package com.google.security.zynamics.zylib.gui.zygraph.layouters;

public enum OrthogonalStyle {
   NORMAL,
   TREE;

   public static OrthogonalStyle parseInt(int var0) {
      if(var0 == NORMAL.ordinal()) {
         return NORMAL;
      } else if(var0 == TREE.ordinal()) {
         return TREE;
      } else {
         throw new IllegalStateException((new StringBuilder(32)).append("Error: Invalid style ").append(var0).toString());
      }
   }
}
