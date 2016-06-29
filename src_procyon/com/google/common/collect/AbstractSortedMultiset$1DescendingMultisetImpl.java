package com.google.common.collect;

import java.util.*;

class AbstractSortedMultiset$1DescendingMultisetImpl extends DescendingMultiset
{
    final /* synthetic */ AbstractSortedMultiset this$0;
    
    AbstractSortedMultiset$1DescendingMultisetImpl(final AbstractSortedMultiset this$0) {
        this.this$0 = this$0;
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
