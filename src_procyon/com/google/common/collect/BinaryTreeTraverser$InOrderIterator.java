package com.google.common.collect;

import java.util.*;
import com.google.common.annotations.*;
import com.google.common.base.*;

final class BinaryTreeTraverser$InOrderIterator extends AbstractIterator
{
    private final Deque stack;
    private final BitSet hasExpandedLeft;
    final /* synthetic */ BinaryTreeTraverser this$0;
    
    BinaryTreeTraverser$InOrderIterator(final BinaryTreeTraverser this$0, final Object o) {
        this.this$0 = this$0;
        this.stack = new ArrayDeque();
        this.hasExpandedLeft = new BitSet();
        this.stack.addLast(o);
    }
    
    @Override
    protected Object computeNext() {
        while (!this.stack.isEmpty()) {
            final Object last = this.stack.getLast();
            if (this.hasExpandedLeft.get(this.stack.size() - 1)) {
                this.stack.removeLast();
                this.hasExpandedLeft.clear(this.stack.size());
                pushIfPresent(this.stack, this.this$0.rightChild(last));
                return last;
            }
            this.hasExpandedLeft.set(this.stack.size() - 1);
            pushIfPresent(this.stack, this.this$0.leftChild(last));
        }
        return this.endOfData();
    }
}
