package com.google.common.collect;

import java.util.*;

class StandardTable$Row$1 implements Iterator
{
    final /* synthetic */ Iterator val$iterator;
    final /* synthetic */ StandardTable$Row this$1;
    
    StandardTable$Row$1(final StandardTable$Row this$1, final Iterator val$iterator) {
        this.this$1 = this$1;
        this.val$iterator = val$iterator;
    }
    
    @Override
    public boolean hasNext() {
        return this.val$iterator.hasNext();
    }
    
    @Override
    public Map.Entry next() {
        return new StandardTable$Row$1$1(this, (Map.Entry)this.val$iterator.next());
    }
    
    @Override
    public void remove() {
        this.val$iterator.remove();
        this.this$1.maintainEmptyInvariant();
    }
}
