package com.google.common.collect;

import java.util.*;

final class Iterables$13 extends FluentIterable
{
    final /* synthetic */ Iterable val$iterable;
    
    Iterables$13(final Iterable val$iterable) {
        this.val$iterable = val$iterable;
    }
    
    @Override
    public Iterator iterator() {
        return new ConsumingQueueIterator((Queue)this.val$iterable);
    }
    
    @Override
    public String toString() {
        return "Iterables.consumingIterable(...)";
    }
}
