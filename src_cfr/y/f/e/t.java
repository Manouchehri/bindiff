/*
 * Decompiled with CFR 0_115.
 */
package y.f.e;

import y.c.A;
import y.c.d;
import y.f.e.q;
import y.g.p;

class t
extends p {
    private final A a;
    private final q b;

    t(q q2, A a2) {
        this.b = q2;
        this.a = a2;
    }

    @Override
    public boolean d(Object object) {
        if (!(object instanceof d)) return false;
        d d2 = (d)object;
        if (this.a.d(d2.c())) return false;
        return true;
    }
}

