package com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel;

import com.google.security.zynamics.bindiff.enums.EDiffViewMode;
import com.google.security.zynamics.bindiff.enums.EGraphLayout;

// $FF: synthetic class
class ViewTabPanelFunctions$1 {
   // $FF: synthetic field
   static final int[] $SwitchMap$com$google$security$zynamics$bindiff$enums$EDiffViewMode;
   // $FF: synthetic field
   static final int[] $SwitchMap$com$google$security$zynamics$bindiff$enums$EGraphLayout = new int[EGraphLayout.values().length];

   static {
      try {
         $SwitchMap$com$google$security$zynamics$bindiff$enums$EGraphLayout[EGraphLayout.CIRCULAR.ordinal()] = 1;
      } catch (NoSuchFieldError var5) {
         ;
      }

      try {
         $SwitchMap$com$google$security$zynamics$bindiff$enums$EGraphLayout[EGraphLayout.HIERARCHICAL.ordinal()] = 2;
      } catch (NoSuchFieldError var4) {
         ;
      }

      try {
         $SwitchMap$com$google$security$zynamics$bindiff$enums$EGraphLayout[EGraphLayout.ORTHOGONAL.ordinal()] = 3;
      } catch (NoSuchFieldError var3) {
         ;
      }

      $SwitchMap$com$google$security$zynamics$bindiff$enums$EDiffViewMode = new int[EDiffViewMode.values().length];

      try {
         $SwitchMap$com$google$security$zynamics$bindiff$enums$EDiffViewMode[EDiffViewMode.NORMAL_VIEW.ordinal()] = 1;
      } catch (NoSuchFieldError var2) {
         ;
      }

      try {
         $SwitchMap$com$google$security$zynamics$bindiff$enums$EDiffViewMode[EDiffViewMode.COMBINED_VIEW.ordinal()] = 2;
      } catch (NoSuchFieldError var1) {
         ;
      }

   }
}
