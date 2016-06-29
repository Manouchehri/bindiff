/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.util.concurrent;

import com.google.common.util.concurrent.AbstractFuture;
import java.util.concurrent.locks.LockSupport;
import javax.annotation.Nullable;

final class AbstractFuture$Waiter {
    static final AbstractFuture$Waiter TOMBSTONE = new AbstractFuture$Waiter(false);
    @Nullable
    volatile Thread thread;
    @Nullable
    volatile AbstractFuture$Waiter next;

    AbstractFuture$Waiter(boolean bl2) {
    }

    AbstractFuture$Waiter() {
        AbstractFuture.access$200().putThread(this, Thread.currentThread());
    }

    void setNext(AbstractFuture$Waiter abstractFuture$Waiter) {
        AbstractFuture.access$200().putNext(this, abstractFuture$Waiter);
    }

    void unpark() {
        Thread thread = this.thread;
        if (thread == null) return;
        this.thread = null;
        LockSupport.unpark(thread);
    }
}

