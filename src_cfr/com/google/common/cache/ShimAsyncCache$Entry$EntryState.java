/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.cache;

import com.google.common.cache.ShimAsyncCache$LoadWhen;
import com.google.common.util.concurrent.ListenableFuture;
import javax.annotation.Nullable;

interface ShimAsyncCache$Entry$EntryState {
    @Nullable
    public Object getIfPresent();

    public ListenableFuture getOrLoadFuture();

    public void maybeLoad(ShimAsyncCache$LoadWhen var1);

    public void addFuture(ListenableFuture var1);

    public void handleCompletion(ListenableFuture var1);
}

