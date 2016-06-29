package com.google.security.zynamics.bindiff.graph.eventhandlers;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.graph.BinDiffGraph;
import com.google.security.zynamics.bindiff.graph.helpers.GraphMover;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.AbstractZyGraph;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.edges.ZyGraphEdge;
import java.awt.event.MouseEvent;

public class EdgeClickEventHandler {
   public static void handleEdgeClicks(AbstractZyGraph var0, ZyGraphEdge var1, MouseEvent var2) {
      Preconditions.checkNotNull(var0, "Graph argument can not be null");
      Preconditions.checkNotNull(var1, "Edge argument can not be null");
      Preconditions.checkNotNull(var2, "Event argument can not be null");
      if(var2.getButton() == 1 && var2.isShiftDown()) {
         var0.getGraph().a(var1.getEdge(), !var1.isSelected());
      } else if(var2.getButton() == 1 && !var2.isShiftDown() && var1.getSource() != var1.getTarget()) {
         double var3 = var0.getView().toWorldCoordX(var2.getX());
         double var5 = var0.getView().toWorldCoordY(var2.getY());
         GraphMover.moveToEdgeNode((BinDiffGraph)var0, var1.getEdge(), var3, var5);
      }

   }
}
