package com.google.common.collect;

import java.util.*;

class ConcurrentHashMultiset$3 extends ForwardingIterator
{
    private Multiset$Entry last;
    final /* synthetic */ Iterator val$readOnlyIterator;
    final /* synthetic */ ConcurrentHashMultiset this$0;
    
    ConcurrentHashMultiset$3(final ConcurrentHashMultiset this$0, final Iterator val$readOnlyIterator) {
        this.this$0 = this$0;
        this.val$readOnlyIterator = val$readOnlyIterator;
    }
    
    @Override
    protected Iterator delegate() {
        return this.val$readOnlyIterator;
    }
    
    @Override
    public Multiset$Entry next() {
        return this.last = (Multiset$Entry)super.next();
    }
    
    @Override
    public void remove() {
        CollectPreconditions.checkRemove(this.last != null);
        this.this$0.setCount(this.last.getElement(), 0);
        this.last = null;
    }
}
