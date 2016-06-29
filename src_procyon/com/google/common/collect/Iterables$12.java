package com.google.common.collect;

import java.util.*;

final class Iterables$12 extends FluentIterable
{
    final /* synthetic */ Iterable val$iterable;
    final /* synthetic */ int val$limitSize;
    
    Iterables$12(final Iterable val$iterable, final int val$limitSize) {
        this.val$iterable = val$iterable;
        this.val$limitSize = val$limitSize;
    }
    
    @Override
    public Iterator iterator() {
        return Iterators.limit(this.val$iterable.iterator(), this.val$limitSize);
    }
}
