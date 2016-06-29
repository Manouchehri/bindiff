/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.common.base.Supplier;
import com.google.common.collect.Iterables;
import com.google.common.collect.Iterators;
import com.google.common.collect.Ordering;
import com.google.common.collect.StandardRowSortedTable;
import com.google.common.collect.Table;
import com.google.common.collect.TreeBasedTable$1;
import com.google.common.collect.TreeBasedTable$2;
import com.google.common.collect.TreeBasedTable$Factory;
import com.google.common.collect.TreeBasedTable$TreeRow;
import com.google.common.collect.UnmodifiableIterator;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import javax.annotation.Nullable;

@GwtCompatible(serializable=1)
@Beta
public class TreeBasedTable
extends StandardRowSortedTable {
    private final Comparator columnComparator;
    private static final long serialVersionUID = 0;

    public static TreeBasedTable create() {
        return new TreeBasedTable(Ordering.natural(), Ordering.natural());
    }

    public static TreeBasedTable create(Comparator comparator, Comparator comparator2) {
        Preconditions.checkNotNull(comparator);
        Preconditions.checkNotNull(comparator2);
        return new TreeBasedTable(comparator, comparator2);
    }

    public static TreeBasedTable create(TreeBasedTable treeBasedTable) {
        TreeBasedTable treeBasedTable2 = new TreeBasedTable(treeBasedTable.rowComparator(), treeBasedTable.columnComparator());
        treeBasedTable2.putAll(treeBasedTable);
        return treeBasedTable2;
    }

    TreeBasedTable(Comparator comparator, Comparator comparator2) {
        super(new TreeMap(comparator), new TreeBasedTable$Factory(comparator2));
        this.columnComparator = comparator2;
    }

    public Comparator rowComparator() {
        return this.rowKeySet().comparator();
    }

    public Comparator columnComparator() {
        return this.columnComparator;
    }

    @Override
    public SortedMap row(Object object) {
        return new TreeBasedTable$TreeRow(this, object);
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
        Comparator comparator = this.columnComparator();
        UnmodifiableIterator unmodifiableIterator = Iterators.mergeSorted(Iterables.transform(this.backingMap.values(), new TreeBasedTable$1(this)), comparator);
        return new TreeBasedTable$2(this, unmodifiableIterator, comparator);
    }
}

