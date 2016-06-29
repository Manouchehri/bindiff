package com.google.security.zynamics.bindiff.graph.listeners;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.graph.SingleGraph;
import com.google.security.zynamics.bindiff.graph.edges.SingleDiffEdge;
import com.google.security.zynamics.bindiff.graph.eventhandlers.SingleGraphMouseEventHandler;
import com.google.security.zynamics.bindiff.graph.nodes.SingleDiffNode;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.ViewTabPanelFunctions;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.IZyGraphListener;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.proximity.ZyProximityNode;
import java.awt.event.MouseEvent;
import y.h.aA;

public class SingleGraphMouseListener implements IZyGraphListener {
   private final SingleGraph graph;
   private final ViewTabPanelFunctions controller;

   protected SingleGraphMouseListener(ViewTabPanelFunctions var1, SingleGraph var2) {
      this.controller = (ViewTabPanelFunctions)Preconditions.checkNotNull(var1);
      this.graph = (SingleGraph)Preconditions.checkNotNull(var2);
      this.addListener();
   }

   public void addListener() {
      this.graph.addListener(this);
   }

   public void edgeClicked(SingleDiffEdge var1, MouseEvent var2, double var3, double var5) {
   }

   public void edgeLabelEntered(aA var1, MouseEvent var2) {
   }

   public void edgeLabelExited(aA var1) {
   }

   public void nodeClicked(SingleDiffNode var1, MouseEvent var2, double var3, double var5) {
      SingleGraphMouseEventHandler.nodeClicked(this.controller, this.graph, var1, var2);
   }

   public void nodeEntered(SingleDiffNode var1, MouseEvent var2) {
      SingleGraphMouseEventHandler.nodeEntered(this.graph, var1);
   }

   public void nodeHovered(SingleDiffNode var1, double var2, double var4) {
   }

   public void nodeLeft(SingleDiffNode var1) {
      SingleGraphMouseEventHandler.nodeLeft(this.graph, var1);
   }

   public void proximityBrowserNodeClicked(ZyProximityNode var1, MouseEvent var2, double var3, double var5) {
      SingleGraphMouseEventHandler.proximityBrowserNodeClicked(this.graph, var1, var2);
   }

   public void removeListener() {
      this.graph.removeListener(this);
   }
}
