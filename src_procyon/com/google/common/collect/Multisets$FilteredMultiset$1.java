package com.google.common.collect;

import com.google.common.base.*;

class Multisets$FilteredMultiset$1 implements Predicate
{
    final /* synthetic */ Multisets$FilteredMultiset this$0;
    
    Multisets$FilteredMultiset$1(final Multisets$FilteredMultiset this$0) {
        this.this$0 = this$0;
    }
    
    public boolean apply(final Multiset$Entry multiset$Entry) {
        return this.this$0.predicate.apply(multiset$Entry.getElement());
    }
}
