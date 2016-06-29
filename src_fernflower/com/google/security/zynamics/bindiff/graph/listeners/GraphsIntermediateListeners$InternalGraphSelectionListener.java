package com.google.security.zynamics.bindiff.graph.listeners;

import com.google.security.zynamics.bindiff.graph.BinDiffGraph;
import com.google.security.zynamics.bindiff.graph.eventhandlers.GraphLayoutEventHandler;
import com.google.security.zynamics.bindiff.graph.listeners.GraphsIntermediateListeners$1;
import com.google.security.zynamics.zylib.gui.zygraph.IZyGraphSelectionListener;

class GraphsIntermediateListeners$InternalGraphSelectionListener implements IZyGraphSelectionListener {
   private final BinDiffGraph graph;

   private GraphsIntermediateListeners$InternalGraphSelectionListener(BinDiffGraph var1) {
      this.graph = var1;
   }

   public BinDiffGraph getGraph() {
      return this.graph;
   }

   public void selectionChanged() {
      GraphLayoutEventHandler.handleSelectionChangedEvent(this.graph, true);
   }

   // $FF: synthetic method
   GraphsIntermediateListeners$InternalGraphSelectionListener(BinDiffGraph var1, GraphsIntermediateListeners$1 var2) {
      this(var1);
   }
}
