package com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes.single.callgraph;

import com.google.security.zynamics.bindiff.enums.ESide;
import com.google.security.zynamics.bindiff.graph.SingleGraph;
import com.google.security.zynamics.bindiff.graph.filter.GraphNodeMultiFilter;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.ViewTabPanelFunctions;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.AbstractGraphNodeTree;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.searcher.TreeNodeSearcher;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.sorter.TreeNodeMultiSorter;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes.AbstractRootTreeNode;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes.single.callgraph.SingleCallGraphBaseTreeNode;
import com.google.security.zynamics.bindiff.project.diff.Diff;
import com.google.security.zynamics.bindiff.project.userview.ViewData;
import java.awt.event.MouseEvent;
import javax.swing.Icon;
import javax.swing.JPopupMenu;

public class SingleCallGraphRootTreeNode extends AbstractRootTreeNode {
   private SingleGraph graph;

   public SingleCallGraphRootTreeNode(ViewTabPanelFunctions var1, AbstractGraphNodeTree var2, Diff var3, ViewData var4, TreeNodeSearcher var5, GraphNodeMultiFilter var6, TreeNodeMultiSorter var7) {
      super(var1, var2, var3, var4, var5, var6, var7);
      this.graph = (SingleGraph)var2.getGraph();
      this.createChildren();
   }

   protected void delete() {
      super.delete();
      this.graph = null;
   }

   public void createChildren() {
      this.add(new SingleCallGraphBaseTreeNode(this));
   }

   public SingleGraph getGraph() {
      return this.graph;
   }

   public Icon getIcon() {
      return null;
   }

   public JPopupMenu getPopupMenu() {
      return null;
   }

   public SingleCallGraphRootTreeNode getRootNode() {
      return this;
   }

   public ESide getSide() {
      return this.graph.getSide();
   }

   public String getTooltipText() {
      return null;
   }

   public void handleMouseEvent(MouseEvent var1) {
   }

   public boolean isSelected() {
      return false;
   }

   public boolean isVisible() {
      return true;
   }

   public String toString() {
      return "";
   }
}
