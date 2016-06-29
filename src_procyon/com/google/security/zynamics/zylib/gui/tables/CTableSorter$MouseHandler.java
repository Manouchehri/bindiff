package com.google.security.zynamics.zylib.gui.tables;

import java.awt.event.*;
import javax.swing.table.*;

class CTableSorter$MouseHandler extends MouseAdapter
{
    final /* synthetic */ CTableSorter this$0;
    
    private CTableSorter$MouseHandler(final CTableSorter this$0) {
        this.this$0 = this$0;
    }
    
    @Override
    public void mouseClicked(final MouseEvent mouseEvent) {
        final TableColumnModel columnModel = ((JTableHeader)mouseEvent.getSource()).getColumnModel();
        final int modelIndex = columnModel.getColumn(columnModel.getColumnIndexAtX(mouseEvent.getX())).getModelIndex();
        if (modelIndex != -1) {
            final int sortingStatus = this.this$0.getSortingStatus(modelIndex);
            if (!mouseEvent.isControlDown()) {
                this.this$0.cancelSorting();
            }
            this.this$0.setSortingStatus(modelIndex, (sortingStatus + (mouseEvent.isShiftDown() ? -1 : 1) + 4) % 3 - 1);
        }
    }
}
