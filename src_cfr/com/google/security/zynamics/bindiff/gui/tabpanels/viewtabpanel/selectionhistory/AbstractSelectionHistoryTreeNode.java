/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.selectionhistory;

import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.ViewTabPanelFunctions;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.selectionhistory.SelectionHistoryRootNode;
import java.awt.Component;
import java.awt.event.MouseEvent;
import javax.swing.Icon;
import javax.swing.JPopupMenu;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeNode;

public abstract class AbstractSelectionHistoryTreeNode
extends DefaultMutableTreeNode {
    public AbstractSelectionHistoryTreeNode(String string) {
        super(string);
    }

    public ViewTabPanelFunctions getController() {
        return this.getRootNode().getController();
    }

    public abstract Icon getIcon();

    public abstract JPopupMenu getPopupMenu();

    public SelectionHistoryRootNode getRootNode() {
        return (SelectionHistoryRootNode)this.getRoot();
    }

    public JTree getTree() {
        return this.getRootNode().getTree();
    }

    public void handleMouseEvent(MouseEvent mouseEvent) {
        if (mouseEvent.getButton() != 3) return;
        if (!mouseEvent.isPopupTrigger()) {
            return;
        }
        JPopupMenu jPopupMenu = this.getPopupMenu();
        if (jPopupMenu == null) return;
        jPopupMenu.show(this.getTree(), mouseEvent.getX(), mouseEvent.getY());
    }
}

