/*
 * Decompiled with CFR 0_115.
 */
package y.f.c.a;

import y.c.A;
import y.c.c;
import y.f.c.a.N;
import y.g.p;

class O
extends p {
    private final c a;
    private final A b;
    private final N d;

    O(N n2, c c2, A a2) {
        this.d = n2;
        this.a = c2;
        this.b = a2;
    }

    @Override
    public Object b(Object object) {
        if (this.a == null) return this.b.b(object);
        if (this.a.b(object) == null) return this.b.b(object);
        return this.a.b(object);
    }
}

