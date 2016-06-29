package com.google.common.util.concurrent;

import com.google.common.base.*;

abstract class Striped$PowerOfTwoStriped extends Striped
{
    final int mask;
    
    Striped$PowerOfTwoStriped(final int n) {
        super(null);
        Preconditions.checkArgument(n > 0, (Object)"Stripes must be positive");
        this.mask = ((n > 1073741824) ? -1 : (Striped.access$200(n) - 1));
    }
    
    @Override
    final int indexFor(final Object o) {
        return Striped.access$300(o.hashCode()) & this.mask;
    }
    
    @Override
    public final Object get(final Object o) {
        return this.getAt(this.indexFor(o));
    }
}
