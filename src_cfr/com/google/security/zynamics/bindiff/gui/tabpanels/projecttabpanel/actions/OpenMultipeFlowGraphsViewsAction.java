/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.actions;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.WorkspaceTabPanelFunctions;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.AbstractTable;
import com.google.security.zynamics.bindiff.gui.window.MainWindow;
import com.google.security.zynamics.bindiff.project.diff.Diff;
import com.google.security.zynamics.zylib.general.Pair;
import com.google.security.zynamics.zylib.general.Triple;
import com.google.security.zynamics.zylib.gui.CMessageBox;
import java.awt.event.ActionEvent;
import java.util.LinkedHashSet;
import javax.swing.AbstractAction;

public class OpenMultipeFlowGraphsViewsAction
extends AbstractAction {
    private static int OPEN_VIEWS_WARNING_THRESHOLD = 10;
    private final AbstractTable table;

    public OpenMultipeFlowGraphsViewsAction(AbstractTable abstractTable) {
        this.table = (AbstractTable)Preconditions.checkNotNull(abstractTable);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        int n2;
        int n3;
        Diff diff;
        WorkspaceTabPanelFunctions workspaceTabPanelFunctions = this.table.getController();
        LinkedHashSet<Triple> linkedHashSet = new LinkedHashSet<Triple>();
        int[] arrn = this.table.getSelectedRows();
        LinkedHashSet<Diff> linkedHashSet2 = new LinkedHashSet<Diff>();
        for (n2 = 0; n2 < arrn.length; ++n2) {
            n3 = arrn[n2];
            diff = AbstractTable.getRowDiff(this.table, n3);
            if (diff.isLoaded()) continue;
            linkedHashSet2.add(diff);
        }
        workspaceTabPanelFunctions.loadFunctionDiffs(linkedHashSet2);
        for (n2 = 0; n2 < arrn.length; ++n2) {
            n3 = arrn[n2];
            diff = AbstractTable.getRowDiff(this.table, n3);
            Pair pair = AbstractTable.getViewAddressPair(this.table, n3);
            linkedHashSet.add(Triple.make(diff, pair.first(), pair.second()));
        }
        n2 = 0;
        if (linkedHashSet.size() > OPEN_VIEWS_WARNING_THRESHOLD) {
            n2 = CMessageBox.showYesNoQuestion(workspaceTabPanelFunctions.getMainWindow(), String.format("This operation will open more than %d views. Continue?", OPEN_VIEWS_WARNING_THRESHOLD));
            if (n2 != 0) return;
        }
        workspaceTabPanelFunctions.openFlowgraphViews(workspaceTabPanelFunctions.getMainWindow(), linkedHashSet);
    }
}

