/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.collect.DiscreteDomain;
import java.io.Serializable;
import java.math.BigInteger;

final class DiscreteDomain$BigIntegerDomain
extends DiscreteDomain
implements Serializable {
    private static final DiscreteDomain$BigIntegerDomain INSTANCE = new DiscreteDomain$BigIntegerDomain();
    private static final BigInteger MIN_LONG = BigInteger.valueOf(Long.MIN_VALUE);
    private static final BigInteger MAX_LONG = BigInteger.valueOf(Long.MAX_VALUE);
    private static final long serialVersionUID = 0;

    private DiscreteDomain$BigIntegerDomain() {
    }

    public BigInteger next(BigInteger bigInteger) {
        return bigInteger.add(BigInteger.ONE);
    }

    public BigInteger previous(BigInteger bigInteger) {
        return bigInteger.subtract(BigInteger.ONE);
    }

    public long distance(BigInteger bigInteger, BigInteger bigInteger2) {
        return bigInteger2.subtract(bigInteger).max(MIN_LONG).min(MAX_LONG).longValue();
    }

    private Object readResolve() {
        return INSTANCE;
    }

    public String toString() {
        return "DiscreteDomain.bigIntegers()";
    }

    static /* synthetic */ DiscreteDomain$BigIntegerDomain access$200() {
        return INSTANCE;
    }
}

