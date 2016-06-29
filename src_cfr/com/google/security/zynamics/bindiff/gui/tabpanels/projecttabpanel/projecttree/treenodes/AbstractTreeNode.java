/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.projecttree.treenodes;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.WorkspaceTabPanelFunctions;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.projecttree.WorkspaceTree;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.projecttree.WorkspaceTreeModel;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.projecttree.treenodes.RootNode;
import com.google.security.zynamics.bindiff.project.diff.Diff;
import java.awt.Component;
import javax.swing.Icon;
import javax.swing.JPopupMenu;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeNode;

public abstract class AbstractTreeNode
extends DefaultMutableTreeNode {
    private final WorkspaceTabPanelFunctions controller;
    private final Diff diff;

    public AbstractTreeNode(WorkspaceTabPanelFunctions workspaceTabPanelFunctions, Diff diff) {
        this.controller = (WorkspaceTabPanelFunctions)Preconditions.checkNotNull(workspaceTabPanelFunctions);
        this.diff = diff;
    }

    protected abstract void createChildren();

    protected abstract void delete();

    protected WorkspaceTabPanelFunctions getController() {
        return this.controller;
    }

    protected WorkspaceTree getTree() {
        return this.controller.getWorkspaceTree();
    }

    protected WorkspaceTreeModel getTreeModel() {
        return this.controller.getWorkspaceTree().getModel();
    }

    public void deleteChildren() {
        int n2 = 0;
        do {
            if (n2 >= this.getChildCount()) {
                this.removeAllChildren();
                return;
            }
            AbstractTreeNode abstractTreeNode = (AbstractTreeNode)this.getChildAt(n2);
            abstractTreeNode.delete();
            ++n2;
        } while (true);
    }

    public abstract void doubleClicked();

    public abstract Component getComponent();

    public Diff getDiff() {
        return this.diff;
    }

    public abstract Icon getIcon();

    public abstract JPopupMenu getPopupMenu();

    @Override
    public RootNode getRoot() {
        return this.controller.getWorkspaceTree().getModel().getRoot();
    }

    @Override
    public abstract String toString();
}

