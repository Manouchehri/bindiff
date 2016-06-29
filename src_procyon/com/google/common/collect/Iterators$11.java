package com.google.common.collect;

import java.util.*;

final class Iterators$11 extends UnmodifiableIterator
{
    final /* synthetic */ Iterator val$iterator;
    
    Iterators$11(final Iterator val$iterator) {
        this.val$iterator = val$iterator;
    }
    
    @Override
    public boolean hasNext() {
        return this.val$iterator.hasNext();
    }
    
    @Override
    public Object next() {
        final Object next = this.val$iterator.next();
        this.val$iterator.remove();
        return next;
    }
    
    @Override
    public String toString() {
        return "Iterators.consumingIterator(...)";
    }
}
