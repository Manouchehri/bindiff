/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.util.concurrent;

import com.google.common.collect.ForwardingObject;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public abstract class ForwardingFuture
extends ForwardingObject
implements Future {
    protected ForwardingFuture() {
    }

    @Override
    protected abstract Future delegate();

    @Override
    public boolean cancel(boolean bl2) {
        return this.delegate().cancel(bl2);
    }

    @Override
    public boolean isCancelled() {
        return this.delegate().isCancelled();
    }

    @Override
    public boolean isDone() {
        return this.delegate().isDone();
    }

    public Object get() {
        return this.delegate().get();
    }

    public Object get(long l2, TimeUnit timeUnit) {
        return this.delegate().get(l2, timeUnit);
    }
}

