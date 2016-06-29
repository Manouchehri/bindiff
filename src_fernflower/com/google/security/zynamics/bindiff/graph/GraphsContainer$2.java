package com.google.security.zynamics.bindiff.graph;

import com.google.security.zynamics.bindiff.enums.EDiffViewMode;

// $FF: synthetic class
class GraphsContainer$2 {
   // $FF: synthetic field
   static final int[] $SwitchMap$com$google$security$zynamics$bindiff$enums$EDiffViewMode = new int[EDiffViewMode.values().length];

   static {
      try {
         $SwitchMap$com$google$security$zynamics$bindiff$enums$EDiffViewMode[EDiffViewMode.NORMAL_VIEW.ordinal()] = 1;
      } catch (NoSuchFieldError var3) {
         ;
      }

      try {
         $SwitchMap$com$google$security$zynamics$bindiff$enums$EDiffViewMode[EDiffViewMode.COMBINED_VIEW.ordinal()] = 2;
      } catch (NoSuchFieldError var2) {
         ;
      }

      try {
         $SwitchMap$com$google$security$zynamics$bindiff$enums$EDiffViewMode[EDiffViewMode.TEXT_VIEW.ordinal()] = 3;
      } catch (NoSuchFieldError var1) {
         ;
      }

   }
}
