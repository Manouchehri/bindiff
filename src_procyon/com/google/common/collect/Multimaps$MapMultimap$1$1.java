package com.google.common.collect;

import java.util.*;

class Multimaps$MapMultimap$1$1 implements Iterator
{
    int i;
    final /* synthetic */ Multimaps$MapMultimap$1 this$1;
    
    Multimaps$MapMultimap$1$1(final Multimaps$MapMultimap$1 this$1) {
        this.this$1 = this$1;
    }
    
    @Override
    public boolean hasNext() {
        return this.i == 0 && this.this$1.this$0.map.containsKey(this.this$1.val$key);
    }
    
    @Override
    public Object next() {
        if (!this.hasNext()) {
            throw new NoSuchElementException();
        }
        ++this.i;
        return this.this$1.this$0.map.get(this.this$1.val$key);
    }
    
    @Override
    public void remove() {
        CollectPreconditions.checkRemove(this.i == 1);
        this.i = -1;
        this.this$1.this$0.map.remove(this.this$1.val$key);
    }
}
