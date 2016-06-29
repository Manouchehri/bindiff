package com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes.combined.callgraph;

import com.google.security.zynamics.bindiff.enums.ESide;
import com.google.security.zynamics.bindiff.graph.CombinedGraph;
import com.google.security.zynamics.bindiff.graph.filter.GraphNodeMultiFilter;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.ViewTabPanelFunctions;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.AbstractGraphNodeTree;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.searcher.TreeNodeSearcher;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.sorter.TreeNodeMultiSorter;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes.AbstractRootTreeNode;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes.combined.callgraph.CombinedCallGraphBaseTreeNode;
import com.google.security.zynamics.bindiff.project.diff.Diff;
import com.google.security.zynamics.bindiff.project.userview.ViewData;
import java.awt.event.MouseEvent;
import javax.swing.Icon;

public class CombinedCallGraphRootTreeNode extends AbstractRootTreeNode {
   private CombinedGraph graph;

   public CombinedCallGraphRootTreeNode(ViewTabPanelFunctions var1, AbstractGraphNodeTree var2, Diff var3, ViewData var4, TreeNodeSearcher var5, GraphNodeMultiFilter var6, TreeNodeMultiSorter var7) {
      super(var1, var2, var3, var4, var5, var6, var7);
      this.graph = (CombinedGraph)var2.getGraph();
      this.createChildren();
   }

   protected void delete() {
      super.delete();
      this.graph = null;
   }

   public void createChildren() {
      this.add(new CombinedCallGraphBaseTreeNode(this));
   }

   public CombinedGraph getGraph() {
      return this.graph;
   }

   public Icon getIcon() {
      return null;
   }

   public CombinedCallGraphRootTreeNode getRootNode() {
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
