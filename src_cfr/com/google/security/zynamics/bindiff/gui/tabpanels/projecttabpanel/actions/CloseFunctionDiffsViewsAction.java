/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.actions;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.gui.tabpanels.TabPanelManager;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.WorkspaceTabPanelFunctions;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.AbstractTable;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.FunctionDiffViewsTable;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.ViewTabPanel;
import com.google.security.zynamics.bindiff.gui.window.CWindowFunctions;
import com.google.security.zynamics.bindiff.gui.window.MainWindow;
import com.google.security.zynamics.bindiff.project.diff.Diff;
import java.awt.event.ActionEvent;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.swing.AbstractAction;

public class CloseFunctionDiffsViewsAction
extends AbstractAction {
    private final WorkspaceTabPanelFunctions controller;
    private final FunctionDiffViewsTable table;

    public CloseFunctionDiffsViewsAction(FunctionDiffViewsTable functionDiffViewsTable) {
        this.table = (FunctionDiffViewsTable)Preconditions.checkNotNull(functionDiffViewsTable);
        this.controller = functionDiffViewsTable.getController();
    }

    public CloseFunctionDiffsViewsAction(WorkspaceTabPanelFunctions workspaceTabPanelFunctions) {
        this.controller = (WorkspaceTabPanelFunctions)Preconditions.checkNotNull(workspaceTabPanelFunctions);
        this.table = null;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        TabPanelManager tabPanelManager = this.controller.getMainWindow().getController().getTabPanelManager();
        HashSet<ViewTabPanel> hashSet = new HashSet<ViewTabPanel>();
        if (this.table == null) {
            hashSet.addAll(tabPanelManager.getViewTabPanels(true));
        } else {
            block0 : for (int i2 = 0; i2 < this.table.getRowCount(); ++i2) {
                Diff diff = AbstractTable.getRowDiff(this.table, i2);
                for (ViewTabPanel viewTabPanel : tabPanelManager.getViewTabPanels(true)) {
                    if (viewTabPanel.getDiff() != diff) continue;
                    hashSet.add(viewTabPanel);
                    continue block0;
                }
            }
        }
        this.controller.closeViews(hashSet);
    }
}

