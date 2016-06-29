/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.collect.ForwardingQueue;
import java.io.Serializable;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Queue;

@Beta
@GwtIncompatible(value="java.util.ArrayDeque")
public final class EvictingQueue
extends ForwardingQueue
implements Serializable {
    private final Queue delegate;
    @VisibleForTesting
    final int maxSize;
    private static final long serialVersionUID = 0;

    private EvictingQueue(int n2) {
        Preconditions.checkArgument(n2 >= 0, "maxSize (%s) must >= 0", n2);
        this.delegate = new ArrayDeque(n2);
        this.maxSize = n2;
    }

    public static EvictingQueue create(int n2) {
        return new EvictingQueue(n2);
    }

    public int remainingCapacity() {
        return this.maxSize - this.size();
    }

    @Override
    protected Queue delegate() {
        return this.delegate;
    }

    @Override
    public boolean offer(Object object) {
        return this.add(object);
    }

    @Override
    public boolean add(Object object) {
        Preconditions.checkNotNull(object);
        if (this.maxSize == 0) {
            return true;
        }
        if (this.size() == this.maxSize) {
            this.delegate.remove();
        }
        this.delegate.add(object);
        return true;
    }

    @Override
    public boolean addAll(Collection collection) {
        return this.standardAddAll(collection);
    }

    @Override
    public boolean contains(Object object) {
        return this.delegate().contains(Preconditions.checkNotNull(object));
    }

    @Override
    public boolean remove(Object object) {
        return this.delegate().remove(Preconditions.checkNotNull(object));
    }
}

