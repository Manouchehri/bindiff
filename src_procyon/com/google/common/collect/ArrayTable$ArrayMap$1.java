package com.google.common.collect;

import java.util.*;

class ArrayTable$ArrayMap$1 extends AbstractIndexedListIterator
{
    final /* synthetic */ ArrayTable$ArrayMap this$0;
    
    ArrayTable$ArrayMap$1(final ArrayTable$ArrayMap this$0, final int n) {
        this.this$0 = this$0;
        super(n);
    }
    
    @Override
    protected Map.Entry get(final int n) {
        return new ArrayTable$ArrayMap$1$1(this, n);
    }
}
