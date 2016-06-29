package com.google.security.zynamics.bindiff.enums;

public enum ELayoutOrientation {
   VERTICAL,
   HORIZONTAL;

   public static ELayoutOrientation getEnum(int var0) {
      return var0 == 0?VERTICAL:HORIZONTAL;
   }

   public static int getOrdinal(ELayoutOrientation var0) {
      return var0 == VERTICAL?0:1;
   }
}
