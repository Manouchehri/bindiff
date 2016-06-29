package com.google.common.collect;

import java.io.*;
import com.google.common.annotations.*;
import com.google.common.base.*;
import javax.annotation.*;
import java.util.*;

class AbstractMapBasedMultimap$KeySet$1 implements Iterator
{
    Map.Entry entry;
    final /* synthetic */ Iterator val$entryIterator;
    final /* synthetic */ AbstractMapBasedMultimap$KeySet this$1;
    
    AbstractMapBasedMultimap$KeySet$1(final AbstractMapBasedMultimap$KeySet this$1, final Iterator val$entryIterator) {
        this.this$1 = this$1;
        this.val$entryIterator = val$entryIterator;
    }
    
    @Override
    public boolean hasNext() {
        return this.val$entryIterator.hasNext();
    }
    
    @Override
    public Object next() {
        this.entry = (Map.Entry)this.val$entryIterator.next();
        return this.entry.getKey();
    }
    
    @Override
    public void remove() {
        CollectPreconditions.checkRemove(this.entry != null);
        final Collection collection = this.entry.getValue();
        this.val$entryIterator.remove();
        this.this$1.this$0.totalSize -= collection.size();
        collection.clear();
    }
}
