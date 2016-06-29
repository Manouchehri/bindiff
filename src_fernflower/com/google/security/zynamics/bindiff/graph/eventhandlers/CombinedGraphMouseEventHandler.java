package com.google.security.zynamics.bindiff.graph.eventhandlers;

import com.google.security.zynamics.bindiff.enums.EGraphType;
import com.google.security.zynamics.bindiff.graph.CombinedGraph;
import com.google.security.zynamics.bindiff.graph.eventhandlers.GraphLayoutEventHandler;
import com.google.security.zynamics.bindiff.graph.nodes.CombinedDiffNode;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.ViewTabPanelFunctions;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.popupmenus.CallGraphPopupMenu;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.popupmenus.FlowGraphPopupMenu;
import com.google.security.zynamics.bindiff.project.rawcallgraph.RawCombinedFunction;
import com.google.security.zynamics.bindiff.project.rawflowgraph.RawCombinedBasicBlock;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.proximity.ZyProximityNode;
import java.awt.event.MouseEvent;

public final class CombinedGraphMouseEventHandler {
   public static void nodeClicked(ViewTabPanelFunctions var0, CombinedGraph var1, CombinedDiffNode var2, MouseEvent var3) {
      if(var3.getButton() == 3) {
         if(var2.getRawNode() instanceof RawCombinedBasicBlock) {
            FlowGraphPopupMenu var4 = new FlowGraphPopupMenu(var0, var1, var2);
            var4.show(var1.getView(), var3.getX(), var3.getY());
         } else if(var2.getRawNode() instanceof RawCombinedFunction) {
            CallGraphPopupMenu var5 = new CallGraphPopupMenu(var0, var1, var2);
            var5.show(var1.getView(), var3.getX(), var3.getY());
         }
      }

      if(var3.getButton() == 1 && var3.getClickCount() == 2 && var1.getGraphType() == EGraphType.CALLGRAPH) {
         var0.openFlowgraphsViews(var2);
      }

   }

   public static void proximityBrowserNodeClicked(CombinedGraph var0, ZyProximityNode var1, MouseEvent var2) {
      if(var2.getButton() == 1) {
         GraphLayoutEventHandler.handleProximityNodeClickedEvent(var0, var1);
      }

   }
}
