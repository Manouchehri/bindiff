package com.google.common.collect;

import java.io.*;

final class DiscreteDomain$LongDomain extends DiscreteDomain implements Serializable
{
    private static final DiscreteDomain$LongDomain INSTANCE;
    private static final long serialVersionUID = 0L;
    
    public Long next(final Long n) {
        final long longValue = n;
        return (longValue == Long.MAX_VALUE) ? null : (longValue + 1L);
    }
    
    public Long previous(final Long n) {
        final long longValue = n;
        return (longValue == Long.MIN_VALUE) ? null : (longValue - 1L);
    }
    
    public long distance(final Long n, final Long n2) {
        final long n3 = n2 - n;
        if (n2 > n && n3 < 0L) {
            return Long.MAX_VALUE;
        }
        if (n2 < n && n3 > 0L) {
            return Long.MIN_VALUE;
        }
        return n3;
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
        return DiscreteDomain$LongDomain.INSTANCE;
    }
    
    @Override
    public String toString() {
        return "DiscreteDomain.longs()";
    }
    
    static {
        INSTANCE = new DiscreteDomain$LongDomain();
    }
}
