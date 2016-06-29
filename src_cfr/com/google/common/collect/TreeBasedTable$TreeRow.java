/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.collect.Maps$SortedKeySet;
import com.google.common.collect.StandardTable;
import com.google.common.collect.StandardTable$Row;
import com.google.common.collect.TreeBasedTable;
import java.util.Comparator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import javax.annotation.Nullable;

class TreeBasedTable$TreeRow
extends StandardTable$Row
implements SortedMap {
    @Nullable
    final Object lowerBound;
    @Nullable
    final Object upperBound;
    transient SortedMap wholeRow;
    final /* synthetic */ TreeBasedTable this$0;

    TreeBasedTable$TreeRow(TreeBasedTable treeBasedTable, Object object) {
        this(treeBasedTable, object, null, null);
    }

    TreeBasedTable$TreeRow(TreeBasedTable treeBasedTable, Object object, @Nullable Object object2, @Nullable Object object3) {
        this.this$0 = treeBasedTable;
        super(treeBasedTable, object);
        this.lowerBound = object2;
        this.upperBound = object3;
        Preconditions.checkArgument(object2 == null || object3 == null || this.compare(object2, object3) <= 0);
    }

    public SortedSet keySet() {
        return new Maps$SortedKeySet(this);
    }

    public Comparator comparator() {
        return this.this$0.columnComparator();
    }

    int compare(Object object, Object object2) {
        Comparator comparator = this.comparator();
        return comparator.compare(object, object2);
    }

    boolean rangeContains(@Nullable Object object) {
        if (object == null) return false;
        if (this.lowerBound != null) {
            if (this.compare(this.lowerBound, object) > 0) return false;
        }
        if (this.upperBound == null) return true;
        if (this.compare(this.upperBound, object) <= 0) return false;
        return true;
    }

    public SortedMap subMap(Object object, Object object2) {
        Preconditions.checkArgument(this.rangeContains(Preconditions.checkNotNull(object)) && this.rangeContains(Preconditions.checkNotNull(object2)));
        return new TreeBasedTable$TreeRow(this.this$0, this.rowKey, object, object2);
    }

    public SortedMap headMap(Object object) {
        Preconditions.checkArgument(this.rangeContains(Preconditions.checkNotNull(object)));
        return new TreeBasedTable$TreeRow(this.this$0, this.rowKey, this.lowerBound, object);
    }

    public SortedMap tailMap(Object object) {
        Preconditions.checkArgument(this.rangeContains(Preconditions.checkNotNull(object)));
        return new TreeBasedTable$TreeRow(this.this$0, this.rowKey, object, this.upperBound);
    }

    public Object firstKey() {
        SortedMap sortedMap = this.backingRowMap();
        if (sortedMap != null) return this.backingRowMap().firstKey();
        throw new NoSuchElementException();
    }

    public Object lastKey() {
        SortedMap sortedMap = this.backingRowMap();
        if (sortedMap != null) return this.backingRowMap().lastKey();
        throw new NoSuchElementException();
    }

    SortedMap wholeRow() {
        if (this.wholeRow != null) {
            if (!this.wholeRow.isEmpty()) return this.wholeRow;
            if (!this.this$0.backingMap.containsKey(this.rowKey)) return this.wholeRow;
        }
        this.wholeRow = (SortedMap)this.this$0.backingMap.get(this.rowKey);
        return this.wholeRow;
    }

    @Override
    SortedMap backingRowMap() {
        return (SortedMap)super.backingRowMap();
    }

    @Override
    SortedMap computeBackingRowMap() {
        SortedMap sortedMap = this.wholeRow();
        if (sortedMap == null) return null;
        if (this.lowerBound != null) {
            sortedMap = sortedMap.tailMap(this.lowerBound);
        }
        if (this.upperBound == null) return sortedMap;
        return sortedMap.headMap(this.upperBound);
    }

    @Override
    void maintainEmptyInvariant() {
        if (this.wholeRow() == null) return;
        if (!this.wholeRow.isEmpty()) return;
        this.this$0.backingMap.remove(this.rowKey);
        this.wholeRow = null;
        this.backingRowMap = null;
    }

    @Override
    public boolean containsKey(Object object) {
        if (!this.rangeContains(object)) return false;
        if (!super.containsKey(object)) return false;
        return true;
    }

    @Override
    public Object put(Object object, Object object2) {
        Preconditions.checkArgument(this.rangeContains(Preconditions.checkNotNull(object)));
        return super.put(object, object2);
    }
}

