package com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree;

import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.*;
import com.google.security.zynamics.bindiff.project.diff.*;
import com.google.security.zynamics.bindiff.project.userview.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.searcher.*;
import com.google.security.zynamics.bindiff.graph.filter.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.sorter.*;
import com.google.common.base.*;
import javax.swing.border.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes.single.callgraph.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.renderers.*;
import javax.swing.tree.*;
import com.google.security.zynamics.bindiff.graph.*;

public class SingleCallGraphTree extends AbstractGraphNodeTree
{
    private SingleGraph singleGraph;
    
    public SingleCallGraphTree(final ViewTabPanelFunctions viewTabPanelFunctions, final Diff diff, final ViewData viewData, final SingleGraph singleGraph, final TreeNodeSearcher treeNodeSearcher, final GraphNodeMultiFilter graphNodeMultiFilter, final TreeNodeMultiSorter treeNodeMultiSorter) {
        Preconditions.checkNotNull(viewTabPanelFunctions);
        Preconditions.checkNotNull(diff);
        Preconditions.checkNotNull(viewData);
        this.singleGraph = (SingleGraph)Preconditions.checkNotNull(singleGraph);
        Preconditions.checkNotNull(treeNodeSearcher);
        Preconditions.checkNotNull(graphNodeMultiFilter);
        Preconditions.checkNotNull(treeNodeMultiSorter);
        this.createTree(viewTabPanelFunctions, diff, viewData, treeNodeSearcher, graphNodeMultiFilter, treeNodeMultiSorter);
        this.setBorder(new EmptyBorder(1, 1, 1, 1));
        this.addListeners();
        this.expandRow(0);
    }
    
    private void createTree(final ViewTabPanelFunctions viewTabPanelFunctions, final Diff diff, final ViewData viewData, final TreeNodeSearcher treeNodeSearcher, final GraphNodeMultiFilter graphNodeMultiFilter, final TreeNodeMultiSorter treeNodeMultiSorter) {
        final SingleCallGraphRootTreeNode root = new SingleCallGraphRootTreeNode(viewTabPanelFunctions, this, diff, viewData, treeNodeSearcher, graphNodeMultiFilter, treeNodeMultiSorter);
        this.setRootVisible(false);
        this.getModel().setRoot(root);
        this.setCellRenderer(new SingleTreeNodeRenderer());
    }
    
    @Override
    public void dispose() {
        super.dispose();
        this.singleGraph = null;
    }
    
    @Override
    public SingleGraph getGraph() {
        return this.singleGraph;
    }
}
