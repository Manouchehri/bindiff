package com.google.protobuf;

import java.util.*;

class SmallSortedMap$EntryIterator implements Iterator
{
    private int pos;
    private boolean nextCalledBeforeRemove;
    private Iterator lazyOverflowIterator;
    final /* synthetic */ SmallSortedMap this$0;
    
    private SmallSortedMap$EntryIterator(final SmallSortedMap this$0) {
        this.this$0 = this$0;
        this.pos = -1;
    }
    
    public boolean hasNext() {
        return this.pos + 1 < this.this$0.entryList.size() || this.getOverflowIterator().hasNext();
    }
    
    public Map.Entry next() {
        this.nextCalledBeforeRemove = true;
        if (++this.pos < this.this$0.entryList.size()) {
            return (Map.Entry)this.this$0.entryList.get(this.pos);
        }
        return (Map.Entry)this.getOverflowIterator().next();
    }
    
    public void remove() {
        if (!this.nextCalledBeforeRemove) {
            throw new IllegalStateException("remove() was called before next()");
        }
        this.nextCalledBeforeRemove = false;
        this.this$0.checkMutable();
        if (this.pos < this.this$0.entryList.size()) {
            this.this$0.removeArrayEntryAt(this.pos--);
        }
        else {
            this.getOverflowIterator().remove();
        }
    }
    
    private Iterator getOverflowIterator() {
        if (this.lazyOverflowIterator == null) {
            this.lazyOverflowIterator = this.this$0.overflowEntries.entrySet().iterator();
        }
        return this.lazyOverflowIterator;
    }
}
