package com.google.common.collect;

import java.util.*;

class DescendingMultiset$1EntrySetImpl extends Multisets$EntrySet
{
    final /* synthetic */ DescendingMultiset this$0;
    
    DescendingMultiset$1EntrySetImpl(final DescendingMultiset this$0) {
        this.this$0 = this$0;
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
