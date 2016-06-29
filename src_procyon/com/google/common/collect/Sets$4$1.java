package com.google.common.collect;

import java.util.*;

class Sets$4$1 extends AbstractIterator
{
    final /* synthetic */ Iterator val$itr1;
    final /* synthetic */ Iterator val$itr2;
    final /* synthetic */ Sets$4 this$0;
    
    Sets$4$1(final Sets$4 this$0, final Iterator val$itr1, final Iterator val$itr2) {
        this.this$0 = this$0;
        this.val$itr1 = val$itr1;
        this.val$itr2 = val$itr2;
    }
    
    public Object computeNext() {
        while (this.val$itr1.hasNext()) {
            final Object next = this.val$itr1.next();
            if (!this.this$0.val$set2.contains(next)) {
                return next;
            }
        }
        while (this.val$itr2.hasNext()) {
            final Object next2 = this.val$itr2.next();
            if (!this.this$0.val$set1.contains(next2)) {
                return next2;
            }
        }
        return this.endOfData();
    }
}
