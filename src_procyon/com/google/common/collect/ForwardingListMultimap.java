package com.google.common.collect;

import com.google.common.annotations.*;
import javax.annotation.*;
import java.util.*;

@GwtCompatible
public abstract class ForwardingListMultimap extends ForwardingMultimap implements ListMultimap
{
    @Override
    protected abstract ListMultimap delegate();
    
    @Override
    public List get(@Nullable final Object o) {
        return this.delegate().get(o);
    }
    
    @Override
    public List removeAll(@Nullable final Object o) {
        return this.delegate().removeAll(o);
    }
    
    @Override
    public List replaceValues(final Object o, final Iterable iterable) {
        return this.delegate().replaceValues(o, iterable);
    }
}
