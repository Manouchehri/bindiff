package com.google.security.zynamics.bindiff.enums;

import com.google.security.zynamics.bindiff.enums.ECircularLayoutStyle$1;

public enum ECircularLayoutStyle {
   COMPACT,
   ISOLATED,
   SINGLE_CYCLE;

   public static ECircularLayoutStyle getEnum(int var0) {
      switch(var0) {
      case 0:
         return COMPACT;
      case 1:
         return ISOLATED;
      case 2:
         return SINGLE_CYCLE;
      default:
         throw new IllegalArgumentException("Unknown circular layout style.");
      }
   }

   public static int getOrdinal(ECircularLayoutStyle var0) {
      switch(ECircularLayoutStyle$1.$SwitchMap$com$google$security$zynamics$bindiff$enums$ECircularLayoutStyle[var0.ordinal()]) {
      case 1:
         return 0;
      case 2:
         return 1;
      case 3:
         return 2;
      default:
         throw new IllegalArgumentException("Unknown cicular layout style.");
      }
   }
}
