/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.graph.BinDiffGraph;
import com.google.security.zynamics.bindiff.graph.SingleGraph;
import com.google.security.zynamics.bindiff.graph.filter.GraphNodeMultiFilter;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.ViewTabPanelFunctions;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.AbstractGraphNodeTree;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.renderers.SingleTreeNodeRenderer;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.searcher.TreeNodeSearcher;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.sorter.TreeNodeMultiSorter;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes.single.callgraph.SingleCallGraphRootTreeNode;
import com.google.security.zynamics.bindiff.project.diff.Diff;
import com.google.security.zynamics.bindiff.project.userview.ViewData;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeCellRenderer;
import javax.swing.tree.TreeNode;

public class SingleCallGraphTree
extends AbstractGraphNodeTree {
    private SingleGraph singleGraph;

    public SingleCallGraphTree(ViewTabPanelFunctions viewTabPanelFunctions, Diff diff, ViewData viewData, SingleGraph singleGraph, TreeNodeSearcher treeNodeSearcher, GraphNodeMultiFilter graphNodeMultiFilter, TreeNodeMultiSorter treeNodeMultiSorter) {
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

    private void createTree(ViewTabPanelFunctions viewTabPanelFunctions, Diff diff, ViewData viewData, TreeNodeSearcher treeNodeSearcher, GraphNodeMultiFilter graphNodeMultiFilter, TreeNodeMultiSorter treeNodeMultiSorter) {
        SingleCallGraphRootTreeNode singleCallGraphRootTreeNode = new SingleCallGraphRootTreeNode(viewTabPanelFunctions, this, diff, viewData, treeNodeSearcher, graphNodeMultiFilter, treeNodeMultiSorter);
        this.setRootVisible(false);
        this.getModel().setRoot(singleCallGraphRootTreeNode);
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

