package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.projecttree.popupmenu;

import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.*;
import com.google.common.base.*;
import com.google.security.zynamics.bindiff.utils.*;
import javax.swing.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.actions.*;
import com.google.security.zynamics.bindiff.project.*;

class NoNodePopupMenu$InternalWorkspaceListener extends WorkspaceAdapter
{
    final /* synthetic */ NoNodePopupMenu this$0;
    
    private NoNodePopupMenu$InternalWorkspaceListener(final NoNodePopupMenu this$0) {
        this.this$0 = this$0;
    }
    
    @Override
    public void closedWorkspace() {
        this.this$0.enableMenu(false);
    }
    
    @Override
    public void loadedWorkspace(final Workspace workspace) {
        this.this$0.enableMenu(true);
    }
}
