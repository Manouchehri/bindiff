/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.base.Optional;
import com.google.common.collect.AbstractIterator;
import com.google.common.collect.BinaryTreeTraverser;
import java.util.ArrayDeque;
import java.util.BitSet;
import java.util.Deque;

final class BinaryTreeTraverser$InOrderIterator
extends AbstractIterator {
    private final Deque stack;
    private final BitSet hasExpandedLeft;
    final /* synthetic */ BinaryTreeTraverser this$0;

    BinaryTreeTraverser$InOrderIterator(BinaryTreeTraverser binaryTreeTraverser, Object object) {
        this.this$0 = binaryTreeTraverser;
        this.stack = new ArrayDeque();
        this.hasExpandedLeft = new BitSet();
        this.stack.addLast(object);
    }

    @Override
    protected Object computeNext() {
        while (!this.stack.isEmpty()) {
            Object e2 = this.stack.getLast();
            if (this.hasExpandedLeft.get(this.stack.size() - 1)) {
                this.stack.removeLast();
                this.hasExpandedLeft.clear(this.stack.size());
                BinaryTreeTraverser.access$000(this.stack, this.this$0.rightChild(e2));
                return e2;
            }
            this.hasExpandedLeft.set(this.stack.size() - 1);
            BinaryTreeTraverser.access$000(this.stack, this.this$0.leftChild(e2));
        }
        return this.endOfData();
    }
}

