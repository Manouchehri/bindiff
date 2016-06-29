/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.util;

import java.util.Iterator;

public class ReadOnlyIterator
implements Iterator {
    private Iterator base;

    public ReadOnlyIterator(Iterator iterator) {
        if (iterator == null) {
            throw new NullPointerException("Base iterator is null.");
        }
        this.base = iterator;
    }

    @Override
    public boolean hasNext() {
        return this.base.hasNext();
    }

    public Object next() {
        return this.base.next();
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }
}

