/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.projecttree.treenodes;

import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.projecttree.WorkspaceTree;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.projecttree.treenodes.DiffNode;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.projecttree.treenodes.DiffNode$1;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.projecttree.treenodes.RootNode;
import com.google.security.zynamics.bindiff.project.diff.Diff;
import com.google.security.zynamics.bindiff.project.diff.DiffListenerAdapter;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;

class DiffNode$InternalDiffModelListener
extends DiffListenerAdapter {
    final /* synthetic */ DiffNode this$0;

    private DiffNode$InternalDiffModelListener(DiffNode diffNode) {
        this.this$0 = diffNode;
    }

    @Override
    public void loadedDiff(Diff diff) {
        if (diff.isFunctionDiff()) return;
        this.this$0.createChildren();
        this.this$0.getTree().expandPath(new TreePath(this.this$0.getPath()));
    }

    @Override
    public void removedDiff(Diff diff) {
        if (diff.isFunctionDiff()) return;
        this.this$0.removeFromParent();
        this.this$0.delete();
        this.this$0.getTree().setSelectionPath(new TreePath(this.this$0.getRoot().getPath()));
        this.this$0.getTree().updateTree();
    }

    @Override
    public void unloadedDiff(Diff diff) {
        if (diff.isFunctionDiff()) return;
        this.this$0.deleteChildren();
        this.this$0.getTree().setSelectionPath(new TreePath(this.this$0.getPath()));
        this.this$0.getTree().updateTree();
    }

    /* synthetic */ DiffNode$InternalDiffModelListener(DiffNode diffNode, DiffNode$1 diffNode$1) {
        this(diffNode);
    }
}

