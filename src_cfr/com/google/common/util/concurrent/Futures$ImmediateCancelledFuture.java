/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.util.concurrent;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.util.concurrent.AbstractFuture;
import com.google.common.util.concurrent.Futures$1;
import com.google.common.util.concurrent.Futures$ImmediateFuture;
import java.util.concurrent.CancellationException;

@GwtIncompatible(value="TODO")
class Futures$ImmediateCancelledFuture
extends Futures$ImmediateFuture {
    private final CancellationException thrown = new CancellationException("Immediate cancelled future.");

    Futures$ImmediateCancelledFuture() {
        super(null);
    }

    @Override
    public boolean isCancelled() {
        return true;
    }

    @Override
    public Object get() {
        throw AbstractFuture.cancellationExceptionWithCause("Task was cancelled.", this.thrown);
    }
}

