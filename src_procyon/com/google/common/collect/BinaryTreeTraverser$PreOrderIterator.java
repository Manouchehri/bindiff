package com.google.common.collect;

import java.util.*;
import com.google.common.annotations.*;
import com.google.common.base.*;

final class BinaryTreeTraverser$PreOrderIterator extends UnmodifiableIterator implements PeekingIterator
{
    private final Deque stack;
    final /* synthetic */ BinaryTreeTraverser this$0;
    
    BinaryTreeTraverser$PreOrderIterator(final BinaryTreeTraverser this$0, final Object o) {
        this.this$0 = this$0;
        (this.stack = new ArrayDeque()).addLast(o);
    }
    
    @Override
    public boolean hasNext() {
        return !this.stack.isEmpty();
    }
    
    @Override
    public Object next() {
        final Object removeLast = this.stack.removeLast();
        pushIfPresent(this.stack, this.this$0.rightChild(removeLast));
        pushIfPresent(this.stack, this.this$0.leftChild(removeLast));
        return removeLast;
    }
    
    @Override
    public Object peek() {
        return this.stack.getLast();
    }
}
