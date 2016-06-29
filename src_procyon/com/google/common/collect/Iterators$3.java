package com.google.common.collect;

import java.util.*;

final class Iterators$3 extends UnmodifiableIterator
{
    final /* synthetic */ Iterator val$iterator;
    
    Iterators$3(final Iterator val$iterator) {
        this.val$iterator = val$iterator;
    }
    
    @Override
    public boolean hasNext() {
        return this.val$iterator.hasNext();
    }
    
    @Override
    public Object next() {
        return this.val$iterator.next();
    }
}
