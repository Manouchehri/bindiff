/*
 * Decompiled with CFR 0_115.
 */
package y.f.c.a;

import java.util.Iterator;
import java.util.NoSuchElementException;

final class dz
implements Iterator {
    private final Object[] a;
    private int b;

    dz(Object[] arrobject) {
        this.a = arrobject;
        this.b = 0;
    }

    @Override
    public boolean hasNext() {
        if (this.b >= this.a.length) return false;
        return true;
    }

    public Object next() {
        if (this.hasNext()) return this.a[this.b++];
        throw new NoSuchElementException();
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }
}

