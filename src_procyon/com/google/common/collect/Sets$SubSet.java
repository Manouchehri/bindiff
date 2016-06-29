package com.google.common.collect;

import java.util.*;
import javax.annotation.*;

final class Sets$SubSet extends AbstractSet
{
    private final ImmutableMap inputSet;
    private final int mask;
    
    Sets$SubSet(final ImmutableMap inputSet, final int mask) {
        this.inputSet = inputSet;
        this.mask = mask;
    }
    
    @Override
    public Iterator iterator() {
        return new Sets$SubSet$1(this);
    }
    
    @Override
    public int size() {
        return Integer.bitCount(this.mask);
    }
    
    @Override
    public boolean contains(@Nullable final Object o) {
        final Integer n = (Integer)this.inputSet.get(o);
        return n != null && (this.mask & 1 << n) != 0x0;
    }
}
