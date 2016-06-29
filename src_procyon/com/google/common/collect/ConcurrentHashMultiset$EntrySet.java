package com.google.common.collect;

import java.util.*;

class ConcurrentHashMultiset$EntrySet extends AbstractMultiset$EntrySet
{
    final /* synthetic */ ConcurrentHashMultiset this$0;
    
    private ConcurrentHashMultiset$EntrySet(final ConcurrentHashMultiset this$0) {
        this.this$0 = this$0;
        super(this$0);
    }
    
    @Override
    ConcurrentHashMultiset multiset() {
        return this.this$0;
    }
    
    @Override
    public Object[] toArray() {
        return this.snapshot().toArray();
    }
    
    @Override
    public Object[] toArray(final Object[] array) {
        return this.snapshot().toArray(array);
    }
    
    private List snapshot() {
        final ArrayList arrayListWithExpectedSize = Lists.newArrayListWithExpectedSize(this.size());
        Iterators.addAll(arrayListWithExpectedSize, this.iterator());
        return arrayListWithExpectedSize;
    }
}
