package com.google.common.collect;

import java.util.*;

class Sets$PowerSet$1 extends AbstractIndexedListIterator
{
    final /* synthetic */ Sets$PowerSet this$0;
    
    Sets$PowerSet$1(final Sets$PowerSet this$0, final int n) {
        this.this$0 = this$0;
        super(n);
    }
    
    @Override
    protected Set get(final int n) {
        return new Sets$SubSet(this.this$0.inputSet, n);
    }
}
