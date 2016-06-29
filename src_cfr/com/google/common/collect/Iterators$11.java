/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.collect.UnmodifiableIterator;
import java.util.Iterator;

final class Iterators$11
extends UnmodifiableIterator {
    final /* synthetic */ Iterator val$iterator;

    Iterators$11(Iterator iterator) {
        this.val$iterator = iterator;
    }

    @Override
    public boolean hasNext() {
        return this.val$iterator.hasNext();
    }

    public Object next() {
        Object e2 = this.val$iterator.next();
        this.val$iterator.remove();
        return e2;
    }

    public String toString() {
        return "Iterators.consumingIterator(...)";
    }
}

