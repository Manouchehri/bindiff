/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.base.Function;
import com.google.common.collect.Ordering;
import com.google.common.collect.Ordering$ArbitraryOrdering;
import java.util.concurrent.atomic.AtomicInteger;

class Ordering$ArbitraryOrdering$1
implements Function {
    final AtomicInteger counter;
    final /* synthetic */ Ordering.ArbitraryOrdering this$0;

    Ordering$ArbitraryOrdering$1(Ordering.ArbitraryOrdering arbitraryOrdering) {
        this.this$0 = arbitraryOrdering;
        this.counter = new AtomicInteger(0);
    }

    @Override
    public Integer apply(Object object) {
        return this.counter.getAndIncrement();
    }
}

