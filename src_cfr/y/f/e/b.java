/*
 * Decompiled with CFR 0_115.
 */
package y.f.e;

import y.c.c;
import y.f.X;
import y.f.e.q;
import y.g.p;

class B
extends p {
    private c a;
    private c b;
    private X d;
    private final q e;

    B(q q2, X x2) {
        this.e = q2;
        this.d = x2;
        this.a = x2.c(q.o);
        this.b = x2.c(q.n);
    }

    @Override
    public boolean d(Object object) {
        y.c.q q2 = (y.c.q)object;
        if (q.a(this.e, q2, this.a, this.d)) return true;
        if (q.a(this.e, q2, this.a)) return true;
        if (this.b == null) return false;
        if (this.b.d(q2)) return false;
        return true;
    }
}

