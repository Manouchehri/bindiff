package com.google.common.collect;

import java.util.*;

class TreeTraverser$1 extends FluentIterable
{
    final /* synthetic */ Object val$root;
    final /* synthetic */ TreeTraverser this$0;
    
    TreeTraverser$1(final TreeTraverser this$0, final Object val$root) {
        this.this$0 = this$0;
        this.val$root = val$root;
    }
    
    @Override
    public UnmodifiableIterator iterator() {
        return this.this$0.preOrderIterator(this.val$root);
    }
}
