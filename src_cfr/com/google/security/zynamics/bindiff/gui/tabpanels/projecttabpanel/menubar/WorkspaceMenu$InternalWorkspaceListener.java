/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.menubar;

import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.menubar.WorkspaceMenu;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.menubar.WorkspaceMenu$1;
import com.google.security.zynamics.bindiff.project.Workspace;
import com.google.security.zynamics.bindiff.project.WorkspaceAdapter;

class WorkspaceMenu$InternalWorkspaceListener
extends WorkspaceAdapter {
    final /* synthetic */ WorkspaceMenu this$0;

    private WorkspaceMenu$InternalWorkspaceListener(WorkspaceMenu workspaceMenu) {
        this.this$0 = workspaceMenu;
    }

    @Override
    public void closedWorkspace() {
        this.this$0.enableSubmenus(false);
    }

    @Override
    public void loadedWorkspace(Workspace workspace) {
        this.this$0.enableSubmenus(true);
        String string = workspace.getWorkspaceFilePath();
        if (string.isEmpty()) {
            return;
        }
        int n2 = WorkspaceMenu.access$200(this.this$0).indexOf(string);
        if (n2 >= 0) {
            String string2 = (String)WorkspaceMenu.access$200(this.this$0).get(0);
            WorkspaceMenu.access$200(this.this$0).set(0, WorkspaceMenu.access$200(this.this$0).get(n2));
            WorkspaceMenu.access$200(this.this$0).set(n2, string2);
        } else {
            WorkspaceMenu.access$200(this.this$0).remove(3);
            WorkspaceMenu.access$200(this.this$0).add(0, string);
        }
        WorkspaceMenu.access$300(this.this$0);
    }

    /* synthetic */ WorkspaceMenu$InternalWorkspaceListener(WorkspaceMenu workspaceMenu, WorkspaceMenu$1 workspaceMenu$1) {
        this(workspaceMenu);
    }
}

