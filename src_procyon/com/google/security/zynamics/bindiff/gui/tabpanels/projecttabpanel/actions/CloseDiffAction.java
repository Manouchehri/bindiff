package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.actions;

import javax.swing.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.*;
import com.google.common.base.*;
import java.awt.event.*;
import com.google.security.zynamics.bindiff.project.diff.*;
import java.util.*;

public class CloseDiffAction extends AbstractAction
{
    private final WorkspaceTabPanelFunctions controller;
    
    public CloseDiffAction(final WorkspaceTabPanelFunctions workspaceTabPanelFunctions) {
        this.controller = (WorkspaceTabPanelFunctions)Preconditions.checkNotNull(workspaceTabPanelFunctions);
    }
    
    @Override
    public void actionPerformed(final ActionEvent actionEvent) {
        final HashSet<Diff> set = new HashSet<Diff>();
        set.add(this.controller.getSelectedDiff());
        this.controller.closeDiffs(set);
    }
}
