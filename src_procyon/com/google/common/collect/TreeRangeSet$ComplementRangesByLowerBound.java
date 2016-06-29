package com.google.common.collect;

import com.google.common.base.*;
import java.util.*;
import javax.annotation.*;

final class TreeRangeSet$ComplementRangesByLowerBound extends AbstractNavigableMap
{
    private final NavigableMap positiveRangesByLowerBound;
    private final NavigableMap positiveRangesByUpperBound;
    private final Range complementLowerBoundWindow;
    
    TreeRangeSet$ComplementRangesByLowerBound(final NavigableMap navigableMap) {
        this(navigableMap, Range.all());
    }
    
    private TreeRangeSet$ComplementRangesByLowerBound(final NavigableMap positiveRangesByLowerBound, final Range complementLowerBoundWindow) {
        this.positiveRangesByLowerBound = positiveRangesByLowerBound;
        this.positiveRangesByUpperBound = new TreeRangeSet$RangesByUpperBound(positiveRangesByLowerBound);
        this.complementLowerBoundWindow = complementLowerBoundWindow;
    }
    
    private NavigableMap subMap(Range intersection) {
        if (!this.complementLowerBoundWindow.isConnected(intersection)) {
            return ImmutableSortedMap.of();
        }
        intersection = intersection.intersection(this.complementLowerBoundWindow);
        return new TreeRangeSet$ComplementRangesByLowerBound(this.positiveRangesByLowerBound, intersection);
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
    Iterator entryIterator() {
        Collection<Object> collection;
        if (this.complementLowerBoundWindow.hasLowerBound()) {
            collection = this.positiveRangesByUpperBound.tailMap(this.complementLowerBoundWindow.lowerEndpoint(), this.complementLowerBoundWindow.lowerBoundType() == BoundType.CLOSED).values();
        }
        else {
            collection = (Collection<Object>)this.positiveRangesByUpperBound.values();
        }
        final PeekingIterator peekingIterator = Iterators.peekingIterator(collection.iterator());
        Cut cut;
        if (this.complementLowerBoundWindow.contains(Cut.belowAll()) && (!peekingIterator.hasNext() || ((Range)peekingIterator.peek()).lowerBound != Cut.belowAll())) {
            cut = Cut.belowAll();
        }
        else {
            if (!peekingIterator.hasNext()) {
                return Iterators.emptyIterator();
            }
            cut = ((Range)peekingIterator.next()).upperBound;
        }
        return new TreeRangeSet$ComplementRangesByLowerBound$1(this, cut, peekingIterator);
    }
    
    @Override
    Iterator descendingEntryIterator() {
        final PeekingIterator peekingIterator = Iterators.peekingIterator(this.positiveRangesByUpperBound.headMap(this.complementLowerBoundWindow.hasUpperBound() ? ((Cut)this.complementLowerBoundWindow.upperEndpoint()) : Cut.aboveAll(), this.complementLowerBoundWindow.hasUpperBound() && this.complementLowerBoundWindow.upperBoundType() == BoundType.CLOSED).descendingMap().values().iterator());
        Cut cut;
        if (peekingIterator.hasNext()) {
            cut = ((((Range)peekingIterator.peek()).upperBound == Cut.aboveAll()) ? ((Range)peekingIterator.next()).lowerBound : this.positiveRangesByLowerBound.higherKey(((Range)peekingIterator.peek()).upperBound));
        }
        else {
            if (!this.complementLowerBoundWindow.contains(Cut.belowAll()) || this.positiveRangesByLowerBound.containsKey(Cut.belowAll())) {
                return Iterators.emptyIterator();
            }
            cut = this.positiveRangesByLowerBound.higherKey(Cut.belowAll());
        }
        return new TreeRangeSet$ComplementRangesByLowerBound$2(this, (Cut)MoreObjects.firstNonNull(cut, Cut.aboveAll()), peekingIterator);
    }
    
    @Override
    public int size() {
        return Iterators.size(this.entryIterator());
    }
    
    @Nullable
    @Override
    public Range get(final Object o) {
        if (o instanceof Cut) {
            try {
                final Cut cut = (Cut)o;
                final Map.Entry firstEntry = this.tailMap(cut, true).firstEntry();
                if (firstEntry != null && firstEntry.getKey().equals(cut)) {
                    return firstEntry.getValue();
                }
            }
            catch (ClassCastException ex) {
                return null;
            }
        }
        return null;
    }
    
    @Override
    public boolean containsKey(final Object o) {
        return this.get(o) != null;
    }
}
