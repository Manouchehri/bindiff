package com.google.security.zynamics.zylib.disassembly;

import com.google.security.zynamics.zylib.disassembly.GraphType;

// $FF: synthetic class
class GraphType$1 {
   // $FF: synthetic field
   static final int[] $SwitchMap$com$google$security$zynamics$zylib$disassembly$GraphType = new int[GraphType.values().length];

   static {
      try {
         $SwitchMap$com$google$security$zynamics$zylib$disassembly$GraphType[GraphType.CALLGRAPH.ordinal()] = 1;
      } catch (NoSuchFieldError var3) {
         ;
      }

      try {
         $SwitchMap$com$google$security$zynamics$zylib$disassembly$GraphType[GraphType.FLOWGRAPH.ordinal()] = 2;
      } catch (NoSuchFieldError var2) {
         ;
      }

      try {
         $SwitchMap$com$google$security$zynamics$zylib$disassembly$GraphType[GraphType.MIXED_GRAPH.ordinal()] = 3;
      } catch (NoSuchFieldError var1) {
         ;
      }

   }
}
