package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.menubar;

import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.*;
import com.google.common.base.*;
import com.google.security.zynamics.bindiff.project.*;
import com.google.security.zynamics.bindiff.utils.*;
import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.io.*;
import com.google.security.zynamics.bindiff.config.*;

class WorkspaceMenu$InternalWorkspaceListener extends WorkspaceAdapter
{
    final /* synthetic */ WorkspaceMenu this$0;
    
    private WorkspaceMenu$InternalWorkspaceListener(final WorkspaceMenu this$0) {
        this.this$0 = this$0;
    }
    
    @Override
    public void closedWorkspace() {
        this.this$0.enableSubmenus(false);
    }
    
    @Override
    public void loadedWorkspace(final Workspace workspace) {
        this.this$0.enableSubmenus(true);
        final String workspaceFilePath = workspace.getWorkspaceFilePath();
        if (workspaceFilePath.isEmpty()) {
            return;
        }
        final int index = this.this$0.recentWorkspaces.indexOf(workspaceFilePath);
        if (index >= 0) {
            final String s = this.this$0.recentWorkspaces.get(0);
            this.this$0.recentWorkspaces.set(0, this.this$0.recentWorkspaces.get(index));
            this.this$0.recentWorkspaces.set(index, s);
        }
        else {
            this.this$0.recentWorkspaces.remove(3);
            this.this$0.recentWorkspaces.add(0, workspaceFilePath);
        }
        this.this$0.updateworkspaceMenu();
    }
}
