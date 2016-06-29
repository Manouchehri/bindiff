package com.google.common.collect;

import java.util.*;

final class Iterables$4 extends FluentIterable
{
    final /* synthetic */ Iterable val$iterable;
    final /* synthetic */ int val$size;
    
    Iterables$4(final Iterable val$iterable, final int val$size) {
        this.val$iterable = val$iterable;
        this.val$size = val$size;
    }
    
    @Override
    public Iterator iterator() {
        return Iterators.partition(this.val$iterable.iterator(), this.val$size);
    }
}
