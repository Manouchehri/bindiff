package com.google.common.collect;

import java.io.*;
import com.google.common.annotations.*;
import java.util.*;
import javax.annotation.*;
import com.google.common.base.*;

@GwtCompatible(serializable = true)
final class GeneralRange implements Serializable
{
    private final Comparator comparator;
    private final boolean hasLowerBound;
    @Nullable
    private final Object lowerEndpoint;
    private final BoundType lowerBoundType;
    private final boolean hasUpperBound;
    @Nullable
    private final Object upperEndpoint;
    private final BoundType upperBoundType;
    private transient GeneralRange reverse;
    
    static GeneralRange from(final Range range) {
        return new GeneralRange(Ordering.natural(), range.hasLowerBound(), range.hasLowerBound() ? range.lowerEndpoint() : null, range.hasLowerBound() ? range.lowerBoundType() : BoundType.OPEN, range.hasUpperBound(), range.hasUpperBound() ? range.upperEndpoint() : null, range.hasUpperBound() ? range.upperBoundType() : BoundType.OPEN);
    }
    
    static GeneralRange all(final Comparator comparator) {
        return new GeneralRange(comparator, false, null, BoundType.OPEN, false, null, BoundType.OPEN);
    }
    
    static GeneralRange downTo(final Comparator comparator, @Nullable final Object o, final BoundType boundType) {
        return new GeneralRange(comparator, true, o, boundType, false, null, BoundType.OPEN);
    }
    
    static GeneralRange upTo(final Comparator comparator, @Nullable final Object o, final BoundType boundType) {
        return new GeneralRange(comparator, false, null, BoundType.OPEN, true, o, boundType);
    }
    
    static GeneralRange range(final Comparator comparator, @Nullable final Object o, final BoundType boundType, @Nullable final Object o2, final BoundType boundType2) {
        return new GeneralRange(comparator, true, o, boundType, true, o2, boundType2);
    }
    
    private GeneralRange(final Comparator comparator, final boolean hasLowerBound, @Nullable final Object lowerEndpoint, final BoundType boundType, final boolean hasUpperBound, @Nullable final Object upperEndpoint, final BoundType boundType2) {
        this.comparator = (Comparator)Preconditions.checkNotNull(comparator);
        this.hasLowerBound = hasLowerBound;
        this.hasUpperBound = hasUpperBound;
        this.lowerEndpoint = lowerEndpoint;
        this.lowerBoundType = (BoundType)Preconditions.checkNotNull(boundType);
        this.upperEndpoint = upperEndpoint;
        this.upperBoundType = (BoundType)Preconditions.checkNotNull(boundType2);
        if (hasLowerBound) {
            comparator.compare(lowerEndpoint, lowerEndpoint);
        }
        if (hasUpperBound) {
            comparator.compare(upperEndpoint, upperEndpoint);
        }
        if (hasLowerBound && hasUpperBound) {
            final int compare = comparator.compare(lowerEndpoint, upperEndpoint);
            Preconditions.checkArgument(compare <= 0, "lowerEndpoint (%s) > upperEndpoint (%s)", lowerEndpoint, upperEndpoint);
            if (compare == 0) {
                Preconditions.checkArgument(boundType != BoundType.OPEN | boundType2 != BoundType.OPEN);
            }
        }
    }
    
    Comparator comparator() {
        return this.comparator;
    }
    
    boolean hasLowerBound() {
        return this.hasLowerBound;
    }
    
    boolean hasUpperBound() {
        return this.hasUpperBound;
    }
    
    boolean isEmpty() {
        return (this.hasUpperBound() && this.tooLow(this.getUpperEndpoint())) || (this.hasLowerBound() && this.tooHigh(this.getLowerEndpoint()));
    }
    
    boolean tooLow(@Nullable final Object o) {
        if (!this.hasLowerBound()) {
            return false;
        }
        final int compare = this.comparator.compare(o, this.getLowerEndpoint());
        return compare < 0 | (compare == 0 & this.getLowerBoundType() == BoundType.OPEN);
    }
    
    boolean tooHigh(@Nullable final Object o) {
        if (!this.hasUpperBound()) {
            return false;
        }
        final int compare = this.comparator.compare(o, this.getUpperEndpoint());
        return compare > 0 | (compare == 0 & this.getUpperBoundType() == BoundType.OPEN);
    }
    
    boolean contains(@Nullable final Object o) {
        return !this.tooLow(o) && !this.tooHigh(o);
    }
    
    GeneralRange intersect(final GeneralRange generalRange) {
        Preconditions.checkNotNull(generalRange);
        Preconditions.checkArgument(this.comparator.equals(generalRange.comparator));
        boolean b = this.hasLowerBound;
        Object o = this.getLowerEndpoint();
        BoundType boundType = this.getLowerBoundType();
        if (!this.hasLowerBound()) {
            b = generalRange.hasLowerBound;
            o = generalRange.getLowerEndpoint();
            boundType = generalRange.getLowerBoundType();
        }
        else if (generalRange.hasLowerBound()) {
            final int compare = this.comparator.compare(this.getLowerEndpoint(), generalRange.getLowerEndpoint());
            if (compare < 0 || (compare == 0 && generalRange.getLowerBoundType() == BoundType.OPEN)) {
                o = generalRange.getLowerEndpoint();
                boundType = generalRange.getLowerBoundType();
            }
        }
        boolean b2 = this.hasUpperBound;
        Object o2 = this.getUpperEndpoint();
        BoundType boundType2 = this.getUpperBoundType();
        if (!this.hasUpperBound()) {
            b2 = generalRange.hasUpperBound;
            o2 = generalRange.getUpperEndpoint();
            boundType2 = generalRange.getUpperBoundType();
        }
        else if (generalRange.hasUpperBound()) {
            final int compare2 = this.comparator.compare(this.getUpperEndpoint(), generalRange.getUpperEndpoint());
            if (compare2 > 0 || (compare2 == 0 && generalRange.getUpperBoundType() == BoundType.OPEN)) {
                o2 = generalRange.getUpperEndpoint();
                boundType2 = generalRange.getUpperBoundType();
            }
        }
        if (b && b2) {
            final int compare3 = this.comparator.compare(o, o2);
            if (compare3 > 0 || (compare3 == 0 && boundType == BoundType.OPEN && boundType2 == BoundType.OPEN)) {
                o = o2;
                boundType = BoundType.OPEN;
                boundType2 = BoundType.CLOSED;
            }
        }
        return new GeneralRange(this.comparator, b, o, boundType, b2, o2, boundType2);
    }
    
    @Override
    public boolean equals(@Nullable final Object o) {
        if (o instanceof GeneralRange) {
            final GeneralRange generalRange = (GeneralRange)o;
            return this.comparator.equals(generalRange.comparator) && this.hasLowerBound == generalRange.hasLowerBound && this.hasUpperBound == generalRange.hasUpperBound && this.getLowerBoundType().equals(generalRange.getLowerBoundType()) && this.getUpperBoundType().equals(generalRange.getUpperBoundType()) && Objects.equal(this.getLowerEndpoint(), generalRange.getLowerEndpoint()) && Objects.equal(this.getUpperEndpoint(), generalRange.getUpperEndpoint());
        }
        return false;
    }
    
    @Override
    public int hashCode() {
        return Objects.hashCode(this.comparator, this.getLowerEndpoint(), this.getLowerBoundType(), this.getUpperEndpoint(), this.getUpperBoundType());
    }
    
    GeneralRange reverse() {
        final GeneralRange reverse = this.reverse;
        if (reverse == null) {
            final GeneralRange reverse2 = new GeneralRange(Ordering.from(this.comparator).reverse(), this.hasUpperBound, this.getUpperEndpoint(), this.getUpperBoundType(), this.hasLowerBound, this.getLowerEndpoint(), this.getLowerBoundType());
            reverse2.reverse = this;
            return this.reverse = reverse2;
        }
        return reverse;
    }
    
    @Override
    public String toString() {
        return this.comparator + ":" + ((this.lowerBoundType == BoundType.CLOSED) ? '[' : '(') + (this.hasLowerBound ? this.lowerEndpoint : "-\u221e") + ',' + (this.hasUpperBound ? this.upperEndpoint : "\u221e") + ((this.upperBoundType == BoundType.CLOSED) ? ']' : ')');
    }
    
    Object getLowerEndpoint() {
        return this.lowerEndpoint;
    }
    
    BoundType getLowerBoundType() {
        return this.lowerBoundType;
    }
    
    Object getUpperEndpoint() {
        return this.upperEndpoint;
    }
    
    BoundType getUpperBoundType() {
        return this.upperBoundType;
    }
}
