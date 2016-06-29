package com.google.common.collect;

import com.google.common.base.*;
import java.util.*;

final class Iterators$5 implements Iterator
{
    Iterator current;
    Iterator removeFrom;
    final /* synthetic */ Iterator val$inputs;
    
    Iterators$5(final Iterator val$inputs) {
        this.val$inputs = val$inputs;
        this.current = Iterators.emptyIterator();
    }
    
    @Override
    public boolean hasNext() {
        boolean hasNext;
        while (!(hasNext = ((Iterator)Preconditions.checkNotNull(this.current)).hasNext()) && this.val$inputs.hasNext()) {
            this.current = this.val$inputs.next();
        }
        return hasNext;
    }
    
    @Override
    public Object next() {
        if (!this.hasNext()) {
            throw new NoSuchElementException();
        }
        this.removeFrom = this.current;
        return this.current.next();
    }
    
    @Override
    public void remove() {
        CollectPreconditions.checkRemove(this.removeFrom != null);
        this.removeFrom.remove();
        this.removeFrom = null;
    }
}
