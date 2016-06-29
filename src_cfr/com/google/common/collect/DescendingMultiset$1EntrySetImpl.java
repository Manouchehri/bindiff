/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.collect.DescendingMultiset;
import com.google.common.collect.Multiset;
import com.google.common.collect.Multisets$EntrySet;
import com.google.common.collect.SortedMultiset;
import java.util.Iterator;
import java.util.Set;

class DescendingMultiset$1EntrySetImpl
extends Multisets$EntrySet {
    final /* synthetic */ DescendingMultiset this$0;

    DescendingMultiset$1EntrySetImpl(DescendingMultiset descendingMultiset) {
        this.this$0 = descendingMultiset;
    }

    @Override
    Multiset multiset() {
        return this.this$0;
    }

    @Override
    public Iterator iterator() {
        return this.this$0.entryIterator();
    }

    @Override
    public int size() {
        return this.this$0.forwardMultiset().entrySet().size();
    }
}

