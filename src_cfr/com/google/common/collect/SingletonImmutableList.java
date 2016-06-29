/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterators;
import com.google.common.collect.UnmodifiableIterator;
import java.util.Iterator;
import java.util.List;

@GwtCompatible(serializable=1, emulated=1)
final class SingletonImmutableList
extends ImmutableList {
    final transient Object element;

    SingletonImmutableList(Object object) {
        this.element = Preconditions.checkNotNull(object);
    }

    public Object get(int n2) {
        Preconditions.checkElementIndex(n2, 1);
        return this.element;
    }

    @Override
    public UnmodifiableIterator iterator() {
        return Iterators.singletonIterator(this.element);
    }

    @Override
    public int size() {
        return 1;
    }

    @Override
    public ImmutableList subList(int n2, int n3) {
        ImmutableList immutableList;
        Preconditions.checkPositionIndexes(n2, n3, 1);
        if (n2 == n3) {
            immutableList = ImmutableList.of();
            return immutableList;
        }
        immutableList = this;
        return immutableList;
    }

    @Override
    public String toString() {
        String string = this.element.toString();
        return new StringBuilder(string.length() + 2).append('[').append(string).append(']').toString();
    }

    @Override
    boolean isPartialView() {
        return false;
    }
}

