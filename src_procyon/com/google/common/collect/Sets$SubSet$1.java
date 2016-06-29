package com.google.common.collect;

import java.util.*;
import javax.annotation.*;

class Sets$SubSet$1 extends UnmodifiableIterator
{
    final ImmutableList elements;
    int remainingSetBits;
    final /* synthetic */ Sets$SubSet this$0;
    
    Sets$SubSet$1(final Sets$SubSet this$0) {
        this.this$0 = this$0;
        this.elements = this.this$0.inputSet.keySet().asList();
        this.remainingSetBits = this.this$0.mask;
    }
    
    @Override
    public boolean hasNext() {
        return this.remainingSetBits != 0;
    }
    
    @Override
    public Object next() {
        final int numberOfTrailingZeros = Integer.numberOfTrailingZeros(this.remainingSetBits);
        if (numberOfTrailingZeros == 32) {
            throw new NoSuchElementException();
        }
        this.remainingSetBits &= ~(1 << numberOfTrailingZeros);
        return this.elements.get(numberOfTrailingZeros);
    }
}
