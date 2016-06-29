/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.gui.tables;

import com.google.security.zynamics.zylib.general.ClipboardHelpers;
import java.awt.Point;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.JTable;

public class CopyCellAction
extends AbstractAction {
    private static final long serialVersionUID = 7553173268247700514L;
    private final JTable m_table;
    private final int m_x;
    private final int m_y;

    public CopyCellAction(JTable jTable, int n2, int n3) {
        super("Copy Cell");
        this.m_table = jTable;
        this.m_x = n2;
        this.m_y = n3;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        int n2 = this.m_table.columnAtPoint(new Point(this.m_x, this.m_y));
        int n3 = this.m_table.rowAtPoint(new Point(this.m_x, this.m_y));
        if (n2 == -1) return;
        if (n3 == -1) {
            return;
        }
        ClipboardHelpers.copyToClipboard(this.m_table.getValueAt(n3, n2).toString());
    }
}

