package com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes.single.flowgraph;

import com.google.security.zynamics.bindiff.enums.ESide;
import com.google.security.zynamics.bindiff.graph.SingleGraph;
import com.google.security.zynamics.bindiff.graph.filter.GraphNodeMultiFilter;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.ViewTabPanelFunctions;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.AbstractGraphNodeTree;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.searcher.TreeNodeSearcher;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.sorter.TreeNodeMultiSorter;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes.AbstractFlowGraphRootTreeNode;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes.single.flowgraph.SingleFlowGraphBaseTreeNode;
import com.google.security.zynamics.bindiff.project.diff.Diff;
import com.google.security.zynamics.bindiff.project.userview.ViewData;
import java.awt.event.MouseEvent;
import javax.swing.Icon;
import javax.swing.JPopupMenu;

public class SingleFlowGraphRootTreeNode extends AbstractFlowGraphRootTreeNode {
   public SingleFlowGraphRootTreeNode(ViewTabPanelFunctions var1, AbstractGraphNodeTree var2, Diff var3, ViewData var4, TreeNodeSearcher var5, GraphNodeMultiFilter var6, TreeNodeMultiSorter var7) {
      super(var1, var2, var3, var4, var5, var6, var7);
      this.createChildren();
   }

   public void createChildren() {
      if(this.getView().getRawGraph(this.getSide()) != null) {
         this.add(new SingleFlowGraphBaseTreeNode(this));
      }

   }

   public SingleGraph getGraph() {
      return (SingleGraph)this.getTree().getGraph();
   }

   public Icon getIcon() {
      return null;
   }

   public JPopupMenu getPopupMenu() {
      return null;
   }

   public SingleFlowGraphRootTreeNode getRootNode() {
      return this;
   }

   public ESide getSide() {
      return this.getGraph().getSide();
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
