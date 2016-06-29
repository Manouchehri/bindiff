package com.google.common.collect;

import java.util.*;

final class Iterators$10 implements Iterator
{
    private int count;
    final /* synthetic */ int val$limitSize;
    final /* synthetic */ Iterator val$iterator;
    
    Iterators$10(final int val$limitSize, final Iterator val$iterator) {
        this.val$limitSize = val$limitSize;
        this.val$iterator = val$iterator;
    }
    
    @Override
    public boolean hasNext() {
        return this.count < this.val$limitSize && this.val$iterator.hasNext();
    }
    
    @Override
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
