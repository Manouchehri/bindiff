package com.google.common.collect;

import java.util.*;

final class Iterators$13 extends UnmodifiableIterator
{
    boolean done;
    final /* synthetic */ Object val$value;
    
    Iterators$13(final Object val$value) {
        this.val$value = val$value;
    }
    
    @Override
    public boolean hasNext() {
        return !this.done;
    }
    
    @Override
    public Object next() {
        if (this.done) {
            throw new NoSuchElementException();
        }
        this.done = true;
        return this.val$value;
    }
}
