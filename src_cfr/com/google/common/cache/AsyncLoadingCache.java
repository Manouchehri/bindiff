/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.cache;

import com.google.common.annotations.GoogleInternal;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.collect.ImmutableMap;
import com.google.common.util.concurrent.ListenableFuture;
import javax.annotation.Nullable;

@GoogleInternal
@GwtIncompatible(value="Futures")
public interface AsyncLoadingCache {
    public ListenableFuture get(Object var1);

    public ImmutableMap getAll(Iterable var1);

    @Nullable
    public Object getIfPresent(Object var1);

    public void invalidateAll();

    public void invalidate(Object var1);

    public void put(Object var1, Object var2);
}

