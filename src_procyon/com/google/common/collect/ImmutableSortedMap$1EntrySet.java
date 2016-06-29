package com.google.common.collect;

import java.util.*;

class ImmutableSortedMap$1EntrySet extends ImmutableMapEntrySet
{
    final /* synthetic */ ImmutableSortedMap this$0;
    
    ImmutableSortedMap$1EntrySet(final ImmutableSortedMap this$0) {
        this.this$0 = this$0;
    }
    
    @Override
    public UnmodifiableIterator iterator() {
        return this.asList().iterator();
    }
    
    @Override
    ImmutableList createAsList() {
        return new ImmutableSortedMap$1EntrySet$1(this);
    }
    
    @Override
    ImmutableMap map() {
        return this.this$0;
    }
}
