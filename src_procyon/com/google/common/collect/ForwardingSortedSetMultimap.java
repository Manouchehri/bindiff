package com.google.common.collect;

import com.google.common.annotations.*;
import javax.annotation.*;
import java.util.*;

@GwtCompatible
public abstract class ForwardingSortedSetMultimap extends ForwardingSetMultimap implements SortedSetMultimap
{
    @Override
    protected abstract SortedSetMultimap delegate();
    
    @Override
    public SortedSet get(@Nullable final Object o) {
        return this.delegate().get(o);
    }
    
    @Override
    public SortedSet removeAll(@Nullable final Object o) {
        return this.delegate().removeAll(o);
    }
    
    @Override
    public SortedSet replaceValues(final Object o, final Iterable iterable) {
        return this.delegate().replaceValues(o, iterable);
    }
    
    @Override
    public Comparator valueComparator() {
        return this.delegate().valueComparator();
    }
}
