/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.menubar;

import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.menubar.DiffMenu;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.menubar.DiffMenu$1;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.projecttree.IWorkspaceTreeListener;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.projecttree.treenodes.AbstractTreeNode;
import com.google.security.zynamics.bindiff.project.diff.Diff;

class DiffMenu$InternalWorkspaceTreeListener
implements IWorkspaceTreeListener {
    final /* synthetic */ DiffMenu this$0;

    private DiffMenu$InternalWorkspaceTreeListener(DiffMenu diffMenu) {
        this.this$0 = diffMenu;
    }

    @Override
    public void changedSelection(AbstractTreeNode abstractTreeNode) {
        Diff diff = abstractTreeNode.getDiff();
        if (diff == null) {
            DiffMenu.access$800(this.this$0).setEnabled(true);
            DiffMenu.access$900(this.this$0).setEnabled(true);
            DiffMenu.access$300(this.this$0).setEnabled(false);
            DiffMenu.access$400(this.this$0).setEnabled(false);
            DiffMenu.access$1000(this.this$0).setEnabled(false);
            DiffMenu.access$700(this.this$0);
            return;
        }
        DiffMenu.access$300(this.this$0).setEnabled(!diff.isLoaded());
        DiffMenu.access$400(this.this$0).setEnabled(diff.isLoaded());
        DiffMenu.access$1000(this.this$0).setEnabled(diff.isLoaded());
        DiffMenu.access$1100(this.this$0, diff);
    }

    /* synthetic */ DiffMenu$InternalWorkspaceTreeListener(DiffMenu diffMenu, DiffMenu$1 diffMenu$1) {
        this(diffMenu);
    }
}

