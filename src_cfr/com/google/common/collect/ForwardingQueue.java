/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.collect.ForwardingCollection;
import java.util.Collection;
import java.util.NoSuchElementException;
import java.util.Queue;

@GwtCompatible
public abstract class ForwardingQueue
extends ForwardingCollection
implements Queue {
    protected ForwardingQueue() {
    }

    @Override
    protected abstract Queue delegate();

    public boolean offer(Object object) {
        return this.delegate().offer(object);
    }

    public Object poll() {
        return this.delegate().poll();
    }

    public Object remove() {
        return this.delegate().remove();
    }

    public Object peek() {
        return this.delegate().peek();
    }

    public Object element() {
        return this.delegate().element();
    }

    protected boolean standardOffer(Object object) {
        try {
            return this.add(object);
        }
        catch (IllegalStateException var2_2) {
            return false;
        }
    }

    protected Object standardPeek() {
        try {
            return this.element();
        }
        catch (NoSuchElementException var1_1) {
            return null;
        }
    }

    protected Object standardPoll() {
        try {
            return this.remove();
        }
        catch (NoSuchElementException var1_1) {
            return null;
        }
    }
}

