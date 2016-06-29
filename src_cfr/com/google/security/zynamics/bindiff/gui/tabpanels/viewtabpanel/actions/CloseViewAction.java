/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.actions;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.gui.tabpanels.TabPanelManager;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.WorkspaceTabPanel;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.WorkspaceTabPanelFunctions;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.ViewTabPanel;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.ViewTabPanelFunctions;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.util.LinkedHashSet;
import java.util.Set;
import javax.swing.AbstractAction;
import javax.swing.JTabbedPane;

public class CloseViewAction
extends AbstractAction {
    private final ViewTabPanelFunctions controller;
    private ViewTabPanel viewPanel;

    public CloseViewAction(ViewTabPanel viewTabPanel) {
        this.controller = null;
        this.viewPanel = (ViewTabPanel)Preconditions.checkNotNull(viewTabPanel);
    }

    public CloseViewAction(ViewTabPanelFunctions viewTabPanelFunctions) {
        this.controller = (ViewTabPanelFunctions)Preconditions.checkNotNull(viewTabPanelFunctions);
        this.viewPanel = null;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        this.execute();
    }

    public void execute() {
        Object object;
        if (this.controller != null) {
            object = this.controller.getTabPanelManager().getTabbedPane();
            this.viewPanel = object.getSelectedIndex() > 0 ? (ViewTabPanel)object.getSelectedComponent() : null;
        }
        if (this.viewPanel == null) return;
        object = this.viewPanel.getController().getTabPanelManager();
        WorkspaceTabPanelFunctions workspaceTabPanelFunctions = object.getWorkspaceTabPanel().getController();
        LinkedHashSet<ViewTabPanel> linkedHashSet = new LinkedHashSet<ViewTabPanel>();
        linkedHashSet.add(this.viewPanel);
        workspaceTabPanelFunctions.closeViews(linkedHashSet);
    }
}

