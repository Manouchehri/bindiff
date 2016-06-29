package com.google.common.collect;

import java.io.*;
import com.google.common.annotations.*;
import com.google.common.base.*;
import javax.annotation.*;
import java.util.*;

abstract class AbstractMapBasedMultimap$Itr implements Iterator
{
    final Iterator keyIterator;
    Object key;
    Collection collection;
    Iterator valueIterator;
    final /* synthetic */ AbstractMapBasedMultimap this$0;
    
    AbstractMapBasedMultimap$Itr(final AbstractMapBasedMultimap this$0) {
        this.this$0 = this$0;
        this.keyIterator = this$0.map.entrySet().iterator();
        this.key = null;
        this.collection = null;
        this.valueIterator = Iterators.emptyModifiableIterator();
    }
    
    abstract Object output(final Object p0, final Object p1);
    
    @Override
    public boolean hasNext() {
        return this.keyIterator.hasNext() || this.valueIterator.hasNext();
    }
    
    @Override
    public Object next() {
        if (!this.valueIterator.hasNext()) {
            final Map.Entry<Object, V> entry = this.keyIterator.next();
            this.key = entry.getKey();
            this.collection = (Collection)entry.getValue();
            this.valueIterator = this.collection.iterator();
        }
        return this.output(this.key, this.valueIterator.next());
    }
    
    @Override
    public void remove() {
        this.valueIterator.remove();
        if (this.collection.isEmpty()) {
            this.keyIterator.remove();
        }
        this.this$0.totalSize--;
    }
}
