/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.collect.Iterators;
import com.google.common.collect.Iterators$MergingIterator;
import com.google.common.collect.PeekingIterator;
import java.util.Comparator;

class Iterators$MergingIterator$1
implements Comparator {
    final /* synthetic */ Comparator val$itemComparator;
    final /* synthetic */ Iterators.MergingIterator this$0;

    Iterators$MergingIterator$1(Iterators.MergingIterator mergingIterator, Comparator comparator) {
        this.this$0 = mergingIterator;
        this.val$itemComparator = comparator;
    }

    public int compare(PeekingIterator peekingIterator, PeekingIterator peekingIterator2) {
        return this.val$itemComparator.compare(peekingIterator.peek(), peekingIterator2.peek());
    }
}

