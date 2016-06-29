package com.google.common.collect;

import java.util.*;

final class Iterables$1 extends FluentIterable
{
    final /* synthetic */ Iterable val$iterable;
    
    Iterables$1(final Iterable val$iterable) {
        this.val$iterable = val$iterable;
    }
    
    @Override
    public Iterator iterator() {
        return Iterators.cycle(this.val$iterable);
    }
    
    @Override
    public String toString() {
        return String.valueOf(this.val$iterable.toString()).concat(" (cycled)");
    }
}
