/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.enums.ESide;
import com.google.security.zynamics.bindiff.graph.filter.GraphNodeMultiFilter;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.ViewTabPanelFunctions;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.AbstractGraphNodeTree;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.searcher.TreeNodeSearcher;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.sorter.TreeNodeMultiSorter;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes.AbstractTreeNode;
import com.google.security.zynamics.bindiff.project.diff.Diff;
import com.google.security.zynamics.bindiff.project.userview.ViewData;

public abstract class AbstractRootTreeNode
extends AbstractTreeNode {
    private final ViewTabPanelFunctions controller;
    private Diff diff;
    private ViewData view;
    private TreeNodeSearcher searcher;
    private GraphNodeMultiFilter filter;
    private AbstractGraphNodeTree tree;
    private TreeNodeMultiSorter sorter;

    public AbstractRootTreeNode(ViewTabPanelFunctions viewTabPanelFunctions, AbstractGraphNodeTree abstractGraphNodeTree, Diff diff, ViewData viewData, TreeNodeSearcher treeNodeSearcher, GraphNodeMultiFilter graphNodeMultiFilter, TreeNodeMultiSorter treeNodeMultiSorter) {
        super(null);
        this.controller = (ViewTabPanelFunctions)Preconditions.checkNotNull(viewTabPanelFunctions);
        this.tree = (AbstractGraphNodeTree)Preconditions.checkNotNull(abstractGraphNodeTree);
        this.view = (ViewData)Preconditions.checkNotNull(viewData);
        this.searcher = (TreeNodeSearcher)Preconditions.checkNotNull(treeNodeSearcher);
        this.filter = (GraphNodeMultiFilter)Preconditions.checkNotNull(graphNodeMultiFilter);
        this.sorter = (TreeNodeMultiSorter)Preconditions.checkNotNull(treeNodeMultiSorter);
        this.diff = diff;
    }

    @Override
    protected Diff getDiff() {
        return this.diff;
    }

    public void dispose() {
        this.delete();
        this.searcher = null;
        this.filter = null;
        this.sorter = null;
        this.view = null;
        this.tree = null;
        this.diff = null;
    }

    public ViewTabPanelFunctions getController() {
        return this.controller;
    }

    @Override
    public GraphNodeMultiFilter getFilter() {
        return this.filter;
    }

    @Override
    public TreeNodeSearcher getSearcher() {
        return this.searcher;
    }

    public abstract ESide getSide();

    @Override
    public TreeNodeMultiSorter getSorter() {
        return this.sorter;
    }

    @Override
    public AbstractGraphNodeTree getTree() {
        return this.tree;
    }

    @Override
    public ViewData getView() {
        return this.view;
    }
}

