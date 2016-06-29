/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.util.concurrent;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.base.Throwables;
import com.google.common.util.concurrent.AbstractFuture;

@GwtIncompatible(value="TODO")
final class MoreExecutors$ScheduledListeningDecorator$NeverSuccessfulListenableFutureTask
extends AbstractFuture
implements Runnable {
    private final Runnable delegate;

    public MoreExecutors$ScheduledListeningDecorator$NeverSuccessfulListenableFutureTask(Runnable runnable) {
        this.delegate = (Runnable)Preconditions.checkNotNull(runnable);
    }

    @Override
    public void run() {
        try {
            this.delegate.run();
            return;
        }
        catch (Throwable var1_1) {
            this.setException(var1_1);
            throw Throwables.propagate(var1_1);
        }
    }
}

