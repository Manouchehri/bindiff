/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.collect.DiscreteDomain;
import java.io.Serializable;

final class DiscreteDomain$LongDomain
extends DiscreteDomain
implements Serializable {
    private static final DiscreteDomain$LongDomain INSTANCE = new DiscreteDomain$LongDomain();
    private static final long serialVersionUID = 0;

    private DiscreteDomain$LongDomain() {
    }

    public Long next(Long l2) {
        long l3 = l2;
        if (l3 == Long.MAX_VALUE) {
            return null;
        }
        Long l4 = l3 + 1;
        return l4;
    }

    public Long previous(Long l2) {
        long l3 = l2;
        if (l3 == Long.MIN_VALUE) {
            return null;
        }
        Long l4 = l3 - 1;
        return l4;
    }

    public long distance(Long l2, Long l3) {
        long l4 = l3 - l2;
        if (l3 > l2 && l4 < 0) {
            return Long.MAX_VALUE;
        }
        if (l3 >= l2) return l4;
        if (l4 <= 0) return l4;
        return Long.MIN_VALUE;
    }

    @Override
    public Long minValue() {
        return Long.MIN_VALUE;
    }

    @Override
    public Long maxValue() {
        return Long.MAX_VALUE;
    }

    private Object readResolve() {
        return INSTANCE;
    }

    public String toString() {
        return "DiscreteDomain.longs()";
    }

    static /* synthetic */ DiscreteDomain$LongDomain access$100() {
        return INSTANCE;
    }
}

