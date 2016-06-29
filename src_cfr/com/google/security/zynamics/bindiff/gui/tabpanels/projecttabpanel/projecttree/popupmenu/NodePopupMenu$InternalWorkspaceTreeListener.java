/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.projecttree.popupmenu;

import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.projecttree.IWorkspaceTreeListener;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.projecttree.popupmenu.NodePopupMenu;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.projecttree.popupmenu.NodePopupMenu$1;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.projecttree.treenodes.AbstractTreeNode;
import com.google.security.zynamics.bindiff.project.diff.Diff;

class NodePopupMenu$InternalWorkspaceTreeListener
implements IWorkspaceTreeListener {
    final /* synthetic */ NodePopupMenu this$0;

    private NodePopupMenu$InternalWorkspaceTreeListener(NodePopupMenu nodePopupMenu) {
        this.this$0 = nodePopupMenu;
    }

    @Override
    public void changedSelection(AbstractTreeNode abstractTreeNode) {
        Diff diff = abstractTreeNode.getDiff();
        if (diff == null) {
            NodePopupMenu.access$300(this.this$0).setEnabled(false);
            NodePopupMenu.access$700(this.this$0).setEnabled(false);
            NodePopupMenu.access$800(this.this$0).setEnabled(false);
            NodePopupMenu.access$900(this.this$0).setEnabled(false);
            NodePopupMenu.access$400(this.this$0);
            return;
        }
        NodePopupMenu.access$200(this.this$0, diff);
        NodePopupMenu.access$1000(this.this$0, diff);
    }

    /* synthetic */ NodePopupMenu$InternalWorkspaceTreeListener(NodePopupMenu nodePopupMenu, NodePopupMenu$1 nodePopupMenu$1) {
        this(nodePopupMenu);
    }
}

