/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.collect.Iterators;
import com.google.common.collect.TransformedIterator;
import java.util.Iterator;
import java.util.ListIterator;

@GwtCompatible
abstract class TransformedListIterator
extends TransformedIterator
implements ListIterator {
    TransformedListIterator(ListIterator listIterator) {
        super(listIterator);
    }

    private ListIterator backingIterator() {
        return Iterators.cast(this.backingIterator);
    }

    @Override
    public final boolean hasPrevious() {
        return this.backingIterator().hasPrevious();
    }

    public final Object previous() {
        return this.transform(this.backingIterator().previous());
    }

    @Override
    public final int nextIndex() {
        return this.backingIterator().nextIndex();
    }

    @Override
    public final int previousIndex() {
        return this.backingIterator().previousIndex();
    }

    public void set(Object object) {
        throw new UnsupportedOperationException();
    }

    public void add(Object object) {
        throw new UnsupportedOperationException();
    }
}

