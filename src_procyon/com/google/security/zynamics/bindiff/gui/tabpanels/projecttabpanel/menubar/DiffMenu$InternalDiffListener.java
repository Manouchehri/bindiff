package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.menubar;

import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.projecttree.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.*;
import com.google.common.base.*;
import com.google.security.zynamics.bindiff.utils.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.actions.*;
import javax.swing.*;
import java.awt.*;
import com.google.security.zynamics.bindiff.project.*;
import com.google.security.zynamics.bindiff.project.diff.*;

class DiffMenu$InternalDiffListener extends DiffListenerAdapter
{
    final /* synthetic */ DiffMenu this$0;
    
    private DiffMenu$InternalDiffListener(final DiffMenu this$0) {
        this.this$0 = this$0;
    }
    
    @Override
    public void loadedDiff(final Diff diff) {
        this.this$0.openDiff.setEnabled(!diff.isLoaded());
        this.this$0.closeDiff.setEnabled(diff.isLoaded());
    }
    
    @Override
    public void removedDiff(final Diff diff) {
        this.this$0.controller.getWorkspaceTree().removeListener(this.this$0.workspaceTreeListener);
    }
    
    @Override
    public void unloadedDiff(final Diff diff) {
        this.this$0.openDiff.setEnabled(!diff.isLoaded());
        this.this$0.closeDiff.setEnabled(diff.isLoaded());
    }
}
