package com.google.security.zynamics.zylib.gui.zygraph;

public enum EdgeHidingMode {
   HIDE_NEVER,
   HIDE_ALWAYS,
   HIDE_ON_THRESHOLD;

   public static EdgeHidingMode parseInt(int var0) {
      if(var0 == HIDE_NEVER.ordinal()) {
         return HIDE_NEVER;
      } else if(var0 == HIDE_ALWAYS.ordinal()) {
         return HIDE_ALWAYS;
      } else if(var0 == HIDE_ON_THRESHOLD.ordinal()) {
         return HIDE_ON_THRESHOLD;
      } else {
         throw new IllegalStateException("Error: Invalid edge hiding mode");
      }
   }
}
