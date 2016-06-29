/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.collect.Iterables;
import com.google.common.collect.PeekingIterator;
import com.google.common.collect.TreeTraverser;
import com.google.common.collect.UnmodifiableIterator;
import java.util.ArrayDeque;
import java.util.Queue;

final class TreeTraverser$BreadthFirstIterator
extends UnmodifiableIterator
implements PeekingIterator {
    private final Queue queue;
    final /* synthetic */ TreeTraverser this$0;

    TreeTraverser$BreadthFirstIterator(TreeTraverser treeTraverser, Object object) {
        this.this$0 = treeTraverser;
        this.queue = new ArrayDeque();
        this.queue.add(object);
    }

    @Override
    public boolean hasNext() {
        if (this.queue.isEmpty()) return false;
        return true;
    }

    @Override
    public Object peek() {
        return this.queue.element();
    }

    @Override
    public Object next() {
        Object e2 = this.queue.remove();
        Iterables.addAll(this.queue, this.this$0.children(e2));
        return e2;
    }
}

