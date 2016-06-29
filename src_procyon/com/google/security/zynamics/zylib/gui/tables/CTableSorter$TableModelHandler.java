package com.google.security.zynamics.zylib.gui.tables;

import javax.swing.event.*;
import javax.swing.table.*;

class CTableSorter$TableModelHandler implements TableModelListener
{
    final /* synthetic */ CTableSorter this$0;
    
    private CTableSorter$TableModelHandler(final CTableSorter this$0) {
        this.this$0 = this$0;
    }
    
    @Override
    public void tableChanged(final TableModelEvent tableModelEvent) {
        if (!this.this$0.isSorting()) {
            this.this$0.clearSortingState();
            this.this$0.fireTableChanged(tableModelEvent);
            return;
        }
        if (tableModelEvent.getFirstRow() == -1) {
            this.this$0.cancelSorting();
            this.this$0.fireTableChanged(tableModelEvent);
            return;
        }
        final int column = tableModelEvent.getColumn();
        if (tableModelEvent.getFirstRow() == tableModelEvent.getLastRow() && column != -1 && this.this$0.getSortingStatus(column) == 0 && this.this$0.modelToView != null) {
            final int n = this.this$0.getModelToView()[tableModelEvent.getFirstRow()];
            this.this$0.fireTableChanged(new TableModelEvent(this.this$0, n, n, column, tableModelEvent.getType()));
            return;
        }
        this.this$0.clearSortingState();
        this.this$0.fireTableDataChanged();
    }
}
