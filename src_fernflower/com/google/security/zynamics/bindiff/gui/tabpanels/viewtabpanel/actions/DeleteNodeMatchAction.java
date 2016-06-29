package com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.actions;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.enums.EDiffViewMode;
import com.google.security.zynamics.bindiff.graph.BinDiffGraph;
import com.google.security.zynamics.bindiff.graph.GraphsContainer;
import com.google.security.zynamics.bindiff.graph.helpers.BasicBlockMatchRemover;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.ViewTabPanelFunctions;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.ZyGraphNode;
import java.awt.event.ActionEvent;
import java.util.List;
import javax.swing.AbstractAction;

public class DeleteNodeMatchAction extends AbstractAction {
   private final ViewTabPanelFunctions controller;
   private final BinDiffGraph graph;
   private final ZyGraphNode clickedNode;

   public DeleteNodeMatchAction(ViewTabPanelFunctions var1) {
      this(var1, (BinDiffGraph)null, (ZyGraphNode)null);
   }

   public DeleteNodeMatchAction(ViewTabPanelFunctions var1, BinDiffGraph var2, ZyGraphNode var3) {
      super("Delete Basic Block Matches");
      this.controller = (ViewTabPanelFunctions)Preconditions.checkNotNull(var1);
      this.graph = var2;
      this.clickedNode = var3;
   }

   public void actionPerformed(ActionEvent var1) {
      GraphsContainer var2 = this.controller.getGraphs();
      if(this.graph != null && this.clickedNode != null) {
         List var6 = BasicBlockMatchRemover.getAffectedCombinedNodes(this.graph, this.clickedNode);
         if(var6 != null) {
            this.controller.removeNodeMatch(var6);
         }
      } else {
         EDiffViewMode var3 = this.controller.getGraphSettings().getDiffViewMode();
         Object var4 = null;
         if(var3 == EDiffViewMode.COMBINED_VIEW) {
            var4 = var2.getCombinedGraph();
         } else if(var3 == EDiffViewMode.NORMAL_VIEW) {
            var4 = var2.getPrimaryGraph();
         }

         List var5 = BasicBlockMatchRemover.getAffectedCombinedNodes((BinDiffGraph)var4);
         if(var5 != null) {
            this.controller.removeNodeMatch(var5);
         }
      }

   }
}
