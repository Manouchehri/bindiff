/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.projecttree.treenodes;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.WorkspaceTabPanelFunctions;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.projecttree.WorkspaceTree;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.projecttree.treenodes.AbstractTreeNode;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.projecttree.treenodes.AllFunctionDiffViewsNode;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.projecttree.treenodes.DiffNode;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.DefaultTreeNodeContextPanel;
import com.google.security.zynamics.bindiff.project.Workspace;
import com.google.security.zynamics.bindiff.project.diff.Diff;
import java.awt.Component;
import java.util.Iterator;
import java.util.List;
import javax.swing.Icon;
import javax.swing.JPopupMenu;
import javax.swing.tree.MutableTreeNode;

public final class RootNode
extends AbstractTreeNode {
    private Workspace workspace = null;
    private final WorkspaceTree tree;
    private final DefaultTreeNodeContextPanel component = new DefaultTreeNodeContextPanel();

    public RootNode(WorkspaceTree workspaceTree, WorkspaceTabPanelFunctions workspaceTabPanelFunctions) {
        super(workspaceTabPanelFunctions, null);
        this.tree = (WorkspaceTree)Preconditions.checkNotNull(workspaceTree);
        this.createChildren();
    }

    @Override
    protected void createChildren() {
        if (this.workspace == null) return;
        this.add(new AllFunctionDiffViewsNode(this.getController()));
        Iterator iterator = this.workspace.getDiffList().iterator();
        while (iterator.hasNext()) {
            Diff diff = (Diff)iterator.next();
            if (diff == null) {
                throw new RuntimeException("Diff cannot be null.");
            }
            if (diff.isFunctionDiff()) continue;
            this.add(new DiffNode(diff, this.getController()));
        }
    }

    @Override
    protected void delete() {
        this.deleteChildren();
    }

    @Override
    protected WorkspaceTree getTree() {
        return this.tree;
    }

    public void addDiff(Diff diff) {
        if (diff.isFunctionDiff()) return;
        this.add(new DiffNode(diff, this.getController()));
    }

    @Override
    public void doubleClicked() {
    }

    @Override
    public Component getComponent() {
        return this.component;
    }

    @Override
    public Icon getIcon() {
        return null;
    }

    @Override
    public JPopupMenu getPopupMenu() {
        return null;
    }

    public void setWorkspace(Workspace workspace) {
        this.workspace = workspace;
        this.createChildren();
    }

    @Override
    public String toString() {
        return "";
    }
}

