/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.actions;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.gui.tabpanels.TabPanelManager;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.WorkspaceTabPanelFunctions;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.AbstractTable;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.ViewTabPanel;
import com.google.security.zynamics.bindiff.gui.window.CWindowFunctions;
import com.google.security.zynamics.bindiff.gui.window.MainWindow;
import com.google.security.zynamics.bindiff.project.diff.Diff;
import com.google.security.zynamics.zylib.disassembly.IAddress;
import com.google.security.zynamics.zylib.general.Pair;
import java.awt.event.ActionEvent;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import javax.swing.AbstractAction;

public class CloseViewsAction
extends AbstractAction {
    private final WorkspaceTabPanelFunctions controller;
    private final AbstractTable table;

    public CloseViewsAction(AbstractTable abstractTable, int n2) {
        this.table = (AbstractTable)Preconditions.checkNotNull(abstractTable);
        this.controller = abstractTable.getController();
    }

    public CloseViewsAction(WorkspaceTabPanelFunctions workspaceTabPanelFunctions) {
        this.controller = (WorkspaceTabPanelFunctions)Preconditions.checkNotNull(workspaceTabPanelFunctions);
        this.table = null;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (this.table == null) {
            Diff diff = this.controller.getSelectedDiff();
            HashSet<Diff> hashSet = new HashSet<Diff>();
            if (diff != null) {
                hashSet.add(diff);
            }
            this.controller.closeViews(this.controller.getOpenViews(hashSet));
            return;
        }
        HashSet<ViewTabPanel> hashSet = new HashSet<ViewTabPanel>();
        Diff diff = this.table.getDiff();
        boolean bl2 = diff == null;
        int[] arrn = this.table.getSelectedRows();
        int n2 = arrn.length;
        int n3 = 0;
        do {
            Pair pair;
            TabPanelManager tabPanelManager;
            ViewTabPanel viewTabPanel;
            if (n3 >= n2) {
                this.controller.closeViews(hashSet);
                return;
            }
            int n4 = arrn[n3];
            if (bl2) {
                diff = AbstractTable.getRowDiff(this.table, n4);
            }
            if ((pair = AbstractTable.getViewAddressPair(this.table, n4)) != null && (viewTabPanel = (tabPanelManager = this.controller.getMainWindow().getController().getTabPanelManager()).getTabPanel((IAddress)pair.first(), (IAddress)pair.second(), diff)) != null) {
                hashSet.add(viewTabPanel);
            }
            ++n3;
        } while (true);
    }
}

