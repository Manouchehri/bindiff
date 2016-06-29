/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.collect.BinaryTreeTraverser;
import com.google.common.collect.BinaryTreeTraverser$InOrderIterator;
import com.google.common.collect.FluentIterable;
import com.google.common.collect.UnmodifiableIterator;
import java.util.Iterator;

class BinaryTreeTraverser$2
extends FluentIterable {
    final /* synthetic */ Object val$root;
    final /* synthetic */ BinaryTreeTraverser this$0;

    BinaryTreeTraverser$2(BinaryTreeTraverser binaryTreeTraverser, Object object) {
        this.this$0 = binaryTreeTraverser;
        this.val$root = object;
    }

    public UnmodifiableIterator iterator() {
        return new BinaryTreeTraverser$InOrderIterator(this.this$0, this.val$root);
    }
}

