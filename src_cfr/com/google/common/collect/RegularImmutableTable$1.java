/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.collect.Table$Cell;
import java.util.Comparator;

final class RegularImmutableTable$1
implements Comparator {
    final /* synthetic */ Comparator val$rowComparator;
    final /* synthetic */ Comparator val$columnComparator;

    RegularImmutableTable$1(Comparator comparator, Comparator comparator2) {
        this.val$rowComparator = comparator;
        this.val$columnComparator = comparator2;
    }

    public int compare(Table$Cell table$Cell, Table$Cell table$Cell2) {
        int n2;
        int n3 = n2 = this.val$rowComparator == null ? 0 : this.val$rowComparator.compare(table$Cell.getRowKey(), table$Cell2.getRowKey());
        if (n2 != 0) {
            return n2;
        }
        if (this.val$columnComparator == null) {
            return 0;
        }
        int n4 = this.val$columnComparator.compare(table$Cell.getColumnKey(), table$Cell2.getColumnKey());
        return n4;
    }
}

