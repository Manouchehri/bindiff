/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.collect.BoundType;
import com.google.common.collect.Cut;
import com.google.common.collect.DiscreteDomain;

final class Cut$AboveAll
extends Cut {
    private static final Cut$AboveAll INSTANCE = new Cut$AboveAll();
    private static final long serialVersionUID = 0;

    private Cut$AboveAll() {
        super(null);
    }

    @Override
    Comparable endpoint() {
        throw new IllegalStateException("range unbounded on this side");
    }

    @Override
    boolean isLessThan(Comparable comparable) {
        return false;
    }

    @Override
    BoundType typeAsLowerBound() {
        throw new AssertionError((Object)"this statement should be unreachable");
    }

    @Override
    BoundType typeAsUpperBound() {
        throw new IllegalStateException();
    }

    @Override
    Cut withLowerBoundType(BoundType boundType, DiscreteDomain discreteDomain) {
        throw new AssertionError((Object)"this statement should be unreachable");
    }

    @Override
    Cut withUpperBoundType(BoundType boundType, DiscreteDomain discreteDomain) {
        throw new IllegalStateException();
    }

    @Override
    void describeAsLowerBound(StringBuilder stringBuilder) {
        throw new AssertionError();
    }

    @Override
    void describeAsUpperBound(StringBuilder stringBuilder) {
        stringBuilder.append("+\u221e)");
    }

    @Override
    Comparable leastValueAbove(DiscreteDomain discreteDomain) {
        throw new AssertionError();
    }

    @Override
    Comparable greatestValueBelow(DiscreteDomain discreteDomain) {
        return discreteDomain.maxValue();
    }

    @Override
    public int compareTo(Cut cut) {
        if (cut != this) return 1;
        return 0;
    }

    public String toString() {
        return "+\u221e";
    }

    private Object readResolve() {
        return INSTANCE;
    }

    static /* synthetic */ Cut$AboveAll access$100() {
        return INSTANCE;
    }
}

