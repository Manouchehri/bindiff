package com.google.common.collect;

import java.util.*;

class TreeTraverser$3 extends FluentIterable
{
    final /* synthetic */ Object val$root;
    final /* synthetic */ TreeTraverser this$0;
    
    TreeTraverser$3(final TreeTraverser this$0, final Object val$root) {
        this.this$0 = this$0;
        this.val$root = val$root;
    }
    
    @Override
    public UnmodifiableIterator iterator() {
        return new TreeTraverser$BreadthFirstIterator(this.this$0, this.val$root);
    }
}
