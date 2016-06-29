/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.util.concurrent;

import com.google.common.util.concurrent.AbstractFuture;
import com.google.common.util.concurrent.AbstractFuture$1;
import com.google.common.util.concurrent.AbstractFuture$AtomicHelper;
import com.google.common.util.concurrent.AbstractFuture$Listener;
import com.google.common.util.concurrent.AbstractFuture$Waiter;

final class AbstractFuture$SafeAtomicHelper
extends AbstractFuture$AtomicHelper {
    private AbstractFuture$SafeAtomicHelper() {
        super(null);
    }

    @Override
    void putThread(AbstractFuture$Waiter abstractFuture$Waiter, Thread thread) {
        AbstractFuture.access$600().lazySet(abstractFuture$Waiter, thread);
    }

    @Override
    void putNext(AbstractFuture$Waiter abstractFuture$Waiter, AbstractFuture$Waiter abstractFuture$Waiter2) {
        AbstractFuture.access$700().lazySet(abstractFuture$Waiter, abstractFuture$Waiter2);
    }

    @Override
    boolean casWaiters(AbstractFuture abstractFuture, AbstractFuture$Waiter abstractFuture$Waiter, AbstractFuture$Waiter abstractFuture$Waiter2) {
        return AbstractFuture.access$800().compareAndSet(abstractFuture, abstractFuture$Waiter, abstractFuture$Waiter2);
    }

    @Override
    boolean casListeners(AbstractFuture abstractFuture, AbstractFuture$Listener abstractFuture$Listener, AbstractFuture$Listener abstractFuture$Listener2) {
        return AbstractFuture.access$900().compareAndSet(abstractFuture, abstractFuture$Listener, abstractFuture$Listener2);
    }

    @Override
    boolean casValue(AbstractFuture abstractFuture, Object object, Object object2) {
        return AbstractFuture.access$1000().compareAndSet(abstractFuture, object, object2);
    }

    /* synthetic */ AbstractFuture$SafeAtomicHelper(AbstractFuture$1 abstractFuture$1) {
        this();
    }
}

