/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.UnmodifiableListIterator;
import java.util.NoSuchElementException;

@GwtCompatible
abstract class AbstractIndexedListIterator
extends UnmodifiableListIterator {
    private final int size;
    private int position;

    protected abstract Object get(int var1);

    protected AbstractIndexedListIterator(int n2) {
        this(n2, 0);
    }

    protected AbstractIndexedListIterator(int n2, int n3) {
        Preconditions.checkPositionIndex(n3, n2);
        this.size = n2;
        this.position = n3;
    }

    @Override
    public final boolean hasNext() {
        if (this.position >= this.size) return false;
        return true;
    }

    @Override
    public final Object next() {
        if (this.hasNext()) return this.get(this.position++);
        throw new NoSuchElementException();
    }

    @Override
    public final int nextIndex() {
        return this.position;
    }

    @Override
    public final boolean hasPrevious() {
        if (this.position <= 0) return false;
        return true;
    }

    public final Object previous() {
        if (this.hasPrevious()) return this.get(--this.position);
        throw new NoSuchElementException();
    }

    @Override
    public final int previousIndex() {
        return this.position - 1;
    }
}

