package com.google.common.collect;

import com.google.common.annotations.*;
import com.google.common.base.*;
import java.util.*;
import javax.annotation.*;

@GwtCompatible(serializable = true)
@Beta
public class TreeBasedTable extends StandardRowSortedTable
{
    private final Comparator columnComparator;
    private static final long serialVersionUID = 0L;
    
    public static TreeBasedTable create() {
        return new TreeBasedTable(Ordering.natural(), Ordering.natural());
    }
    
    public static TreeBasedTable create(final Comparator comparator, final Comparator comparator2) {
        Preconditions.checkNotNull(comparator);
        Preconditions.checkNotNull(comparator2);
        return new TreeBasedTable(comparator, comparator2);
    }
    
    public static TreeBasedTable create(final TreeBasedTable treeBasedTable) {
        final TreeBasedTable treeBasedTable2 = new TreeBasedTable(treeBasedTable.rowComparator(), treeBasedTable.columnComparator());
        treeBasedTable2.putAll(treeBasedTable);
        return treeBasedTable2;
    }
    
    TreeBasedTable(final Comparator comparator, final Comparator columnComparator) {
        super(new TreeMap(comparator), new TreeBasedTable$Factory(columnComparator));
        this.columnComparator = columnComparator;
    }
    
    public Comparator rowComparator() {
        return this.rowKeySet().comparator();
    }
    
    public Comparator columnComparator() {
        return this.columnComparator;
    }
    
    @Override
    public SortedMap row(final Object o) {
        return new TreeBasedTable$TreeRow(this, o);
    }
    
    @Override
    public SortedSet rowKeySet() {
        return super.rowKeySet();
    }
    
    @Override
    public SortedMap rowMap() {
        return super.rowMap();
    }
    
    @Override
    Iterator createColumnKeyIterator() {
        final Comparator columnComparator = this.columnComparator();
        return new TreeBasedTable$2(this, Iterators.mergeSorted(Iterables.transform(this.backingMap.values(), new TreeBasedTable$1(this)), columnComparator), columnComparator);
    }
}
