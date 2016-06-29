package com.google.common.collect;

import java.util.*;

final class RegularImmutableTable$1 implements Comparator
{
    final /* synthetic */ Comparator val$rowComparator;
    final /* synthetic */ Comparator val$columnComparator;
    
    RegularImmutableTable$1(final Comparator val$rowComparator, final Comparator val$columnComparator) {
        this.val$rowComparator = val$rowComparator;
        this.val$columnComparator = val$columnComparator;
    }
    
    public int compare(final Table$Cell table$Cell, final Table$Cell table$Cell2) {
        final int n = (this.val$rowComparator == null) ? 0 : this.val$rowComparator.compare(table$Cell.getRowKey(), table$Cell2.getRowKey());
        if (n != 0) {
            return n;
        }
        return (this.val$columnComparator == null) ? 0 : this.val$columnComparator.compare(table$Cell.getColumnKey(), table$Cell2.getColumnKey());
    }
}
