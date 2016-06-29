/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.base.Optional;
import com.google.common.collect.BinaryTreeTraverser;
import com.google.common.collect.PeekingIterator;
import com.google.common.collect.UnmodifiableIterator;
import java.util.ArrayDeque;
import java.util.Deque;

final class BinaryTreeTraverser$PreOrderIterator
extends UnmodifiableIterator
implements PeekingIterator {
    private final Deque stack;
    final /* synthetic */ BinaryTreeTraverser this$0;

    BinaryTreeTraverser$PreOrderIterator(BinaryTreeTraverser binaryTreeTraverser, Object object) {
        this.this$0 = binaryTreeTraverser;
        this.stack = new ArrayDeque();
        this.stack.addLast(object);
    }

    @Override
    public boolean hasNext() {
        if (this.stack.isEmpty()) return false;
        return true;
    }

    @Override
    public Object next() {
        Object e2 = this.stack.removeLast();
        BinaryTreeTraverser.access$000(this.stack, this.this$0.rightChild(e2));
        BinaryTreeTraverser.access$000(this.stack, this.this$0.leftChild(e2));
        return e2;
    }

    @Override
    public Object peek() {
        return this.stack.getLast();
    }
}

