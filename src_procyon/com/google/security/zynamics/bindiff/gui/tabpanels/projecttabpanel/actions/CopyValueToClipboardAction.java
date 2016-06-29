package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.actions;

import javax.swing.*;
import com.google.common.base.*;
import java.awt.event.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.*;
import com.google.security.zynamics.zylib.general.*;

public class CopyValueToClipboardAction extends AbstractAction
{
    private final AbstractTable table;
    private final int hitRowIndex;
    private final int hitColumnIndex;
    
    public CopyValueToClipboardAction(final AbstractTable abstractTable, final int hitRowIndex, final int hitColumnIndex) {
        this.table = (AbstractTable)Preconditions.checkNotNull(abstractTable);
        this.hitRowIndex = hitRowIndex;
        this.hitColumnIndex = hitColumnIndex;
    }
    
    @Override
    public void actionPerformed(final ActionEvent actionEvent) {
        final Object value = this.table.getModel().getValueAt(this.hitRowIndex, this.hitColumnIndex);
        String string;
        if (value == ExtendedMatchedFunctionViewsTableModel.ADDED_ICON) {
            string = "+";
        }
        else if (value == ExtendedMatchedFunctionViewsTableModel.REMOVED_ICON) {
            string = "-";
        }
        else {
            string = this.table.getModel().getValueAt(this.hitRowIndex, this.hitColumnIndex).toString();
        }
        ClipboardHelpers.copyToClipboard(string);
    }
}
