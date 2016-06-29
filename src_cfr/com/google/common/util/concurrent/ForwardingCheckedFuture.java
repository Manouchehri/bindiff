/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import com.google.common.util.concurrent.CheckedFuture;
import com.google.common.util.concurrent.ForwardingListenableFuture;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

@Beta
public abstract class ForwardingCheckedFuture
extends ForwardingListenableFuture
implements CheckedFuture {
    @Override
    public Object checkedGet() {
        return this.delegate().checkedGet();
    }

    @Override
    public Object checkedGet(long l2, TimeUnit timeUnit) {
        return this.delegate().checkedGet(l2, timeUnit);
    }

    @Override
    protected abstract CheckedFuture delegate();
}

