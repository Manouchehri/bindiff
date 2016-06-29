/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.window;

import com.google.security.zynamics.bindiff.gui.window.MainWindow;
import com.google.security.zynamics.bindiff.gui.window.MainWindow$1;
import com.google.security.zynamics.bindiff.project.Workspace;
import com.google.security.zynamics.bindiff.project.WorkspaceAdapter;

class MainWindow$InternalWorkspaceListener
extends WorkspaceAdapter {
    final /* synthetic */ MainWindow this$0;

    private MainWindow$InternalWorkspaceListener(MainWindow mainWindow) {
        this.this$0 = mainWindow;
    }

    @Override
    public void closedWorkspace() {
        this.this$0.setTitle("");
    }

    @Override
    public void loadedWorkspace(Workspace workspace) {
        this.this$0.setTitle(workspace.getWorkspaceFilePath());
        MainWindow.access$502(this.this$0, workspace.getWorkspaceFilePath());
        MainWindow.access$200(this.this$0);
    }

    /* synthetic */ MainWindow$InternalWorkspaceListener(MainWindow mainWindow, MainWindow$1 mainWindow$1) {
        this(mainWindow);
    }
}

