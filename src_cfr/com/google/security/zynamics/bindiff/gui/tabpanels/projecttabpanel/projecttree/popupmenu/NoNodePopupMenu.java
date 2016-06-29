/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.projecttree.popupmenu;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.WorkspaceTabPanelFunctions;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.actions.AddDiffAction;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.actions.NewDiffAction;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.projecttree.popupmenu.NoNodePopupMenu$1;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.projecttree.popupmenu.NoNodePopupMenu$InternalWorkspaceListener;
import com.google.security.zynamics.bindiff.project.IWorkspaceListener;
import com.google.security.zynamics.bindiff.project.Workspace;
import com.google.security.zynamics.bindiff.utils.GuiUtils;
import javax.swing.AbstractAction;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

public class NoNodePopupMenu
extends JPopupMenu {
    private final WorkspaceTabPanelFunctions controller;
    private final JMenuItem newDiff;
    private final JMenuItem addDiff;
    private final NoNodePopupMenu$InternalWorkspaceListener workspaceListener;

    public NoNodePopupMenu(WorkspaceTabPanelFunctions workspaceTabPanelFunctions) {
        this.workspaceListener = new NoNodePopupMenu$InternalWorkspaceListener(this, null);
        this.controller = (WorkspaceTabPanelFunctions)Preconditions.checkNotNull(workspaceTabPanelFunctions);
        this.newDiff = GuiUtils.buildMenuItem("New Diff...", 'N', (AbstractAction)new NewDiffAction(workspaceTabPanelFunctions));
        this.addDiff = GuiUtils.buildMenuItem("Add Existing Diff...", 'A', (AbstractAction)new AddDiffAction(workspaceTabPanelFunctions));
        this.add(this.newDiff);
        this.add(this.addDiff);
        this.enableMenu(false);
        workspaceTabPanelFunctions.getWorkspace().addListener(this.workspaceListener);
    }

    private void enableMenu(boolean bl2) {
        this.newDiff.setEnabled(bl2);
        this.addDiff.setEnabled(bl2);
    }

    public void dispose() {
        this.controller.getWorkspace().addListener(this.workspaceListener);
    }

    static /* synthetic */ void access$100(NoNodePopupMenu noNodePopupMenu, boolean bl2) {
        noNodePopupMenu.enableMenu(bl2);
    }
}

