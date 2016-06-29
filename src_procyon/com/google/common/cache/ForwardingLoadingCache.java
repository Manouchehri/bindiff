package com.google.common.cache;

import com.google.common.collect.*;

public abstract class ForwardingLoadingCache extends ForwardingCache implements LoadingCache
{
    @Override
    protected abstract LoadingCache delegate();
    
    @Override
    public Object get(final Object o) {
        return this.delegate().get(o);
    }
    
    @Override
    public Object getUnchecked(final Object o) {
        return this.delegate().getUnchecked(o);
    }
    
    @Override
    public ImmutableMap getAll(final Iterable iterable) {
        return this.delegate().getAll(iterable);
    }
    
    @Override
    public Object apply(final Object o) {
        return this.delegate().apply(o);
    }
    
    @Override
    public void refresh(final Object o) {
        this.delegate().refresh(o);
    }
}
