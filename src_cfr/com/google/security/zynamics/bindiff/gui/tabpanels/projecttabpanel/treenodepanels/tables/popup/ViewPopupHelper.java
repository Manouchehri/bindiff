/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.popup;

import com.google.security.zynamics.bindiff.gui.tabpanels.TabPanelManager;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.WorkspaceTabPanelFunctions;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.AbstractTable;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.ViewTabPanel;
import com.google.security.zynamics.bindiff.gui.window.CWindowFunctions;
import com.google.security.zynamics.bindiff.gui.window.MainWindow;
import com.google.security.zynamics.bindiff.project.diff.Diff;
import com.google.security.zynamics.zylib.disassembly.IAddress;
import com.google.security.zynamics.zylib.general.Pair;
import javax.swing.ListSelectionModel;

public class ViewPopupHelper {
    public static boolean isEnabled(AbstractTable abstractTable, int n2, boolean bl2) {
        boolean bl3;
        WorkspaceTabPanelFunctions workspaceTabPanelFunctions = abstractTable.getController();
        TabPanelManager tabPanelManager = workspaceTabPanelFunctions.getMainWindow().getController().getTabPanelManager();
        Diff diff = abstractTable.getDiff();
        boolean bl4 = bl3 = diff == null;
        if (!abstractTable.getSelectionModel().isSelectedIndex(n2)) {
            Pair pair = AbstractTable.getViewAddressPair(abstractTable, n2);
            ViewTabPanel viewTabPanel = tabPanelManager.getTabPanel((IAddress)pair.first(), (IAddress)pair.second(), diff);
            if (bl2 != (viewTabPanel == null)) return false;
            return true;
        }
        int[] arrn = abstractTable.getSelectedRows();
        int n3 = arrn.length;
        int n4 = 0;
        while (n4 < n3) {
            int n5 = arrn[n4];
            if (bl3 && !(diff = AbstractTable.getRowDiff(abstractTable, n5)).isLoaded()) {
                if (bl2) {
                    return true;
                }
            } else {
                Pair pair = AbstractTable.getViewAddressPair(abstractTable, n5);
                ViewTabPanel viewTabPanel = tabPanelManager.getTabPanel((IAddress)pair.first(), (IAddress)pair.second(), diff);
                if (bl2 && viewTabPanel == null) {
                    return true;
                }
                if (!bl2 && viewTabPanel != null) {
                    return true;
                }
            }
            ++n4;
        }
        return false;
    }
}

