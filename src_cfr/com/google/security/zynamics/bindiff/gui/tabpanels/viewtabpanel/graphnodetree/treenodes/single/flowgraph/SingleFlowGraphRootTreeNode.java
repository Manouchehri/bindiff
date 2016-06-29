/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes.single.flowgraph;

import com.google.security.zynamics.bindiff.enums.ESide;
import com.google.security.zynamics.bindiff.graph.BinDiffGraph;
import com.google.security.zynamics.bindiff.graph.SingleGraph;
import com.google.security.zynamics.bindiff.graph.filter.GraphNodeMultiFilter;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.ViewTabPanelFunctions;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.AbstractGraphNodeTree;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.searcher.TreeNodeSearcher;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.sorter.TreeNodeMultiSorter;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes.AbstractFlowGraphRootTreeNode;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes.AbstractRootTreeNode;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes.single.flowgraph.SingleFlowGraphBaseTreeNode;
import com.google.security.zynamics.bindiff.project.diff.Diff;
import com.google.security.zynamics.bindiff.project.rawflowgraph.RawFlowGraph;
import com.google.security.zynamics.bindiff.project.userview.FlowGraphViewData;
import com.google.security.zynamics.bindiff.project.userview.ViewData;
import java.awt.event.MouseEvent;
import javax.swing.Icon;
import javax.swing.JPopupMenu;
import javax.swing.tree.MutableTreeNode;

public class SingleFlowGraphRootTreeNode
extends AbstractFlowGraphRootTreeNode {
    public SingleFlowGraphRootTreeNode(ViewTabPanelFunctions viewTabPanelFunctions, AbstractGraphNodeTree abstractGraphNodeTree, Diff diff, ViewData viewData, TreeNodeSearcher treeNodeSearcher, GraphNodeMultiFilter graphNodeMultiFilter, TreeNodeMultiSorter treeNodeMultiSorter) {
        super(viewTabPanelFunctions, abstractGraphNodeTree, diff, viewData, treeNodeSearcher, graphNodeMultiFilter, treeNodeMultiSorter);
        this.createChildren();
    }

    @Override
    public void createChildren() {
        if (this.getView().getRawGraph(this.getSide()) == null) return;
        this.add(new SingleFlowGraphBaseTreeNode(this));
    }

    @Override
    public SingleGraph getGraph() {
        return (SingleGraph)this.getTree().getGraph();
    }

    @Override
    public Icon getIcon() {
        return null;
    }

    @Override
    public JPopupMenu getPopupMenu() {
        return null;
    }

    @Override
    public SingleFlowGraphRootTreeNode getRootNode() {
        return this;
    }

    @Override
    public ESide getSide() {
        return this.getGraph().getSide();
    }

    @Override
    public String getTooltipText() {
        return null;
    }

    @Override
    public void handleMouseEvent(MouseEvent mouseEvent) {
    }

    @Override
    public boolean isSelected() {
        return false;
    }

    @Override
    public boolean isVisible() {
        return true;
    }

    @Override
    public String toString() {
        return "";
    }
}

