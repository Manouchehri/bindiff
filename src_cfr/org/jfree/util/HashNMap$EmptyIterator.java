/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.util;

import java.util.Iterator;
import java.util.NoSuchElementException;
import org.jfree.util.HashNMap$1;

final class HashNMap$EmptyIterator
implements Iterator {
    private HashNMap$EmptyIterator() {
    }

    @Override
    public boolean hasNext() {
        return false;
    }

    public Object next() {
        throw new NoSuchElementException("This iterator is empty.");
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException("This iterator is empty, no remove supported.");
    }

    HashNMap$EmptyIterator(HashNMap$1 hashNMap$1) {
        this();
    }
}

