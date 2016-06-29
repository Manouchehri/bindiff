package com.google.common.collect;

import java.util.*;

final class Iterators$4 implements Iterator
{
    Iterator iterator;
    Iterator removeFrom;
    final /* synthetic */ Iterable val$iterable;
    
    Iterators$4(final Iterable val$iterable) {
        this.val$iterable = val$iterable;
        this.iterator = Iterators.emptyIterator();
    }
    
    @Override
    public boolean hasNext() {
        if (!this.iterator.hasNext()) {
            this.iterator = this.val$iterable.iterator();
        }
        return this.iterator.hasNext();
    }
    
    @Override
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
