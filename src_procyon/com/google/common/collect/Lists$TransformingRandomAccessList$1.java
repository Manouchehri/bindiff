package com.google.common.collect;

import java.util.*;

class Lists$TransformingRandomAccessList$1 extends TransformedListIterator
{
    final /* synthetic */ Lists$TransformingRandomAccessList this$0;
    
    Lists$TransformingRandomAccessList$1(final Lists$TransformingRandomAccessList this$0, final ListIterator listIterator) {
        this.this$0 = this$0;
        super(listIterator);
    }
    
    @Override
    Object transform(final Object o) {
        return this.this$0.function.apply(o);
    }
}
