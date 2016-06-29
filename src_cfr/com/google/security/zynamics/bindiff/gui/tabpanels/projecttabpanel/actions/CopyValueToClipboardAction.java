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

public class CopyValueToClipboardAction
extends AbstractAction {
    private final AbstractTable table;
    private final int hitRowIndex;
    private final int hitColumnIndex;

    public CopyValueToClipboardAction(AbstractTable abstractTable, int n2, int n3) {
        this.table = (AbstractTable)Preconditions.checkNotNull(abstractTable);
        this.hitRowIndex = n2;
        this.hitColumnIndex = n3;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        String string = "";
        Object object = this.table.getModel().getValueAt(this.hitRowIndex, this.hitColumnIndex);
        string = object == ExtendedMatchedFunctionViewsTableModel.ADDED_ICON ? "+" : (object == ExtendedMatchedFunctionViewsTableModel.REMOVED_ICON ? "-" : this.table.getModel().getValueAt(this.hitRowIndex, this.hitColumnIndex).toString());
        ClipboardHelpers.copyToClipboard(string);
    }
}

