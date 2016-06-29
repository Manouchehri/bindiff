/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.collect.ForwardingIterator;
import java.util.Iterator;
import java.util.ListIterator;

@GwtCompatible
public abstract class ForwardingListIterator
extends ForwardingIterator
implements ListIterator {
    protected ForwardingListIterator() {
    }

    @Override
    protected abstract ListIterator delegate();

    public void add(Object object) {
        this.delegate().add(object);
    }

    @Override
    public boolean hasPrevious() {
        return this.delegate().hasPrevious();
    }

    @Override
    public int nextIndex() {
        return this.delegate().nextIndex();
    }

    public Object previous() {
        return this.delegate().previous();
    }

    @Override
    public int previousIndex() {
        return this.delegate().previousIndex();
    }

    public void set(Object object) {
        this.delegate().set(object);
    }
}

