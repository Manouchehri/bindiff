/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.ui;

import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.JTable;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import org.jfree.ui.SortButtonRenderer;
import org.jfree.ui.SortableTableHeaderListener;
import org.jfree.ui.SortableTableModel;

public class SortableTable
extends JTable {
    private SortableTableHeaderListener headerListener;

    public SortableTable(SortableTableModel sortableTableModel) {
        super(sortableTableModel);
        SortButtonRenderer sortButtonRenderer = new SortButtonRenderer();
        TableColumnModel tableColumnModel = this.getColumnModel();
        int n2 = 0;
        do {
            if (n2 >= tableColumnModel.getColumnCount()) {
                JTableHeader jTableHeader = this.getTableHeader();
                this.headerListener = new SortableTableHeaderListener(sortableTableModel, sortButtonRenderer);
                jTableHeader.addMouseListener(this.headerListener);
                jTableHeader.addMouseMotionListener(this.headerListener);
                sortableTableModel.sortByColumn(0, true);
                return;
            }
            tableColumnModel.getColumn(n2).setHeaderRenderer(sortButtonRenderer);
            ++n2;
        } while (true);
    }

    public void setSortableModel(SortableTableModel sortableTableModel) {
        super.setModel(sortableTableModel);
        this.headerListener.setTableModel(sortableTableModel);
        SortButtonRenderer sortButtonRenderer = new SortButtonRenderer();
        TableColumnModel tableColumnModel = this.getColumnModel();
        int n2 = 0;
        do {
            if (n2 >= tableColumnModel.getColumnCount()) {
                sortableTableModel.sortByColumn(0, true);
                return;
            }
            tableColumnModel.getColumn(n2).setHeaderRenderer(sortButtonRenderer);
            ++n2;
        } while (true);
    }
}

