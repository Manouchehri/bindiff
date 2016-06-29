/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.projecttree;

import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.projecttree.WorkspaceTree;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.projecttree.treenodes.RootNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeNode;

public final class WorkspaceTreeModel
extends DefaultTreeModel {
    private final RootNode rootNode;
    private final WorkspaceTree tree;

    public WorkspaceTreeModel(WorkspaceTree workspaceTree, RootNode rootNode) {
        super(rootNode);
        if (workspaceTree == null) {
            throw new IllegalArgumentException("Project tree cannot be null.)");
        }
        this.tree = workspaceTree;
        this.rootNode = rootNode;
    }

    @Override
    public RootNode getRoot() {
        return this.rootNode;
    }

    public WorkspaceTree getTree() {
        return this.tree;
    }
}

