package com.google.security.zynamics.zylib.gui.tables;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import com.google.security.zynamics.zylib.general.*;

public class CopyCellAction extends AbstractAction
{
    private static final long serialVersionUID = 7553173268247700514L;
    private final JTable m_table;
    private final int m_x;
    private final int m_y;
    
    public CopyCellAction(final JTable table, final int x, final int y) {
        super("Copy Cell");
        this.m_table = table;
        this.m_x = x;
        this.m_y = y;
    }
    
    @Override
    public void actionPerformed(final ActionEvent actionEvent) {
        final int columnAtPoint = this.m_table.columnAtPoint(new Point(this.m_x, this.m_y));
        final int rowAtPoint = this.m_table.rowAtPoint(new Point(this.m_x, this.m_y));
        if (columnAtPoint == -1 || rowAtPoint == -1) {
            return;
        }
        ClipboardHelpers.copyToClipboard(this.m_table.getValueAt(rowAtPoint, columnAtPoint).toString());
    }
}
