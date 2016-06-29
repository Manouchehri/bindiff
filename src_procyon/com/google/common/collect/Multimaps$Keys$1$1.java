package com.google.common.collect;

import java.util.*;

class Multimaps$Keys$1$1 extends Multisets$AbstractEntry
{
    final /* synthetic */ Map.Entry val$backingEntry;
    final /* synthetic */ Multimaps$Keys$1 this$1;
    
    Multimaps$Keys$1$1(final Multimaps$Keys$1 this$1, final Map.Entry val$backingEntry) {
        this.this$1 = this$1;
        this.val$backingEntry = val$backingEntry;
    }
    
    @Override
    public Object getElement() {
        return this.val$backingEntry.getKey();
    }
    
    @Override
    public int getCount() {
        return this.val$backingEntry.getValue().size();
    }
}
