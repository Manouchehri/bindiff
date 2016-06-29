package com.google.common.collect;

import com.google.common.base.*;
import java.util.*;

abstract class ImmutableCollection$ArrayBasedBuilder extends ImmutableCollection$Builder
{
    Object[] contents;
    int size;
    
    ImmutableCollection$ArrayBasedBuilder(final int n) {
        CollectPreconditions.checkNonnegative(n, "initialCapacity");
        this.contents = new Object[n];
        this.size = 0;
    }
    
    private void ensureCapacity(final int n) {
        if (this.contents.length < n) {
            this.contents = ObjectArrays.arraysCopyOf(this.contents, ImmutableCollection$Builder.expandedCapacity(this.contents.length, n));
        }
    }
    
    @Override
    public ImmutableCollection$ArrayBasedBuilder add(final Object o) {
        Preconditions.checkNotNull(o);
        this.ensureCapacity(this.size + 1);
        this.contents[this.size++] = o;
        return this;
    }
    
    @Override
    public ImmutableCollection$Builder add(final Object... array) {
        ObjectArrays.checkElementsNotNull(array);
        this.ensureCapacity(this.size + array.length);
        System.arraycopy(array, 0, this.contents, this.size, array.length);
        this.size += array.length;
        return this;
    }
    
    @Override
    public ImmutableCollection$Builder addAll(final Iterable iterable) {
        if (iterable instanceof Collection) {
            this.ensureCapacity(this.size + ((Collection)iterable).size());
        }
        super.addAll(iterable);
        return this;
    }
}
