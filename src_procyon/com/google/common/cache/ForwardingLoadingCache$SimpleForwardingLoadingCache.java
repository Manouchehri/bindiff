package com.google.common.cache;

import com.google.common.base.*;

public abstract class ForwardingLoadingCache$SimpleForwardingLoadingCache extends ForwardingLoadingCache
{
    private final LoadingCache delegate;
    
    protected ForwardingLoadingCache$SimpleForwardingLoadingCache(final LoadingCache loadingCache) {
        this.delegate = (LoadingCache)Preconditions.checkNotNull(loadingCache);
    }
    
    @Override
    protected final LoadingCache delegate() {
        return this.delegate;
    }
}
