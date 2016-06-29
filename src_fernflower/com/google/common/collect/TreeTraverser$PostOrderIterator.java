package com.google.common.collect;

import com.google.common.collect.AbstractIterator;
import com.google.common.collect.TreeTraverser;
import com.google.common.collect.TreeTraverser$PostOrderNode;
import java.util.ArrayDeque;

final class TreeTraverser$PostOrderIterator extends AbstractIterator {
   private final ArrayDeque stack;
   // $FF: synthetic field
   final TreeTraverser this$0;

   TreeTraverser$PostOrderIterator(TreeTraverser var1, Object var2) {
      this.this$0 = var1;
      this.stack = new ArrayDeque();
      this.stack.addLast(this.expand(var2));
   }

   protected Object computeNext() {
      while(true) {
         if(!this.stack.isEmpty()) {
            TreeTraverser$PostOrderNode var1 = (TreeTraverser$PostOrderNode)this.stack.getLast();
            if(var1.childIterator.hasNext()) {
               Object var2 = var1.childIterator.next();
               this.stack.addLast(this.expand(var2));
               continue;
            }

            this.stack.removeLast();
            return var1.root;
         }

         return this.endOfData();
      }
   }

   private TreeTraverser$PostOrderNode expand(Object var1) {
      return new TreeTraverser$PostOrderNode(var1, this.this$0.children(var1).iterator());
   }
}
