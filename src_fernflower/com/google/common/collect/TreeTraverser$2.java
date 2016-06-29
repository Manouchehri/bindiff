package com.google.common.collect;

import com.google.common.collect.FluentIterable;
import com.google.common.collect.TreeTraverser;
import com.google.common.collect.UnmodifiableIterator;

class TreeTraverser$2 extends FluentIterable {
   // $FF: synthetic field
   final Object val$root;
   // $FF: synthetic field
   final TreeTraverser this$0;

   TreeTraverser$2(TreeTraverser var1, Object var2) {
      this.this$0 = var1;
      this.val$root = var2;
   }

   public UnmodifiableIterator iterator() {
      return this.this$0.postOrderIterator(this.val$root);
   }
}
