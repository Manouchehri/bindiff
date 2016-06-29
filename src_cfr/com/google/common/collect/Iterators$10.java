/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import java.util.Iterator;
import java.util.NoSuchElementException;

final class Iterators$10
implements Iterator {
    private int count;
    final /* synthetic */ int val$limitSize;
    final /* synthetic */ Iterator val$iterator;

    Iterators$10(int n2, Iterator iterator) {
        this.val$limitSize = n2;
        this.val$iterator = iterator;
    }

    @Override
    public boolean hasNext() {
        if (this.count >= this.val$limitSize) return false;
        if (!this.val$iterator.hasNext()) return false;
        return true;
    }

    public Object next() {
        if (!this.hasNext()) {
            throw new NoSuchElementException();
        }
        ++this.count;
        return this.val$iterator.next();
    }

    @Override
    public void remove() {
        this.val$iterator.remove();
    }
}

