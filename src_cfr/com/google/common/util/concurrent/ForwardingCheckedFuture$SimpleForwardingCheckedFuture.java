/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.CheckedFuture;
import com.google.common.util.concurrent.ForwardingCheckedFuture;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Future;

@Beta
public abstract class ForwardingCheckedFuture$SimpleForwardingCheckedFuture
extends ForwardingCheckedFuture {
    private final CheckedFuture delegate;

    protected ForwardingCheckedFuture$SimpleForwardingCheckedFuture(CheckedFuture checkedFuture) {
        this.delegate = (CheckedFuture)Preconditions.checkNotNull(checkedFuture);
    }

    @Override
    protected final CheckedFuture delegate() {
        return this.delegate;
    }
}

