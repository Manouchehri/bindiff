package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.popup;

import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.*;
import com.google.security.zynamics.zylib.disassembly.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.*;
import com.google.security.zynamics.bindiff.project.diff.*;
import com.google.security.zynamics.zylib.general.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.*;

public class ViewPopupHelper
{
    public static boolean isEnabled(final AbstractTable abstractTable, final int n, final boolean b) {
        final TabPanelManager tabPanelManager = abstractTable.getController().getMainWindow().getController().getTabPanelManager();
        Diff diff = abstractTable.getDiff();
        final boolean b2 = diff == null;
        if (abstractTable.getSelectionModel().isSelectedIndex(n)) {
            for (final int n2 : abstractTable.getSelectedRows()) {
                Label_0158: {
                    if (b2) {
                        diff = AbstractTable.getRowDiff(abstractTable, n2);
                        if (!diff.isLoaded()) {
                            if (b) {
                                return true;
                            }
                            break Label_0158;
                        }
                    }
                    final Pair viewAddressPair = AbstractTable.getViewAddressPair(abstractTable, n2);
                    final ViewTabPanel tabPanel = tabPanelManager.getTabPanel((IAddress)viewAddressPair.first(), (IAddress)viewAddressPair.second(), diff);
                    if (b && tabPanel == null) {
                        return true;
                    }
                    if (!b && tabPanel != null) {
                        return true;
                    }
                }
            }
            return false;
        }
        final Pair viewAddressPair2 = AbstractTable.getViewAddressPair(abstractTable, n);
        return b == (tabPanelManager.getTabPanel((IAddress)viewAddressPair2.first(), (IAddress)viewAddressPair2.second(), diff) == null);
    }
}
