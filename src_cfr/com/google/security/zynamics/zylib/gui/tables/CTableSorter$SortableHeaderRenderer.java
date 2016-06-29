/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.gui.tables;

import com.google.security.zynamics.zylib.gui.tables.CTableSorter;
import java.awt.Component;
import java.awt.Font;
import javax.swing.Icon;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

class CTableSorter$SortableHeaderRenderer
implements TableCellRenderer {
    protected TableCellRenderer tableCellRenderer;
    final /* synthetic */ CTableSorter this$0;

    public CTableSorter$SortableHeaderRenderer(CTableSorter cTableSorter, TableCellRenderer tableCellRenderer) {
        this.this$0 = cTableSorter;
        this.tableCellRenderer = tableCellRenderer;
    }

    @Override
    public Component getTableCellRendererComponent(JTable jTable, Object object, boolean bl2, boolean bl3, int n2, int n3) {
        Component component = this.tableCellRenderer.getTableCellRendererComponent(jTable, object, bl2, bl3, n2, n3);
        if (!(component instanceof JLabel)) return component;
        JLabel jLabel = (JLabel)component;
        jLabel.setHorizontalTextPosition(2);
        int n4 = jTable.convertColumnIndexToModel(n3);
        jLabel.setIcon(this.this$0.getHeaderRendererIcon(n4, jLabel.getFont().getSize()));
        return component;
    }
}

