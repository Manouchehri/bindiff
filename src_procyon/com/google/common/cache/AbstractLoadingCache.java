package com.google.common.cache;

import com.google.common.util.concurrent.*;
import java.util.concurrent.*;
import com.google.common.collect.*;
import java.util.*;

public abstract class AbstractLoadingCache extends AbstractCache implements LoadingCache
{
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
        final LinkedHashMap linkedHashMap = Maps.newLinkedHashMap();
        for (final Object next : iterable) {
            if (!linkedHashMap.containsKey(next)) {
                linkedHashMap.put(next, this.get(next));
            }
        }
        return ImmutableMap.copyOf(linkedHashMap);
    }
    
    @Override
    public final Object apply(final Object o) {
        return this.getUnchecked(o);
    }
    
    @Override
    public void refresh(final Object o) {
        throw new UnsupportedOperationException();
    }
}
