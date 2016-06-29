package com.google.security.zynamics.zylib.gui.tables;

import com.google.common.base.*;
import java.awt.*;
import javax.swing.*;

public class CTableSearcher
{
    private final JTable m_Table;
    private final Window m_Frame;
    private int m_StartRow;
    private final String m_title;
    
    public CTableSearcher(final Window frame, final String title, final JTable table, final int startRow) {
        this.m_StartRow = 0;
        Preconditions.checkNotNull(frame, (Object)"Internal Error: Parent window can't be null");
        Preconditions.checkNotNull(title, (Object)"Internal Error: Window title can't be null");
        Preconditions.checkNotNull(table, (Object)"Internal Error: Table can't be null");
        this.m_Table = table;
        this.m_Frame = frame;
        this.m_title = title;
        this.m_StartRow = startRow;
    }
    
    public void search() {
        String s = "";
        do {
            this.m_Frame.repaint();
            s = (String)JOptionPane.showInputDialog(this.m_Frame, "Search", this.m_title, 3, null, null, s);
            if (s != null && s.length() > 0 && !this.search(s)) {
                JOptionPane.showMessageDialog(this.m_Frame, "Search string not found", this.m_title, 0);
            }
        } while (s != null && s.length() > 0);
    }
    
    public boolean search(final String s) {
        final int columnCount = this.m_Table.getModel().getColumnCount();
        for (int rowCount = this.m_Table.getRowCount(), i = 0; i < rowCount; ++i) {
            for (int j = 0; j < columnCount; ++j) {
                final Object value = this.m_Table.getModel().getValueAt((i + this.m_StartRow) % rowCount, j);
                if (((value != null) ? value.toString() : "").toLowerCase().contains(s.toLowerCase())) {
                    this.m_StartRow = (i + this.m_StartRow) % rowCount;
                    this.m_Table.setRowSelectionInterval(this.m_StartRow, this.m_StartRow);
                    this.m_Table.scrollRectToVisible(this.m_Table.getCellRect(this.m_StartRow, 0, true));
                    ++this.m_StartRow;
                    return true;
                }
            }
        }
        return false;
    }
}
