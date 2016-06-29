package com.google.security.zynamics.bindiff.graph.listeners;

import com.google.security.zynamics.bindiff.graph.BinDiffGraph;
import com.google.security.zynamics.bindiff.graph.listeners.GraphsIntermediateListeners$1;
import com.google.security.zynamics.zylib.gui.zygraph.IZyGraphVisibilityListener;

class GraphsIntermediateListeners$InternalGraphVisibilityListener implements IZyGraphVisibilityListener {
   private final BinDiffGraph graph;

   private GraphsIntermediateListeners$InternalGraphVisibilityListener(BinDiffGraph var1) {
      this.graph = var1;
   }

   public BinDiffGraph getGraph() {
      return this.graph;
   }

   public void nodeDeleted() {
   }

   public void visibilityChanged() {
   }

   // $FF: synthetic method
   GraphsIntermediateListeners$InternalGraphVisibilityListener(BinDiffGraph var1, GraphsIntermediateListeners$1 var2) {
      this(var1);
   }
}
