package com.google.security.zynamics.bindiff.graph.builders;

import com.google.security.zynamics.bindiff.enums.EJumpType;

// $FF: synthetic class
class ViewFlowGraphBuilder$1 {
   // $FF: synthetic field
   static final int[] $SwitchMap$com$google$security$zynamics$bindiff$enums$EJumpType = new int[EJumpType.values().length];

   static {
      try {
         $SwitchMap$com$google$security$zynamics$bindiff$enums$EJumpType[EJumpType.JUMP_TRUE.ordinal()] = 1;
      } catch (NoSuchFieldError var3) {
         ;
      }

      try {
         $SwitchMap$com$google$security$zynamics$bindiff$enums$EJumpType[EJumpType.JUMP_FALSE.ordinal()] = 2;
      } catch (NoSuchFieldError var2) {
         ;
      }

      try {
         $SwitchMap$com$google$security$zynamics$bindiff$enums$EJumpType[EJumpType.SWITCH.ordinal()] = 3;
      } catch (NoSuchFieldError var1) {
         ;
      }

   }
}
