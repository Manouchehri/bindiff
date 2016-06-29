/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.collect.UnmodifiableIterator;
import java.util.NoSuchElementException;

final class Iterators$13
extends UnmodifiableIterator {
    boolean done;
    final /* synthetic */ Object val$value;

    Iterators$13(Object object) {
        this.val$value = object;
    }

    @Override
    public boolean hasNext() {
        if (this.done) return false;
        return true;
    }

    public Object next() {
        if (this.done) {
            throw new NoSuchElementException();
        }
        this.done = true;
        return this.val$value;
    }
}

