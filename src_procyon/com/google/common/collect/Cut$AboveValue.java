package com.google.common.collect;

import com.google.common.base.*;

final class Cut$AboveValue extends Cut
{
    private static final long serialVersionUID = 0L;
    
    Cut$AboveValue(final Comparable comparable) {
        super((Comparable)Preconditions.checkNotNull(comparable));
    }
    
    @Override
    boolean isLessThan(final Comparable comparable) {
        return Range.compareOrThrow(this.endpoint, comparable) < 0;
    }
    
    @Override
    BoundType typeAsLowerBound() {
        return BoundType.OPEN;
    }
    
    @Override
    BoundType typeAsUpperBound() {
        return BoundType.CLOSED;
    }
    
    @Override
    Cut withLowerBoundType(final BoundType boundType, final DiscreteDomain discreteDomain) {
        switch (Cut$1.$SwitchMap$com$google$common$collect$BoundType[boundType.ordinal()]) {
            case 2: {
                return this;
            }
            case 1: {
                final Comparable next = discreteDomain.next(this.endpoint);
                return (next == null) ? Cut.belowAll() : Cut.belowValue(next);
            }
            default: {
                throw new AssertionError();
            }
        }
    }
    
    @Override
    Cut withUpperBoundType(final BoundType boundType, final DiscreteDomain discreteDomain) {
        switch (Cut$1.$SwitchMap$com$google$common$collect$BoundType[boundType.ordinal()]) {
            case 2: {
                final Comparable next = discreteDomain.next(this.endpoint);
                return (next == null) ? Cut.aboveAll() : Cut.belowValue(next);
            }
            case 1: {
                return this;
            }
            default: {
                throw new AssertionError();
            }
        }
    }
    
    @Override
    void describeAsLowerBound(final StringBuilder sb) {
        sb.append('(').append(this.endpoint);
    }
    
    @Override
    void describeAsUpperBound(final StringBuilder sb) {
        sb.append(this.endpoint).append(']');
    }
    
    @Override
    Comparable leastValueAbove(final DiscreteDomain discreteDomain) {
        return discreteDomain.next(this.endpoint);
    }
    
    @Override
    Comparable greatestValueBelow(final DiscreteDomain discreteDomain) {
        return this.endpoint;
    }
    
    @Override
    Cut canonical(final DiscreteDomain discreteDomain) {
        final Comparable leastValueAbove = this.leastValueAbove(discreteDomain);
        return (leastValueAbove != null) ? Cut.belowValue(leastValueAbove) : Cut.aboveAll();
    }
    
    @Override
    public int hashCode() {
        return ~this.endpoint.hashCode();
    }
    
    @Override
    public String toString() {
        final String value = String.valueOf(this.endpoint);
        return new StringBuilder(2 + String.valueOf(value).length()).append("/").append(value).append("\\").toString();
    }
}
