package com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes.single.flowgraph;

import com.google.security.zynamics.bindiff.enums.EMatchState;

// $FF: synthetic class
class SingleFlowGraphBasicBlockTreeNode$1 {
   // $FF: synthetic field
   static final int[] $SwitchMap$com$google$security$zynamics$bindiff$enums$EMatchState = new int[EMatchState.values().length];

   static {
      try {
         $SwitchMap$com$google$security$zynamics$bindiff$enums$EMatchState[EMatchState.MATCHED.ordinal()] = 1;
      } catch (NoSuchFieldError var3) {
         ;
      }

      try {
         $SwitchMap$com$google$security$zynamics$bindiff$enums$EMatchState[EMatchState.PRIMARY_UNMATCHED.ordinal()] = 2;
      } catch (NoSuchFieldError var2) {
         ;
      }

      try {
         $SwitchMap$com$google$security$zynamics$bindiff$enums$EMatchState[EMatchState.SECONDRAY_UNMATCHED.ordinal()] = 3;
      } catch (NoSuchFieldError var1) {
         ;
      }

   }
}
