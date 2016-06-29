package com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes;

import com.google.security.zynamics.bindiff.graph.filter.GraphNodeMultiFilter;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.ViewTabPanelFunctions;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.AbstractGraphNodeTree;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.searcher.TreeNodeSearcher;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.sorter.TreeNodeMultiSorter;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes.AbstractRootTreeNode;
import com.google.security.zynamics.bindiff.project.diff.Diff;
import com.google.security.zynamics.bindiff.project.userview.FlowGraphViewData;
import com.google.security.zynamics.bindiff.project.userview.ViewData;

public abstract class AbstractFlowGraphRootTreeNode extends AbstractRootTreeNode {
   public AbstractFlowGraphRootTreeNode(ViewTabPanelFunctions var1, AbstractGraphNodeTree var2, Diff var3, ViewData var4, TreeNodeSearcher var5, GraphNodeMultiFilter var6, TreeNodeMultiSorter var7) {
      super(var1, var2, var3, var4, var5, var6, var7);
   }

   public FlowGraphViewData getView() {
      return (FlowGraphViewData)super.getView();
   }
}
