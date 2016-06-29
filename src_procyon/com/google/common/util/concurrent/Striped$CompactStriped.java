package com.google.common.util.concurrent;

import com.google.common.base.*;

class Striped$CompactStriped extends Striped$PowerOfTwoStriped
{
    private final Object[] array;
    
    private Striped$CompactStriped(final int n, final Supplier supplier) {
        super(n);
        Preconditions.checkArgument(n <= 1073741824, (Object)"Stripes must be <= 2^30)");
        this.array = new Object[this.mask + 1];
        for (int i = 0; i < this.array.length; ++i) {
            this.array[i] = supplier.get();
        }
    }
    
    @Override
    public Object getAt(final int n) {
        return this.array[n];
    }
    
    @Override
    public int size() {
        return this.array.length;
    }
}
