/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.util.concurrent;

import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.Futures$1;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

abstract class Futures$ImmediateFuture
implements ListenableFuture {
    private static final Logger log = Logger.getLogger(Futures$ImmediateFuture.class.getName());

    private Futures$ImmediateFuture() {
    }

    @Override
    public void addListener(Runnable runnable, Executor executor) {
        Preconditions.checkNotNull(runnable, "Runnable was null.");
        Preconditions.checkNotNull(executor, "Executor was null.");
        try {
            executor.execute(runnable);
            return;
        }
        catch (RuntimeException var3_3) {
            String string = String.valueOf(runnable);
            String string2 = String.valueOf(executor);
            log.log(Level.SEVERE, new StringBuilder(57 + String.valueOf(string).length() + String.valueOf(string2).length()).append("RuntimeException while executing runnable ").append(string).append(" with executor ").append(string2).toString(), var3_3);
        }
    }

    @Override
    public boolean cancel(boolean bl2) {
        return false;
    }

    public abstract Object get();

    public Object get(long l2, TimeUnit timeUnit) {
        Preconditions.checkNotNull((Object)((Object)timeUnit));
        return this.get();
    }

    @Override
    public boolean isCancelled() {
        return false;
    }

    @Override
    public boolean isDone() {
        return true;
    }

    /* synthetic */ Futures$ImmediateFuture(Futures$1 futures$1) {
        this();
    }
}

