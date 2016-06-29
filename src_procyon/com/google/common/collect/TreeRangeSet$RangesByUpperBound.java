package com.google.common.collect;

import com.google.common.annotations.*;
import javax.annotation.*;
import java.util.*;

@VisibleForTesting
final class TreeRangeSet$RangesByUpperBound extends AbstractNavigableMap
{
    private final NavigableMap rangesByLowerBound;
    private final Range upperBoundWindow;
    
    TreeRangeSet$RangesByUpperBound(final NavigableMap rangesByLowerBound) {
        this.rangesByLowerBound = rangesByLowerBound;
        this.upperBoundWindow = Range.all();
    }
    
    private TreeRangeSet$RangesByUpperBound(final NavigableMap rangesByLowerBound, final Range upperBoundWindow) {
        this.rangesByLowerBound = rangesByLowerBound;
        this.upperBoundWindow = upperBoundWindow;
    }
    
    private NavigableMap subMap(final Range range) {
        if (range.isConnected(this.upperBoundWindow)) {
            return new TreeRangeSet$RangesByUpperBound(this.rangesByLowerBound, range.intersection(this.upperBoundWindow));
        }
        return ImmutableSortedMap.of();
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
    
    @Override
    public Range get(@Nullable final Object o) {
        if (o instanceof Cut) {
            try {
                final Cut cut = (Cut)o;
                if (!this.upperBoundWindow.contains(cut)) {
                    return null;
                }
                final Map.Entry<Cut, Object> lowerEntry = this.rangesByLowerBound.lowerEntry(cut);
                if (lowerEntry != null && lowerEntry.getValue().upperBound.equals(cut)) {
                    return lowerEntry.getValue();
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
        Iterator<Object> iterator;
        if (!this.upperBoundWindow.hasLowerBound()) {
            iterator = (Iterator<Object>)this.rangesByLowerBound.values().iterator();
        }
        else {
            final Map.Entry<Comparable, Range> lowerEntry = this.rangesByLowerBound.lowerEntry(this.upperBoundWindow.lowerEndpoint());
            if (lowerEntry == null) {
                iterator = (Iterator<Object>)this.rangesByLowerBound.values().iterator();
            }
            else if (this.upperBoundWindow.lowerBound.isLessThan(lowerEntry.getValue().upperBound)) {
                iterator = this.rangesByLowerBound.tailMap(lowerEntry.getKey(), true).values().iterator();
            }
            else {
                iterator = this.rangesByLowerBound.tailMap(this.upperBoundWindow.lowerEndpoint(), true).values().iterator();
            }
        }
        return new TreeRangeSet$RangesByUpperBound$1(this, iterator);
    }
    
    @Override
    Iterator descendingEntryIterator() {
        Collection<Object> collection;
        if (this.upperBoundWindow.hasUpperBound()) {
            collection = this.rangesByLowerBound.headMap(this.upperBoundWindow.upperEndpoint(), false).descendingMap().values();
        }
        else {
            collection = (Collection<Object>)this.rangesByLowerBound.descendingMap().values();
        }
        final PeekingIterator peekingIterator = Iterators.peekingIterator(collection.iterator());
        if (peekingIterator.hasNext() && this.upperBoundWindow.upperBound.isLessThan(((Range)peekingIterator.peek()).upperBound)) {
            peekingIterator.next();
        }
        return new TreeRangeSet$RangesByUpperBound$2(this, peekingIterator);
    }
    
    @Override
    public int size() {
        if (this.upperBoundWindow.equals(Range.all())) {
            return this.rangesByLowerBound.size();
        }
        return Iterators.size(this.entryIterator());
    }
    
    @Override
    public boolean isEmpty() {
        return this.upperBoundWindow.equals(Range.all()) ? this.rangesByLowerBound.isEmpty() : (!this.entryIterator().hasNext());
    }
}
