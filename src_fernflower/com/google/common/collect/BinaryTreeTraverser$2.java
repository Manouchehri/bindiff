package com.google.common.collect;

import com.google.common.collect.BinaryTreeTraverser;
import com.google.common.collect.BinaryTreeTraverser$InOrderIterator;
import com.google.common.collect.FluentIterable;
import com.google.common.collect.UnmodifiableIterator;

class BinaryTreeTraverser$2 extends FluentIterable {
   // $FF: synthetic field
   final Object val$root;
   // $FF: synthetic field
   final BinaryTreeTraverser this$0;

   BinaryTreeTraverser$2(BinaryTreeTraverser var1, Object var2) {
      this.this$0 = var1;
      this.val$root = var2;
   }

   public UnmodifiableIterator iterator() {
      return new BinaryTreeTraverser$InOrderIterator(this.this$0, this.val$root);
   }
}
