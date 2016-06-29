package com.google.common.collect;

import java.util.*;
import com.google.common.annotations.*;
import com.google.common.base.*;

final class BinaryTreeTraverser$PostOrderIterator extends UnmodifiableIterator
{
    private final Deque stack;
    private final BitSet hasExpanded;
    final /* synthetic */ BinaryTreeTraverser this$0;
    
    BinaryTreeTraverser$PostOrderIterator(final BinaryTreeTraverser this$0, final Object o) {
        this.this$0 = this$0;
        (this.stack = new ArrayDeque()).addLast(o);
        this.hasExpanded = new BitSet();
    }
    
    @Override
    public boolean hasNext() {
        return !this.stack.isEmpty();
    }
    
    @Override
    public Object next() {
        Object last;
        while (true) {
            last = this.stack.getLast();
            if (this.hasExpanded.get(this.stack.size() - 1)) {
                break;
            }
            this.hasExpanded.set(this.stack.size() - 1);
            pushIfPresent(this.stack, this.this$0.rightChild(last));
            pushIfPresent(this.stack, this.this$0.leftChild(last));
        }
        this.stack.removeLast();
        this.hasExpanded.clear(this.stack.size());
        return last;
    }
}
