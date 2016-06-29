/*
 * Decompiled with CFR 0_115.
 */
package y.f.g;

import y.c.c;
import y.c.q;
import y.f.g.d;
import y.g.p;

class h
extends p {
    private final c a;
    private final c b;
    private final d d;

    h(d d2, c c2, c c3) {
        this.d = d2;
        this.a = c2;
        this.b = c3;
    }

    @Override
    public boolean d(Object object) {
        y.c.d d2 = (y.c.d)object;
        if (this.a != null) {
            if (this.a.d(d2.c())) return false;
            if (this.a.d(d2.d())) return false;
        }
        if (this.b == null) return true;
        if (this.b.d(d2)) return false;
        return true;
    }
}

