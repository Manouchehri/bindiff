package com.google.common.collect;

import java.util.*;

final class Cut$BelowAll extends Cut
{
    private static final Cut$BelowAll INSTANCE;
    private static final long serialVersionUID = 0L;
    
    private Cut$BelowAll() {
        super(null);
    }
    
    @Override
    Comparable endpoint() {
        throw new IllegalStateException("range unbounded on this side");
    }
    
    @Override
    boolean isLessThan(final Comparable comparable) {
        return true;
    }
    
    @Override
    BoundType typeAsLowerBound() {
        throw new IllegalStateException();
    }
    
    @Override
    BoundType typeAsUpperBound() {
        throw new AssertionError((Object)"this statement should be unreachable");
    }
    
    @Override
    Cut withLowerBoundType(final BoundType boundType, final DiscreteDomain discreteDomain) {
        throw new IllegalStateException();
    }
    
    @Override
    Cut withUpperBoundType(final BoundType boundType, final DiscreteDomain discreteDomain) {
        throw new AssertionError((Object)"this statement should be unreachable");
    }
    
    @Override
    void describeAsLowerBound(final StringBuilder sb) {
        sb.append("(-\u221e");
    }
    
    @Override
    void describeAsUpperBound(final StringBuilder sb) {
        throw new AssertionError();
    }
    
    @Override
    Comparable leastValueAbove(final DiscreteDomain discreteDomain) {
        return discreteDomain.minValue();
    }
    
    @Override
    Comparable greatestValueBelow(final DiscreteDomain discreteDomain) {
        throw new AssertionError();
    }
    
    @Override
    Cut canonical(final DiscreteDomain discreteDomain) {
        try {
            return Cut.belowValue(discreteDomain.minValue());
        }
        catch (NoSuchElementException ex) {
            return this;
        }
    }
    
    @Override
    public int compareTo(final Cut cut) {
        return (cut == this) ? 0 : -1;
    }
    
    @Override
    public String toString() {
        return "-\u221e";
    }
    
    private Object readResolve() {
        return Cut$BelowAll.INSTANCE;
    }
    
    static {
        INSTANCE = new Cut$BelowAll();
    }
}
