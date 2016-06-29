package com.google.common.collect;

import java.io.*;
import javax.annotation.*;
import java.lang.reflect.*;
import com.google.common.annotations.*;
import com.google.common.base.*;
import java.util.*;

@Beta
@GwtCompatible(emulated = true)
public final class ArrayTable extends AbstractTable implements Serializable
{
    private final ImmutableList rowList;
    private final ImmutableList columnList;
    private final ImmutableMap rowKeyToIndex;
    private final ImmutableMap columnKeyToIndex;
    private final Object[][] array;
    private transient ArrayTable$ColumnMap columnMap;
    private transient ArrayTable$RowMap rowMap;
    private static final long serialVersionUID = 0L;
    
    public static ArrayTable create(final Iterable iterable, final Iterable iterable2) {
        return new ArrayTable(iterable, iterable2);
    }
    
    public static ArrayTable create(final Table table) {
        return (table instanceof ArrayTable) ? new ArrayTable((ArrayTable)table) : new ArrayTable(table);
    }
    
    private ArrayTable(final Iterable iterable, final Iterable iterable2) {
        this.rowList = ImmutableList.copyOf(iterable);
        this.columnList = ImmutableList.copyOf(iterable2);
        Preconditions.checkArgument(!this.rowList.isEmpty());
        Preconditions.checkArgument(!this.columnList.isEmpty());
        this.rowKeyToIndex = Maps.indexMap(this.rowList);
        this.columnKeyToIndex = Maps.indexMap(this.columnList);
        this.array = new Object[this.rowList.size()][this.columnList.size()];
        this.eraseAll();
    }
    
    private ArrayTable(final Table table) {
        this(table.rowKeySet(), table.columnKeySet());
        this.putAll(table);
    }
    
    private ArrayTable(final ArrayTable arrayTable) {
        this.rowList = arrayTable.rowList;
        this.columnList = arrayTable.columnList;
        this.rowKeyToIndex = arrayTable.rowKeyToIndex;
        this.columnKeyToIndex = arrayTable.columnKeyToIndex;
        final Object[][] array = new Object[this.rowList.size()][this.columnList.size()];
        this.array = array;
        this.eraseAll();
        for (int i = 0; i < this.rowList.size(); ++i) {
            System.arraycopy(arrayTable.array[i], 0, array[i], 0, arrayTable.array[i].length);
        }
    }
    
    public ImmutableList rowKeyList() {
        return this.rowList;
    }
    
    public ImmutableList columnKeyList() {
        return this.columnList;
    }
    
    public Object at(final int n, final int n2) {
        Preconditions.checkElementIndex(n, this.rowList.size());
        Preconditions.checkElementIndex(n2, this.columnList.size());
        return this.array[n][n2];
    }
    
    public Object set(final int n, final int n2, @Nullable final Object o) {
        Preconditions.checkElementIndex(n, this.rowList.size());
        Preconditions.checkElementIndex(n2, this.columnList.size());
        final Object o2 = this.array[n][n2];
        this.array[n][n2] = o;
        return o2;
    }
    
    @GwtIncompatible("reflection")
    public Object[][] toArray(final Class clazz) {
        final Object[][] array = (Object[][])Array.newInstance(clazz, this.rowList.size(), this.columnList.size());
        for (int i = 0; i < this.rowList.size(); ++i) {
            System.arraycopy(this.array[i], 0, array[i], 0, this.array[i].length);
        }
        return array;
    }
    
    @Deprecated
    @Override
    public void clear() {
        throw new UnsupportedOperationException();
    }
    
    public void eraseAll() {
        final Object[][] array = this.array;
        for (int length = array.length, i = 0; i < length; ++i) {
            Arrays.fill(array[i], null);
        }
    }
    
    @Override
    public boolean contains(@Nullable final Object o, @Nullable final Object o2) {
        return this.containsRow(o) && this.containsColumn(o2);
    }
    
    @Override
    public boolean containsColumn(@Nullable final Object o) {
        return this.columnKeyToIndex.containsKey(o);
    }
    
    @Override
    public boolean containsRow(@Nullable final Object o) {
        return this.rowKeyToIndex.containsKey(o);
    }
    
    @Override
    public boolean containsValue(@Nullable final Object o) {
        for (final Object[] array2 : this.array) {
            for (int length2 = array2.length, j = 0; j < length2; ++j) {
                if (Objects.equal(o, array2[j])) {
                    return true;
                }
            }
        }
        return false;
    }
    
    @Override
    public Object get(@Nullable final Object o, @Nullable final Object o2) {
        final Integer n = (Integer)this.rowKeyToIndex.get(o);
        final Integer n2 = (Integer)this.columnKeyToIndex.get(o2);
        return (n == null || n2 == null) ? null : this.at(n, n2);
    }
    
    @Override
    public boolean isEmpty() {
        return false;
    }
    
    @Override
    public Object put(final Object o, final Object o2, @Nullable final Object o3) {
        Preconditions.checkNotNull(o);
        Preconditions.checkNotNull(o2);
        final Integer n = (Integer)this.rowKeyToIndex.get(o);
        Preconditions.checkArgument(n != null, "Row %s not in %s", o, this.rowList);
        final Integer n2 = (Integer)this.columnKeyToIndex.get(o2);
        Preconditions.checkArgument(n2 != null, "Column %s not in %s", o2, this.columnList);
        return this.set(n, n2, o3);
    }
    
    @Override
    public void putAll(final Table table) {
        super.putAll(table);
    }
    
    @Deprecated
    @Override
    public Object remove(final Object o, final Object o2) {
        throw new UnsupportedOperationException();
    }
    
    public Object erase(@Nullable final Object o, @Nullable final Object o2) {
        final Integer n = (Integer)this.rowKeyToIndex.get(o);
        final Integer n2 = (Integer)this.columnKeyToIndex.get(o2);
        if (n == null || n2 == null) {
            return null;
        }
        return this.set(n, n2, null);
    }
    
    @Override
    public int size() {
        return this.rowList.size() * this.columnList.size();
    }
    
    @Override
    public Set cellSet() {
        return super.cellSet();
    }
    
    @Override
    Iterator cellIterator() {
        return new ArrayTable$1(this, this.size());
    }
    
    @Override
    public Map column(final Object o) {
        Preconditions.checkNotNull(o);
        final Integer n = (Integer)this.columnKeyToIndex.get(o);
        return (n == null) ? ImmutableMap.of() : new ArrayTable$Column(this, n);
    }
    
    @Override
    public ImmutableSet columnKeySet() {
        return this.columnKeyToIndex.keySet();
    }
    
    @Override
    public Map columnMap() {
        final ArrayTable$ColumnMap columnMap = this.columnMap;
        return (columnMap == null) ? (this.columnMap = new ArrayTable$ColumnMap(this, null)) : columnMap;
    }
    
    @Override
    public Map row(final Object o) {
        Preconditions.checkNotNull(o);
        final Integer n = (Integer)this.rowKeyToIndex.get(o);
        return (n == null) ? ImmutableMap.of() : new ArrayTable$Row(this, n);
    }
    
    @Override
    public ImmutableSet rowKeySet() {
        return this.rowKeyToIndex.keySet();
    }
    
    @Override
    public Map rowMap() {
        final ArrayTable$RowMap rowMap = this.rowMap;
        return (rowMap == null) ? (this.rowMap = new ArrayTable$RowMap(this, null)) : rowMap;
    }
    
    @Override
    public Collection values() {
        return super.values();
    }
}
