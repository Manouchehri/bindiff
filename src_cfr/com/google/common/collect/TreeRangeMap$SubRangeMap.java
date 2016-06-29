/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.collect.Cut;
import com.google.common.collect.Maps;
import com.google.common.collect.Range;
import com.google.common.collect.RangeMap;
import com.google.common.collect.TreeRangeMap;
import com.google.common.collect.TreeRangeMap$RangeMapEntry;
import com.google.common.collect.TreeRangeMap$SubRangeMap$1;
import com.google.common.collect.TreeRangeMap$SubRangeMap$SubRangeMapAsMap;
import java.util.Map;
import java.util.NoSuchElementException;
import javax.annotation.Nullable;

class TreeRangeMap$SubRangeMap
implements RangeMap {
    private final Range subRange;
    final /* synthetic */ TreeRangeMap this$0;

    TreeRangeMap$SubRangeMap(TreeRangeMap treeRangeMap, Range range) {
        this.this$0 = treeRangeMap;
        this.subRange = range;
    }

    @Nullable
    @Override
    public Object get(Comparable comparable) {
        if (!this.subRange.contains(comparable)) return null;
        Object object = this.this$0.get(comparable);
        return object;
    }

    @Nullable
    @Override
    public Map.Entry getEntry(Comparable comparable) {
        if (!this.subRange.contains(comparable)) return null;
        Map.Entry entry = this.this$0.getEntry(comparable);
        if (entry == null) return null;
        return Maps.immutableEntry(((Range)entry.getKey()).intersection(this.subRange), entry.getValue());
    }

    @Override
    public Range span() {
        Cut cut;
        Cut cut2;
        Map.Entry entry = TreeRangeMap.access$000(this.this$0).floorEntry(this.subRange.lowerBound);
        if (entry != null && ((TreeRangeMap$RangeMapEntry)entry.getValue()).getUpperBound().compareTo(this.subRange.lowerBound) > 0) {
            cut = this.subRange.lowerBound;
        } else {
            cut = TreeRangeMap.access$000(this.this$0).ceilingKey(this.subRange.lowerBound);
            if (cut == null) throw new NoSuchElementException();
            if (cut.compareTo(this.subRange.upperBound) >= 0) {
                throw new NoSuchElementException();
            }
        }
        Map.Entry entry2 = TreeRangeMap.access$000(this.this$0).lowerEntry(this.subRange.upperBound);
        if (entry2 == null) {
            throw new NoSuchElementException();
        }
        if (((TreeRangeMap$RangeMapEntry)entry2.getValue()).getUpperBound().compareTo(this.subRange.upperBound) >= 0) {
            cut2 = this.subRange.upperBound;
            return Range.create(cut, cut2);
        }
        cut2 = ((TreeRangeMap$RangeMapEntry)entry2.getValue()).getUpperBound();
        return Range.create(cut, cut2);
    }

    @Override
    public void put(Range range, Object object) {
        Preconditions.checkArgument(this.subRange.encloses(range), "Cannot put range %s into a subRangeMap(%s)", range, this.subRange);
        this.this$0.put(range, object);
    }

    @Override
    public void putAll(RangeMap rangeMap) {
        if (rangeMap.asMapOfRanges().isEmpty()) {
            return;
        }
        Range range = rangeMap.span();
        Preconditions.checkArgument(this.subRange.encloses(range), "Cannot putAll rangeMap with span %s into a subRangeMap(%s)", range, this.subRange);
        this.this$0.putAll(rangeMap);
    }

    @Override
    public void clear() {
        this.this$0.remove(this.subRange);
    }

    @Override
    public void remove(Range range) {
        if (!range.isConnected(this.subRange)) return;
        this.this$0.remove(range.intersection(this.subRange));
    }

    @Override
    public RangeMap subRangeMap(Range range) {
        if (range.isConnected(this.subRange)) return this.this$0.subRangeMap(range.intersection(this.subRange));
        return TreeRangeMap.access$100(this.this$0);
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
    public boolean equals(@Nullable Object object) {
        if (!(object instanceof RangeMap)) return false;
        RangeMap rangeMap = (RangeMap)object;
        return this.asMapOfRanges().equals(rangeMap.asMapOfRanges());
    }

    @Override
    public int hashCode() {
        return this.asMapOfRanges().hashCode();
    }

    @Override
    public String toString() {
        return this.asMapOfRanges().toString();
    }

    static /* synthetic */ Range access$200(TreeRangeMap$SubRangeMap treeRangeMap$SubRangeMap) {
        return treeRangeMap$SubRangeMap.subRange;
    }
}

