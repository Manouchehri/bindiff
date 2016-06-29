package com.google.common.collect;

import java.util.*;

final class Iterables$14 extends FluentIterable
{
    final /* synthetic */ Iterable val$iterable;
    
    Iterables$14(final Iterable val$iterable) {
        this.val$iterable = val$iterable;
    }
    
    @Override
    public Iterator iterator() {
        return Iterators.consumingIterator(this.val$iterable.iterator());
    }
    
    @Override
    public String toString() {
        return "Iterables.consumingIterable(...)";
    }
}
