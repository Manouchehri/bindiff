/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.collect.ForwardingDeque;
import java.util.Collection;
import java.util.Deque;
import java.util.Queue;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.TimeUnit;

public abstract class ForwardingBlockingDeque
extends ForwardingDeque
implements BlockingDeque {
    protected ForwardingBlockingDeque() {
    }

    @Override
    protected abstract BlockingDeque delegate();

    @Override
    public int remainingCapacity() {
        return this.delegate().remainingCapacity();
    }

    public void putFirst(Object object) {
        this.delegate().putFirst(object);
    }

    public void putLast(Object object) {
        this.delegate().putLast(object);
    }

    public boolean offerFirst(Object object, long l2, TimeUnit timeUnit) {
        return this.delegate().offerFirst(object, l2, timeUnit);
    }

    public boolean offerLast(Object object, long l2, TimeUnit timeUnit) {
        return this.delegate().offerLast(object, l2, timeUnit);
    }

    public Object takeFirst() {
        return this.delegate().takeFirst();
    }

    public Object takeLast() {
        return this.delegate().takeLast();
    }

    public Object pollFirst(long l2, TimeUnit timeUnit) {
        return this.delegate().pollFirst(l2, timeUnit);
    }

    public Object pollLast(long l2, TimeUnit timeUnit) {
        return this.delegate().pollLast(l2, timeUnit);
    }

    @Override
    public void put(Object object) {
        this.delegate().put(object);
    }

    @Override
    public boolean offer(Object object, long l2, TimeUnit timeUnit) {
        return this.delegate().offer(object, l2, timeUnit);
    }

    @Override
    public Object take() {
        return this.delegate().take();
    }

    @Override
    public Object poll(long l2, TimeUnit timeUnit) {
        return this.delegate().poll(l2, timeUnit);
    }

    @Override
    public int drainTo(Collection collection) {
        return this.delegate().drainTo(collection);
    }

    @Override
    public int drainTo(Collection collection, int n2) {
        return this.delegate().drainTo(collection, n2);
    }
}

