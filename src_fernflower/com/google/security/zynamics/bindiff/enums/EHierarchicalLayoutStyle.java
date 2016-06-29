package com.google.security.zynamics.bindiff.enums;

import com.google.security.zynamics.bindiff.enums.EHierarchicalLayoutStyle$1;

public enum EHierarchicalLayoutStyle {
   PENDULUM_MULTILINE,
   PENDULUM_ORTHOGONAL,
   LINEAR_SEGMEMENTS_MULTILINE,
   LINEAR_SEGMENTS_ORTHOGONAL;

   public static EHierarchicalLayoutStyle getEnum(int var0) {
      switch(var0) {
      case 0:
         return PENDULUM_MULTILINE;
      case 1:
         return PENDULUM_ORTHOGONAL;
      case 2:
         return LINEAR_SEGMEMENTS_MULTILINE;
      case 3:
         return LINEAR_SEGMENTS_ORTHOGONAL;
      default:
         throw new IllegalArgumentException("Unknown hierarchical layout style.");
      }
   }

   public static int getOrdinal(EHierarchicalLayoutStyle var0) {
      switch(EHierarchicalLayoutStyle$1.$SwitchMap$com$google$security$zynamics$bindiff$enums$EHierarchicalLayoutStyle[var0.ordinal()]) {
      case 1:
         return 0;
      case 2:
         return 1;
      case 3:
         return 2;
      case 4:
         return 3;
      default:
         throw new IllegalArgumentException("Unknown hierarchical layout style.");
      }
   }
}
