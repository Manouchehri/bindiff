package com.google.common.collect;

import java.util.*;

final class Iterables$5 extends FluentIterable
{
    final /* synthetic */ Iterable val$iterable;
    final /* synthetic */ int val$size;
    
    Iterables$5(final Iterable val$iterable, final int val$size) {
        this.val$iterable = val$iterable;
        this.val$size = val$size;
    }
    
    @Override
    public Iterator iterator() {
        return Iterators.paddedPartition(this.val$iterable.iterator(), this.val$size);
    }
}
