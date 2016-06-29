/*
 * Decompiled with CFR 0_115.
 */
package y.f.h.a;

import java.util.Iterator;
import y.f.h.a.h;
import y.f.h.a.i;
import y.f.h.a.p;

class q
implements Iterator {
    h a;
    private final p b;

    q(p p2) {
        this.b = p2;
        this.a = this.b.a;
    }

    @Override
    public boolean hasNext() {
        if (this.a.b == this.b.a) return false;
        return true;
    }

    public Object next() {
        this.a = this.a.b;
        return this.a.a();
    }

    @Override
    public void remove() {
        h h2 = this.a.c;
        this.a.b();
        this.a = h2;
    }
}

