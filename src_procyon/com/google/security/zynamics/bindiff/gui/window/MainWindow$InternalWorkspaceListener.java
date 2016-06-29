package com.google.security.zynamics.bindiff.gui.window;

import javax.swing.*;
import com.google.common.base.*;
import com.google.security.zynamics.bindiff.project.*;
import java.awt.event.*;
import com.google.security.zynamics.bindiff.config.*;
import com.google.security.zynamics.bindiff.utils.*;
import com.google.security.zynamics.zylib.io.*;
import java.awt.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.detachedviewstabpanel.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.*;

class MainWindow$InternalWorkspaceListener extends WorkspaceAdapter
{
    final /* synthetic */ MainWindow this$0;
    
    private MainWindow$InternalWorkspaceListener(final MainWindow this$0) {
        this.this$0 = this$0;
    }
    
    @Override
    public void closedWorkspace() {
        this.this$0.setTitle("");
    }
    
    @Override
    public void loadedWorkspace(final Workspace workspace) {
        this.this$0.setTitle(workspace.getWorkspaceFilePath());
        this.this$0.titlePath = workspace.getWorkspaceFilePath();
        this.this$0.updateEllipsis();
    }
}
