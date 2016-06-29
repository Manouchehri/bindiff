package com.google.security.zynamics.zylib.disassembly;

public enum ReferenceType {
   CONDITIONAL_TRUE,
   CONDITIONAL_FALSE,
   UNCONDITIONAL,
   SWITCH,
   CALL_DIRECT,
   CALL_INDIRECT,
   CALL_VIRTUAL,
   DATA,
   DATA_STRING;

   public static ReferenceType convertIntToReferenceType(int var0) {
      switch(var0) {
      case 0:
         return CONDITIONAL_TRUE;
      case 1:
         return CONDITIONAL_FALSE;
      case 2:
         return UNCONDITIONAL;
      case 3:
         return SWITCH;
      case 4:
         return CALL_DIRECT;
      case 5:
         return CALL_INDIRECT;
      case 6:
         return CALL_INDIRECT;
      case 7:
         return CALL_VIRTUAL;
      case 8:
         return DATA;
      case 9:
         return DATA_STRING;
      default:
         throw new IllegalArgumentException("Error type is outside of reference type range");
      }
   }

   public static int convertReferenceTypeToInt(ReferenceType var0) {
      return var0.ordinal();
   }

   public static boolean isCodeReference(ReferenceType var0) {
      return !isDataReference(var0);
   }

   public static boolean isDataReference(ReferenceType var0) {
      return var0.compareTo(CALL_VIRTUAL) >= 0;
   }
}
