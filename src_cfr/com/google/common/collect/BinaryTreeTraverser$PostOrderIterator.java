/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.base.Optional;
import com.google.common.collect.BinaryTreeTraverser;
import com.google.common.collect.UnmodifiableIterator;
import java.util.ArrayDeque;
import java.util.BitSet;
import java.util.Deque;

final class BinaryTreeTraverser$PostOrderIterator
extends UnmodifiableIterator {
    private final Deque stack;
    private final BitSet hasExpanded;
    final /* synthetic */ BinaryTreeTraverser this$0;

    BinaryTreeTraverser$PostOrderIterator(BinaryTreeTraverser binaryTreeTraverser, Object object) {
        this.this$0 = binaryTreeTraverser;
        this.stack = new ArrayDeque();
        this.stack.addLast(object);
        this.hasExpanded = new BitSet();
    }

    @Override
    public boolean hasNext() {
        if (this.stack.isEmpty()) return false;
        return true;
    }

    public Object next() {
        do {
            Object e2 = this.stack.getLast();
            boolean bl2 = this.hasExpanded.get(this.stack.size() - 1);
            if (bl2) {
                this.stack.removeLast();
                this.hasExpanded.clear(this.stack.size());
                return e2;
            }
            this.hasExpanded.set(this.stack.size() - 1);
            BinaryTreeTraverser.access$000(this.stack, this.this$0.rightChild(e2));
            BinaryTreeTraverser.access$000(this.stack, this.this$0.leftChild(e2));
        } while (true);
    }
}

