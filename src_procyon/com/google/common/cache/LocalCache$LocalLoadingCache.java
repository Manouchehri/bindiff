package com.google.common.cache;

import com.google.common.base.*;
import com.google.common.util.concurrent.*;
import java.util.concurrent.*;
import com.google.common.collect.*;

class LocalCache$LocalLoadingCache extends LocalCache$LocalManualCache implements LoadingCache
{
    private static final long serialVersionUID = 1L;
    
    LocalCache$LocalLoadingCache(final CacheBuilder cacheBuilder, final CacheLoader cacheLoader) {
        super(new LocalCache(cacheBuilder, (CacheLoader)Preconditions.checkNotNull(cacheLoader)), null);
    }
    
    @Override
    public Object get(final Object o) {
        return this.localCache.getOrLoad(o);
    }
    
    @Override
    public Object getUnchecked(final Object o) {
        try {
            return this.get(o);
        }
        catch (ExecutionException ex) {
            throw new UncheckedExecutionException(ex.getCause());
        }
    }
    
    @Override
    public ImmutableMap getAll(final Iterable iterable) {
        return this.localCache.getAll(iterable);
    }
    
    @Override
    public void refresh(final Object o) {
        this.localCache.refresh(o);
    }
    
    @Override
    public final Object apply(final Object o) {
        return this.getUnchecked(o);
    }
    
    @Override
    Object writeReplace() {
        return new LocalCache$LoadingSerializationProxy(this.localCache);
    }
}
