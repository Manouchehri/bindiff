package com.google.common.collect;

import com.google.common.base.*;

final class Cut$BelowValue extends Cut
{
    private static final long serialVersionUID = 0L;
    
    Cut$BelowValue(final Comparable comparable) {
        super((Comparable)Preconditions.checkNotNull(comparable));
    }
    
    @Override
    boolean isLessThan(final Comparable comparable) {
        return Range.compareOrThrow(this.endpoint, comparable) <= 0;
    }
    
    @Override
    BoundType typeAsLowerBound() {
        return BoundType.CLOSED;
    }
    
    @Override
    BoundType typeAsUpperBound() {
        return BoundType.OPEN;
    }
    
    @Override
    Cut withLowerBoundType(final BoundType boundType, final DiscreteDomain discreteDomain) {
        switch (Cut$1.$SwitchMap$com$google$common$collect$BoundType[boundType.ordinal()]) {
            case 1: {
                return this;
            }
            case 2: {
                final Comparable previous = discreteDomain.previous(this.endpoint);
                return (previous == null) ? Cut.belowAll() : new Cut$AboveValue(previous);
            }
            default: {
                throw new AssertionError();
            }
        }
    }
    
    @Override
    Cut withUpperBoundType(final BoundType boundType, final DiscreteDomain discreteDomain) {
        switch (Cut$1.$SwitchMap$com$google$common$collect$BoundType[boundType.ordinal()]) {
            case 1: {
                final Comparable previous = discreteDomain.previous(this.endpoint);
                return (previous == null) ? Cut.aboveAll() : new Cut$AboveValue(previous);
            }
            case 2: {
                return this;
            }
            default: {
                throw new AssertionError();
            }
        }
    }
    
    @Override
    void describeAsLowerBound(final StringBuilder sb) {
        sb.append('[').append(this.endpoint);
    }
    
    @Override
    void describeAsUpperBound(final StringBuilder sb) {
        sb.append(this.endpoint).append(')');
    }
    
    @Override
    Comparable leastValueAbove(final DiscreteDomain discreteDomain) {
        return this.endpoint;
    }
    
    @Override
    Comparable greatestValueBelow(final DiscreteDomain discreteDomain) {
        return discreteDomain.previous(this.endpoint);
    }
    
    @Override
    public int hashCode() {
        return this.endpoint.hashCode();
    }
    
    @Override
    public String toString() {
        final String value = String.valueOf(this.endpoint);
        return new StringBuilder(2 + String.valueOf(value).length()).append("\\").append(value).append("/").toString();
    }
}
