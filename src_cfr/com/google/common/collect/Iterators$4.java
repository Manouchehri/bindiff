/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.collect.CollectPreconditions;
import com.google.common.collect.Iterators;
import java.util.Iterator;
import java.util.NoSuchElementException;

final class Iterators$4
implements Iterator {
    Iterator iterator;
    Iterator removeFrom;
    final /* synthetic */ Iterable val$iterable;

    Iterators$4(Iterable iterable) {
        this.val$iterable = iterable;
        this.iterator = Iterators.emptyIterator();
    }

    @Override
    public boolean hasNext() {
        if (this.iterator.hasNext()) return this.iterator.hasNext();
        this.iterator = this.val$iterable.iterator();
        return this.iterator.hasNext();
    }

    public Object next() {
        if (!this.hasNext()) {
            throw new NoSuchElementException();
        }
        this.removeFrom = this.iterator;
        return this.iterator.next();
    }

    @Override
    public void remove() {
        CollectPreconditions.checkRemove(this.removeFrom != null);
        this.removeFrom.remove();
        this.removeFrom = null;
    }
}

