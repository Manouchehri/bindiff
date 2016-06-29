/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterators;
import com.google.common.collect.ObjectArrays;
import com.google.common.collect.UnmodifiableListIterator;
import java.util.ListIterator;

@GwtCompatible(serializable=1, emulated=1)
class RegularImmutableList
extends ImmutableList {
    static final ImmutableList EMPTY = new RegularImmutableList(ObjectArrays.EMPTY_ARRAY);
    private final transient int offset;
    private final transient int size;
    private final transient Object[] array;

    RegularImmutableList(Object[] arrobject, int n2, int n3) {
        this.offset = n2;
        this.size = n3;
        this.array = arrobject;
    }

    RegularImmutableList(Object[] arrobject) {
        this(arrobject, 0, arrobject.length);
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    boolean isPartialView() {
        if (this.size == this.array.length) return false;
        return true;
    }

    @Override
    int copyIntoArray(Object[] arrobject, int n2) {
        System.arraycopy(this.array, this.offset, arrobject, n2, this.size);
        return n2 + this.size;
    }

    public Object get(int n2) {
        Preconditions.checkElementIndex(n2, this.size);
        return this.array[n2 + this.offset];
    }

    @Override
    ImmutableList subListUnchecked(int n2, int n3) {
        return new RegularImmutableList(this.array, this.offset + n2, n3 - n2);
    }

    @Override
    public UnmodifiableListIterator listIterator(int n2) {
        return Iterators.forArray(this.array, this.offset, this.size, n2);
    }
}

