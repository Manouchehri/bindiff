package com.google.common.collect;

import com.google.common.collect.BinaryTreeTraverser;
import com.google.common.collect.UnmodifiableIterator;
import java.util.ArrayDeque;
import java.util.BitSet;
import java.util.Deque;

final class BinaryTreeTraverser$PostOrderIterator extends UnmodifiableIterator {
   private final Deque stack;
   private final BitSet hasExpanded;
   // $FF: synthetic field
   final BinaryTreeTraverser this$0;

   BinaryTreeTraverser$PostOrderIterator(BinaryTreeTraverser var1, Object var2) {
      this.this$0 = var1;
      this.stack = new ArrayDeque();
      this.stack.addLast(var2);
      this.hasExpanded = new BitSet();
   }

   public boolean hasNext() {
      return !this.stack.isEmpty();
   }

   public Object next() {
      while(true) {
         Object var1 = this.stack.getLast();
         boolean var2 = this.hasExpanded.get(this.stack.size() - 1);
         if(var2) {
            this.stack.removeLast();
            this.hasExpanded.clear(this.stack.size());
            return var1;
         }

         this.hasExpanded.set(this.stack.size() - 1);
         BinaryTreeTraverser.access$000(this.stack, this.this$0.rightChild(var1));
         BinaryTreeTraverser.access$000(this.stack, this.this$0.leftChild(var1));
      }
   }
}
