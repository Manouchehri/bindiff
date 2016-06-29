package com.google.security.zynamics.zylib.disassembly;

import com.google.security.zynamics.zylib.disassembly.FunctionType;

// $FF: synthetic class
class FunctionType$1 {
   // $FF: synthetic field
   static final int[] $SwitchMap$com$google$security$zynamics$zylib$disassembly$FunctionType = new int[FunctionType.values().length];

   static {
      try {
         $SwitchMap$com$google$security$zynamics$zylib$disassembly$FunctionType[FunctionType.NORMAL.ordinal()] = 1;
      } catch (NoSuchFieldError var7) {
         ;
      }

      try {
         $SwitchMap$com$google$security$zynamics$zylib$disassembly$FunctionType[FunctionType.LIBRARY.ordinal()] = 2;
      } catch (NoSuchFieldError var6) {
         ;
      }

      try {
         $SwitchMap$com$google$security$zynamics$zylib$disassembly$FunctionType[FunctionType.IMPORT.ordinal()] = 3;
      } catch (NoSuchFieldError var5) {
         ;
      }

      try {
         $SwitchMap$com$google$security$zynamics$zylib$disassembly$FunctionType[FunctionType.THUNK.ordinal()] = 4;
      } catch (NoSuchFieldError var4) {
         ;
      }

      try {
         $SwitchMap$com$google$security$zynamics$zylib$disassembly$FunctionType[FunctionType.ADJUSTOR_THUNK.ordinal()] = 5;
      } catch (NoSuchFieldError var3) {
         ;
      }

      try {
         $SwitchMap$com$google$security$zynamics$zylib$disassembly$FunctionType[FunctionType.INVALID.ordinal()] = 6;
      } catch (NoSuchFieldError var2) {
         ;
      }

      try {
         $SwitchMap$com$google$security$zynamics$zylib$disassembly$FunctionType[FunctionType.UNKNOWN.ordinal()] = 7;
      } catch (NoSuchFieldError var1) {
         ;
      }

   }
}
