/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.collect.BoundType;
import com.google.common.collect.Cut;
import com.google.common.collect.Cut$1;
import com.google.common.collect.DiscreteDomain;
import com.google.common.collect.Range;

final class Cut$AboveValue
extends Cut {
    private static final long serialVersionUID = 0;

    Cut$AboveValue(Comparable comparable) {
        super((Comparable)Preconditions.checkNotNull(comparable));
    }

    @Override
    boolean isLessThan(Comparable comparable) {
        if (Range.compareOrThrow(this.endpoint, comparable) >= 0) return false;
        return true;
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
    Cut withLowerBoundType(BoundType boundType, DiscreteDomain discreteDomain) {
        switch (Cut$1.$SwitchMap$com$google$common$collect$BoundType[boundType.ordinal()]) {
            case 2: {
                return this;
            }
            case 1: {
                Cut cut;
                Comparable comparable = discreteDomain.next(this.endpoint);
                if (comparable == null) {
                    cut = Cut.belowAll();
                    return cut;
                }
                cut = Cut$AboveValue.belowValue(comparable);
                return cut;
            }
        }
        throw new AssertionError();
    }

    @Override
    Cut withUpperBoundType(BoundType boundType, DiscreteDomain discreteDomain) {
        switch (Cut$1.$SwitchMap$com$google$common$collect$BoundType[boundType.ordinal()]) {
            case 2: {
                Cut cut;
                Comparable comparable = discreteDomain.next(this.endpoint);
                if (comparable == null) {
                    cut = Cut.aboveAll();
                    return cut;
                }
                cut = Cut$AboveValue.belowValue(comparable);
                return cut;
            }
            case 1: {
                return this;
            }
        }
        throw new AssertionError();
    }

    @Override
    void describeAsLowerBound(StringBuilder stringBuilder) {
        stringBuilder.append('(').append(this.endpoint);
    }

    @Override
    void describeAsUpperBound(StringBuilder stringBuilder) {
        stringBuilder.append(this.endpoint).append(']');
    }

    @Override
    Comparable leastValueAbove(DiscreteDomain discreteDomain) {
        return discreteDomain.next(this.endpoint);
    }

    @Override
    Comparable greatestValueBelow(DiscreteDomain discreteDomain) {
        return this.endpoint;
    }

    @Override
    Cut canonical(DiscreteDomain discreteDomain) {
        Cut cut;
        Comparable comparable = this.leastValueAbove(discreteDomain);
        if (comparable != null) {
            cut = Cut$AboveValue.belowValue(comparable);
            return cut;
        }
        cut = Cut.aboveAll();
        return cut;
    }

    public int hashCode() {
        return ~ this.endpoint.hashCode();
    }

    public String toString() {
        String string = String.valueOf(this.endpoint);
        return new StringBuilder(2 + String.valueOf(string).length()).append("/").append(string).append("\\").toString();
    }
}

