/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.actions;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.AbstractTable;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.ExtendedMatchedFunctionViewsTableModel;
import com.google.security.zynamics.zylib.general.ClipboardHelpers;
import com.google.security.zynamics.zylib.gui.tables.CTableSorter;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.Icon;

public class CopySelectionToClipboardAction
extends AbstractAction {
    private final AbstractTable table;

    public CopySelectionToClipboardAction(AbstractTable abstractTable) {
        this.table = (AbstractTable)Preconditions.checkNotNull(abstractTable);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        StringBuilder stringBuilder = new StringBuilder();
        CTableSorter cTableSorter = this.table.getModel();
        int[] arrn = this.table.getSelectedRows();
        int n2 = arrn.length;
        int n3 = 0;
        do {
            if (n3 >= n2) {
                ClipboardHelpers.copyToClipboard(stringBuilder.toString());
                return;
            }
            int n4 = arrn[n3];
            for (int i2 = 0; i2 < cTableSorter.getColumnCount(); ++i2) {
                Object object;
                if (i2 > 0) {
                    stringBuilder.append("\t");
                }
                if ((object = this.table.getModel().getValueAt(n4, i2)) == ExtendedMatchedFunctionViewsTableModel.ADDED_ICON) {
                    stringBuilder.append("+");
                    continue;
                }
                if (object == ExtendedMatchedFunctionViewsTableModel.REMOVED_ICON) {
                    stringBuilder.append("-");
                    continue;
                }
                stringBuilder.append(object.toString());
            }
            stringBuilder.append("\n");
            ++n3;
        } while (true);
    }
}

