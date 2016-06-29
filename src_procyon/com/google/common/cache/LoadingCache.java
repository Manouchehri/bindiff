package com.google.common.cache;

import com.google.common.base.*;
import com.google.common.annotations.*;
import com.google.common.collect.*;
import java.util.concurrent.*;

@GwtCompatible
public interface LoadingCache extends Function, Cache
{
    Object get(final Object p0);
    
    Object getUnchecked(final Object p0);
    
    ImmutableMap getAll(final Iterable p0);
    
    @Deprecated
    Object apply(final Object p0);
    
    void refresh(final Object p0);
    
    ConcurrentMap asMap();
}
