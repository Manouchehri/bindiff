package com.google.common.collect;

import com.google.common.annotations.*;
import com.google.common.base.*;
import java.util.*;
import com.google.common.primitives.*;
import javax.annotation.*;
import java.io.*;

class AbstractMapBasedMultiset$MapBasedMultisetIterator implements Iterator
{
    final Iterator entryIterator;
    Map.Entry currentEntry;
    int occurrencesLeft;
    boolean canRemove;
    final /* synthetic */ AbstractMapBasedMultiset this$0;
    
    AbstractMapBasedMultiset$MapBasedMultisetIterator(final AbstractMapBasedMultiset this$0) {
        this.this$0 = this$0;
        this.entryIterator = this$0.backingMap.entrySet().iterator();
    }
    
    @Override
    public boolean hasNext() {
        return this.occurrencesLeft > 0 || this.entryIterator.hasNext();
    }
    
    @Override
    public Object next() {
        if (this.occurrencesLeft == 0) {
            this.currentEntry = (Map.Entry)this.entryIterator.next();
            this.occurrencesLeft = this.currentEntry.getValue().get();
        }
        --this.occurrencesLeft;
        this.canRemove = true;
        return this.currentEntry.getKey();
    }
    
    @Override
    public void remove() {
        CollectPreconditions.checkRemove(this.canRemove);
        if (this.currentEntry.getValue().get() <= 0) {
            throw new ConcurrentModificationException();
        }
        if (this.currentEntry.getValue().addAndGet(-1) == 0) {
            this.entryIterator.remove();
        }
        this.this$0.size--;
        this.canRemove = false;
    }
}
