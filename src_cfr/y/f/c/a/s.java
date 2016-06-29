/*
 * Decompiled with CFR 0_115.
 */
package y.f.c.a;

import y.c.A;
import y.c.c;
import y.f.c.a.N;
import y.g.p;

class S
extends p {
    private final A a;
    private final Object b;
    private final c d;
    private final N e;

    S(N n2, A a2, Object object, c c2) {
        this.e = n2;
        this.a = a2;
        this.b = object;
        this.d = c2;
    }

    @Override
    public Object b(Object object) {
        if (this.a.d(object)) {
            return this.b;
        }
        if (this.d.b(object) != null) return this.d.b(object);
        return this.b;
    }
}

