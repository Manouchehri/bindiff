/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.util.concurrent;

import com.google.common.util.concurrent.AbstractFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

abstract class AbstractFuture$TrustedFuture
extends AbstractFuture {
    AbstractFuture$TrustedFuture() {
    }

    @Override
    public final Object get() {
        return super.get();
    }

    @Override
    public final Object get(long l2, TimeUnit timeUnit) {
        return super.get(l2, timeUnit);
    }

    @Override
    public final boolean isDone() {
        return super.isDone();
    }

    @Override
    public final boolean isCancelled() {
        return super.isCancelled();
    }

    @Override
    public final void addListener(Runnable runnable, Executor executor) {
        super.addListener(runnable, executor);
    }
}

