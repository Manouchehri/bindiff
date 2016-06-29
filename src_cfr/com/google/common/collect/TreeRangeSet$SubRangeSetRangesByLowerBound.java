/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.collect.AbstractNavigableMap;
import com.google.common.collect.BoundType;
import com.google.common.collect.Cut;
import com.google.common.collect.ImmutableSortedMap;
import com.google.common.collect.Iterators;
import com.google.common.collect.Maps;
import com.google.common.collect.Ordering;
import com.google.common.collect.Range;
import com.google.common.collect.TreeRangeSet$1;
import com.google.common.collect.TreeRangeSet$RangesByUpperBound;
import com.google.common.collect.TreeRangeSet$SubRangeSetRangesByLowerBound$1;
import com.google.common.collect.TreeRangeSet$SubRangeSetRangesByLowerBound$2;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.NavigableMap;
import javax.annotation.Nullable;

final class TreeRangeSet$SubRangeSetRangesByLowerBound
extends AbstractNavigableMap {
    private final Range lowerBoundWindow;
    private final Range restriction;
    private final NavigableMap rangesByLowerBound;
    private final NavigableMap rangesByUpperBound;

    private TreeRangeSet$SubRangeSetRangesByLowerBound(Range range, Range range2, NavigableMap navigableMap) {
        this.lowerBoundWindow = (Range)Preconditions.checkNotNull(range);
        this.restriction = (Range)Preconditions.checkNotNull(range2);
        this.rangesByLowerBound = (NavigableMap)Preconditions.checkNotNull(navigableMap);
        this.rangesByUpperBound = new TreeRangeSet$RangesByUpperBound(navigableMap);
    }

    private NavigableMap subMap(Range range) {
        if (range.isConnected(this.lowerBoundWindow)) return new TreeRangeSet$SubRangeSetRangesByLowerBound(this.lowerBoundWindow.intersection(range), this.restriction, this.rangesByLowerBound);
        return ImmutableSortedMap.of();
    }

    public NavigableMap subMap(Cut cut, boolean bl2, Cut cut2, boolean bl3) {
        return this.subMap(Range.range(cut, BoundType.forBoolean(bl2), cut2, BoundType.forBoolean(bl3)));
    }

    public NavigableMap headMap(Cut cut, boolean bl2) {
        return this.subMap(Range.upTo(cut, BoundType.forBoolean(bl2)));
    }

    public NavigableMap tailMap(Cut cut, boolean bl2) {
        return this.subMap(Range.downTo(cut, BoundType.forBoolean(bl2)));
    }

    @Override
    public Comparator comparator() {
        return Ordering.natural();
    }

    @Override
    public boolean containsKey(@Nullable Object object) {
        if (this.get(object) == null) return false;
        return true;
    }

    @Nullable
    @Override
    public Range get(@Nullable Object object) {
        if (!(object instanceof Cut)) return null;
        try {
            Cut cut = (Cut)object;
            if (!this.lowerBoundWindow.contains(cut)) return null;
            if (cut.compareTo(this.restriction.lowerBound) < 0) return null;
            if (cut.compareTo(this.restriction.upperBound) >= 0) {
                return null;
            }
            if (cut.equals(this.restriction.lowerBound)) {
                Range range = (Range)Maps.valueOrNull(this.rangesByLowerBound.floorEntry(cut));
                if (range == null) return null;
                if (range.upperBound.compareTo(this.restriction.lowerBound) <= 0) return null;
                return range.intersection(this.restriction);
            }
            Range range = (Range)this.rangesByLowerBound.get(cut);
            if (range == null) return null;
            return range.intersection(this.restriction);
        }
        catch (ClassCastException var2_3) {
            return null;
        }
    }

    @Override
    Iterator entryIterator() {
        if (this.restriction.isEmpty()) {
            return Iterators.emptyIterator();
        }
        if (this.lowerBoundWindow.upperBound.isLessThan(this.restriction.lowerBound)) {
            return Iterators.emptyIterator();
        }
        Iterator iterator = this.lowerBoundWindow.lowerBound.isLessThan(this.restriction.lowerBound) ? this.rangesByUpperBound.tailMap(this.restriction.lowerBound, false).values().iterator() : this.rangesByLowerBound.tailMap(this.lowerBoundWindow.lowerBound.endpoint(), this.lowerBoundWindow.lowerBoundType() == BoundType.CLOSED).values().iterator();
        Cut cut = (Cut)Ordering.natural().min(this.lowerBoundWindow.upperBound, Cut.belowValue(this.restriction.upperBound));
        return new TreeRangeSet$SubRangeSetRangesByLowerBound$1(this, iterator, cut);
    }

    @Override
    Iterator descendingEntryIterator() {
        Cut cut;
        if (this.restriction.isEmpty()) {
            return Iterators.emptyIterator();
        }
        Iterator iterator = this.rangesByLowerBound.headMap(cut.endpoint(), (cut = (Cut)Ordering.natural().min(this.lowerBoundWindow.upperBound, Cut.belowValue(this.restriction.upperBound))).typeAsUpperBound() == BoundType.CLOSED).descendingMap().values().iterator();
        return new TreeRangeSet$SubRangeSetRangesByLowerBound$2(this, iterator);
    }

    @Override
    public int size() {
        return Iterators.size(this.entryIterator());
    }

    static /* synthetic */ Range access$300(TreeRangeSet$SubRangeSetRangesByLowerBound treeRangeSet$SubRangeSetRangesByLowerBound) {
        return treeRangeSet$SubRangeSetRangesByLowerBound.restriction;
    }

    static /* synthetic */ Range access$400(TreeRangeSet$SubRangeSetRangesByLowerBound treeRangeSet$SubRangeSetRangesByLowerBound) {
        return treeRangeSet$SubRangeSetRangesByLowerBound.lowerBoundWindow;
    }

    /* synthetic */ TreeRangeSet$SubRangeSetRangesByLowerBound(Range range, Range range2, NavigableMap navigableMap, TreeRangeSet$1 treeRangeSet$1) {
        this(range, range2, navigableMap);
    }
}

