package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.collect.Iterators;
import com.google.common.collect.TreeTraverser;
import com.google.common.collect.UnmodifiableIterator;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

final class TreeTraverser$PreOrderIterator extends UnmodifiableIterator {
   private final Deque stack;
   // $FF: synthetic field
   final TreeTraverser this$0;

   TreeTraverser$PreOrderIterator(TreeTraverser var1, Object var2) {
      this.this$0 = var1;
      this.stack = new ArrayDeque();
      this.stack.addLast(Iterators.singletonIterator(Preconditions.checkNotNull(var2)));
   }

   public boolean hasNext() {
      return !this.stack.isEmpty();
   }

   public Object next() {
      Iterator var1 = (Iterator)this.stack.getLast();
      Object var2 = Preconditions.checkNotNull(var1.next());
      if(!var1.hasNext()) {
         this.stack.removeLast();
      }

      Iterator var3 = this.this$0.children(var2).iterator();
      if(var3.hasNext()) {
         this.stack.addLast(var3);
      }

      return var2;
   }
}
