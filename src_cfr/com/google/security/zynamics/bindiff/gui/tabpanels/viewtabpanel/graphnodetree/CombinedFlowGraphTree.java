/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.graph.BinDiffGraph;
import com.google.security.zynamics.bindiff.graph.CombinedGraph;
import com.google.security.zynamics.bindiff.graph.filter.GraphNodeMultiFilter;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.ViewTabPanelFunctions;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.AbstractGraphNodeTree;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.renderers.CombinedTreeNodeRenderer;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.searcher.TreeNodeSearcher;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.sorter.TreeNodeMultiSorter;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes.combined.flowgraph.CombinedFlowGraphRootTreeNode;
import com.google.security.zynamics.bindiff.project.diff.Diff;
import com.google.security.zynamics.bindiff.project.userview.ViewData;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeCellRenderer;
import javax.swing.tree.TreeNode;

public class CombinedFlowGraphTree
extends AbstractGraphNodeTree {
    private CombinedGraph combinedGraph;

    public CombinedFlowGraphTree(ViewTabPanelFunctions viewTabPanelFunctions, Diff diff, ViewData viewData, CombinedGraph combinedGraph, TreeNodeSearcher treeNodeSearcher, GraphNodeMultiFilter graphNodeMultiFilter, TreeNodeMultiSorter treeNodeMultiSorter) {
        Preconditions.checkNotNull(viewTabPanelFunctions);
        Preconditions.checkNotNull(viewData);
        Preconditions.checkNotNull(viewData);
        Preconditions.checkNotNull(combinedGraph);
        Preconditions.checkNotNull(treeNodeSearcher);
        Preconditions.checkNotNull(graphNodeMultiFilter);
        Preconditions.checkNotNull(treeNodeMultiSorter);
        this.combinedGraph = combinedGraph;
        this.createTree(viewTabPanelFunctions, diff, viewData, treeNodeSearcher, graphNodeMultiFilter, treeNodeMultiSorter);
        this.addListeners();
        this.setBorder(new EmptyBorder(1, 1, 1, 1));
        this.expandRow(0);
    }

    private void createTree(ViewTabPanelFunctions viewTabPanelFunctions, Diff diff, ViewData viewData, TreeNodeSearcher treeNodeSearcher, GraphNodeMultiFilter graphNodeMultiFilter, TreeNodeMultiSorter treeNodeMultiSorter) {
        CombinedFlowGraphRootTreeNode combinedFlowGraphRootTreeNode = new CombinedFlowGraphRootTreeNode(viewTabPanelFunctions, this, diff, viewData, treeNodeSearcher, graphNodeMultiFilter, treeNodeMultiSorter);
        this.setRootVisible(false);
        this.getModel().setRoot(combinedFlowGraphRootTreeNode);
        this.setCellRenderer(new CombinedTreeNodeRenderer());
    }

    @Override
    public void dispose() {
        super.dispose();
        this.combinedGraph = null;
    }

    @Override
    public CombinedGraph getGraph() {
        return this.combinedGraph;
    }
}

