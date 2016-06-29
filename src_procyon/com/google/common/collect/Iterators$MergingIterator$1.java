package com.google.common.collect;

import java.util.*;

class Iterators$MergingIterator$1 implements Comparator
{
    final /* synthetic */ Comparator val$itemComparator;
    final /* synthetic */ Iterators$MergingIterator this$0;
    
    Iterators$MergingIterator$1(final Iterators$MergingIterator this$0, final Comparator val$itemComparator) {
        this.this$0 = this$0;
        this.val$itemComparator = val$itemComparator;
    }
    
    public int compare(final PeekingIterator peekingIterator, final PeekingIterator peekingIterator2) {
        return this.val$itemComparator.compare(peekingIterator.peek(), peekingIterator2.peek());
    }
}
