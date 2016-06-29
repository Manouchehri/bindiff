package com.google.common.collect;

import com.google.common.annotations.*;
import com.google.common.base.*;
import java.util.*;
import com.google.common.primitives.*;
import javax.annotation.*;
import java.io.*;

class AbstractMapBasedMultiset$1 implements Iterator
{
    Map.Entry toRemove;
    final /* synthetic */ Iterator val$backingEntries;
    final /* synthetic */ AbstractMapBasedMultiset this$0;
    
    AbstractMapBasedMultiset$1(final AbstractMapBasedMultiset this$0, final Iterator val$backingEntries) {
        this.this$0 = this$0;
        this.val$backingEntries = val$backingEntries;
    }
    
    @Override
    public boolean hasNext() {
        return this.val$backingEntries.hasNext();
    }
    
    @Override
    public Multiset$Entry next() {
        final Map.Entry toRemove = this.val$backingEntries.next();
        this.toRemove = (Map.Entry)toRemove;
        return new AbstractMapBasedMultiset$1$1(this, (Map.Entry)toRemove);
    }
    
    @Override
    public void remove() {
        CollectPreconditions.checkRemove(this.toRemove != null);
        this.this$0.size -= this.toRemove.getValue().getAndSet(0);
        this.val$backingEntries.remove();
        this.toRemove = null;
    }
}
