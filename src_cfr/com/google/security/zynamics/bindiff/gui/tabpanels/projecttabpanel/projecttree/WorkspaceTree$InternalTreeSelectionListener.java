/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.projecttree;

import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.projecttree.IWorkspaceTreeListener;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.projecttree.WorkspaceTree;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.projecttree.WorkspaceTree$1;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.projecttree.treenodes.AbstractTreeNode;
import com.google.security.zynamics.zylib.gui.jtree.TreeHelpers;
import java.util.Iterator;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;

class WorkspaceTree$InternalTreeSelectionListener
implements TreeSelectionListener {
    private DefaultMutableTreeNode lastNode;
    final /* synthetic */ WorkspaceTree this$0;

    private WorkspaceTree$InternalTreeSelectionListener(WorkspaceTree workspaceTree) {
        this.this$0 = workspaceTree;
        this.lastNode = null;
    }

    @Override
    public void valueChanged(TreeSelectionEvent treeSelectionEvent) {
        AbstractTreeNode abstractTreeNode = (AbstractTreeNode)this.this$0.getLastSelectedPathComponent();
        if (abstractTreeNode != null) {
            WorkspaceTree.access$500(this.this$0, abstractTreeNode);
            this.lastNode = abstractTreeNode;
        } else if (this.lastNode == null || !TreeHelpers.isAncestor(this.lastNode, WorkspaceTree.access$600(this.this$0))) {
            WorkspaceTree.access$500(this.this$0, WorkspaceTree.access$600(this.this$0));
        }
        Iterator iterator = WorkspaceTree.access$700(this.this$0).iterator();
        while (iterator.hasNext()) {
            IWorkspaceTreeListener iWorkspaceTreeListener = (IWorkspaceTreeListener)iterator.next();
            iWorkspaceTreeListener.changedSelection(abstractTreeNode != null ? abstractTreeNode : WorkspaceTree.access$600(this.this$0));
        }
    }

    /* synthetic */ WorkspaceTree$InternalTreeSelectionListener(WorkspaceTree workspaceTree, WorkspaceTree$1 workspaceTree$1) {
        this(workspaceTree);
    }
}

