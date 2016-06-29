package com.google.common.collect;

import java.util.*;

class Multisets$3$1 extends AbstractIterator
{
    final /* synthetic */ Iterator val$iterator1;
    final /* synthetic */ Iterator val$iterator2;
    final /* synthetic */ Multisets$3 this$0;
    
    Multisets$3$1(final Multisets$3 this$0, final Iterator val$iterator1, final Iterator val$iterator2) {
        this.this$0 = this$0;
        this.val$iterator1 = val$iterator1;
        this.val$iterator2 = val$iterator2;
    }
    
    @Override
    protected Multiset$Entry computeNext() {
        if (this.val$iterator1.hasNext()) {
            final Multiset$Entry multiset$Entry = this.val$iterator1.next();
            final Object element = multiset$Entry.getElement();
            return Multisets.immutableEntry(element, multiset$Entry.getCount() + this.this$0.val$multiset2.count(element));
        }
        while (this.val$iterator2.hasNext()) {
            final Multiset$Entry multiset$Entry2 = this.val$iterator2.next();
            final Object element2 = multiset$Entry2.getElement();
            if (!this.this$0.val$multiset1.contains(element2)) {
                return Multisets.immutableEntry(element2, multiset$Entry2.getCount());
            }
        }
        return (Multiset$Entry)this.endOfData();
    }
}
