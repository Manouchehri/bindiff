package com.google.common.collect;

import java.util.*;

public abstract class ImmutableCollection$Builder
{
    static final int DEFAULT_INITIAL_CAPACITY = 4;
    
    static int expandedCapacity(final int n, final int n2) {
        if (n2 < 0) {
            throw new AssertionError((Object)"cannot store more than MAX_VALUE elements");
        }
        int n3 = n + (n >> 1) + 1;
        if (n3 < n2) {
            n3 = Integer.highestOneBit(n2 - 1) << 1;
        }
        if (n3 < 0) {
            n3 = Integer.MAX_VALUE;
        }
        return n3;
    }
    
    public abstract ImmutableCollection$Builder add(final Object p0);
    
    public ImmutableCollection$Builder add(final Object... array) {
        for (int length = array.length, i = 0; i < length; ++i) {
            this.add(array[i]);
        }
        return this;
    }
    
    public ImmutableCollection$Builder addAll(final Iterable iterable) {
        final Iterator<Object> iterator = iterable.iterator();
        while (iterator.hasNext()) {
            this.add(iterator.next());
        }
        return this;
    }
    
    public ImmutableCollection$Builder addAll(final Iterator iterator) {
        while (iterator.hasNext()) {
            this.add(iterator.next());
        }
        return this;
    }
    
    public abstract ImmutableCollection build();
}
