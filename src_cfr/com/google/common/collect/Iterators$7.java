/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.base.Pair;
import java.util.Iterator;
import java.util.NoSuchElementException;

final class Iterators$7
implements Iterator {
    final /* synthetic */ Iterator val$first;
    final /* synthetic */ Iterator val$second;

    Iterators$7(Iterator iterator, Iterator iterator2) {
        this.val$first = iterator;
        this.val$second = iterator2;
    }

    @Override
    public boolean hasNext() {
        if (!this.val$first.hasNext()) return false;
        if (!this.val$second.hasNext()) return false;
        return true;
    }

    public Pair next() {
        if (this.hasNext()) return Pair.of(this.val$first.next(), this.val$second.next());
        throw new NoSuchElementException();
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException("remove() not yet implemented for paired lists.");
    }
}

