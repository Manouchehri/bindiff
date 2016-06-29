/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.collect.AbstractSortedMultiset;
import com.google.common.collect.DescendingMultiset;
import com.google.common.collect.SortedMultiset;
import java.util.Iterator;

class AbstractSortedMultiset$1DescendingMultisetImpl
extends DescendingMultiset {
    final /* synthetic */ AbstractSortedMultiset this$0;

    AbstractSortedMultiset$1DescendingMultisetImpl(AbstractSortedMultiset abstractSortedMultiset) {
        this.this$0 = abstractSortedMultiset;
    }

    @Override
    SortedMultiset forwardMultiset() {
        return this.this$0;
    }

    @Override
    Iterator entryIterator() {
        return this.this$0.descendingEntryIterator();
    }

    @Override
    public Iterator iterator() {
        return this.this$0.descendingIterator();
    }
}

