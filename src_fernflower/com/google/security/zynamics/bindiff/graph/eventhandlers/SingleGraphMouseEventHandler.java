package com.google.security.zynamics.bindiff.graph.eventhandlers;

import com.google.security.zynamics.bindiff.enums.EGraphType;
import com.google.security.zynamics.bindiff.graph.SingleGraph;
import com.google.security.zynamics.bindiff.graph.eventhandlers.GraphLayoutEventHandler;
import com.google.security.zynamics.bindiff.graph.nodes.SingleDiffNode;
import com.google.security.zynamics.bindiff.graph.synchronizer.GraphMouseHoverSynchronizer;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.ViewTabPanelFunctions;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.popupmenus.CallGraphPopupMenu;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.popupmenus.FlowGraphPopupMenu;
import com.google.security.zynamics.bindiff.project.rawcallgraph.RawFunction;
import com.google.security.zynamics.bindiff.project.rawflowgraph.RawBasicBlock;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.proximity.ZyProximityNode;
import java.awt.event.MouseEvent;

public final class SingleGraphMouseEventHandler {
   public static void nodeClicked(ViewTabPanelFunctions var0, SingleGraph var1, SingleDiffNode var2, MouseEvent var3) {
      if(var3.getButton() == 3) {
         if(var2.getRawNode() instanceof RawFunction) {
            CallGraphPopupMenu var4 = new CallGraphPopupMenu(var0, var1, var2);
            var4.show(var1.getView(), var3.getX(), var3.getY());
         } else if(var2.getRawNode() instanceof RawBasicBlock) {
            FlowGraphPopupMenu var5 = new FlowGraphPopupMenu(var0, var1, var2);
            var5.show(var1.getView(), var3.getX(), var3.getY());
         }
      }

      if(var3.getButton() == 1 && var3.getClickCount() == 2 && var1.getGraphType() == EGraphType.CALLGRAPH) {
         var0.openFlowgraphsViews(var2);
      }

   }

   public static void nodeEntered(SingleGraph var0, SingleDiffNode var1) {
      if(var1 != null) {
         GraphMouseHoverSynchronizer.adoptHoveredNodeState(var0, var1);
      }

   }

   public static void nodeLeft(SingleGraph var0, SingleDiffNode var1) {
      if(var1 != null) {
         GraphMouseHoverSynchronizer.adoptHoveredNodeState(var0, var1);
      }

   }

   public static void proximityBrowserNodeClicked(SingleGraph var0, ZyProximityNode var1, MouseEvent var2) {
      if(var2.getButton() == 1) {
         GraphLayoutEventHandler.handleProximityNodeClickedEvent(var0, var1);
      }

   }
}
