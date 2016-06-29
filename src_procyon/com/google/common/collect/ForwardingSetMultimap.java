package com.google.common.collect;

import com.google.common.annotations.*;
import javax.annotation.*;
import java.util.*;

@GwtCompatible
public abstract class ForwardingSetMultimap extends ForwardingMultimap implements SetMultimap
{
    @Override
    protected abstract SetMultimap delegate();
    
    @Override
    public Set entries() {
        return this.delegate().entries();
    }
    
    @Override
    public Set get(@Nullable final Object o) {
        return this.delegate().get(o);
    }
    
    @Override
    public Set removeAll(@Nullable final Object o) {
        return this.delegate().removeAll(o);
    }
    
    @Override
    public Set replaceValues(final Object o, final Iterable iterable) {
        return this.delegate().replaceValues(o, iterable);
    }
}
