package com.google.common.cache;

import com.google.common.base.*;

public abstract class ForwardingCache$SimpleForwardingCache extends ForwardingCache
{
    private final Cache delegate;
    
    protected ForwardingCache$SimpleForwardingCache(final Cache cache) {
        this.delegate = (Cache)Preconditions.checkNotNull(cache);
    }
    
    @Override
    protected final Cache delegate() {
        return this.delegate;
    }
}
