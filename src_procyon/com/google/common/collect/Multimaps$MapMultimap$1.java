package com.google.common.collect;

import java.util.*;

class Multimaps$MapMultimap$1 extends Sets$ImprovedAbstractSet
{
    final /* synthetic */ Object val$key;
    final /* synthetic */ Multimaps$MapMultimap this$0;
    
    Multimaps$MapMultimap$1(final Multimaps$MapMultimap this$0, final Object val$key) {
        this.this$0 = this$0;
        this.val$key = val$key;
    }
    
    @Override
    public Iterator iterator() {
        return new Multimaps$MapMultimap$1$1(this);
    }
    
    @Override
    public int size() {
        return this.this$0.map.containsKey(this.val$key) ? 1 : 0;
    }
}
