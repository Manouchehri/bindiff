/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.collect;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.collect.AbstractNavigableMap;
import com.google.common.collect.BoundType;
import com.google.common.collect.Cut;
import com.google.common.collect.ImmutableSortedMap;
import com.google.common.collect.Iterators;
import com.google.common.collect.Ordering;
import com.google.common.collect.PeekingIterator;
import com.google.common.collect.Range;
import com.google.common.collect.TreeRangeSet$RangesByUpperBound$1;
import com.google.common.collect.TreeRangeSet$RangesByUpperBound$2;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.NavigableMap;
import javax.annotation.Nullable;

@VisibleForTesting
final class TreeRangeSet$RangesByUpperBound
extends AbstractNavigableMap {
    private final NavigableMap rangesByLowerBound;
    private final Range upperBoundWindow;

    TreeRangeSet$RangesByUpperBound(NavigableMap navigableMap) {
        this.rangesByLowerBound = navigableMap;
        this.upperBoundWindow = Range.all();
    }

    private TreeRangeSet$RangesByUpperBound(NavigableMap navigableMap, Range range) {
        this.rangesByLowerBound = navigableMap;
        this.upperBoundWindow = range;
    }

    private NavigableMap subMap(Range range) {
        if (!range.isConnected(this.upperBoundWindow)) return ImmutableSortedMap.of();
        return new TreeRangeSet$RangesByUpperBound(this.rangesByLowerBound, range.intersection(this.upperBoundWindow));
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

    @Override
    public Range get(@Nullable Object object) {
        if (!(object instanceof Cut)) return null;
        try {
            Cut cut = (Cut)object;
            if (!this.upperBoundWindow.contains(cut)) {
                return null;
            }
            Map.Entry entry = this.rangesByLowerBound.lowerEntry(cut);
            if (entry == null) return null;
            if (!((Range)entry.getValue()).upperBound.equals(cut)) return null;
            return (Range)entry.getValue();
        }
        catch (ClassCastException var2_3) {
            return null;
        }
    }

    @Override
    Iterator entryIterator() {
        Iterator iterator;
        if (!this.upperBoundWindow.hasLowerBound()) {
            iterator = this.rangesByLowerBound.values().iterator();
            return new TreeRangeSet$RangesByUpperBound$1(this, iterator);
        }
        Map.Entry entry = this.rangesByLowerBound.lowerEntry(this.upperBoundWindow.lowerEndpoint());
        if (entry == null) {
            iterator = this.rangesByLowerBound.values().iterator();
            return new TreeRangeSet$RangesByUpperBound$1(this, iterator);
        }
        if (this.upperBoundWindow.lowerBound.isLessThan(((Range)entry.getValue()).upperBound)) {
            iterator = this.rangesByLowerBound.tailMap(entry.getKey(), true).values().iterator();
            return new TreeRangeSet$RangesByUpperBound$1(this, iterator);
        }
        iterator = this.rangesByLowerBound.tailMap(this.upperBoundWindow.lowerEndpoint(), true).values().iterator();
        return new TreeRangeSet$RangesByUpperBound$1(this, iterator);
    }

    @Override
    Iterator descendingEntryIterator() {
        Collection collection = this.upperBoundWindow.hasUpperBound() ? this.rangesByLowerBound.headMap(this.upperBoundWindow.upperEndpoint(), false).descendingMap().values() : this.rangesByLowerBound.descendingMap().values();
        PeekingIterator peekingIterator = Iterators.peekingIterator(collection.iterator());
        if (!peekingIterator.hasNext()) return new TreeRangeSet$RangesByUpperBound$2(this, peekingIterator);
        if (!this.upperBoundWindow.upperBound.isLessThan(((Range)peekingIterator.peek()).upperBound)) return new TreeRangeSet$RangesByUpperBound$2(this, peekingIterator);
        peekingIterator.next();
        return new TreeRangeSet$RangesByUpperBound$2(this, peekingIterator);
    }

    @Override
    public int size() {
        if (!this.upperBoundWindow.equals(Range.all())) return Iterators.size(this.entryIterator());
        return this.rangesByLowerBound.size();
    }

    @Override
    public boolean isEmpty() {
        if (this.upperBoundWindow.equals(Range.all())) {
            boolean bl2 = this.rangesByLowerBound.isEmpty();
            return bl2;
        }
        if (this.entryIterator().hasNext()) return false;
        return true;
    }

    static /* synthetic */ Range access$000(TreeRangeSet$RangesByUpperBound treeRangeSet$RangesByUpperBound) {
        return treeRangeSet$RangesByUpperBound.upperBoundWindow;
    }
}

