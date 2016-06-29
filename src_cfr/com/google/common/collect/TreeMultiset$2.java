/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.collect.CollectPreconditions;
import com.google.common.collect.Multiset$Entry;
import com.google.common.collect.TreeMultiset;
import com.google.common.collect.TreeMultiset$AvlNode;
import java.util.Iterator;
import java.util.NoSuchElementException;

class TreeMultiset$2
implements Iterator {
    TreeMultiset$AvlNode current;
    Multiset$Entry prevEntry;
    final /* synthetic */ TreeMultiset this$0;

    TreeMultiset$2(TreeMultiset treeMultiset) {
        this.this$0 = treeMultiset;
        this.current = TreeMultiset.access$1200(this.this$0);
    }

    @Override
    public boolean hasNext() {
        if (this.current == null) {
            return false;
        }
        if (!TreeMultiset.access$1300(this.this$0).tooHigh(this.current.getElement())) return true;
        this.current = null;
        return false;
    }

    public Multiset$Entry next() {
        Multiset$Entry multiset$Entry;
        if (!this.hasNext()) {
            throw new NoSuchElementException();
        }
        this.prevEntry = multiset$Entry = TreeMultiset.access$1400(this.this$0, this.current);
        if (TreeMultiset$AvlNode.access$900(this.current) == TreeMultiset.access$1500(this.this$0)) {
            this.current = null;
            return multiset$Entry;
        }
        this.current = TreeMultiset$AvlNode.access$900(this.current);
        return multiset$Entry;
    }

    @Override
    public void remove() {
        CollectPreconditions.checkRemove(this.prevEntry != null);
        this.this$0.setCount(this.prevEntry.getElement(), 0);
        this.prevEntry = null;
    }
}

