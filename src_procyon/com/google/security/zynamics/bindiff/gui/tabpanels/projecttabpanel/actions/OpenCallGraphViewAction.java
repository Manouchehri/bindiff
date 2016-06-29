package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.actions;

import javax.swing.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.*;
import com.google.security.zynamics.bindiff.project.diff.*;
import com.google.common.base.*;
import java.awt.event.*;

public class OpenCallGraphViewAction extends AbstractAction
{
    private final WorkspaceTabPanelFunctions controller;
    private final Diff diff;
    
    public OpenCallGraphViewAction(final WorkspaceTabPanelFunctions workspaceTabPanelFunctions, final Diff diff) {
        this.controller = (WorkspaceTabPanelFunctions)Preconditions.checkNotNull(workspaceTabPanelFunctions);
        this.diff = (Diff)Preconditions.checkNotNull(diff);
    }
    
    @Override
    public void actionPerformed(final ActionEvent actionEvent) {
        this.controller.openCallgraphView(this.controller.getMainWindow(), this.diff);
    }
}
