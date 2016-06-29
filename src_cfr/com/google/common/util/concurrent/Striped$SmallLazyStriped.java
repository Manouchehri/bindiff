/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.util.concurrent;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.base.Supplier;
import com.google.common.util.concurrent.Striped$PowerOfTwoStriped;
import com.google.common.util.concurrent.Striped$SmallLazyStriped$ArrayReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.concurrent.atomic.AtomicReferenceArray;

@VisibleForTesting
class Striped$SmallLazyStriped
extends Striped$PowerOfTwoStriped {
    final AtomicReferenceArray locks;
    final Supplier supplier;
    final int size;
    final ReferenceQueue queue = new ReferenceQueue();

    Striped$SmallLazyStriped(int n2, Supplier supplier) {
        super(n2);
        this.size = this.mask == -1 ? Integer.MAX_VALUE : this.mask + 1;
        this.locks = new AtomicReferenceArray(this.size);
        this.supplier = supplier;
    }

    @Override
    public Object getAt(int n2) {
        Object var3_3;
        Striped$SmallLazyStriped$ArrayReference striped$SmallLazyStriped$ArrayReference;
        if (this.size != Integer.MAX_VALUE) {
            Preconditions.checkElementIndex(n2, this.size());
        }
        Object v0 = var3_3 = (striped$SmallLazyStriped$ArrayReference = (Striped$SmallLazyStriped$ArrayReference)this.locks.get(n2)) == null ? null : striped$SmallLazyStriped$ArrayReference.get();
        if (var3_3 != null) {
            return var3_3;
        }
        Object object = this.supplier.get();
        Striped$SmallLazyStriped$ArrayReference striped$SmallLazyStriped$ArrayReference2 = new Striped$SmallLazyStriped$ArrayReference(object, n2, this.queue);
        do {
            if (!this.locks.compareAndSet(n2, striped$SmallLazyStriped$ArrayReference, striped$SmallLazyStriped$ArrayReference2)) continue;
            this.drainQueue();
            return object;
        } while ((var3_3 = (striped$SmallLazyStriped$ArrayReference = (Striped$SmallLazyStriped$ArrayReference)this.locks.get(n2)) == null ? null : striped$SmallLazyStriped$ArrayReference.get()) == null);
        return var3_3;
    }

    private void drainQueue() {
        Reference reference;
        while ((reference = this.queue.poll()) != null) {
            Striped$SmallLazyStriped$ArrayReference striped$SmallLazyStriped$ArrayReference = (Striped$SmallLazyStriped$ArrayReference)reference;
            this.locks.compareAndSet(striped$SmallLazyStriped$ArrayReference.index, striped$SmallLazyStriped$ArrayReference, null);
        }
    }

    @Override
    public int size() {
        return this.size;
    }
}

