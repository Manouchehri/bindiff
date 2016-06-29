package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.actions;

import javax.swing.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.*;
import com.google.security.zynamics.bindiff.project.diff.*;
import com.google.common.base.*;
import java.awt.event.*;
import com.google.security.zynamics.zylib.disassembly.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.*;
import java.util.*;

public class CloseCallGraphViewAction extends AbstractAction
{
    private final WorkspaceTabPanelFunctions controller;
    private final Diff diff;
    
    public CloseCallGraphViewAction(final WorkspaceTabPanelFunctions workspaceTabPanelFunctions, final Diff diff) {
        this.controller = (WorkspaceTabPanelFunctions)Preconditions.checkNotNull(workspaceTabPanelFunctions);
        this.diff = (Diff)Preconditions.checkNotNull(diff);
    }
    
    @Override
    public void actionPerformed(final ActionEvent actionEvent) {
        final ViewTabPanel tabPanel = this.controller.getMainWindow().getController().getTabPanelManager().getTabPanel(null, null, this.diff);
        if (tabPanel != null) {
            final HashSet<ViewTabPanel> set = new HashSet<ViewTabPanel>();
            set.add(tabPanel);
            this.controller.closeViews(set);
        }
    }
}
