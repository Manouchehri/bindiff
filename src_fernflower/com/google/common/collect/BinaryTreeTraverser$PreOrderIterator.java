package com.google.common.collect;

import com.google.common.collect.BinaryTreeTraverser;
import com.google.common.collect.PeekingIterator;
import com.google.common.collect.UnmodifiableIterator;
import java.util.ArrayDeque;
import java.util.Deque;

final class BinaryTreeTraverser$PreOrderIterator extends UnmodifiableIterator implements PeekingIterator {
   private final Deque stack;
   // $FF: synthetic field
   final BinaryTreeTraverser this$0;

   BinaryTreeTraverser$PreOrderIterator(BinaryTreeTraverser var1, Object var2) {
      this.this$0 = var1;
      this.stack = new ArrayDeque();
      this.stack.addLast(var2);
   }

   public boolean hasNext() {
      return !this.stack.isEmpty();
   }

   public Object next() {
      Object var1 = this.stack.removeLast();
      BinaryTreeTraverser.access$000(this.stack, this.this$0.rightChild(var1));
      BinaryTreeTraverser.access$000(this.stack, this.this$0.leftChild(var1));
      return var1;
   }

   public Object peek() {
      return this.stack.getLast();
   }
}
