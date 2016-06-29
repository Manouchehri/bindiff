/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.AbstractTable;
import com.google.common.collect.ArrayTable$1;
import com.google.common.collect.ArrayTable$Column;
import com.google.common.collect.ArrayTable$ColumnMap;
import com.google.common.collect.ArrayTable$Row;
import com.google.common.collect.ArrayTable$RowMap;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Maps;
import com.google.common.collect.Table;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;

@Beta
@GwtCompatible(emulated=1)
public final class ArrayTable
extends AbstractTable
implements Serializable {
    private final ImmutableList rowList;
    private final ImmutableList columnList;
    private final ImmutableMap rowKeyToIndex;
    private final ImmutableMap columnKeyToIndex;
    private final Object[][] array;
    private transient ArrayTable$ColumnMap columnMap;
    private transient ArrayTable$RowMap rowMap;
    private static final long serialVersionUID = 0;

    public static ArrayTable create(Iterable iterable, Iterable iterable2) {
        return new ArrayTable(iterable, iterable2);
    }

    public static ArrayTable create(Table table) {
        ArrayTable arrayTable;
        if (table instanceof ArrayTable) {
            arrayTable = new ArrayTable((ArrayTable)table);
            return arrayTable;
        }
        arrayTable = new ArrayTable(table);
        return arrayTable;
    }

    private ArrayTable(Iterable iterable, Iterable iterable2) {
        Object[][] arrobject;
        this.rowList = ImmutableList.copyOf(iterable);
        this.columnList = ImmutableList.copyOf(iterable2);
        Preconditions.checkArgument(!this.rowList.isEmpty());
        Preconditions.checkArgument(!this.columnList.isEmpty());
        this.rowKeyToIndex = Maps.indexMap(this.rowList);
        this.columnKeyToIndex = Maps.indexMap(this.columnList);
        this.array = arrobject = new Object[this.rowList.size()][this.columnList.size()];
        this.eraseAll();
    }

    private ArrayTable(Table table) {
        this(table.rowKeySet(), table.columnKeySet());
        this.putAll(table);
    }

    private ArrayTable(ArrayTable arrayTable) {
        Object[][] arrobject;
        this.rowList = arrayTable.rowList;
        this.columnList = arrayTable.columnList;
        this.rowKeyToIndex = arrayTable.rowKeyToIndex;
        this.columnKeyToIndex = arrayTable.columnKeyToIndex;
        this.array = arrobject = new Object[this.rowList.size()][this.columnList.size()];
        this.eraseAll();
        int n2 = 0;
        while (n2 < this.rowList.size()) {
            System.arraycopy(arrayTable.array[n2], 0, arrobject[n2], 0, arrayTable.array[n2].length);
            ++n2;
        }
    }

    public ImmutableList rowKeyList() {
        return this.rowList;
    }

    public ImmutableList columnKeyList() {
        return this.columnList;
    }

    public Object at(int n2, int n3) {
        Preconditions.checkElementIndex(n2, this.rowList.size());
        Preconditions.checkElementIndex(n3, this.columnList.size());
        return this.array[n2][n3];
    }

    public Object set(int n2, int n3, @Nullable Object object) {
        Preconditions.checkElementIndex(n2, this.rowList.size());
        Preconditions.checkElementIndex(n3, this.columnList.size());
        Object object2 = this.array[n2][n3];
        this.array[n2][n3] = object;
        return object2;
    }

    @GwtIncompatible(value="reflection")
    public Object[][] toArray(Class class_) {
        Object[][] arrobject = (Object[][])Array.newInstance(class_, this.rowList.size(), this.columnList.size());
        int n2 = 0;
        while (n2 < this.rowList.size()) {
            System.arraycopy(this.array[n2], 0, arrobject[n2], 0, this.array[n2].length);
            ++n2;
        }
        return arrobject;
    }

    @Deprecated
    @Override
    public void clear() {
        throw new UnsupportedOperationException();
    }

    public void eraseAll() {
        Object[][] arrobject = this.array;
        int n2 = arrobject.length;
        int n3 = 0;
        while (n3 < n2) {
            Object[] arrobject2 = arrobject[n3];
            Arrays.fill(arrobject2, null);
            ++n3;
        }
    }

    @Override
    public boolean contains(@Nullable Object object, @Nullable Object object2) {
        if (!this.containsRow(object)) return false;
        if (!this.containsColumn(object2)) return false;
        return true;
    }

    @Override
    public boolean containsColumn(@Nullable Object object) {
        return this.columnKeyToIndex.containsKey(object);
    }

    @Override
    public boolean containsRow(@Nullable Object object) {
        return this.rowKeyToIndex.containsKey(object);
    }

    @Override
    public boolean containsValue(@Nullable Object object) {
        Object[][] arrobject = this.array;
        int n2 = arrobject.length;
        int n3 = 0;
        while (n3 < n2) {
            Object[] arrobject2;
            for (Object object2 : arrobject2 = arrobject[n3]) {
                if (!Objects.equal(object, object2)) continue;
                return true;
            }
            ++n3;
        }
        return false;
    }

    @Override
    public Object get(@Nullable Object object, @Nullable Object object2) {
        Integer n2 = (Integer)this.rowKeyToIndex.get(object);
        Integer n3 = (Integer)this.columnKeyToIndex.get(object2);
        if (n2 == null) return null;
        if (n3 == null) return null;
        Object object3 = this.at(n2, n3);
        return object3;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public Object put(Object object, Object object2, @Nullable Object object3) {
        Preconditions.checkNotNull(object);
        Preconditions.checkNotNull(object2);
        Integer n2 = (Integer)this.rowKeyToIndex.get(object);
        Preconditions.checkArgument(n2 != null, "Row %s not in %s", object, this.rowList);
        Integer n3 = (Integer)this.columnKeyToIndex.get(object2);
        Preconditions.checkArgument(n3 != null, "Column %s not in %s", object2, this.columnList);
        return this.set(n2, n3, object3);
    }

    @Override
    public void putAll(Table table) {
        super.putAll(table);
    }

    @Deprecated
    @Override
    public Object remove(Object object, Object object2) {
        throw new UnsupportedOperationException();
    }

    public Object erase(@Nullable Object object, @Nullable Object object2) {
        Integer n2 = (Integer)this.rowKeyToIndex.get(object);
        Integer n3 = (Integer)this.columnKeyToIndex.get(object2);
        if (n2 == null) return null;
        if (n3 != null) return this.set(n2, n3, null);
        return null;
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
    public Map column(Object object) {
        ImmutableMap immutableMap /* !! */ ;
        Preconditions.checkNotNull(object);
        Integer n2 = (Integer)this.columnKeyToIndex.get(object);
        if (n2 == null) {
            immutableMap /* !! */  = ImmutableMap.of();
            return immutableMap /* !! */ ;
        }
        immutableMap /* !! */  = new ArrayTable$Column(this, n2);
        return immutableMap /* !! */ ;
    }

    @Override
    public ImmutableSet columnKeySet() {
        return this.columnKeyToIndex.keySet();
    }

    @Override
    public Map columnMap() {
        ArrayTable$ColumnMap arrayTable$ColumnMap;
        ArrayTable$ColumnMap arrayTable$ColumnMap2 = this.columnMap;
        if (arrayTable$ColumnMap2 == null) {
            arrayTable$ColumnMap = this.columnMap = new ArrayTable$ColumnMap(this, null);
            return arrayTable$ColumnMap;
        }
        arrayTable$ColumnMap = arrayTable$ColumnMap2;
        return arrayTable$ColumnMap;
    }

    @Override
    public Map row(Object object) {
        ImmutableMap immutableMap /* !! */ ;
        Preconditions.checkNotNull(object);
        Integer n2 = (Integer)this.rowKeyToIndex.get(object);
        if (n2 == null) {
            immutableMap /* !! */  = ImmutableMap.of();
            return immutableMap /* !! */ ;
        }
        immutableMap /* !! */  = new ArrayTable$Row(this, n2);
        return immutableMap /* !! */ ;
    }

    @Override
    public ImmutableSet rowKeySet() {
        return this.rowKeyToIndex.keySet();
    }

    @Override
    public Map rowMap() {
        ArrayTable$RowMap arrayTable$RowMap;
        ArrayTable$RowMap arrayTable$RowMap2 = this.rowMap;
        if (arrayTable$RowMap2 == null) {
            arrayTable$RowMap = this.rowMap = new ArrayTable$RowMap(this, null);
            return arrayTable$RowMap;
        }
        arrayTable$RowMap = arrayTable$RowMap2;
        return arrayTable$RowMap;
    }

    @Override
    public Collection values() {
        return super.values();
    }

    static /* synthetic */ ImmutableList access$000(ArrayTable arrayTable) {
        return arrayTable.columnList;
    }

    static /* synthetic */ ImmutableList access$100(ArrayTable arrayTable) {
        return arrayTable.rowList;
    }

    static /* synthetic */ ImmutableMap access$200(ArrayTable arrayTable) {
        return arrayTable.rowKeyToIndex;
    }

    static /* synthetic */ ImmutableMap access$500(ArrayTable arrayTable) {
        return arrayTable.columnKeyToIndex;
    }
}

