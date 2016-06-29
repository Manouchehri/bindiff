package com.google.common.collect;

import com.google.common.base.*;
import javax.annotation.*;
import java.util.*;

final class TreeRangeSet$SubRangeSetRangesByLowerBound extends AbstractNavigableMap
{
    private final Range lowerBoundWindow;
    private final Range restriction;
    private final NavigableMap rangesByLowerBound;
    private final NavigableMap rangesByUpperBound;
    
    private TreeRangeSet$SubRangeSetRangesByLowerBound(final Range range, final Range range2, final NavigableMap navigableMap) {
        this.lowerBoundWindow = (Range)Preconditions.checkNotNull(range);
        this.restriction = (Range)Preconditions.checkNotNull(range2);
        this.rangesByLowerBound = (NavigableMap)Preconditions.checkNotNull(navigableMap);
        this.rangesByUpperBound = new TreeRangeSet$RangesByUpperBound(navigableMap);
    }
    
    private NavigableMap subMap(final Range range) {
        if (!range.isConnected(this.lowerBoundWindow)) {
            return ImmutableSortedMap.of();
        }
        return new TreeRangeSet$SubRangeSetRangesByLowerBound(this.lowerBoundWindow.intersection(range), this.restriction, this.rangesByLowerBound);
    }
    
    public NavigableMap subMap(final Cut cut, final boolean b, final Cut cut2, final boolean b2) {
        return this.subMap(Range.range(cut, BoundType.forBoolean(b), cut2, BoundType.forBoolean(b2)));
    }
    
    public NavigableMap headMap(final Cut cut, final boolean b) {
        return this.subMap(Range.upTo(cut, BoundType.forBoolean(b)));
    }
    
    public NavigableMap tailMap(final Cut cut, final boolean b) {
        return this.subMap(Range.downTo(cut, BoundType.forBoolean(b)));
    }
    
    @Override
    public Comparator comparator() {
        return Ordering.natural();
    }
    
    @Override
    public boolean containsKey(@Nullable final Object o) {
        return this.get(o) != null;
    }
    
    @Nullable
    @Override
    public Range get(@Nullable final Object o) {
        if (o instanceof Cut) {
            try {
                final Cut cut = (Cut)o;
                if (!this.lowerBoundWindow.contains(cut) || cut.compareTo(this.restriction.lowerBound) < 0 || cut.compareTo(this.restriction.upperBound) >= 0) {
                    return null;
                }
                if (cut.equals(this.restriction.lowerBound)) {
                    final Range range = (Range)Maps.valueOrNull((Entry)this.rangesByLowerBound.floorEntry(cut));
                    if (range != null && range.upperBound.compareTo(this.restriction.lowerBound) > 0) {
                        return range.intersection(this.restriction);
                    }
                }
                else {
                    final Range range2 = (Range)this.rangesByLowerBound.get(cut);
                    if (range2 != null) {
                        return range2.intersection(this.restriction);
                    }
                }
            }
            catch (ClassCastException ex) {
                return null;
            }
        }
        return null;
    }
    
    @Override
    Iterator entryIterator() {
        if (this.restriction.isEmpty()) {
            return Iterators.emptyIterator();
        }
        if (this.lowerBoundWindow.upperBound.isLessThan(this.restriction.lowerBound)) {
            return Iterators.emptyIterator();
        }
        Iterator<Object> iterator;
        if (this.lowerBoundWindow.lowerBound.isLessThan(this.restriction.lowerBound)) {
            iterator = this.rangesByUpperBound.tailMap(this.restriction.lowerBound, false).values().iterator();
        }
        else {
            iterator = this.rangesByLowerBound.tailMap(this.lowerBoundWindow.lowerBound.endpoint(), this.lowerBoundWindow.lowerBoundType() == BoundType.CLOSED).values().iterator();
        }
        return new TreeRangeSet$SubRangeSetRangesByLowerBound$1(this, iterator, (Cut)Ordering.natural().min(this.lowerBoundWindow.upperBound, Cut.belowValue(this.restriction.upperBound)));
    }
    
    @Override
    Iterator descendingEntryIterator() {
        if (this.restriction.isEmpty()) {
            return Iterators.emptyIterator();
        }
        final Cut cut = (Cut)Ordering.natural().min(this.lowerBoundWindow.upperBound, Cut.belowValue(this.restriction.upperBound));
        return new TreeRangeSet$SubRangeSetRangesByLowerBound$2(this, this.rangesByLowerBound.headMap(cut.endpoint(), cut.typeAsUpperBound() == BoundType.CLOSED).descendingMap().values().iterator());
    }
    
    @Override
    public int size() {
        return Iterators.size(this.entryIterator());
    }
}
