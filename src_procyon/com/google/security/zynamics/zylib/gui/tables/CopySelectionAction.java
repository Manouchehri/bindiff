package com.google.security.zynamics.zylib.gui.tables;

import javax.swing.*;
import java.awt.event.*;
import com.google.common.base.*;
import com.google.security.zynamics.zylib.general.*;

public class CopySelectionAction extends AbstractAction
{
    private final JTable table;
    
    public CopySelectionAction(final JTable table) {
        super("Copy Selection");
        this.table = table;
    }
    
    @Override
    public void actionPerformed(final ActionEvent actionEvent) {
        final int[] selectedRows = this.table.getSelectedRows();
        final int columnCount = this.table.getColumnCount();
        final int[] array = new int[columnCount];
        for (final int n : selectedRows) {
            for (int j = 0; j < columnCount; ++j) {
                if (this.table.getValueAt(n, j) != null) {
                    final int length2 = this.table.getValueAt(n, j).toString().length();
                    if (length2 > array[j]) {
                        array[j] = length2;
                    }
                }
            }
        }
        final StringBuffer sb = new StringBuffer();
        for (final int n2 : selectedRows) {
            for (int l = 0; l < columnCount; ++l) {
                if (this.table.getValueAt(n2, l) != null) {
                    final String string = this.table.getValueAt(n2, l).toString();
                    final int n3 = array[l] - string.length();
                    sb.append(string);
                    sb.append(Strings.repeat(" ", n3));
                    if (l != columnCount - 1) {
                        sb.append("  ");
                    }
                }
            }
            sb.append("\n");
        }
        ClipboardHelpers.copyToClipboard(sb.toString());
    }
}
