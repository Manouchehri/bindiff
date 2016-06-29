/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.actions;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.gui.tabpanels.TabPanelManager;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.WorkspaceTabPanelFunctions;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.ViewTabPanel;
import com.google.security.zynamics.bindiff.gui.window.CWindowFunctions;
import com.google.security.zynamics.bindiff.gui.window.MainWindow;
import java.awt.event.ActionEvent;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.swing.AbstractAction;

public class CloseAllViewsAction
extends AbstractAction {
    private final WorkspaceTabPanelFunctions controller;
    private final ViewTabPanel dontClosePanel;

    public CloseAllViewsAction(WorkspaceTabPanelFunctions workspaceTabPanelFunctions) {
        this(workspaceTabPanelFunctions, null);
    }

    public CloseAllViewsAction(WorkspaceTabPanelFunctions workspaceTabPanelFunctions, ViewTabPanel viewTabPanel) {
        this.controller = (WorkspaceTabPanelFunctions)Preconditions.checkNotNull(workspaceTabPanelFunctions);
        this.dontClosePanel = viewTabPanel;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        LinkedHashSet<ViewTabPanel> linkedHashSet = new LinkedHashSet<ViewTabPanel>();
        TabPanelManager tabPanelManager = this.controller.getMainWindow().getController().getTabPanelManager();
        Iterator iterator = tabPanelManager.getViewTabPanels().iterator();
        do {
            if (!iterator.hasNext()) {
                this.controller.closeViews(linkedHashSet);
                return;
            }
            ViewTabPanel viewTabPanel = (ViewTabPanel)iterator.next();
            if (this.dontClosePanel != null && this.dontClosePanel == viewTabPanel) continue;
            linkedHashSet.add(viewTabPanel);
        } while (true);
    }
}

