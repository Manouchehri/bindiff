package com.google.common.collect;

import java.util.*;

class Multimaps$Keys$1 extends TransformedIterator
{
    final /* synthetic */ Multimaps$Keys this$0;
    
    Multimaps$Keys$1(final Multimaps$Keys this$0, final Iterator iterator) {
        this.this$0 = this$0;
        super(iterator);
    }
    
    Multiset$Entry transform(final Map.Entry entry) {
        return new Multimaps$Keys$1$1(this, entry);
    }
}
