/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.util.concurrent;

import com.google.common.util.concurrent.AbstractFuture;
import com.google.common.util.concurrent.AbstractFuture$1;
import com.google.common.util.concurrent.AbstractFuture$Listener;
import com.google.common.util.concurrent.AbstractFuture$Waiter;

abstract class AbstractFuture$AtomicHelper {
    private AbstractFuture$AtomicHelper() {
    }

    abstract void putThread(AbstractFuture.Waiter var1, Thread var2);

    abstract void putNext(AbstractFuture.Waiter var1, AbstractFuture.Waiter var2);

    abstract boolean casWaiters(AbstractFuture var1, AbstractFuture.Waiter var2, AbstractFuture.Waiter var3);

    abstract boolean casListeners(AbstractFuture var1, AbstractFuture.Listener var2, AbstractFuture.Listener var3);

    abstract boolean casValue(AbstractFuture var1, Object var2, Object var3);

    /* synthetic */ AbstractFuture$AtomicHelper(AbstractFuture$1 abstractFuture$1) {
        this();
    }
}

