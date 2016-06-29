/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.collect.CollectPreconditions;
import com.google.common.collect.Multiset;
import com.google.common.collect.Multiset$Entry;
import java.util.Iterator;
import java.util.NoSuchElementException;

final class Multisets$MultisetIteratorImpl
implements Iterator {
    private final Multiset multiset;
    private final Iterator entryIterator;
    private Multiset$Entry currentEntry;
    private int laterCount;
    private int totalCount;
    private boolean canRemove;

    Multisets$MultisetIteratorImpl(Multiset multiset, Iterator iterator) {
        this.multiset = multiset;
        this.entryIterator = iterator;
    }

    @Override
    public boolean hasNext() {
        if (this.laterCount > 0) return true;
        if (this.entryIterator.hasNext()) return true;
        return false;
    }

    public Object next() {
        if (!this.hasNext()) {
            throw new NoSuchElementException();
        }
        if (this.laterCount == 0) {
            this.currentEntry = (Multiset$Entry)this.entryIterator.next();
            this.totalCount = this.laterCount = this.currentEntry.getCount();
        }
        --this.laterCount;
        this.canRemove = true;
        return this.currentEntry.getElement();
    }

    @Override
    public void remove() {
        CollectPreconditions.checkRemove(this.canRemove);
        if (this.totalCount == 1) {
            this.entryIterator.remove();
        } else {
            this.multiset.remove(this.currentEntry.getElement());
        }
        --this.totalCount;
        this.canRemove = false;
    }
}

