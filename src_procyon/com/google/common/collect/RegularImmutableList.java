package com.google.common.collect;

import com.google.common.annotations.*;
import com.google.common.base.*;
import java.util.*;

@GwtCompatible(serializable = true, emulated = true)
class RegularImmutableList extends ImmutableList
{
    static final ImmutableList EMPTY;
    private final transient int offset;
    private final transient int size;
    private final transient Object[] array;
    
    RegularImmutableList(final Object[] array, final int offset, final int size) {
        this.offset = offset;
        this.size = size;
        this.array = array;
    }
    
    RegularImmutableList(final Object[] array) {
        this(array, 0, array.length);
    }
    
    @Override
    public int size() {
        return this.size;
    }
    
    @Override
    boolean isPartialView() {
        return this.size != this.array.length;
    }
    
    @Override
    int copyIntoArray(final Object[] array, final int n) {
        System.arraycopy(this.array, this.offset, array, n, this.size);
        return n + this.size;
    }
    
    @Override
    public Object get(final int n) {
        Preconditions.checkElementIndex(n, this.size);
        return this.array[n + this.offset];
    }
    
    @Override
    ImmutableList subListUnchecked(final int n, final int n2) {
        return new RegularImmutableList(this.array, this.offset + n, n2 - n);
    }
    
    @Override
    public UnmodifiableListIterator listIterator(final int n) {
        return Iterators.forArray(this.array, this.offset, this.size, n);
    }
    
    static {
        EMPTY = new RegularImmutableList(ObjectArrays.EMPTY_ARRAY);
    }
}
