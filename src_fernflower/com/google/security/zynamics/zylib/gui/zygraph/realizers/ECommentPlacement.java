package com.google.security.zynamics.zylib.gui.zygraph.realizers;

public enum ECommentPlacement {
   ABOVE_LINE,
   BEHIND_LINE;

   public static int getOrdinal(ECommentPlacement var0) {
      return var0 == ABOVE_LINE?0:1;
   }

   public static ECommentPlacement valueOf(int var0) {
      if(var0 == 0) {
         return ABOVE_LINE;
      } else if(var0 == 1) {
         return BEHIND_LINE;
      } else {
         throw new IllegalStateException("Error: Unknown ordinal value.");
      }
   }
}
