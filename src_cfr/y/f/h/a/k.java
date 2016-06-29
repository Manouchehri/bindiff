/*
 * Decompiled with CFR 0_115.
 */
package y.f.h.a;

import java.util.Iterator;
import y.c.d;
import y.c.e;
import y.c.q;
import y.f.h.a.j;

class k
implements Iterator {
    e a;
    private final q b;
    private final j c;

    k(j j2, q q2) {
        this.c = j2;
        this.b = q2;
        this.a = this.b.j();
    }

    @Override
    public boolean hasNext() {
        return this.a.f();
    }

    public Object next() {
        d d2 = this.a.a();
        this.a.g();
        return d2;
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException("You cannot remove an element from a tree ordering!");
    }
}

