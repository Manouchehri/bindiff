/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.collect.BoundType;
import com.google.common.collect.Cut;
import com.google.common.collect.DiscreteDomain;
import java.util.NoSuchElementException;

final class Cut$BelowAll
extends Cut {
    private static final Cut$BelowAll INSTANCE = new Cut$BelowAll();
    private static final long serialVersionUID = 0;

    private Cut$BelowAll() {
        super(null);
    }

    @Override
    Comparable endpoint() {
        throw new IllegalStateException("range unbounded on this side");
    }

    @Override
    boolean isLessThan(Comparable comparable) {
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
    Cut withLowerBoundType(BoundType boundType, DiscreteDomain discreteDomain) {
        throw new IllegalStateException();
    }

    @Override
    Cut withUpperBoundType(BoundType boundType, DiscreteDomain discreteDomain) {
        throw new AssertionError((Object)"this statement should be unreachable");
    }

    @Override
    void describeAsLowerBound(StringBuilder stringBuilder) {
        stringBuilder.append("(-\u221e");
    }

    @Override
    void describeAsUpperBound(StringBuilder stringBuilder) {
        throw new AssertionError();
    }

    @Override
    Comparable leastValueAbove(DiscreteDomain discreteDomain) {
        return discreteDomain.minValue();
    }

    @Override
    Comparable greatestValueBelow(DiscreteDomain discreteDomain) {
        throw new AssertionError();
    }

    @Override
    Cut canonical(DiscreteDomain discreteDomain) {
        try {
            return Cut.belowValue(discreteDomain.minValue());
        }
        catch (NoSuchElementException var2_2) {
            return this;
        }
    }

    @Override
    public int compareTo(Cut cut) {
        if (cut != this) return -1;
        return 0;
    }

    public String toString() {
        return "-\u221e";
    }

    private Object readResolve() {
        return INSTANCE;
    }

    static /* synthetic */ Cut$BelowAll access$000() {
        return INSTANCE;
    }
}

