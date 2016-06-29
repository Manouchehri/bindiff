/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.gui.tables;

import com.google.security.zynamics.zylib.gui.tables.CTableSorter;
import com.google.security.zynamics.zylib.gui.tables.CTableSorter$1;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

class CTableSorter$TableModelHandler
implements TableModelListener {
    final /* synthetic */ CTableSorter this$0;

    private CTableSorter$TableModelHandler(CTableSorter cTableSorter) {
        this.this$0 = cTableSorter;
    }

    @Override
    public void tableChanged(TableModelEvent tableModelEvent) {
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
        int n2 = tableModelEvent.getColumn();
        if (tableModelEvent.getFirstRow() == tableModelEvent.getLastRow() && n2 != -1 && this.this$0.getSortingStatus(n2) == 0 && this.this$0.modelToView != null) {
            int n3 = this.this$0.getModelToView()[tableModelEvent.getFirstRow()];
            this.this$0.fireTableChanged(new TableModelEvent(this.this$0, n3, n3, n2, tableModelEvent.getType()));
            return;
        }
        this.this$0.clearSortingState();
        this.this$0.fireTableDataChanged();
    }

    /* synthetic */ CTableSorter$TableModelHandler(CTableSorter cTableSorter, CTableSorter$1 cTableSorter$1) {
        this(cTableSorter);
    }
}

