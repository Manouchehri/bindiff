/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.collect.ForwardingObject;
import java.util.Iterator;

@GwtCompatible
public abstract class ForwardingIterator
extends ForwardingObject
implements Iterator {
    protected ForwardingIterator() {
    }

    @Override
    protected abstract Iterator delegate();

    @Override
    public boolean hasNext() {
        return this.delegate().hasNext();
    }

    public Object next() {
        return this.delegate().next();
    }

    @Override
    public void remove() {
        this.delegate().remove();
    }
}

