/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.cache;

import com.google.common.cache.AbstractCache;
import com.google.common.cache.LoadingCache;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import com.google.common.util.concurrent.UncheckedExecutionException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.concurrent.ExecutionException;

public abstract class AbstractLoadingCache
extends AbstractCache
implements LoadingCache {
    protected AbstractLoadingCache() {
    }

    @Override
    public Object getUnchecked(Object object) {
        try {
            return this.get(object);
        }
        catch (ExecutionException var2_2) {
            throw new UncheckedExecutionException(var2_2.getCause());
        }
    }

    @Override
    public ImmutableMap getAll(Iterable iterable) {
        LinkedHashMap linkedHashMap = Maps.newLinkedHashMap();
        Iterator iterator = iterable.iterator();
        while (iterator.hasNext()) {
            Object t2 = iterator.next();
            if (linkedHashMap.containsKey(t2)) continue;
            linkedHashMap.put(t2, this.get(t2));
        }
        return ImmutableMap.copyOf(linkedHashMap);
    }

    @Override
    public final Object apply(Object object) {
        return this.getUnchecked(object);
    }

    @Override
    public void refresh(Object object) {
        throw new UnsupportedOperationException();
    }
}

