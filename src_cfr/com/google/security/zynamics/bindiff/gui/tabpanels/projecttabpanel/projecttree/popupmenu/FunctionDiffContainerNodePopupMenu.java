/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.projecttree.popupmenu;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.gui.tabpanels.TabPanelManager;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.WorkspaceTabPanelFunctions;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.actions.CloseFunctionDiffsAction;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.actions.CloseFunctionDiffsViewsAction;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.actions.LoadFunctionDiffsAction;
import com.google.security.zynamics.bindiff.gui.window.CWindowFunctions;
import com.google.security.zynamics.bindiff.gui.window.MainWindow;
import com.google.security.zynamics.bindiff.project.Workspace;
import com.google.security.zynamics.bindiff.project.diff.Diff;
import com.google.security.zynamics.bindiff.utils.GuiUtils;
import java.awt.Component;
import java.util.Iterator;
import java.util.List;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JSeparator;

public class FunctionDiffContainerNodePopupMenu
extends JPopupMenu {
    public FunctionDiffContainerNodePopupMenu(WorkspaceTabPanelFunctions workspaceTabPanelFunctions) {
        Preconditions.checkNotNull(workspaceTabPanelFunctions);
        this.add(GuiUtils.buildMenuItem("Open Function Diffs", new LoadFunctionDiffsAction(workspaceTabPanelFunctions), this.isOpenDiffsEnabled(workspaceTabPanelFunctions)));
        this.add(GuiUtils.buildMenuItem("Close Function Diffs", new CloseFunctionDiffsAction(workspaceTabPanelFunctions), this.isCloseDiffsEnabled(workspaceTabPanelFunctions)));
        this.add(new JSeparator());
        this.add(GuiUtils.buildMenuItem("Close Function Diff Views", new CloseFunctionDiffsViewsAction(workspaceTabPanelFunctions), this.isCloseViewsEnabled(workspaceTabPanelFunctions)));
    }

    private boolean isCloseDiffsEnabled(WorkspaceTabPanelFunctions workspaceTabPanelFunctions) {
        Diff diff;
        Iterator iterator = workspaceTabPanelFunctions.getWorkspace().getDiffList(true).iterator();
        do {
            if (!iterator.hasNext()) return false;
        } while (!(diff = (Diff)iterator.next()).isLoaded());
        return true;
    }

    private boolean isCloseViewsEnabled(WorkspaceTabPanelFunctions workspaceTabPanelFunctions) {
        TabPanelManager tabPanelManager = workspaceTabPanelFunctions.getMainWindow().getController().getTabPanelManager();
        if (tabPanelManager.getViewTabPanels(true).size() <= 0) return false;
        return true;
    }

    private boolean isOpenDiffsEnabled(WorkspaceTabPanelFunctions workspaceTabPanelFunctions) {
        Diff diff;
        Iterator iterator = workspaceTabPanelFunctions.getWorkspace().getDiffList(true).iterator();
        do {
            if (!iterator.hasNext()) return false;
        } while ((diff = (Diff)iterator.next()).isLoaded());
        return true;
    }
}

