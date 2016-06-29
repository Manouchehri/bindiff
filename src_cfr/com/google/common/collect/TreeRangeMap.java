/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.Cut;
import com.google.common.collect.Maps;
import com.google.common.collect.Range;
import com.google.common.collect.RangeMap;
import com.google.common.collect.TreeRangeMap$1;
import com.google.common.collect.TreeRangeMap$AsMapOfRanges;
import com.google.common.collect.TreeRangeMap$RangeMapEntry;
import com.google.common.collect.TreeRangeMap$SubRangeMap;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.SortedMap;
import javax.annotation.Nullable;

@Beta
@GwtIncompatible(value="NavigableMap")
public final class TreeRangeMap
implements RangeMap {
    private final NavigableMap entriesByLowerBound = Maps.newTreeMap();
    private static final RangeMap EMPTY_SUB_RANGE_MAP = new TreeRangeMap$1();

    public static TreeRangeMap create() {
        return new TreeRangeMap();
    }

    private TreeRangeMap() {
    }

    @Nullable
    @Override
    public Object get(Comparable comparable) {
        Map.Entry entry = this.getEntry(comparable);
        if (entry == null) {
            return null;
        }
        Object v0 = entry.getValue();
        return v0;
    }

    @Nullable
    @Override
    public Map.Entry getEntry(Comparable comparable) {
        Map.Entry entry = this.entriesByLowerBound.floorEntry(Cut.belowValue(comparable));
        if (entry == null) return null;
        if (!((TreeRangeMap$RangeMapEntry)entry.getValue()).contains(comparable)) return null;
        return (Map.Entry)entry.getValue();
    }

    @Override
    public void put(Range range, Object object) {
        if (range.isEmpty()) return;
        Preconditions.checkNotNull(object);
        this.remove(range);
        this.entriesByLowerBound.put(range.lowerBound, new TreeRangeMap$RangeMapEntry(range, object));
    }

    @Override
    public void putAll(RangeMap rangeMap) {
        Iterator iterator = rangeMap.asMapOfRanges().entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry entry = iterator.next();
            this.put((Range)entry.getKey(), entry.getValue());
        }
    }

    @Override
    public void clear() {
        this.entriesByLowerBound.clear();
    }

    @Override
    public Range span() {
        Map.Entry entry = this.entriesByLowerBound.firstEntry();
        Map.Entry entry2 = this.entriesByLowerBound.lastEntry();
        if (entry != null) return Range.create(((TreeRangeMap$RangeMapEntry)entry.getValue()).getKey().lowerBound, ((TreeRangeMap$RangeMapEntry)entry2.getValue()).getKey().upperBound);
        throw new NoSuchElementException();
    }

    private void putRangeMapEntry(Cut cut, Cut cut2, Object object) {
        this.entriesByLowerBound.put(cut, new TreeRangeMap$RangeMapEntry(cut, cut2, object));
    }

    @Override
    public void remove(Range range) {
        Map.Entry entry;
        TreeRangeMap$RangeMapEntry treeRangeMap$RangeMapEntry;
        if (range.isEmpty()) {
            return;
        }
        Map.Entry entry2 = this.entriesByLowerBound.lowerEntry(range.lowerBound);
        if (entry2 != null && (entry = (TreeRangeMap$RangeMapEntry)entry2.getValue()).getUpperBound().compareTo(range.lowerBound) > 0) {
            if (entry.getUpperBound().compareTo(range.upperBound) > 0) {
                this.putRangeMapEntry(range.upperBound, entry.getUpperBound(), ((TreeRangeMap$RangeMapEntry)entry2.getValue()).getValue());
            }
            this.putRangeMapEntry(entry.getLowerBound(), range.lowerBound, ((TreeRangeMap$RangeMapEntry)entry2.getValue()).getValue());
        }
        if ((entry = this.entriesByLowerBound.lowerEntry(range.upperBound)) != null && (treeRangeMap$RangeMapEntry = (TreeRangeMap$RangeMapEntry)entry.getValue()).getUpperBound().compareTo(range.upperBound) > 0) {
            this.putRangeMapEntry(range.upperBound, treeRangeMap$RangeMapEntry.getUpperBound(), ((TreeRangeMap$RangeMapEntry)entry.getValue()).getValue());
            this.entriesByLowerBound.remove(range.lowerBound);
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
    public RangeMap subRangeMap(Range range) {
        if (!range.equals(Range.all())) return new TreeRangeMap$SubRangeMap(this, range);
        return this;
    }

    private RangeMap emptySubRangeMap() {
        return EMPTY_SUB_RANGE_MAP;
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
        return this.entriesByLowerBound.values().toString();
    }

    static /* synthetic */ NavigableMap access$000(TreeRangeMap treeRangeMap) {
        return treeRangeMap.entriesByLowerBound;
    }

    static /* synthetic */ RangeMap access$100(TreeRangeMap treeRangeMap) {
        return treeRangeMap.emptySubRangeMap();
    }
}

