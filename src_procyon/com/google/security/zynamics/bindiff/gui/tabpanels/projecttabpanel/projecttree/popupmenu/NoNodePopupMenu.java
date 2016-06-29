package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.projecttree.popupmenu;

import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.*;
import com.google.common.base.*;
import com.google.security.zynamics.bindiff.utils.*;
import javax.swing.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.actions.*;
import com.google.security.zynamics.bindiff.project.*;

public class NoNodePopupMenu extends JPopupMenu
{
    private final WorkspaceTabPanelFunctions controller;
    private final JMenuItem newDiff;
    private final JMenuItem addDiff;
    private final NoNodePopupMenu$InternalWorkspaceListener workspaceListener;
    
    public NoNodePopupMenu(final WorkspaceTabPanelFunctions workspaceTabPanelFunctions) {
        this.workspaceListener = new NoNodePopupMenu$InternalWorkspaceListener(this, null);
        this.controller = (WorkspaceTabPanelFunctions)Preconditions.checkNotNull(workspaceTabPanelFunctions);
        this.newDiff = GuiUtils.buildMenuItem("New Diff...", 'N', new NewDiffAction(workspaceTabPanelFunctions));
        this.addDiff = GuiUtils.buildMenuItem("Add Existing Diff...", 'A', new AddDiffAction(workspaceTabPanelFunctions));
        this.add(this.newDiff);
        this.add(this.addDiff);
        this.enableMenu(false);
        workspaceTabPanelFunctions.getWorkspace().addListener(this.workspaceListener);
    }
    
    private void enableMenu(final boolean b) {
        this.newDiff.setEnabled(b);
        this.addDiff.setEnabled(b);
    }
    
    public void dispose() {
        this.controller.getWorkspace().addListener(this.workspaceListener);
    }
}
