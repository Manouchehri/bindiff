/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.BoundType;
import com.google.common.collect.Ordering;
import com.google.common.collect.Range;
import java.io.Serializable;
import java.util.Comparator;
import javax.annotation.Nullable;

@GwtCompatible(serializable=1)
final class GeneralRange
implements Serializable {
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

    static GeneralRange from(Range range) {
        Comparable comparable = range.hasLowerBound() ? range.lowerEndpoint() : null;
        BoundType boundType = range.hasLowerBound() ? range.lowerBoundType() : BoundType.OPEN;
        Comparable comparable2 = range.hasUpperBound() ? range.upperEndpoint() : null;
        BoundType boundType2 = range.hasUpperBound() ? range.upperBoundType() : BoundType.OPEN;
        return new GeneralRange(Ordering.natural(), range.hasLowerBound(), comparable, boundType, range.hasUpperBound(), comparable2, boundType2);
    }

    static GeneralRange all(Comparator comparator) {
        return new GeneralRange(comparator, false, null, BoundType.OPEN, false, null, BoundType.OPEN);
    }

    static GeneralRange downTo(Comparator comparator, @Nullable Object object, BoundType boundType) {
        return new GeneralRange(comparator, true, object, boundType, false, null, BoundType.OPEN);
    }

    static GeneralRange upTo(Comparator comparator, @Nullable Object object, BoundType boundType) {
        return new GeneralRange(comparator, false, null, BoundType.OPEN, true, object, boundType);
    }

    static GeneralRange range(Comparator comparator, @Nullable Object object, BoundType boundType, @Nullable Object object2, BoundType boundType2) {
        return new GeneralRange(comparator, true, object, boundType, true, object2, boundType2);
    }

    private GeneralRange(Comparator comparator, boolean bl2, @Nullable Object object, BoundType boundType, boolean bl3, @Nullable Object object2, BoundType boundType2) {
        this.comparator = (Comparator)Preconditions.checkNotNull(comparator);
        this.hasLowerBound = bl2;
        this.hasUpperBound = bl3;
        this.lowerEndpoint = object;
        this.lowerBoundType = (BoundType)((Object)Preconditions.checkNotNull((Object)boundType));
        this.upperEndpoint = object2;
        this.upperBoundType = (BoundType)((Object)Preconditions.checkNotNull((Object)boundType2));
        if (bl2) {
            comparator.compare(object, object);
        }
        if (bl3) {
            comparator.compare(object2, object2);
        }
        if (!bl2) return;
        if (!bl3) return;
        int n2 = comparator.compare(object, object2);
        Preconditions.checkArgument(n2 <= 0, "lowerEndpoint (%s) > upperEndpoint (%s)", object, object2);
        if (n2 != 0) return;
        Preconditions.checkArgument(boundType != BoundType.OPEN | boundType2 != BoundType.OPEN);
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
        if (this.hasUpperBound()) {
            if (this.tooLow(this.getUpperEndpoint())) return true;
        }
        if (!this.hasLowerBound()) return false;
        if (!this.tooHigh(this.getLowerEndpoint())) return false;
        return true;
    }

    boolean tooLow(@Nullable Object object) {
        boolean bl2;
        if (!this.hasLowerBound()) {
            return false;
        }
        Object object2 = this.getLowerEndpoint();
        int n2 = this.comparator.compare(object, object2);
        boolean bl3 = n2 < 0;
        boolean bl4 = n2 == 0;
        if (this.getLowerBoundType() == BoundType.OPEN) {
            bl2 = true;
            return bl3 | bl4 & bl2;
        }
        bl2 = false;
        return bl3 | bl4 & bl2;
    }

    boolean tooHigh(@Nullable Object object) {
        boolean bl2;
        if (!this.hasUpperBound()) {
            return false;
        }
        Object object2 = this.getUpperEndpoint();
        int n2 = this.comparator.compare(object, object2);
        boolean bl3 = n2 > 0;
        boolean bl4 = n2 == 0;
        if (this.getUpperBoundType() == BoundType.OPEN) {
            bl2 = true;
            return bl3 | bl4 & bl2;
        }
        bl2 = false;
        return bl3 | bl4 & bl2;
    }

    boolean contains(@Nullable Object object) {
        if (this.tooLow(object)) return false;
        if (this.tooHigh(object)) return false;
        return true;
    }

    GeneralRange intersect(GeneralRange generalRange) {
        int n2;
        boolean bl2;
        Preconditions.checkNotNull(generalRange);
        Preconditions.checkArgument(this.comparator.equals(generalRange.comparator));
        boolean bl3 = this.hasLowerBound;
        Object object = this.getLowerEndpoint();
        BoundType boundType = this.getLowerBoundType();
        if (!this.hasLowerBound()) {
            bl3 = generalRange.hasLowerBound;
            object = generalRange.getLowerEndpoint();
            boundType = generalRange.getLowerBoundType();
        } else if (generalRange.hasLowerBound() && ((bl2 = this.comparator.compare(this.getLowerEndpoint(), generalRange.getLowerEndpoint())) < false || !bl2 && generalRange.getLowerBoundType() == BoundType.OPEN)) {
            object = generalRange.getLowerEndpoint();
            boundType = generalRange.getLowerBoundType();
        }
        bl2 = this.hasUpperBound;
        Object object2 = this.getUpperEndpoint();
        BoundType boundType2 = this.getUpperBoundType();
        if (!this.hasUpperBound()) {
            bl2 = generalRange.hasUpperBound;
            object2 = generalRange.getUpperEndpoint();
            boundType2 = generalRange.getUpperBoundType();
        } else if (generalRange.hasUpperBound() && ((n2 = this.comparator.compare(this.getUpperEndpoint(), generalRange.getUpperEndpoint())) > 0 || n2 == 0 && generalRange.getUpperBoundType() == BoundType.OPEN)) {
            object2 = generalRange.getUpperEndpoint();
            boundType2 = generalRange.getUpperBoundType();
        }
        if (!bl3) return new GeneralRange(this.comparator, bl3, object, boundType, bl2, object2, boundType2);
        if (!bl2) return new GeneralRange(this.comparator, bl3, object, boundType, bl2, object2, boundType2);
        n2 = this.comparator.compare(object, object2);
        if (n2 <= 0) {
            if (n2 != 0) return new GeneralRange(this.comparator, bl3, object, boundType, bl2, object2, boundType2);
            if (boundType != BoundType.OPEN) return new GeneralRange(this.comparator, bl3, object, boundType, bl2, object2, boundType2);
            if (boundType2 != BoundType.OPEN) return new GeneralRange(this.comparator, bl3, object, boundType, bl2, object2, boundType2);
        }
        object = object2;
        boundType = BoundType.OPEN;
        boundType2 = BoundType.CLOSED;
        return new GeneralRange(this.comparator, bl3, object, boundType, bl2, object2, boundType2);
    }

    public boolean equals(@Nullable Object object) {
        if (!(object instanceof GeneralRange)) return false;
        GeneralRange generalRange = (GeneralRange)object;
        if (!this.comparator.equals(generalRange.comparator)) return false;
        if (this.hasLowerBound != generalRange.hasLowerBound) return false;
        if (this.hasUpperBound != generalRange.hasUpperBound) return false;
        if (!this.getLowerBoundType().equals((Object)generalRange.getLowerBoundType())) return false;
        if (!this.getUpperBoundType().equals((Object)generalRange.getUpperBoundType())) return false;
        if (!Objects.equal(this.getLowerEndpoint(), generalRange.getLowerEndpoint())) return false;
        if (!Objects.equal(this.getUpperEndpoint(), generalRange.getUpperEndpoint())) return false;
        return true;
    }

    public int hashCode() {
        return Objects.hashCode(new Object[]{this.comparator, this.getLowerEndpoint(), this.getLowerBoundType(), this.getUpperEndpoint(), this.getUpperBoundType()});
    }

    GeneralRange reverse() {
        GeneralRange generalRange = this.reverse;
        if (generalRange != null) return generalRange;
        generalRange = new GeneralRange(Ordering.from(this.comparator).reverse(), this.hasUpperBound, this.getUpperEndpoint(), this.getUpperBoundType(), this.hasLowerBound, this.getLowerEndpoint(), this.getLowerBoundType());
        generalRange.reverse = this;
        this.reverse = generalRange;
        return this.reverse;
    }

    public String toString() {
        char c2;
        char c3 = this.lowerBoundType == BoundType.CLOSED ? '[' : '(';
        Object object = this.hasLowerBound ? this.lowerEndpoint : "-\u221e";
        Object object2 = this.hasUpperBound ? this.upperEndpoint : "\u221e";
        if (this.upperBoundType == BoundType.CLOSED) {
            c2 = ']';
            return this.comparator + ":" + c3 + object + ',' + object2 + c2;
        }
        c2 = ')';
        return this.comparator + ":" + c3 + object + ',' + object2 + c2;
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

