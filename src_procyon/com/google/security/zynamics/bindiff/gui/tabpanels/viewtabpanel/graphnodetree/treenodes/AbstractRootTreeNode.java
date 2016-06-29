package com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes;

import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.*;
import com.google.security.zynamics.bindiff.project.diff.*;
import com.google.security.zynamics.bindiff.project.userview.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.searcher.*;
import com.google.security.zynamics.bindiff.graph.filter.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.sorter.*;
import com.google.common.base.*;
import com.google.security.zynamics.bindiff.enums.*;

public abstract class AbstractRootTreeNode extends AbstractTreeNode
{
    private final ViewTabPanelFunctions controller;
    private Diff diff;
    private ViewData view;
    private TreeNodeSearcher searcher;
    private GraphNodeMultiFilter filter;
    private AbstractGraphNodeTree tree;
    private TreeNodeMultiSorter sorter;
    
    public AbstractRootTreeNode(final ViewTabPanelFunctions viewTabPanelFunctions, final AbstractGraphNodeTree abstractGraphNodeTree, final Diff diff, final ViewData viewData, final TreeNodeSearcher treeNodeSearcher, final GraphNodeMultiFilter graphNodeMultiFilter, final TreeNodeMultiSorter treeNodeMultiSorter) {
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
    
    public GraphNodeMultiFilter getFilter() {
        return this.filter;
    }
    
    public TreeNodeSearcher getSearcher() {
        return this.searcher;
    }
    
    public abstract ESide getSide();
    
    public TreeNodeMultiSorter getSorter() {
        return this.sorter;
    }
    
    public AbstractGraphNodeTree getTree() {
        return this.tree;
    }
    
    public ViewData getView() {
        return this.view;
    }
}
