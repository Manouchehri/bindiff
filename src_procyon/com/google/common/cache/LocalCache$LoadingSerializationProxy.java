package com.google.common.cache;

import java.io.*;
import com.google.common.collect.*;

final class LocalCache$LoadingSerializationProxy extends LocalCache$ManualSerializationProxy implements LoadingCache, Serializable
{
    private static final long serialVersionUID = 1L;
    transient LoadingCache autoDelegate;
    
    LocalCache$LoadingSerializationProxy(final LocalCache localCache) {
        super(localCache);
    }
    
    private void readObject(final ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        this.autoDelegate = this.recreateCacheBuilder().build(this.loader);
    }
    
    @Override
    public Object get(final Object o) {
        return this.autoDelegate.get(o);
    }
    
    @Override
    public Object getUnchecked(final Object o) {
        return this.autoDelegate.getUnchecked(o);
    }
    
    @Override
    public ImmutableMap getAll(final Iterable iterable) {
        return this.autoDelegate.getAll(iterable);
    }
    
    @Override
    public final Object apply(final Object o) {
        return this.autoDelegate.apply(o);
    }
    
    @Override
    public void refresh(final Object o) {
        this.autoDelegate.refresh(o);
    }
    
    private Object readResolve() {
        return this.autoDelegate;
    }
}
