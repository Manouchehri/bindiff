package com.google.common.util.concurrent;

import com.google.common.annotations.*;
import java.util.concurrent.atomic.*;
import com.google.common.base.*;
import java.lang.ref.*;

@VisibleForTesting
class Striped$SmallLazyStriped extends Striped$PowerOfTwoStriped
{
    final AtomicReferenceArray locks;
    final Supplier supplier;
    final int size;
    final ReferenceQueue queue;
    
    Striped$SmallLazyStriped(final int n, final Supplier supplier) {
        super(n);
        this.queue = new ReferenceQueue();
        this.size = ((this.mask == -1) ? Integer.MAX_VALUE : (this.mask + 1));
        this.locks = new AtomicReferenceArray(this.size);
        this.supplier = supplier;
    }
    
    @Override
    public Object getAt(final int n) {
        if (this.size != Integer.MAX_VALUE) {
            Preconditions.checkElementIndex(n, this.size());
        }
        Striped$SmallLazyStriped$ArrayReference striped$SmallLazyStriped$ArrayReference = this.locks.get(n);
        final Object o = (striped$SmallLazyStriped$ArrayReference == null) ? null : striped$SmallLazyStriped$ArrayReference.get();
        if (o != null) {
            return o;
        }
        final Object value = this.supplier.get();
        while (!this.locks.compareAndSet(n, striped$SmallLazyStriped$ArrayReference, new Striped$SmallLazyStriped$ArrayReference(value, n, this.queue))) {
            striped$SmallLazyStriped$ArrayReference = this.locks.get(n);
            final Object o2 = (striped$SmallLazyStriped$ArrayReference == null) ? null : striped$SmallLazyStriped$ArrayReference.get();
            if (o2 != null) {
                return o2;
            }
        }
        this.drainQueue();
        return value;
    }
    
    private void drainQueue() {
        Reference poll;
        while ((poll = this.queue.poll()) != null) {
            final Striped$SmallLazyStriped$ArrayReference striped$SmallLazyStriped$ArrayReference = (Striped$SmallLazyStriped$ArrayReference)poll;
            this.locks.compareAndSet(striped$SmallLazyStriped$ArrayReference.index, striped$SmallLazyStriped$ArrayReference, null);
        }
    }
    
    @Override
    public int size() {
        return this.size;
    }
}
