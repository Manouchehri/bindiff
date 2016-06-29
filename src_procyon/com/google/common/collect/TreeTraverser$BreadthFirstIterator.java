package com.google.common.collect;

import java.util.*;

final class TreeTraverser$BreadthFirstIterator extends UnmodifiableIterator implements PeekingIterator
{
    private final Queue queue;
    final /* synthetic */ TreeTraverser this$0;
    
    TreeTraverser$BreadthFirstIterator(final TreeTraverser this$0, final Object o) {
        this.this$0 = this$0;
        (this.queue = new ArrayDeque()).add(o);
    }
    
    @Override
    public boolean hasNext() {
        return !this.queue.isEmpty();
    }
    
    @Override
    public Object peek() {
        return this.queue.element();
    }
    
    @Override
    public Object next() {
        final Object remove = this.queue.remove();
        Iterables.addAll(this.queue, this.this$0.children(remove));
        return remove;
    }
}
