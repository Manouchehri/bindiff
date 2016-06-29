package com.google.security.zynamics.bindiff.graph;

import com.google.security.zynamics.bindiff.enums.EGraph;
import com.google.security.zynamics.bindiff.graph.CombinedGraph;
import com.google.security.zynamics.bindiff.graph.GraphsContainer;
import com.google.security.zynamics.bindiff.graph.SingleGraph;
import com.google.security.zynamics.bindiff.graph.SuperGraph;
import java.util.ArrayList;

class GraphsContainer$1 extends ArrayList {
   // $FF: synthetic field
   final SingleGraph val$primaryGraph;
   // $FF: synthetic field
   final SingleGraph val$secondaryGraph;
   // $FF: synthetic field
   final CombinedGraph val$combinedGraph;
   // $FF: synthetic field
   final SuperGraph val$superGraph;
   // $FF: synthetic field
   final GraphsContainer this$0;

   GraphsContainer$1(GraphsContainer var1, int var2, SingleGraph var3, SingleGraph var4, CombinedGraph var5, SuperGraph var6) {
      super(var2);
      this.this$0 = var1;
      this.val$primaryGraph = var3;
      this.val$secondaryGraph = var4;
      this.val$combinedGraph = var5;
      this.val$superGraph = var6;
      this.add(EGraph.PRIMARY_GRAPH.ordinal(), this.val$primaryGraph);
      this.add(EGraph.SECONDARY_GRAPH.ordinal(), this.val$secondaryGraph);
      this.add(EGraph.COMBINED_GRAPH.ordinal(), this.val$combinedGraph);
      this.add(EGraph.SUPER_GRAPH.ordinal(), this.val$superGraph);
   }
}
