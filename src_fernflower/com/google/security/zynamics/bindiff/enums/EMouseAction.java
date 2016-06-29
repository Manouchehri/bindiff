package com.google.security.zynamics.bindiff.enums;

public enum EMouseAction {
   ZOOM,
   SCROLL;

   public static EMouseAction getEnum(int var0) {
      return var0 == 0?ZOOM:SCROLL;
   }

   public static int getOrdinal(EMouseAction var0) {
      return var0 == ZOOM?0:1;
   }
}
