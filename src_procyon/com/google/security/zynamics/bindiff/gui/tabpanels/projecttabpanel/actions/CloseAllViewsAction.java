package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.actions;

import javax.swing.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.*;
import com.google.common.base.*;
import java.awt.event.*;
import java.util.*;

public class CloseAllViewsAction extends AbstractAction
{
    private final WorkspaceTabPanelFunctions controller;
    private final ViewTabPanel dontClosePanel;
    
    public CloseAllViewsAction(final WorkspaceTabPanelFunctions workspaceTabPanelFunctions) {
        this(workspaceTabPanelFunctions, null);
    }
    
    public CloseAllViewsAction(final WorkspaceTabPanelFunctions workspaceTabPanelFunctions, final ViewTabPanel dontClosePanel) {
        this.controller = (WorkspaceTabPanelFunctions)Preconditions.checkNotNull(workspaceTabPanelFunctions);
        this.dontClosePanel = dontClosePanel;
    }
    
    @Override
    public void actionPerformed(final ActionEvent actionEvent) {
        final LinkedHashSet<ViewTabPanel> set = new LinkedHashSet<ViewTabPanel>();
        for (final ViewTabPanel viewTabPanel : this.controller.getMainWindow().getController().getTabPanelManager().getViewTabPanels()) {
            if (this.dontClosePanel != null && this.dontClosePanel == viewTabPanel) {
                continue;
            }
            set.add(viewTabPanel);
        }
        this.controller.closeViews(set);
    }
}
