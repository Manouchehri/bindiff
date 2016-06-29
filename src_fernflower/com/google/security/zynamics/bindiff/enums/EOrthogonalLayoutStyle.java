package com.google.security.zynamics.bindiff.enums;

public enum EOrthogonalLayoutStyle {
   NORMAL,
   TREE;

   public static EOrthogonalLayoutStyle getEnum(int var0) {
      return var0 == 0?NORMAL:TREE;
   }

   public static int getOrdinal(EOrthogonalLayoutStyle var0) {
      return var0 == NORMAL?0:1;
   }
}
