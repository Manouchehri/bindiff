package com.google.common.collect;

import java.util.*;

class Iterables$11$1 implements Iterator
{
    boolean atStart;
    final /* synthetic */ Iterator val$iterator;
    final /* synthetic */ Iterables$11 this$0;
    
    Iterables$11$1(final Iterables$11 this$0, final Iterator val$iterator) {
        this.this$0 = this$0;
        this.val$iterator = val$iterator;
        this.atStart = true;
    }
    
    @Override
    public boolean hasNext() {
        return this.val$iterator.hasNext();
    }
    
    @Override
    public Object next() {
        final Object next = this.val$iterator.next();
        this.atStart = false;
        return next;
    }
    
    @Override
    public void remove() {
        CollectPreconditions.checkRemove(!this.atStart);
        this.val$iterator.remove();
    }
}
