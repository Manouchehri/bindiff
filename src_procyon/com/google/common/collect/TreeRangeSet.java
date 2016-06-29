package com.google.common.collect;

import com.google.common.annotations.*;
import com.google.common.base.*;
import javax.annotation.*;
import java.util.*;

@Beta
@GwtIncompatible("uses NavigableMap")
public class TreeRangeSet extends AbstractRangeSet
{
    @VisibleForTesting
    final NavigableMap rangesByLowerBound;
    private transient Set asRanges;
    private transient Set asDescendingSetOfRanges;
    private transient RangeSet complement;
    
    public static TreeRangeSet create() {
        return new TreeRangeSet(new TreeMap());
    }
    
    public static TreeRangeSet create(final RangeSet set) {
        final TreeRangeSet create = create();
        create.addAll(set);
        return create;
    }
    
    private TreeRangeSet(final NavigableMap rangesByLowerBound) {
        this.rangesByLowerBound = rangesByLowerBound;
    }
    
    @Override
    public Set asRanges() {
        final Set asRanges = this.asRanges;
        return (asRanges == null) ? (this.asRanges = new TreeRangeSet$AsRanges(this, this.rangesByLowerBound.values())) : asRanges;
    }
    
    @Override
    public Set asDescendingSetOfRanges() {
        final Set asDescendingSetOfRanges = this.asDescendingSetOfRanges;
        return (asDescendingSetOfRanges == null) ? (this.asDescendingSetOfRanges = new TreeRangeSet$AsRanges(this, this.rangesByLowerBound.descendingMap().values())) : asDescendingSetOfRanges;
    }
    
    @Nullable
    @Override
    public Range rangeContaining(final Comparable comparable) {
        Preconditions.checkNotNull(comparable);
        final Map.Entry<Cut, Range> floorEntry = this.rangesByLowerBound.floorEntry(Cut.belowValue(comparable));
        if (floorEntry != null && floorEntry.getValue().contains(comparable)) {
            return floorEntry.getValue();
        }
        return null;
    }
    
    @Override
    public boolean encloses(final Range range) {
        Preconditions.checkNotNull(range);
        final Map.Entry<Cut, Range> floorEntry = this.rangesByLowerBound.floorEntry(range.lowerBound);
        return floorEntry != null && floorEntry.getValue().encloses(range);
    }
    
    @Nullable
    private Range rangeEnclosing(final Range range) {
        Preconditions.checkNotNull(range);
        final Map.Entry<Cut, Range> floorEntry = this.rangesByLowerBound.floorEntry(range.lowerBound);
        return (floorEntry != null && floorEntry.getValue().encloses(range)) ? floorEntry.getValue() : null;
    }
    
    @Override
    public Range span() {
        final Map.Entry<K, Range> firstEntry = this.rangesByLowerBound.firstEntry();
        final Map.Entry<K, Range> lastEntry = this.rangesByLowerBound.lastEntry();
        if (firstEntry == null) {
            throw new NoSuchElementException();
        }
        return Range.create(firstEntry.getValue().lowerBound, lastEntry.getValue().upperBound);
    }
    
    @Override
    public void add(final Range range) {
        Preconditions.checkNotNull(range);
        if (range.isEmpty()) {
            return;
        }
        Cut cut = range.lowerBound;
        Cut cut2 = range.upperBound;
        final Map.Entry<Cut, Object> lowerEntry = this.rangesByLowerBound.lowerEntry(cut);
        if (lowerEntry != null) {
            final Range range2 = lowerEntry.getValue();
            if (range2.upperBound.compareTo(cut) >= 0) {
                if (range2.upperBound.compareTo(cut2) >= 0) {
                    cut2 = range2.upperBound;
                }
                cut = range2.lowerBound;
            }
        }
        final Map.Entry<Cut, Object> floorEntry = this.rangesByLowerBound.floorEntry(cut2);
        if (floorEntry != null) {
            final Range range3 = floorEntry.getValue();
            if (range3.upperBound.compareTo(cut2) >= 0) {
                cut2 = range3.upperBound;
            }
        }
        this.rangesByLowerBound.subMap(cut, cut2).clear();
        this.replaceRangeWithSameLowerBound(Range.create(cut, cut2));
    }
    
    @Override
    public void remove(final Range range) {
        Preconditions.checkNotNull(range);
        if (range.isEmpty()) {
            return;
        }
        final Map.Entry<Cut, Range> lowerEntry = this.rangesByLowerBound.lowerEntry(range.lowerBound);
        if (lowerEntry != null) {
            final Range range2 = lowerEntry.getValue();
            if (range2.upperBound.compareTo(range.lowerBound) >= 0) {
                if (range.hasUpperBound() && range2.upperBound.compareTo(range.upperBound) >= 0) {
                    this.replaceRangeWithSameLowerBound(Range.create(range.upperBound, range2.upperBound));
                }
                this.replaceRangeWithSameLowerBound(Range.create(range2.lowerBound, range.lowerBound));
            }
        }
        final Map.Entry<Cut, Range> floorEntry = this.rangesByLowerBound.floorEntry(range.upperBound);
        if (floorEntry != null) {
            final Range range3 = floorEntry.getValue();
            if (range.hasUpperBound() && range3.upperBound.compareTo(range.upperBound) >= 0) {
                this.replaceRangeWithSameLowerBound(Range.create(range.upperBound, range3.upperBound));
            }
        }
        this.rangesByLowerBound.subMap(range.lowerBound, range.upperBound).clear();
    }
    
    private void replaceRangeWithSameLowerBound(final Range range) {
        if (range.isEmpty()) {
            this.rangesByLowerBound.remove(range.lowerBound);
        }
        else {
            this.rangesByLowerBound.put(range.lowerBound, range);
        }
    }
    
    @Override
    public RangeSet complement() {
        final RangeSet complement = this.complement;
        return (complement == null) ? (this.complement = new TreeRangeSet$Complement(this)) : complement;
    }
    
    @Override
    public RangeSet subRangeSet(final Range range) {
        return range.equals(Range.all()) ? this : new TreeRangeSet$SubRangeSet(this, range);
    }
}
