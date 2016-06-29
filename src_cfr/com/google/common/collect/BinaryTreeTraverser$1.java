/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.collect.BinaryTreeTraverser;
import com.google.common.collect.BinaryTreeTraverser$1$1;
import com.google.common.collect.FluentIterable;
import java.util.Iterator;

class BinaryTreeTraverser$1
extends FluentIterable {
    final /* synthetic */ Object val$root;
    final /* synthetic */ BinaryTreeTraverser this$0;

    BinaryTreeTraverser$1(BinaryTreeTraverser binaryTreeTraverser, Object object) {
        this.this$0 = binaryTreeTraverser;
        this.val$root = object;
    }

    public Iterator iterator() {
        return new BinaryTreeTraverser$1$1(this);
    }
}

