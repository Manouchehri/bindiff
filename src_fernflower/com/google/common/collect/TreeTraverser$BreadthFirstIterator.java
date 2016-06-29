package com.google.common.collect;

import com.google.common.collect.Iterables;
import com.google.common.collect.PeekingIterator;
import com.google.common.collect.TreeTraverser;
import com.google.common.collect.UnmodifiableIterator;
import java.util.ArrayDeque;
import java.util.Queue;

final class TreeTraverser$BreadthFirstIterator extends UnmodifiableIterator implements PeekingIterator {
   private final Queue queue;
   // $FF: synthetic field
   final TreeTraverser this$0;

   TreeTraverser$BreadthFirstIterator(TreeTraverser var1, Object var2) {
      this.this$0 = var1;
      this.queue = new ArrayDeque();
      this.queue.add(var2);
   }

   public boolean hasNext() {
      return !this.queue.isEmpty();
   }

   public Object peek() {
      return this.queue.element();
   }

   public Object next() {
      Object var1 = this.queue.remove();
      Iterables.addAll(this.queue, this.this$0.children(var1));
      return var1;
   }
}
