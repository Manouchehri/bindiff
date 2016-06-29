package com.google.security.zynamics.bindiff.enums;

import com.google.security.zynamics.bindiff.enums.EGraphLayout$1;

public enum EGraphLayout {
   HIERARCHICAL,
   ORTHOGONAL,
   CIRCULAR;

   public static EGraphLayout getEnum(int var0) {
      switch(var0) {
      case 0:
         return HIERARCHICAL;
      case 1:
         return ORTHOGONAL;
      case 2:
         return CIRCULAR;
      default:
         throw new IllegalArgumentException("Unknown layout style.");
      }
   }

   public static int getOrdinal(EGraphLayout var0) {
      switch(EGraphLayout$1.$SwitchMap$com$google$security$zynamics$bindiff$enums$EGraphLayout[var0.ordinal()]) {
      case 1:
         return 0;
      case 2:
         return 1;
      case 3:
         return 2;
      default:
         throw new IllegalArgumentException("Unknown layout style.");
      }
   }
}
