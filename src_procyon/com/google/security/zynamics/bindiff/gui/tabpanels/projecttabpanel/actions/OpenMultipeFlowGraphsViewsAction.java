package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.actions;

import javax.swing.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.*;
import com.google.common.base.*;
import java.awt.event.*;
import java.util.*;
import com.google.security.zynamics.bindiff.project.diff.*;
import com.google.security.zynamics.zylib.gui.*;
import java.awt.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.*;
import com.google.security.zynamics.zylib.general.*;

public class OpenMultipeFlowGraphsViewsAction extends AbstractAction
{
    private static int OPEN_VIEWS_WARNING_THRESHOLD;
    private final AbstractTable table;
    
    public OpenMultipeFlowGraphsViewsAction(final AbstractTable abstractTable) {
        this.table = (AbstractTable)Preconditions.checkNotNull(abstractTable);
    }
    
    @Override
    public void actionPerformed(final ActionEvent actionEvent) {
        final WorkspaceTabPanelFunctions controller = this.table.getController();
        final LinkedHashSet<Triple> set = new LinkedHashSet<Triple>();
        final int[] selectedRows = this.table.getSelectedRows();
        final LinkedHashSet<Diff> set2 = new LinkedHashSet<Diff>();
        for (int i = 0; i < selectedRows.length; ++i) {
            final Diff rowDiff = AbstractTable.getRowDiff(this.table, selectedRows[i]);
            if (!rowDiff.isLoaded()) {
                set2.add(rowDiff);
            }
        }
        controller.loadFunctionDiffs(set2);
        for (int j = 0; j < selectedRows.length; ++j) {
            final int n = selectedRows[j];
            final Diff rowDiff2 = AbstractTable.getRowDiff(this.table, n);
            final Pair viewAddressPair = AbstractTable.getViewAddressPair(this.table, n);
            set.add(Triple.make(rowDiff2, viewAddressPair.first(), viewAddressPair.second()));
        }
        int showYesNoQuestion = 0;
        if (set.size() > OpenMultipeFlowGraphsViewsAction.OPEN_VIEWS_WARNING_THRESHOLD) {
            showYesNoQuestion = CMessageBox.showYesNoQuestion(controller.getMainWindow(), String.format("This operation will open more than %d views. Continue?", OpenMultipeFlowGraphsViewsAction.OPEN_VIEWS_WARNING_THRESHOLD));
        }
        if (showYesNoQuestion == 0) {
            controller.openFlowgraphViews(controller.getMainWindow(), set);
        }
    }
    
    static {
        OpenMultipeFlowGraphsViewsAction.OPEN_VIEWS_WARNING_THRESHOLD = 10;
    }
}
