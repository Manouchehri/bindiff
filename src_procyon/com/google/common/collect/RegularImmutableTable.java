package com.google.common.collect;

import com.google.common.annotations.*;
import javax.annotation.*;
import com.google.common.base.*;
import java.util.*;

@GwtCompatible
abstract class RegularImmutableTable extends ImmutableTable
{
    abstract Table$Cell getCell(final int p0);
    
    @Override
    final ImmutableSet createCellSet() {
        return this.isEmpty() ? ImmutableSet.of() : new RegularImmutableTable$CellSet(this, null);
    }
    
    abstract Object getValue(final int p0);
    
    @Override
    final ImmutableCollection createValues() {
        return this.isEmpty() ? ImmutableList.of() : new RegularImmutableTable$Values(this, null);
    }
    
    static RegularImmutableTable forCells(final List list, @Nullable final Comparator comparator, @Nullable final Comparator comparator2) {
        Preconditions.checkNotNull(list);
        if (comparator != null || comparator2 != null) {
            Collections.sort((List<Object>)list, new RegularImmutableTable$1(comparator, comparator2));
        }
        return forCellsInternal(list, comparator, comparator2);
    }
    
    static RegularImmutableTable forCells(final Iterable iterable) {
        return forCellsInternal(iterable, null, null);
    }
    
    private static final RegularImmutableTable forCellsInternal(final Iterable iterable, @Nullable final Comparator comparator, @Nullable final Comparator comparator2) {
        final LinkedHashSet<Object> set = new LinkedHashSet<Object>();
        final LinkedHashSet<Object> set2 = new LinkedHashSet<Object>();
        final ImmutableList copy = ImmutableList.copyOf(iterable);
        for (final Table$Cell table$Cell : iterable) {
            set.add(table$Cell.getRowKey());
            set2.add(table$Cell.getColumnKey());
        }
        final ImmutableSet set3 = (comparator == null) ? ImmutableSet.copyOf(set) : ImmutableSet.copyOf(Ordering.from(comparator).immutableSortedCopy(set));
        final ImmutableSet set4 = (comparator2 == null) ? ImmutableSet.copyOf(set2) : ImmutableSet.copyOf(Ordering.from(comparator2).immutableSortedCopy(set2));
        return (copy.size() > set3.size() * set4.size() / 2L) ? new DenseImmutableTable(copy, set3, set4) : new SparseImmutableTable(copy, set3, set4);
    }
}
