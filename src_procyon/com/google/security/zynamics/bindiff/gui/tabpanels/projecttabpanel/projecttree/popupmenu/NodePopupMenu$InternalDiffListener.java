package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.projecttree.popupmenu;

import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.projecttree.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.*;
import com.google.common.base.*;
import com.google.security.zynamics.bindiff.utils.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.actions.*;
import javax.swing.*;
import java.awt.*;
import com.google.security.zynamics.bindiff.project.diff.*;
import java.util.*;

class NodePopupMenu$InternalDiffListener extends DiffListenerAdapter
{
    final /* synthetic */ NodePopupMenu this$0;
    
    private NodePopupMenu$InternalDiffListener(final NodePopupMenu this$0) {
        this.this$0 = this$0;
    }
    
    @Override
    public void closedView(final Diff diff) {
        this.this$0.updateMenu(diff);
    }
    
    @Override
    public void loadedDiff(final Diff diff) {
        this.this$0.updateMenu(diff);
        if (diff.getMatches() == null) {
            this.this$0.openDiff.setEnabled(false);
        }
    }
    
    @Override
    public void loadedView(final Diff diff) {
        this.this$0.updateMenu(diff);
    }
    
    @Override
    public void removedDiff(final Diff diff) {
        this.this$0.updateMenu(diff);
        this.this$0.unregisterCurrentDiffListener();
        this.this$0.controller.getWorkspaceTree().removeListener(this.this$0.workspaceTreeListener);
    }
    
    @Override
    public void unloadedDiff(final Diff diff) {
        this.this$0.updateMenu(diff);
    }
}
