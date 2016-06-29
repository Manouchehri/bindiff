/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.collect.Multisets$AbstractEntry;
import com.google.common.collect.TreeMultiset;
import com.google.common.collect.TreeMultiset$AvlNode;

class TreeMultiset$1
extends Multisets$AbstractEntry {
    final /* synthetic */ TreeMultiset$AvlNode val$baseEntry;
    final /* synthetic */ TreeMultiset this$0;

    TreeMultiset$1(TreeMultiset treeMultiset, TreeMultiset$AvlNode avlNode) {
        this.this$0 = treeMultiset;
        this.val$baseEntry = avlNode;
    }

    @Override
    public Object getElement() {
        return this.val$baseEntry.getElement();
    }

    @Override
    public int getCount() {
        int n2 = this.val$baseEntry.getCount();
        if (n2 != 0) return n2;
        return this.this$0.count(this.getElement());
    }
}

