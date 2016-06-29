package com.google.common.collect;

import java.util.*;

class ImmutableMap$MapViewOfValuesAsSingletonSets$1$1 extends AbstractMapEntry
{
    final /* synthetic */ Entry val$backingEntry;
    final /* synthetic */ ImmutableMap$MapViewOfValuesAsSingletonSets$1 this$2;
    
    ImmutableMap$MapViewOfValuesAsSingletonSets$1$1(final ImmutableMap$MapViewOfValuesAsSingletonSets$1 this$2, final Entry val$backingEntry) {
        this.this$2 = this$2;
        this.val$backingEntry = val$backingEntry;
    }
    
    @Override
    public Object getKey() {
        return this.val$backingEntry.getKey();
    }
    
    @Override
    public ImmutableSet getValue() {
        return ImmutableSet.of(this.val$backingEntry.getValue());
    }
}
