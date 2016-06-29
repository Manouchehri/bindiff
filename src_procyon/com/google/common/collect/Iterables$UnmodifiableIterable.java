package com.google.common.collect;

import java.util.*;

final class Iterables$UnmodifiableIterable extends FluentIterable
{
    private final Iterable iterable;
    
    private Iterables$UnmodifiableIterable(final Iterable iterable) {
        this.iterable = iterable;
    }
    
    @Override
    public Iterator iterator() {
        return Iterators.unmodifiableIterator(this.iterable.iterator());
    }
    
    @Override
    public String toString() {
        return this.iterable.toString();
    }
}
