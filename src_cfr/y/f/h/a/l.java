/*
 * Decompiled with CFR 0_115.
 */
package y.f.h.a;

import java.util.Iterator;
import y.c.i;
import y.c.q;
import y.c.x;
import y.f.h.a.j;

class l
implements Iterator {
    x a;
    private final j b;

    l(j j2) {
        this.b = j2;
        this.a = this.b.b.o();
    }

    @Override
    public boolean hasNext() {
        return this.a.f();
    }

    public Object next() {
        q q2 = this.a.e();
        this.a.g();
        return q2;
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException("You cannot remove an element from a tree ordering!");
    }
}

