package com.google.common.collect;

import java.util.*;

class ImmutableMap$MapViewOfValuesAsSingletonSets$1 extends UnmodifiableIterator
{
    final /* synthetic */ Iterator val$backingIterator;
    final /* synthetic */ ImmutableMap$MapViewOfValuesAsSingletonSets this$1;
    
    ImmutableMap$MapViewOfValuesAsSingletonSets$1(final ImmutableMap$MapViewOfValuesAsSingletonSets this$1, final Iterator val$backingIterator) {
        this.this$1 = this$1;
        this.val$backingIterator = val$backingIterator;
    }
    
    @Override
    public boolean hasNext() {
        return this.val$backingIterator.hasNext();
    }
    
    @Override
    public Map.Entry next() {
        return new ImmutableMap$MapViewOfValuesAsSingletonSets$1$1(this, (Map.Entry)this.val$backingIterator.next());
    }
}
