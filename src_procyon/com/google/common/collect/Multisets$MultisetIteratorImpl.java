package com.google.common.collect;

import java.util.*;

final class Multisets$MultisetIteratorImpl implements Iterator
{
    private final Multiset multiset;
    private final Iterator entryIterator;
    private Multiset$Entry currentEntry;
    private int laterCount;
    private int totalCount;
    private boolean canRemove;
    
    Multisets$MultisetIteratorImpl(final Multiset multiset, final Iterator entryIterator) {
        this.multiset = multiset;
        this.entryIterator = entryIterator;
    }
    
    @Override
    public boolean hasNext() {
        return this.laterCount > 0 || this.entryIterator.hasNext();
    }
    
    @Override
    public Object next() {
        if (!this.hasNext()) {
            throw new NoSuchElementException();
        }
        if (this.laterCount == 0) {
            this.currentEntry = this.entryIterator.next();
            final int count = this.currentEntry.getCount();
            this.laterCount = count;
            this.totalCount = count;
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
        }
        else {
            this.multiset.remove(this.currentEntry.getElement());
        }
        --this.totalCount;
        this.canRemove = false;
    }
}
