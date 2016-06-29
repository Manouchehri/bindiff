package com.google.common.collect;

import com.google.common.annotations.*;
import javax.annotation.*;
import java.util.*;

@GwtCompatible(serializable = true, emulated = true)
final class RegularImmutableSet extends ImmutableSet
{
    static final RegularImmutableSet EMPTY;
    private final transient Object[] elements;
    @VisibleForTesting
    final transient Object[] table;
    private final transient int mask;
    private final transient int hashCode;
    
    RegularImmutableSet(final Object[] elements, final int hashCode, final Object[] table, final int mask) {
        this.elements = elements;
        this.table = table;
        this.mask = mask;
        this.hashCode = hashCode;
    }
    
    @Override
    public boolean contains(@Nullable final Object o) {
        final Object[] table = this.table;
        if (o == null || table == null) {
            return false;
        }
        int smearedHash = Hashing.smearedHash(o);
        while (true) {
            smearedHash &= this.mask;
            final Object o2 = table[smearedHash];
            if (o2 == null) {
                return false;
            }
            if (o2.equals(o)) {
                return true;
            }
            ++smearedHash;
        }
    }
    
    @Override
    public int size() {
        return this.elements.length;
    }
    
    @Override
    public UnmodifiableIterator iterator() {
        return Iterators.forArray(this.elements);
    }
    
    @Override
    int copyIntoArray(final Object[] array, final int n) {
        System.arraycopy(this.elements, 0, array, n, this.elements.length);
        return n + this.elements.length;
    }
    
    @Override
    ImmutableList createAsList() {
        return (this.table == null) ? ImmutableList.of() : new RegularImmutableAsList(this, this.elements);
    }
    
    @Override
    boolean isPartialView() {
        return false;
    }
    
    @Override
    public int hashCode() {
        return this.hashCode;
    }
    
    @Override
    boolean isHashCodeFast() {
        return true;
    }
    
    static {
        EMPTY = new RegularImmutableSet(ObjectArrays.EMPTY_ARRAY, 0, null, 0);
    }
}
