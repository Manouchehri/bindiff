package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.projecttree.popupmenu;

import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.projecttree.treenodes.*;
import com.google.security.zynamics.bindiff.utils.*;
import javax.swing.*;
import java.awt.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.actions.*;
import com.google.security.zynamics.bindiff.project.diff.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.*;
import java.util.*;

public class FunctionDiffNodePopupMenu extends JPopupMenu
{
    public FunctionDiffNodePopupMenu(final FunctionDiffViewsNode functionDiffViewsNode) {
        final FunctionDiffViewsTable functionDiffViewsTable = functionDiffViewsNode.getComponent().getTables().get(0);
        this.add(GuiUtils.buildMenuItem("Delete Function Diffs", new DeleteFunctionDiffViewsAction(functionDiffViewsNode)));
        this.add(new JSeparator());
        this.add(GuiUtils.buildMenuItem("Close Function Diff Views", new CloseFunctionDiffsViewsAction(functionDiffViewsTable), this.isCloseViewsEnabled(functionDiffViewsTable)));
    }
    
    private boolean isCloseViewsEnabled(final FunctionDiffViewsTable functionDiffViewsTable) {
        final TabPanelManager tabPanelManager = functionDiffViewsTable.getController().getMainWindow().getController().getTabPanelManager();
        final HashSet<Diff> set = new HashSet<Diff>();
        final Iterator iterator = tabPanelManager.getViewTabPanels(true).iterator();
        while (iterator.hasNext()) {
            set.add(iterator.next().getDiff());
        }
        for (int i = 0; i < functionDiffViewsTable.getRowCount(); ++i) {
            if (set.contains(AbstractTable.getRowDiff(functionDiffViewsTable, i))) {
                return true;
            }
        }
        return false;
    }
}
