/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.projecttree.popupmenu;

import com.google.security.zynamics.bindiff.gui.tabpanels.TabPanelManager;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.WorkspaceTabPanelFunctions;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.actions.CloseFunctionDiffsViewsAction;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.actions.DeleteFunctionDiffViewsAction;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.projecttree.treenodes.FunctionDiffViewsNode;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.FunctionDiffViewsNodeContextPanel;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.AbstractTable;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.FunctionDiffViewsTable;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.ViewTabPanel;
import com.google.security.zynamics.bindiff.gui.window.CWindowFunctions;
import com.google.security.zynamics.bindiff.gui.window.MainWindow;
import com.google.security.zynamics.bindiff.project.diff.Diff;
import com.google.security.zynamics.bindiff.utils.GuiUtils;
import java.awt.Component;
import java.util.HashSet;
import java.util.List;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JSeparator;

public class FunctionDiffNodePopupMenu
extends JPopupMenu {
    public FunctionDiffNodePopupMenu(FunctionDiffViewsNode functionDiffViewsNode) {
        FunctionDiffViewsNodeContextPanel functionDiffViewsNodeContextPanel = functionDiffViewsNode.getComponent();
        FunctionDiffViewsTable functionDiffViewsTable = (FunctionDiffViewsTable)functionDiffViewsNodeContextPanel.getTables().get(0);
        this.add(GuiUtils.buildMenuItem("Delete Function Diffs", new DeleteFunctionDiffViewsAction(functionDiffViewsNode)));
        this.add(new JSeparator());
        this.add(GuiUtils.buildMenuItem("Close Function Diff Views", new CloseFunctionDiffsViewsAction(functionDiffViewsTable), this.isCloseViewsEnabled(functionDiffViewsTable)));
    }

    private boolean isCloseViewsEnabled(FunctionDiffViewsTable functionDiffViewsTable) {
        WorkspaceTabPanelFunctions workspaceTabPanelFunctions = functionDiffViewsTable.getController();
        TabPanelManager tabPanelManager = workspaceTabPanelFunctions.getMainWindow().getController().getTabPanelManager();
        HashSet<Diff> hashSet = new HashSet<Diff>();
        for (ViewTabPanel viewTabPanel : tabPanelManager.getViewTabPanels(true)) {
            hashSet.add(viewTabPanel.getDiff());
        }
        int n2 = 0;
        while (n2 < functionDiffViewsTable.getRowCount()) {
            if (hashSet.contains(AbstractTable.getRowDiff(functionDiffViewsTable, n2))) {
                return true;
            }
            ++n2;
        }
        return false;
    }
}

