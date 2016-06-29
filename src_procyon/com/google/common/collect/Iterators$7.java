package com.google.common.collect;

import com.google.common.base.*;
import java.util.*;

final class Iterators$7 implements Iterator
{
    final /* synthetic */ Iterator val$first;
    final /* synthetic */ Iterator val$second;
    
    Iterators$7(final Iterator val$first, final Iterator val$second) {
        this.val$first = val$first;
        this.val$second = val$second;
    }
    
    @Override
    public boolean hasNext() {
        return this.val$first.hasNext() && this.val$second.hasNext();
    }
    
    @Override
    public Pair next() {
        if (!this.hasNext()) {
            throw new NoSuchElementException();
        }
        return Pair.of(this.val$first.next(), this.val$second.next());
    }
    
    @Override
    public void remove() {
        throw new UnsupportedOperationException("remove() not yet implemented for paired lists.");
    }
}
