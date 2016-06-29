package com.google.common.collect;

import java.util.*;

final class Iterables$11 extends FluentIterable
{
    final /* synthetic */ Iterable val$iterable;
    final /* synthetic */ int val$numberToSkip;
    
    Iterables$11(final Iterable val$iterable, final int val$numberToSkip) {
        this.val$iterable = val$iterable;
        this.val$numberToSkip = val$numberToSkip;
    }
    
    @Override
    public Iterator iterator() {
        final Iterator iterator = this.val$iterable.iterator();
        Iterators.advance(iterator, this.val$numberToSkip);
        return new Iterables$11$1(this, iterator);
    }
}
