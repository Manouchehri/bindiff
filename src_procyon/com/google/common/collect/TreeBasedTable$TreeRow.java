package com.google.common.collect;

import javax.annotation.*;
import com.google.common.base.*;
import java.util.*;

class TreeBasedTable$TreeRow extends StandardTable$Row implements SortedMap
{
    @Nullable
    final Object lowerBound;
    @Nullable
    final Object upperBound;
    transient SortedMap wholeRow;
    final /* synthetic */ TreeBasedTable this$0;
    
    TreeBasedTable$TreeRow(final TreeBasedTable treeBasedTable, final Object o) {
        this(treeBasedTable, o, null, null);
    }
    
    TreeBasedTable$TreeRow(final TreeBasedTable this$0, final Object o, @Nullable final Object lowerBound, @Nullable final Object upperBound) {
        this.this$0 = this$0;
        super(this$0, o);
        this.lowerBound = lowerBound;
        this.upperBound = upperBound;
        Preconditions.checkArgument(lowerBound == null || upperBound == null || this.compare(lowerBound, upperBound) <= 0);
    }
    
    @Override
    public SortedSet keySet() {
        return new Maps$SortedKeySet(this);
    }
    
    @Override
    public Comparator comparator() {
        return this.this$0.columnComparator();
    }
    
    int compare(final Object o, final Object o2) {
        return this.comparator().compare(o, o2);
    }
    
    boolean rangeContains(@Nullable final Object o) {
        return o != null && (this.lowerBound == null || this.compare(this.lowerBound, o) <= 0) && (this.upperBound == null || this.compare(this.upperBound, o) > 0);
    }
    
    @Override
    public SortedMap subMap(final Object o, final Object o2) {
        Preconditions.checkArgument(this.rangeContains(Preconditions.checkNotNull(o)) && this.rangeContains(Preconditions.checkNotNull(o2)));
        return new TreeBasedTable$TreeRow(this.this$0, this.rowKey, o, o2);
    }
    
    @Override
    public SortedMap headMap(final Object o) {
        Preconditions.checkArgument(this.rangeContains(Preconditions.checkNotNull(o)));
        return new TreeBasedTable$TreeRow(this.this$0, this.rowKey, this.lowerBound, o);
    }
    
    @Override
    public SortedMap tailMap(final Object o) {
        Preconditions.checkArgument(this.rangeContains(Preconditions.checkNotNull(o)));
        return new TreeBasedTable$TreeRow(this.this$0, this.rowKey, o, this.upperBound);
    }
    
    @Override
    public Object firstKey() {
        if (this.backingRowMap() == null) {
            throw new NoSuchElementException();
        }
        return this.backingRowMap().firstKey();
    }
    
    @Override
    public Object lastKey() {
        if (this.backingRowMap() == null) {
            throw new NoSuchElementException();
        }
        return this.backingRowMap().lastKey();
    }
    
    SortedMap wholeRow() {
        if (this.wholeRow == null || (this.wholeRow.isEmpty() && this.this$0.backingMap.containsKey(this.rowKey))) {
            this.wholeRow = this.this$0.backingMap.get(this.rowKey);
        }
        return this.wholeRow;
    }
    
    @Override
    SortedMap backingRowMap() {
        return (SortedMap)super.backingRowMap();
    }
    
    @Override
    SortedMap computeBackingRowMap() {
        SortedMap<Object, Object> sortedMap = (SortedMap<Object, Object>)this.wholeRow();
        if (sortedMap != null) {
            if (this.lowerBound != null) {
                sortedMap = sortedMap.tailMap(this.lowerBound);
            }
            if (this.upperBound != null) {
                sortedMap = sortedMap.headMap(this.upperBound);
            }
            return sortedMap;
        }
        return null;
    }
    
    @Override
    void maintainEmptyInvariant() {
        if (this.wholeRow() != null && this.wholeRow.isEmpty()) {
            this.this$0.backingMap.remove(this.rowKey);
            this.wholeRow = null;
            this.backingRowMap = null;
        }
    }
    
    @Override
    public boolean containsKey(final Object o) {
        return this.rangeContains(o) && super.containsKey(o);
    }
    
    @Override
    public Object put(final Object o, final Object o2) {
        Preconditions.checkArgument(this.rangeContains(Preconditions.checkNotNull(o)));
        return super.put(o, o2);
    }
}
