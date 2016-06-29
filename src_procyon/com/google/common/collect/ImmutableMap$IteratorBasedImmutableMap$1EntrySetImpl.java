package com.google.common.collect;

import java.util.*;

class ImmutableMap$IteratorBasedImmutableMap$1EntrySetImpl extends ImmutableMapEntrySet
{
    final /* synthetic */ ImmutableMap$IteratorBasedImmutableMap this$0;
    
    ImmutableMap$IteratorBasedImmutableMap$1EntrySetImpl(final ImmutableMap$IteratorBasedImmutableMap this$0) {
        this.this$0 = this$0;
    }
    
    @Override
    ImmutableMap map() {
        return this.this$0;
    }
    
    @Override
    public UnmodifiableIterator iterator() {
        return this.this$0.entryIterator();
    }
}
