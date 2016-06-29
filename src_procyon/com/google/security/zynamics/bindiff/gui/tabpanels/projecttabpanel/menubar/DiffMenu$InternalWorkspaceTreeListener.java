package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.menubar;

import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.projecttree.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.projecttree.treenodes.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.*;
import com.google.common.base.*;
import com.google.security.zynamics.bindiff.utils.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.actions.*;
import javax.swing.*;
import java.awt.*;
import com.google.security.zynamics.bindiff.project.*;
import com.google.security.zynamics.bindiff.project.diff.*;

class DiffMenu$InternalWorkspaceTreeListener implements IWorkspaceTreeListener
{
    final /* synthetic */ DiffMenu this$0;
    
    private DiffMenu$InternalWorkspaceTreeListener(final DiffMenu this$0) {
        this.this$0 = this$0;
    }
    
    @Override
    public void changedSelection(final AbstractTreeNode abstractTreeNode) {
        final Diff diff = abstractTreeNode.getDiff();
        if (diff == null) {
            this.this$0.newDiff.setEnabled(true);
            this.this$0.addDiff.setEnabled(true);
            this.this$0.openDiff.setEnabled(false);
            this.this$0.closeDiff.setEnabled(false);
            this.this$0.deleteDiff.setEnabled(false);
            this.this$0.unregisterCurrentDiffListener();
        }
        else {
            this.this$0.openDiff.setEnabled(!diff.isLoaded());
            this.this$0.closeDiff.setEnabled(diff.isLoaded());
            this.this$0.deleteDiff.setEnabled(diff.isLoaded());
            this.this$0.registerCurrentDiffListener(diff);
        }
    }
}
