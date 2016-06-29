/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.actions;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.WorkspaceTabPanelFunctions;
import com.google.security.zynamics.bindiff.project.diff.Diff;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;

public class LoadDiffAction
extends AbstractAction {
    private final WorkspaceTabPanelFunctions controller;

    public LoadDiffAction(WorkspaceTabPanelFunctions workspaceTabPanelFunctions) {
        this.controller = (WorkspaceTabPanelFunctions)Preconditions.checkNotNull(workspaceTabPanelFunctions);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        this.controller.loadDiff(null);
    }
}

