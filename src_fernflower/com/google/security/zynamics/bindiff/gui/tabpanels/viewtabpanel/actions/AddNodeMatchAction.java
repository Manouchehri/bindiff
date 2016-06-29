package com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.actions;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.enums.EDiffViewMode;
import com.google.security.zynamics.bindiff.graph.BinDiffGraph;
import com.google.security.zynamics.bindiff.graph.GraphsContainer;
import com.google.security.zynamics.bindiff.graph.helpers.BasicBlockMatchAdder;
import com.google.security.zynamics.bindiff.graph.nodes.CombinedDiffNode;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.ViewTabPanelFunctions;
import com.google.security.zynamics.zylib.general.Pair;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.ZyGraphNode;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;

public class AddNodeMatchAction extends AbstractAction {
   private final ViewTabPanelFunctions controller;
   private final BinDiffGraph graph;
   private final ZyGraphNode clickedNode;

   public AddNodeMatchAction(ViewTabPanelFunctions var1) {
      this(var1, (BinDiffGraph)null, (ZyGraphNode)null);
   }

   public AddNodeMatchAction(ViewTabPanelFunctions var1, BinDiffGraph var2, ZyGraphNode var3) {
      super("Add Basic Block Match");
      this.controller = (ViewTabPanelFunctions)Preconditions.checkNotNull(var1);
      this.graph = var2;
      this.clickedNode = var3;
   }

   public void actionPerformed(ActionEvent var1) {
      GraphsContainer var2 = this.controller.getGraphs();
      if(this.graph != null && this.clickedNode != null) {
         Pair var6 = BasicBlockMatchAdder.getAffectedCombinedNodes(this.graph, this.clickedNode);
         if(var6 != null) {
            this.controller.addNodeMatch((CombinedDiffNode)var6.first(), (CombinedDiffNode)var6.second());
         }
      } else {
         EDiffViewMode var3 = this.controller.getGraphSettings().getDiffViewMode();
         Object var4 = null;
         if(var3 == EDiffViewMode.COMBINED_VIEW) {
            var4 = var2.getCombinedGraph();
         } else if(var3 == EDiffViewMode.NORMAL_VIEW) {
            var4 = var2.getPrimaryGraph();
         }

         Pair var5 = BasicBlockMatchAdder.getAffectedCombinedNodes((BinDiffGraph)var4);
         if(var5 != null) {
            this.controller.addNodeMatch((CombinedDiffNode)var5.first(), (CombinedDiffNode)var5.second());
         }
      }

   }
}
