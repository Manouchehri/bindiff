/*
 * Decompiled with CFR 0_115.
 */
package y.f.c.a;

import y.c.q;
import y.f.b.c;
import y.f.c.a.N;
import y.g.p;

class U
extends p {
    private final c a;
    private final N b;

    U(N n2, c c2) {
        this.b = n2;
        this.a = c2;
    }

    @Override
    public boolean d(Object object) {
        q q2 = (q)object;
        if (!this.a.d(q2)) return false;
        if (!this.a.e(q2)) return false;
        return true;
    }
}

