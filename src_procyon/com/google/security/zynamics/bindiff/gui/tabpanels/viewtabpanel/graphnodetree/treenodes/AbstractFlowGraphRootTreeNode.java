package com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes;

import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.*;
import com.google.security.zynamics.bindiff.project.diff.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.searcher.*;
import com.google.security.zynamics.bindiff.graph.filter.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.sorter.*;
import com.google.security.zynamics.bindiff.project.userview.*;

public abstract class AbstractFlowGraphRootTreeNode extends AbstractRootTreeNode
{
    public AbstractFlowGraphRootTreeNode(final ViewTabPanelFunctions viewTabPanelFunctions, final AbstractGraphNodeTree abstractGraphNodeTree, final Diff diff, final ViewData viewData, final TreeNodeSearcher treeNodeSearcher, final GraphNodeMultiFilter graphNodeMultiFilter, final TreeNodeMultiSorter treeNodeMultiSorter) {
        super(viewTabPanelFunctions, abstractGraphNodeTree, diff, viewData, treeNodeSearcher, graphNodeMultiFilter, treeNodeMultiSorter);
    }
    
    @Override
    public FlowGraphViewData getView() {
        return (FlowGraphViewData)super.getView();
    }
}
