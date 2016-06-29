package com.google.protobuf;

import java.util.*;

class LazyField$LazyIterator implements Iterator
{
    private Iterator iterator;
    
    public LazyField$LazyIterator(final Iterator iterator) {
        this.iterator = iterator;
    }
    
    public boolean hasNext() {
        return this.iterator.hasNext();
    }
    
    public Map.Entry next() {
        final Map.Entry entry = this.iterator.next();
        if (entry.getValue() instanceof LazyField) {
            return new LazyField$LazyEntry((Map.Entry)entry, null);
        }
        return (Map.Entry)entry;
    }
    
    public void remove() {
        this.iterator.remove();
    }
}
