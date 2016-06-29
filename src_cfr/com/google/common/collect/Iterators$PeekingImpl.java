/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.collect.PeekingIterator;
import java.util.Iterator;

class Iterators$PeekingImpl
implements PeekingIterator {
    private final Iterator iterator;
    private boolean hasPeeked;
    private Object peekedElement;

    public Iterators$PeekingImpl(Iterator iterator) {
        this.iterator = (Iterator)Preconditions.checkNotNull(iterator);
    }

    @Override
    public boolean hasNext() {
        if (this.hasPeeked) return true;
        if (this.iterator.hasNext()) return true;
        return false;
    }

    @Override
    public Object next() {
        if (!this.hasPeeked) {
            return this.iterator.next();
        }
        Object object = this.peekedElement;
        this.hasPeeked = false;
        this.peekedElement = null;
        return object;
    }

    @Override
    public void remove() {
        Preconditions.checkState(!this.hasPeeked, "Can't remove after you've peeked at next");
        this.iterator.remove();
    }

    @Override
    public Object peek() {
        if (this.hasPeeked) return this.peekedElement;
        this.peekedElement = this.iterator.next();
        this.hasPeeked = true;
        return this.peekedElement;
    }
}

