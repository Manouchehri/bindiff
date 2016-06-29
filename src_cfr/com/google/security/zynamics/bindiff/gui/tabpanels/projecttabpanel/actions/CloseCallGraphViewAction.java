/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.actions;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.gui.tabpanels.TabPanelManager;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.WorkspaceTabPanelFunctions;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.ViewTabPanel;
import com.google.security.zynamics.bindiff.gui.window.CWindowFunctions;
import com.google.security.zynamics.bindiff.gui.window.MainWindow;
import com.google.security.zynamics.bindiff.project.diff.Diff;
import com.google.security.zynamics.zylib.disassembly.IAddress;
import java.awt.event.ActionEvent;
import java.util.HashSet;
import java.util.Set;
import javax.swing.AbstractAction;

public class CloseCallGraphViewAction
extends AbstractAction {
    private final WorkspaceTabPanelFunctions controller;
    private final Diff diff;

    public CloseCallGraphViewAction(WorkspaceTabPanelFunctions workspaceTabPanelFunctions, Diff diff) {
        this.controller = (WorkspaceTabPanelFunctions)Preconditions.checkNotNull(workspaceTabPanelFunctions);
        this.diff = (Diff)Preconditions.checkNotNull(diff);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        TabPanelManager tabPanelManager = this.controller.getMainWindow().getController().getTabPanelManager();
        ViewTabPanel viewTabPanel = tabPanelManager.getTabPanel(null, null, this.diff);
        if (viewTabPanel == null) return;
        HashSet<ViewTabPanel> hashSet = new HashSet<ViewTabPanel>();
        hashSet.add(viewTabPanel);
        this.controller.closeViews(hashSet);
    }
}

