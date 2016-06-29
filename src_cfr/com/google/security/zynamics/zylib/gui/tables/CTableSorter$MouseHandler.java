/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.gui.tables;

import com.google.security.zynamics.zylib.gui.tables.CTableSorter;
import com.google.security.zynamics.zylib.gui.tables.CTableSorter$1;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

class CTableSorter$MouseHandler
extends MouseAdapter {
    final /* synthetic */ CTableSorter this$0;

    private CTableSorter$MouseHandler(CTableSorter cTableSorter) {
        this.this$0 = cTableSorter;
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        int n2;
        JTableHeader jTableHeader = (JTableHeader)mouseEvent.getSource();
        TableColumnModel tableColumnModel = jTableHeader.getColumnModel();
        int n3 = tableColumnModel.getColumn(n2 = tableColumnModel.getColumnIndexAtX(mouseEvent.getX())).getModelIndex();
        if (n3 == -1) return;
        int n4 = this.this$0.getSortingStatus(n3);
        if (!mouseEvent.isControlDown()) {
            this.this$0.cancelSorting();
        }
        n4 += mouseEvent.isShiftDown() ? -1 : 1;
        n4 = (n4 + 4) % 3 - 1;
        this.this$0.setSortingStatus(n3, n4);
    }

    /* synthetic */ CTableSorter$MouseHandler(CTableSorter cTableSorter, CTableSorter$1 cTableSorter$1) {
        this(cTableSorter);
    }
}

