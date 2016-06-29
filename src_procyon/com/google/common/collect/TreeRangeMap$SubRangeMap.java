package com.google.common.collect;

import javax.annotation.*;
import com.google.common.base.*;
import com.google.common.annotations.*;
import java.util.*;

class TreeRangeMap$SubRangeMap implements RangeMap
{
    private final Range subRange;
    final /* synthetic */ TreeRangeMap this$0;
    
    TreeRangeMap$SubRangeMap(final TreeRangeMap this$0, final Range subRange) {
        this.this$0 = this$0;
        this.subRange = subRange;
    }
    
    @Nullable
    @Override
    public Object get(final Comparable comparable) {
        return this.subRange.contains(comparable) ? this.this$0.get(comparable) : null;
    }
    
    @Nullable
    @Override
    public Map.Entry getEntry(final Comparable comparable) {
        if (this.subRange.contains(comparable)) {
            final Map.Entry entry = this.this$0.getEntry(comparable);
            if (entry != null) {
                return Maps.immutableEntry(entry.getKey().intersection(this.subRange), entry.getValue());
            }
        }
        return null;
    }
    
    @Override
    public Range span() {
        final Map.Entry<Cut, TreeRangeMap$RangeMapEntry> floorEntry = this.this$0.entriesByLowerBound.floorEntry(this.subRange.lowerBound);
        Cut lowerBound;
        if (floorEntry != null && floorEntry.getValue().getUpperBound().compareTo(this.subRange.lowerBound) > 0) {
            lowerBound = this.subRange.lowerBound;
        }
        else {
            lowerBound = this.this$0.entriesByLowerBound.ceilingKey(this.subRange.lowerBound);
            if (lowerBound == null || lowerBound.compareTo(this.subRange.upperBound) >= 0) {
                throw new NoSuchElementException();
            }
        }
        final Map.Entry<Cut, TreeRangeMap$RangeMapEntry> lowerEntry = this.this$0.entriesByLowerBound.lowerEntry(this.subRange.upperBound);
        if (lowerEntry == null) {
            throw new NoSuchElementException();
        }
        Cut cut;
        if (lowerEntry.getValue().getUpperBound().compareTo(this.subRange.upperBound) >= 0) {
            cut = this.subRange.upperBound;
        }
        else {
            cut = lowerEntry.getValue().getUpperBound();
        }
        return Range.create(lowerBound, cut);
    }
    
    @Override
    public void put(final Range range, final Object o) {
        Preconditions.checkArgument(this.subRange.encloses(range), "Cannot put range %s into a subRangeMap(%s)", range, this.subRange);
        this.this$0.put(range, o);
    }
    
    @Override
    public void putAll(final RangeMap rangeMap) {
        if (rangeMap.asMapOfRanges().isEmpty()) {
            return;
        }
        final Range span = rangeMap.span();
        Preconditions.checkArgument(this.subRange.encloses(span), "Cannot putAll rangeMap with span %s into a subRangeMap(%s)", span, this.subRange);
        this.this$0.putAll(rangeMap);
    }
    
    @Override
    public void clear() {
        this.this$0.remove(this.subRange);
    }
    
    @Override
    public void remove(final Range range) {
        if (range.isConnected(this.subRange)) {
            this.this$0.remove(range.intersection(this.subRange));
        }
    }
    
    @Override
    public RangeMap subRangeMap(final Range range) {
        if (!range.isConnected(this.subRange)) {
            return this.this$0.emptySubRangeMap();
        }
        return this.this$0.subRangeMap(range.intersection(this.subRange));
    }
    
    @Override
    public Map asMapOfRanges() {
        return new TreeRangeMap$SubRangeMap$SubRangeMapAsMap(this);
    }
    
    @Override
    public Map asDescendingMapOfRanges() {
        return new TreeRangeMap$SubRangeMap$1(this);
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
        return this.asMapOfRanges().toString();
    }
}
