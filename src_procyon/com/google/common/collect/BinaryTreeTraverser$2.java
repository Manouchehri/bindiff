package com.google.common.collect;

import java.util.*;

class BinaryTreeTraverser$2 extends FluentIterable
{
    final /* synthetic */ Object val$root;
    final /* synthetic */ BinaryTreeTraverser this$0;
    
    BinaryTreeTraverser$2(final BinaryTreeTraverser this$0, final Object val$root) {
        this.this$0 = this$0;
        this.val$root = val$root;
    }
    
    @Override
    public UnmodifiableIterator iterator() {
        return new BinaryTreeTraverser$InOrderIterator(this.this$0, this.val$root);
    }
}
