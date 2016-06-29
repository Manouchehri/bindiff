/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.collect.UnmodifiableListIterator;
import java.util.NoSuchElementException;

final class Iterators$1
extends UnmodifiableListIterator {
    Iterators$1() {
    }

    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public Object next() {
        throw new NoSuchElementException();
    }

    @Override
    public boolean hasPrevious() {
        return false;
    }

    public Object previous() {
        throw new NoSuchElementException();
    }

    @Override
    public int nextIndex() {
        return 0;
    }

    @Override
    public int previousIndex() {
        return -1;
    }
}

