/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.collect.Hashing;
import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterators;
import com.google.common.collect.ObjectArrays;
import com.google.common.collect.RegularImmutableAsList;
import com.google.common.collect.UnmodifiableIterator;
import java.util.Iterator;
import javax.annotation.Nullable;

@GwtCompatible(serializable=1, emulated=1)
final class RegularImmutableSet
extends ImmutableSet {
    static final RegularImmutableSet EMPTY = new RegularImmutableSet(ObjectArrays.EMPTY_ARRAY, 0, null, 0);
    private final transient Object[] elements;
    @VisibleForTesting
    final transient Object[] table;
    private final transient int mask;
    private final transient int hashCode;

    RegularImmutableSet(Object[] arrobject, int n2, Object[] arrobject2, int n3) {
        this.elements = arrobject;
        this.table = arrobject2;
        this.mask = n3;
        this.hashCode = n2;
    }

    @Override
    public boolean contains(@Nullable Object object) {
        Object[] arrobject = this.table;
        if (object == null) return false;
        if (arrobject == null) {
            return false;
        }
        int n2 = Hashing.smearedHash(object);
        Object object2;
        while ((object2 = arrobject[n2 &= this.mask]) != null) {
            if (object2.equals(object)) {
                return true;
            }
            ++n2;
        }
        return false;
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
    int copyIntoArray(Object[] arrobject, int n2) {
        System.arraycopy(this.elements, 0, arrobject, n2, this.elements.length);
        return n2 + this.elements.length;
    }

    @Override
    ImmutableList createAsList() {
        ImmutableList immutableList;
        if (this.table == null) {
            immutableList = ImmutableList.of();
            return immutableList;
        }
        immutableList = new RegularImmutableAsList((ImmutableCollection)this, this.elements);
        return immutableList;
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
}

