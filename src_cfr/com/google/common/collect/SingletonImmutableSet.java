/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterators;
import com.google.common.collect.UnmodifiableIterator;
import com.google.errorprone.annotations.concurrent.LazyInit;
import java.util.Iterator;

@GwtCompatible(serializable=1, emulated=1)
final class SingletonImmutableSet
extends ImmutableSet {
    final transient Object element;
    @LazyInit
    private transient int cachedHashCode;

    SingletonImmutableSet(Object object) {
        this.element = Preconditions.checkNotNull(object);
    }

    SingletonImmutableSet(Object object, int n2) {
        this.element = object;
        this.cachedHashCode = n2;
    }

    @Override
    public int size() {
        return 1;
    }

    @Override
    public boolean contains(Object object) {
        return this.element.equals(object);
    }

    @Override
    public UnmodifiableIterator iterator() {
        return Iterators.singletonIterator(this.element);
    }

    @Override
    boolean isPartialView() {
        return false;
    }

    @Override
    int copyIntoArray(Object[] arrobject, int n2) {
        arrobject[n2] = this.element;
        return n2 + 1;
    }

    @Override
    public final int hashCode() {
        int n2 = this.cachedHashCode;
        if (n2 != 0) return n2;
        this.cachedHashCode = n2 = this.element.hashCode();
        return n2;
    }

    @Override
    boolean isHashCodeFast() {
        if (this.cachedHashCode == 0) return false;
        return true;
    }

    @Override
    public String toString() {
        String string = this.element.toString();
        return new StringBuilder(string.length() + 2).append('[').append(string).append(']').toString();
    }
}

