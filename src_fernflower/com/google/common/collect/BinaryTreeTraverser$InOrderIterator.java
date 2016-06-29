package com.google.common.collect;

import com.google.common.collect.AbstractIterator;
import com.google.common.collect.BinaryTreeTraverser;
import java.util.ArrayDeque;
import java.util.BitSet;
import java.util.Deque;

final class BinaryTreeTraverser$InOrderIterator extends AbstractIterator {
   private final Deque stack;
   private final BitSet hasExpandedLeft;
   // $FF: synthetic field
   final BinaryTreeTraverser this$0;

   BinaryTreeTraverser$InOrderIterator(BinaryTreeTraverser var1, Object var2) {
      this.this$0 = var1;
      this.stack = new ArrayDeque();
      this.hasExpandedLeft = new BitSet();
      this.stack.addLast(var2);
   }

   protected Object computeNext() {
      while(!this.stack.isEmpty()) {
         Object var1 = this.stack.getLast();
         if(this.hasExpandedLeft.get(this.stack.size() - 1)) {
            this.stack.removeLast();
            this.hasExpandedLeft.clear(this.stack.size());
            BinaryTreeTraverser.access$000(this.stack, this.this$0.rightChild(var1));
            return var1;
         }

         this.hasExpandedLeft.set(this.stack.size() - 1);
         BinaryTreeTraverser.access$000(this.stack, this.this$0.leftChild(var1));
      }

      return this.endOfData();
   }
}
