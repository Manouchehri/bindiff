/*
 * Decompiled with CFR 0_115.
 */
package y.f.c.a;

import java.util.Iterator;
import java.util.NoSuchElementException;
import y.c.y;
import y.f.c.a.aQ;
import y.f.c.a.aU;

final class dB
implements Iterator {
    private final aU a;
    private int b;

    dB(aU aU2) {
        this.a = aU2;
        this.b = 0;
    }

    @Override
    public boolean hasNext() {
        if (this.b >= this.a.b()) return false;
        return true;
    }

    public Object next() {
        if (this.hasNext()) return this.a.a(this.b++).d();
        throw new NoSuchElementException();
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }
}

