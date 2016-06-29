package com.google.common.collect;

import java.util.*;

final class Iterables$6 extends FluentIterable
{
    final /* synthetic */ Iterable val$first;
    final /* synthetic */ Iterable val$second;
    
    Iterables$6(final Iterable val$first, final Iterable val$second) {
        this.val$first = val$first;
        this.val$second = val$second;
    }
    
    @Override
    public Iterator iterator() {
        return Iterators.pairUp(this.val$first.iterator(), this.val$second.iterator());
    }
}
