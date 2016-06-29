package com.google.common.collect;

import com.google.common.annotations.*;
import javax.annotation.*;
import com.google.common.base.*;
import java.util.*;

@Beta
@GwtIncompatible("NavigableMap")
public final class TreeRangeMap implements RangeMap
{
    private final NavigableMap entriesByLowerBound;
    private static final RangeMap EMPTY_SUB_RANGE_MAP;
    
    public static TreeRangeMap create() {
        return new TreeRangeMap();
    }
    
    private TreeRangeMap() {
        this.entriesByLowerBound = Maps.newTreeMap();
    }
    
    @Nullable
    @Override
    public Object get(final Comparable comparable) {
        final Map.Entry entry = this.getEntry(comparable);
        return (entry == null) ? null : entry.getValue();
    }
    
    @Nullable
    @Override
    public Map.Entry getEntry(final Comparable comparable) {
        final Map.Entry<Cut, TreeRangeMap$RangeMapEntry> floorEntry = this.entriesByLowerBound.floorEntry(Cut.belowValue(comparable));
        if (floorEntry != null && floorEntry.getValue().contains(comparable)) {
            return floorEntry.getValue();
        }
        return null;
    }
    
    @Override
    public void put(final Range range, final Object o) {
        if (!range.isEmpty()) {
            Preconditions.checkNotNull(o);
            this.remove(range);
            this.entriesByLowerBound.put(range.lowerBound, new TreeRangeMap$RangeMapEntry(range, o));
        }
    }
    
    @Override
    public void putAll(final RangeMap rangeMap) {
        for (final Map.Entry<Range, V> entry : rangeMap.asMapOfRanges().entrySet()) {
            this.put(entry.getKey(), entry.getValue());
        }
    }
    
    @Override
    public void clear() {
        this.entriesByLowerBound.clear();
    }
    
    @Override
    public Range span() {
        final Map.Entry<K, TreeRangeMap$RangeMapEntry> firstEntry = this.entriesByLowerBound.firstEntry();
        final Map.Entry<K, TreeRangeMap$RangeMapEntry> lastEntry = this.entriesByLowerBound.lastEntry();
        if (firstEntry == null) {
            throw new NoSuchElementException();
        }
        return Range.create(firstEntry.getValue().getKey().lowerBound, lastEntry.getValue().getKey().upperBound);
    }
    
    private void putRangeMapEntry(final Cut cut, final Cut cut2, final Object o) {
        this.entriesByLowerBound.put(cut, new TreeRangeMap$RangeMapEntry(cut, cut2, o));
    }
    
    @Override
    public void remove(final Range range) {
        if (range.isEmpty()) {
            return;
        }
        final Map.Entry<Cut, TreeRangeMap$RangeMapEntry> lowerEntry = this.entriesByLowerBound.lowerEntry(range.lowerBound);
        if (lowerEntry != null) {
            final TreeRangeMap$RangeMapEntry treeRangeMap$RangeMapEntry = lowerEntry.getValue();
            if (treeRangeMap$RangeMapEntry.getUpperBound().compareTo(range.lowerBound) > 0) {
                if (treeRangeMap$RangeMapEntry.getUpperBound().compareTo(range.upperBound) > 0) {
                    this.putRangeMapEntry(range.upperBound, treeRangeMap$RangeMapEntry.getUpperBound(), lowerEntry.getValue().getValue());
                }
                this.putRangeMapEntry(treeRangeMap$RangeMapEntry.getLowerBound(), range.lowerBound, lowerEntry.getValue().getValue());
            }
        }
        final Map.Entry<Cut, TreeRangeMap$RangeMapEntry> lowerEntry2 = this.entriesByLowerBound.lowerEntry(range.upperBound);
        if (lowerEntry2 != null) {
            final TreeRangeMap$RangeMapEntry treeRangeMap$RangeMapEntry2 = lowerEntry2.getValue();
            if (treeRangeMap$RangeMapEntry2.getUpperBound().compareTo(range.upperBound) > 0) {
                this.putRangeMapEntry(range.upperBound, treeRangeMap$RangeMapEntry2.getUpperBound(), lowerEntry2.getValue().getValue());
                this.entriesByLowerBound.remove(range.lowerBound);
            }
        }
        this.entriesByLowerBound.subMap(range.lowerBound, range.upperBound).clear();
    }
    
    @Override
    public Map asMapOfRanges() {
        return new TreeRangeMap$AsMapOfRanges(this, this.entriesByLowerBound.values());
    }
    
    @Override
    public Map asDescendingMapOfRanges() {
        return new TreeRangeMap$AsMapOfRanges(this, this.entriesByLowerBound.descendingMap().values());
    }
    
    @Override
    public RangeMap subRangeMap(final Range range) {
        if (range.equals(Range.all())) {
            return this;
        }
        return new TreeRangeMap$SubRangeMap(this, range);
    }
    
    private RangeMap emptySubRangeMap() {
        return TreeRangeMap.EMPTY_SUB_RANGE_MAP;
    }
    
    @Override
    public boolean equals(@Nullable final Object o) {
        return o instanceof RangeMap && this.asMapOfRanges().equals(((RangeMap)o).asMapOfRanges());
    }
    
    @Override
    public int hashCode() {
        return this.asMapOfRanges().hashCode();
    }
    
    @Override
    public String toString() {
        return this.entriesByLowerBound.values().toString();
    }
    
    static {
        EMPTY_SUB_RANGE_MAP = new TreeRangeMap$1();
    }
}
