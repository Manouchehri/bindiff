package com.google.common.collect;

import java.util.*;

class Iterators$MergingIterator extends UnmodifiableIterator
{
    final Queue queue;
    
    public Iterators$MergingIterator(final Iterable iterable, final Comparator comparator) {
        this.queue = new PriorityQueue(2, new Iterators$MergingIterator$1(this, comparator));
        for (final Iterator iterator2 : iterable) {
            if (iterator2.hasNext()) {
                this.queue.add(Iterators.peekingIterator(iterator2));
            }
        }
    }
    
    @Override
    public boolean hasNext() {
        return !this.queue.isEmpty();
    }
    
    @Override
    public Object next() {
        final PeekingIterator peekingIterator = this.queue.remove();
        final Object next = peekingIterator.next();
        if (peekingIterator.hasNext()) {
            this.queue.add(peekingIterator);
        }
        return next;
    }
}
