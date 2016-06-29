/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.menubar;

import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.menubar.DiffMenu;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.menubar.DiffMenu$1;
import com.google.security.zynamics.bindiff.project.Workspace;
import com.google.security.zynamics.bindiff.project.WorkspaceAdapter;

class DiffMenu$InternalWorkspaceListener
extends WorkspaceAdapter {
    final /* synthetic */ DiffMenu this$0;

    private DiffMenu$InternalWorkspaceListener(DiffMenu diffMenu) {
        this.this$0 = diffMenu;
    }

    @Override
    public void closedWorkspace() {
        this.this$0.setEnabled(false);
        DiffMenu.access$700(this.this$0);
    }

    @Override
    public void loadedWorkspace(Workspace workspace) {
        this.this$0.setEnabled(true);
        DiffMenu.access$800(this.this$0).setEnabled(true);
        DiffMenu.access$900(this.this$0).setEnabled(true);
        DiffMenu.access$300(this.this$0).setEnabled(false);
        DiffMenu.access$400(this.this$0).setEnabled(false);
        DiffMenu.access$1000(this.this$0).setEnabled(false);
    }

    /* synthetic */ DiffMenu$InternalWorkspaceListener(DiffMenu diffMenu, DiffMenu$1 diffMenu$1) {
        this(diffMenu);
    }
}

