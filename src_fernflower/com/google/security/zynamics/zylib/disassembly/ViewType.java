package com.google.security.zynamics.zylib.disassembly;

public enum ViewType {
   Native,
   NonNative;

   public static ViewType parseInt(int var0) {
      if(var0 - 1 == Native.ordinal()) {
         return Native;
      } else if(var0 - 1 == NonNative.ordinal()) {
         return NonNative;
      } else {
         throw new IllegalStateException("Internal Error: Unknown view type");
      }
   }
}
