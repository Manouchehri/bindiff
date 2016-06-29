package com.google.common.collect;

import com.google.common.base.*;
import java.util.concurrent.atomic.*;

class Ordering$ArbitraryOrdering$1 implements Function
{
    final AtomicInteger counter;
    final /* synthetic */ Ordering$ArbitraryOrdering this$0;
    
    Ordering$ArbitraryOrdering$1(final Ordering$ArbitraryOrdering this$0) {
        this.this$0 = this$0;
        this.counter = new AtomicInteger(0);
    }
    
    @Override
    public Integer apply(final Object o) {
        return this.counter.getAndIncrement();
    }
}
