/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.selectionhistory;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.graph.BinDiffGraph;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.ViewTabPanelFunctions;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.selectionhistory.AbstractSelectionHistoryTreeNode;
import com.google.security.zynamics.bindiff.utils.ImageUtils;
import javax.swing.Icon;
import javax.swing.JPopupMenu;
import javax.swing.JTree;

public class SelectionHistoryRootNode
extends AbstractSelectionHistoryTreeNode {
    private static final Icon ICON_ROOT = ImageUtils.getImageIcon("data/selectionicons/root.png");
    private final ViewTabPanelFunctions controller;
    private JTree tree;
    private final BinDiffGraph graph;

    public SelectionHistoryRootNode(ViewTabPanelFunctions viewTabPanelFunctions, BinDiffGraph binDiffGraph, String string) {
        super(string);
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
        return ICON_ROOT;
    }

    @Override
    public JPopupMenu getPopupMenu() {
        return null;
    }

    @Override
    public JTree getTree() {
        return this.tree;
    }

    public void setTree(JTree jTree) {
        this.tree = jTree;
    }
}

