package com.google.common.collect;

import java.util.*;

class BinaryTreeTraverser$1 extends FluentIterable
{
    final /* synthetic */ Object val$root;
    final /* synthetic */ BinaryTreeTraverser this$0;
    
    BinaryTreeTraverser$1(final BinaryTreeTraverser this$0, final Object val$root) {
        this.this$0 = this$0;
        this.val$root = val$root;
    }
    
    @Override
    public Iterator iterator() {
        return new BinaryTreeTraverser$1$1(this);
    }
}
