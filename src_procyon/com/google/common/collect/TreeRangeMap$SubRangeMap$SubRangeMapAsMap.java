package com.google.common.collect;

import javax.annotation.*;
import com.google.common.base.*;
import com.google.common.annotations.*;
import java.util.*;

class TreeRangeMap$SubRangeMap$SubRangeMapAsMap extends AbstractMap
{
    final /* synthetic */ TreeRangeMap$SubRangeMap this$1;
    
    TreeRangeMap$SubRangeMap$SubRangeMapAsMap(final TreeRangeMap$SubRangeMap this$1) {
        this.this$1 = this$1;
    }
    
    @Override
    public boolean containsKey(final Object o) {
        return this.get(o) != null;
    }
    
    @Override
    public Object get(final Object o) {
        try {
            if (o instanceof Range) {
                final Range range = (Range)o;
                if (!this.this$1.subRange.encloses(range) || range.isEmpty()) {
                    return null;
                }
                TreeRangeMap$RangeMapEntry treeRangeMap$RangeMapEntry = null;
                if (range.lowerBound.compareTo(this.this$1.subRange.lowerBound) == 0) {
                    final Map.Entry<Cut, Object> floorEntry = this.this$1.this$0.entriesByLowerBound.floorEntry(range.lowerBound);
                    if (floorEntry != null) {
                        treeRangeMap$RangeMapEntry = floorEntry.getValue();
                    }
                }
                else {
                    treeRangeMap$RangeMapEntry = (TreeRangeMap$RangeMapEntry)this.this$1.this$0.entriesByLowerBound.get(range.lowerBound);
                }
                if (treeRangeMap$RangeMapEntry != null && treeRangeMap$RangeMapEntry.getKey().isConnected(this.this$1.subRange) && treeRangeMap$RangeMapEntry.getKey().intersection(this.this$1.subRange).equals(range)) {
                    return treeRangeMap$RangeMapEntry.getValue();
                }
            }
        }
        catch (ClassCastException ex) {
            return null;
        }
        return null;
    }
    
    @Override
    public Object remove(final Object o) {
        final Object value = this.get(o);
        if (value != null) {
            this.this$1.this$0.remove((Range)o);
            return value;
        }
        return null;
    }
    
    @Override
    public void clear() {
        this.this$1.clear();
    }
    
    private boolean removeEntryIf(final Predicate predicate) {
        final ArrayList arrayList = Lists.newArrayList();
        for (final Map.Entry<Object, V> entry : this.entrySet()) {
            if (predicate.apply(entry)) {
                arrayList.add(entry.getKey());
            }
        }
        final Iterator<Range> iterator2 = arrayList.iterator();
        while (iterator2.hasNext()) {
            this.this$1.this$0.remove(iterator2.next());
        }
        return !arrayList.isEmpty();
    }
    
    @Override
    public Set keySet() {
        return new TreeRangeMap$SubRangeMap$SubRangeMapAsMap$1(this, this);
    }
    
    @Override
    public Set entrySet() {
        return new TreeRangeMap$SubRangeMap$SubRangeMapAsMap$2(this);
    }
    
    Iterator entryIterator() {
        if (this.this$1.subRange.isEmpty()) {
            return Iterators.emptyIterator();
        }
        return new TreeRangeMap$SubRangeMap$SubRangeMapAsMap$3(this, this.this$1.this$0.entriesByLowerBound.tailMap(MoreObjects.firstNonNull(this.this$1.this$0.entriesByLowerBound.floorKey(this.this$1.subRange.lowerBound), this.this$1.subRange.lowerBound), true).values().iterator());
    }
    
    @Override
    public Collection values() {
        return new TreeRangeMap$SubRangeMap$SubRangeMapAsMap$4(this, this);
    }
}
