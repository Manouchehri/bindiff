package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.actions;

import javax.swing.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.*;
import com.google.common.base.*;
import java.awt.event.*;
import com.google.security.zynamics.bindiff.project.diff.*;

public class DeleteDiffAction extends AbstractAction
{
    private final WorkspaceTabPanelFunctions controller;
    
    public DeleteDiffAction(final WorkspaceTabPanelFunctions workspaceTabPanelFunctions) {
        this.controller = (WorkspaceTabPanelFunctions)Preconditions.checkNotNull(workspaceTabPanelFunctions);
    }
    
    @Override
    public void actionPerformed(final ActionEvent actionEvent) {
        this.controller.deleteDiff(null);
    }
}
