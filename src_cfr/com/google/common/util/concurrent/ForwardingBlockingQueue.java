/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.util.concurrent;

import com.google.common.collect.ForwardingQueue;
import java.util.Collection;
import java.util.Queue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public abstract class ForwardingBlockingQueue
extends ForwardingQueue
implements BlockingQueue {
    protected ForwardingBlockingQueue() {
    }

    @Override
    protected abstract BlockingQueue delegate();

    public int drainTo(Collection collection, int n2) {
        return this.delegate().drainTo(collection, n2);
    }

    public int drainTo(Collection collection) {
        return this.delegate().drainTo(collection);
    }

    public boolean offer(Object object, long l2, TimeUnit timeUnit) {
        return this.delegate().offer(object, l2, timeUnit);
    }

    public Object poll(long l2, TimeUnit timeUnit) {
        return this.delegate().poll(l2, timeUnit);
    }

    public void put(Object object) {
        this.delegate().put(object);
    }

    @Override
    public int remainingCapacity() {
        return this.delegate().remainingCapacity();
    }

    public Object take() {
        return this.delegate().take();
    }
}

