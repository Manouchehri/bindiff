package com.google.security.zynamics.bindiff.graph.listeners;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.graph.CombinedGraph;
import com.google.security.zynamics.bindiff.graph.edges.CombinedDiffEdge;
import com.google.security.zynamics.bindiff.graph.eventhandlers.CombinedGraphMouseEventHandler;
import com.google.security.zynamics.bindiff.graph.nodes.CombinedDiffNode;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.ViewTabPanelFunctions;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.IZyGraphListener;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.proximity.ZyProximityNode;
import java.awt.event.MouseEvent;
import y.h.aA;

public class CombinedGraphMouseListener implements IZyGraphListener {
   private final CombinedGraph graph;
   private final ViewTabPanelFunctions controller;

   protected CombinedGraphMouseListener(ViewTabPanelFunctions var1, CombinedGraph var2) {
      this.controller = (ViewTabPanelFunctions)Preconditions.checkNotNull(var1);
      this.graph = (CombinedGraph)Preconditions.checkNotNull(var2);
      this.addListener();
   }

   public void addListener() {
      this.graph.addListener(this);
   }

   public void edgeClicked(CombinedDiffEdge var1, MouseEvent var2, double var3, double var5) {
   }

   public void edgeLabelEntered(aA var1, MouseEvent var2) {
   }

   public void edgeLabelExited(aA var1) {
   }

   public void nodeClicked(CombinedDiffNode var1, MouseEvent var2, double var3, double var5) {
      CombinedGraphMouseEventHandler.nodeClicked(this.controller, this.graph, var1, var2);
   }

   public void nodeEntered(CombinedDiffNode var1, MouseEvent var2) {
   }

   public void nodeHovered(CombinedDiffNode var1, double var2, double var4) {
   }

   public void nodeLeft(CombinedDiffNode var1) {
   }

   public void proximityBrowserNodeClicked(ZyProximityNode var1, MouseEvent var2, double var3, double var5) {
      CombinedGraphMouseEventHandler.proximityBrowserNodeClicked(this.graph, var1, var2);
   }

   public void removeListener() {
      this.graph.removeListener(this);
   }
}
