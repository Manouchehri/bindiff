package com.google.security.zynamics.zylib.disassembly;

import com.google.security.zynamics.zylib.disassembly.GraphType$1;

public enum GraphType {
   CALLGRAPH,
   FLOWGRAPH,
   MIXED_GRAPH;

   public static String parseString(GraphType var0) {
      switch(GraphType$1.$SwitchMap$com$google$security$zynamics$zylib$disassembly$GraphType[var0.ordinal()]) {
      case 1:
         return "Call graph";
      case 2:
         return "Flow graph";
      case 3:
         return "Mixed Graph";
      default:
         return "Unknown";
      }
   }
}
