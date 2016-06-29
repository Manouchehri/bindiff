package com.google.security.zynamics.bindiff.enums;

import com.google.security.zynamics.bindiff.enums.EMatchState$1;

public enum EMatchState {
   MATCHED,
   PRIMARY_UNMATCHED,
   SECONDRAY_UNMATCHED;

   public static EMatchState getMatchState(int var0) {
      switch(var0) {
      case 0:
         return MATCHED;
      case 1:
         return PRIMARY_UNMATCHED;
      case 2:
         return SECONDRAY_UNMATCHED;
      default:
         throw new IllegalArgumentException("Unknown match state.");
      }
   }

   public static int getOrdinal(EMatchState var0) {
      switch(EMatchState$1.$SwitchMap$com$google$security$zynamics$bindiff$enums$EMatchState[var0.ordinal()]) {
      case 1:
         return 2;
      case 2:
         return 1;
      case 3:
         return 0;
      default:
         throw new IllegalArgumentException("Unknown match state type.");
      }
   }

   public String toString() {
      switch(EMatchState$1.$SwitchMap$com$google$security$zynamics$bindiff$enums$EMatchState[this.ordinal()]) {
      case 1:
         return "Secondary Unmatched";
      case 2:
         return "Primary Unmatched";
      case 3:
         return "Matched";
      default:
         throw new IllegalArgumentException("Unknown match state type.");
      }
   }
}
