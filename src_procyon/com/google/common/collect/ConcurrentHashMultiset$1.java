package com.google.common.collect;

import javax.annotation.*;
import java.util.*;

class ConcurrentHashMultiset$1 extends ForwardingSet
{
    final /* synthetic */ Set val$delegate;
    final /* synthetic */ ConcurrentHashMultiset this$0;
    
    ConcurrentHashMultiset$1(final ConcurrentHashMultiset this$0, final Set val$delegate) {
        this.this$0 = this$0;
        this.val$delegate = val$delegate;
    }
    
    @Override
    protected Set delegate() {
        return this.val$delegate;
    }
    
    @Override
    public boolean contains(@Nullable final Object o) {
        return o != null && Collections2.safeContains(this.val$delegate, o);
    }
    
    @Override
    public boolean containsAll(final Collection collection) {
        return this.standardContainsAll(collection);
    }
    
    @Override
    public boolean remove(final Object o) {
        return o != null && Collections2.safeRemove(this.val$delegate, o);
    }
    
    @Override
    public boolean removeAll(final Collection collection) {
        return this.standardRemoveAll(collection);
    }
}
