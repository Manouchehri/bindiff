package com.google.common.collect;

import com.google.common.base.*;
import java.util.*;

public final class ImmutableTable$Builder
{
    private final List cells;
    private Comparator rowComparator;
    private Comparator columnComparator;
    
    public ImmutableTable$Builder() {
        this.cells = Lists.newArrayList();
    }
    
    public ImmutableTable$Builder orderRowsBy(final Comparator comparator) {
        this.rowComparator = (Comparator)Preconditions.checkNotNull(comparator);
        return this;
    }
    
    public ImmutableTable$Builder orderColumnsBy(final Comparator comparator) {
        this.columnComparator = (Comparator)Preconditions.checkNotNull(comparator);
        return this;
    }
    
    public ImmutableTable$Builder put(final Object o, final Object o2, final Object o3) {
        this.cells.add(ImmutableTable.cellOf(o, o2, o3));
        return this;
    }
    
    public ImmutableTable$Builder put(final Table$Cell table$Cell) {
        if (table$Cell instanceof Tables$ImmutableCell) {
            Preconditions.checkNotNull(table$Cell.getRowKey());
            Preconditions.checkNotNull(table$Cell.getColumnKey());
            Preconditions.checkNotNull(table$Cell.getValue());
            this.cells.add(table$Cell);
        }
        else {
            this.put(table$Cell.getRowKey(), table$Cell.getColumnKey(), table$Cell.getValue());
        }
        return this;
    }
    
    public ImmutableTable$Builder putAll(final Table table) {
        final Iterator<Table$Cell> iterator = table.cellSet().iterator();
        while (iterator.hasNext()) {
            this.put(iterator.next());
        }
        return this;
    }
    
    public ImmutableTable build() {
        switch (this.cells.size()) {
            case 0: {
                return ImmutableTable.of();
            }
            case 1: {
                return new SingletonImmutableTable((Table$Cell)Iterables.getOnlyElement(this.cells));
            }
            default: {
                return RegularImmutableTable.forCells(this.cells, this.rowComparator, this.columnComparator);
            }
        }
    }
}
