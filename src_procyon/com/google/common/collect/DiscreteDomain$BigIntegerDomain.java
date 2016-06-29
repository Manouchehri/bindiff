package com.google.common.collect;

import java.io.*;
import java.math.*;

final class DiscreteDomain$BigIntegerDomain extends DiscreteDomain implements Serializable
{
    private static final DiscreteDomain$BigIntegerDomain INSTANCE;
    private static final BigInteger MIN_LONG;
    private static final BigInteger MAX_LONG;
    private static final long serialVersionUID = 0L;
    
    public BigInteger next(final BigInteger bigInteger) {
        return bigInteger.add(BigInteger.ONE);
    }
    
    public BigInteger previous(final BigInteger bigInteger) {
        return bigInteger.subtract(BigInteger.ONE);
    }
    
    public long distance(final BigInteger bigInteger, final BigInteger bigInteger2) {
        return bigInteger2.subtract(bigInteger).max(DiscreteDomain$BigIntegerDomain.MIN_LONG).min(DiscreteDomain$BigIntegerDomain.MAX_LONG).longValue();
    }
    
    private Object readResolve() {
        return DiscreteDomain$BigIntegerDomain.INSTANCE;
    }
    
    @Override
    public String toString() {
        return "DiscreteDomain.bigIntegers()";
    }
    
    static {
        INSTANCE = new DiscreteDomain$BigIntegerDomain();
        MIN_LONG = BigInteger.valueOf(Long.MIN_VALUE);
        MAX_LONG = BigInteger.valueOf(Long.MAX_VALUE);
    }
}
