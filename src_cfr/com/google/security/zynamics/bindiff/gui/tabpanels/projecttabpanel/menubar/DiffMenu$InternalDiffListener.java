/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.menubar;

import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.menubar.DiffMenu;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.menubar.DiffMenu$1;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.projecttree.IWorkspaceTreeListener;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.projecttree.WorkspaceTree;
import com.google.security.zynamics.bindiff.project.diff.Diff;
import com.google.security.zynamics.bindiff.project.diff.DiffListenerAdapter;

class DiffMenu$InternalDiffListener
extends DiffListenerAdapter {
    final /* synthetic */ DiffMenu this$0;

    private DiffMenu$InternalDiffListener(DiffMenu diffMenu) {
        this.this$0 = diffMenu;
    }

    @Override
    public void loadedDiff(Diff diff) {
        DiffMenu.access$300(this.this$0).setEnabled(!diff.isLoaded());
        DiffMenu.access$400(this.this$0).setEnabled(diff.isLoaded());
    }

    @Override
    public void removedDiff(Diff diff) {
        DiffMenu.access$600(this.this$0).getWorkspaceTree().removeListener(DiffMenu.access$500(this.this$0));
    }

    @Override
    public void unloadedDiff(Diff diff) {
        DiffMenu.access$300(this.this$0).setEnabled(!diff.isLoaded());
        DiffMenu.access$400(this.this$0).setEnabled(diff.isLoaded());
    }

    /* synthetic */ DiffMenu$InternalDiffListener(DiffMenu diffMenu, DiffMenu$1 diffMenu$1) {
        this(diffMenu);
    }
}

