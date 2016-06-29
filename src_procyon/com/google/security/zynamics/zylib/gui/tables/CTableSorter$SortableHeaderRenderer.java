package com.google.security.zynamics.zylib.gui.tables;

import javax.swing.table.*;
import java.awt.*;
import javax.swing.*;

class CTableSorter$SortableHeaderRenderer implements TableCellRenderer
{
    protected TableCellRenderer tableCellRenderer;
    final /* synthetic */ CTableSorter this$0;
    
    public CTableSorter$SortableHeaderRenderer(final CTableSorter this$0, final TableCellRenderer tableCellRenderer) {
        this.this$0 = this$0;
        this.tableCellRenderer = tableCellRenderer;
    }
    
    @Override
    public Component getTableCellRendererComponent(final JTable table, final Object o, final boolean b, final boolean b2, final int n, final int n2) {
        final Component tableCellRendererComponent = this.tableCellRenderer.getTableCellRendererComponent(table, o, b, b2, n, n2);
        if (tableCellRendererComponent instanceof JLabel) {
            final JLabel label = (JLabel)tableCellRendererComponent;
            label.setHorizontalTextPosition(2);
            label.setIcon(this.this$0.getHeaderRendererIcon(table.convertColumnIndexToModel(n2), label.getFont().getSize()));
        }
        return tableCellRendererComponent;
    }
}
