package com.google.common.collect;

import java.util.*;

final class Maps$2 extends ForwardingSet
{
    final /* synthetic */ Set val$set;
    
    Maps$2(final Set val$set) {
        this.val$set = val$set;
    }
    
    @Override
    protected Set delegate() {
        return this.val$set;
    }
    
    @Override
    public boolean add(final Object o) {
        throw new UnsupportedOperationException();
    }
    
    @Override
    public boolean addAll(final Collection collection) {
        throw new UnsupportedOperationException();
    }
}
