/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.util.concurrent;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.CheckedFuture;
import com.google.common.util.concurrent.Futures$1;
import com.google.common.util.concurrent.Futures$ImmediateFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

@GwtIncompatible(value="TODO")
class Futures$ImmediateFailedCheckedFuture
extends Futures$ImmediateFuture
implements CheckedFuture {
    private final Exception thrown;

    Futures$ImmediateFailedCheckedFuture(Exception exception) {
        super(null);
        this.thrown = exception;
    }

    @Override
    public Object get() {
        throw new ExecutionException(this.thrown);
    }

    @Override
    public Object checkedGet() {
        throw this.thrown;
    }

    @Override
    public Object checkedGet(long l2, TimeUnit timeUnit) {
        Preconditions.checkNotNull((Object)timeUnit);
        throw this.thrown;
    }
}

