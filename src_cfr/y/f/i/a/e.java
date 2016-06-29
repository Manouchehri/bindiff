/*
 * Decompiled with CFR 0_115.
 */
package y.f.i.a;

import y.c.d;
import y.d.m;
import y.d.o;
import y.d.y;
import y.f.i.a.z;

class E
implements o {
    private final m a;
    private final d b;

    private E(d d2, m m2) {
        this.b = d2;
        this.a = m2;
    }

    @Override
    public y h() {
        return this.a.h();
    }

    E(d d2, m m2, z z2) {
        this(d2, m2);
    }

    static m a(E e2) {
        return e2.a;
    }

    static d b(E e2) {
        return e2.b;
    }
}

