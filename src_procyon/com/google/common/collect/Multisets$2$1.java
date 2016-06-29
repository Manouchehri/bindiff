package com.google.common.collect;

import java.util.*;

class Multisets$2$1 extends AbstractIterator
{
    final /* synthetic */ Iterator val$iterator1;
    final /* synthetic */ Multisets$2 this$0;
    
    Multisets$2$1(final Multisets$2 this$0, final Iterator val$iterator1) {
        this.this$0 = this$0;
        this.val$iterator1 = val$iterator1;
    }
    
    @Override
    protected Multiset$Entry computeNext() {
        while (this.val$iterator1.hasNext()) {
            final Multiset$Entry multiset$Entry = this.val$iterator1.next();
            final Object element = multiset$Entry.getElement();
            final int min = Math.min(multiset$Entry.getCount(), this.this$0.val$multiset2.count(element));
            if (min > 0) {
                return Multisets.immutableEntry(element, min);
            }
        }
        return (Multiset$Entry)this.endOfData();
    }
}
