/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.projecttree.popupmenu;

import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.projecttree.IWorkspaceTreeListener;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.projecttree.WorkspaceTree;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.projecttree.popupmenu.NodePopupMenu;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.projecttree.popupmenu.NodePopupMenu$1;
import com.google.security.zynamics.bindiff.project.diff.Diff;
import com.google.security.zynamics.bindiff.project.diff.DiffListenerAdapter;
import com.google.security.zynamics.bindiff.project.matches.MatchData;

class NodePopupMenu$InternalDiffListener
extends DiffListenerAdapter {
    final /* synthetic */ NodePopupMenu this$0;

    private NodePopupMenu$InternalDiffListener(NodePopupMenu nodePopupMenu) {
        this.this$0 = nodePopupMenu;
    }

    @Override
    public void closedView(Diff diff) {
        NodePopupMenu.access$200(this.this$0, diff);
    }

    @Override
    public void loadedDiff(Diff diff) {
        NodePopupMenu.access$200(this.this$0, diff);
        if (diff.getMatches() != null) return;
        NodePopupMenu.access$300(this.this$0).setEnabled(false);
    }

    @Override
    public void loadedView(Diff diff) {
        NodePopupMenu.access$200(this.this$0, diff);
    }

    @Override
    public void removedDiff(Diff diff) {
        NodePopupMenu.access$200(this.this$0, diff);
        NodePopupMenu.access$400(this.this$0);
        NodePopupMenu.access$600(this.this$0).getWorkspaceTree().removeListener(NodePopupMenu.access$500(this.this$0));
    }

    @Override
    public void unloadedDiff(Diff diff) {
        NodePopupMenu.access$200(this.this$0, diff);
    }

    /* synthetic */ NodePopupMenu$InternalDiffListener(NodePopupMenu nodePopupMenu, NodePopupMenu$1 nodePopupMenu$1) {
        this(nodePopupMenu);
    }
}

