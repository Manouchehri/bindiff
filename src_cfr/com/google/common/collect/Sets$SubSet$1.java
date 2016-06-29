/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Sets$SubSet;
import com.google.common.collect.UnmodifiableIterator;
import java.util.NoSuchElementException;

class Sets$SubSet$1
extends UnmodifiableIterator {
    final ImmutableList elements;
    int remainingSetBits;
    final /* synthetic */ Sets$SubSet this$0;

    Sets$SubSet$1(Sets$SubSet sets$SubSet) {
        this.this$0 = sets$SubSet;
        this.elements = Sets$SubSet.access$100(this.this$0).keySet().asList();
        this.remainingSetBits = Sets$SubSet.access$200(this.this$0);
    }

    @Override
    public boolean hasNext() {
        if (this.remainingSetBits == 0) return false;
        return true;
    }

    public Object next() {
        int n2 = Integer.numberOfTrailingZeros(this.remainingSetBits);
        if (n2 == 32) {
            throw new NoSuchElementException();
        }
        this.remainingSetBits &= ~ (1 << n2);
        return this.elements.get(n2);
    }
}

