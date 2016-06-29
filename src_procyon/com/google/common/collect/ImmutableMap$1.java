package com.google.common.collect;

import java.util.*;

class ImmutableMap$1 extends UnmodifiableIterator
{
    final /* synthetic */ UnmodifiableIterator val$entryIterator;
    final /* synthetic */ ImmutableMap this$0;
    
    ImmutableMap$1(final ImmutableMap this$0, final UnmodifiableIterator val$entryIterator) {
        this.this$0 = this$0;
        this.val$entryIterator = val$entryIterator;
    }
    
    @Override
    public boolean hasNext() {
        return this.val$entryIterator.hasNext();
    }
    
    @Override
    public Object next() {
        return this.val$entryIterator.next().getKey();
    }
}
