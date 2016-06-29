package com.google.common.util.concurrent;

import com.google.common.annotations.*;
import java.util.concurrent.*;
import com.google.common.collect.*;
import com.google.common.base.*;

@VisibleForTesting
class Striped$LargeLazyStriped extends Striped$PowerOfTwoStriped
{
    final ConcurrentMap locks;
    final Supplier supplier;
    final int size;
    
    Striped$LargeLazyStriped(final int n, final Supplier supplier) {
        super(n);
        this.size = ((this.mask == -1) ? Integer.MAX_VALUE : (this.mask + 1));
        this.supplier = supplier;
        this.locks = new MapMaker().weakValues().makeMap();
    }
    
    @Override
    public Object getAt(final int n) {
        if (this.size != Integer.MAX_VALUE) {
            Preconditions.checkElementIndex(n, this.size());
        }
        final Object value = this.locks.get(n);
        if (value != null) {
            return value;
        }
        final Object value2 = this.supplier.get();
        return MoreObjects.firstNonNull(this.locks.putIfAbsent(n, value2), value2);
    }
    
    @Override
    public int size() {
        return this.size;
    }
}
