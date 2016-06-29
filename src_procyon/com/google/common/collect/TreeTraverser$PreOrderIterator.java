package com.google.common.collect;

import com.google.common.base.*;
import java.util.*;

final class TreeTraverser$PreOrderIterator extends UnmodifiableIterator
{
    private final Deque stack;
    final /* synthetic */ TreeTraverser this$0;
    
    TreeTraverser$PreOrderIterator(final TreeTraverser this$0, final Object o) {
        this.this$0 = this$0;
        (this.stack = new ArrayDeque()).addLast(Iterators.singletonIterator(Preconditions.checkNotNull(o)));
    }
    
    @Override
    public boolean hasNext() {
        return !this.stack.isEmpty();
    }
    
    @Override
    public Object next() {
        final Iterator<Object> iterator = this.stack.getLast();
        final Object checkNotNull = Preconditions.checkNotNull(iterator.next());
        if (!iterator.hasNext()) {
            this.stack.removeLast();
        }
        final Iterator iterator2 = this.this$0.children(checkNotNull).iterator();
        if (iterator2.hasNext()) {
            this.stack.addLast(iterator2);
        }
        return checkNotNull;
    }
}
