package com.google.security.zynamics.bindiff.gui.tabpanels.detachedviewstabpanel;

import com.google.security.zynamics.bindiff.enums.EMatchType;

// $FF: synthetic class
class FunctionDiffViewTabPanel$1 {
   // $FF: synthetic field
   static final int[] $SwitchMap$com$google$security$zynamics$bindiff$enums$EMatchType = new int[EMatchType.values().length];

   static {
      try {
         $SwitchMap$com$google$security$zynamics$bindiff$enums$EMatchType[EMatchType.IDENTICAL.ordinal()] = 1;
      } catch (NoSuchFieldError var3) {
         ;
      }

      try {
         $SwitchMap$com$google$security$zynamics$bindiff$enums$EMatchType[EMatchType.INSTRUCTIONS_CHANGED.ordinal()] = 2;
      } catch (NoSuchFieldError var2) {
         ;
      }

      try {
         $SwitchMap$com$google$security$zynamics$bindiff$enums$EMatchType[EMatchType.STRUCTURAL_CHANGED.ordinal()] = 3;
      } catch (NoSuchFieldError var1) {
         ;
      }

   }
}
