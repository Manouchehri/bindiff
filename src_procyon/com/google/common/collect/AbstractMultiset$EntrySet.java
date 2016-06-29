package com.google.common.collect;

import java.util.*;

class AbstractMultiset$EntrySet extends Multisets$EntrySet
{
    final /* synthetic */ AbstractMultiset this$0;
    
    AbstractMultiset$EntrySet(final AbstractMultiset this$0) {
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
        return this.this$0.distinctElements();
    }
}
