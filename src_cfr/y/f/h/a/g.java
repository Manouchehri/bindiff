/*
 * Decompiled with CFR 0_115.
 */
package y.f.h.a;

import java.util.Iterator;
import y.f.h.a.f;
import y.f.h.a.m;
import y.f.h.a.o;

class g
implements Iterator {
    o a;
    o b;
    private final f c;

    g(f f2) {
        this.c = f2;
        this.a = null;
        this.b = f.e(this.c);
    }

    @Override
    public boolean hasNext() {
        if (this.b.a(this.a) == f.f(this.c)) return false;
        return true;
    }

    public Object next() {
        o o2 = this.b;
        this.b = this.b.a(this.a);
        this.a = o2;
        return this.b.a();
    }

    @Override
    public void remove() {
        o o2 = this.a;
        this.a = this.a.a(this.b);
        this.b = o2;
        this.b.a(this.a).b();
    }
}

