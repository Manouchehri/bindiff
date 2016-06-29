/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.collect.AbstractTable;
import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.ImmutableSet$Builder;
import com.google.common.collect.ImmutableTable$Builder;
import com.google.common.collect.Iterables;
import com.google.common.collect.RegularImmutableTable;
import com.google.common.collect.SingletonImmutableTable;
import com.google.common.collect.SparseImmutableTable;
import com.google.common.collect.Table;
import com.google.common.collect.Table$Cell;
import com.google.common.collect.Tables;
import com.google.common.collect.UnmodifiableIterator;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;

@GwtCompatible
public abstract class ImmutableTable
extends AbstractTable {
    private static final ImmutableTable EMPTY = new SparseImmutableTable(ImmutableList.of(), ImmutableSet.of(), ImmutableSet.of());

    public static ImmutableTable of() {
        return EMPTY;
    }

    public static ImmutableTable of(Object object, Object object2, Object object3) {
        return new SingletonImmutableTable(object, object2, object3);
    }

    public static ImmutableTable copyOf(Table table) {
        if (table instanceof ImmutableTable) {
            return (ImmutableTable)table;
        }
        int n2 = table.size();
        switch (n2) {
            case 0: {
                return ImmutableTable.of();
            }
            case 1: {
                Table$Cell table$Cell = (Table$Cell)Iterables.getOnlyElement(table.cellSet());
                return ImmutableTable.of(table$Cell.getRowKey(), table$Cell.getColumnKey(), table$Cell.getValue());
            }
        }
        ImmutableSet$Builder immutableSet$Builder = new ImmutableSet$Builder(n2);
        Iterator iterator = table.cellSet().iterator();
        while (iterator.hasNext()) {
            Table$Cell table$Cell = (Table$Cell)iterator.next();
            immutableSet$Builder.add((Object)ImmutableTable.cellOf(table$Cell.getRowKey(), table$Cell.getColumnKey(), table$Cell.getValue()));
        }
        return RegularImmutableTable.forCells(immutableSet$Builder.build());
    }

    public static ImmutableTable$Builder builder() {
        return new ImmutableTable$Builder();
    }

    static Table$Cell cellOf(Object object, Object object2, Object object3) {
        return Tables.immutableCell(Preconditions.checkNotNull(object), Preconditions.checkNotNull(object2), Preconditions.checkNotNull(object3));
    }

    ImmutableTable() {
    }

    @Override
    public ImmutableSet cellSet() {
        return (ImmutableSet)super.cellSet();
    }

    @Override
    abstract ImmutableSet createCellSet();

    @Override
    final UnmodifiableIterator cellIterator() {
        throw new AssertionError((Object)"should never be called");
    }

    @Override
    public ImmutableCollection values() {
        return (ImmutableCollection)super.values();
    }

    @Override
    abstract ImmutableCollection createValues();

    @Override
    final Iterator valuesIterator() {
        throw new AssertionError((Object)"should never be called");
    }

    @Override
    public ImmutableMap column(Object object) {
        Preconditions.checkNotNull(object);
        return (ImmutableMap)MoreObjects.firstNonNull((ImmutableMap)this.columnMap().get(object), ImmutableMap.of());
    }

    @Override
    public ImmutableSet columnKeySet() {
        return this.columnMap().keySet();
    }

    @Override
    public abstract ImmutableMap columnMap();

    @Override
    public ImmutableMap row(Object object) {
        Preconditions.checkNotNull(object);
        return (ImmutableMap)MoreObjects.firstNonNull((ImmutableMap)this.rowMap().get(object), ImmutableMap.of());
    }

    @Override
    public ImmutableSet rowKeySet() {
        return this.rowMap().keySet();
    }

    @Override
    public abstract ImmutableMap rowMap();

    @Override
    public boolean contains(@Nullable Object object, @Nullable Object object2) {
        if (this.get(object, object2) == null) return false;
        return true;
    }

    @Override
    public boolean containsValue(@Nullable Object object) {
        return this.values().contains(object);
    }

    @Deprecated
    @Override
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    @Override
    public final Object put(Object object, Object object2, Object object3) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    @Override
    public final void putAll(Table table) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    @Override
    public final Object remove(Object object, Object object2) {
        throw new UnsupportedOperationException();
    }
}

