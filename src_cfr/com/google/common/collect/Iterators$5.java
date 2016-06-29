/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.collect.CollectPreconditions;
import com.google.common.collect.Iterators;
import java.util.Iterator;
import java.util.NoSuchElementException;

final class Iterators$5
implements Iterator {
    Iterator current;
    Iterator removeFrom;
    final /* synthetic */ Iterator val$inputs;

    Iterators$5(Iterator iterator) {
        this.val$inputs = iterator;
        this.current = Iterators.emptyIterator();
    }

    @Override
    public boolean hasNext() {
        boolean bl2;
        while (!(bl2 = ((Iterator)Preconditions.checkNotNull(this.current)).hasNext())) {
            if (!this.val$inputs.hasNext()) return bl2;
            this.current = (Iterator)this.val$inputs.next();
        }
        return bl2;
    }

    public Object next() {
        if (!this.hasNext()) {
            throw new NoSuchElementException();
        }
        this.removeFrom = this.current;
        return this.current.next();
    }

    @Override
    public void remove() {
        CollectPreconditions.checkRemove(this.removeFrom != null);
        this.removeFrom.remove();
        this.removeFrom = null;
    }
}

