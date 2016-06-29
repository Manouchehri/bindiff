package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.actions;

import javax.swing.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.*;
import com.google.common.base.*;
import java.awt.event.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.*;
import com.google.security.zynamics.bindiff.project.diff.*;
import java.util.*;

public class CloseFunctionDiffsViewsAction extends AbstractAction
{
    private final WorkspaceTabPanelFunctions controller;
    private final FunctionDiffViewsTable table;
    
    public CloseFunctionDiffsViewsAction(final FunctionDiffViewsTable functionDiffViewsTable) {
        this.table = (FunctionDiffViewsTable)Preconditions.checkNotNull(functionDiffViewsTable);
        this.controller = functionDiffViewsTable.getController();
    }
    
    public CloseFunctionDiffsViewsAction(final WorkspaceTabPanelFunctions workspaceTabPanelFunctions) {
        this.controller = (WorkspaceTabPanelFunctions)Preconditions.checkNotNull(workspaceTabPanelFunctions);
        this.table = null;
    }
    
    @Override
    public void actionPerformed(final ActionEvent actionEvent) {
        final TabPanelManager tabPanelManager = this.controller.getMainWindow().getController().getTabPanelManager();
        final HashSet<Object> set = new HashSet<Object>();
        if (this.table == null) {
            set.addAll(tabPanelManager.getViewTabPanels(true));
        }
        else {
            for (int i = 0; i < this.table.getRowCount(); ++i) {
                final Diff rowDiff = AbstractTable.getRowDiff(this.table, i);
                for (final ViewTabPanel viewTabPanel : tabPanelManager.getViewTabPanels(true)) {
                    if (viewTabPanel.getDiff() == rowDiff) {
                        set.add(viewTabPanel);
                        break;
                    }
                }
            }
        }
        this.controller.closeViews(set);
    }
}
