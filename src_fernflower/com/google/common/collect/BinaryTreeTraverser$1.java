package com.google.common.collect;

import com.google.common.collect.BinaryTreeTraverser;
import com.google.common.collect.BinaryTreeTraverser$1$1;
import com.google.common.collect.FluentIterable;
import java.util.Iterator;

class BinaryTreeTraverser$1 extends FluentIterable {
   // $FF: synthetic field
   final Object val$root;
   // $FF: synthetic field
   final BinaryTreeTraverser this$0;

   BinaryTreeTraverser$1(BinaryTreeTraverser var1, Object var2) {
      this.this$0 = var1;
      this.val$root = var2;
   }

   public Iterator iterator() {
      return new BinaryTreeTraverser$1$1(this);
   }
}
