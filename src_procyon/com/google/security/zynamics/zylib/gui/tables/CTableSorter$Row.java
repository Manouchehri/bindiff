package com.google.security.zynamics.zylib.gui.tables;

import java.util.*;

class CTableSorter$Row implements Comparable
{
    protected int modelIndex;
    final /* synthetic */ CTableSorter this$0;
    
    public CTableSorter$Row(final CTableSorter this$0, final int modelIndex) {
        this.this$0 = this$0;
        this.modelIndex = modelIndex;
    }
    
    @Override
    public int compareTo(final Object o) {
        final int modelIndex = this.modelIndex;
        final int modelIndex2 = ((CTableSorter$Row)o).modelIndex;
        for (final CTableSorter$Directive cTableSorter$Directive : this.this$0.sortingColumns) {
            final int column = cTableSorter$Directive.column;
            final Object value = this.this$0.tableModel.getValueAt(modelIndex, column);
            final Object value2 = this.this$0.tableModel.getValueAt(modelIndex2, column);
            int compare;
            if (value == null && value2 == null) {
                compare = 0;
            }
            else if (value == null) {
                compare = -1;
            }
            else if (value2 == null) {
                compare = 1;
            }
            else {
                compare = this.this$0.getComparator(column).compare(value, value2);
            }
            if (compare != 0) {
                return (cTableSorter$Directive.direction == -1) ? (-compare) : compare;
            }
        }
        return 0;
    }
}
