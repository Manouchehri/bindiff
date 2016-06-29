package com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes.combined.flowgraph;

import com.google.security.zynamics.bindiff.enums.ESide;
import com.google.security.zynamics.bindiff.graph.CombinedGraph;
import com.google.security.zynamics.bindiff.graph.filter.GraphNodeMultiFilter;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.ViewTabPanelFunctions;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.AbstractGraphNodeTree;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.searcher.TreeNodeSearcher;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.sorter.TreeNodeMultiSorter;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes.AbstractFlowGraphRootTreeNode;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes.combined.flowgraph.CombinedFlowGraphBaseTreeNode;
import com.google.security.zynamics.bindiff.project.diff.Diff;
import com.google.security.zynamics.bindiff.project.userview.ViewData;
import java.awt.event.MouseEvent;
import javax.swing.Icon;

public class CombinedFlowGraphRootTreeNode extends AbstractFlowGraphRootTreeNode {
   private final CombinedGraph combinedGraph;

   public CombinedFlowGraphRootTreeNode(ViewTabPanelFunctions var1, AbstractGraphNodeTree var2, Diff var3, ViewData var4, TreeNodeSearcher var5, GraphNodeMultiFilter var6, TreeNodeMultiSorter var7) {
      super(var1, var2, var3, var4, var5, var6, var7);
      this.combinedGraph = (CombinedGraph)var2.getGraph();
      this.createChildren();
   }

   public void createChildren() {
      this.add(new CombinedFlowGraphBaseTreeNode(this));
   }

   public CombinedGraph getGraph() {
      return this.combinedGraph;
   }

   public Icon getIcon() {
      return null;
   }

   public CombinedFlowGraphRootTreeNode getRootNode() {
      return this;
   }

   public ESide getSide() {
      return null;
   }

   public void handleMouseEvent(MouseEvent var1) {
   }

   public String toString() {
      return "Root Node";
   }
}
