package com.google.common.collect;

import java.util.*;

final class TreeTraverser$PostOrderIterator extends AbstractIterator
{
    private final ArrayDeque stack;
    final /* synthetic */ TreeTraverser this$0;
    
    TreeTraverser$PostOrderIterator(final TreeTraverser this$0, final Object o) {
        this.this$0 = this$0;
        (this.stack = new ArrayDeque()).addLast(this.expand(o));
    }
    
    @Override
    protected Object computeNext() {
        while (!this.stack.isEmpty()) {
            final TreeTraverser$PostOrderNode treeTraverser$PostOrderNode = this.stack.getLast();
            if (!treeTraverser$PostOrderNode.childIterator.hasNext()) {
                this.stack.removeLast();
                return treeTraverser$PostOrderNode.root;
            }
            this.stack.addLast(this.expand(treeTraverser$PostOrderNode.childIterator.next()));
        }
        return this.endOfData();
    }
    
    private TreeTraverser$PostOrderNode expand(final Object o) {
        return new TreeTraverser$PostOrderNode(o, this.this$0.children(o).iterator());
    }
}
