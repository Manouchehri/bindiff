/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.projecttree.popupmenu;

import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.projecttree.popupmenu.NoNodePopupMenu;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.projecttree.popupmenu.NoNodePopupMenu$1;
import com.google.security.zynamics.bindiff.project.Workspace;
import com.google.security.zynamics.bindiff.project.WorkspaceAdapter;

class NoNodePopupMenu$InternalWorkspaceListener
extends WorkspaceAdapter {
    final /* synthetic */ NoNodePopupMenu this$0;

    private NoNodePopupMenu$InternalWorkspaceListener(NoNodePopupMenu noNodePopupMenu) {
        this.this$0 = noNodePopupMenu;
    }

    @Override
    public void closedWorkspace() {
        NoNodePopupMenu.access$100(this.this$0, false);
    }

    @Override
    public void loadedWorkspace(Workspace workspace) {
        NoNodePopupMenu.access$100(this.this$0, true);
    }

    /* synthetic */ NoNodePopupMenu$InternalWorkspaceListener(NoNodePopupMenu noNodePopupMenu, NoNodePopupMenu$1 noNodePopupMenu$1) {
        this(noNodePopupMenu);
    }
}

