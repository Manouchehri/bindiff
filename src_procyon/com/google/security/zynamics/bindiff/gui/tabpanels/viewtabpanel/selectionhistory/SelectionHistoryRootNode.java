package com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.selectionhistory;

import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.*;
import com.google.security.zynamics.bindiff.graph.*;
import com.google.common.base.*;
import javax.swing.*;
import com.google.security.zynamics.bindiff.utils.*;

public class SelectionHistoryRootNode extends AbstractSelectionHistoryTreeNode
{
    private static final Icon ICON_ROOT;
    private final ViewTabPanelFunctions controller;
    private JTree tree;
    private final BinDiffGraph graph;
    
    public SelectionHistoryRootNode(final ViewTabPanelFunctions viewTabPanelFunctions, final BinDiffGraph binDiffGraph, final String s) {
        super(s);
        this.controller = (ViewTabPanelFunctions)Preconditions.checkNotNull(viewTabPanelFunctions);
        this.graph = (BinDiffGraph)Preconditions.checkNotNull(binDiffGraph);
    }
    
    @Override
    public ViewTabPanelFunctions getController() {
        return this.controller;
    }
    
    public BinDiffGraph getGraph() {
        return this.graph;
    }
    
    @Override
    public Icon getIcon() {
        return SelectionHistoryRootNode.ICON_ROOT;
    }
    
    @Override
    public JPopupMenu getPopupMenu() {
        return null;
    }
    
    @Override
    public JTree getTree() {
        return this.tree;
    }
    
    public void setTree(final JTree tree) {
        this.tree = tree;
    }
    
    static {
        ICON_ROOT = ImageUtils.getImageIcon("data/selectionicons/root.png");
    }
}
