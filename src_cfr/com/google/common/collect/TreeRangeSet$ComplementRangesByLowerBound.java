/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.collect;

import com.google.common.base.MoreObjects;
import com.google.common.collect.AbstractNavigableMap;
import com.google.common.collect.BoundType;
import com.google.common.collect.Cut;
import com.google.common.collect.ImmutableSortedMap;
import com.google.common.collect.Iterators;
import com.google.common.collect.Ordering;
import com.google.common.collect.PeekingIterator;
import com.google.common.collect.Range;
import com.google.common.collect.TreeRangeSet$ComplementRangesByLowerBound$1;
import com.google.common.collect.TreeRangeSet$ComplementRangesByLowerBound$2;
import com.google.common.collect.TreeRangeSet$RangesByUpperBound;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.NavigableMap;
import javax.annotation.Nullable;

final class TreeRangeSet$ComplementRangesByLowerBound
extends AbstractNavigableMap {
    private final NavigableMap positiveRangesByLowerBound;
    private final NavigableMap positiveRangesByUpperBound;
    private final Range complementLowerBoundWindow;

    TreeRangeSet$ComplementRangesByLowerBound(NavigableMap navigableMap) {
        this(navigableMap, Range.all());
    }

    private TreeRangeSet$ComplementRangesByLowerBound(NavigableMap navigableMap, Range range) {
        this.positiveRangesByLowerBound = navigableMap;
        this.positiveRangesByUpperBound = new TreeRangeSet$RangesByUpperBound(navigableMap);
        this.complementLowerBoundWindow = range;
    }

    private NavigableMap subMap(Range range) {
        if (!this.complementLowerBoundWindow.isConnected(range)) {
            return ImmutableSortedMap.of();
        }
        range = range.intersection(this.complementLowerBoundWindow);
        return new TreeRangeSet$ComplementRangesByLowerBound(this.positiveRangesByLowerBound, range);
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
    Iterator entryIterator() {
        Cut cut;
        Collection collection = this.complementLowerBoundWindow.hasLowerBound() ? this.positiveRangesByUpperBound.tailMap(this.complementLowerBoundWindow.lowerEndpoint(), this.complementLowerBoundWindow.lowerBoundType() == BoundType.CLOSED).values() : this.positiveRangesByUpperBound.values();
        PeekingIterator peekingIterator = Iterators.peekingIterator(collection.iterator());
        if (this.complementLowerBoundWindow.contains(Cut.belowAll()) && (!peekingIterator.hasNext() || ((Range)peekingIterator.peek()).lowerBound != Cut.belowAll())) {
            cut = Cut.belowAll();
            return new TreeRangeSet$ComplementRangesByLowerBound$1(this, cut, peekingIterator);
        }
        if (!peekingIterator.hasNext()) return Iterators.emptyIterator();
        cut = ((Range)peekingIterator.next()).upperBound;
        return new TreeRangeSet$ComplementRangesByLowerBound$1(this, cut, peekingIterator);
    }

    @Override
    Iterator descendingEntryIterator() {
        boolean bl2;
        Cut cut;
        Cut cut2 = this.complementLowerBoundWindow.hasUpperBound() ? (Cut)this.complementLowerBoundWindow.upperEndpoint() : Cut.aboveAll();
        PeekingIterator peekingIterator = Iterators.peekingIterator(this.positiveRangesByUpperBound.headMap(cut2, bl2 = this.complementLowerBoundWindow.hasUpperBound() && this.complementLowerBoundWindow.upperBoundType() == BoundType.CLOSED).descendingMap().values().iterator());
        if (peekingIterator.hasNext()) {
            cut = ((Range)peekingIterator.peek()).upperBound == Cut.aboveAll() ? ((Range)peekingIterator.next()).lowerBound : this.positiveRangesByLowerBound.higherKey(((Range)peekingIterator.peek()).upperBound);
        } else {
            if (!this.complementLowerBoundWindow.contains(Cut.belowAll())) return Iterators.emptyIterator();
            if (this.positiveRangesByLowerBound.containsKey(Cut.belowAll())) {
                return Iterators.emptyIterator();
            }
            cut = this.positiveRangesByLowerBound.higherKey(Cut.belowAll());
        }
        Cut cut3 = (Cut)MoreObjects.firstNonNull(cut, Cut.aboveAll());
        return new TreeRangeSet$ComplementRangesByLowerBound$2(this, cut3, peekingIterator);
    }

    @Override
    public int size() {
        return Iterators.size(this.entryIterator());
    }

    @Nullable
    @Override
    public Range get(Object object) {
        if (!(object instanceof Cut)) return null;
        try {
            Cut cut = (Cut)object;
            Map.Entry entry = this.tailMap(cut, true).firstEntry();
            if (entry == null) return null;
            if (!((Cut)entry.getKey()).equals(cut)) return null;
            return (Range)entry.getValue();
        }
        catch (ClassCastException var2_3) {
            return null;
        }
    }

    @Override
    public boolean containsKey(Object object) {
        if (this.get(object) == null) return false;
        return true;
    }

    static /* synthetic */ Range access$100(TreeRangeSet$ComplementRangesByLowerBound treeRangeSet$ComplementRangesByLowerBound) {
        return treeRangeSet$ComplementRangesByLowerBound.complementLowerBoundWindow;
    }
}

