package com.google.protobuf;

import java.util.*;

class Internal$MapAdapter$IteratorAdapter implements Iterator
{
    private final Iterator realIterator;
    final /* synthetic */ Internal$MapAdapter this$0;
    
    public Internal$MapAdapter$IteratorAdapter(final Internal$MapAdapter this$0, final Iterator realIterator) {
        this.this$0 = this$0;
        this.realIterator = realIterator;
    }
    
    public boolean hasNext() {
        return this.realIterator.hasNext();
    }
    
    public Map.Entry next() {
        return new Internal$MapAdapter$EntryAdapter(this.this$0, (Map.Entry)this.realIterator.next());
    }
    
    public void remove() {
        this.realIterator.remove();
    }
}
