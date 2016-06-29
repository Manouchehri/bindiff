package com.google.security.zynamics.bindiff.graph.helpers;

import com.google.security.zynamics.bindiff.graph.BinDiffGraph;
import com.google.security.zynamics.bindiff.graph.helpers.GraphZoomer;
import java.util.Collection;

final class GraphZoomer$1 implements Runnable {
   // $FF: synthetic field
   final BinDiffGraph val$graph;
   // $FF: synthetic field
   final Collection val$nodes;

   GraphZoomer$1(BinDiffGraph var1, Collection var2) {
      this.val$graph = var1;
      this.val$nodes = var2;
   }

   public void run() {
      GraphZoomer.access$000(this.val$graph, this.val$nodes);
   }
}
