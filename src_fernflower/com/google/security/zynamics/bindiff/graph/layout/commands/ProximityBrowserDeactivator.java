package com.google.security.zynamics.bindiff.graph.layout.commands;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.graph.BinDiffGraph;
import com.google.security.zynamics.bindiff.graph.filter.GraphEdgeFilter;
import com.google.security.zynamics.bindiff.graph.filter.GraphNodeFilter;
import com.google.security.zynamics.bindiff.graph.filter.GraphNodeFilter$Criterium;
import com.google.security.zynamics.bindiff.graph.layout.commands.GraphLayoutUpdater;
import com.google.security.zynamics.bindiff.graph.layout.commands.GraphViewUpdater;
import com.google.security.zynamics.bindiff.graph.layout.commands.ProximityBrowserUpdater;
import com.google.security.zynamics.bindiff.graph.listeners.GraphsIntermediateListeners;
import com.google.security.zynamics.bindiff.graph.nodes.SuperDiffNode;
import com.google.security.zynamics.zylib.gui.CMessageBox;
import com.google.security.zynamics.zylib.types.common.ICommand;
import java.util.Iterator;

public class ProximityBrowserDeactivator implements ICommand {
   private final BinDiffGraph graph;

   public ProximityBrowserDeactivator(BinDiffGraph var1) {
      Preconditions.checkNotNull(var1);
      this.graph = var1;
   }

   private static boolean hasHiddenNodes(BinDiffGraph var0) {
      return GraphNodeFilter.filterNodesCountOnly(var0, GraphNodeFilter$Criterium.INVISIBLE) > 0;
   }

   private static boolean showAllNodesVisibilityWarningDialog(BinDiffGraph var0) {
      int var1 = GraphEdgeFilter.filterInvisibleEdges(var0).size();
      int var2 = GraphNodeFilter.filterNodesCountOnly(var0, GraphNodeFilter$Criterium.INVISIBLE);
      int var3 = var0.getSettings().getLayoutSettings().getVisibilityWarningThreshold();
      if(var1 >= var3) {
         int var4 = CMessageBox.showYesNoQuestion(BinDiffGraph.getParentWindow(var0), String.format("The selected operation makes %d more nodes with %d edges visible. Do you want to continue?", new Object[]{Integer.valueOf(var2), Integer.valueOf(var1)}));
         return var4 == 0;
      } else {
         return true;
      }
   }

   private static void unhideAll(BinDiffGraph var0) {
      ProximityBrowserUpdater.deleteAllProximityNodes(var0.getPrimaryGraph());
      ProximityBrowserUpdater.deleteAllProximityNodes(var0.getSecondaryGraph());
      Iterator var1 = var0.getSuperGraph().getNodes().iterator();

      while(var1.hasNext()) {
         SuperDiffNode var2 = (SuperDiffNode)var1.next();
         var2.getRawNode().setVisible(true);
         var2.getCombinedRawNode().setVisible(true);
      }

      ProximityBrowserUpdater.adoptSuperGraphVisibility(var0.getSuperGraph());
      GraphViewUpdater.updateViews(var0);
   }

   public static void executeStatic(BinDiffGraph var0) {
      if(hasHiddenNodes(var0)) {
         if(showAllNodesVisibilityWarningDialog(var0)) {
            var0.getCombinedGraph().getProximityBrowser().deleteProximityNodes();
            var0.getSuperGraph().getProximityBrowser().deleteProximityNodes();
            unhideAll(var0);
            GraphsIntermediateListeners.notifyIntermediateVisibilityListeners(var0);
            if(var0.getSettings().getLayoutSettings().getAutomaticLayouting()) {
               GraphLayoutUpdater.executeStatic(var0, true);
            }

            GraphViewUpdater.updateViews(var0);
         } else {
            var0.getSettings().getProximitySettings().setProximityBrowsing(true);
         }

      }
   }

   public void execute() {
      executeStatic(this.graph);
   }
}
