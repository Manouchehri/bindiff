package com.google.security.zynamics.bindiff.graph.listeners;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.graph.BinDiffGraph;
import com.google.security.zynamics.bindiff.graph.GraphsContainer;
import com.google.security.zynamics.bindiff.graph.listeners.CombinedGraphMouseListener;
import com.google.security.zynamics.bindiff.graph.listeners.SingleGraphMouseListener;
import com.google.security.zynamics.bindiff.graph.listeners.SingleViewCanvasListener;
import com.google.security.zynamics.bindiff.graph.listeners.SingleViewFocusListener;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.ViewTabPanelFunctions;
import com.google.security.zynamics.bindiff.log.Logger;

public class GraphViewsListenerManager {
   private final GraphsContainer graphs;
   private final SingleViewCanvasListener primaryViewCanvasListener;
   private final SingleViewCanvasListener secondaryViewCanvasListener;
   private final CombinedGraphMouseListener combinedGraphMouseListener;
   private final SingleGraphMouseListener primaryGraphMouseListener;
   private final SingleGraphMouseListener secondaryGraphMouseListener;
   private final SingleViewFocusListener primaryViewFocusListener;
   private final SingleViewFocusListener secondaryViewFocusListener;

   public GraphViewsListenerManager(GraphsContainer var1, ViewTabPanelFunctions var2) {
      Preconditions.checkNotNull(var1);
      Preconditions.checkNotNull(var2);
      this.graphs = var1;
      this.primaryViewCanvasListener = new SingleViewCanvasListener(var2, var1.getPrimaryGraph());
      this.secondaryViewCanvasListener = new SingleViewCanvasListener(var2, var1.getSecondaryGraph());
      this.combinedGraphMouseListener = new CombinedGraphMouseListener(var2, var1.getCombinedGraph());
      this.primaryGraphMouseListener = new SingleGraphMouseListener(var2, var1.getPrimaryGraph());
      this.secondaryGraphMouseListener = new SingleGraphMouseListener(var2, var1.getSecondaryGraph());
      this.primaryViewFocusListener = new SingleViewFocusListener(var2, var1.getPrimaryGraph());
      this.secondaryViewFocusListener = new SingleViewFocusListener(var2, var1.getSecondaryGraph());
   }

   public void addGraphMouseListener(BinDiffGraph var1) {
      if(var1 == this.graphs.getPrimaryGraph()) {
         this.primaryGraphMouseListener.addListener();
      } else if(var1 == this.graphs.getSecondaryGraph()) {
         this.secondaryGraphMouseListener.addListener();
      } else if(var1 == this.graphs.getCombinedGraph()) {
         this.combinedGraphMouseListener.addListener();
      } else {
         Logger.logWarning("Unknown graph! Add graph mouse listener was ignored.", new Object[0]);
      }

   }

   public void addViewCanvasListener(BinDiffGraph var1) {
      if(var1 == this.graphs.getPrimaryGraph()) {
         this.primaryViewCanvasListener.addListener();
      } else if(var1 == this.graphs.getSecondaryGraph()) {
         this.secondaryViewCanvasListener.addListener();
      } else {
         Logger.logWarning("Unknown graph! Add view canvas listener was ignored.", new Object[0]);
      }

   }

   public void addViewFocusListener(BinDiffGraph var1) {
      if(var1 == this.graphs.getPrimaryGraph()) {
         this.primaryViewFocusListener.addListener();
      } else if(var1 == this.graphs.getSecondaryGraph()) {
         this.secondaryViewFocusListener.addListener();
      } else {
         Logger.logWarning("Unknown graph! Add graph view focus listener was ignored.", new Object[0]);
      }

   }

   public void dispose() {
      this.removeViewCanvasListener(this.graphs.getPrimaryGraph());
      this.removeViewCanvasListener(this.graphs.getSecondaryGraph());
      this.removeViewFocusListener(this.graphs.getPrimaryGraph());
      this.removeViewFocusListener(this.graphs.getSecondaryGraph());
      this.removeGraphMouseListener(this.graphs.getPrimaryGraph());
      this.removeGraphMouseListener(this.graphs.getSecondaryGraph());
      this.removeGraphMouseListener(this.graphs.getCombinedGraph());
   }

   public void removeGraphMouseListener(BinDiffGraph var1) {
      try {
         if(var1 == this.graphs.getPrimaryGraph()) {
            this.primaryGraphMouseListener.removeListener();
         } else if(var1 == this.graphs.getSecondaryGraph()) {
            this.secondaryGraphMouseListener.removeListener();
         } else if(var1 == this.graphs.getCombinedGraph()) {
            this.combinedGraphMouseListener.removeListener();
         } else {
            Logger.logWarning("Unknown graph! Remove graph mouse listener was ignored.", new Object[0]);
         }
      } catch (IllegalStateException var3) {
         Logger.logWarning("Listener was not listening.", new Object[0]);
      }

   }

   public void removeViewCanvasListener(BinDiffGraph var1) {
      try {
         if(var1 == this.graphs.getPrimaryGraph()) {
            this.primaryViewCanvasListener.removeListener();
         } else if(var1 == this.graphs.getSecondaryGraph()) {
            this.secondaryViewCanvasListener.removeListener();
         } else {
            Logger.logWarning("Unknown graph! Remove view canvas listener was ignored.", new Object[0]);
         }
      } catch (IllegalStateException var3) {
         Logger.logWarning("Listener was not listening.", new Object[0]);
      }

   }

   public void removeViewFocusListener(BinDiffGraph var1) {
      try {
         if(var1 == this.graphs.getPrimaryGraph()) {
            this.primaryViewFocusListener.addListener();
         } else if(var1 == this.graphs.getSecondaryGraph()) {
            this.secondaryViewFocusListener.addListener();
         } else {
            Logger.logWarning("Unknown graph! Add graph view focus listener was ignored.", new Object[0]);
         }
      } catch (IllegalStateException var3) {
         Logger.logWarning("Listener was not listening.", new Object[0]);
      }

   }

   public void suppressUpdating(boolean var1) {
      this.primaryViewCanvasListener.suppressUpdateGraph(var1);
      this.secondaryViewCanvasListener.suppressUpdateGraph(var1);
   }
}
