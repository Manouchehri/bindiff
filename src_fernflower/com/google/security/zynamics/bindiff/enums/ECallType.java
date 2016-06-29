package com.google.security.zynamics.bindiff.enums;

import com.google.security.zynamics.bindiff.enums.ECallType$1;

public enum ECallType {
   NORMAL,
   LIBRARY,
   THUNK,
   IMPORTED,
   UNKNOWN,
   MIXED;

   public static int getOrdinal(ECallType var0) {
      switch(ECallType$1.$SwitchMap$com$google$security$zynamics$bindiff$enums$ECallType[var0.ordinal()]) {
      case 1:
         return 0;
      case 2:
         return 1;
      case 3:
         return 2;
      case 4:
         return 3;
      case 5:
         return 4;
      case 6:
         return 5;
      default:
         throw new IllegalArgumentException("Unknown raw call type.");
      }
   }

   public static ECallType getType(int var0) {
      switch(var0) {
      case 0:
         return NORMAL;
      case 1:
         return LIBRARY;
      case 2:
         return THUNK;
      case 3:
         return IMPORTED;
      case 4:
         return UNKNOWN;
      case 5:
         return MIXED;
      default:
         throw new IllegalArgumentException("Unknown raw call type.");
      }
   }

   public String toString() {
      switch(ECallType$1.$SwitchMap$com$google$security$zynamics$bindiff$enums$ECallType[this.ordinal()]) {
      case 1:
         return "Normal";
      case 2:
         return "Library";
      case 3:
         return "Thunk";
      case 4:
         return "Imported";
      case 5:
         return "Unknown";
      case 6:
         return "Mixed Call Match";
      default:
         throw new IllegalArgumentException("Unknown raw call type.");
      }
   }
}
