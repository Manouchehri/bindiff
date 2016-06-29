/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.collect;

import com.google.common.collect.Range;
import com.google.common.collect.RangeSet;
import java.util.Iterator;
import java.util.Set;
import javax.annotation.Nullable;

abstract class AbstractRangeSet
implements RangeSet {
    AbstractRangeSet() {
    }

    @Override
    public boolean contains(Comparable comparable) {
        if (this.rangeContaining(comparable) == null) return false;
        return true;
    }

    @Override
    public abstract Range rangeContaining(Comparable var1);

    @Override
    public boolean isEmpty() {
        return this.asRanges().isEmpty();
    }

    @Override
    public void add(Range range) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void remove(Range range) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void clear() {
        this.remove(Range.all());
    }

    @Override
    public boolean enclosesAll(RangeSet rangeSet) {
        Range range;
        Iterator<E> iterator = rangeSet.asRanges().iterator();
        do {
            if (!iterator.hasNext()) return true;
        } while (this.encloses(range = (Range)iterator.next()));
        return false;
    }

    @Override
    public void addAll(RangeSet rangeSet) {
        Iterator<E> iterator = rangeSet.asRanges().iterator();
        while (iterator.hasNext()) {
            Range range = (Range)iterator.next();
            this.add(range);
        }
    }

    @Override
    public void removeAll(RangeSet rangeSet) {
        Iterator<E> iterator = rangeSet.asRanges().iterator();
        while (iterator.hasNext()) {
            Range range = (Range)iterator.next();
            this.remove(range);
        }
    }

    @Override
    public abstract boolean encloses(Range var1);

    @Override
    public boolean equals(@Nullable Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof RangeSet)) return false;
        RangeSet rangeSet = (RangeSet)object;
        return this.asRanges().equals(rangeSet.asRanges());
    }

    @Override
    public final int hashCode() {
        return this.asRanges().hashCode();
    }

    @Override
    public final String toString() {
        return this.asRanges().toString();
    }
}

