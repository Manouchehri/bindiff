package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.actions;

import javax.swing.*;
import com.google.common.base.*;
import java.awt.event.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.*;
import com.google.security.zynamics.zylib.general.*;
import com.google.security.zynamics.zylib.gui.tables.*;

public class CopySelectionToClipboardAction extends AbstractAction
{
    private final AbstractTable table;
    
    public CopySelectionToClipboardAction(final AbstractTable abstractTable) {
        this.table = (AbstractTable)Preconditions.checkNotNull(abstractTable);
    }
    
    @Override
    public void actionPerformed(final ActionEvent actionEvent) {
        final StringBuilder sb = new StringBuilder();
        final CTableSorter model = this.table.getModel();
        for (final int n : this.table.getSelectedRows()) {
            for (int j = 0; j < model.getColumnCount(); ++j) {
                if (j > 0) {
                    sb.append("\t");
                }
                final Object value = this.table.getModel().getValueAt(n, j);
                if (value == ExtendedMatchedFunctionViewsTableModel.ADDED_ICON) {
                    sb.append("+");
                }
                else if (value == ExtendedMatchedFunctionViewsTableModel.REMOVED_ICON) {
                    sb.append("-");
                }
                else {
                    sb.append(value.toString());
                }
            }
            sb.append("\n");
        }
        ClipboardHelpers.copyToClipboard(sb.toString());
    }
}
