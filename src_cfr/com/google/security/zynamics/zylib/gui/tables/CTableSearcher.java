/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.gui.tables;

import com.google.common.base.Preconditions;
import java.awt.Rectangle;
import java.awt.Window;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.TableModel;

public class CTableSearcher {
    private final JTable m_Table;
    private final Window m_Frame;
    private int m_StartRow = 0;
    private final String m_title;

    public CTableSearcher(Window window, String string, JTable jTable, int n2) {
        Preconditions.checkNotNull(window, "Internal Error: Parent window can't be null");
        Preconditions.checkNotNull(string, "Internal Error: Window title can't be null");
        Preconditions.checkNotNull(jTable, "Internal Error: Table can't be null");
        this.m_Table = jTable;
        this.m_Frame = window;
        this.m_title = string;
        this.m_StartRow = n2;
    }

    public void search() {
        String string = "";
        do {
            this.m_Frame.repaint();
            string = (String)JOptionPane.showInputDialog(this.m_Frame, "Search", this.m_title, 3, null, null, string);
            if (string != null && string.length() > 0 && !this.search(string)) {
                JOptionPane.showMessageDialog(this.m_Frame, "Search string not found", this.m_title, 0);
            }
            if (string == null) return;
        } while (string.length() > 0);
    }

    public boolean search(String string) {
        int n2 = this.m_Table.getModel().getColumnCount();
        int n3 = this.m_Table.getRowCount();
        int n4 = 0;
        while (n4 < n3) {
            for (int i2 = 0; i2 < n2; ++i2) {
                String string2;
                Object object = this.m_Table.getModel().getValueAt((n4 + this.m_StartRow) % n3, i2);
                String string3 = string2 = object != null ? object.toString() : "";
                if (!string2.toLowerCase().contains(string.toLowerCase())) continue;
                this.m_StartRow = (n4 + this.m_StartRow) % n3;
                this.m_Table.setRowSelectionInterval(this.m_StartRow, this.m_StartRow);
                this.m_Table.scrollRectToVisible(this.m_Table.getCellRect(this.m_StartRow, 0, true));
                ++this.m_StartRow;
                return true;
            }
            ++n4;
        }
        return false;
    }
}

