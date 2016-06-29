/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.selectionhistory;

import com.google.security.zynamics.bindiff.graph.BinDiffGraph;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.selectionhistory.AbstractSelectionHistoryTreeNode;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.selectionhistory.SelectionHistoryRootNode;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.selectionhistory.SelectionHistoryTree$1;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.selectionhistory.SelectionHistoryTree$InternalMouseListener;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.selectionhistory.SelectionHistoryTreeCellRenderer;
import com.google.security.zynamics.zylib.gui.jtree.TreeHelpers;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.AbstractZyGraph;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JTree;
import javax.swing.tree.TreeCellRenderer;
import javax.swing.tree.TreeNode;

public class SelectionHistoryTree
extends JTree {
    private final SelectionHistoryTree$InternalMouseListener mouseListener;

    public SelectionHistoryTree(SelectionHistoryRootNode selectionHistoryRootNode) {
        super(selectionHistoryRootNode);
        this.mouseListener = new SelectionHistoryTree$InternalMouseListener(this, null);
        this.addMouseListener(this.mouseListener);
        this.setCellRenderer(new SelectionHistoryTreeCellRenderer(selectionHistoryRootNode.getGraph()));
    }

    private void handleMouseEvent(MouseEvent mouseEvent) {
        AbstractSelectionHistoryTreeNode abstractSelectionHistoryTreeNode = (AbstractSelectionHistoryTreeNode)TreeHelpers.getNodeAt(this, mouseEvent.getX(), mouseEvent.getY());
        if (abstractSelectionHistoryTreeNode == null) {
            return;
        }
        abstractSelectionHistoryTreeNode.handleMouseEvent(mouseEvent);
    }

    public void dispose() {
        this.removeMouseListener(this.mouseListener);
    }

    static /* synthetic */ void access$100(SelectionHistoryTree selectionHistoryTree, MouseEvent mouseEvent) {
        selectionHistoryTree.handleMouseEvent(mouseEvent);
    }
}

