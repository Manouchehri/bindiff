package com.google.security.zynamics.bindiff.graph.listeners;

import com.google.security.zynamics.bindiff.enums.EGraph;

// $FF: synthetic class
class GraphsIntermediateListeners$1 {
   // $FF: synthetic field
   static final int[] $SwitchMap$com$google$security$zynamics$bindiff$enums$EGraph = new int[EGraph.values().length];

   static {
      try {
         $SwitchMap$com$google$security$zynamics$bindiff$enums$EGraph[EGraph.PRIMARY_GRAPH.ordinal()] = 1;
      } catch (NoSuchFieldError var4) {
         ;
      }

      try {
         $SwitchMap$com$google$security$zynamics$bindiff$enums$EGraph[EGraph.SECONDARY_GRAPH.ordinal()] = 2;
      } catch (NoSuchFieldError var3) {
         ;
      }

      try {
         $SwitchMap$com$google$security$zynamics$bindiff$enums$EGraph[EGraph.COMBINED_GRAPH.ordinal()] = 3;
      } catch (NoSuchFieldError var2) {
         ;
      }

      try {
         $SwitchMap$com$google$security$zynamics$bindiff$enums$EGraph[EGraph.SUPER_GRAPH.ordinal()] = 4;
      } catch (NoSuchFieldError var1) {
         ;
      }

   }
}
