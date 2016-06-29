package com.google.common.collect;

import com.google.common.base.*;

class BinaryTreeTraverser$1$1 extends AbstractIterator
{
    boolean doneLeft;
    boolean doneRight;
    final /* synthetic */ BinaryTreeTraverser$1 this$1;
    
    BinaryTreeTraverser$1$1(final BinaryTreeTraverser$1 this$1) {
        this.this$1 = this$1;
    }
    
    @Override
    protected Object computeNext() {
        if (!this.doneLeft) {
            this.doneLeft = true;
            final Optional leftChild = this.this$1.this$0.leftChild(this.this$1.val$root);
            if (leftChild.isPresent()) {
                return leftChild.get();
            }
        }
        if (!this.doneRight) {
            this.doneRight = true;
            final Optional rightChild = this.this$1.this$0.rightChild(this.this$1.val$root);
            if (rightChild.isPresent()) {
                return rightChild.get();
            }
        }
        return this.endOfData();
    }
}
