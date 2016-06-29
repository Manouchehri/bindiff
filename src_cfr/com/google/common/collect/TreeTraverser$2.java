/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.collect.FluentIterable;
import com.google.common.collect.TreeTraverser;
import com.google.common.collect.UnmodifiableIterator;
import java.util.Iterator;

class TreeTraverser$2
extends FluentIterable {
    final /* synthetic */ Object val$root;
    final /* synthetic */ TreeTraverser this$0;

    TreeTraverser$2(TreeTraverser treeTraverser, Object object) {
        this.this$0 = treeTraverser;
        this.val$root = object;
    }

    public UnmodifiableIterator iterator() {
        return this.this$0.postOrderIterator(this.val$root);
    }
}

