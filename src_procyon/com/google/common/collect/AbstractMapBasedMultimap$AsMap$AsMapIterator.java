package com.google.common.collect;

import java.io.*;
import com.google.common.annotations.*;
import com.google.common.base.*;
import javax.annotation.*;
import java.util.*;

class AbstractMapBasedMultimap$AsMap$AsMapIterator implements Iterator
{
    final Iterator delegateIterator;
    Collection collection;
    final /* synthetic */ AbstractMapBasedMultimap$AsMap this$1;
    
    AbstractMapBasedMultimap$AsMap$AsMapIterator(final AbstractMapBasedMultimap$AsMap this$1) {
        this.this$1 = this$1;
        this.delegateIterator = this.this$1.submap.entrySet().iterator();
    }
    
    @Override
    public boolean hasNext() {
        return this.delegateIterator.hasNext();
    }
    
    @Override
    public Map.Entry next() {
        final Map.Entry<K, Collection> entry = this.delegateIterator.next();
        this.collection = entry.getValue();
        return this.this$1.wrapEntry((Map.Entry)entry);
    }
    
    @Override
    public void remove() {
        this.delegateIterator.remove();
        this.this$1.this$0.totalSize -= this.collection.size();
        this.collection.clear();
    }
}
