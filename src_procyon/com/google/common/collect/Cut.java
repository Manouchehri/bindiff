package com.google.common.collect;

import java.io.*;
import com.google.common.annotations.*;
import javax.annotation.*;
import com.google.common.primitives.*;
import java.util.*;

@GwtCompatible
abstract class Cut implements Serializable, Comparable
{
    final Comparable endpoint;
    private static final long serialVersionUID = 0L;
    
    Cut(@Nullable final Comparable endpoint) {
        this.endpoint = endpoint;
    }
    
    abstract boolean isLessThan(final Comparable p0);
    
    abstract BoundType typeAsLowerBound();
    
    abstract BoundType typeAsUpperBound();
    
    abstract Cut withLowerBoundType(final BoundType p0, final DiscreteDomain p1);
    
    abstract Cut withUpperBoundType(final BoundType p0, final DiscreteDomain p1);
    
    abstract void describeAsLowerBound(final StringBuilder p0);
    
    abstract void describeAsUpperBound(final StringBuilder p0);
    
    abstract Comparable leastValueAbove(final DiscreteDomain p0);
    
    abstract Comparable greatestValueBelow(final DiscreteDomain p0);
    
    Cut canonical(final DiscreteDomain discreteDomain) {
        return this;
    }
    
    public int compareTo(final Cut cut) {
        if (cut == belowAll()) {
            return 1;
        }
        if (cut == aboveAll()) {
            return -1;
        }
        final int compareOrThrow = Range.compareOrThrow(this.endpoint, cut.endpoint);
        if (compareOrThrow != 0) {
            return compareOrThrow;
        }
        return Booleans.compare(this instanceof Cut$AboveValue, cut instanceof Cut$AboveValue);
    }
    
    Comparable endpoint() {
        return this.endpoint;
    }
    
    @Override
    public boolean equals(final Object o) {
        if (o instanceof Cut) {
            final Cut cut = (Cut)o;
            try {
                return this.compareTo(cut) == 0;
            }
            catch (ClassCastException ex) {}
        }
        return false;
    }
    
    static Cut belowAll() {
        return Cut$BelowAll.INSTANCE;
    }
    
    static Cut aboveAll() {
        return Cut$AboveAll.INSTANCE;
    }
    
    static Cut belowValue(final Comparable comparable) {
        return new Cut$BelowValue(comparable);
    }
    
    static Cut aboveValue(final Comparable comparable) {
        return new Cut$AboveValue(comparable);
    }
}
