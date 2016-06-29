/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.actions;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.WorkspaceTabPanelFunctions;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;

public class InitialFlowGraphSettingsAction
extends AbstractAction {
    private final WorkspaceTabPanelFunctions controller;

    public InitialFlowGraphSettingsAction(WorkspaceTabPanelFunctions workspaceTabPanelFunctions) {
        this.controller = (WorkspaceTabPanelFunctions)Preconditions.checkNotNull(workspaceTabPanelFunctions);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        this.controller.showInitialFlowgraphSettingsDialog();
    }
}

