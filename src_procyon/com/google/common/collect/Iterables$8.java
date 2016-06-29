package com.google.common.collect;

import java.util.*;

final class Iterables$8 extends FluentIterable
{
    final /* synthetic */ Iterable val$unfiltered;
    final /* synthetic */ Class val$type;
    
    Iterables$8(final Iterable val$unfiltered, final Class val$type) {
        this.val$unfiltered = val$unfiltered;
        this.val$type = val$type;
    }
    
    @Override
    public Iterator iterator() {
        return Iterators.filter(this.val$unfiltered.iterator(), this.val$type);
    }
}
