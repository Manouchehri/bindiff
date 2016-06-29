/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.util.concurrent.AbstractFuture$TrustedFuture;
import com.google.common.util.concurrent.ListenableFuture;
import javax.annotation.Nullable;

@GwtCompatible
public final class SettableFuture
extends AbstractFuture$TrustedFuture {
    public static SettableFuture create() {
        return new SettableFuture();
    }

    private SettableFuture() {
    }

    @Override
    public boolean set(@Nullable Object object) {
        return super.set(object);
    }

    @Override
    public boolean setException(Throwable throwable) {
        return super.setException(throwable);
    }

    @Beta
    @Override
    public boolean setFuture(ListenableFuture listenableFuture) {
        return super.setFuture(listenableFuture);
    }
}

