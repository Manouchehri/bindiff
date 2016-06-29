package com.google.security.zynamics.bindiff.enums;

import com.google.security.zynamics.bindiff.enums.EFunctionType$1;

public enum EFunctionType {
   NORMAL,
   LIBRARY,
   THUNK,
   IMPORTED,
   UNKNOWN,
   MIXED;

   public static int getOrdinal(EFunctionType var0) {
      switch(EFunctionType$1.$SwitchMap$com$google$security$zynamics$bindiff$enums$EFunctionType[var0.ordinal()]) {
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
         throw new IllegalArgumentException("Unknown raw function type.");
      }
   }

   public static EFunctionType getType(int var0) {
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
         throw new IllegalArgumentException("Unknown raw function type.");
      }
   }

   public static String getTypeChar(EFunctionType var0) {
      switch(EFunctionType$1.$SwitchMap$com$google$security$zynamics$bindiff$enums$EFunctionType[var0.ordinal()]) {
      case 1:
         return "N";
      case 2:
         return "L";
      case 3:
         return "T";
      case 4:
         return "I";
      case 5:
         return "U";
      case 6:
         return "Mixed Function Match";
      default:
         throw new IllegalArgumentException("Unknown raw function type.");
      }
   }

   public String toString() {
      switch(EFunctionType$1.$SwitchMap$com$google$security$zynamics$bindiff$enums$EFunctionType[this.ordinal()]) {
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
         return "Mixed Function Match";
      default:
         throw new IllegalArgumentException("Unknown raw function type.");
      }
   }
}
