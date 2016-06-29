/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.collect.DiscreteDomain;
import java.io.Serializable;

final class DiscreteDomain$IntegerDomain
extends DiscreteDomain
implements Serializable {
    private static final DiscreteDomain$IntegerDomain INSTANCE = new DiscreteDomain$IntegerDomain();
    private static final long serialVersionUID = 0;

    private DiscreteDomain$IntegerDomain() {
    }

    public Integer next(Integer n2) {
        int n3 = n2;
        if (n3 == Integer.MAX_VALUE) {
            return null;
        }
        Integer n4 = n3 + 1;
        return n4;
    }

    public Integer previous(Integer n2) {
        int n3 = n2;
        if (n3 == Integer.MIN_VALUE) {
            return null;
        }
        Integer n4 = n3 - 1;
        return n4;
    }

    public long distance(Integer n2, Integer n3) {
        return (long)n3.intValue() - (long)n2.intValue();
    }

    @Override
    public Integer minValue() {
        return Integer.MIN_VALUE;
    }

    @Override
    public Integer maxValue() {
        return Integer.MAX_VALUE;
    }

    private Object readResolve() {
        return INSTANCE;
    }

    public String toString() {
        return "DiscreteDomain.integers()";
    }

    static /* synthetic */ DiscreteDomain$IntegerDomain access$000() {
        return INSTANCE;
    }
}

