/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.util.concurrent;

import com.google.common.util.concurrent.Futures$1;
import com.google.common.util.concurrent.Futures$ImmediateFuture;
import java.util.concurrent.ExecutionException;

class Futures$ImmediateFailedFuture
extends Futures$ImmediateFuture {
    private final Throwable thrown;

    Futures$ImmediateFailedFuture(Throwable throwable) {
        super(null);
        this.thrown = throwable;
    }

    @Override
    public Object get() {
        throw new ExecutionException(this.thrown);
    }
}

