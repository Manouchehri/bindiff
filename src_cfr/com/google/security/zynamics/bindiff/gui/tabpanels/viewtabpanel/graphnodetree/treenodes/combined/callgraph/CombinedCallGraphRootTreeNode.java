/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes.combined.callgraph;

import com.google.security.zynamics.bindiff.enums.ESide;
import com.google.security.zynamics.bindiff.graph.BinDiffGraph;
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
import javax.swing.tree.MutableTreeNode;

public class CombinedCallGraphRootTreeNode
extends AbstractRootTreeNode {
    private CombinedGraph graph;

    public CombinedCallGraphRootTreeNode(ViewTabPanelFunctions viewTabPanelFunctions, AbstractGraphNodeTree abstractGraphNodeTree, Diff diff, ViewData viewData, TreeNodeSearcher treeNodeSearcher, GraphNodeMultiFilter graphNodeMultiFilter, TreeNodeMultiSorter treeNodeMultiSorter) {
        super(viewTabPanelFunctions, abstractGraphNodeTree, diff, viewData, treeNodeSearcher, graphNodeMultiFilter, treeNodeMultiSorter);
        this.graph = (CombinedGraph)abstractGraphNodeTree.getGraph();
        this.createChildren();
    }

    @Override
    protected void delete() {
        super.delete();
        this.graph = null;
    }

    @Override
    public void createChildren() {
        this.add(new CombinedCallGraphBaseTreeNode(this));
    }

    @Override
    public CombinedGraph getGraph() {
        return this.graph;
    }

    @Override
    public Icon getIcon() {
        return null;
    }

    @Override
    public CombinedCallGraphRootTreeNode getRootNode() {
        return this;
    }

    @Override
    public ESide getSide() {
        return null;
    }

    @Override
    public void handleMouseEvent(MouseEvent mouseEvent) {
    }

    @Override
    public String toString() {
        return "Root Node";
    }
}

