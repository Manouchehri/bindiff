package com.google.common.collect;

import com.google.common.base.Optional;
import com.google.common.collect.AbstractIterator;
import com.google.common.collect.BinaryTreeTraverser$1;

class BinaryTreeTraverser$1$1 extends AbstractIterator {
   boolean doneLeft;
   boolean doneRight;
   // $FF: synthetic field
   final BinaryTreeTraverser$1 this$1;

   BinaryTreeTraverser$1$1(BinaryTreeTraverser$1 var1) {
      this.this$1 = var1;
   }

   protected Object computeNext() {
      Optional var1;
      if(!this.doneLeft) {
         this.doneLeft = true;
         var1 = this.this$1.this$0.leftChild(this.this$1.val$root);
         if(var1.isPresent()) {
            return var1.get();
         }
      }

      if(!this.doneRight) {
         this.doneRight = true;
         var1 = this.this$1.this$0.rightChild(this.this$1.val$root);
         if(var1.isPresent()) {
            return var1.get();
         }
      }

      return this.endOfData();
   }
}
