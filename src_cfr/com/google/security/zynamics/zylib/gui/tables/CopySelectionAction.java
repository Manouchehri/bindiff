/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.gui.tables;

import com.google.common.base.Strings;
import com.google.security.zynamics.zylib.general.ClipboardHelpers;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.JTable;

public class CopySelectionAction
extends AbstractAction {
    private final JTable table;

    public CopySelectionAction(JTable jTable) {
        super("Copy Selection");
        this.table = jTable;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        int n2;
        int n32;
        int n4;
        int[] arrn = this.table.getSelectedRows();
        int n5 = this.table.getColumnCount();
        int[] arrn2 = new int[n5];
        for (int n32 : arrn) {
            for (n4 = 0; n4 < n5; ++n4) {
                if (this.table.getValueAt(n32, n4) == null || (n2 = this.table.getValueAt(n32, n4).toString().length()) <= arrn2[n4]) continue;
                arrn2[n4] = n2;
            }
        }
        StringBuffer stringBuffer = new StringBuffer();
        int[] arrn3 = arrn;
        int n6 = arrn3.length;
        n32 = 0;
        do {
            if (n32 >= n6) {
                ClipboardHelpers.copyToClipboard(stringBuffer.toString());
                return;
            }
            n4 = arrn3[n32];
            for (n2 = 0; n2 < n5; ++n2) {
                if (this.table.getValueAt(n4, n2) == null) continue;
                String string = this.table.getValueAt(n4, n2).toString();
                int n7 = arrn2[n2] - string.length();
                stringBuffer.append(string);
                stringBuffer.append(Strings.repeat(" ", n7));
                if (n2 == n5 - 1) continue;
                stringBuffer.append("  ");
            }
            stringBuffer.append("\n");
            ++n32;
        } while (true);
    }
}

