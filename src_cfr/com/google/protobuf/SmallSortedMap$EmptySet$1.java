/*
 * Decompiled with CFR 0_115.
 */
package com.google.protobuf;

import java.util.Iterator;
import java.util.NoSuchElementException;

final class SmallSortedMap$EmptySet$1
implements Iterator {
    SmallSortedMap$EmptySet$1() {
    }

    @Override
    public boolean hasNext() {
        return false;
    }

    public Object next() {
        throw new NoSuchElementException();
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }
}

