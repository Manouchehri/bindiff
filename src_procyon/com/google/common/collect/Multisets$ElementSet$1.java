package com.google.common.collect;

import java.util.*;

class Multisets$ElementSet$1 extends TransformedIterator
{
    final /* synthetic */ Multisets$ElementSet this$0;
    
    Multisets$ElementSet$1(final Multisets$ElementSet this$0, final Iterator iterator) {
        this.this$0 = this$0;
        super(iterator);
    }
    
    Object transform(final Multiset$Entry multiset$Entry) {
        return multiset$Entry.getElement();
    }
}
