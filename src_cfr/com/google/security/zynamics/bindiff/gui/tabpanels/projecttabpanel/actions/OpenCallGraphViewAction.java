/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.actions;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.WorkspaceTabPanelFunctions;
import com.google.security.zynamics.bindiff.gui.window.MainWindow;
import com.google.security.zynamics.bindiff.project.diff.Diff;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;

public class OpenCallGraphViewAction
extends AbstractAction {
    private final WorkspaceTabPanelFunctions controller;
    private final Diff diff;

    public OpenCallGraphViewAction(WorkspaceTabPanelFunctions workspaceTabPanelFunctions, Diff diff) {
        this.controller = (WorkspaceTabPanelFunctions)Preconditions.checkNotNull(workspaceTabPanelFunctions);
        this.diff = (Diff)Preconditions.checkNotNull(diff);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        this.controller.openCallgraphView(this.controller.getMainWindow(), this.diff);
    }
}

