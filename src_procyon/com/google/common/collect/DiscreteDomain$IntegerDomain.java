package com.google.common.collect;

import java.io.*;

final class DiscreteDomain$IntegerDomain extends DiscreteDomain implements Serializable
{
    private static final DiscreteDomain$IntegerDomain INSTANCE;
    private static final long serialVersionUID = 0L;
    
    public Integer next(final Integer n) {
        final int intValue = n;
        return (intValue == Integer.MAX_VALUE) ? null : (intValue + 1);
    }
    
    public Integer previous(final Integer n) {
        final int intValue = n;
        return (intValue == Integer.MIN_VALUE) ? null : (intValue - 1);
    }
    
    public long distance(final Integer n, final Integer n2) {
        return n2 - n;
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
        return DiscreteDomain$IntegerDomain.INSTANCE;
    }
    
    @Override
    public String toString() {
        return "DiscreteDomain.integers()";
    }
    
    static {
        INSTANCE = new DiscreteDomain$IntegerDomain();
    }
}
