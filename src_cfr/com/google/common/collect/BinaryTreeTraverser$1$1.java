/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.base.Optional;
import com.google.common.collect.AbstractIterator;
import com.google.common.collect.BinaryTreeTraverser;
import com.google.common.collect.BinaryTreeTraverser$1;

class BinaryTreeTraverser$1$1
extends AbstractIterator {
    boolean doneLeft;
    boolean doneRight;
    final /* synthetic */ BinaryTreeTraverser$1 this$1;

    BinaryTreeTraverser$1$1(BinaryTreeTraverser$1 var1_1) {
        this.this$1 = var1_1;
    }

    @Override
    protected Object computeNext() {
        Optional optional;
        if (!this.doneLeft) {
            this.doneLeft = true;
            optional = this.this$1.this$0.leftChild(this.this$1.val$root);
            if (optional.isPresent()) {
                return optional.get();
            }
        }
        if (this.doneRight) return this.endOfData();
        this.doneRight = true;
        optional = this.this$1.this$0.rightChild(this.this$1.val$root);
        if (!optional.isPresent()) return this.endOfData();
        return optional.get();
    }
}

