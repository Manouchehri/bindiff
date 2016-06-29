package com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.actions;

import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.*;
import com.google.common.base.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.*;

public class CloseViewAction extends AbstractAction
{
    private final ViewTabPanelFunctions controller;
    private ViewTabPanel viewPanel;
    
    public CloseViewAction(final ViewTabPanel viewTabPanel) {
        this.controller = null;
        this.viewPanel = (ViewTabPanel)Preconditions.checkNotNull(viewTabPanel);
    }
    
    public CloseViewAction(final ViewTabPanelFunctions viewTabPanelFunctions) {
        this.controller = (ViewTabPanelFunctions)Preconditions.checkNotNull(viewTabPanelFunctions);
        this.viewPanel = null;
    }
    
    @Override
    public void actionPerformed(final ActionEvent actionEvent) {
        this.execute();
    }
    
    public void execute() {
        if (this.controller != null) {
            final JTabbedPane tabbedPane = this.controller.getTabPanelManager().getTabbedPane();
            this.viewPanel = ((tabbedPane.getSelectedIndex() > 0) ? ((ViewTabPanel)tabbedPane.getSelectedComponent()) : null);
        }
        if (this.viewPanel != null) {
            final WorkspaceTabPanelFunctions controller = this.viewPanel.getController().getTabPanelManager().getWorkspaceTabPanel().getController();
            final LinkedHashSet<ViewTabPanel> set = new LinkedHashSet<ViewTabPanel>();
            set.add(this.viewPanel);
            controller.closeViews(set);
        }
    }
}
