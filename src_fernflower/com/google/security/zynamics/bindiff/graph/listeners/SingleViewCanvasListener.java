package com.google.security.zynamics.bindiff.graph.listeners;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.enums.EGraphType;
import com.google.security.zynamics.bindiff.graph.SingleGraph;
import com.google.security.zynamics.bindiff.graph.synchronizer.GraphViewCanvasSynchronizer;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.ViewTabPanelFunctions;
import java.awt.geom.Point2D.Double;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class SingleViewCanvasListener implements PropertyChangeListener {
   private final SingleGraph graph;
   private final ViewTabPanelFunctions viewPanelController;
   private boolean suppressUpdateGraph = false;

   protected SingleViewCanvasListener(ViewTabPanelFunctions var1, SingleGraph var2) {
      Preconditions.checkNotNull(var1);
      Preconditions.checkNotNull(var2);
      this.viewPanelController = var1;
      this.graph = var2;
      this.addListener();
   }

   public void addListener() {
      this.graph.getView().getCanvasComponent().addPropertyChangeListener(this);
   }

   public void propertyChange(PropertyChangeEvent var1) {
      if(this.graph.getGraphType() != EGraphType.FLOWGRAPH || this.graph.getFunctionAddress() != null) {
         if("Zoom".equals(var1.getPropertyName())) {
            GraphViewCanvasSynchronizer.adoptZoom(this.viewPanelController.getGraphListenerManager(), this.graph);
         } else if("ViewPoint".equals(var1.getPropertyName())) {
            GraphViewCanvasSynchronizer.adoptViewPoint(this.viewPanelController.getGraphListenerManager(), this.graph, (Double)var1.getOldValue(), this.suppressUpdateGraph);
         }

      }
   }

   public void removeListener() {
      this.graph.getView().getCanvasComponent().removePropertyChangeListener(this);
   }

   public void suppressUpdateGraph(boolean var1) {
      this.suppressUpdateGraph = var1;
   }
}
