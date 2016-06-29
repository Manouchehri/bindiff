/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.util.concurrent;

import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.ForwardingFuture;
import java.util.concurrent.Future;

public abstract class ForwardingFuture$SimpleForwardingFuture
extends ForwardingFuture {
    private final Future delegate;

    protected ForwardingFuture$SimpleForwardingFuture(Future future) {
        this.delegate = (Future)Preconditions.checkNotNull(future);
    }

    @Override
    protected final Future delegate() {
        return this.delegate;
    }
}

