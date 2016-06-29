/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.util.concurrent;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.base.Supplier;
import com.google.common.collect.MapMaker;
import com.google.common.util.concurrent.Striped$PowerOfTwoStriped;
import java.util.concurrent.ConcurrentMap;

@VisibleForTesting
class Striped$LargeLazyStriped
extends Striped$PowerOfTwoStriped {
    final ConcurrentMap locks;
    final Supplier supplier;
    final int size;

    Striped$LargeLazyStriped(int n2, Supplier supplier) {
        super(n2);
        this.size = this.mask == -1 ? Integer.MAX_VALUE : this.mask + 1;
        this.supplier = supplier;
        this.locks = new MapMaker().weakValues().makeMap();
    }

    @Override
    public Object getAt(int n2) {
        Object object;
        if (this.size != Integer.MAX_VALUE) {
            Preconditions.checkElementIndex(n2, this.size());
        }
        if ((object = this.locks.get(n2)) != null) {
            return object;
        }
        Object object2 = this.supplier.get();
        object = this.locks.putIfAbsent(n2, object2);
        return MoreObjects.firstNonNull(object, object2);
    }

    @Override
    public int size() {
        return this.size;
    }
}

