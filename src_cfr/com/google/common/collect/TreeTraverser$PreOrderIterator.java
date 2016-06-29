/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.collect.Iterators;
import com.google.common.collect.TreeTraverser;
import com.google.common.collect.UnmodifiableIterator;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

final class TreeTraverser$PreOrderIterator
extends UnmodifiableIterator {
    private final Deque stack;
    final /* synthetic */ TreeTraverser this$0;

    TreeTraverser$PreOrderIterator(TreeTraverser treeTraverser, Object object) {
        this.this$0 = treeTraverser;
        this.stack = new ArrayDeque();
        this.stack.addLast(Iterators.singletonIterator(Preconditions.checkNotNull(object)));
    }

    @Override
    public boolean hasNext() {
        if (this.stack.isEmpty()) return false;
        return true;
    }

    public Object next() {
        Iterator iterator;
        Iterator iterator2 = (Iterator)this.stack.getLast();
        Object object = Preconditions.checkNotNull(iterator2.next());
        if (!iterator2.hasNext()) {
            this.stack.removeLast();
        }
        if (!(iterator = this.this$0.children(object).iterator()).hasNext()) return object;
        this.stack.addLast(iterator);
        return object;
    }
}

