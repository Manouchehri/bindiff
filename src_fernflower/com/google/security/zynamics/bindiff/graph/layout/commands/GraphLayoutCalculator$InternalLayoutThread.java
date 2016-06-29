package com.google.security.zynamics.bindiff.graph.layout.commands;

import com.google.security.zynamics.bindiff.exceptions.GraphLayoutException;
import com.google.security.zynamics.bindiff.graph.BinDiffGraph;
import com.google.security.zynamics.bindiff.graph.CombinedGraph;
import com.google.security.zynamics.bindiff.graph.layout.commands.GraphLayoutCalculator;
import com.google.security.zynamics.bindiff.graph.layout.util.PortConstraints;
import y.f.O;
import y.f.c;

class GraphLayoutCalculator$InternalLayoutThread extends Thread {
   private final BinDiffGraph graph;
   private final c layouter;
   private O graphLayout;
   private GraphLayoutException exception;
   // $FF: synthetic field
   final GraphLayoutCalculator this$0;

   protected GraphLayoutCalculator$InternalLayoutThread(GraphLayoutCalculator var1, BinDiffGraph var2, c var3) {
      this.this$0 = var1;
      this.graphLayout = null;
      this.exception = null;
      this.graph = var2;
      this.layouter = var3;
   }

   protected GraphLayoutException getException() {
      return this.exception;
   }

   protected O getGraphLayout() {
      return this.graphLayout;
   }

   public void run() {
      try {
         if(this.graph instanceof CombinedGraph) {
            PortConstraints.configureConstraints((CombinedGraph)this.graph);
         }

         this.graphLayout = this.graph.calculateLayout(this.layouter);
      } catch (GraphLayoutException var5) {
         this.exception = var5;
      } finally {
         GraphLayoutCalculator.access$000(this.this$0).countDown();
      }

   }
}
