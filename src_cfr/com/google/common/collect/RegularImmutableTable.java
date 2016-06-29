/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.DenseImmutableTable;
import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.ImmutableTable;
import com.google.common.collect.Ordering;
import com.google.common.collect.RegularImmutableTable$1;
import com.google.common.collect.RegularImmutableTable$CellSet;
import com.google.common.collect.RegularImmutableTable$Values;
import com.google.common.collect.SparseImmutableTable;
import com.google.common.collect.Table$Cell;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.Nullable;

@GwtCompatible
abstract class RegularImmutableTable
extends ImmutableTable {
    RegularImmutableTable() {
    }

    abstract Table$Cell getCell(int var1);

    @Override
    final ImmutableSet createCellSet() {
        ImmutableSet immutableSet;
        if (this.isEmpty()) {
            immutableSet = ImmutableSet.of();
            return immutableSet;
        }
        immutableSet = new RegularImmutableTable$CellSet(this, null);
        return immutableSet;
    }

    abstract Object getValue(int var1);

    @Override
    final ImmutableCollection createValues() {
        ImmutableList immutableList;
        if (this.isEmpty()) {
            immutableList = ImmutableList.of();
            return immutableList;
        }
        immutableList = new RegularImmutableTable$Values(this, null);
        return immutableList;
    }

    static RegularImmutableTable forCells(List list, @Nullable Comparator comparator, @Nullable Comparator comparator2) {
        Preconditions.checkNotNull(list);
        if (comparator == null) {
            if (comparator2 == null) return RegularImmutableTable.forCellsInternal(list, comparator, comparator2);
        }
        RegularImmutableTable$1 regularImmutableTable$1 = new RegularImmutableTable$1(comparator, comparator2);
        Collections.sort(list, regularImmutableTable$1);
        return RegularImmutableTable.forCellsInternal(list, comparator, comparator2);
    }

    static RegularImmutableTable forCells(Iterable iterable) {
        return RegularImmutableTable.forCellsInternal(iterable, null, null);
    }

    private static final RegularImmutableTable forCellsInternal(Iterable iterable, @Nullable Comparator comparator, @Nullable Comparator comparator2) {
        Object object2;
        DenseImmutableTable denseImmutableTable /* !! */ ;
        LinkedHashSet<Object> linkedHashSet = new LinkedHashSet<Object>();
        LinkedHashSet<Object> linkedHashSet2 = new LinkedHashSet<Object>();
        ImmutableList immutableList = ImmutableList.copyOf(iterable);
        for (Object object2 : iterable) {
            linkedHashSet.add(object2.getRowKey());
            linkedHashSet2.add(object2.getColumnKey());
        }
        ImmutableSet immutableSet = comparator == null ? ImmutableSet.copyOf(linkedHashSet) : ImmutableSet.copyOf(Ordering.from(comparator).immutableSortedCopy(linkedHashSet));
        Object object3 = object2 = comparator2 == null ? ImmutableSet.copyOf(linkedHashSet2) : ImmutableSet.copyOf(Ordering.from(comparator2).immutableSortedCopy(linkedHashSet2));
        if ((long)immutableList.size() > (long)immutableSet.size() * (long)object2.size() / 2) {
            denseImmutableTable /* !! */  = new DenseImmutableTable(immutableList, immutableSet, (ImmutableSet)object2);
            return denseImmutableTable /* !! */ ;
        }
        denseImmutableTable /* !! */  = new SparseImmutableTable(immutableList, immutableSet, (ImmutableSet)object2);
        return denseImmutableTable /* !! */ ;
    }
}

