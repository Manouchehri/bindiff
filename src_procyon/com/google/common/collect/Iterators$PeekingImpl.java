package com.google.common.collect;

import java.util.*;
import com.google.common.base.*;

class Iterators$PeekingImpl implements PeekingIterator
{
    private final Iterator iterator;
    private boolean hasPeeked;
    private Object peekedElement;
    
    public Iterators$PeekingImpl(final Iterator iterator) {
        this.iterator = (Iterator)Preconditions.checkNotNull(iterator);
    }
    
    @Override
    public boolean hasNext() {
        return this.hasPeeked || this.iterator.hasNext();
    }
    
    @Override
    public Object next() {
        if (!this.hasPeeked) {
            return this.iterator.next();
        }
        final Object peekedElement = this.peekedElement;
        this.hasPeeked = false;
        this.peekedElement = null;
        return peekedElement;
    }
    
    @Override
    public void remove() {
        Preconditions.checkState(!this.hasPeeked, (Object)"Can't remove after you've peeked at next");
        this.iterator.remove();
    }
    
    @Override
    public Object peek() {
        if (!this.hasPeeked) {
            this.peekedElement = this.iterator.next();
            this.hasPeeked = true;
        }
        return this.peekedElement;
    }
}
