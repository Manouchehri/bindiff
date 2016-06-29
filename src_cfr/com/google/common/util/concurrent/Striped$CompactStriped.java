/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.util.concurrent;

import com.google.common.base.Preconditions;
import com.google.common.base.Supplier;
import com.google.common.util.concurrent.Striped$1;
import com.google.common.util.concurrent.Striped$PowerOfTwoStriped;

class Striped$CompactStriped
extends Striped$PowerOfTwoStriped {
    private final Object[] array;

    private Striped$CompactStriped(int n2, Supplier supplier) {
        super(n2);
        Preconditions.checkArgument(n2 <= 1073741824, "Stripes must be <= 2^30)");
        this.array = new Object[this.mask + 1];
        int n3 = 0;
        while (n3 < this.array.length) {
            this.array[n3] = supplier.get();
            ++n3;
        }
    }

    @Override
    public Object getAt(int n2) {
        return this.array[n2];
    }

    @Override
    public int size() {
        return this.array.length;
    }

    /* synthetic */ Striped$CompactStriped(int n2, Supplier supplier, Striped$1 striped$1) {
        this(n2, supplier);
    }
}

