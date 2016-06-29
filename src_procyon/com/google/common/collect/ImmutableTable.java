package com.google.common.collect;

import com.google.common.annotations.*;
import com.google.common.base.*;
import javax.annotation.*;
import java.util.*;

@GwtCompatible
public abstract class ImmutableTable extends AbstractTable
{
    private static final ImmutableTable EMPTY;
    
    public static ImmutableTable of() {
        return ImmutableTable.EMPTY;
    }
    
    public static ImmutableTable of(final Object o, final Object o2, final Object o3) {
        return new SingletonImmutableTable(o, o2, o3);
    }
    
    public static ImmutableTable copyOf(final Table table) {
        if (table instanceof ImmutableTable) {
            return (ImmutableTable)table;
        }
        final int size = table.size();
        switch (size) {
            case 0: {
                return of();
            }
            case 1: {
                final Table$Cell table$Cell = (Table$Cell)Iterables.getOnlyElement(table.cellSet());
                return of(table$Cell.getRowKey(), table$Cell.getColumnKey(), table$Cell.getValue());
            }
            default: {
                final ImmutableSet$Builder immutableSet$Builder = new ImmutableSet$Builder(size);
                for (final Table$Cell table$Cell2 : table.cellSet()) {
                    immutableSet$Builder.add(cellOf(table$Cell2.getRowKey(), table$Cell2.getColumnKey(), table$Cell2.getValue()));
                }
                return RegularImmutableTable.forCells(immutableSet$Builder.build());
            }
        }
    }
    
    public static ImmutableTable$Builder builder() {
        return new ImmutableTable$Builder();
    }
    
    static Table$Cell cellOf(final Object o, final Object o2, final Object o3) {
        return Tables.immutableCell(Preconditions.checkNotNull(o), Preconditions.checkNotNull(o2), Preconditions.checkNotNull(o3));
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
    public ImmutableMap column(final Object o) {
        Preconditions.checkNotNull(o);
        return (ImmutableMap)MoreObjects.firstNonNull(this.columnMap().get(o), ImmutableMap.of());
    }
    
    @Override
    public ImmutableSet columnKeySet() {
        return this.columnMap().keySet();
    }
    
    @Override
    public abstract ImmutableMap columnMap();
    
    @Override
    public ImmutableMap row(final Object o) {
        Preconditions.checkNotNull(o);
        return (ImmutableMap)MoreObjects.firstNonNull(this.rowMap().get(o), ImmutableMap.of());
    }
    
    @Override
    public ImmutableSet rowKeySet() {
        return this.rowMap().keySet();
    }
    
    @Override
    public abstract ImmutableMap rowMap();
    
    @Override
    public boolean contains(@Nullable final Object o, @Nullable final Object o2) {
        return this.get(o, o2) != null;
    }
    
    @Override
    public boolean containsValue(@Nullable final Object o) {
        return this.values().contains(o);
    }
    
    @Deprecated
    @Override
    public final void clear() {
        throw new UnsupportedOperationException();
    }
    
    @Deprecated
    @Override
    public final Object put(final Object o, final Object o2, final Object o3) {
        throw new UnsupportedOperationException();
    }
    
    @Deprecated
    @Override
    public final void putAll(final Table table) {
        throw new UnsupportedOperationException();
    }
    
    @Deprecated
    @Override
    public final Object remove(final Object o, final Object o2) {
        throw new UnsupportedOperationException();
    }
    
    static {
        EMPTY = new SparseImmutableTable(ImmutableList.of(), ImmutableSet.of(), ImmutableSet.of());
    }
}
