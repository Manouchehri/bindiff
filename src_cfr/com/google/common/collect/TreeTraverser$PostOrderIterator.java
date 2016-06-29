/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.collect.AbstractIterator;
import com.google.common.collect.TreeTraverser;
import com.google.common.collect.TreeTraverser$PostOrderNode;
import java.util.ArrayDeque;
import java.util.Iterator;

final class TreeTraverser$PostOrderIterator
extends AbstractIterator {
    private final ArrayDeque stack;
    final /* synthetic */ TreeTraverser this$0;

    TreeTraverser$PostOrderIterator(TreeTraverser treeTraverser, Object object) {
        this.this$0 = treeTraverser;
        this.stack = new ArrayDeque();
        this.stack.addLast(this.expand(object));
    }

    @Override
    protected Object computeNext() {
        while (!this.stack.isEmpty()) {
            TreeTraverser$PostOrderNode treeTraverser$PostOrderNode = (TreeTraverser$PostOrderNode)this.stack.getLast();
            if (!treeTraverser$PostOrderNode.childIterator.hasNext()) {
                this.stack.removeLast();
                return treeTraverser$PostOrderNode.root;
            }
            Object e2 = treeTraverser$PostOrderNode.childIterator.next();
            this.stack.addLast(this.expand(e2));
        }
        return this.endOfData();
    }

    private TreeTraverser$PostOrderNode expand(Object object) {
        return new TreeTraverser$PostOrderNode(object, this.this$0.children(object).iterator());
    }
}

